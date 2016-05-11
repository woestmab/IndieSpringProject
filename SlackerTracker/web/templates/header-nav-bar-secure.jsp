<header>
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">SlackerTracker</a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li class="active"><a id="cal-tab" href="#">Calendar</a></li>
          <li><a id="route-tab" href="#">Daily Routes</a></li>
          <%----%>
          <%--<li><a href="https://www.google.com/maps" target="blank">Google Maps--%>
            <%--Maps</a></li>--%>
          <%--<li><a href="http://www.cityofmadison.com/metro/" target="blank">Madison Metro</a></li>--%>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#"><span
              class="glyphicon glyphicon-user">

          </span> Sign Up</a>
          </li>
          <li><a href="${pageContext.request.contextPath}/secure/secure-test.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</header>