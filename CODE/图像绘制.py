import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import os
from tqdm import tqdm

# 台站坐标: 经度，纬度
address_zt = [103.73, 27.32]
address_ys = [100.76, 26.69]
address_tc = [98.54, 25.02]
address_gz = [103.18, 30.12]

# 台站名称和颜色
stations = {
    'zt': (address_zt, 'red'),
    'ys': (address_ys, 'orange'),
    'tc': (address_tc, 'yellow'),
    'gz': (address_gz, 'green')
}

# 读取交点数据
intersection_df = pd.read_csv('D:\\srdp\\所用数据集\\交点数据完整版.csv')

# 将 time 列转换为 datetime 类型
intersection_df['time'] = pd.to_datetime(intersection_df['time'])

# 提取年份和月份信息
intersection_df['year'] = intersection_df['time'].dt.year
intersection_df['month'] = intersection_df['time'].dt.month

# 定义颜色
intersection_color = 'blue'
earthquake_color_5_plus = 'black'

# 定义 x 和 y 的区间
xlim = (80, 120)
ylim = (10, 45)

# 创建输出目录
output_dir = 'D:\\srdp\\所用数据集\\交点数据年份图像'
os.makedirs(output_dir, exist_ok=True)

# 按年份分组
years = intersection_df['year'].unique()
for year in years:
    # 创建图形和子图，先设置一个大图
    fig, ax = plt.subplots(figsize=(20, 15))
    
    # 获取当前年份的数据
    year_data = intersection_df[intersection_df['year'] == year]
    
    # 创建一个计数器来跟踪子图的数量
    subplot_count = 0
    
    # 按月份绘制数据点
    for month in range(1, 13):
        month_data = year_data[year_data['month'] == month]
        if not month_data.empty:
            subplot_count += 1
            ax = plt.subplot(3, 4, subplot_count)
            
            # 绘制交点
            for (x_col, y_col) in [('zt-ys_x', 'zt-ys_y'), ('zt-tc_x', 'zt-tc_y'), ('zt-gz_x', 'zt-gz_y'),
                                   ('ys-tc_x', 'ys-tc_y'), ('ys-gz_x', 'ys-gz_y'), ('tc-gz_x', 'tc-gz_y')]:
                ax.scatter(month_data[x_col], month_data[y_col], color=intersection_color, label='intersection', alpha=0.6)
            
            # 绘制地震点，只显示级别大于等于5的地震
            month_data_5_plus = month_data[month_data['level'] >= 5]
            ax.scatter(month_data_5_plus['lon'], month_data_5_plus['lat'], color=earthquake_color_5_plus, label='5+ magnitude', marker='*', s=month_data_5_plus['level']*20)
            
            # 绘制台站坐标
            for station, (coord, color) in stations.items():
                ax.scatter(coord[0], coord[1], color=color, label=f'station {station}', edgecolor='black', s=100, marker='o')
            
            # 设置标题和标签
            ax.set_title(f'Month {month}')
            ax.set_xlim(xlim)
            ax.set_ylim(ylim)
            ax.set_xlabel('Longitude')
            ax.set_ylabel('Latitude')
    
    # 调整布局和图例
    handles, labels = ax.get_legend_handles_labels()
    fig.legend(handles, labels, loc='upper right')
    plt.tight_layout(rect=[0, 0, 0.9, 1])
    
    # 保存图像
    output_path = os.path.join(output_dir, f'{year}_交点数据月份图像.png')
    plt.savefig(output_path)
    plt.close(fig)
    print(f"{year} 年图像保存完毕")
