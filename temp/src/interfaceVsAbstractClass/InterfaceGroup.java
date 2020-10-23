package interfaceVsAbstractClass;

public class InterfaceGroup {
	public interface AInterface {
		public default void interfaceMethod(){
			System.out.println("AInterface Method");
		}
	}

	public interface BInterface {
		public default void interfaceMethod(){
			System.out.println("BInterface Method");
		}
	}

	public interface CInterface {
		public void interfaceMethod();
	}
}
