import math
import pandas as pd
import numpy as np
from tqdm import tqdm
from joblib import Parallel, delayed

# 定义一个空的数据框来存储合并后的数据
df_all = pd.DataFrame()

# 使用一个循环来读取和处理四个txt文件
for i in range(1, 5):
    # 读取第i个txt文件，并去掉第一列
    df_stra = pd.read_csv(f"D:\\srdp\\所用数据集\\ys\\ys_stra ({i}).txt", sep=' ', header=None)
    df_stra = df_stra.drop(columns=df_stra.columns[[0]])
    
    # 转置数据框，并将其添加到合并后的数据框中
    df_stra = df_stra.T
    df_all[f'stra0{i}'] = df_stra.values.flatten(order='F')
    
# 替换极大值为空值
df_all = df_all.replace([999999], np.nan)

# 替换空值为插值
df_all = df_all.fillna(df_all.interpolate())

num1 = df_all.iloc[525600-1,:]
num2 = df_all.iloc[1051200-1,:]
num3 = df_all.iloc[1578240-1,:]
num4 = df_all.iloc[2103840-1,:]
num5 = df_all.iloc[2629440-1,:]

df1 = df_all.iloc[0:525600,:]
df2 = df_all.iloc[525600:1051200,:]
df3 = df_all.iloc[1051200:1578240,:]
df4 = df_all.iloc[1578240:2103840,:]
df5 = df_all.iloc[2103840:2629440,:]
df6 = df_all.iloc[2629440:,:]

df2 += num1
df3 += num1 + num2
df4 += num1 + num2 + num3
df5 += num1 + num2 + num3 + num4
df6 += num1 + num2 + num3 + num4 + num5
df_all = pd.concat([df1, df2, df3, df4, df5, df6], axis=0)

# 截取需要的行数
df_all = df_all.iloc[:1440*2779]

# 添加时间列，并格式化为字符串
time = pd.date_range('2010/01/01 00:00', '2017/08/10 23:59', freq='min')
df_all.insert(0, 'time', time)

# 计算不同方向应变数据值
# 将每列数据分别赋值给SS1, SS2, SS3, SS4
SS1 = df_all['stra01'].values
SS2 = df_all['stra02'].values
SS3 = df_all['stra03'].values
SS4 = df_all['stra04'].values

# 存储每个 i 的 s_theta 值
s_theta_dict = {}

# 计算并插入每个 i 下的 s_theta
for i in tqdm(range(1, 361), desc="计算应变数据"):
    theta = np.deg2rad(i)
    e1e2 = 0.5 * (SS1 + SS3) * (1 + 0.25)
    
    with np.errstate(divide='ignore', invalid='ignore'):
        phi = np.deg2rad(52) - 0.5 * np.arctan(np.divide((SS4 - SS2), (SS1 - SS3)))
        e1_e2 = np.divide(((SS1 - SS3) * (1 + 0.25)), (4 * np.cos(np.arctan(np.divide((SS4 - SS2), (SS1 - SS3)))))) * np.cos(2 * (theta - phi))

    # 处理SS1和SS3相等的情况
    e1e2[SS1 == SS3] = 0
    e1_e2[SS1 == SS3] = 0
    
    s_theta = 0.5 * e1e2 + 0.5 * e1_e2
    s_theta_dict[i] = s_theta

# 将所有 s_theta 值转换为 DataFrame
s_theta_df = pd.DataFrame(s_theta_dict)

# 计算 max, min, max-min 列
max_i = s_theta_df.idxmax(axis=1).values
min_i = s_theta_df.idxmin(axis=1).values
max_min_diff = np.abs(max_i - min_i)

df_all['max'] = max_i
df_all['min'] = min_i
df_all['max-min'] = max_min_diff

# 计算每个时刻的斜率
def calculate_slope(angle):
    theta = math.radians(angle)
    return math.tan(theta)

# 计算并存储每个时刻的斜率
df_all['slope'] = df_all['max'].apply(calculate_slope)

# 提取所需列
df_result = df_all[['time', 'slope', 'max']].copy()

# 根据max列的值找到对应的s_theta值，并创建一个新的列max_value
max_indices = df_result['max'].values - 1  # idxmax() 是从 1 开始的，需要减 1
max_values = s_theta_df.to_numpy()[np.arange(len(df_result)), max_indices]
df_result.loc[:, 'max_value'] = max_values

df_result.rename(columns={'max_value': 'intensity'}, inplace=True)

# 保存结果到CSV文件
df_result.to_csv("D:\\srdp\\所用数据集\\ys\\ys斜率数据集分钟版.csv", index=False)
print("最终数据集保存完成")
