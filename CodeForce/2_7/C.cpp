#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 1005;

int qpow(int base, int n)
{
	int ans = 1;
	while(n)
	{
		if(n & 1) ans *= base;
		base = base * base;
		n >>= 1;
	}
	return ans;
}

int a[maxn];
int table[25] =
{0, 1, 1, 5, 1, 21, 1, 85, 73, 341, 89, 1365, 1, 5461, 4681, 21845, 1, 87381, 1, 349525, 299593, 1398101, 178481, 5592405, 1082401};

int main()
{
	int q;
	cin >> q;
	for(int i = 0; i < q; i++)
		cin >> a[i];
	for(int i = 0; i < q; i++)
	{
		int flag = 0, co = 0;
		for(int j = 0; j < 25; j++)
		{
			if(a[i] == qpow(2, j + 1) - 1)
			{
				co = -1;
				cout << table[j] << endl;
				break;
			}
			else if (a[i] >= qpow(2, j + 1) && a[i] < qpow(2, j + 2) - 1)
				co = j + 1;
		}
		if(co != -1)
			cout << qpow(2, co + 1) - 1 << endl;

	}
	return 0;
}