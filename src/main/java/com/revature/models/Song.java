package com.revature.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@Column(name="song_name")
	private String songName;
	
	@ManyToMany(mappedBy="songs", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) // declare the owner of the relationship by mapping it to the property of the User class
	private @NonNull Set<User> owners;

}
