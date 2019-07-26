#!/usr/bin/env bash
set -aex
DOCKER_UID=1000
DOCKER_GID=1000
DOCKER_COMPOSE_UP="docker-compose up"
DOCKER_COMPOSE_EXEC_ROOT="docker-compose exec -uroot -T"

if [ "$(docker ps -aq)" != '' ]
then
  docker rm -vf $(docker ps -aq)
  docker volume prune -f
else
  echo "no containers"
fi
echo 'source .env'

DB_BOOTSTRAP_FILE="pg-boostrap.dump"
${DOCKER_COMPOSE_UP} -d --no-recreate postgres || exit
sleep 10
${DOCKER_COMPOSE_EXEC_ROOT} "postgres" sh -c "pg_restore --host=localhost --dbname=${POSTGRES_DB} --username=${POSTGRES_USER} --clean --if-exists --no-acl --no-owner" || exit