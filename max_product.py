# -*- coding: utf-8 -*-

#title:
#求数组中乘积最大的连续子数组，返回乘积最大值

# tips:
#    动态规划
# 定义 f[i] 为 以第 i 位为结尾的乘积最大值， g[i] 是以第 i 位为结尾的乘积最小值, 假设原数组是A[]
# 则有递推关系式：
# f[i+1] = max(f[i]*A[i], g[i]*A[i], A[i])
# g[i+1] = min(f[i]*A[i], g[i]*A[i], A[i])
# 时间复杂度 O(n)

def max_product(A):
    if not A or not isinstance(A, list):
        return 0
    length = len(A)
    if length == 1:
        return A[0]
    f = [0] * length
    g = [0] * length
    f[0] = A[0]
    g[0] = A[0]
    for i in range(1, length):
        f[i] = max(f[i-1]*A[i-1], g[i-1]*A[i-1], A[i-1])
        g[i] = min(f[i-1]*A[i-1], g[i-1]*A[i-1], A[i-1])

    return max(f)

if __name__ == '__main__':
    print max_product(2)
    print max_product("1.5")
    print max_product([])
    print max_product([1])
    print max_product([1, 2, 3, 0.2])
    print max_product([-1, -2, -3, -0.2])

