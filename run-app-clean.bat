@echo off
git checkout main
git pull

cd .docker\postgresql

docker-compose down

docker volume rm postgresql_pgdata

docker-compose up -d

mvn spring-boot:run