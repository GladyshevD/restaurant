### Curl samples.
> For windows use `Git Bash`

#### Add new restaurant
`curl -s -X POST -d '{"name":"Restaurant4"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/restaurants --user admin@gmail.com:admin`

#### Delete restaurant 100002
`curl -s -X DELETE http://localhost:8080/rest/admin/restaurants/100002 --user admin@gmail.com:admin`

#### Update restaurant 100002
`curl -s -X PUT -d '{"name":"NewRestaurant"}' -H 'Content-Type: application/json' http://localhost:8080/rest/admin/restaurants/100002 --user admin@gmail.com:admin`

#### Get all restaurants with today menu
`curl -s http://localhost:8080/rest/admin/restaurants --user admin@gmail.com:admin`


#### Register new user
`curl -s -X POST -d '{"name":"newUser","email":"newUser@yandex.ru","password":"newPassword"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/profile/register`

