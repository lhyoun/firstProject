<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>








<table>
	<tr>
		<td>제품 번호</td>
		<td>제품 이미지</td>
		<td>제품명</td>
		<td>가격</td>
		<td>카테고리</td>
	</tr>

<c:forEach var="pro" items="${list}">
<tr>
	<td>${pro.no}</td>
	<td>이미지 </td>
	<td>${pro.name}</td>
	<td>${pro.price}</td>
	<td>${pro.category}</td>
</tr>	
</c:forEach>
</table>





<footer>
  <div class="footerlink">
    <p class="lf">Copyright &copy; 2010 <a href="#">SiteName</a> - All Rights Reserved</p>
    <p class="rf">Design by <a href="http://www.templatemonster.com/">TemplateMonster</a></p>
    <div style="clear:both;"></div>
  </div>
</footer>
<!-- END PAGE SOURCE -->
</body>
</html>