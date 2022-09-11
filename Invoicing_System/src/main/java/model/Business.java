package model;

public class Business {
public int id;
public String business_name;
public String business_number;
public String person_name;
public String pib;
public String address;
public String email;
public String status;
public String username;
public String password;
public String phone;


public Business() {
	super();
	// TODO Auto-generated constructor stub
}

public Business(int id, String business_name) {
	super();
	this.id = id;
	this.business_name = business_name;
}

public Business(int id, String business_name, String business_number, String person_name, String pib, String address,
		String email, String status, String username, String password, String phone) {
	super();
	this.id = id;
	this.business_name = business_name;
	this.business_number = business_number;
	this.person_name = person_name;
	this.pib = pib;
	this.address = address;
	this.email = email;
	this.status = status;
	this.username = username;
	this.password = password;
	this.phone = phone;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBusiness_name() {
	return business_name;
}
public void setBusiness_name(String business_name) {
	this.business_name = business_name;
}
public String getBusiness_number() {
	return business_number;
}
public void setBusiness_number(String business_number) {
	this.business_number = business_number;
}
public String getPerson_name() {
	return person_name;
}
public void setPerson_name(String person_name) {
	this.person_name = person_name;
}
public String getPib() {
	return pib;
}
public void setPib(String pib) {
	this.pib = pib;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "Business [id=" + id + ", business_name=" + business_name + ", business_number=" + business_number
			+ ", person_name=" + person_name + ", pib=" + pib + ", address=" + address + ", email=" + email
			+ ", status=" + status + ", username=" + username + ", password=" + password + ", phone=" + phone + "]";
}

}
