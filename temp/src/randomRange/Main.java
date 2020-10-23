package randomRange;

public class Main {
	public static void main(String[] args){
		for(int i = 0 ; i < Integer.MAX_VALUE ; i++){
			if(i % 10000000 == 0)
				System.out.println("current i is " + i);
			double tmp = Math.random();
			if(tmp == 0 || tmp ==1){
				System.out.println("tmp is 0 or 1 in i is " + i + " and tmp is " + tmp);
				break;
			}
		}
	}
}
