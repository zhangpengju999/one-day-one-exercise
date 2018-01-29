# -*- coding: utf-8 -*-

#title:
#一个数组表示股票每天的价格, 只可以进行一次买卖操作并且只能先买后卖, 求何时买卖利润最大

# 时间复杂度 O(n)


def max_profit(prices):
    if len(prices) ==0 or len(prices) == 1:
        return 0
    buy = prices[0]
    profit = 0
    for v in prices:
        buy = min(buy, v)
        profit = max(v-buy, profit)
    return profit

if __name__ == "__main__":
    prices = [2,1,2,4,3,10]
    print max_profit(prices)