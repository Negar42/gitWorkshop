import java.util.Scanner;

public class Tamrin1_1_1 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		StringBuilder str=new StringBuilder();
		int k=s.nextInt();
		int n=s.nextInt();
		
		for(int i=0;i<k;i++) {
			for(int j=1; j<=(n-i); j++)str.append(' ');
			for(int j=1;j<=((2*i)+1);j++)str.append('*');
			str.append('\n');
		}
		for(int i=k; i<=n;i++) {
			for(int j=1; j<=(n-i); j++)str.append(' ');
				for(int j=1;j<=k;j++)str.append('*');
				for(int j=1;j<=((2*(i-k))+1);j++)str.append(' ');
				for(int j=1;j<=k;j++)str.append('*');
				str.append('\n');
		}
		
		for(int i=(n-1); i>=k;i--) {
			for(int j=1; j<=(n-i); j++)str.append(' ');
				for(int j=1;j<=k;j++)str.append('*');
				for(int j=1;j<=((2*(i-k))+1);j++)str.append(' ');
				for(int j=1;j<=k;j++)str.append('*');
				str.append('\n');
		}
			for(int i=(k-1);i>=0;i--) {
				for(int j=1; j<=(n-i); j++)str.append(' ');
				for(int j=1;j<=((2*i)+1);j++) str.append('*');
				str.append('\n');
			}
			System.out.print(str);
	}

}
