<%--
  Created by IntelliJ IDEA.
  User: Bdub
  Date: 2/13/16
  Time: 1:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Slacker Tracker</title>
    <c:import url="${pageContext.request.contextPath}/templates/head-links.jsp"/>
  </head>
  <body class="body-unsecure">
    <c:import url="${pageContext.request.contextPath}/templates/header-nav-bar.jsp"/>
    <div class="text-center white container">
      <h2>Welcome to SlackerTracker</h2>
      <h3>Maximize your time</h3>
      <h3>Focus on what matters</h3>
      <h3>Commute like a pro</h3>
    </div>
    <video autoplay="" loop="" class="fillWidth fadeIn animated"
           poster="https://s3-us-west-2.amazonaws.com/coverr/poster/Traffic-blurred2.jpg"
           id="video-background">
      <source src="https://s3-us-west-2.amazonaws.com/coverr/mp4/Traffic-blurred2.mp4"
              type="video/mp4">
      Your browser does not support the video tag. I suggest you upgrade your browser.
    </video>
  </body>
</html>