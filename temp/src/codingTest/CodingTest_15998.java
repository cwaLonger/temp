package codingTest;

import java.util.Scanner;
import java.util.Vector;

//https://www.acmicpc.net/problem/15998
public class CodingTest_15998 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int length;
		long trade, rest, bRest = 0, charge;
		Vector<Long> vi = new Vector<Long>();

		//data input
		length = Integer.valueOf(scanner.next());

		for(int i = 0 ; i < length ; i++) {
			trade = Long.valueOf(scanner.next());
			rest = Long.valueOf(scanner.next());
			charge = rest - bRest - trade;
			if(trade > 0 || Math.abs(trade) < bRest) { }
			else if(vi.isEmpty()) {
				for(long j = 1 ; j <= charge ; j ++)
					if(charge%j == 0)
						vi.add(j);
			}
			else {
				for(int j = 0 ; j < vi.size() ; j++){
					if(rest >= vi.get(j)) {
						vi.remove(j--);
					}
					else if(vi.get(j) > charge)
						vi.remove(j--);
					else if(charge%vi.get(j) !=0)
						vi.remove(j--);
				}
			}
			bRest = rest;

		}
		
		if(vi.isEmpty())
			System.out.println("-1");
		else
			System.out.println(vi.get(vi.size()-1));

		scanner.close();
	}
}
