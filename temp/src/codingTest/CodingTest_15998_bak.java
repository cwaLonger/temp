package codingTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

//https://www.acmicpc.net/problem/15998
public class CodingTest_15998_bak {
	public static void main(String[] args){
		BufferedReader br = null;
		StringTokenizer st = null;
		int length;
		long trade, rest, bRest = 0, charge;
		File file = new File("C:/Temp/input_15998.txt");
		Vector<Integer> vi = new Vector<Integer>();

		// init variable		
		try {
			br = new BufferedReader(new FileReader(file));
			
			//data input
			length = Integer.valueOf(br.readLine());

			for(int i = 0 ; i < length ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				trade = Long.valueOf(st.nextToken());
				rest = Long.valueOf(st.nextToken());
				charge = rest - bRest - trade;
				if(trade > 0 || Math.abs(trade) < bRest) { }
				else if(vi.isEmpty()) {
					for(int j = 1 ; j <= charge ; j ++)
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
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
