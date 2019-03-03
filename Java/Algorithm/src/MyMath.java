
public class MyMath {
	static long GCD(long a, long b) {
		return b == 0 ? a : GCD(b, a % b);
	}

	static long lcm(long a, long b) {
		return a / GCD(a, b) * b;
	}

	static int qGCD(int a, int b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		if ((a & 1) == 0 && 0 == (b & 1))
			return qGCD(a >> 1, b >> 1) << 1;
		else if ((b & 1) == 0)
			return qGCD(a, b >> 1);
		else if ((a & 1) == 0)
			return qGCD(a >> 1, b);
		else
			return qGCD(Math.abs(a - b), Math.min(a, b));
	}

	static long alonggcd(long arr[]) {
		int n = arr.length;
		long e, gcd, k;
		k = gcd = 1;
		for (int i = 0; i < n; i++) {
			e = arr[i];
			gcd = k / GCD(e, k) * e;
			k = gcd;
		}
		return gcd;
	}

	static int[] exGCD(int a, int b) { // 扩展欧几里得
										// triple[0]=d,triple[1]=x,triple[2]=y
		int[] triple = new int[3];
		if (b == 0) {
			triple[0] = a;
			triple[1] = 1;
			triple[2] = 0;
			return triple;
		}
		int[] t = exGCD(b, a % b);
		triple[0] = t[0];
		triple[1] = t[2];
		triple[2] = t[1] - (a / b) * t[2];
		return triple;
	}

	static int inv(int a, int n) {// 计算a关于n的逆元
		int triple[] = exGCD(a, n);
		return triple[0] == 1 ? (triple[1] + n) % n : 0;
	}

	public static void main(String[] args) {
		System.out.println(inv(3, 4));
	}
}
