<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>

<title>완료된 주문 목록</title>     
   <section id="content">
    <div class="container">
		<div id="mainContests" class="row">
	      <c:forEach items="${list}" var="order">
	      <c:if test="${order.order_state eq '수령완료' }">
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
	                            <h4>Order number : ${order.order_code}</h4>
	                            	<a>주문시간 : ${order.order_time}</a>
	                            	<br>
	                            <ul class="info-list">
	                              <li class="menu"><span>메뉴</span>수량</li>
	                              <li><span>${order.pno}</span></li>
	                              <li class="menu"><span>총 수량</span>수량(DB)</li>
	                            </ul>
	                            <div class="aligncenter"><a href="#" class="link1"><span><span>Done</span></span></a></div>
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
       </c:if>
	       </c:forEach>
      </div>
    </div>
  </section>
</div>
<aside>
</aside>
<footer>
  <div class="footerlink">
    <p class="lf">Copyright &copy; 2010 <a href="#">SiteName</a> - All Rights Reserved</p>
    <p class="rf">Design by <a href="http://www.templatemonster.com/">TemplateMonster</a></p>
    <div style="clear:both;"></div>
  </div>
</footer>
<script type="text/javascript"> Cufon.now(); </script>
<!-- END PAGE SOURCE -->
</body>
</html>