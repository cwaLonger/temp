package javaCoding.builder;

public class Main {

	public static void main(String[] args) {

		PenProduct pen = new PenProduct.Builder().color("white").mm(1).price(500).makeCompany("monami").build();
		System.out.println(pen.getColor());
		System.out.println(pen.getMm());
		System.out.println(pen.getPrice());
		System.out.println(pen.getMakeCompany());
		System.out.println(pen.getDistributeCompany());
		
		
	}

}
