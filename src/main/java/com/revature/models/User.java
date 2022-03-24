package com.revature.models;

import java.util.Map;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
	@Size(min=5)
	private String username;
	
	@NotBlank
	@Size(min=5)
	private String password;
	
	private Map<String, Object> playlist;

	public User(@NotBlank @Size(min = 5) String username, @NotBlank @Size(min = 5) String password,
			Map<String, Object> playlist) {
		super();
		this.username = username;
		this.password = password;
		this.playlist = playlist;
	}
	
	
	
}
