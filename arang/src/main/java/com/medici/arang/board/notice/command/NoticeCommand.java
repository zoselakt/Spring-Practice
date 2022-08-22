package com.medici.arang.board.notice.command;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class NoticeCommand {
	private long num;
	private String title;
	private String writer;
	private String content;
	private int readCnt;
	private Timestamp regDate;
}
