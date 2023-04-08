import numpy as np

if __name__ == '__main__':
    # 使用numpy计算矩阵特征值
    ShengSai2023.A = np.array([[1, 2, 1], [0.5, 1, 2], [1, 1/2, 1]])
    print(np.max(np.linalg.eig(ShengSai2023.A)[0]))
    # 使用numpy计算矩阵的逆矩阵
    ShengSai2023.A = np.array([[1, 2], [3, 4]])
    print(np.linalg.inv(ShengSai2023.A))