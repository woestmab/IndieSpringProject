# Design/Code Review 2

## Project: CraigsBook

### Developer: Ran Yim

#### Reviewer: Brian Woestman

|Category|Criteria|Rating/Comments|
|--------|---------|---------------|
|**Problem Statement**|Does it exist?| reviewer rating/comments go here|
| |Does the problem statement accurately describe project purpose?| Yes |
| |Is the problem statement professional? Think of prospective employers viewing this as part of the developer's portfolio.| Yes |
| |What is good?| It does a good job of conveying the problem and solution |
| |What could be improved?| N/A |
|**Project Plan**|Does it exist?| Yes |
| |Does it demonstrate the developer has thought about all the tasks needed to complete the project?| No | 
| |Does it provide enough detail to guide the developer through their development?| No | 
| |What is good?| Updated with more info | 
| |What could be improved?| Looks good |
|**UI design**|Does it exist?| Yes |
| |Is the navigation/flow through the application logical and easy to use?| Yes |
| |Is the order in which the fields are displayed and form fields entered logical and easy to use?| Yes |
| |What data missing?| Messaging area might need more info if it's incorporated to the final plan |
| |Is there data that is not used?| No |
| |What is good?| It looks professional and well designed |
| |What could be improved?| Finalize the layout |
|**Data model**|Does it exist?| No |
|**Additional design documents**| Yes | |
| |Is everything on the screens represented in the model?| Yes |
| |Does the model represent good database design? | Needs more normalization |
| |What is good?| The tables seem appropriate for the data |
| |What could be better?| Use same term for FK in other table |
|**Application structure in IntelliJ**|Does it exist?| Yes |
| |src directory with well-named packages for entity, controller, persistence| Yes |
| |tests directory|  |
| |web directory|  |
| |Other comments/notes?|  |
|**JSPs**|Do they exist?| Yes |
| |Is templating used (for example, header.jsp, footer.jsp, etc.)?| Yes |
| |Is there business logic mixed in the JSPs?| No |
| |CSS?| Yes |
| |Other comments/notes?| Already created a few separate pages |
|**Entities/DAOs/Controllers**|Do they exist?| Yes |
|**Java code quality**|Are methods single-purpose?| Yes |
| |Are classes appropriately-sized classes (no monster classes)?| No |
| |Are the same lines of code repeated at all?| No | 
| |Do any classes perform very similar functions that could be candidates for super/subclass relationships?| No |
| |Are any values hard-coded that should be in a properties file?| No |
| |Are variable names descriptive?| Yes |
| |Are there many branches or loops that could be simplified or broken up into smaller methods?| Maybe |
| |Do the DAOs use Hibernate? No hard-coded sql!| No |
| |Other comments/notes?| Looks good |
|**Logging**|Has log4J been added?| Yes |
| |Are there logging statements in the code?| Yes |
| |Are appropriate logging levels used? Info, debug, error, for example.| Yes |
| |Are there any System.out.printlns in the code?| No |
| |Other comments/notes?| n/a |
|**Unit Tests**|Do they exist?| Yes |
| |Do the tests pass?| Yes |
| |What is the current code coverage?| Medium |
| |Is each test truly a unit test or are they functional tests?| Unit |
| |Other comments/notes?| Lots of tests - good job |
|**Web Service/API integration**|Has a web service/api been selected? | No |
| |What web services/apis might work well with this application?| Amazon or Google |
|**Independent research topic**| Has a topic been selected?| No |
| |What topic/s might fit well in this application?| An api for messages might be a good thing to research |