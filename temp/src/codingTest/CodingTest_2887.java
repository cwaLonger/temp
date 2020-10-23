package codingTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

// https://www.acmicpc.net/problem/2887
public class CodingTest_2887 {
	public static void main(String[] args){
		BufferedReader br = null;
		StringTokenizer st = null;
		int length;
		short[][] planet;
		Vector<Vector<Integer>> result = new Vector<Vector<Integer>>();
		File file = new File("C:\\Temp\\input.txt");
		try {
			br = new BufferedReader(new FileReader(file));
			
			//data Input
			length = Integer.valueOf(br.readLine());
			planet = new short[length][3];
			for(int i = 0 ; i < length ; i++){
				st = new StringTokenizer(br.readLine(), " ");
				planet[i][0] = Short.valueOf(st.nextToken());
				planet[i][1] = Short.valueOf(st.nextToken());
				planet[i][2] = Short.valueOf(st.nextToken());
			}
			
			//input Validate
			for(int i = 0 ; i < length ; i++) {
				for(int j = 0 ; j < 3 ; j++) 
					System.out.print(planet[i][j] + " ");
				System.out.println("");
			}
			
			
			// logical Section
			int smallest;
			int localSmallest, localIndex = 0;
			for(int i = 0 ; i < length ; i++) {
				smallest = Integer.MAX_VALUE;
				for(int j = 0 ; j < length ; j++) {
					if(i == j) continue;
					int gapX = Math.abs(planet[i][0] - planet[j][0]);
					int gapY = Math.abs(planet[i][1] - planet[j][1]);
					int gapZ = Math.abs(planet[i][2] - planet[j][2]);
					localSmallest = Math.min(Math.min(gapX, gapY), gapZ);
					if(localSmallest < smallest){
						smallest = localSmallest;
						localIndex = j;
					}
				}
				

				System.out.println(result);
				
				int resultSize = result.size();
				
				if(resultSize == 0) {
					Vector<Integer> tmp = new Vector<Integer>();
					tmp.add(localIndex);
					tmp.add(0);
					result.add(tmp);
				}
				for(int j = 0 ; j < resultSize; j++) {
					if(result.get(j).contains(localIndex)){
						result.get(j).add(localIndex);
					}
					else {
						Vector<Integer> tmp = new Vector<Integer>();
						tmp.add(localIndex);
						result.add(tmp);
					}
				}
				System.out.println("####"+smallest + "    " + localIndex);
			}
			
			System.out.println(result);
			
			
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
