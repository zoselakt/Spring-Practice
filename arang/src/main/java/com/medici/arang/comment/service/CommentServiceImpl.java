package com.medici.arang.comment.service;

import java.util.List;

import com.medici.arang.comment.command.CommentCommand;
import com.medici.arang.comment.dao.CommentDao;

public class CommentServiceImpl implements CommentService{
	private CommentDao commentDao = new CommentDao();
	
	@Override
	public long insertComment(CommentCommand commentCommand) {
		return commentDao.insertComment(commentCommand);
	}

	@Override
	public long updateComment(CommentCommand commentCommand, long comment_num) {
		return commentDao.updateComment(commentCommand, comment_num);
	}

	@Override
	public long deleteComment(long comment_num) {
		return commentDao.deleteComment(comment_num);
	}

	@Override
	public List<CommentCommand> findAllCommentList() {
		return commentDao.findAllCommentList();
	}

	@Override
	public CommentCommand findOneComment(long comment_num) {
		return commentDao.findOneComment(comment_num);
	}

}
