package deadlock.deadlockRefactor;

public class Main {
	public static void main(String[] args){
		// Inint Resource
		Resource resource1 = new Resource("i love steak");
		Resource resource2 = new Resource("outback steak house");

		// Init Process 
		Process process1 = new Process("Process1");
		Process process2 = new Process("Process2");

		process1.shouldAct();
		process2.shouldAct();

		
		// DeadLock Condition 2 : Hold and Wait
		System.out.println(" Set Resource \n");
		process1.shouldSetResource(resource1);
		process2.shouldSetResource(resource2);

		localSleep(500);
		
		System.out.println("\n\n\n Print \n");
		System.out.println(process1.getResource());
		System.out.println(process2.getResource());

		localSleep(500);
		
		// DeadLock Condition 4 : Circular Wait
		System.out.println("\n\n\n DeadLock \n");
		process1.shouldSetResource(resource2);
		process2.shouldSetResource(resource1);
		
		
		// Resource2 Free
		localSleep(5000);
		process2.destroyAll();
		
	}
	
	private static void localSleep(int time){
		// start�? ?��?�� run?�� ?��?��?��?�� main thread�? ?��?�� 멈춤.
		new Thread(){
			public void run(){
				try {
					sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.run();		
	}
	
	
	// 리팩?��링을 ?��면서 ?��?? ?��.
	// 1. Resource?��?�� Process = null?�� ?��각없?�� ?��?��?��?��?�� 깊�? 복사�? ?��뤄�?�? ?��?? ?��?��?�� ?��치에 감사?���? ?��?��?��???��.
	// 2. 콘솔창이 ?���? ?��?��?�� Resource�?분에?�� println ?��?��?��?�� 것을 �??��?��???��.
	// 3. 로그�? ?���? 콘솔?�� ?�� 깔끔?��보이겠�?�? ?���? ?��?�� 미숙?��?�� ?��?��?���? ?��?��?��.
	// 4. Process ?���??�� Thread Queue�? 만들?�� destroyAll?���? Thread�? ?�� 멈추�? ?��.
}
