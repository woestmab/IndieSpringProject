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

  <legend>Location</legend>

  <!-- Street number input-->
  <div class="form-group">
    <label class="col-md-4 control-label" for="streetNumber">Street Number:</label>
    <div class="col-md-6">
      <input id="streetNumber" name="streetNumber" type="text" placeholder="Street Number" class="form-control input-md" ="">

    </div>
  </div>

  <!-- Street name input-->
  <div class="form-group">
    <label class="col-md-4 control-label" for="streetName">Street Name:</label>
    <div class="col-md-6">
      <input id="streetName" name="streetName" type="text" placeholder="Street Name" class="form-control input-md" ="">

    </div>
  </div>

  <!-- City input-->
  <div class="form-group">
    <label class="col-md-4 control-label" for="city">City:</label>
    <div class="col-md-6">
      <input id="city" name="city" type="text" placeholder="City" class="form-control input-md">

    </div>
  </div>

  <!-- State input-->
  <div class="form-group">
    <label class="col-md-4 control-label" for="state">State:</label>
    <div class="col-md-6">
      <input id="state" name="state" type="text" placeholder="State" class="form-control input-md">

    </div>
  </div>

  <!-- Zip input-->
  <div class="form-group">
    <label class="col-md-4 control-label" for="zip">Zip Code:</label>
    <div class="col-md-6">
      <input id="zip" name="zip" type="number" placeholder="Zip code" class="form-control input-md">

    </div>
  </div>
</fieldset>