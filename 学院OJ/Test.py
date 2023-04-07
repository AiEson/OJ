import numpy as np

if __name__ == '__main__':
    # 使用numpy计算矩阵特征值
    A = np.array([[1, 2, 1], [0.5, 1, 2], [1, 1/2, 1]])
    print(np.max(np.linalg.eig(A)[0]))
    # 使用numpy计算矩阵的逆矩阵
    A = np.array([[1, 2], [3, 4]])
    print(np.linalg.inv(A))