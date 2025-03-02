#include <bits/stdc++.h>

#define FASTIO ios_base::sync_with_stdio(false);cin.tie(NULL);
#define SIZE(v) (int)v.size()
#define ALL(v) v.begin(),v.end()
#define SETW(n, c) cout << setw(n) << setfill(c);
#define SETP(n) cout << fixed << setprecision(n);

using namespace std;
using ll = long long;
using uint = unsigned int;
using ull = unsigned long long;
using ld = long double;
using pii = pair<int, int>;

int main() {
    FASTIO;

    int n;
    cin >> n;

    stack<int> stck;
    ll moved_cnt_div_4 = 0;
    ll moved_weight_sum = 0;
    int prev = 20;

    for (int i = 0; i < n; i++) {
        int cur;
        cin >> cur;

        if (prev < cur) {
            int diff = cur - prev;
            moved_weight_sum += diff;
            stck.push(diff);
        }
        else if (prev > cur) {
            int diff = prev - cur;
            moved_weight_sum += diff;

            while (diff > 0) {
                int weight_to_pop = min(diff, stck.top());
                diff -= weight_to_pop;
                stck.top() -= weight_to_pop;

                if (stck.top() == 0) stck.pop();

                moved_cnt_div_4 += (weight_to_pop - 1) / 40 + 1;
            }
        }

        prev = cur;
    }

    if (prev > 20) {
        int diff = prev - 20;
        moved_weight_sum += diff;

        while (diff > 0) {
            int weight_to_pop = min(diff, stck.top());
            diff -= weight_to_pop;
            stck.top() -= weight_to_pop;

            if (stck.top() == 0) stck.pop();

            moved_cnt_div_4 += (weight_to_pop - 1) / 40 + 1;
        }
    }

    cout << moved_weight_sum << ' ' << moved_cnt_div_4 * 4 << '\n';

    return 0;
}
