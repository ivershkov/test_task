create table books (
id BIGINT PRIMARY KEY NOT NULL,
book_name VARCHAR(255),
isbn VARCHAR(30),
theme VARCHAR(255),
author_id BIGINT ,FOREIGN KEY (author_id) REFERENCES authors(id)
)