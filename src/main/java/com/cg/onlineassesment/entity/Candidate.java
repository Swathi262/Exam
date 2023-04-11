package com.cg.onlineassesment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "candidate")
public class Candidate {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int custid;

private String name;
@NotBlank(message="The email could not be blank or empty or null")
@Email(message="please enter the valid email Id", regexp="^[a-zA-Z0-9,_-]+@[a-zA-Z0-9.]{2,5}")
private String email;
@NotBlank(message="the password field should not be blank")
@Size(min=5,max=15)
private String password;
private Long mobileno;
private String qualification;
@OneToOne
@JoinColumn(name = "user_id")
private User userId;

public int getCustid() {
	return custid;
}
public void setCustid(int custid) {
	this.custid = custid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Long getMobileno() {
	return mobileno;
}
public void setMobileno(Long mobileno) {
	this.mobileno = mobileno;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}

@Override
public String toString() {
	return "Candidate [custid=" + custid + ", name=" + name + ", email=" + email + ", password=" + password
			+ ", mobileno=" + mobileno + ", qualification=" + qualification + "]";
}

}
