package com.ogrenciden.ogrenciden.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "campus")
public class Campus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long campusId;
	
	String CampusName;

}
