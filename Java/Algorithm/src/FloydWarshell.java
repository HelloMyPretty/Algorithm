import java.util.Arrays;

public class FloydWarshell {
	static int maxn;
	int dis[][] = new int[maxn][maxn]; // 权值矩阵,初始化为INF,令dis[i][i]=0
	int path[][] = new int[maxn][maxn];//path[i][j]记录i到j最路径上j的前驱点
	int n; // n个结点

	void init() {
		// 权值矩阵预处理，假设结点从0到n-1编号
		Arrays.fill(dis, Integer.MAX_VALUE);
		Arrays.fill(path, 0);
		for (int i = 0; i < n; i++)
			dis[i][i] = 0;
	}

	void floyd() {
		for (int k = 0; k < n; k++)
		for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			if (dis[i][k] < Integer.MAX_VALUE && dis[k][j] < Integer.MAX_VALUE) // 这样避免了溢出问题
			{
				if (dis[i][k] + dis[k][j] < dis[i][j]) {
					dis[i][j] = dis[i][k] + dis[k][j];
					path[i][j] = k;
				}
			}
	}
	void output(int i,int j) {
		if(path[i][j]==0) return;
		
		output(i, path[i][j]);
		System.out.println(path[i][j]);
		output(path[i][j], j);
	}

}
