package interfaceVsAbstractClass;

import interfaceVsAbstractClass.InterfaceGroup.AInterface;
import interfaceVsAbstractClass.InterfaceGroup.BInterface;
import interfaceVsAbstractClass.InterfaceGroup.CInterface;

public class SubInterfaceClassGroup {
	// main method is static, but inner class is not
	public ASubInterfaceClass getASubInterfaceClass(){
		return new ASubInterfaceClass();
	}
	
	public BSubInterfaceClass getBSubInterfaceClass(){
		return new BSubInterfaceClass();
	}
	
	public CSubInterfaceClass getCSubInterfaceClass(){
		return new CSubInterfaceClass();
	}
	
	public OverrideSubInterfaceClass getOverrideSubInterfaceClass(){
		return new OverrideSubInterfaceClass();
	}
	
	
	
	public class ASubInterfaceClass implements AInterface {
		
	}

	public class BSubInterfaceClass implements BInterface {
		
	}

	public class CSubInterfaceClass implements CInterface {
		public void interfaceMethod() {
			System.out.println("CSubInterfaceClass method");
		}
	}

//	A, B Interface has a dafualt method.
//	If developer wanted to use this two interface, he must override the method.
//	Then, why we have to use interface instead of abstract class?
//	Or why multiple inheritance is not supported in Java?
	
//	public class ABSubInterfaceClass implements AInterface, BInterface{
//		
//	}
//	public class ACSubInterfaceClass implements AInterface, CInterface{
//		
//	}
//	public class BCSubInterfaceClass implements BInterface, CInterface{
//		
//	}
	
	public class OverrideSubInterfaceClass implements AInterface, BInterface, CInterface {
		@Override
		public void interfaceMethod(){
			System.out.println("OverrideSubInterfaceClass Method");
		}
	}
}
