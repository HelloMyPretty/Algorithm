#include<bits/stdc++.h>
using namespace std;
const int maxn = 3e5 + 5;
bool vis[maxn];
vector<int>edge[maxn];
struct Node
{
	int red = 0, blue = 0, black = 0;
	Node(int a, int b, int c)
	{
		red = a;
		blue = b;
		black = c;
	}
} node[maxn];
void dfs(int v){
	for(int i=0;i<edge[v].size();i++){
		int cur=edge[v][i];
		if(vis[cur]) continue;
		vis[cur]=1;
 	}

}
int main(int argc, char const *argv[])
{
	int n;
	cin >> n;
	for(int i = 1; i <= n; i++)
	{
		int color;
		cin >> color;
		if(color == 0)
		{
			node[i] = Node(1, 0, 0);
		}
		else if(color == 1)
		{
			node[i] = Node(0, 1, 0);
		}
		else node[i] = Node(0, 0, 1);
	}
	for(int i = 1; i < n; i++)
	{
		int u, v;
		cin >> u >> v;
		edge[u].push_bakc(v);
		edge[b].push_bakc(u);
	}
	return 0;
}