#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

ll big[10000000], pp[10000000];
int co = 0;

int main()
{
	ll n, b;
	cin >> n >> b;
	ll nn = n;
	ll a = sqrt((double)(b + 0.5));
	for(ll i = 2; i <= a; i++)
	{
		if(b % i == 0)
		{
			big[co] = i;
			while(b % i == 0)
			{
				b /= i;
				pp[co]++;
			}
			co++;
		}
	}
	if(b != 1)
	{
		big[co] = b;
		pp[co] = 1;
		co++;
	}
	ll ans = 0, FINAL = 1000000000000000000;
	for(int i = 0; i < co; i++)
	{
		n = nn;
		ans = 0;
		while(n > 0)
		{
			ans += n / big[i];
			n /= big[i];
		}
		FINAL = min(ans / pp[i], FINAL);

	}
	cout << FINAL << endl;

	return 0;
}