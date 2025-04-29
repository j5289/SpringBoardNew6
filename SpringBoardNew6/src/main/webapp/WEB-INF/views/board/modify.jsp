<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<h1>/board/modify.jsp</h1>

<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">게시판 글수정</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
	<!-- action해당하는 속성정보가 없음
	      =>자기 자신의 페이지 호출
	        (/board/regist 호출)
	 -->
	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">번  호</label>
				<input type="text" name="bno" class="form-control" id="exampleInputEmail1"
				       value="${boardVO.bno }" readonly>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">제 목</label>
				<input type="text" name="title" class="form-control" id="exampleInputEmail1"
				       value="${boardVO.title }">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">작성자</label>
				<input type="text" name="writer" class="form-control" 
				id="exampleInputEmail1" value="${boardVO.writer }">
			</div>
			<div class="form-group">
				<label>내  용</label>
				<textarea name="content" class="form-control" rows="3" 
				                 >${boardVO.content }</textarea>
			</div>
		</div>
		<!-- /.box-body -->

		<div class="box-footer">
			<button type="submit" 
			    class="btn btn-primary">글수정</button>
		</div>
	</form>
</div>

<%@ include file="../include/footer.jsp"%>


