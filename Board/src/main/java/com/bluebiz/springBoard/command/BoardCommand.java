package com.bluebiz.springBoard.command;

import java.sql.Timestamp;

public class BoardCommand {
	private long bnum;
	private String title;
	private String writer;
	private String content;
	private Timestamp regDate;
	public long getBnum() {
		return bnum;
	}
	public void setBnum(long bnum) {
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
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	
}
