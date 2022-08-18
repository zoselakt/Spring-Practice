package com.medici.arang.board.artist.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArtworkCommand {
	private long wid;
	private long artistId;
	private String artworkName;
	private String artworkImg;
	private String description;
	private String artworkCategory;
	
	public ArtworkCommand() {
		super();
	}
}
