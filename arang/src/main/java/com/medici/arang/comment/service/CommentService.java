package com.medici.arang.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medici.arang.comment.command.CommentCommand;

@Service
public interface CommentService {
	public long insertComment(CommentCommand commentCommand);
	public long updateComment(CommentCommand commentCommand, long comment_num);
	public long deleteComment(long comment_num);
	public List<CommentCommand> findAllCommentList();
	public CommentCommand findOneComment(long comment_num);
}
