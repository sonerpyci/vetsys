INSERT INTO role (id, name)
SELECT * FROM (SELECT 0, 'ADMIN') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM role WHERE name = 'ADMIN'
) LIMIT 1;


INSERT INTO user (id, `password`, username)
SELECT * FROM (SELECT 0, '$2a$10$l75./ti2yghugsZGNLLkOOW/VQ6si3o7yD0VqOAg7muFCy.C5oh9K', 'vetsysadmin') AS tmp
WHERE NOT EXISTS (
    SELECT username FROM user WHERE username = 'vetsysadmin'
) LIMIT 1;

INSERT INTO user_roles (users_id, roles_id)
SELECT * FROM (SELECT 1 as users_id, 1 as roles_id) AS tmp
WHERE NOT EXISTS (
    SELECT users_id, roles_id FROM user_roles WHERE roles_id = 1 and users_id=1
) LIMIT 1;
