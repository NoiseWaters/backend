package com.revature.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
// import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
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
	private String username;
	
	@NotBlank
	@Size(min=5, max = 15, message = "Must be between 5 & 15 characters")
	private String password;
	
	@Email
	private String email;
	
	@ManyToMany
	@JoinTable(name="users_songs", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns=@JoinColumn(name = "song_pk")) 
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
	
}
