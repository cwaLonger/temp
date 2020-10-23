package temp;

public class StI {
	private static String binP = "^0b";
	private static String octP = "^(.o*)";
	private static String hexP = "^(.x*)";
	
	public static int convertInt(String str){
		if(str.matches(binP))
			System.out.println("binP");
		else if(str.matches(octP))
			System.out.println("octP");
		else if(str.matches(hexP))
			System.out.println("hexP");
		else {
			System.out.println("zz");
		}
		
		return 1;
	}
	
	public static void foo(){
		System.out.println("0b00000000".matches(binP));
	}
}
