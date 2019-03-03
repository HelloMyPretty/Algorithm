#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

char s[1005], t[1005];
int main()
{
	cin >> s;
	cin >> t;
	int len1 = strlen(s), len2 = strlen(t);
	if(len1 != len2)
	{
		cout << "No" << endl;
		return 0;
	}
	for(int i = 0, j = 0; i < len1 && j < len2; i++, j++)
	{
		if(((s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' ) &&
				!( t[j] == 'a' || t[j] == 'e' || t[j] == 'i' || t[j] == 'o' || t[j] == 'u' )) ||
				(!(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' ) &&
				 ( t[j] == 'a' || t[j] == 'e' || t[j] == 'i' || t[j] == 'o' || t[j] == 'u' )))
		{
			cout << "No" << endl;
			return 0;
		}
	}
	cout << "Yes" << endl;
	return 0;
}
