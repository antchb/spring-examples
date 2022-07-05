-- To run: Open psql and use command: \i FILE_PATH
-- For example:
-- /Applications/Postgres.app/Contents/Versions/14/bin/psql -U postgres
-- Enter Your Password if required. Settings for your local host you can find in 'pg_hba.conf' file
-- \i /Users/anthony/Development/github/spring-examples/rest/db/init_spring_rest_db.sql

CREATE DATABASE spring_rest_db;

\c spring_rest_db

CREATE SCHEMA IF NOT EXISTS spring_rest;

CREATE TABLE IF NOT EXISTS spring_rest.users (
  user_id SERIAL PRIMARY KEY,
  first_name VARCHAR(128) NOT NULL,
  last_name VARCHAR(128) NOT NULL,
  email VARCHAR(255) NOT NULL,
  upd_dt TIMESTAMP DEFAULT CURRENT_DATE
);

-- Users + Roles
CREATE USER spring_rest WITH ENCRYPTED PASSWORD 'spring_rest';
CREATE ROLE spring_rest_project_role WITH NOLOGIN CONNECTION LIMIT -1;

GRANT ALL ON SCHEMA spring_rest TO spring_rest_project_role;
GRANT ALL ON ALL TABLES IN SCHEMA spring_rest TO spring_rest_project_role;
GRANT ALL ON ALL SEQUENCES IN SCHEMA spring_rest TO spring_rest_project_role;
GRANT ALL ON ALL FUNCTIONS IN SCHEMA spring_rest TO spring_rest_project_role;
GRANT ALL ON ALL PROCEDURES IN SCHEMA spring_rest TO spring_rest_project_role;

GRANT spring_rest_project_role TO spring_rest;
