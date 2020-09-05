<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
<title>주문 현황</title>
<section id="content">
	<div class="container">
		<div id="mainContests" class="row">

			<c:set var="i" value="0"/>


			<c:forEach items="${ttt}" var="ttt">
				<%-- <c:if test="${order.order_state eq '주문완료' }"> --%>
				<div class="col-md-3 text-center">
					<div class="box col-1 maxheight">
						<div class="border-right maxheight">
							<div class="border-bot maxheight">
								<div class="border-left maxheight">
									<div class="left-top-corner maxheight">
										<div class="right-top-corner maxheight">
											<div class="right-bot-corner maxheight">
												<div class="left-bot-corner maxheight">

													<div class="inner">
														<h4>Order number : ${ttt.order_num}</h4>
														<a>주문시간 :${list[i].order_time}</a> <br>
														<ul class="info-list">
														
															
															<li class="menu"><span>메뉴</span>옵션</li>
															<c:forEach begin="0" end="${ttt.order_count-1}" step="1" varStatus="status">
																<li><span>${list[i].name}</span>${list[i].user_option}</li>
																
																<c:set var="i" value="${i+1}"/>
															</c:forEach>
															
															<!-- <li class="menu"><span>총 수량</span>수량(DB)</li> -->
															
														</ul>
														<div class="aligncenter">
															<a href="asas.do?no=${ttt.order_num}" class="link1"><span><span>Done</span></span></a>
														</div>
														<!-- 위에 버튼 누르면 DB에 상태를 1로 업데이트 해줘야 함 -->
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
				<%-- </c:if> --%>
			</c:forEach>


		</div>
	</div>
</section>
<!-- </div> -->
<aside></aside>

<script type="text/javascript">
	Cufon.now();
</script>
<!-- END PAGE SOURCE -->
</body>
</html>