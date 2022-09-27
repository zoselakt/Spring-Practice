package com.bluebiz.springBoard.domain;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Repository
public class BoardDto {
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
