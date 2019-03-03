#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 2e5 + 5;
int n, m, k;
ll arr[maxn], brr[maxn];
map<ll, ll>mp;

int main(int argc, char const *argv[])
{
	cin >> n >> m >> k;
	for(int i = 0; i < n; i++)
	{
		cin >> arr[i];
		brr[i] = arr[i];
	}
	sort(brr, brr + n);
	int co = 0;
	ll ans = 0;
	for(int i = n - 1; i >= 0 && co < m * k; i--, co++)
	{
		mp[brr[i]]++;
		ans += brr[i];
	}
	cout << ans << endl;
	int have = 0;
	co = 0;
	for(int i = 0; i < n; i++)
	{
		if(mp.find(arr[i]) != mp.end() && mp[arr[i]] > 0)
		{
			have++;
			mp[arr[i]]--;
		}
		if(have == m&&co<k-1)
		{
			co++;
			cout << i + 1 << endl;
			have = 0;
		}
	}

	return 0;
}