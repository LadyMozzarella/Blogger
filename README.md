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
+ Clone this repository

+ Run Maven
```
mvn package
```
(or mvn clean install)

+ Run Server
```
java -jar target/Blogger-0.0.1-SNAPSHOT.jar server Blogger.yml
```

+ View at http://localhost:8080


###Homepage
![https://i.imgur.com/H7EuvY8.png](https://i.imgur.com/H7EuvY8.png)

###User Sign Up
![http://i.imgur.com/CVhVOvY.png](http://i.imgur.com/CVhVOvY.png)

###Create a Post
![https://i.imgur.com/MtEvTZR.png](https://i.imgur.com/MtEvTZR.png)

###View a Post, or Post a Comment
![https://i.imgur.com/1GU5Hry.png](https://i.imgur.com/1GU5Hry.png)


