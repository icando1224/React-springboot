Docker Postgres run:

docker run --name postgres-spring -e POSTGRES_PASSWORD=passwd -d -p 5432:5432 postgres:alpine

docker exec -it 988d bin/bash

psql -U postgres

CREATE DATABASE spring_boot_postgres_db;
