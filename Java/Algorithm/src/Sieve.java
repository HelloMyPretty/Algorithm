import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Sieve {
	static int maxn = (int) 1e5 + 5;
	static boolean vis[] = new boolean[maxn];
	static int prime[] = new int[maxn];// Ҳ������ArrayList����
	static int tot = 0;

	static void sieve() {
		for (int i = 2; i < maxn; i++) {
			if (!vis[i])
				prime[tot++] = i;
			for (int j = 0; j < tot && i * prime[j] < maxn; j++) {
				vis[i * prime[j]] = true;
				if (i % prime[j] == 0)
					break;
			}
		}
	}

	static void addInteger(int n, int d, int exponent[]) {
		// ���Լ���һ����ʽ�� Ψһ�ֽ�ʽ,�������������
		// d=1ʱ��ʾnΪ���ӣ�d=-1ʱ��ʾnΪ��ĸ
		// exponent�洢��������ָ��

		for (int i = 0; i < prime.length; i++) {
			while (n % prime[i] == 0) {
				n /= prime[i];
				exponent[i] += d;
			}
			if (n == 1)
				break;
		}
	}

	static int divide(int n, int d, ArrayList<Integer> list) {
		// ����n���ж��ٸ�������d���������list��
		while (n % d == 0) {
			n /= d;
			list.add(d);
		}
		return n;
	}

	static ArrayList<Integer> divideAlong(int n) {
		// ��n��Ψһ�ֽ�ʽ
		ArrayList<Integer> list = new ArrayList<>();// �洢Ψһ�ֽ�ʽ
		int m = (int) Math.floor(Math.sqrt(n) + 0.5);
		for (int i = 2; i < m; i++) {
			if (n % i == 0)
				n = divide(n, i, list);
			if (n == 0)
				break;
		}
		if (n > 1)
			list.add(n);
		return list;
	}

	static int f(int n, int p) {
		// ���n����Ψһ�ֽ�ʽ��p��ָ��
		int exp = 0;
		while (n != 0) {
			exp += n / p;
			n = n / p;
		}
		return exp;
	}

	static void sieve2() {
		// ���1~maxn������
		vis[0] = vis[1] = true;
		for (int i = 2; i < maxn; i++) {
			if (!vis[i]) {
				prime[tot++] = i;
				if (i > maxn / i)
					continue;
				for (int j = i * i; j < maxn; j += i) {
					if (!vis[j])
						vis[j] = true;
				}
			}

		}
	}
	
	

	public static void main(String[] args) {
		ArrayList<Integer> list = divideAlong(110);
		System.out.println(list);
	}
}