@echo off

docker-compose down

docker volume rm postgresql_pgdata

docker-compose up -d

mvn spring-boot:run