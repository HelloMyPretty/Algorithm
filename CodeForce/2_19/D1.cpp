#include<bits/stdc++.h>
using namespace std;
long long coff[1005];
long long ccoff[1005];
long long n, m;
long long f(long long chunk)
{
	long long page = 0;
	long long cnt = 0;
	long long i;
	for(int i = 1; i <= chunk; i++)
	{
		int co = 0;
		while(max(ccoff[cnt] - co, 0ll))
		{
			int x=(ccoff[cnt++] - co++);
			page += x;
			if(page >= m)
				return page;
		}
	}
	return page;
}
int main()
{
	cin >> n >> m;
	long long s = 0;
	for(long long i = 0; i < n; i++)
	{
		cin >> coff[i];
		s += coff[i];
	}
	if(s < m)
	{
		cout << -1 << endl;
		return 0;
	}
	if(s == m)
	{
		cout << n << endl;
		return 0;
	}
	sort(coff, coff + n);
	for(long long i = n - 1; i >= 0; i--)
		ccoff[n - i - 1] = coff[i];
	for(long long i = 1; i <= n; i++)
	{
		if(f(i * 1ll) >= m)
		{
			cout << i << endl;
			return 0;
		}
	}
	return 0;
}