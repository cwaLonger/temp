package deadlock.deadlockState2;

public class Main {
	public static void main(String[] args){
		Resource resource1 = new Resource("Resource1");
		Resource resource2 = new Resource("Resource2");
		
		resource1.setInformation("i love steak");
		resource2.setInformation("outback steak house");
		
		Process process1 = new Process("Process1");
		Process process2 = new Process("Process2");

		System.out.println(" Set Success \n");
		process1.setResource1(resource1);
		process2.setResource2(resource2);
		
		System.out.println("\n\n\n Set Failed \n");
		process1.setResource2(resource2);
		process2.setResource1(resource1);
		
		System.out.println("\n\n\n Print \n");
		System.out.println(process1.getResource1());
		System.out.println(process1.getResource2());
		System.out.println(process2.getResource1());
		System.out.println(process2.getResource2());

		System.out.println("\n\n\n DeadLock \n");
		process1.shouldSetResource2(resource2);
		process2.shouldSetResource1(resource1);
		
		// shouldSetResourceÎ°? 1Ï¥àÍ? Ïß??ÇòÍ≥? Í≥ÑÏÜç ?ï†?ãπ?ïòÍ≤? ?ñâ?èô
	}
}
