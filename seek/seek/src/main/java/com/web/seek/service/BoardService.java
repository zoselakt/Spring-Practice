package com.web.seek.service;

import com.web.seek.domain.Board;
import com.web.seek.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    /**
     * 페이징 처리
     * @param pageable
     * @return
     */
    public Page<Board> findBoardList(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1 , pageable.getPageSize());
        return boardRepository.findAll(pageable);
    }

    /**
     * 게시글 ID로 조회
     * @param id
     * @return
     */
    public Board findBoardById(Long id){
        Board board = boardRepository.findById(id).orElse(new Board());
        return board;
    }

    /**
     * 게시글 저장
     * @param board
     * @return
     */
    public Board save(Board board){
        Board saveBoard = boardRepository.save(board);
        return saveBoard;
    }

    /**
     * 게시글 삭제
     * @param id
     */
    public void deleteById(Long id){
        boardRepository.deleteById(id);
    }
}
