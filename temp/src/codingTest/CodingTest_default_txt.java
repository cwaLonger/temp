package codingTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

// url
public class CodingTest_default_txt {
	public static void main(String[] args){
		// init variable
		BufferedReader br = null;
		StringTokenizer st = null;
		int length;
		short[][] planet;		
		File file = new File("C:/Temp/input_number.txt");
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			//data input
			length = Integer.valueOf(br.readLine());
			planet = new short[length][3];
			for(int i = 0 ; i < length ; i++){
				st = new StringTokenizer(br.readLine(), " ");
				planet[i][0] = Short.valueOf(st.nextToken());
				planet[i][1] = Short.valueOf(st.nextToken());
				planet[i][2] = Short.valueOf(st.nextToken());
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
