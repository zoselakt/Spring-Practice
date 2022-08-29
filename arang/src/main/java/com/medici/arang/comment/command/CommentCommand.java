package com.medici.arang.comment.command;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommentCommand {
		private long comment_num;
		private String comment_id;
		private String comment_content;
		private int comment_board;
		private int comment_parent;
		private int comment_level;
		private Timestamp regDate;
}
