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
		// startκ°? ?? run? ?¬?©?΄? main threadλ₯? ? ? λ©μΆ€.
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
	
	
	// λ¦¬ν©? λ§μ ?λ©΄μ ??? ? .
	// 1. Resource?? Process = null? ?κ°μ?΄ ?¬?©???° κΉμ? λ³΅μ¬κ°? ?΄λ€μ?μ§? ??? ?°?°? ?ΌμΉμ κ°μ¬?λ©? ?? ????€.
	// 2. μ½μμ°½μ΄ ?λ¬? ??‘?΄ ResourceλΆ?λΆμ? println ?¬?©?? κ²μ μ§??????€.
	// 3. λ‘κ·Έλ₯? ?°λ©? μ½μ?΄ ? κΉλ?΄λ³΄μ΄κ² μ?λ§? ?μ§? ?€? ₯ λ―Έμ?΄?Ό ? ?©?μ§? ???€.
	// 4. Process ?΄λΆ?? Thread Queueλ₯? λ§λ€?΄ destroyAll?λ©? Threadλ₯? ?€ λ©μΆκ²? ?¨.
}
