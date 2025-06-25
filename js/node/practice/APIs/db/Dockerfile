From postgres:17-alpine3.21

ENV POSTGRES_DB=booktraking \
    POSTGRES_USER=me \
# I know this should be an env value
    POSTGRES_PASSWORD=mypass 

COPY ./data /data
COPY ./init.sql /docker-entrypoint-initdb.d/
COPY ./load_data.sh /docker-entrypoint-initdb.d/
RUN chmod +x /docker-entrypoint-initdb.d/load_data.sh

EXPOSE 5432
