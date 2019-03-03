import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Dijkstra {
	static class Edge{			//存储边的信息
		int from,to,dist;
		public Edge(int x,int y,int z) {
			from=x;
			to=y;
			dist=z;
		}
	}
	
	 static int maxn=10000;
	 int n,m;											//n是结点数目，m是边数目
	 ArrayList<Edge> edges=new ArrayList<>();			//输入的边的信息列表
	 ArrayList<Integer>[] gra=new ArrayList[maxn];		//邻接表
	 int[] dis=new int[maxn];							//记录源点到每个点的距离 
	 int[] p=new int[maxn];								//记录最短路中的上一条弧，用于寻找路径。
	 boolean inq[]=new boolean[maxn];					//记录某结点是否在队列中
	 int cnt[]=new int[maxn];							//记录一个结点在出现在队列中的次数
	 
	 void init() {										//初始化
		edges=new ArrayList<>();
		 for(int i=1;i<=n;i++) {						//顶点编号从1到n
			gra[i]=new ArrayList<>();
			dis[i]=Integer.MAX_VALUE;					//将d[]全部初始化为最大值
		}
	}
	
	void addEdge(int form,int to,int w) {
		edges.add(new Edge(form, to, w));
		gra[form].add(edges.size()-1);
	}
	
	boolean bellmanFord(int s) {
		Queue<Integer>queue=new ArrayDeque<>();			//保存进行松弛操作的结点
		dis[s]=0;
		inq[s]=true;
		queue.add(s);
		while(!queue.isEmpty()) {
			int cur=queue.poll();	
			inq[cur]=false;
			
			//松弛操作
			for(int i=0;i<gra[cur].size();i++) {
				Edge e=edges.get(gra[cur].get(i));
				if(dis[cur]<Integer.MAX_VALUE&&dis[e.to]>dis[cur]+e.dist) {
					dis[e.to]=dis[cur]+e.dist;		//更新cur的邻接点到源点的距离
					p[e.to]=gra[cur].get(i);
					if(!inq[e.to]) {
						queue.add(e.to);			//只将不在队列中的结点入队
						inq[e.to]=true;				//标记当前节点已经在队列中
						if(++cnt[e.to]>n)
							return false;			//一个结点入队多于n次必然有负环
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
