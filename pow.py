# -*- coding: utf-8 -*-

#title:
#pow(double x, int n), 计算一个数x的n次幂

# tips:
#    二分法
# 时间复杂度 O(logn)


def pow(x, n):
    if n == 0:
        return 1.0
    r = pow(x, n//2)
    if (n % 2 == 0):
        return r * r
    else:
        return r * r * x


if __name__ == "__main__":
    x = 2
    n = -10
    if n < 0:
        result = 1/pow(x, -n)
    else:
        result = pow(x, n)
    print result