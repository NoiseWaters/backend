package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Playlist")
@Component
public class Playlist {
	
	@Id
	@Column(name="playlist_pk")
	private int id;
	
	@Column(name = "playlist_id")
	private int songId;
	

	public Playlist() {
	}

}