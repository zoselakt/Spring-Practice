package com.medici.arang.board.notice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medici.arang.board.notice.command.NoticeCommand;

@Service
public interface NoticeService {
	public void insertNotice(NoticeCommand command);
	public void updateNotice(NoticeCommand command, long num);
	public void deleteNotice(long num);
	public List<NoticeCommand> findAllNotice();
	public NoticeCommand findOneNotice(long num);
	public long NoticeCount(long num);
}
