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
    <c:import url="/templates/head-links.jsp"/>
  </head>

  <body class="body-unsecure" id="body-index">
    <c:import url="/templates/header-nav-bar.jsp"/>
    <a href="${pageContext.request.contextPath}/user-page.jsp">
    <div class="text-center white container">
      <h1>Welcome to SlackerTracker</h1>
      <div class=" white">
        <div class="row">

          <div class="col-sm-4"><h3>Add Appointments</h3>
            <img class="img-responsive center-block"
                 src="${pageContext.request.contextPath}/img/icons/svg/calendar.svg"
                 alt="Calendar">
          </div>

          <div class="col-sm-4"><h3>Check Schedule</h3>
            <img class="img-responsive center-block"
                 src="${pageContext.request.contextPath}/img/icons/svg/retina.svg" alt="">
          </div>

          <div class="col-sm-4"><h3>Away you go!</h3>
            <img class="img-responsive center-block"
                 src="${pageContext.request.contextPath}/img/icons/svg/map.svg" alt="">
          </div>
        </div>
        <div class="container">
          <h2>Click to begin your journey</h2>
        </div>
      </div>
    </div>
    <video autoplay="" loop="" class="fillWidth fadeIn animated"
           poster="https://s3-us-west-2.amazonaws.com/coverr/poster/Traffic-blurred2.jpg"
           id="video-background">
      <source src="https://s3-us-west-2.amazonaws.com/coverr/mp4/Traffic-blurred2.mp4"
              type="video/mp4">
      Your browser does not support the video tag. I suggest you upgrade your browser.
    </video>
    </a>
  </body>
</html>