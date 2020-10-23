package method;

public class Circle {
	private int radius;
	
	public Circle(){
		
	}
	
	public Circle(int radius){
		this.radius = radius;
	}
	
	public int getRadius() { return radius; }
	public void setRadius(int radius){ this.radius = radius; }
	public double getShape(){ return radius * radius * 3.141592; }
}
