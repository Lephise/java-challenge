### How to use this spring-boot project

The same as before applies so this remains unchanged!

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.


#### Comments and thoughts about my changes

First things I noticed in the project was that Department did not have its own entity, instead only being a string inside Employee. I am very interested in entity and database design, so this was the main issue
I wanted to tackle. Given the limited time I had to work on this during this week I decided that this will serve as my main goal, with other changes to be done if I had time. I also think that opting to do this
change instead of just following your suggestions would hopefully show a bit about my skills, my interests and my way of thinking. 

The changelist:
- Created new Entity for Departments
- Created controller and endpoints for Department operations
- Created Department repository for data persistence
- Changed the department field of Employee to be foreign key (department_id) using the @ManyToOne.
- Added very basic security for endpoints
	- Roles:
		- USER: limited for viewing data only (no POST, PUT, DELETE allowed!)
		- ADMIN: free access to anything
	- Two users:
		- Username: user, Password: user (Role: USER)
		- Username: admin, Password: admin (Role: ADMIN)
		
As for git, in real life scenario more commits and perhaps even branching would be good. This just has one big commit which might not always be the best idea.

#### Ideas for improvement (in other words, what I didnt have time to implement)

Even with such a small application like this, there would be plenty to improve upon. Some ideas in rough order of priority if I was to work on this alone(including your ideas too), however I think the 4 first points are critical.
- Tests
	- Plenty of work here. Writing the tests itself, but also would be beneficial to write mock database calls etc. 
- Proper logging! Now we barely use some System.outs. Use of logger would be highly recommended.
- Improved security
	- Database stored users with user registration available instead of default inmemory users.
	- Authentication token based authentication, for example Oauth. Current one uses basic auth with Spring sessions.
	- Restrict editing of employee details to only the employee themseleves and admin. You could use the security contexts .getPrincipal to do this for the employees for example.
- Improve existing APIs
	- ID of Employee or Department is now never returned when just listing them. Depending on the need, we might need to change this. For now I regarded them as just list without any reference to their IDs,
	this however makes updating data near impossible, since you have no way of knowing which ID to update.
	- Unify responses to match some agreed form.
	- Write better swagger doc
	- Check and verify that all functions and database calls work properly
- Fix the ModelMapper issue (see EmployeeController, getEmployees()). I had no time to find proper way to use the ModelMapper for this, thus the related object Department is just manually assigned to the Employee
inside a loop instead of ModelMapper correctly mapping all nested Entities that are needed.
- Caching. While very important to save resources, I think this is of lower priority at this point. I would assume no heavy load would be put on the server, that is it would never be in production use, before having fixed all of the above.


#### Experience in Java

- About 2 years and 8 months working as Java Web Developer. Mostly designing and implementing APIs using Spring Framework. 
- Some experience on using Spring Websockets for realtime data transfer (audio data).
- Experience in creating Criteria based queries using Hibernate.
- Reading codebases of existing Java projects to understand as well as to fix bugs.
- Have used Spring Boot for just this and some school project(s).


#### Final Comments 

Thank you for the assignment. I really think this was the best thought out development assignment I have encountered so far. I think its fantastic that you provide a working project that you are supposed to improve upon, instead of 
a leetcode type coding challenge or a ground up built project. I think you manage to keep the time requirement fair as well as this really simulates "the usual" scenario of hopping to an existing project as a new developer well, in small scale, but still. 

Also thank you for the opportunity. I myself am not perfectly happy with what I can provide you with this time, but I did best that I could with very limited time that I could spare during one weekend to work on this. I still think I managed to somewhat meet my 
goal that I set at the beginning that I could achieve in some hours of work, so in that sense I feel like it was a success too!

I really look forward to hearing from you and I would be grateful to hear any feedback no matter the outcome about this. I really enjoyed this challenge, so thank you again!

Have a nice Spring!

