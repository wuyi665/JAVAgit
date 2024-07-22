import pandas as pd
import numpy as np
import torch
import torch.nn as nn
import torch.optim as optim
import torch.nn.functional as F
from torch.utils.data import DataLoader, TensorDataset
from sklearn.model_selection import train_test_split
from sklearn.metrics import confusion_matrix, classification_report
from torch.optim.lr_scheduler import ReduceLROnPlateau
import matplotlib.pyplot as plt

# 设置图形的中文显示
plt.rcParams['font.sans-serif'] = ['SimHei']
plt.rcParams['axes.unicode_minus'] = False

# 读取数据集
#data = pd.read_csv("D:/srdp/所用数据集/新建文件夹/zt_corr_continue_7.csv")
data = pd.read_csv("D:\srdp\所用数据集\ys\ys-7-3.csv")
#data2 = pd.read_csv("D:/srdp/所用数据集/zt/zt最终版数据集前7.csv")
# 按列组合数据集
#data= pd.concat([data1, data2],  axis=0, ignore_index=True)
num = len(data)
print('the length of data is', num)

# 定义条件和对应的值
conditions = [
    (data['level'] >= 3) & (data['level'] < 5),
    (data['level'] >= 5)
]
values = [1, 2]

# 使用 np.select 方法赋值
data['level'] = np.select(conditions, values)
data.replace({"region": {5.0: 1, 6.0: 2, 7.0: 3, 8.0: 4}}, inplace=True)
l=7
input_dim2 = int(1440*l/30-1)     
input_dim3 = 24
input_dim1 = int(len(data)/input_dim2)
# 输入输出
X = data.iloc[:, :24].values  # 输入特征
y1 = round(data.iloc[:, 26]).values  # 输出标签1
y2 = round(data.iloc[:, 25]).values  # 输出标签2

# 将数据转换为3D张量
X = X.reshape((input_dim1, input_dim2, input_dim3), order='C')
# 转换标签数据
y1 = y1.reshape((input_dim1, input_dim2))
y1 = y1[:, 0]  # 取每个样本的最后一个元素作为样本的标签
y2 = y2.reshape((input_dim1, input_dim2))
y2 = y2[:, 0]  # 取每个样本的最后一个元素作为样本的标签

# 将标签进行one-hot编码
y1 = torch.nn.functional.one_hot(torch.tensor(y1, dtype=torch.long), 3).float().numpy()
y2 = torch.nn.functional.one_hot(torch.tensor(y2, dtype=torch.long), 5).float().numpy()

# 使用 train_test_split 函数来随机划分训练集和测试集
X_train, X_test, y1_train, y1_test, y2_train, y2_test = train_test_split(X, y1, y2, test_size=0.15, random_state=42)
X_train, X_val, y1_train, y1_val, y2_train, y2_val = train_test_split(X_train, y1_train, y2_train, test_size=0.15, random_state=42)

# 定义一个函数，用来查看一个数据集的类别分布
def show_dist(y):
    # 将y转换为一维数组
    y_classes = np.argmax(y, axis=1)
    # 调用np.unique函数，返回数组中唯一元素的排序列表和它们的出现次数
    unique_elements, counts_elements = np.unique(y_classes, return_counts=True)
    # 打印结果
    print("类别：", unique_elements)
    print("频数：", counts_elements)

# 调用函数，查看y1_train, y1_test, y1_val, y2_train, y2_test, y2_val的类别分布
show_dist(y1_train)
show_dist(y1_val)
show_dist(y1_test)

show_dist(y2_train)
show_dist(y2_val)
show_dist(y2_test)

# 转换数据为 PyTorch Tensor
X_train_tensor = torch.tensor(X_train, dtype=torch.float32)
y1_train_tensor = torch.tensor(np.argmax(y1_train, axis=1), dtype=torch.long)
y2_train_tensor = torch.tensor(np.argmax(y2_train, axis=1), dtype=torch.long)

X_val_tensor = torch.tensor(X_val, dtype=torch.float32)
y1_val_tensor = torch.tensor(np.argmax(y1_val, axis=1), dtype=torch.long)
y2_val_tensor = torch.tensor(np.argmax(y2_val, axis=1), dtype=torch.long)

X_test_tensor = torch.tensor(X_test, dtype=torch.float32)
y1_test_tensor = torch.tensor(np.argmax(y1_test, axis=1), dtype=torch.long)
y2_test_tensor = torch.tensor(np.argmax(y2_test, axis=1), dtype=torch.long)

# 创建 DataLoader
train_dataset = TensorDataset(X_train_tensor, y1_train_tensor, y2_train_tensor)
train_loader = DataLoader(train_dataset, batch_size=32, shuffle=True)
test_dataset = TensorDataset(X_test_tensor, y1_test_tensor, y2_test_tensor)
test_loader = DataLoader(test_dataset, batch_size=32, shuffle=False)
val_dataset = TensorDataset(X_val_tensor, y1_val_tensor, y2_val_tensor)
val_loader = DataLoader(val_dataset, batch_size=32, shuffle=False)
# 模型定义
class CNN(nn.Module):
    def __init__(self):
        super(CNN, self).__init__()
        # 第一个卷积层
        self.conv1 = nn.Conv1d(in_channels=24, out_channels=64, kernel_size=6, stride=1, padding=0)
        # 批量归一化
        self.bn1 = nn.BatchNorm1d(64)
        # 池化层
        self.pool1 = nn.MaxPool1d(kernel_size=2, stride=2)
        #第二个卷积层
        self.conv2 = nn.Conv1d(in_channels=64, out_channels=64, kernel_size=10, stride=1, padding=0)
        # 批量归一化
        self.bn2 = nn.BatchNorm1d(64)
        # 池化层
        self.pool2 = nn.MaxPool1d(kernel_size=3, stride=3)
        # 全局平均池化层
        self.global_avg_pool = nn.AdaptiveAvgPool1d(1)

        # 全连接层1
        self.fc1= nn.Linear(64, 32)
        self.dropout1 = nn.Dropout(p=0)
        # 全连接层2
        self.fc2= nn.Linear(32, 16)
        self.dropout2 = nn.Dropout(p=0.1)
        # 激活函数
        self.relu = nn.ReLU()
        # 第一个输出层（三类）
        self.fc_output1 = nn.Linear(16, 3)
        # 第二个输出层（五类）
        self.fc_output2 = nn.Linear(16, 5)

    def forward(self, x):
        x=x.transpose(1,2)
        # 输入数据经过第一个卷积层、激活函数、池化
        x = self.pool1(self.bn1(self.relu(self.conv1(x))))
        # 输入数据经过第二个卷积层、激活函数、池化
        x = self.pool2(self.bn2(self.relu(self.conv2(x))))
        # 全局平均池化
        x = self.global_avg_pool(x) 

        # 将维度展平
        x = torch.flatten(x, start_dim=1)
        # 全连接层1
        x = self.relu(self.fc1(x))
        x = self.dropout1(x)
        # 全连接层2
        x = self.relu(self.fc2(x))
        x = self.dropout2(x)

        # 输出层
        output1 = F.softmax(self.fc_output1(x), dim=1)
        output2 = F.softmax(self.fc_output2(x), dim=1)

        return output1, output2

# 创建模型实例
model = CNN()
# 损失函数定义
criterion = nn.CrossEntropyLoss() 
# 优化器
optimizer = optim.Adam([
{'params': model.conv1.parameters(), 'weight_decay': 0.01},
{'params': model.conv2.parameters(), 'weight_decay': 0.01},
{'params': model.fc1.parameters(), 'weight_decay': 0.0001},
], lr=0.0001)
reduce_lr = ReduceLROnPlateau(optimizer, mode='min', factor=0.1, patience=10, verbose=True, min_lr=1e-8)



#模型训练函数
def training(model,criterion,optimizer,reduce_lr,train_loader,val_loader):

    #模型训练
    model.train()
    train_running_loss1=0
    train_running_loss2=0
    total_samples = 0

    for data in train_loader:
        # 区分输入，输出标签1，输出标签2
        train_inputs, train_y1, train_y2 = data

        # 前向传播
        train_output1, train_output2 = model(train_inputs)

        # 计算损失
        train_loss1 = criterion(train_output1, train_y1)
        train_loss2 = criterion(train_output2, train_y2)
        train_loss = train_loss1 * 0.5 + train_loss2 * 0.5

        # 反向传播和优化
        optimizer.zero_grad()
        train_loss.backward()
        optimizer.step()

        train_running_loss1 += train_loss1.item()
        train_running_loss2 += train_loss2.item()
        total_samples += 1
        epoch_train_loss1=train_running_loss1/total_samples
        epoch_train_loss2=train_running_loss2/total_samples

    #模型验证
    model.eval()
    val_running_loss = 0
    val_running_loss1 = 0
    val_running_loss2 = 0
    total_samples = 0

    with torch.no_grad():
        for data in val_loader:
            # 区分输入，输出标签1，输出标签2
            val_inputs, val_y1, val_y2 = data

            # 前向传播
            val_output1, val_output2 = model(val_inputs)

            # 计算损失
            val_loss1 = criterion(val_output1, val_y1)
            val_loss2 = criterion(val_output2, val_y2)
            val_loss = val_loss1 * 0.5 + val_loss2 * 0.5

            optimizer.zero_grad()
            optimizer.step()

            val_running_loss += val_loss.item()
            val_running_loss1 += val_loss1.item()
            val_running_loss2 += val_loss2.item()
            total_samples += 1
            epoch_val_loss = val_running_loss/total_samples
            epoch_val_loss1 = val_running_loss1/total_samples
            epoch_val_loss2 = val_running_loss2/total_samples


    # 更新学习率
    reduce_lr.step(epoch_val_loss)

    return epoch_train_loss1, epoch_train_loss2, epoch_val_loss1, epoch_val_loss2

# 单输出准确率计算函数
def compute_one_accuracy(output, target):
    _, predicted = torch.max(output, 1)
    correct = (predicted == target).sum().item()
    total = target.size(0)
    accuracy = correct / total
    return accuracy

# 双输出准确率计算函数
def compute_two_accuracy(model, _):
    total_correct_accuracy1 = 0
    total_correct_accuracy2 = 0
    total_samples = 0

    with torch.no_grad():
        for batch in _:
            inputs, label1, label2 = batch
            output1, output2 = model(inputs)

            # 计算第一个、第二个输出层的准确率
            accuracy1 = compute_one_accuracy(output1, label1)
            accuracy2 = compute_one_accuracy(output2, label2)

            # 计算每个epoch两个准确率的平均值
            total_correct_accuracy1 += accuracy1 
            total_correct_accuracy2 += accuracy2
            total_samples += 1

    return total_correct_accuracy1 / total_samples, total_correct_accuracy2 / total_samples

# 训练迭代
train_loss1 = []
train_loss2 = []
val_loss1 = []
val_loss2 = []
train_accuracy1 = []
val_accuracy1 = []
train_accuracy2 = []
val_accuracy2 = []

num_epochs = 300
for epoch in range(num_epochs):
    # 计算每个epoch的训练集损失、验证集损失、训练集准确率、验证集准确率
    epoch_train_loss1, epoch_train_loss2, epoch_val_loss1, epoch_val_loss2=training(model,criterion,optimizer,reduce_lr,train_loader,val_loader)
    epoch_train_accuracy1,epoch_train_accuracy2=compute_two_accuracy(model,train_loader)
    epoch_val_accuracy1,epoch_val_accuracy2=compute_two_accuracy(model,val_loader)
    # 保存训练集和验证集的迭代数据
    train_loss1.append(epoch_train_loss1)
    train_loss2.append(epoch_train_loss2)
    val_loss1.append(epoch_val_loss1)
    val_loss2.append(epoch_val_loss2)
    train_accuracy1.append(epoch_train_accuracy1)
    val_accuracy1.append(epoch_val_accuracy1)
    train_accuracy2.append(epoch_train_accuracy2)
    val_accuracy2.append(epoch_val_accuracy2)

    # 打印每个 epoch 的损失
    print(f'Epoch [{epoch+1}/{num_epochs}]\n'
          f'Train Accuracy1: {epoch_train_accuracy1}, Val Accuracy1: {epoch_val_accuracy1} \n'
          f'Train Accuracy2: {epoch_train_accuracy2}, Val Accuracy2: {epoch_val_accuracy2} \n'
          f'Train Loss1: {epoch_train_loss1}, Val Loss1: {epoch_val_loss1},\n'
          f'Train Loss2: {epoch_train_loss2}, Val Loss2: {epoch_val_loss2},\n')
    
# 使用模型进行预测
model.eval()
with torch.no_grad():
    y1_pred, y2_pred = model(X_test_tensor)
# 将预测值和真实值转换为类别标签
y1_test_classes = np.argmax(y1_test, axis=1)
y1_pred_classes = np.argmax(y1_pred.numpy(), axis=1)
y2_test_classes = np.argmax(y2_test, axis=1)
y2_pred_classes = np.argmax(y2_pred.numpy(), axis=1)

# 混淆矩阵和分类报告
conf_matrix_y1 = confusion_matrix(y1_test_classes, y1_pred_classes)
conf_matrix_y2 = confusion_matrix(y2_test_classes, y2_pred_classes)

class_report_y1 = classification_report(y1_test_classes, y1_pred_classes, zero_division=1)
class_report_y2 = classification_report(y2_test_classes, y2_pred_classes, zero_division=1)

print("Confusion Matrix (Task 1):\n", conf_matrix_y1)
print("Classification Report (Task 1):\n", class_report_y1)

print("Confusion Matrix (Task 2):\n", conf_matrix_y2)
print("Classification Report (Task 2):\n", class_report_y2)



    
# 设置图形的大小和分辨率
fig, axs = plt.subplots(2, 2, figsize=(16, 8), dpi=100, facecolor=None, edgecolor=None, frameon=True)

# 绘制第一行的子图，显示output1的准确率和损失率
axs[0, 0].plot(train_accuracy1, color='black', linestyle='-')
axs[0, 0].plot(val_accuracy1, color='black', linestyle='--')
axs[0, 0].set_title('Output 1 Accuracy')
axs[0, 0].legend(['Train', 'Val'], loc='lower right')

axs[0, 1].plot(train_loss1, color='black', linestyle='-')
axs[0, 1].plot(val_loss1, color='black', linestyle='--')
axs[0, 1].set_title('Output 1 Loss')
axs[0, 1].legend(['Train', 'Val'], loc='upper right')

# 绘制第二行的子图，显示output2的准确率和损失率
axs[1, 0].plot(train_accuracy2, color='black', linestyle='-')
axs[1, 0].plot(val_accuracy2, color='black', linestyle='--')
axs[1, 0].set_title('Output 2 Accuracy')
axs[1, 0].legend(['Train', 'Val'], loc='lower right')

axs[1, 1].plot(train_loss1, color='black', linestyle='-')
axs[1, 1].plot(val_loss2, color='black', linestyle='--')
axs[1, 1].set_title('Output 2 Loss')
axs[1, 1].legend(['Train', 'Val'], loc='upper right')

plt.rcParams['font.size'] = 10  # 设置全局字体大小

fig.text(0.5, -0.01, 'Epoch', ha='center', fontsize=16)
fig.text(-0.01, 0.5, 'Accuracy and Loss', va='center', rotation='vertical', fontsize=16)
plt.tight_layout()  # 调整子图间距

# 显示图形
plt.show()




