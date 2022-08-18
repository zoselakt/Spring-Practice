package com.medici.arang.board.Notice.domain;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@Repository
@ToString
public class PagingVo {
	private int currentPage; // 클릭된 현재 번호
	private int startPage; // 현재페이지내 시작 번호
	private int endPage; // 현재페이지내 끝 번호
	private int totalPage; // 게시글 총 갯수
	private int pageCount; // 현재페이지 글 갯수
	private int startBlock; // 1번으로 
	private int endBlock; // 끝번으로
	private int start; // 쿼리에 필요
	private int End; // 쿼리에 필요
	
	public PagingVo(int totalPage, int currentPage, int pageCount) {
		setCurrentPage(currentPage);
		setPageCount(pageCount);
		setTotalPage(totalPage);
		calcLastPage(getTotalPage(), getPageCount());
		calcStartEndPage(getCurrentPage(), pageCount);
		calcStartEnd(getCurrentPage(), getPageCount());
	}

	public void calcLastPage(int totalPage, int pageCount) {
		setEndBlock((int) Math.ceil((double) totalPage / (double) pageCount));
	}

	public void calcStartEndPage(int currentPage, int pageCount) {
		setEndPage(((int)Math.ceil((double)currentPage / (double)pageCount)) * pageCount);
		if (getEndBlock() < getEndPage()) {
			setEndPage(getEndBlock());
		}
		setStartPage(getEndPage() - pageCount + 1);
		if (getStartPage() < 1) {
			setStartPage(1);
		}
	}
	
	public void calcStartEnd(int currentPage, int pageCount) {
		setEnd(currentPage * pageCount);
		setStart(getEnd() - pageCount + 1);
	}

}