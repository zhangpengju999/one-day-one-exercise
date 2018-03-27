/*
 *  Best Time to Buy and Sell Stock Problem Collection 
 */

#include <vector>
#include <iostream>
#include <cmath>
#include <climits>

using namespace std;

// Best Time to Buy and Sell Stock 
int MaxProfit(const vector<int> &prices) { 
    int min_price = INT_MAX;
    int max_profit = 0;

    for (size_t i = 0; i < prices.size(); ++i) {
        min_price = min(prices[i], min_price);
        max_profit = max(max_profit, prices[i] - min_price);
    }
    return max_profit;
}

// Best Time to Buy and Sell Stock II 
int MaxProfit2(const vector<int> &prices) {
    int max_profit = 0;

    for (size_t i = 1; i < prices.size(); ++i) {
        max_profit += max(0, prices[i] - prices[i - 1]); 
    }
    return max_profit;
}

// Best Time to Buy and Sell Stock III
int MaxProfit3(const vector<int> &prices) {
    if (prices.size() < 2)
        return 0;

    int global[2][2] = {0, 0, 0, 0};
    int local[2] = {0, 0};

    int prev = 0;
    int cur = 1;
    int min_price = prices[0];

    for (size_t i = 1; i < prices.size(); ++i) {
        int diff = prices[i] - prices[i - 1];
        min_price = min(prices[i], min_price);
        local[cur] = max(global[prev][0] + max(0, diff), local[prev] + diff); 
        global[cur][0] = max(global[cur][0], prices[i] - min_price);
        global[cur][1] = max(global[prev][1], local[cur]);
        swap(prev, cur);
    }
    return global[prev][1];
}

// Best Time to Buy and Sell Stock IV
int MaxProfit4(int k, const vector<int> &prices) {
    if (prices.size() < 2 || k < 1)
        return 0;

    if (k > prices.size() / 2) {
        int ret = 0;
        for (size_t i = 1; i < prices.size(); ++i) {
            ret += max(prices[i] - prices[i - 1], 0);
        }
        return ret;
    }

    vector<int> global[2] = {vector<int>(k, 0), vector<int>(k, 0)};
    vector<int> local[2] = {vector<int>(k, 0), vector<int>(k, 0)};

    int prev = 0;
    int cur = 1;

    for (size_t i = 1; i < prices.size(); ++i) {
        int diff = prices[i] - prices[i - 1];

        for (int j = 0; j < k; ++j) {
            if (j == 0)
                local[cur][j] = max(max(diff, 0), local[prev][j] + diff);
            else
                local[cur][j] = max(global[prev][j - 1] + max(diff, 0),
                                    local[prev][j] + diff);
            global[cur][j] = max(global[prev][j], local[cur][j]);
        }
        swap(prev, cur);
    }

    return global[prev][k - 1];
}

int main(void) {
    vector<int> prices{2, 4, 6, 9, 1, 3, 11, 7};
    cout << MaxProfit(prices) << endl;
    cout << MaxProfit2(prices) << endl;
    cout << MaxProfit3(prices) << endl;
    cout << MaxProfit4(2, prices) << endl;
    return 0;
}
