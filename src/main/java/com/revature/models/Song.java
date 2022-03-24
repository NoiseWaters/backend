package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity @AllArgsConstructor @NoArgsConstructor
public class Song {
	
	@Id
	@Column(name="song_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	


}
