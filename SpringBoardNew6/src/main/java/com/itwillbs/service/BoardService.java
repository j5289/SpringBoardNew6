package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

/**
 *	서비스의 영역 - 동작의 제어가 필요한경우 처리
 */
public interface BoardService {
	
	public String getServerTime();
	
	// 게시판 글쓰기 
	public void registBoard(BoardVO vo) throws Exception;
	
	// 게시판 글 전체 목록 조회
	public List<BoardVO> getBoardListAll() throws Exception;
	
	// 특정 글(bno) 정보를 조회
	public BoardVO getBoard(int bno) throws Exception;
	
	// 특정 글(bno) 조회수 1증가
	public void increaseViewCnt(int bno) throws Exception;
	
	// 특정 글정보를 수정
	public void modifyBoard(BoardVO uvo) throws Exception;
	
	// 특정 글 정보를 삭제
	public Integer removeBoard(BoardVO dvo) throws Exception;
	
	
	
	
}
