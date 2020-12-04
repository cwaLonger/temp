package javaCoding.builder;

public class PenProduct extends Product {
	private String color;
	private int mm;
	
	public static class Builder extends Product.Builder<Builder>{
		private String color;
		private int mm;
		public Builder color(String color){this.color = color; return this;}
		public Builder mm(int mm){this.mm = mm; return this;}

		@Override
		public PenProduct build() { return new PenProduct(this); }

		@Override
		protected Builder self() {return this;}
		
	}
	
	public PenProduct(Builder builder){
		super(builder);
		color = builder.color;
		mm = builder.mm;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getMm() {
		return mm;
	}
}
