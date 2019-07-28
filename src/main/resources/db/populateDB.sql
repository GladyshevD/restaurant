INSERT INTO users (name, email, password) VALUES
  ('Admin', 'admin@gmail.com', 'admin'),
  ('User', 'user@yandex.ru', 'password');


INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100001),
  ('ROLE_ADMIN', 100000);
