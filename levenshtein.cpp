#include <string>
#include <iostream>
#include <vector>
#include <cmath>
#include <memory>

using namespace std;

#define LOC(row, col, stride) (row) * (stride) + (col)

size_t levenshtein_distance(const string &s1, const string &s2) {
    size_t len_s1 = s1.size();
    size_t len_s2 = s2.size();

    size_t stride = len_s1 + 1;
    vector<size_t> m(stride * (len_s2 + 1));

    for (size_t i = 0; i < len_s1 + 1; ++i) 
        m[i] = i;
    for (size_t j = 1; j < len_s2 + 1; ++j)
        m[LOC(j, 0, stride)] = j;
    for (size_t i = 1; i < len_s1 + 1; ++i) { 
        for (size_t j = 1; j < len_s2 + 1; ++j) {
            size_t d1 = m[LOC(j - 1, i - 1, stride)];
            size_t d2 = m[LOC(j - 1, i, stride)];
            size_t d3 = m[LOC(j, i - 1, stride)];
            size_t d = min(min(d1, d2), d3);
            if (s1[i - 1] == s2[j - 1]) 
                m[LOC(j, i, stride)] = d;
            else 
                m[LOC(j, i, stride)] = d + 1;
        }
    }

    return m[LOC(len_s2, len_s1, stride)];
}

int main(void) {

    cout << levenshtein_distance("", "ab") << endl;
    cout << levenshtein_distance("abc", "cba") << endl;
    cout << levenshtein_distance("string", "story") << endl;
    cout << levenshtein_distance("book", "block") << endl;

    return 0;
}
