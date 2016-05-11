<%--
  Created by IntelliJ IDEA.
  User: Bdub
  Date: 2/20/16
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Login</title>
    <c:import url="${pageContext.request.contextPath}/templates/head-links.jsp"/>
    <c:import url="${pageContext.request.contextPath}/templates/header-nav-bar.jsp"/>
  </head>
  <body class="body-unsecure">
    <h1 class="text-center h1-absolute">Login or sign up</h1>
    <c:import url="${pageContext.request.contextPath}/templates/login-form.jsp"/>

    <video autoplay="" loop="" class="fillWidth fadeIn animated"
           poster="https://s3-us-west-2.amazonaws.com/coverr/poster/Traffic-blurred2.jpg"
           id="video-background">
      <source src="https://s3-us-west-2.amazonaws.com/coverr/mp4/Traffic-blurred2.mp4"
              type="video/mp4">
      Your browser does not support the video tag. I suggest you upgrade your browser.
    </video>
  </body>
</html>
