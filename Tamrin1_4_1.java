import java.util.Scanner;
import java.lang.Math;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Tamrin1_4_1 {
	public static void main(String[] args) {
		double xPosition=0,yPosition=0,goalDistance1=999,goalDistance2=0,distanceFromRobot1=999,distanceFromRobot2=0;
		int noise=0,goal=0;
		boolean shootMode=false;
		Pattern pattern=Pattern.compile("#forward,x=(\\d+),y=(\\d+),distance=(\\d+)#");
		Matcher matcher;
		Scanner scanner=new Scanner(System.in);
		
		String data=scanner.nextLine();
		String[] splittedData=data.split("@");
		
		for(String analyzer:splittedData) {
			if(noise<200) {
			matcher=pattern.matcher(analyzer);
			if(analyzer.matches("#forward,x=(\\d+),y=(\\d+),distance=(\\d+)#")) {
				noise=0;
				if(matcher.find()) {
					xPosition=Integer.parseInt(matcher.group(1));
					yPosition=Integer.parseInt(matcher.group(2));
					distanceFromRobot2=Integer.parseInt(matcher.group(3));
				}
				if(distanceFromRobot1<10) shootMode=true;
				
				goalDistance2=Math.hypot(xPosition,yPosition)-distanceFromRobot2;
				
				if(goalDistance2<goalDistance1) {
					if(goalDistance2<=10 && shootMode) {
						goal++;
						shootMode=false;
					}
				}
				else shootMode=false;
				
				goalDistance1=goalDistance2;
				distanceFromRobot1=distanceFromRobot2;
			
			}
			else {
				noise+=analyzer.length();
			}
			}
			else break;
		}
		System.out.println(goal);
	}

}
