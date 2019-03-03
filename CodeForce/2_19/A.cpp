#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    int q;
    cin >> q;
    while(q--)
    {
        ll n, a, b;
        cin >> n >> a >> b;
        double cost = a / 1;
        double costt = b / 2;
        ll ans = 0;
        if(cost <= costt)
            ans = n * a;
        else
            ans = (n / 2) * b + (n % 2) * a;
        cout << ans << endl;
    }
    return 0;
}