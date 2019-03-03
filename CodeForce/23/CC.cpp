#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 100005;

int pos[maxn] = {1, 8, 5, 12, 43, 2, 7};
ll ff(int l, int r)         //查找pos[i] 在[l,r]内的数
{
    int left = lower_bound(pos, pos + 7, l) - pos;
    int right = lower_bound(pos, pos + 7, r + 1) - pos;
    cout<<left<<' '<<right<<endl;
    return right - left ;

}
int main(int argc, char const *argv[])
{
    sort(pos, pos + 7);
    int l, r;
    while(1)
    {
        cin >> l >> r;
        cout << ff(l, r) << endl;
    }
    return 0;
}
