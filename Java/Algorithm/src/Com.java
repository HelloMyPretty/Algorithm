
public class Com {
	static int maxn; 
	static long inv[]=new long[maxn], fac[ ]=new long[maxn], facInv[ ]=new long[maxn];
	static int n = 100;
	static long P;
	static void f()
	{
		inv[1] = 1; fac[0] = facInv[0] = 1;
		for(int i = 1; i <= n; i++)
		{
			if(i != 1) inv[i] = (P - P / i) * inv[(int)P % i] % P;
			fac[i] = fac[i - 1] * i % P;
			facInv[i] = facInv[i - 1] * inv[i] % P;
		}
	}
	long C(int n, int m)
	{
		return fac[n] * facInv[m] % P * facInv[n - m] % P;
	}
//	static int lucas(int n, int m, int mod)
//	{
//		if(n < m) return 0;
//		int ans = 1;
//		//for(; m!=0; n /= mod, m /= mod) ans = 1L * ans * C(n % mod, m % mod, mod) % mod;
//		return ans;
//	}
	
}
