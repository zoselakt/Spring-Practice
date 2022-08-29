package com.medici.arang.comment.domain;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
public class CommentVo {
	private long comment_num;
	private String comment_id;
	private String comment_content;
	private int comment_board;
	private int comment_parent;
	private int comment_level;
	private Timestamp regDate;
}
