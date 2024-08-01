-- Book table
CREATE TABLE BOOK (
                      BOOK_ID SERIAL PRIMARY KEY,
                      BOOK_TITLE VARCHAR(255),
                      BOOK_AUTHOR VARCHAR(255),
                      PUBLICATION_YEAR INT,
                      BOOK_ISBN VARCHAR(255)
);

-- Patron table
CREATE TABLE PATRON (
                        PATRON_ID SERIAL PRIMARY KEY,
                        PATRON_NAME VARCHAR(255),
                        CONTACT_INFORMATION VARCHAR(255)
);

-- BorrowingRecord table
CREATE TABLE BORROWING_RECORD (
                                  BORROWING_ID SERIAL PRIMARY KEY,
                                  BOOK_ID INT REFERENCES BOOK(BOOK_ID),
                                  PATRON_ID INT REFERENCES PATRON(PATRON_ID),
                                  BORROW_DATE DATE,
                                  RETURN_DATE DATE
);

-- User table
CREATE TABLE LIB_USER (
                          USER_ID SERIAL PRIMARY KEY,
                          USER_NAME VARCHAR(255),
                          PASSWORD VARCHAR(255),
                          ACTIVE BOOLEAN
);
