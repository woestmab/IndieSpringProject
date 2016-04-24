<%--
  Created by IntelliJ IDEA.
  User: Bdub
  Date: 4/2/16
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="make-loc" method="post">

  <label for="streetNumber">Street Number</label>
  <input type="text" id="streetNumber" name="streetNumber">

  <label for="streetName">Street Name</label>
  <input type="text" id="streetName" name="streetName">

  <label for="city">City</label>
  <input type="text" id="city" name="city">

  <label for="state">State</label>
  <input type="text" id="state" name="state">

  <label for="zip">Zip</label>
  <input type="text" id="zip" name="zip">

  <input type="submit" value="Submit" name="submit">

</form>