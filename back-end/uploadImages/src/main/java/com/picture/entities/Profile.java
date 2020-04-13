package com.picture.entities;


import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;




@Entity
@EntityListeners(AuditingEntityListener.class)
public  class Profile{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
 
    private String name;

	private String mail;

	private String password;

    @Column(name = "picture", columnDefinition = "longblob")
	private  byte[] picture;
    private String getpic;
	public Profile(int id, String name, String mail, String password, byte[] picture, String getpic) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.picture = picture;
		this.getpic = getpic;
	}
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public String getGetpic() {
		return getpic;
	}
	public void setGetpic(String getpic) {
		this.getpic = getpic;
	}
	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", mail=" + mail + ", password=" + password + ", picture="
				+ Arrays.toString(picture) + ", getpic=" + getpic + "]";
	}

    

	
	
	
}
