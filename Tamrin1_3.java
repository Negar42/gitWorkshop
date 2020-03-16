import java.util.Scanner;

public class Tamrin1_3 {
	public static void floyd_warshell(int[][] edge) {
		for(int i=0;i<11;i++) {
			for(int j=0;j<11;j++) {
				for(int k=0;k<11;k++) {
					if(edge[j][k]>edge[j][i]+edge[i][k]) {
						edge[j][k]=edge[j][i]+edge[i][k];
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		int[][] edge=new int[11][11];
		for(int i=0;i<11;i++) {
			for(int j=0;j<11;j++) {
				edge[i][j]=9999;
				}
			edge[i][i]=0;
			}
		Scanner s=new Scanner(System.in);
		int a1,a2;
		int t=s.nextInt();
		int n=s.nextInt();
		for(int i=0;i<n;i++) {
			a1=s.nextInt();
			a2=s.nextInt();
			edge[a1-1][a2-1]=edge[a2-1][a1-1]=t;
		}
		floyd_warshell(edge);
		System.out.println(90/edge[0][10]);
		}
		
		
	}

