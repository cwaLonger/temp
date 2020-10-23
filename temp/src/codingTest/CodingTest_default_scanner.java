package codingTest;

import java.util.Scanner;

public class CodingTest_default_scanner {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		System.out.println(str);
		scanner.close();
		
		
	}
}
