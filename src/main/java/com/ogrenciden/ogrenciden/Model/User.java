package com.ogrenciden.ogrenciden.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	
	//UserPhoto
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="userId")
	Long userId;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "lastName")
	String lastName;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "contactInfo")
	String contactInfo;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name = "universityId")
	University universityId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "campusId")
	Campus campusId;
	

}
