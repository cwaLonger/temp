package codingTest.clear;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

// https://www.acmicpc.net/problem/1316
//샤미드(Vaporeon), 쥬피썬더(Jolteon), 부스터(Flareon) 
public class CodingTest_1316 {
	public static void main(String[] args){
		// init variable
		BufferedReader br = null;
		int length, groupWord = 0;
		String target;
		char buf, c;
		Vector<Character> has = new Vector<Character>();
		File file = new File("C:/Temp/input_1316_2.txt");
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			//data input
			length = Integer.valueOf(br.readLine());
			groupWord = length;
			for(int i = 0 ; i < length ; i++){
				has.clear();
				target = br.readLine();
				buf = target.charAt(0);
				has.add(buf);
				for(int j = 1 ; j < target.length(); j++) {
					c = target.charAt(j);
					if(c == buf)
						continue;
					else if(!has.contains(c))
						has.add(c);
					else {
						groupWord--;
						break;
					}
					buf = c;
				}
			}
			
			System.out.println(groupWord);
			
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
