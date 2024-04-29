-- Section 02
INSERT INTO customer (name, email, age)
VALUES ('John Doe', 'john@gmail.com', 20),
       ('Jane Doe', 'Jane@gmail.com', 30),
       ('Tom Smith', 'tom@gmail.com', 40);

-- Section 03
INSERT INTO book_store (name)
VALUES ('Book Store 1'),
       ('Book Store 2'),
       ('Book Store 3');

INSERT INTO book (title, book_store_id)
VALUES ('Book Store 1 Book 1', 1),
       ('Book Store 1 Book 2', 1),
       ('Book Store 2 Book 1', 2),
       ('Book Store 2 Book 2', 2),
       ('Book Store 3 Book 1', 3),
       ('Book Store 3 Book 2', 3);