-- IMPORTANT! This script will remove entire database including 'spring_boot' user and related role!

-- To run: Open psql and use command: \i FILE_PATH
-- For example:
-- /Applications/Postgres.app/Contents/Versions/14/bin/psql -U postgres
-- Enter Your Password if required. Settings for your local host you can find in 'pg_hba.conf' file
-- \i /Users/anthony/Development/github/spring-examples/boot/db/drop_spring_boot_db.sql

\c postgres

DROP DATABASE IF EXISTS spring_boot_db WITH (FORCE);

DROP ROLE spring_boot_project_role;
DROP USER spring_boot;
