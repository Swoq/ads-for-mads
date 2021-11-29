#!/bin/sh
docker run -d \
    -e POSTGRES_PASSWORD=postgres \
    -e PGDATA=/var/lib/postgresql/data/pgdata \
    -p 5432:5432 \
    -v /Users/mkratiuk/IdeaProjects/ads-for-mads/db-volume:/var/lib/postgresql/data \
    postgres