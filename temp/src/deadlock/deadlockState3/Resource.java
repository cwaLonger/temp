package deadlock.deadlockState3;

public class Resource {
	private String ID;
	private Process process = null;
	private String information = null;
	
	public Resource(String ID){
		this.ID = ID;
	}
	
	public String getProcess() {
		return process.toString();
	}
	
	public boolean setProcess(Process process) {
		if(this.process == null) {
			this.process = process;
			return true;
		}
		else {
			System.out.println(ID + "] it can't be allocated.");
			return false;
		}
	}
	
	public void freeProcess(){
		process = null;
	}
	
	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
}
