package com.revature.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "songs"})
@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column (name ="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Size(min=5, max= 15, message = "Must be between 5 & 15 characters")
	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*")
	@Column(unique=true)
	private String username;
	
	@NotBlank
	@Size(min=5, max = 15, message = "Must be between 5 & 15 characters")
	private String password;
	
	@Email
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.PERSIST)
	@JoinTable(name="users_songs", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns=@JoinColumn(name = "song_pk"))
//	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	private Set<Song> songs;

	public User(
			@NotBlank @Size(min = 5, max = 15, message = "Must be between 5 & 15 characters") @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") String username,
			@NotBlank @Size(min = 5, max = 15, message = "Must be between 5 & 15 characters") String password,
			@Email String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public User(
			@NotBlank @Size(min = 5, max = 15, message = "Must be between 5 & 15 characters") @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") String username,
			@NotBlank @Size(min = 5, max = 15, message = "Must be between 5 & 15 characters") String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(
			@NotBlank @Size(min = 5, max = 15, message = "Must be between 5 & 15 characters") @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") String username,
			@NotBlank @Size(min = 5, max = 15, message = "Must be between 5 & 15 characters") String password,
			@Email String email, Set<Song> songs) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.songs = songs;
	}
	
}