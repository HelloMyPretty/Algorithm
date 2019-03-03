#include<bits/stdc++.h>
using namespace std;
int arr[100005];
int main(int argc, char const *argv[])
{
	int left = 0;
	int n, m, k;
	cin >> n >> m >> k;
	cin >> left;
	for(int i = 2; i <= n; i++)
	{
		int e;
		cin >> e;
		arr[i] = e - left;
		left = e;
	}
	sort(arr + 2, arr + n + 1);
	//for(int i = 2; i <= n; i++)  cout << arr[i] << endl;
	int ans = 0;
	for(int i = 2, j = 1; j <= n - k; i++,j++) ans += arr[i];
	ans += k;
	cout << ans << endl;
	return 0;
}