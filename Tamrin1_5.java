import java.util.Scanner;
import java.lang.System;
import java.lang.StringBuilder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Tamrin1_5 {
	static StringBuilder message;
	static String operation;
	static String[] splittedoperation;
	static Pattern p;
	static Matcher m;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		message=new StringBuilder(s.nextLine());
		
		
		while(true) {
			operation=s.nextLine();
			operation=operation.trim();
			if(operation.equals("mul")) {
				mulMethod();
				
			}
			else if(operation.equals("add")) {
				addMethod();
			}
			else if(operation.equals("sub")) {
				subMethod();
			}
			else if(operation.startsWith("sum ")) {
				splittedoperation=operation.split(" ");
				if(splittedoperation.length==3 && splittedoperation[1].matches("\\d+") && splittedoperation[2].matches("-f|-b")) {
					sumMethod();
				}
				else {
					printCommandError();
				}
			}
			else if(operation.startsWith("gcd ")) {
				splittedoperation=operation.split(" ");
				if(splittedoperation.length==3 && splittedoperation[1].matches("\\d+") && splittedoperation[2].matches("-f|-b")) {
					gcdMethod();
				}
				else {
					printCommandError();
				}
				
			}
			else if(operation.startsWith("replace ")) {
				splittedoperation=operation.split(" ");
				if(splittedoperation.length==4 && splittedoperation[3].matches("\\d+")) {
					replaceMethod();
				}
				else {
					printCommandError();
				}
				System.out.println(message);
				
				
			}
			else if(operation.startsWith("count_entail ")) {
				splittedoperation=operation.split(" ");
				if(splittedoperation.length==2) {
					count_entailMethod();
				}
				else {
					printCommandError();
				}
				
				
			}
			else if(operation.startsWith("insert ")) {
				splittedoperation=operation.split(" ");
				if(splittedoperation.length==2 || (splittedoperation.length==3 && splittedoperation[2].matches("\\d+"))) {
					insertMethod();
					System.out.println(message);
				}
				else {
					printCommandError();
				}
				
			}
			else if(operation.startsWith("delete ")) {
				splittedoperation=operation.split(" ");
				if(splittedoperation.length==2 || splittedoperation.length==3) {
					p=Pattern.compile(splittedoperation[1]);
					m=p.matcher(message);
					if(m.find()) {
						deleteMethod();
						System.out.println(message);
					}
					else {
						printSuitableError();
					}
				}
				else {
					printCommandError();
				}
				
			}
			else if(operation.equals("print")) {
				System.out.println(message);
			}
			else if(operation.equals("end")) {
				System.out.println("END OF PROGRAM");
				System.exit(0);
				
			}
			else {
				printCommandError();
			}
		}
	}
	
	
	static void mulMethod() {
		int a1 = 0,a2 = 0;
		p=Pattern.compile("(-?\\d+)[^0-9 ^-]+(-?\\d+)(.*)");
		m=p.matcher(message);
		if(m.find()) {
			a1=Integer.parseInt(m.group(1));
			a2=Integer.parseInt(m.group(2));
			message=message.replace(message.indexOf(m.group(1)), message.indexOf(m.group(3)), Integer.toString(a1*a2));
			System.out.println(message);
		}
		else {
			printSuitableError();
		}
		
	}
	
	
	static void addMethod() {
		int a1 = 0,a2 = 0;
		p=Pattern.compile("(-?\\d+)[^0-9 ^-]+(-?\\d+)(.*)");
		m=p.matcher(message);
		if(m.find()) {
			a1=Integer.parseInt(m.group(1));
			a2=Integer.parseInt(m.group(2));
			message=message.replace(message.indexOf(m.group(1)), message.indexOf(m.group(3)), Integer.toString(a1+a2));
			System.out.println(message);
		}
		else {
			printSuitableError();
		}


}
	
	
	static void subMethod() {
		int a1 = 0,a2 = 0;
		p=Pattern.compile("(-?\\d+)[^0-9 ^-]+(-?\\d+)(.*)");
		m=p.matcher(message);
		if(m.find()) {
			a1=Integer.parseInt(m.group(1));
			a2=Integer.parseInt(m.group(2));
			message=message.replace(message.indexOf(m.group(1)), message.indexOf(m.group(3)), Integer.toString(a1-a2));
			System.out.println(message);
		}
		else {
			printSuitableError();
		}


}
	
	
	static void sumMethod() {
		int sum=0,counter=0,found=0;
		
		p=Pattern.compile("(-?\\d+)");
		m=p.matcher(message);
		
		while(m.find()) {
			found++;
		}
		
		if(found>=Integer.parseInt(splittedoperation[1])) {
			int[] nums =new int[found];
			m=p.matcher(message);
		while(m.find()) {
			nums[counter++]=Integer.parseInt(m.group());
		}
		if(splittedoperation[2].contentEquals("-b")) {
			for(int i=0;i<Integer.parseInt(splittedoperation[1]);i++) {
				sum+=nums[i];
			}
		}
		else {
			for(int i=0;i<Integer.parseInt(splittedoperation[1]);i++) {
				sum+=nums[nums.length-1-i];
			}
		}
		message.append("S"+Integer.toString(sum)+"S");
		}
		else {
			printSuitableError();
		}
	}
	
	
	static void gcdMethod() {
		int gcd=0,counter=0,found=0;
		
		p=Pattern.compile("\\d+");
		m=p.matcher(message);
		
		while(m.find()) {
			found++;
		}
			
		if(found>=Integer.parseInt(splittedoperation[1])) {
			int[] nums=new int[found];
			m=p.matcher(message);
			while(m.find()) {
			nums[counter++]=Integer.parseInt(m.group());
		}
			
			if(splittedoperation[2].contentEquals("-b")) {
				for(int i=0;i<Integer.parseInt(splittedoperation[1]);i++) {
				
				gcd=findgcd(nums[i],gcd);
				
				if(gcd==1) break;
			}
			}
		
			else {
			for(int i=0;i<Integer.parseInt(splittedoperation[1]);i++) {
				gcd=findgcd(nums[nums.length-1-i],gcd);
				
				if(gcd==1) break;
			}
		}
		message.append("G"+Integer.toString(gcd)+"G");
		}
		
		else {
			printSuitableError();
		}
		
	}
	
	
	static int findgcd(int a,int b) {
	
		if(b==0) return a;
	
		else return findgcd(b,a%b);
		
	}
	
	
	static void replaceMethod() {
		p=Pattern.compile(splittedoperation[1]);
		m=p.matcher(message);
		
		for(int i=0;i<Integer.parseInt(splittedoperation[3]);i++) {
			
			if(!m.find()) {
				break;
			}
			message=new StringBuilder(m.replaceFirst(splittedoperation[2]));
			m=p.matcher(message);
		}
		
	}
	
	
	static void count_entailMethod() {
		int messLenght=message.length();
		int pattLenght=splittedoperation[1].length();
		int j,occure=0;
		
		for(int i=0;i<=messLenght-pattLenght;i++) {
			
			for(j=0;j<pattLenght;j++) {
			
				if(message.charAt(i+j)!=splittedoperation[1].charAt(j)) {
					break;
				}
			}
				if(j==pattLenght) {
					occure++;
				}
		}
		if(occure==0) {
			printSuitableError();
		}
		else {
		System.out.println(message.append("C"+Integer.toString(occure)+"C"));
		}
	}
	
	
	static void insertMethod() {
		
		if(splittedoperation.length==3) {
			if(Integer.parseInt(splittedoperation[2])<=message.length()) {
			message.insert(Integer.parseInt(splittedoperation[2]),splittedoperation[1]);
			}
		}
	
		else {
			message.append(splittedoperation[1]);
		}
		
	}
	
	
	static void deleteMethod() {
		if(message.toString().contains(splittedoperation[1])) {
		if(splittedoperation.length==2) {
			message.replace(message.lastIndexOf(splittedoperation[1]), message.indexOf(splittedoperation[1])+splittedoperation[1].length(), "");
		}
		
		else if(splittedoperation[2].contentEquals("-f")) {
			message.replace(message.lastIndexOf(splittedoperation[1]), message.lastIndexOf(splittedoperation[1])+splittedoperation[1].length(), "");
		}
		else {
			printCommandError();
		}
		}
		else {
			printSuitableError();
		}
	}
	
	
	static void printSuitableError() {
		System.out.println("CANNOT PERFORM THE COMMAND SUCCESSFULLY");
	}
	
	
	static void printCommandError() {
		System.out.println("THE COMMAND IS INVALID");
	}
	}

