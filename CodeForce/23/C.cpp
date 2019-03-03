#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int pos[100005];
map<int, int>mp;
ll m, k, A, B;
ll ff(int l, int r)         //查找pos[i] 在[l,r]内的数
{
	int left = lower_bound(pos, pos + k, l) - pos;
	int right = upper_bound(pos, pos + k, r ) - pos;
	return right - left ;

}
ll ans = 0;
ll f(int l, int r)
{
	if(l == r)
	{
		if (!ff(l, r)) return A;
		return  B * (r - l + 1) * 1;
	}
	int m = (l + r) >> 1;
	int n = ff(l, r);
	ll res = f(l, m) + f(m + 1, r);
	if(!n)
		return min(A, res);
	else
		return min(B * (r - l + 1) * n, res);
}
int main(int argc, char const *argv[])
{
	cin >> m >> k >> A >> B;
	for(int i = 0; i < k; i++)
	{
		int e;
		cin >> pos[i] ;
	}
	sort(pos, pos + k);
	cout << f(1, 1 << m) << endl;
	return 0;
}