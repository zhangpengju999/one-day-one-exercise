#include <string>
#include <iostream>
#include <vector>
#include <cmath>
#include <memory>

using namespace std;

size_t LevenshteinDistance(const string &s1, const string &s2) {
    size_t l1 = s1.size() + 1;
    size_t l2 = s2.size() + 1;

    unique_ptr<size_t[]> m(new size_t[l1 * l2]);
    for (size_t i = 0; i < l1; ++i)
        m[i] = i;
    for (size_t j = 1; j < l2; ++j)
        m[j * l1] = j;

    for (size_t j = 1; j < l2; ++j) {
        for (size_t i = 1; i < l1; ++i) {
            size_t d1 = m[(j - 1) * l1 + i - 1];
            size_t d2 = m[(j - 1) * l1 + i];
            size_t d3 = m[j * l1 + i - 1];
            if (s1[i - 1] == s2[j - 1])
                m[j * l1 + i] = min(min(d2 + 1, d3 + 1), d1);
            else
                m[j * l1 + i] = min(min(d2 + 1, d3 + 1), d1 + 1);
        }
    }

    return m[l1 * l2 - 1];
}

int main(void) {

    cout << LevenshteinDistance("", "ab") << endl;
    cout << LevenshteinDistance("abc", "cba") << endl;
    cout << LevenshteinDistance("string", "story") << endl;
    cout << LevenshteinDistance("book", "block") << endl;
    cout << LevenshteinDistance("pneumonoultramicroscopicsilicovolcanoconiosis",
                                "ultramicroscopically") << endl;

    return 0;
}
