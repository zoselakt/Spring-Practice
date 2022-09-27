package com.bluebiz.board.domain;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDto {
	private int bnum;
	private String title;
	private String writer;
	private String content;
	private int readCnt;
	private Timestamp regDate;
	
	public BoardDto() {}
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public BoardDto(int bnum, String title, String writer, String content, int readCnt, Timestamp regDate) {
		super();
		this.bnum = bnum;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.readCnt = readCnt;
		this.regDate = regDate;
	}
}
