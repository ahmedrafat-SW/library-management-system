-- inserting sample data into Book table
INSERT INTO BOOK (BOOK_TITLE, BOOK_AUTHOR, PUBLICATION_YEAR, BOOK_ISBN) VALUES
                                                                            ('The Great Gatsby', 'F. Scott Fitzgerald', 1925, '9780743273565'),
                                                                            ('1984', 'George Orwell', 1949, '9780451524935');

--  inserting sample data into Patron table
INSERT INTO PATRON (PATRON_NAME, CONTACT_INFORMATION) VALUES
                                                          ('John Doe', 'johndoe@example.com'),
                                                          ('Jane Smith', 'janesmith@example.com');

--  inserting sample data into BorrowingRecord table
INSERT INTO BORROWING_RECORD (BOOK_ID, PATRON_ID, BORROW_DATE, RETURN_DATE) VALUES
                                                                                (1, 1, '2024-01-01', '2024-01-15'),
                                                                                (2, 2, '2024-01-05', '2024-01-20');

--  inserting sample data into User table
INSERT INTO LIB_USER (USER_NAME, PASSWORD, ACTIVE) VALUES
                                                       ('admin', 'adminpassword', true),
                                                       ('user', 'userpassword', true);
