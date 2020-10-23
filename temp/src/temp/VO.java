package temp;

public class VO {
	private String bName, name, description, makeCompany, distributeCompany;
	private int price;
	
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMakeCompany() {
		return makeCompany;
	}
	public void setMakeCompany(String makeCompany) {
		this.makeCompany = makeCompany;
	}
	public String getDistributeCompany() {
		return distributeCompany;
	}
	public void setDistributeCompany(String distributeCompany) {
		this.distributeCompany = distributeCompany;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public VO(){};
	public VO(String bName, String name, String description, String makeCompany, String distributeCompany, int price) {
		this.bName = bName;
		this.name = name;
		this.description = description;
		this.makeCompany = makeCompany;
		this.distributeCompany = distributeCompany;
		this.price = price;
	}
	
	@Override
	public String toString(){
		return "{\"bName\" : \"" + bName
				+ "\", \"name\" : \"" + name
				+ "\", \"description\" : \"" + description
				+ "\", \"makeCompany\" : \"" + makeCompany
				+ "\", \"distributeCompany\" : \"" + distributeCompany
				+ "\", \"price\" : \"" + price + "\"}";
	}
	
}
