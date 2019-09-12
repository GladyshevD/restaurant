### Curl samples.
> For windows use `Git Bash`


#### Get all restaurants
`curl -s http://localhost:8080/rest/admin/restaurants/ --user admin@gmail.com:admin`

#### Add new restaurant
`curl -s -X POST -d '{"name":"Restaurant4"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/restaurants --user admin@gmail.com:admin`

#### Delete restaurant 100002
`curl -s -X DELETE http://localhost:8080/rest/admin/restaurants/100002 --user admin@gmail.com:admin`

#### Update restaurant 100002
`curl -s -X PUT -d '{"name":"NewRestaurant"}' -H 'Content-Type: application/json' http://localhost:8080/rest/admin/restaurants/100002 --user admin@gmail.com:admin`

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

