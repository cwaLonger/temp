package javaCoding.builder;

public abstract class Product {
	private String name;
	private int price;
	private String makeCompany;
	private String distributeCompany;
	private String description;
	
	abstract static class Builder<T extends Builder<T>>{
		private String name;
		private int price;
		private String makeCompany;
		private String distributeCompany;
		private String description;
		
		public T name(String name) {this.name = name; return self();}
		public T price(int price) {this.price = price; return self();}
		public T makeCompany(String makeCompany) {this.makeCompany = makeCompany; return self();}
		public T distributeCompany(String distributeCompany) {this.distributeCompany = distributeCompany; return self();}
		public T description(String description) {this.description = description; return self();}
		
		public abstract Product build();
		
		protected abstract T self();
	}
	
	public Product(Builder<?> builder){
		name = builder.name;
		price = builder.price;
		makeCompany = builder.makeCompany;
		distributeCompany = builder.distributeCompany;
		description = builder.description;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getMakeCompany() {
		return makeCompany;
	}

	public String getDistributeCompany() {
		return distributeCompany;
	}

	public String getDescription() {
		return description;
	}
}
