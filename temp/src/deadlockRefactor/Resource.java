package deadlockRefactor;

public class Resource {
	private String process = null;
	private String information = null;
	
	public Resource(String information){
		this.information = information;
	}
	
	public boolean setProcess(Process process) {
		// DeadLock Condition 1 & 3 : Mutual Exclusion & Non-preemption
		if(this.process == null) {
			this.process = process.getID();
			return true;
		}
		else 
			return false;
	}
	
	public void freeProcess(){
		process = null;
	}
	
	public String getInformation() {
		return information;
	}
}
