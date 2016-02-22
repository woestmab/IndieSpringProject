<%--
  Created by IntelliJ IDEA.
  User: Bdub
  Date: 2/20/16
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <form ACTION="j_security_check" METHOD="POST">
      User name: <INPUT TYPE="TEXT" NAME="j_username"><br>
      Password: <INPUT TYPE="PASSWORD" NAME="j_password"><br>
      <INPUT TYPE="SUBMIT" VALUE="Log In">
    </form>
  </body>
</html>
