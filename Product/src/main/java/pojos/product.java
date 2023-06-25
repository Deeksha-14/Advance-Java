package pojos;

public class product {
private int id;
private String desc1;
private String name1;
private double price1;
private int quantity1;


public product() {
	
}

public product(int id, String desc1, String name1, double price1, int quantity1) {
	super();
	this.id = id;
	this.desc1 = desc1;
	this.name1 = name1;
	this.price1 = price1;
	this.quantity1 = quantity1;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getDesc1() {
	return desc1;
}


public void setDesc1(String desc1) {
	this.desc1 = desc1;
}


public String getName1() {
	return name1;
}


public void setName1(String name1) {
	this.name1 = name1;
}


public double getPrice1() {
	return price1;
}


public void setPrice1(double price1) {
	this.price1 = price1;
}


public int getQuantity1() {
	return quantity1;
}


public void setQuantity1(int quantity1) {
	this.quantity1 = quantity1;
}


@Override
public String toString() {
	return "product [id=" + id + ", desc1=" + desc1 + ", name1=" + name1 + ", price1=" + price1 + ", quantity1="
			+ quantity1 + "]";
}


}
