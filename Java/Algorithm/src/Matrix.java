
public class Matrix {
	 int n; 								// ��������������Ǿ�̬��
	 long matrix[][] ;		//�����Ǿ�̬��
	 public Matrix(int n) {
		this.n=n;
		 matrix=new long[n][n];
	}
	 Matrix multi(Matrix rhs) {				//�����Ǿ�̬��
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

	Matrix pow(Matrix M, long m) {	//���Ǿ�̬��
		// �������M��m����	
		Matrix ans = new Matrix(n);
		for (int i = 0; i < M.n; i++) // ���쵥λ����
			ans.matrix[i][i] = 1;
		for (; m > 0; m >>= 1) {
			if ((m & 1) == 1)
				ans = ans.multi(M);
			M = M.multi(M);
		}
		return ans;
	}
	public static void main(String args[]) {
		//����ȫ1����
		Matrix input=new Matrix(2);
		for(int i=0;i<input.n;i++)
			for(int j=0;j<input.n;j++)
				input.matrix[i][j]=1;
		//����3����
		Matrix ans=input.pow(input, 3);
		for(int i=0;i<input.n;i++)
			for(int j=0;j<input.n;j++)
				System.out.println(ans.matrix[i][j]);
	}
}