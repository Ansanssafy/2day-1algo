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

    ll x_sum = 0;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;

        x_sum += x;
    }

    ll ans = x_sum - (ll) n * (n - 1) / 2;
    cout << ans << '\n';

    return 0;
}
