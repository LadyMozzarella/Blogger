Blogger
=======

##User Log in
User data is extremely simple. Username and password isn't encrypted or salted or anything. I didn't get to attempting to implement sessions, so the user must enter username and password upon creating every post and comment.

##Pages
 + The index page shows the posts listed beginning with the most recent at the top.
 + There's a create user page.
 + Creating a post as well as a comment require username and password. (Currently breaks if the log in information isn't correct... as well as on the user creation page.)
 + Creating comments is done on the individual post page.
 
##Styling
The design is super bootstrap.

##Database
The database is H2 (SQL, in-memory)

##Commands to get it up and running
1. Clone this repository

2. Run Maven
```
mvn package
```

3. Setup H2 Database
```
java -jar target/dBlogger-0.0.1-SNAPSHOT.jar db migrate Blogger.yml
```

4. Run Server
```
java -jar target/Blogger-0.0.1-SNAPSHOT.jar server Blogger.yml
```

5. View at http://localhost:8080

![https://i.imgur.com/H7EuvY8.png](https://i.imgur.com/H7EuvY8.png)
![http://i.imgur.com/CVhVOvY.png](http://i.imgur.com/CVhVOvY.png)
![https://i.imgur.com/MtEvTZR.png](https://i.imgur.com/MtEvTZR.png)
![https://i.imgur.com/1GU5Hry.png](https://i.imgur.com/1GU5Hry.png)
