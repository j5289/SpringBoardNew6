package com.itwillbs.controller;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {

	//DataSource 객체를 사용(java sql) => 객체를 주입해서 사용 
	@Inject
	private DataSource ds;
	
	@Test
	public void ds_test() {
		System.out.println("디비 연결정보 확인 테스트!");
		System.out.println("ds : "+ds);
	}
	
	
	
	
}
