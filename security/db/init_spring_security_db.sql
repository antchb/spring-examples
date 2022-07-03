-- To run: Open psql and use command: \i FILE_PATH
-- For example:
-- /Applications/Postgres.app/Contents/Versions/14/bin/psql -U postgres
-- Enter Your Password if required. Settings for your local host you can find in 'pg_hba.conf' file
-- \i /Users/anthony/Development/github/spring-examples/security/db/init_spring_security_db.sql

CREATE DATABASE spring_security_db;

\c spring_security_db

CREATE SCHEMA IF NOT EXISTS spring_security;

CREATE TABLE IF NOT EXISTS spring_security.users (
  user_id SERIAL PRIMARY KEY,
  login_id VARCHAR(128) NOT NULL,
  password VARCHAR(128) NOT NULL,
  is_enabled BOOLEAN NOT NULL,
  salt VARCHAR(128),
  upd_dt TIMESTAMP DEFAULT CURRENT_DATE
);

CREATE TABLE IF NOT EXISTS spring_security.roles (
  role_id SERIAL PRIMARY KEY,
  name VARCHAR(128) NOT NULL,
  upd_dt TIMESTAMP DEFAULT CURRENT_DATE
);

CREATE TABLE IF NOT EXISTS spring_security.user_roles (
  user_id INT,
  role_id INT,
  upd_dt TIMESTAMP DEFAULT CURRENT_DATE,

  PRIMARY KEY(user_id, role_id),

  CONSTRAINT fk_user_roles_user_id
    FOREIGN KEY(user_id)
      REFERENCES spring_security.users(user_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,

  CONSTRAINT fk_user_roles_role_id
    FOREIGN KEY(role_id)
      REFERENCES spring_security.roles(role_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

-- Users + Roles
CREATE USER spring_security WITH ENCRYPTED PASSWORD 'spring_security';
CREATE ROLE spring_security_role WITH NOLOGIN CONNECTION LIMIT -1;

GRANT ALL ON SCHEMA spring_security TO spring_security_role;
GRANT ALL ON ALL TABLES IN SCHEMA spring_security TO spring_security_role;
GRANT ALL ON ALL SEQUENCES IN SCHEMA spring_security TO spring_security_role;
GRANT ALL ON ALL FUNCTIONS IN SCHEMA spring_security TO spring_security_role;
GRANT ALL ON ALL PROCEDURES IN SCHEMA spring_security TO spring_security_role;

GRANT spring_security_role TO spring_security;

-- Test Data. 'ROLE_' prefix is required if additional settings is not added to Spring

-- Credentials encoded with BCrypt [login_id:password]:
-- * admin:admin
-- * user:user
insert into spring_security.roles (name) values ('ROLE_ADMIN');
insert into spring_security.roles (name) values ('ROLE_USER');

insert into spring_security.users (login_id, password, is_enabled, salt ) values ('admin', '$2a$10$1YDg6PvV.aaB/e1tLHJ9deuMvw1XX.hBo2A3n7Lzp94KAEyam1JfW', true, null);
insert into spring_security.users (login_id, password, is_enabled, salt ) values ('user', '$2a$10$39wm7QqbPtyY/XQGPYwH8OfyE7WI5JYSeTpAtklbt.YyPyahRXYC.', true, null);

insert into spring_security.user_roles (user_id, role_id)
select u.user_id, r.role_id
from (select user_id from spring_security.users where login_id = 'admin') as u,
     (select role_id from spring_security.roles where name = 'ROLE_ADMIN') as r;
	 
insert into spring_security.user_roles (user_id, role_id)
select u.user_id, r.role_id
from (select user_id from spring_security.users where login_id = 'admin') as u,
     (select role_id from spring_security.roles where name = 'ROLE_USER') as r;
	 
insert into spring_security.user_roles (user_id, role_id)
select u.user_id, r.role_id
from (select user_id from spring_security.users where login_id = 'user') as u,
     (select role_id from spring_security.roles where name = 'ROLE_USER') as r;
