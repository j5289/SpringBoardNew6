package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

/**
 *	실제 서비스동작이 수행되는 객체 
 */
@Service
public class BoardServiceImpl implements BoardService{
	//mylog
	private static final Logger logger 
	   = LoggerFactory.getLogger(BoardServiceImpl.class);
	// BoardDAO 객체 주입
	@Inject
	private BoardDAO bDao;
	
	@Override
	public String getServerTime() {
		
		return bDao.getServerTime();
	}

	@Override
	public void registBoard(BoardVO vo) throws Exception {
		logger.info("게시판 글쓰기 - registBoard(BoardVO vo) 실행");
		logger.info(" 전달받은 정보를 DAO로 전달 + DAO동작을 처리 ");
		
		bDao.insertBoard(vo);
		
		logger.info(" DAO 실행완료 -> 컨트롤러로 이동");
		
	}

	@Override
	public List<BoardVO> getBoardListAll() throws Exception {
		logger.info(" getBoardListAll() 실행 ");
		
		// DAO 동작 호출
		List<BoardVO> boardList = bDao.selectBoardListAll();
		
		logger.info(" boardList : {} 개",boardList.size());
		
		return boardList;
	}

	@Override
	public BoardVO getBoard(int bno) throws Exception {
		logger.info(" getBoard(int bno)실행 ");
		
		// DAO - 특정 글정보를 조회 
		return bDao.selectBoard(bno);
	}

	@Override
	public void increaseViewCnt(int bno) throws Exception {
		logger.info(" increaseViewCnt(int bno) 실행 ");
		
		bDao.updateViewCnt(bno);		
	}

	@Override
	public void modifyBoard(BoardVO uvo) throws Exception {
		logger.info(" modifyBoard(BoardVO uvo) 실행 ");
		
		bDao.updateBoard(uvo);		
	}

	@Override
	public Integer removeBoard(BoardVO dvo) throws Exception {
		logger.info(" removeBoard(BoardVO dvo) 호출 ");
		return bDao.deleteBoard(dvo);
	}
	
	
	
	
	
	
	
	
	
	

}
