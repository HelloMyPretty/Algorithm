import java.util.Arrays;

public class FloydWarshell {
	static int maxn;
	int dis[][] = new int[maxn][maxn]; // Ȩֵ����,��ʼ��ΪINF,��dis[i][i]=0
	int path[][] = new int[maxn][maxn];//path[i][j]��¼i��j��·����j��ǰ����
	int n; // n�����

	void init() {
		// Ȩֵ����Ԥ�������������0��n-1���
		Arrays.fill(dis, Integer.MAX_VALUE);
		Arrays.fill(path, 0);
		for (int i = 0; i < n; i++)
			dis[i][i] = 0;
	}

	void floyd() {
		for (int k = 0; k < n; k++)
		for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			if (dis[i][k] < Integer.MAX_VALUE && dis[k][j] < Integer.MAX_VALUE) // �����������������
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