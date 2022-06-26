-- IMPORTANT! This script will remove entire database including 'antchb' user and related role!

-- To run: Open psql and use command: \i FILE_PATH
-- For example:
-- /Applications/Postgres.app/Contents/Versions/14/bin/psql -U postgres
-- Enter Your Password if required. Settings for your local host you can find in 'pg_hba.conf' file
-- \i /Users/anthony/Development/github/spring-examples/db/drop_mvc_hibernate_project.sql

\c postgres

DROP DATABASE IF EXISTS mvc_hibernate_project WITH (FORCE);

DROP ROLE mvc_hibernate_project_role;
DROP USER antchb;
