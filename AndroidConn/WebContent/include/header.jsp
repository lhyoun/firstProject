<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<link rel="stylesheet" href="css/bootstrap.css">

<script type="text/javascript" src="js/maxheight.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-replace.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_300.font.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_400.font.js"></script>
<script type="text/javascript" src="js/jquery.faded.js"></script>
<script type="text/javascript" src="js/jquery.jqtransform.js"></script>
<script type="text/javascript">
$(function () {
    $("#faded").faded({
        speed: 500,
        crossfade: true,
        autoplay: 10000,
        autopagination: false
    });
    $('#domain-form').jqTransform({
        imgPath: 'images/'
    });
});
</script>
</head>
<body onresize="parent.resizeTo(500, 400)" onload="parent.resizeTo(500, 400)" 
id="page1" onLoad="new ElementMaxHeight();">
<!-- START PAGE SOURCE -->
<!--     <div class="tail-top"> -->
    <header>
    <div class="container">
      <div class="header-box">
        <div class="left">
          <div class="right">
            <nav>
              <ul>
                <li class="current"><a href="order.do"><cufon class="cufon cufon-canvas" alt="Order List" style="width: 50px; height: 18px;"><canvas width="58" height="22" style="width: 58px; height: 22px; top: -2px; left: -1px;"></canvas><cufontext>Order List</cufontext></cufon></a></li>
                <li><a href="complete.do"><cufon class="cufon cufon-canvas" alt="Complete Order List" style="width: 73px; height: 18px;"><canvas width="82" height="22" style="width: 82px; height: 22px; top: -2px; left: -1px;"></canvas><cufontext>Complete Order List</cufontext></cufon></a></li>
                <li><a href="Product.do"><cufon class="cufon cufon-canvas" alt="Product Registration" style="width: 72px; height: 18px;"><canvas width="79" height="22" style="width: 79px; height: 22px; top: -2px; left: -1px;"></canvas><cufontext>Product Registration</cufontext></cufon></a></li>
<%--                 <li><a href="solutions.html"><cufon class="cufon cufon-canvas" alt="Solutions" style="width: 90px; height: 18px;"><canvas width="99" height="22" style="width: 99px; height: 22px; top: -2px; left: -1px;"></canvas><cufontext>Solutions</cufontext></cufon></a></li> --%>
<%--                 <li><a href="support.html"><cufon class="cufon cufon-canvas" alt="Support" style="width: 74px; height: 18px;"><canvas width="82" height="22" style="width: 82px; height: 22px; top: -2px; left: -1px;"></canvas><cufontext>Support</cufontext></cufon></a></li> --%>
<%--                 <li><a href="contacts.html"><cufon class="cufon cufon-canvas" alt="Contacts" style="width: 84px; height: 18px;"><canvas width="93" height="22" style="width: 93px; height: 22px; top: -2px; left: -1px;"></canvas><cufontext>Contacts</cufontext></cufon></a></li> --%>
              </ul>
            </nav>
            <h1><a href="order.do"><span><cufon class="cufon cufon-canvas" alt="Order" style="width: 91px; height: 36px;"><canvas width="113" height="41" style="width: 113px; height: 41px; top: -5px; left: -2px;"></canvas><cufontext>Order</cufontext></cufon></span><cufon class="cufon cufon-canvas" alt=" List" style="width: 55px; height: 36px;"><canvas width="77" height="42" style="width: 77px; height: 42px; top: -5px; left: -2px;"></canvas><cufontext> List</cufontext></cufon></a></h1>
          </div>
        </div>
      </div>
    </div>
  </header>