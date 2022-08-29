package com.medici.arang.comment.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medici.arang.comment.command.CommentCommand;
import com.medici.arang.comment.domain.CommentRowMapper;

import lombok.NoArgsConstructor;

@Repository
@NoArgsConstructor
public class CommentDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CommentDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate();
	}
	
	public long insertComment(CommentCommand commentCommand) {
		String sql = "INSERT INTO Comment (comment_id, comment_content, comment_board, "
				+ " comment_parent, comment_level) VALUE (?,?,?,?,?)";
		return jdbcTemplate.update(sql, commentCommand.getComment_id(), 
				commentCommand.getComment_content(), commentCommand.getComment_board(),
				commentCommand.getComment_parent(), commentCommand.getComment_level());
	}
	public long updateComment(CommentCommand commentCommand, long comment_num) {
		String sql = "UPDATE Comment SET comment_id = ?, comment_content = ?, comment_board = ?, "
				+ " comment_parent = ?, comment_level = ? WHERE comment_num = ?";
		return jdbcTemplate.update(sql, commentCommand.getComment_id(), 
				commentCommand.getComment_content(), commentCommand.getComment_board(),
				commentCommand.getComment_parent(), commentCommand.getComment_level(), comment_num);
	}
	public long deleteComment(long comment_num) {
		String sql = "DELETE FROM comment WHERE comment_num = ?";
		return jdbcTemplate.update(sql, comment_num);
	}
	public List<CommentCommand> findAllCommentList(){
		String sql = "select comment_id, comment_content, comment_board, "
				+ " comment_parent, comment_level from comment ";
		return jdbcTemplate.query(sql, new CommentRowMapper());
	}
	public CommentCommand findOneComment(long comment_num) {
		String sql ="select * from comment where comment_num = ?";
		return jdbcTemplate.queryForObject(sql, new CommentRowMapper(), comment_num);
	}
}
