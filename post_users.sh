curl -H "Content-Type: application/json" -X POST -d '{"username":"Brittany", "password":"friends"}' http://localhost:8080/users
curl -H "Content-Type: application/json" -X POST -d '{"username":"Philip", "password":"fri"}' http://localhost:8080/users
curl -H "Content-Type: application/json" -X POST -d '{"username":"Entry 3!", "password":"fri"}' http://localhost:8080/users
curl -H "Content-Type: application/json" -X POST -d '{"title":"Coda Hale", "content" : "Chief Wizard of whatever and whatever", "user_id": "1" }' http://localhost:8080/posts
curl -H "Content-Type: application/json" -X POST -d '{"title":"Another Post", "content" : "Whatever and whatever sadfljoiwa savoav eaiojea", "user_id": "1" }' http://localhost:8080/posts
curl -H "Content-Type: application/json" -X POST -d '{"content" : "Chief Wizard of whatever and whatever sadfljoiwa savoav eaiojea", "user_id": "2", "post_id":"1" }' http://localhost:8080/comments
curl -H "Content-Type: application/json" -X POST -d '{"content" : "Another Chief Wizard of whatever and whatever sadfljoiwa savoav eaiojea", "user_id": "2", "post_id":"1" }' http://localhost:8080/comments

