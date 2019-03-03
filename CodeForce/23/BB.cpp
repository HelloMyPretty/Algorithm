#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 100005;

int arr[maxn];
ll S[maxn];
bool cmp(int a, int S)
{
    return a > S;
}

int main()
{
    int n, k, m;
    cin >> n >> k >> m;
    for(int i = 1; i <= n; i++)
        cin >> arr[i];
    sort(arr + 1, arr + n + 1, cmp);
    for(int i = 1; i <= n; i++)
        S[i] = S[i - 1] + arr[i];
    double ans = 0, co = 0;
    double num = -1;
    for(int i = 0; i < n; i++)
    {
        ans = 1.0 * (S[n - i] + min((n - i) * k, m - i)) / (n - i);
        num = max(num, ans);
    }
    printf("%.7lf", num);
    return 0;
}
