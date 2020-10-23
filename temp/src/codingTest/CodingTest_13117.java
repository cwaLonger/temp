package codingTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/13117
public class CodingTest_13117 {
	public static void main(String[] args){
		// init variable
		BufferedReader br = null;
		StringTokenizer st = null;
		@SuppressWarnings("unused")
		int length, goal;
		double[][] people;		
		File file = new File("C:/Temp/input_13117.txt");
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			//data input
			st = new StringTokenizer(br.readLine(), " ");
			length = Integer.valueOf(st.nextToken());
			goal = Integer.valueOf(st.nextToken());
			
			people = new double[length][3];
			for(int i = 0 ; i < length ; i++){
				st = new StringTokenizer(br.readLine(), " ");
				people[i][0] = Double.valueOf(st.nextToken());
				people[i][1] = Double.valueOf(st.nextToken());
				people[i][2] = Double.valueOf(st.nextToken());
			}

			for(int i = 0 ; i < length ; i++){
				System.out.print(people[i][0] + " ");
				System.out.print(people[i][1] + " ");
				System.out.print(people[i][2] + "\n");
			}
			
			
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
