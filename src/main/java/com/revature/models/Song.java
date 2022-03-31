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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity 
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@EqualsAndHashCode(exclude={"owners"}) @ToString(exclude= {"owners"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "owners"})
public class Song {
	
	@Id
	@Column(name="song_pk")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="song_id", unique=true)
	private int songId;
	
	@Column(name="song_name")
	private String songName;
	
	@ManyToMany(mappedBy="songs", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) // declare the owner of the relationship by mapping it to the property of the User class
	private @NonNull Set<User> owners;

	public void addUser(User user) {
        owners.add(user);
        user.getSongs().add(this);
    }

	public Song(int songId, String songName) {
		super();
		this.songId = songId;
		this.songName = songName;
	}	
}
