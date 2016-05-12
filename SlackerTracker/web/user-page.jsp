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
    <c:if test="${not empty error}">
      <script>
        var message = "${error}";
        alert(message);
      </script>
    </c:if>
  </head>
  <body>
    <c:import url="${pageContext.request.contextPath}/templates/header-nav-bar-secure.jsp"/>

    <c:import url="${pageContext.request.contextPath}/templates/cal-div.jsp"/>
    <c:import url="${pageContext.request.contextPath}/templates/route-div.jsp"/>
    <c:import url="${pageContext.request.contextPath}/templates/edit-div.jsp"/>

    <!-- Modal -->
    <div class="modal fade" id="add-modal" tabindex="-1" role="dialog"
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

    <div class="modal fade" id="edit-modal" tabindex="-1" role="dialog"
         aria-labelledby="addAppointmentModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="editAppointmentModalLabel">Edit Appointment</h4>
          </div>

          <div class="modal-body">
            <form action="update-appt" method="post">
              <div id="editForms">

                <fieldset>

                  <legend>Location</legend>

                  <!-- Street number input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label" for="edit-streetNumber">Street Number:</label>
                    <div class="col-md-6">
                      <input id="edit-streetNumber" name="edit-streetNumber" type="text" placeholder="Street Number"
                             class="form-control input-md" required>
                    </div>
                  </div>

                  <!-- Street name input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label" for="edit-streetName">Street Name:</label>
                    <div class="col-md-6">
                      <input id="edit-streetName" name="edit-streetName" type="text" placeholder="Street Name"
                             class="form-control input-md" required>

                    </div>
                  </div>

                  <!-- City input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label" for="edit-city">City:</label>
                    <div class="col-md-6">
                      <input id="edit-city" name="edit-city" type="text" placeholder="City"
                             class="form-control input-md" required>
                    </div>
                  </div>

                  <!-- State input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label" for="edit-state">State:</label>
                    <div class="col-md-6">
                      <input id="edit-state" name="edit-state" type="text" placeholder="State"
                             class="form-control input-md" required>
                    </div>
                  </div>

                  <!-- Zip input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label" for="edit-zip">Zip Code:</label>
                    <div class="col-md-6">
                      <input id="edit-zip" name="edit-zip" type="number" placeholder="Zip code"
                             class="form-control input-md" required>

                    </div>
                  </div>
                </fieldset>
                <fieldset>

                  <!-- Interfaces.Form Name -->
                  <legend>Details</legend>

                  <input id="edit-id" type="number" name="edit-id" hidden>

                  <!-- Text input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label" for="edit-title">Appointment Title:</label>
                    <div class="col-md-6">
                      <input id="edit-title" name="edit-title" type="text" placeholder="Appointment title"
                             class="form-control input-md" required>
                    </div>
                  </div>

                  <!-- Text input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label" for="edit-start">Start Time:</label>
                    <div class="col-md-6">
                      <input id="edit-start" name="edit-start" type="time" placeholder="Start time"
                             class="form-control input-md" required>
                    </div>
                  </div>

                  <!-- Text input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label" for="edit-end">End Time:</label>
                    <div class="col-md-6">
                      <input id="edit-end" name="edit-end" type="time" placeholder="End time"
                             class="form-control input-md" required>
                    </div>
                  </div>

                  <!-- Text input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label" for="edit-date">Date:</label>
                    <div class="col-md-6">
                      <input id="edit-date" name="edit-date" type="date" class="form-control input-md" required>
                    </div>
                  </div>

                </fieldset>
              </div>
              <%--<button id="edit-delete-btn" type="button" class="btn btn-danger"--%>
                      <%--data-dismiss="modal">Delete--%>
              <%--</button>--%>
              <button type="button" class="btn btn-warning" data-dismiss="modal">Cancel
              </button>
              <input type="submit" class="btn btn-success" value="submit" name="Save">
            </form>
          </div>

        </div>
      </div>
    </div>

  </body>
</html>