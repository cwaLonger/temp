package lamda;

import java.util.Vector;

public class Main {
	private Vector<Ridable> vr = new Vector<Ridable>();
	
	public Main() {
		vr.add(new Car());
		vr.add(new Bike());
		vr.add(new Bus());
		vr.add(()->{System.out.println("this is a lamda expression");});
		vr.add(new Ridable(){
			public void getType(){
				System.out.println("this is a annomymous class");
			}
		});
		
		for (Ridable lamda : vr) {
			lamda.getType();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
