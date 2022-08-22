package com.medici.arang.board.notice.service;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import com.medici.arang.board.notice.command.NoticeCommand;
import com.medici.arang.board.notice.dao.NoticeDao;

public class NoticeServiceImpl implements NoticeService{
	NoticeDao dao = new NoticeDao();
	
	@Override
	public void insertNotice(NoticeCommand command) {
		dao.insertNotice(command);
	}

	@Override
	public void updateNotice(NoticeCommand command, long num) {
		dao.updateNotice(command, num);
	}

	@Override
	public void deleteNotice(long num) {
		dao.deleteNotice(num);
	}

	@Override
	public List<NoticeCommand> findAllNotice() {
		return dao.findAllNotice();
	}

	@Override
	public NoticeCommand findOneNotice(long num) {
		return dao.findOneNotice(num);
	}

	@Override
	public long NoticeCount(long num) {
		return dao.NoticeCount(num);
	}

}
