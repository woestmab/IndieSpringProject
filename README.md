# IndieSpringProject - SlackerTracker
## Website to help with transit scheduling
### Problem:
   Transportation to and from school / work is confusing and complicated.  It would be much easier to enter my schedule into a web app and have it calculate the best routes each day to make efficient use of my time.  Ideally I would also like to implement a system to take weather into account and suggest either a bus or bike solution.

# Project Plan

* Week 2 - Project Plan and Problem Statement.

* Week 3 - Get bus route data from Madison Metro and create a database to hold all of the route information sorted into appropriate tables.
	[X] https://developers.google.com/transit/?hl=en

* Week 4 - Design & Wireframe.  
	[X] Create illustrations to show how the site will be laid out.
	[X] Color considerations and styles will be added along with some notes about animation and extra "flashy" features and ideas.

* Week 5 - UML & ER diagramming for they system to show how the entire project will function from front end to back.
	[X] Diagram classes
	[X] Research design patterns (ongoing)
	[X] Figure out how to integrate Spring framework

* Week 6 - Create unit testing that must be passed during each stage of the project.
	[X] Tests for backend
	[] Tests for frontend (how?)
	[X] Tests for data
	
* Week 7
    [] Create dao
    [X] Create POJOS
    [X] Implement use for Spring Framework <- update this with more info after research
    
* Week 8
    [] Create business logic
    [] Use framework to pass JSON data to frontend - Gson object should do what I want

* Week 9 - 10 - Prototype and build Interactive calendar for entering schedule from website.
	[X] Clickable dates
	[] Popup for schedule entry
	[X] Calendar pages displaying each month

* Week 10 - 12 - Figure out how to calculate the routes and to determine what times are best for the set schedule.
	[] Incorporate Google API (likely a good way to figure out routes)
	[X] See if any frameworks could help with scheduling

* Week 13 - 15 - Testing and bug fixes.