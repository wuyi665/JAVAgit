import pandas as pd

# 读取CSV文件
file_path = "D:\\srdp\\所用数据集\\交点数据分钟版版.csv"
df = pd.read_csv(file_path)

# 统计level列不为0的数据条数
non_zero_level_count = df[df['level'] != 0].shape[0]

print(f"level列不为0的数据条数: {non_zero_level_count}")
