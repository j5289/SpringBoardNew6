package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * BoardDAO 인터페이스 객체를 구현한 객체
 * => 실제 처리되는 동작을 구현하는 객체 
 */

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	//SqlSession 객체를 주입
	@Inject
	private SqlSession sqlSession;
	
	//boardMapper.xml 접근 이름
	private static final String NAMESPACE
		="com.itwillbs.mapper.BoardMapper.";
	
	
	@Override
	public String getServerTime() {
		//디비연결
		//해당 SQL구문 호출
		String time = 
		sqlSession.selectOne(NAMESPACE+"getServerTime");
		
		return time;
	}
}
