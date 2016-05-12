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
  <body>
    <c:import url="${pageContext.request.contextPath}/templates/header-nav-bar-secure.jsp"/>

    <c:import url="${pageContext.request.contextPath}/templates/cal-div.jsp"/>
    <c:import url="${pageContext.request.contextPath}/templates/route-div.jsp"/>
    <c:import url="${pageContext.request.contextPath}/templates/edit-div.jsp"/>

    <!-- Modal -->
    <div class="modal fade" id="addAppointmentModal-page1" tabindex="-1" role="dialog"
         aria-labelledby="addAppointmentModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="addAppointmentModalLabel">Add Appointment</h4>
          </div>

          <div class="modal-body">
            <form action="make-appt" method="post">
              <div id="locationForm">
                <c:import
                    url="${pageContext.request.contextPath}/templates/location-form-fragment.jsp"/>
                <c:import
                    url="${pageContext.request.contextPath}/templates/appointment-form-fragment.jsp"/>
              </div>
              <button type="button" class="btn btn-warning" data-dismiss="modal">Cancel
              </button>
              <input type="submit" class="btn btn-success" value="submit" name="submit">
            </form>
          </div>

        </div>
      </div>
    </div>
  </body>
</html>