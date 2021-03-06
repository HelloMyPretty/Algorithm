package ���߽�;

import java.util.Arrays;

public class ���ľ {
	// boolean[] vis = new boolean[10];
	int map[][] = new int[5][5];
	int ans;

	void print() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}


	void dfs(int floor, boolean[] vis) {
		if (floor == 5) {
			ans++;
			print();
			return;
		}
		boolean v[] = vis;
		int i = 1;
		label: for (int j = 0; j < 10;j++) {
			if(vis[j]) continue;
			for (; i <= floor; ) {
				if (!vis[j] && map[floor - 1][i - 1] < j && map[floor - 1][i] < j) {
					vis[j] = true;
					map[floor][i] = j;
					
					if (i == floor) {
						dfs(floor + 1, vis);
						vis = v;
						i=1;
						continue label;
					}
					i++;
					continue label;
				}
				break;
			}
		}
	}

	public static void main(String[] args) {

		���ľ test = new ���ľ();

		for (int i = 0; i < 10; i++) {
			boolean[] vis = new boolean[10];
			vis[i] = true;
			test.map[1][1] = i;
			test.dfs(2, vis);
		}
	}
}
