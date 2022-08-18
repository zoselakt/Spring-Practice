package com.medici.arang.board.Notice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medici.arang.board.Notice.domain.NoticeVo;
import com.medici.arang.board.Notice.domain.PagingVo;

@Service
public interface NoticeService {
	public long insertNotice(NoticeVo noticeVo);
	public long updateNotice(NoticeVo noticeVo, long num);
	public long deleteNotice(long num);
	public List<NoticeVo> findAllNotice();
	public NoticeVo findOneNotice(long num);
	public int readCnt(long num);
	
	public List<NoticeVo> paging(long num);
	public NoticeVo getCount(NoticeVo noticeVo);
}
