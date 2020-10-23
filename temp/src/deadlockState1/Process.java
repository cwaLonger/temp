package deadlockState1;

public class Process {
	private String ID;
	private Resource resource1;
	private Resource resource2;
	
	public Process(String ID){
		this.ID = ID;
	}

	public String getResource1() {
		if(resource1 != null)
			return resource1.getInformation();
		else
			return ID + "] resource1 is null";
	}
	
	public boolean setResource1(Resource resource1) {
		if(resource1.setProcess(this)) {
			this.resource1 = resource1;
			System.out.println(ID + "] Resource1 is allocated");
			return true;
		}
		else {
			System.out.println(ID + "] Resource1 is allocated failed");
			return false;
		}
	}
	
	public String getResource2() {
		if(resource2 != null)
			return resource2.getInformation();
		else
			return ID + "] resource2 is null";
	}
	
	public boolean setResource2(Resource resource2) {
		if(resource2.setProcess(this)) {
			this.resource2 = resource2;
			System.out.println(ID + "] Resource2 is allocated");
			return true;
		}
		else {
			System.out.println(ID + "] Resource2 is allocated failed");
			return false;
		}
	}
	
	
}
