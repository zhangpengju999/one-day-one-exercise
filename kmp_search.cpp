#include <string>
#include <iostream>
#include <vector>

using namespace std;

vector<int> compute_prefix_function(const string &P) {
    int m = P.size();
    vector<int> pi(m);
    pi[0] = 0;
    int k = 0;
    for (int q = 1; q < m; ++q) {
        while (k > 0 and P[k] != P[q]) 
            k = pi[k - 1];
        if (P[k] == P[q])
            k++;
        pi[q] = k;
    }
    return pi;
}

vector<int> kmp_matcher(const string &T, const string &P) {
    vector<int> pos {};

    if (P.empty() || T.empty()) 
        return pos;

    int n = T.size();
    int m = P.size();


    vector<int> pi = compute_prefix_function(P);
    int q = 0;
    for (int i = 0; i < n; ++i) {
        while (q > 0 && P[q] != T[i]) {
            q = pi[q - 1];
        }
        if (P[q] == T[i]) 
            q++;
        if (q == m) {
            pos.push_back(i - m + 1);
            q = pi[q - 1];
        }
    }
    return pos;
}

void print_vector(const vector<int>& vec) {
    for (auto val: vec) {
        cout << val << " ";
    }
    cout << endl;
}

int main(void) {
    string P = "ababaca";
    string T = "bacbababacababaca";

    vector<int> pos = kmp_matcher(T, P);
    print_vector(pos);

    return 0;
}
