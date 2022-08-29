package com.medici.arang.comment.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medici.arang.comment.command.CommentCommand;

public class CommentRowMapper implements RowMapper<CommentCommand> {

	@Override
	public CommentCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentCommand commentCommand = new CommentCommand();
		commentCommand.getComment_num();
		commentCommand.getComment_id();
		commentCommand.getComment_content();
		commentCommand.getComment_board();
		commentCommand.getComment_parent();
		commentCommand.getComment_level();
		commentCommand.getRegDate();
		return commentCommand;
	}
}
