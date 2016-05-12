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
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">SlackerTracker</a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li id="cal-li" class="active"><a id="cal-tab" href="#">Calendar</a></li>
          <li id="route-li"><a id="route-tab" href="#">Daily Routes</a></li>
          <li id="edit-li"><a id="edit-tab" href="#">Edit Appointments</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">

          <li>
            <a href="#" class="" data-toggle="modal"
                    data-target="#addAppointmentModal-page1">
              <span class="glyphicon glyphicon-calendar"></span> Add Appointment
            </a>
          </li>
          <li>
            <a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</header>