import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.Scanner;

public class queue {
	static int N = 10000010;
	public static void main(String args[])
	{
	    Scanner cin=new Scanner(new BufferedInputStream(System.in));
		int h, t;
	    int a[]=new int[100], q[]=new int[100];
	    int n, m;
	    n=cin.nextInt();
	    m=cin.nextInt();
	    for(int i = 1; i <= n; i++)
	       a[i]=cin.nextInt();
	    h = 1;
	    t = 0;
	    for(int i = n; i >0; i--)
	    {
	        while(t >= h && a[q[t]] >= a[i]) //�Ӷ��׿�ʼ�׳����д��ڵ���a[i]��Ԫ���±꣬ʹ�ö���Ԫ�����
	            t--;                          //��>�Ÿ�Ϊ<ʵ�ֵݼ�����ջ
	        q[++t] = i;                         //a[i]���
	        if(i+m-1<=n)              //���䳤�ȴﵽm
	        {
	            if(q[h] == i + m )
	                h++;    		//��βԪ�ز��������ڣ�Ҫ�׳�
	            for(int j = h; j <= t; j++)     //����������е�Ԫ��
	                System.out.printf("%d ", a[q[j]]);
	            System.out.printf("max:%d  len:%d\n",a[q[h]],t-h+1);
	        }
	    }
	}
}