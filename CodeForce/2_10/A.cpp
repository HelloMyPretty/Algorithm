#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int qpow(ll b, ll n)
{
    ll ans = 1;
    while(n)
    {
        if(n & 1) ans *= b;
        b = b * b;
        n >>= 1;
    }
    return ans;
}

int main()
{
    int x, y, z, a, b, c;
    cin >> x >> y >> z >> a >> b >> c;
    int co_1 = 0, co_2 = 0, co_3 = 0;
    if(a >= x)
    {
        co_1 = 1;
        a -= x;
    }
    if(a + b >= y)
    {
        co_2 = 1;
        a -= y;
    }
    if(a + b + c >= z)
    {
        co_3 = 1;
        a -= z;
    }
    if(co_1 == 1 && co_2 == 1 && co_3 == 1)
        printf("YES\n");
    else printf("NO\n");
    return 0;
}
