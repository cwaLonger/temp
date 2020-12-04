package deadlock.deadlockRefactor;

import java.util.Vector;

public class Process {
	private String ID;
	private Resource[] resource = new Resource[2];
	private Vector<InnerProcess> thv = new Vector<InnerProcess>();
	
	public Process(String ID){
		this.ID = ID;
		
		new Thread(){
			public void run() {
				while(true) {
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					int length = thv.size();
					for(int i = 0 ; i < length ; i ++)
						if(thv.get(i).notifyProcess()){
							thv.remove(thv.get(i));
							length--;
						}
				}
			}
		}.start();
	}
	
	public String getID(){
		return ID;
	}
	
	public String getResource() {
		String resource1 = resource[0] != null ? resource[0].getInformation() :  "null";
		String resource2 = resource[1] != null ? resource[1].getInformation() :  "null";
		return ID + "] " + resource1 + " / " + resource2;		
	}
	
	private boolean setResource(Resource resource) {
		// short-circuit
		if((this.resource[0] == null || this.resource[1] == null) && resource.setProcess(this)) {
			if(this.resource[0] == null)
				this.resource[0] = resource;
			else if(this.resource[1] == null)
				this.resource[1] = resource;
			System.out.println(ID + "] Resource is allocated");
			return true;
		}
		else {
			System.out.println(ID + "] Resource is allocated failed");
			return false;
		}
	}
	
	public void shouldSetResource(Resource resource){
		thv.add(new ResourceProcess(resource));
	}
	
	public void shouldAct(){
		thv.add(new ActProcess());
	}
	
	
	private class ActProcess implements InnerProcess {
		@Override
		public boolean notifyProcess() {
			if(resource[0] != null && resource[1] != null) {
				System.out.println(getResource());
				return true;
			}
			return false;
		}
	}

	private class ResourceProcess implements InnerProcess {
		private int tryCount = 0;
		private Resource innerResource;
		
		public ResourceProcess(Resource resource) {
			innerResource = resource;
		}
		
		@Override
		public boolean notifyProcess() {
			if(setResource(innerResource))
				return true;
			else{
				System.out.println(ID + "] try in " + tryCount++);
				return false;
			}
		}
	}
	
	
	
	public void destroyAll(){
		if(resource[0] != null) {
			resource[0].freeProcess();
			resource[0] = null;
		}
		if(resource[1] != null) {
			resource[1].freeProcess();
			resource[1] = null;
		}
		thv.clear();
	}
	
}
