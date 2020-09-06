<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>

<title>Product list</title>

<style>
img {
	display: block;
	margin: 0px auto;
}

.title {
	font-size: 30px;
	font: bold;
}

.category {
	font-size: 15px;
	float: right;
}

input {
	display: block;
	margin: 0 auto; width : 1000px;
	height: 50px;
	align-content: center;
	font-size: 15px;
	width: 1000px;
}

label{
	font-size: 20px;
	float: left;
}

.pname{
	font-size: 30px;
	font-weight: bold;
	text-align: center;
	border:none;
	background: transparent; 
}
</style>

<section id="content">
	<div class="container">
		<div id="mainContests" class="row">

			<c:forEach items="${list}" var="Pro">
				<div class="col-md-6 text-center">
					<div class="box col-1 maxheight">
						<div class="border-right maxheight">
							<div class="border-bot maxheight">
								<div class="border-left maxheight">
									<div class="left-top-corner maxheight">
										<div class="right-top-corner maxheight">
											<div class="right-bot-corner maxheight">
												<div class="left-bot-corner maxheight">
												
													<!-- 상품 리스트 -->
													<div class="inner">
														<!-- 상품 명 -->
														<div class="form-group">
															<input	type="text" class="form-control pname" id="exampleInputEmail1" value="${Pro.name}">
														</div>
														<br>
														<!-- 상품 이미지 -->														
														<ul class="info-list" style="text-align: center;">
															<li class="menu" style="display: inline-block;">
																<img src="${Pro.image_name}">
																
																<span style="font-size: 15px; float: left;">
																
																	<!-- 드롭다운 -->
																	<label for="exampleInputEmail1">구분</label>
																	<br><br>
																	<div class="btn-group" style="float: left;">
																		<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
																			카테고리 
																			<span class="caret"></span>
																		</button>
																		<ul class="dropdown-menu" role="menu">
																			<li><a href="#">카테고리</a></li>
																			<li><a href="#">Another action</a></li>
																			<li><a href="#">Something else here</a></li>
																			<li class="divider"></li>
																			<li><a href="#">Separated link</a></li>
																		</ul>
																	</div>
																	<br><br><br>
																		
																	<!-- 가격 -->
																	<div class="form-group">
																		<label for="exampleInputPassword1">가격</label>
																 	 	<input	type="text" class="form-control" id="exampleInputPassword1" value="${Pro.price}" disabled>
																	</div>
																	
																	<!-- 설명 -->
																	<div class="form-group">
																		<label for="exampleInputEmail1">상품 설명</label>
																		<textarea class="form-control" rows="5" disabled>${Pro.info}</textarea>
																	</div>
																</span>
															</li>
														</ul>
														
														
														<div class="aligncenter">
															<a href="#" class="link1"><span><span>Modify</span></span></a>
															<a href="#" class="link1"><span><span>Delete</span></span></a>
														</div>
														
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			
			
		</div>
	</div>
</section>

<script type="text/javascript">

</script>
</body>
</html>