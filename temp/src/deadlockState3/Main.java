package deadlockState3;

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
		
		process1.shouldAct();
		process2.shouldAct();
		
		new Thread(){
			public void run(){
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					resource2.freeProcess();
				}
				
			}
		}.start();
		
		// 5초 후에 잠금해제
		// 현재 Resource는 Process 정보가 없지만 Process는 Resource 정보가 있음. 이를 해결해줘야함
		// 콘솔이 너무 지저분하게 떠서 이를 정리해줘야함.
	}
}
