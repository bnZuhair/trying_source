#!/bin/bash
set -e

echo "Importing CSV data into PostgreSQL..."

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<EOF
\COPY users(id, location, age) FROM '/data/users.csv' DELIMITER ',' CSV HEADER;
\COPY books(isbn, book_title, book_author, year_of_publication, publisher, image_url_s, image_url_m, image_url_l) FROM '/data/books.csv' DELIMITER ',' CSV HEADER;
\COPY userBooks(user_id, book_isbn, rating, status, start_date, end_date) FROM '/data/userBooks.csv' DELIMITER ',' CSV HEADER;
EOF

echo "✅ Data import completed!"

