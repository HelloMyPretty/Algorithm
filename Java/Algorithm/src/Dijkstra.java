import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Dijkstra {
	static class Edge{			//�洢�ߵ���Ϣ
		int from,to,dist;
		public Edge(int x,int y,int z) {
			from=x;
			to=y;
			dist=z;
		}
	}
	
	 static int maxn=10000;
	 int n,m;											//n�ǽ����Ŀ��m�Ǳ���Ŀ
	 ArrayList<Edge> edges=new ArrayList<>();			//����ıߵ���Ϣ�б�
	 ArrayList<Integer>[] gra=new ArrayList[maxn];		//�ڽӱ�
	 int[] dis=new int[maxn];							//��¼Դ�㵽ÿ����ľ��� 
	 int[] p=new int[maxn];								//��¼���·�е���һ����������Ѱ��·����
	 boolean inq[]=new boolean[maxn];					//��¼ĳ����Ƿ��ڶ�����
	 int cnt[]=new int[maxn];							//��¼һ������ڳ����ڶ����еĴ���
	 
	 void init() {										//��ʼ��
		edges=new ArrayList<>();
		 for(int i=1;i<=n;i++) {						//�����Ŵ�1��n
			gra[i]=new ArrayList<>();
			dis[i]=Integer.MAX_VALUE;					//��d[]ȫ����ʼ��Ϊ���ֵ
		}
	}
	
	void addEdge(int form,int to,int w) {
		edges.add(new Edge(form, to, w));
		gra[form].add(edges.size()-1);
	}
	
	boolean bellmanFord(int s) {
		Queue<Integer>queue=new ArrayDeque<>();			//��������ɳڲ����Ľ��
		dis[s]=0;
		inq[s]=true;
		queue.add(s);
		while(!queue.isEmpty()) {
			int cur=queue.poll();	
			inq[cur]=false;
			
			//�ɳڲ���
			for(int i=0;i<gra[cur].size();i++) {
				Edge e=edges.get(gra[cur].get(i));
				if(dis[cur]<Integer.MAX_VALUE&&dis[e.to]>dis[cur]+e.dist) {
					dis[e.to]=dis[cur]+e.dist;		//����cur���ڽӵ㵽Դ��ľ���
					p[e.to]=gra[cur].get(i);
					if(!inq[e.to]) {
						queue.add(e.to);			//ֻ�����ڶ����еĽ�����
						inq[e.to]=true;				//��ǵ�ǰ�ڵ��Ѿ��ڶ�����
						if(++cnt[e.to]>n)
							return false;			//һ�������Ӷ���n�α�Ȼ�и���
					}
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		Dijkstra test=new Dijkstra();
		int source;
		test.n=cin.nextInt();
		test.m=cin.nextInt();
		source=cin.nextInt();
		test.init();
		for(int i=0;i<test.m;i++)
		{
			int u,v,w;
			u=cin.nextInt();
			v=cin.nextInt();
			w=cin.nextInt();
			test.addEdge(u, v, w);
		}
		if(test.bellmanFord(source))
			System.out.println("YES");
		else System.out.println("NO");
		
	}
}