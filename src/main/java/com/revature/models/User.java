package com.revature.models;

import java.util.Map;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
// import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class User {
	
	@Id
	@Column (name ="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 5, max = 15, message = "Must be between 5 & 15 characters")
	private String username;
	
	@Size(min = 5, max = 15, message = "Must be between 5 & 15 characters")
	private String password;
	
	@Email
	private String email;

	
	
//	private Map<String, Object> songs;
	
//	private Map<String, Object> playlist;
	
}
