package model;

public class Invoice {
public int id;
public int business_id;
public float total;
public float tax;
public String products;
public String quantities;
public String payment_method;
public String name;
public String slip;
public String id_number;
public String date;
public Invoice(int id, int business_id, float total, float tax, String products, String quantities,
		String payment_method, String name, String slip, String id_number, String date) {
	super();
	this.id = id;
	this.business_id = business_id;
	this.total = total;
	this.tax = tax;
	this.products = products;
	this.quantities = quantities;
	this.payment_method = payment_method;
	this.name = name;
	this.slip = slip;
	this.id_number = id_number;
	this.date = date;
	
}

public Invoice(int id, String payment_method,String name, float total, float tax ) {
	super();
	this.id = id;
	this.payment_method = payment_method;
	this.name = name;
	this.total = total;
	this.tax = tax;
	
	
	
}


public Invoice(float total, float tax, String products, String name, String date) {
	super();
	this.total = total;
	this.tax = tax;
	this.products = products;
	this.name = name;
	this.date = date;
}

public Invoice() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getBusiness_id() {
	return business_id;
}
public void setBusiness_id(int business_id) {
	this.business_id = business_id;
}
public float getTotal() {
	return total;
}
public void setTotal(float total) {
	this.total = total;
}
public float getTax() {
	return tax;
}
public void setTax(float tax) {
	this.tax = tax;
}
public String getProducts() {
	return products;
}
public void setProducts(String products) {
	this.products = products;
}
public String getQuantities() {
	return quantities;
}
public void setQuantities(String quantities) {
	this.quantities = quantities;
}
public String getPayment_method() {
	return payment_method;
}
public void setPayment_method(String payment_method) {
	this.payment_method = payment_method;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSlip() {
	return slip;
}
public void setSlip(String slip) {
	this.slip = slip;
}
public String getId_number() {
	return id_number;
}
public void setId_number(String id_number) {
	this.id_number = id_number;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
@Override
public String toString() {
	return "Invoice [id=" + id + ", business_id=" + business_id + ", total=" + total + ", tax=" + tax + ", products="
			+ products + ", quantities=" + quantities + ", payment_method=" + payment_method + ", name=" + name
			+ ", slip=" + slip + ", id_number=" + id_number + ", date=" + date + "]";
}

}
