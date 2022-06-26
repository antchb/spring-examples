-- To run: Open psql and use command: \i FILE_PATH
-- For example:
-- /Applications/Postgres.app/Contents/Versions/14/bin/psql -U postgres
-- Enter Your Password if required. Settings for your local host you can find in 'pg_hba.conf' file
-- \i /Users/anthony/Development/github/spring-examples/db/init_mvc_hibernate_project.sql

CREATE DATABASE mvc_hibernate_project;

\c mvc_hibernate_project

CREATE SCHEMA IF NOT EXISTS users_control;

CREATE TABLE IF NOT EXISTS users_control.users (
  user_id SERIAL PRIMARY KEY,
  first_name VARCHAR(128) NOT NULL,
  last_name VARCHAR(128) NOT NULL,
  email VARCHAR(255) NOT NULL,
  upd_dt TIMESTAMP DEFAULT CURRENT_DATE
);

-- Users + Roles
CREATE USER antchb WITH ENCRYPTED PASSWORD 'antchb';
CREATE ROLE mvc_hibernate_project_role WITH NOLOGIN CONNECTION LIMIT -1;

GRANT ALL ON SCHEMA users_control TO mvc_hibernate_project_role;
GRANT ALL ON ALL TABLES IN SCHEMA users_control TO mvc_hibernate_project_role;
GRANT ALL ON ALL SEQUENCES IN SCHEMA users_control TO mvc_hibernate_project_role;
GRANT ALL ON ALL FUNCTIONS IN SCHEMA users_control TO mvc_hibernate_project_role;
GRANT ALL ON ALL PROCEDURES IN SCHEMA users_control TO mvc_hibernate_project_role;

GRANT mvc_hibernate_project_role TO antchb;
