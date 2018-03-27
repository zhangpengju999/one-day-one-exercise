# -*- coding: utf-8 -*-

#title:
#1、一个数组表示股票每天的价格, 只可以进行一次买卖操作并且只能先买后卖, 求何时买卖利润最大
#2、可以买卖无穷次, 买之前必须把以前的股票卖掉, 求最大获利
#3、可以买卖两次, 买之前必须把以前的股票卖掉, 求最大获利

#1、时间复杂度 O(n)
#2、时间复杂度 O(n)
#3、时间复杂度 O(n)


def max_profit1(prices):
    if len(prices) ==0 or len(prices) == 1:
        return 0
    buy = prices[0]
    profit = 0
    for v in prices:
        buy = min(buy, v)
        profit = max(v-buy, profit)
    return profit


def max_profit2(prices):
    if len(prices) ==0 or len(prices) == 1:
        return 0
    profit = 0
    for i in range(len(prices)-1):
        if prices[i]<prices[i+1]:
            profit += prices[i+1]-prices[i]
    return profit


def max_profit3(prices):
    if len(prices) ==0 or len(prices) == 1:
        return 0
    sum = 0
    buy = prices[0]
    sell = prices[-1]
    left = []
    right = []
    profit = 0
    for v in prices:
        buy = min(buy, v)
        profit = max(v - buy, profit)
        left.append(profit)
    profit = 0
    for v in prices[::-1]:
        sell = max(sell, v)
        profit = max(sell - v, profit)
        right.append(profit)
    for i in range(len(prices)):
        if left[i]+right[len(prices)-i-1] > sum:
            sum = left[i]+right[len(prices)-i-1]
    return sum

if __name__ == "__main__":
    prices = [2,1,2,4,3,10]
    print max_profit1(prices)
    print max_profit2(prices)
    print max_profit3(prices)