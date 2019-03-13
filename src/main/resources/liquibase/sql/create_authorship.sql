create table authorship (
id BIGINT PRIMARY KEY NOT NULL,
book_id BIGINT,
author_id BIGINT ,
FOREIGN KEY (author_id) REFERENCES authors(id),
FOREIGN KEY (book_id) REFERENCES books(id)
)