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
		// startê°? ?•„?‹Œ run?„ ?‚¬?š©?•´?„œ main threadë¥? ? ?‹œ ë©ˆì¶¤.
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
	
	
	// ë¦¬íŒ©?† ë§ì„ ?•˜ë©´ì„œ ?Š?? ? .
	// 1. Resource?—?„œ Process = null?„ ?ƒê°ì—†?´ ?‚¬?š©?–ˆ?Š”?° ê¹Šì? ë³µì‚¬ê°? ?´ë¤„ì?ì§? ?•Š?? ?š°?—°?˜ ?¼ì¹˜ì— ê°ì‚¬?•˜ë©? ?ˆ˜? •?•˜???‹¤.
	// 2. ì½˜ì†”ì°½ì´ ?„ˆë¬? ?‚œ?¡?•´ Resourceë¶?ë¶„ì—?„œ println ?‚¬?š©?•˜?Š” ê²ƒì„ ì§??–‘?•˜???‹¤.
	// 3. ë¡œê·¸ë¥? ?“°ë©? ì½˜ì†”?´ ?” ê¹”ë”?•´ë³´ì´ê² ì?ë§? ?•„ì§? ?‹¤? ¥ ë¯¸ìˆ™?´?¼ ? ?š©?•˜ì§? ?•Š?•˜?‹¤.
	// 4. Process ?‚´ë¶??— Thread Queueë¥? ë§Œë“¤?–´ destroyAll?•˜ë©? Threadë¥? ?‹¤ ë©ˆì¶”ê²? ?•¨.
}
