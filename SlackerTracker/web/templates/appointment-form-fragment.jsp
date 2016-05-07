<%--
  Created by IntelliJ IDEA.
  User: Bdub
  Date: 4/2/16
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <fieldset>

    <!-- Interfaces.Form Name -->
    <legend>Details</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="apptTitle">Appointment Title:</label>
      <div class="col-md-6">
        <input id="apptTitle" name="apptTitle" type="text" placeholder="Appointment title" class="form-control input-md" >

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="startTime">Start Time:</label>
      <div class="col-md-6">
        <input id="startTime" name="startTime" type="time" placeholder="Start time" class="form-control input-md" >

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="endTime">End Time:</label>
      <div class="col-md-6">
        <input id="endTime" name="endTime" type="time" placeholder="End time" class="form-control input-md">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="date">Date:</label>
      <div class="col-md-6">
        <input id="date" name="date" type="date" class="form-control input-md">

      </div>
    </div>

  </fieldset>
