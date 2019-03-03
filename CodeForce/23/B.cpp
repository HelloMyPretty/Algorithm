#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 1e5 + 5;
ll arr[maxn];
int main()
{
	int n, k, m;
	cin >> n >> k >> m;
	ll s = 0;
	for(int i = 1; i <= n; i++)
	{
		cin >> arr[i];
		s += arr[i];
	}
	sort(arr + 1, arr + n + 1);
	double ans = (s * 1.0 + min(n * k, m)) / n;

	if(n == 1)
	{
		printf("%.6lf", ans);
		return 0;
	}
	for(int i = 1; i <= min(n - 1, m); i++)
	{
		s -= arr[i];
		double res = (min((n - i) * 1ll * k, m * 1ll - i) + s) * 1.0 / (n - i);
		ans = max(ans, res);
	}
	printf("%.6lf", ans);
	return 0;
}