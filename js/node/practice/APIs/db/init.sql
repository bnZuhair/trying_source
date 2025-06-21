-- for for users
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    location VARCHAR(255),
    age INT
);


-- for books
CREATE TABLE books (
    isbn VARCHAR(20) PRIMARY KEY, 
    book_title TEXT NOT NULL,     
    book_author TEXT NOT NULL,    
    year_of_publication INT,      
    publisher VARCHAR(255),       
    image_url_s TEXT,             
    image_url_m TEXT,
    image_url_l TEXT
);


-- for userBooks
CREATE TABLE userBooks (
    user_id INT NOT NULL,
    book_isbn VARCHAR(20) NOT NULL,
    rating SMALLINT,
    status VARCHAR(50),
    start_date TIMESTAMP WITHOUT TIME ZONE,
    end_date TIMESTAMP WITHOUT TIME ZONE,

    PRIMARY KEY (user_id, book_isbn),

    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE,

    CONSTRAINT fk_book
        FOREIGN KEY (book_isbn)
        REFERENCES books (isbn)
        ON DELETE RESTRICT
);
