package model;

public class Product {
public int id;
public int business_id;
public String name;
public String unit;
public String tax_rate;
public String country;
public String foreign_name;
public String barcode;
public String manufacturer;
public String rate;
public String eco_tax;
public String description;
public String declaration;
public String object_name;
public float buying_price;
public float selling_price;
public String status;


public Product() {
	super();
	// TODO Auto-generated constructor stub
}

public Product(String name, String manufacturer,float selling_price, String object_name, int business_id) {
	super();
	this.name = name;
	this.manufacturer = manufacturer;
	this.selling_price = selling_price;
	this.object_name = object_name;
	this.business_id = business_id;
}
public Product(String name, String manufacturer,float selling_price, String object_name, String description) {
	super();
	this.name = name;
	this.manufacturer = manufacturer;
	this.selling_price = selling_price;
	this.object_name = object_name;
	this.description = description;
}
public Product(int id, String name, String unit, String tax_rate, String manufacturer, int business_id) {
	super();
	this.id = id;
	this.name = name;
	this.unit = unit;
	this.tax_rate = tax_rate;
	this.manufacturer = manufacturer;
	this.business_id=business_id;
}
public Product(int id, String name, String unit, String tax_rate, String manufacturer, float selling_price, int business_id) {
	super();
	this.id = id;
	this.name = name;
	this.unit = unit;
	this.tax_rate = tax_rate;
	this.manufacturer = manufacturer;
	this.selling_price=selling_price;
	this.business_id=business_id;
}

public Product(int id, int business_id, String name, String unit, String tax_rate, String country, String foreign_name,
		String barcode, String manufacturer, String rate, String eco_tax, String description, String declaration,
		String object_name, float buying_price, float selling_price, String status) {
	super();
	this.id = id;
	this.business_id = business_id;
	this.name = name;
	this.unit = unit;
	this.tax_rate = tax_rate;
	this.country = country;
	this.foreign_name = foreign_name;
	this.barcode = barcode;
	this.manufacturer = manufacturer;
	this.rate = rate;
	this.eco_tax = eco_tax;
	this.description = description;
	this.declaration = declaration;
	this.object_name = object_name;
	this.buying_price = buying_price;
	this.selling_price = selling_price;
	this.status = status;
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
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public String getTax_rate() {
	return tax_rate;
}
public void setTax_rate(String tax_rate) {
	this.tax_rate = tax_rate;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getForeign_name() {
	return foreign_name;
}
public void setForeign_name(String foreign_name) {
	this.foreign_name = foreign_name;
}
public String getBarcode() {
	return barcode;
}
public void setBarcode(String barcode) {
	this.barcode = barcode;
}
public String getManufacturer() {
	return manufacturer;
}
public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}
public String getRate() {
	return rate;
}
public void setRate(String rate) {
	this.rate = rate;
}
public String getEco_tax() {
	return eco_tax;
}
public void setEco_tax(String eco_tax) {
	this.eco_tax = eco_tax;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getDeclaration() {
	return declaration;
}
public void setDeclaration(String declaration) {
	this.declaration = declaration;
}
public String getObject_name() {
	return object_name;
}
public void setObject_name(String object_name) {
	this.object_name = object_name;
}
public float getBuying_price() {
	return buying_price;
}
public void setBuying_price(float buying_price) {
	this.buying_price = buying_price;
}
public float getSelling_price() {
	return selling_price;
}
public void setSelling_price(float selling_price) {
	this.selling_price = selling_price;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

@Override
public String toString() {
	return "Product [id=" + id + ", business_id=" + business_id + ", name=" + name + ", unit=" + unit + ", tax_rate="
			+ tax_rate + ", country=" + country + ", foreign_name=" + foreign_name + ", barcode=" + barcode
			+ ", manufacturer=" + manufacturer + ", rate=" + rate + ", eco_tax=" + eco_tax + ", description="
			+ description + ", declaration=" + declaration + ", object_name=" + object_name + ", buying_price="
			+ buying_price + ", selling_price=" + selling_price + ", status=" + status + "]";
}


}
