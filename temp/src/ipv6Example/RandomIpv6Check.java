package ipv6Example;


public class RandomIpv6Check {	
	private String destAddress;

	public RandomIpv6Check(){}
	public RandomIpv6Check(String destAddress){ this.destAddress = destAddress; }
	
	public void start(int num){
		int round = num<=0 ? Integer.MAX_VALUE : num;
		for(int i = 0 ; i < round ; i++){
			if(i % 1000000 == 0)
				System.out.println("checking... " + i);
			if(destAddress.equals(randomIpv6())){
				System.out.println("ipv6 is same in index " + i);
				return;
			}
		}
		System.out.println("cannot find a same address.");
		System.out.println(randomIpv6());
	}

	private String randomHexa(){
		String ipv6First = Integer.toHexString((int)(Math.random()*16));
		String ipv6Second = Integer.toHexString((int)(Math.random()*16));
		String ipv6Third = Integer.toHexString((int)(Math.random()*16));
		String ipv6Fourth = Integer.toHexString((int)(Math.random()*16));
		String randomVal = ipv6First + ipv6Second+ ipv6Third+ ipv6Fourth;
		return randomVal;
	}

	private String randomIpv6(){
		String ipv6 = "";
		for(int i = 0 ; i < 8 ; i++){
			ipv6 += randomHexa();
			if(i != 7) ipv6 += ":";
		}
		return ipv6;
	}
	public String getDestAddress() {
		return destAddress;
	}

	public void setDestAddress(String destAddress) {
		this.destAddress = destAddress;
	}
}
