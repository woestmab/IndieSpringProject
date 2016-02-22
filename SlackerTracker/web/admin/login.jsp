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
    <c:import url="../templates/header-links.jsp"/>
  </head>
  <body>
    <div class="container">
      <FORM class="form-horizontal" ACTION="j_security_check" METHOD="POST">
        <div class="form-group">
          <label class="col-sm-2 control-label" for="j_username">User
            name </label>
          <div class="col-sm-10">
            <INPUT class="form-control" id="j_username" TYPE="TEXT"
                   NAME="j_username" placeholder="User name">
          </div>
        </div>
        <div class="form-group">
          <label for="j_password"
                 class="col-sm-2 control-label">Password</label>
          <div class="col-sm-10">
            <INPUT class="form-control" id="j_password" TYPE="PASSWORD"
                   NAME="j_password" placeholder="Password">
          </div>
        </div>
        <div class="col-sm-offset-2 col-sm-10">
          <INPUT class="btn btn-primary" TYPE="SUBMIT" VALUE="Log In">
        </div>
      </FORM>
    </div>
  </body>
</html>
