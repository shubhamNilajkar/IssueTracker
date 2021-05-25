package com.issue_tracker.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	int id;
	String fName;
	String lName;
	String gender;
	String eMail;
	String username;
	String password;
	String dateOfBirth;
	String secQn1;
	String secQn2;
	String secQn3;
	long contact;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
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
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSecQn1() {
		return secQn1;
	}
	public void setSecQn1(String secQn1) {
		this.secQn1 = secQn1;
	}
	public String getSecQn2() {
		return secQn2;
	}
	public void setSecQn2(String secQn2) {
		this.secQn2 = secQn2;
	}
	public String getSecQn3() {
		return secQn3;
	}
	public void setSecQn3(String secQn3) {
		this.secQn3 = secQn3;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", fName=");
		builder.append(fName);
		builder.append(", lName=");
		builder.append(lName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", eMail=");
		builder.append(eMail);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", dob=");
		builder.append(dateOfBirth);
		builder.append(", secQn1=");
		builder.append(secQn1);
		builder.append(", secQn2=");
		builder.append(secQn2);
		builder.append(", secQn3=");
		builder.append(secQn3);
		builder.append(", contact=");
		builder.append(contact);
		builder.append("]");
		return builder.toString();
	}	
}
