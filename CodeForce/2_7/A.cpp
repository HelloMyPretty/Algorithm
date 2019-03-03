#include<bits/stdc++.h>
using namespace std;
int arr[100005];
int main()
{
	int k, b;
	cin >> b >> k;
	int ans = 0;
	int base = 1;
	int ok = 0;
	for(int i = k; i > 0; i--)
		cin >> arr[i];
	for(int i = 1; i <= k; i++)
	{
		int e = arr[i];
		ans += (e * base % 10);
		base = base * b % 10;
	}
	if(ans % 2) cout << "odd" << endl;
	else cout << "even" << endl;
	return 0;
}