package com.revature.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity 
public class Song {
	
	@Id
	@Column(name="song_pk")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="song_id")
	private int songId;
	
	@ManyToMany(mappedBy="songs") // declare the owner of the relationship by mapping it to the property of the User class
	private @NonNull Set<User> owners;

}