package deadlockRefactor;

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
		// start가 아닌 run을 사용해서 main thread를 잠시 멈춤.
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
	
	
	// 리팩토링을 하면서 느낀 점.
	// 1. Resource에서 Process = null을 생각없이 사용했는데 깊은 복사가 이뤄지지 않은 우연의 일치에 감사하며 수정하였다.
	// 2. 콘솔창이 너무 난잡해 Resource부분에서 println 사용하는 것을 지양하였다.
	// 3. 로그를 쓰면 콘솔이 더 깔끔해보이겠지만 아직 실력 미숙이라 적용하지 않았다.
	// 4. Process 내부에 Thread Queue를 만들어 destroyAll하면 Thread를 다 멈추게 함.
}
