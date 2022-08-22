package com.medici.arang.board.notice.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.medici.arang.board.notice.command.NoticeCommand;
import com.medici.arang.board.notice.domain.NoticeVo;

@Service
public interface NoticeService {
	public long insertNotice(NoticeCommand command);
	public long updateNotice(NoticeCommand command, long num);
	public long deleteNotice(long num);
	public List<NoticeCommand> findAllNotice();
	public NoticeCommand findOneNotice(long num);
	public long NoticeCount(long num);
	public List<NoticeCommand> paging(long num);
	public Page<NoticeCommand> findAll(Pageable pageable);
	public long getCount();
	public List<NoticeCommand> searchByTitle(String title);
	public List<NoticeCommand> searchByContent(String content);
	public List<NoticeCommand> searchByWriter(String writer);
}
