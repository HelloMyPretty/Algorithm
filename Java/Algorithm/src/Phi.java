import java.beans.Visibility;
import java.nio.file.ProviderMismatchException;
import java.util.Arrays;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

public class Phi {
	static int euler(int n) {
		int m = (int) Math.sqrt(0.5 + n);
		int ans = n;
		for (int i = 2; i <= m; i++) {
			if (n % i == 0) {
				ans = ans / i * (i - 1);
				while (n % i == 0)
					n /= i;
			}
		}

		if (n > 1)
			ans = ans / n * (n - 1);
		return ans;
	}

	static int maxn = (int) 1e5 + 5;
	static int phi[] = new int[maxn];
	static int prime[] = new int[maxn];
	static boolean vis[] = new boolean[maxn];

	static int table(int n) {
		// 计算1~n的所有欧拉函数,返回1~n以内素数的个数
		// prime存储1~n的所有素数，phi存储1~n的所有欧拉值
		phi[1] = 1;
		int tot = 0;
		for (int i = 2; i <= n; i++) {
			if (!vis[i]) {
				prime[tot++] = i;
				phi[i] = i - 1;
			}
			for (int j = 0; j < tot; j++) {
				if (i * prime[j] > n)
					break;
				vis[i * prime[j]] = true;
				if (i % prime[j] == 0) {
					phi[i * prime[j]] = phi[i] * prime[j];
					break;
				} else
					phi[i * prime[j]] = phi[i] * (prime[j] - 1);
			}
		}
		return tot;
	}

	static void table2(int n) {
		// 计算1~n的欧拉函数
		phi[1] = 1;
		for (int i = 2; i <= n; i++) {
			if (phi[i] == 0) {
				for (int j = i; j <= n; j += i) {
					if (phi[j] == 0)
						phi[j] = j;
					phi[j] = phi[j] / i * (i - 1);
				}
			}
		}
	}

	static int powMod(int a, int b, int m) {
		int ans = 1;
		for (; b != 0; b >>= 1) {
			if (b % 2 == 1)
				ans = (ans * a) % m;
			a = (a * a) % m;
		}
		return ans;
	}

	static int inv(int a, int m) {
		return powMod(a, m - 2, m);
	}

	public static void main(String[] args) {
		System.out.println(inv(5, 3));
	}
}
