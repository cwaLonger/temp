package temp;

public class A {
	static {
		System.out.println("static A");
	}
	{
		System.out.println("init A");
	}
}
