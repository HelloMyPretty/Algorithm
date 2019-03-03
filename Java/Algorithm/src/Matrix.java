
public class Matrix {
	 int n; 								// 矩阵阶数，不能是静态的
	 long matrix[][] ;		//不能是静态的
	 public Matrix(int n) {
		this.n=n;
		 matrix=new long[n][n];
	}
	 Matrix multi(Matrix rhs) {				//不用是静态的
		Matrix ans = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				if (matrix[i][j] != 0) {
					for (int k = 0; k < n; k++)
						ans.matrix[i][k] += matrix[i][j] * rhs.matrix[j][k];
				}
		}
		return ans;
	}

	Matrix pow(Matrix M, long m) {	//不是静态的
		// 计算矩阵M的m次幂	
		Matrix ans = new Matrix(n);
		for (int i = 0; i < M.n; i++) // 构造单位矩阵
			ans.matrix[i][i] = 1;
		for (; m > 0; m >>= 1) {
			if ((m & 1) == 1)
				ans = ans.multi(M);
			M = M.multi(M);
		}
		return ans;
	}
	public static void main(String args[]) {
		//构造全1矩阵
		Matrix input=new Matrix(2);
		for(int i=0;i<input.n;i++)
			for(int j=0;j<input.n;j++)
				input.matrix[i][j]=1;
		//计算3次幂
		Matrix ans=input.pow(input, 3);
		for(int i=0;i<input.n;i++)
			for(int j=0;j<input.n;j++)
				System.out.println(ans.matrix[i][j]);
	}
}
