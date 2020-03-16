import java.util.*;
public class Tamrin1_3_1 {
	
	static int inf=Integer.MAX_VALUE;
	
	public static int calculateDistance(int[][] edges) {
		int vertex;
		int[] dist=new int[11];
		boolean[] visited=new boolean[11];
		
		for(int i=0;i<11;i++) {
			dist[i]=inf;
			visited[i]=false;
		}
		dist[0]=0;
		
		for(int j=0;j<10;j++) {
			vertex=minDistance(dist,visited);
			visited[vertex]=true;
			for(int k=0;k<11;k++) {
				if (!visited[k] && edges[vertex][k]!=0 && dist[vertex] !=inf  
                        && dist[vertex]+edges[vertex][k] < dist[k]) 
					dist[k] = dist[vertex] + edges[vertex][k]; 
				} 
			}
		
		return dist[10];
		}
	
	
	
	public static int minDistance(int[] dist,boolean[] visited) {
		int minDistance=inf,vertexIndex=-1;
		for(int i=0;i<11;i++) {
			if(visited[i]==false && dist[i]<=minDistance) {
				minDistance=dist[i];
				vertexIndex=i;
			}
		}
		return vertexIndex;
	}
	
	
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int[][] edges=new int[11][11];
		for(int i=0;i<11;i++) {
			for(int j=0;j<11;j++) {
				edges[i][j]=0;
				}
			}
		
		int a1,a2;
		int t=scanner.nextInt();
		int n=scanner.nextInt();
		for(int i=0;i<n;i++) {
			a1=scanner.nextInt();
			a2=scanner.nextInt();
			edges[a1-1][a2-1]=edges[a2-1][a1-1]=t;
		}
		System.out.println(90/calculateDistance(edges));
	}
}
