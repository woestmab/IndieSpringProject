# Design/Code Review 3

## Project: YouDeserveBetterToday

### Developer: Nancy Meister

#### Reviewer: Brian Woestman

|Category|Criteria|Rating/Comments|
|--------|---------|---------------|
|**Project Overview**|| |
||Does the application function as planned and designed? Are all project objectives met?| Yes |
||Does the GitHub history show regular progress on the project| Yes |
||Was peer and instructor feedback/recommendations incorporated into the project?| Yes |
||Other comments/notes?| N/A |
|**JSPs**|| |
||Is templating used (for example, header.jsp, footer.jsp, etc.)?| Yes |
||Is there business logic mixed in the JSPs?| No |
||Does the site look professionl? Is it portfolio worthy?| Yes |
||Is there validation of user input?| Yes |
||Other comments/notes?| N/A |
|**Java code quality**|Are methods single-purpose?| Yes |
||Is the project well-structured with well-named packages for entity, controller, persistence, etc.?| Yes |
||Are classes appropriately-sized  (no monster classes)?| Yes |
||Are the same lines of code repeated at all?| No | 
||Do any classes perform very similar functions that could be candidates for super/subclass relationships?| No |
||Are any values hard-coded that should be in a properties file?| No |
||Are best practices for naming variables, methods and classes followed?| Yes |
||Are there many branches or loops that could be simplified or broken up into smaller methods?| None |
||Do the DAOs use Hibernate? No hard-coded sql!| Yes / No hardcoded values |
||Do the DAOs use Hibernate criteria wherever possible, minimizing the use of HQL?| Yes |
||Is proper exception handling used?| Yes |
||Is the code docmented appropriately?| Yes |
||Other comments/notes?| N/A |
|**Logging**|Has log4J been added?| Yes |
||Is there an appropriate number of logging statements in the code for error logging and debugging?| Yes |
||Are appropriate logging levels used? Info, debug, error, for example.| Yes |
||Are there any System.out.printlns or printstacktrace() in the code?| No |
||Are the logs properly written when running as a web application?| Yes |
||Other comments/notes?| N/A |
|**Unit Tests**|Do they exist?| Yes |
||Do the tests pass?| Yes |
||What is the current code coverage?| 35% |
||Is each test truly a unit test or are they functional tests?| Yes |
||Is redundant code eliminated by using set up and tear down methods, i.e., @Before, @After?| Yes |
||Other comments/notes?| N/A |
|**Security**|Has authentication/authorization been implemented?| Yes |
||Are there some resources that only certain users can access?| Yes |
||Are there some resources that everyone can access?| Yes |
||Other comments/notes?| N/A |
|**Web Service/API integration**|Which services/apis have been implemented? | Working through Google maps usage for Java |
||Is the service SOAP or RESTful?| No |
||Are java objects created from the service response?| N/A |
||Is the service used effectively in the project?| N/A |
||Does the service implementation include error handling? For example, What happens if the service is not available?| N/A |
||Other comments/notes?| N/A |
|**Independent research topic**| What is the independent research topic?| Google maps API |
||Is the independent research topic/technique implemented in the project?| Not yet |
||Other comments/notes?| N/A |
|**Deployment**| Has the application been successfully deployed to Openshift or another hosting service?| No |
||Is the hosted application fully functioning?| No |
||Other comments/notes?| N/A |