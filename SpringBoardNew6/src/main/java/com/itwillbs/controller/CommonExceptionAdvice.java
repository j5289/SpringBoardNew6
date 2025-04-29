package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * AOP 개념 사용
 * 보조기능을 구현 
 * 
 * => 공통의 예외를 처리하는 객체 
 */

//  @ControllerAdvice 
// => 컨트롤러에서 발생한 예외(보조기능)를 처리하는 객체선언

@ControllerAdvice 
public class CommonExceptionAdvice { 
	
	private static final Logger logger 
	= LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	//Exception - 모든 예외처리를 가능하게 함(업캐스팅 가능하게 하는)
	//@ExceptionHandler(예외처리 객체) 
	@ExceptionHandler(Exception.class) 
	public String common(Exception e) {
		logger.info("CommonExceptionAdvice_common() 실행");
		logger.info("예외 발생!");
		
		logger.info(""+e.toString()); //어떤 것 때문에 예외가 발생했는지 확인 가능!
		
		return "ITWILL";
	}
	
	//@ExceptionHandler(NumberFormatException.class)
//	@ExceptionHandler(NullPointerException.class)
//	public String common2() {
//		logger.info("CommonExceptionAdvice_common2() 실행");
//		logger.info("NumberFormatException 예외 발생!");
//		
//		return "ITWILL";
//	}
	
}
