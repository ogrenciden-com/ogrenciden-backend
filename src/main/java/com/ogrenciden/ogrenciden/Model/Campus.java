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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
@Table(name = "campus")
public class Campus{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long campusId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "universityId")
	@JsonIgnore
	University universityId;
	
	@Column(name = "campusName")
	String CampusName;
	

}
