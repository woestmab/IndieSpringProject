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
    <title>Welcome to the Slacker Tracker!</title>
    <c:import url="templates/head-links.jsp"/>
  </head>
  <body>
    <c:import url="templates/header-nav-bar.jsp"/>
    <input type="button" class="btn btn-default" id="backButton" value="Back">
    <div id="calendar"></div>
    <script type="text/javascript">

      calendar();

      var backButton = document.getElementById('backButton');
      backButton.onclick = calendar;

      function calendar() {
        var calendar = $("#calendar").calendar(
            {
              tmpl_path: "tmpls/",
              events_source: function () {
                return [
                  {
                    "id": 1,
                    "title": "Enterprise Java",
                    "url": "https://github.com/MadJavaEntSpring2016/Home",
                    "class": "event-success",
                    "start": 1456860816228, // Milliseconds
                    "end": 1456860818000 // Milliseconds
                  },
                  {
                    "id": 2,
                    "title": "PHP",
                    "url": "http://flibbertigiblets.com/phpWebDevMySQL/",
                    "class": "event-info",
                    "start": 1455222600000, // Milliseconds
                    "end": 1455229200000 // Milliseconds
                  }
                ];
              }
            });
      }
    </script>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-toggle="modal"
            data-target="#addAppointmentModal">
      Add Appointment
    </button>

    <!-- Modal -->
    <div class="modal fade" id="addAppointmentModal" tabindex="-1" role="dialog"
         aria-labelledby="addAppointmentModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="addAppointmentModalLabel">Add Appointment</h4>
          </div>
          <div class="modal-body">
            <form action="make-loc" method="post">
              <c:import url="templates/location-form-fragment.jsp"/>
              <c:import url="templates/appointment-form-fragment.jsp"/>
              <button type="button" class="btn btn-warning" onclick='' data-dismiss="modal">Cancel
              </button>
              <input type="submit" class="btn btn-success" name="submit" value="Submit">
            </form>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>