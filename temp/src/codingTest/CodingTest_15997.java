package codingTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15997
public class CodingTest_15997 {
	public static void main(String[] args){
		BufferedReader br = null;
		StringTokenizer st = null;
		String[][] expect = new String[6][5];		
		File file = new File("C:/Temp/input_15997.txt");

		// init variable		
		try {
			br = new BufferedReader(new FileReader(file));
			
			//data input
			br.readLine();
			
			for(int i = 0 ; i < 6 ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				expect[i][0] = st.nextToken();
				expect[i][1] = st.nextToken();
				expect[i][2] = st.nextToken();
				expect[i][3] = st.nextToken();
				expect[i][4] = st.nextToken();
			}
			System.out.printf("%6s %6s %6s %6s %6s\n", expect[0][0], expect[0][1], expect[0][2], expect[0][3], expect[0][4]);
			System.out.printf("%6s %6s %6s %6s %6s\n", expect[1][0], expect[1][1], expect[1][2], expect[1][3], expect[1][4]);
			System.out.printf("%6s %6s %6s %6s %6s\n", expect[2][0], expect[2][1], expect[2][2], expect[2][3], expect[2][4]);
			System.out.printf("%6s %6s %6s %6s %6s\n", expect[3][0], expect[3][1], expect[3][2], expect[3][3], expect[3][4]);
			System.out.printf("%6s %6s %6s %6s %6s\n", expect[4][0], expect[4][1], expect[4][2], expect[4][3], expect[4][4]);
			
			System.out.println(Long.MIN_VALUE);
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
