package tamrinat;

import java.util.Scanner;

public class Tamrin1_3_2 {
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		int firstVertex,secondVertex,inf=1000;
		int timeInterval,edgeNumber;
		
		int[][] distances=new int[11][11];
		
		for(int i=0;i<11;i++) {
			for(int j=0;j<11;j++) {
				distances[i][j]=inf;
				if(i==j) {
					distances[i][j]=0;
				}
			}
			
		}
		
		edgeNumber=scanner.nextInt();
		timeInterval=scanner.nextInt();
		
		for(int counter=0;counter<edgeNumber;counter++) {
			firstVertex=scanner.nextInt()-1;
			secondVertex=scanner.nextInt()-1;
		}
	}

}
