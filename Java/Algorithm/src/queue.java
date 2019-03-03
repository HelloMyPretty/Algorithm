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
	        while(t >= h && a[q[t]] >= a[i]) //从队首开始抛出所有大于等于a[i]的元素下标，使得队首元素最大
	            t--;                          //将>号改为<实现递减单调栈
	        q[++t] = i;                         //a[i]入队
	        if(i+m-1<=n)              //区间长度达到m
	        {
	            if(q[h] == i + m )
	                h++;    		//队尾元素不再序列内，要抛出
	            for(int j = h; j <= t; j++)     //输出单调队中的元素
	                System.out.printf("%d ", a[q[j]]);
	            System.out.printf("max:%d  len:%d\n",a[q[h]],t-h+1);
	        }
	    }
	}
}
