INSERT INTO users (NAME, EMAIL, PASSWORD)
VALUES ('Admin', 'admin@gmail.com', 'admin'),
       ('User', 'user@yandex.ru', 'password');


INSERT INTO user_roles (USER_ID, ROLE)
VALUES (100000, 'ROLE_USER'),
       (100001, 'ROLE_ADMIN');

INSERT INTO restaurants (ID, NAME)
VALUES (100002, 'Restaurant1'),
       (100003, 'Restaurant2'),
       (100004, 'Restaurant3');

INSERT INTO menu (ID, RESTAURANT_ID)
VALUES (100005, 100002),
       (100006, 100003),
       (100007, 100004);

INSERT INTO dishes (NAME, PRICE, MENU_ID)
VALUES ('Dish1', 10000, 100005),
       ('Dish2', 1000, 100005),
       ('Dish3', 500, 100006),
       ('Dish4', 10015, 100006),
       ('Dish5', 200, 100007),
       ('Dish6', 1018, 100007)