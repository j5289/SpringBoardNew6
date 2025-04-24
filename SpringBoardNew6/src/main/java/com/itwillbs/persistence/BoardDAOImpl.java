package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

/**
 *  BoardDAO 인터페이스 객체를 구현한 객체
 *   => 실제 처리되는 동작을 구현하는 객체 
 */
@Repository
public class BoardDAOImpl implements BoardDAO{
	//mylog
	private static final Logger logger
	 = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	// SqlSession 객체를 주입
	@Inject
	private SqlSession sqlSession;
	
	//boardMapper.xml 접근 이름
	private static final String NAMESPACE
	       ="com.itwillbs.mapper.BoardMapper.";
	
	@Override
	public String getServerTime() {
		// 디비연결
		// 해당 SQL구문 호출
		String time 
		  = sqlSession.selectOne(NAMESPACE + "getServerTime");
		
		return time;
	}

	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		logger.info("insertBoard(BoardVO vo) 실행 ");
		logger.info(" 전달받은 정보를 사용해서 SQL구문 실행 (mapper 실행)");
		
		// 디비연결 객체를 사용해서 필요한 SQL구문 실행
		//                com.itwillbs.mapper.BoardMapper.insertBoard
		sqlSession.insert(NAMESPACE +"insertBoard",vo);
		
		logger.info(" mapper 실행 완료! -> 결과를 서비스로 전달");
	}

	@Override
	public List<BoardVO> selectBoardListAll() throws Exception {
		logger.info(" selectBoardListAll() 실행 ");
		// 특정 mapper 호출 - SQL구문 호출
		
		List<BoardVO> boardList = 
		  sqlSession.selectList(NAMESPACE + "listAll");
		
		logger.info(" boardList : {} 개",boardList.size());
		
		return boardList;
	}

	@Override
	public BoardVO selectBoard(int bno) throws Exception {
		logger.info(" selectBoard(int bno) 실행 ");
		// mapper 해당 SQL구문 호출
		
		return sqlSession.selectOne(NAMESPACE +"getBoard",bno);
	}

	@Override
	public void updateViewCnt(int bno) throws Exception {
		logger.info(" updateViewCnt(int bno) 실행 ");
		
		sqlSession.update(NAMESPACE + "updateViewcnt",bno);
	}

	@Override
	public void updateBoard(BoardVO uvo) throws Exception {
		logger.info(" updateBoard(BoardVO uvo) 실행 ");
		
		sqlSession.update(NAMESPACE + "updateBoard",uvo);		
	}

	@Override
	public Integer deleteBoard(BoardVO dvo) throws Exception {
		logger.info("deleteBoard(BoardVO dvo) 호출");
		int result 
		  = sqlSession.delete(NAMESPACE + "deleteBoard", dvo);
		return result;
	}
	
	
	
	
	
	
}
