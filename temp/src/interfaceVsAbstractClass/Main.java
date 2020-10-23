package interfaceVsAbstractClass;

import interfaceVsAbstractClass.SubInterfaceClassGroup.ASubInterfaceClass;
import interfaceVsAbstractClass.SubInterfaceClassGroup.BSubInterfaceClass;
import interfaceVsAbstractClass.SubInterfaceClassGroup.CSubInterfaceClass;
import interfaceVsAbstractClass.SubInterfaceClassGroup.OverrideSubInterfaceClass;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubInterfaceClassGroup sfcg = new SubInterfaceClassGroup();

		ASubInterfaceClass asic = sfcg.getASubInterfaceClass();
		BSubInterfaceClass bsic = sfcg.getBSubInterfaceClass();
		CSubInterfaceClass csic = sfcg.getCSubInterfaceClass();
		OverrideSubInterfaceClass osic = sfcg.getOverrideSubInterfaceClass();
		
		asic.interfaceMethod();
		bsic.interfaceMethod();
		csic.interfaceMethod();
		osic.interfaceMethod();
	}

}