## Restaurant Vote Application

The task is:

Build a voting system for deciding where to have lunch.

- 2 types of users: admin and regular users
- Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
- Menu changes each day (admins do the updates)
-U sers can vote on which restaurant they want to have lunch at
- Only one vote counted per user

If user votes again the same day:
- If it is before 11:00 we asume that he changed his mind.
- If it is after 11:00 then it is too late, vote can't be changed

Each restaurant provides new menu each day.

### Stack
Used Implementation Stack: Spring/SpringMVC/SpringDataJPA/Hibernate/HSQLDB/SpringSecurity

### Curl samples:
> For windows use `Git Bash`

**Restaurant administration:**
- Get all restaurants
`curl -s http://localhost:8080/rest/admin/restaurants/ --user admin@gmail.com:admin`
- Add new restaurant
`curl -s -X POST -d '{"name":"Restaurant4"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/restaurants --user admin@gmail.com:admin`
- Delete restaurant with id=3
`curl -s -X DELETE http://localhost:8080/rest/admin/restaurants/3 --user admin@gmail.com:admin`
- Update restaurant with id=4
`curl -s -X PUT -d '{"name":"NewRestaurant"}' -H 'Content-Type: application/json' http://localhost:8080/rest/admin/restaurants/4 --user admin@gmail.com:admin`
- Get all restaurants with today menu
`curl -s http://localhost:8080/rest/admin/restaurants/today --user admin@gmail.com:admin`
- Filter all restaurants with menu between dates
`curl -s http://localhost:8080/rest/admin/restaurants/filter?startDate=2019-09-11&endDate=2019-09-12 --user admin@gmail.com:admin`

**Dishes administration:**
- Add new dish for restaurant with id=3
`curl -s -X POST -d '{"name":"Burger","price":10151}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/dishes/3 --user admin@gmail.com:admin`
- Delete dish with id=6
`curl -s -X DELETE http://localhost:8080/rest/admin/dishes/6 --user admin@gmail.com:admin`
- Update dish with id=7
`curl -s -X PUT -d '{"name":"Барбекю","price":9660}' -H 'Content-Type: application/json' http://localhost:8080/rest/admin/dishes/7 --user admin@gmail.com:admin`

**Register new user: **
`curl -s -X POST -d '{"name":"newUser","email":"newUser@yandex.ru","password":"newPassword"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/profile/register`

**Users administration:**
- Get all users
`curl -s http://localhost:8080/rest/admin/users --user admin@gmail.com:admin`
- Get user by id=2
`curl -s http://localhost:8080/rest/admin/users/2 --user admin@gmail.com:admin`
- Delete user with id=2
`curl -s -X DELETE http://localhost:8080/rest/admin/users/2 --user admin@gmail.com:admin`

**Vote system:**
- Vote for restaurant with id=3
`curl -s http://localhost:8080/rest/user/vote/3 --user user@yandex.ru:password`
- Get all votes for authorized user between dates
`curl -s http://localhost:8080/rest/user/filter?startDate=2019-09-11&endDate=2019-09-12 --user user@yandex.ru:password`
- Get today votes for authorized user
`curl -s http://localhost:8080/rest/user/votes/today --user user@yandex.ru:password`
