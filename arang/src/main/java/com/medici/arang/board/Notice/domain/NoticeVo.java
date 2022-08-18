package com.medici.arang.board.Notice.domain;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class NoticeVo {
	private long num;
	private String title;
	private String writer;  // 작성자는 값을 다른 테이블에서 가져와야 하기때문에 일단은 STring으로 작성함
	private String content;
	private int readCnt;
	private Timestamp regDate;
}
