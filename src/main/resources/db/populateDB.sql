INSERT INTO users (ID, NAME, EMAIL, PASSWORD)
VALUES (1, 'Admin', 'admin@gmail.com', 'admin'),
       (2, 'User', 'user@yandex.ru', 'password');


INSERT INTO user_roles (USER_ID, ROLE)
VALUES (1, 'ROLE_USER'),
       (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

INSERT INTO restaurants (ID, NAME)
VALUES (3, 'Restaurant1'),
       (4, 'Restaurant2'),
       (5, 'Restaurant3');

INSERT INTO dishes (ID, NAME, PRICE, RESTAURANT_ID)
VALUES (6, 'Dish1', 10000, 3),
       (7, 'Dish2', 1000, 3),
       (8, 'Dish3', 500, 4),
       (9, 'Dish4', 10015, 4),
       (10, 'Dish5', 200, 5),
       (11, 'Dish6', 1018, 5)