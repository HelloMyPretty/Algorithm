#include<bits/stdc++.h>
using namespace std;
const int mxn = 2e5 + 5;
long long arr[mxn];
long long even[mxn], odd[mxn];
int main()
{
	int n;
	cin >> n;
	for(int i = 1; i <= n; i++)
	{
		cin >> arr[i];
		if(i % 2)
		{
			odd[i] = odd[i - 1] + arr[i];
			even[i] = even[i - 1];
		}
		else
		{
			even[i] = even[i - 1] + arr[i];
			odd[i] = odd[i - 1];
		}
	}
	int co = 0;
	for(int i = 1; i <= n; i++)
	{
		//cout << i << endl;
		long long evenn = even[i - 1] + odd[n] - odd[i];
		long long oddd = odd[i - 1] + even[n] - even[i];
		//cout << evenn << ' ' << oddd << endl;
		if(evenn == oddd)
			co++;
	}
	cout << co << endl;
	return 0;
}