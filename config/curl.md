### Curl samples.
> For windows use `Git Bash`


#### Get all restaurants
`curl -s http://localhost:8080/rest/admin/restaurants/ --user admin@gmail.com:admin`
#### Add new restaurant
`curl -s -X POST -d '{"name":"Restaurant4"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/restaurants --user admin@gmail.com:admin`
#### Delete restaurant with id=3
`curl -s -X DELETE http://localhost:8080/rest/admin/restaurants/3 --user admin@gmail.com:admin`
#### Update restaurant with id=4
`curl -s -X PUT -d '{"name":"NewRestaurant"}' -H 'Content-Type: application/json' http://localhost:8080/rest/admin/restaurants/4 --user admin@gmail.com:admin`
#### Get all restaurants with today menu
`curl -s http://localhost:8080/rest/admin/restaurants/today --user admin@gmail.com:admin`
#### Filter all restaurants with menu between dates
`curl -s http://localhost:8080/rest/admin/restaurants/filter?startDate=2019-09-11&endDate=2019-09-12 --user admin@gmail.com:admin`


#### Add new dish for restaurant with id=3
`curl -s -X POST -d '{"name":"Burger","price":10151}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/dishes/3 --user admin@gmail.com:admin`
#### Delete dish with id=6
`curl -s -X DELETE http://localhost:8080/rest/admin/dishes/6 --user admin@gmail.com:admin`
#### Update dish with id=7
`curl -s -X PUT -d '{"name":"Барбекю","price":9660}' -H 'Content-Type: application/json' http://localhost:8080/rest/admin/dishes/7 --user admin@gmail.com:admin`


#### Register new user
`curl -s -X POST -d '{"name":"newUser","email":"newUser@yandex.ru","password":"newPassword"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/profile/register`


#### Get all users
`curl -s http://localhost:8080/rest/admin/users --user admin@gmail.com:admin`
#### Get user by id=2
`curl -s http://localhost:8080/rest/admin/users/2 --user admin@gmail.com:admin`
#### Delete user with id=2
`curl -s -X DELETE http://localhost:8080/rest/admin/users/2 --user admin@gmail.com:admin`


#### Vote for restaurant with id=3
`curl -s http://localhost:8080/rest/user/vote/3 --user user@yandex.ru:password`
#### Get all votes for authorized user between dates
`curl -s http://localhost:8080/rest/user/filter?startDate=2019-09-11&endDate=2019-09-12 --user user@yandex.ru:password`
#### Get today votes for authorized user
`curl -s http://localhost:8080/rest/user/votes/today --user user@yandex.ru:password`
