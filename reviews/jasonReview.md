# Design/Code Review 3

## Project:

### Developer:

#### Reviewer:

|Category|Criteria|Rating/Comments|
|--------|---------|---------------|
|**Project Overview**|| |
||Does the application function as planned and designed? Are all project objectives met?| |
||Does the GitHub history show regular progress on the project| |
||Was peer and instructor feedback/recommendations incorporated into the project?| |
||Other comments/notes?| |
|**JSPs**|| |
||Is templating used (for example, header.jsp, footer.jsp, etc.)?| |
||Is there business logic mixed in the JSPs?| |
||Does the site look professionl? Is it portfolio worthy?| |
||Is there validation of user input?| |
||Other comments/notes?| |
|**Java code quality**|Are methods single-purpose?| |
||Is the project well-structured with well-named packages for entity, controller, persistence, etc.?| |
||Are classes appropriately-sized  (no monster classes)?| |
||Are the same lines of code repeated at all?| | 
||Do any classes perform very similar functions that could be candidates for super/subclass relationships?| |
||Are any values hard-coded that should be in a properties file?| |
||Are best practices for naming variables, methods and classes followed?| |
||Are there many branches or loops that could be simplified or broken up into smaller methods?| |
||Do the DAOs use Hibernate? No hard-coded sql!| |
||Do the DAOs use Hibernate criteria wherever possible, minimizing the use of HQL?| |
||Is proper exception handling used?| |
||Is the code docmented appropriately?| |
||Other comments/notes?| |
|**Logging**|Has log4J been added?| |
||Is there an appropriate number of logging statements in the code for error logging and debugging?| |
||Are appropriate logging levels used? Info, debug, error, for example.| |
||Are there any System.out.printlns or printstacktrace() in the code?| |
||Are the logs properly written when running as a web application?| |
||Other comments/notes?| |
|**Unit Tests**|Do they exist?| |
||Do the tests pass?| |
||What is the current code coverage?| |
||Is each test truly a unit test or are they functional tests?| |
||Is redundant code eliminated by using set up and tear down methods, i.e., @Before, @After?| |
||Other comments/notes?| |
|**Security**|Has authentication/authorization been implemented?| |
||Are there some resources that only certain users can access?| |
||Are there some resources that everyone can access?| |
||Other comments/notes?| |
|**Web Service/API integration**|Which services/apis have been implemented? | |
||Is the service SOAP or RESTful?| |
||Are java objects created from the service response?| |
||Is the service used effectively in the project?| |
||Does the service implementation include error handling? For example, What happens if the service is not available?| |
||Other comments/notes?| |
|**Independent research topic**| What is the independent research topic?| |
||Is the independent research topic/technique implemented in the project?| |
||Other comments/notes?| |
|**Deployment**| Has the application been successfully deployed to Openshift or another hosting service?| |
||Is the hosted application fully functioning?| |
||Other comments/notes?| |