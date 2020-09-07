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
			<!-- 상품 등록 -->
			<div class="col-md-12 text-center">
				<div class="box col-1 maxheight">
					<div class="border-right maxheight">
						<div class="border-bot maxheight">
							<div class="border-left maxheight">
								<div class="left-top-corner maxheight">
									<div class="right-top-corner maxheight">
										<div class="right-bot-corner maxheight">
											<div class="left-bot-corner maxheight">

												<!-- 상품등록 시작 -->
												<div class="inner">
													<span class="title">상품 등록</span>
													<br><br>
													<form action="write.do" enctype="multipart/form-data">
														<label for="exampleInputEmail1">구분</label>
														<br><br><br>
														<div class="btn-group" style="float: left;">
																<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
																	카테고리 <span class="caret"></span>
																</button>
															<ul class="dropdown-menu" role="menu">
															<c:forEach items="${list2}" var="ProC">
																<li><a href="#">${ProC.category}</a></li>
															</c:forEach>
<!-- 																<li class="divider"></li> -->
<!-- 																<li><a href="#">구분선 할거임?</a></li> -->
															</ul>
															<br>
														</div>
														
														<br><br><br><br>

														<div class="form-group">
															<label for="exampleInputEmail1">상품명</label>
															 <input	type="text" class="form-control" id="exampleInputEmail1" placeholder="상품명을 입력하세요">
														</div>
														<div class="form-group">
															<label for="exampleInputPassword1">가격</label>
															 <input	type="text" class="form-control" id="exampleInputPassword1" placeholder="가격을 입력하세요">
														</div>
														<div class="form-group">
															<label for="exampleInputEmail1">상품 설명</label>
															<textarea class="form-control" rows="5" placeholder="상품 설명을 입력하세요"></textarea>
														</div>
														<div class="form-group">
															<label for="exampleInputFile">상품 이미지</label>
															 <input	type="file" id="exampleInputFile">
														</div>
														<button type="submit" class="btn btn-default">등록</button>
													</form>
												</div>
												<!-- 상품등록 종료 -->
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

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
														<form>
															<div class="form-group">
																<input type="text" class="form-control pname" id="exampleInputEmail1" style="color: white;" value="${Pro.name}">
															</div>
															<br>
															<ul class="info-list" style="text-align: center;">
																<li class="menu">
																	<img src="${Pro.image_name}">
																	<span style="font-size: 15px; float: left;">
																		<label for="exampleInputEmail1">구분</label>
																		<br><br>
																		<div class="btn-group" style="float: left;">
																			<button type="button" class="btn btn-success dropdown-toggle active" data-toggle="dropdown" aria-expanded="false" style="background: #5CB85C;" disabled="disabled"> ${Pro.category}
																				
																			</button>

																		</div>
																		<br><br><br>
																		<div class="form-group">
																			<label for="exampleInputPassword1">가격</label>
																			 <input type="text" class="form-control" id="exampleInputPassword1" value="${Pro.price}" style="font-size: 20px; background: transparent;" disabled="disabled">																		</div>
																		<div class="form-group">
																			<label for="exampleInputEmail1">상품 설명</label>
																			 <textarea class="form-control" rows="5" style="background: transparent;" disabled="disabled">${Pro.info}</textarea>
																		</div>
																</li>
															</ul>
															<div class="aligncenter">
                                             					<a href="#" class="link1"><span><span>Modify</span></span></a>
                                             					<a href="#" class="link1"><span><span>Delete</span></span></a>
                                          					</div>
														</form>
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