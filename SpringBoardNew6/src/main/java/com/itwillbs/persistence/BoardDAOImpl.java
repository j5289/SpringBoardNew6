package com.itwillbs.persistence;

import org.springframework.stereotype.Repository;

/**
 * BoardDAO 인터페이스 객체를 구현한 객체
 * => 실제 처리되는 동작을 구현하는 객체 
 */

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Override
	public String getServerTime() {
		return null;
	}
}
