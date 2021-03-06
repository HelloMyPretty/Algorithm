package B;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
	static class tuple {
		int x, y;

		@Override
		public boolean equals(Object obj) {
			return x == ((tuple) obj).x && y == ((tuple) obj).y;
		}

		public tuple(int a, int b) {
			x = a;
			y = b;
		}
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		int n = cin.nextInt();
		int ans = 1;
		tuple pre = new tuple(0, 0);
		tuple cur;
		for (int i = 1; i <= n; i++) {
			cur = new tuple(cin.nextInt(), cin.nextInt());
			int x = cur.x - pre.x;
			int y = cur.y - pre.y;
			ans += Math.min(x, y);
			if (x != y && cur.x == cur.y)
				ans++;
			if(x==y)
				pre = cur;
		}
		System.out.println(ans);
	}

}
