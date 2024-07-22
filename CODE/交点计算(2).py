import pandas as pd
import numpy as np
import os
from tqdm import tqdm

# 台站坐标: 经度，纬度
address_zt = [103.73, 27.32]
address_ys = [100.76, 26.69]
address_tc = [98.54, 25.02]
address_gz = [103.18, 30.12]

# 读取台站斜率和强度数据
zt_data = pd.read_csv("D:\\srdp\\所用数据集\\zt\\zt斜率数据集分钟版.csv")
ys_data = pd.read_csv("D:\\srdp\\所用数据集\\ys\\ys斜率数据集分钟版.csv")
tc_data = pd.read_csv("D:\\srdp\\所用数据集\\tc\\tc斜率数据集分钟版.csv")
gz_data = pd.read_csv("D:\\srdp\\所用数据集\\gz\\gz斜率数据集分钟版.csv")

# 合并数据
df_all = pd.DataFrame({
    'time': pd.to_datetime(zt_data['time']),
    'zt_slope': zt_data['slope'],
    'zt_intensity': zt_data['intensity'],
    'ys_slope': ys_data['slope'],
    'ys_intensity': ys_data['intensity'],
    'tc_slope': tc_data['slope'],
    'tc_intensity': tc_data['intensity'],
    'gz_slope': gz_data['slope'],
    'gz_intensity': gz_data['intensity']
})

# 直线交点函数
def line_intersection(slope1, intercept1, slope2, intercept2, coord1, coord2, intensity1, intensity2):
    if slope1 == slope2:
        if intercept1 == intercept2:  # 直线重合
            total_intensity = intensity1 + intensity2
            x = (intensity1 * coord1[0] + intensity2 * coord2[0]) / total_intensity
            y = (intensity1 * coord1[1] + intensity2 * coord2[1]) / total_intensity
            return x, y
        else:  # 直线平行但不重合
            return float('inf'), float('inf')  # 无实际交点

    if np.isinf(slope1):
        x = coord1[0]
        y = slope2 * x + intercept2
        return x, y
    if np.isinf(slope2):
        x = coord2[0]
        y = slope1 * x + intercept1
        return x, y

    x = (intercept2 - intercept1) / (slope1 - slope2)
    y = slope1 * x + intercept1
    return x, y

# 计算每个时刻的六个交点
intersection_points = []

for idx, row in tqdm(df_all.iterrows(), total=df_all.shape[0], desc="计算交点"):
    slopes = {
        'zt': row['zt_slope'],
        'ys': row['ys_slope'],
        'tc': row['tc_slope'],
        'gz': row['gz_slope']
    }
    
    intercepts = {
        'zt': address_zt[1] - slopes['zt'] * address_zt[0],
        'ys': address_ys[1] - slopes['ys'] * address_ys[0],
        'tc': address_tc[1] - slopes['tc'] * address_tc[0],
        'gz': address_gz[1] - slopes['gz'] * address_gz[0]
    }
    
    intensities = {
        'zt': row['zt_intensity'],
        'ys': row['ys_intensity'],
        'tc': row['tc_intensity'],
        'gz': row['gz_intensity']
    }
    
    # 计算交点
    points = []
    coordinates = {'zt': address_zt, 'ys': address_ys, 'tc': address_tc, 'gz': address_gz}
    combinations = [('zt', 'ys'), ('zt', 'tc'), ('zt', 'gz'), ('ys', 'tc'), ('ys', 'gz'), ('tc', 'gz')]
    for (a, b) in combinations:
        x, y = line_intersection(slopes[a], intercepts[a], slopes[b], intercepts[b], coordinates[a], coordinates[b], intensities[a], intensities[b])
        points.extend([x, y])
    
    intersection_points.append(points)

# 创建新的DataFrame保存交点数据
columns = [
    'zt-ys_x', 'zt-ys_y',
    'zt-tc_x', 'zt-tc_y',
    'zt-gz_x', 'zt-gz_y',
    'ys-tc_x', 'ys-tc_y',
    'ys-gz_x', 'ys-gz_y',
    'tc-gz_x', 'tc-gz_y'
]
intersection_df = pd.DataFrame(intersection_points, columns=columns)
intersection_df.insert(0, 'time', pd.to_datetime(df_all['time']))
intersection_df.insert(1, 'zt_max_value', zt_data['intensity'])
intersection_df.insert(2, 'ys_max_value', ys_data['intensity'])
intersection_df.insert(3, 'tc_max_value', tc_data['intensity'])
intersection_df.insert(4, 'gz_max_value', gz_data['intensity'])

# 地震目录处理
df1 = pd.read_excel(r"D:\\srdp\\所用数据集\\地震目录\\3-.xls")
df1 = df1.drop(columns=df1.columns[[0, 4, 5, 7, 8]])
df2 = pd.read_excel(r"D:\\srdp\\所用数据集\\地震目录\\5-.xls")
df2 = df2.drop(columns=df2.columns[[0, 4, 5, 7, 8]])
df1.columns = ['time', 'lon', 'lat', 'level']
df2.columns = ['time', 'lon', 'lat', 'level']
df1['time'] = pd.to_datetime(df1['time'])
df2['time'] = pd.to_datetime(df2['time'])
df3 = pd.concat([df1, df2], ignore_index=True)

# 合并数据集
df4 = pd.merge(intersection_df, df3, how='left', on='time')

# 将后三列的所有空白位置填入0
df4[['lon', 'lat', 'level']] = df4[['lon', 'lat', 'level']].fillna(0)
# 新增judge列
def assign_judge(level):
    if level >= 5:
        return 2
    elif level >= 3 and level < 5:
        return 1
    else:
        return 0

df4['judge'] = df4['level'].apply(assign_judge)


# 保存到CSV文件
output_path = 'D:\\srdp\\所用数据集\\交点数据分钟版版.csv'
os.makedirs(os.path.dirname(output_path), exist_ok=True)
df4.to_csv(output_path, index=False)
print("交点数据保存完毕")
