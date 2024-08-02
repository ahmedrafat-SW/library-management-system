# Library Management System API Documentation

## Overview
This document provides an overview of the API endpoints available in the Library Management System, using versioning with `/v1` and the prefix `/lib`.

## API Endpoints

### 1. BookController

#### `GET /lib/api/v1/books`
- **Description**: Retrieves a list of all books.
- **Response**: 
  - 200 OK: Returns a list of books.

#### `GET /lib/api/v1/books/{id}`
- **Description**: Retrieves a specific book by its ID.
- **Parameters**:
  - `id`: The ID of the book.
- **Response**:
  - 200 OK: Returns the book details.
  - 404 Not Found: If the book does not exist.

#### `POST /lib/api/v1/books`
- **Description**: Adds a new book to the library.
- **Request Body**: JSON object representing the book details.
- **Response**:
  - 201 Created: The book was successfully added.

#### `PUT /lib/api/v1/books/{id}`
- **Description**: Updates an existing book's information.
- **Parameters**:
  - `id`: The ID of the book.
- **Request Body**: JSON object with updated book details.
- **Response**:
  - 200 OK: The book was successfully updated.
  - 404 Not Found: If the book does not exist.

#### `DELETE /lib/api/v1/books/{id}`
- **Description**: Deletes a book from the library.
- **Parameters**:
  - `id`: The ID of the book.
- **Response**:
  - 200 OK: The book was successfully deleted.
  - 404 Not Found: If the book does not exist.

### 2. UserController

#### `GET /lib/api/v1/users`
- **Description**: Retrieves a list of all users.
- **Response**:
  - 200 OK: Returns a list of users.

#### `GET /lib/api/v1/users/{id}`
- **Description**: Retrieves a specific user by their ID.
- **Parameters**:
  - `id`: The ID of the user.
- **Response**:
  - 200 OK: Returns the user details.
  - 404 Not Found: If the user does not exist.

#### `POST /lib/api/v1/users`
- **Description**: Registers a new user.
- **Request Body**: JSON object representing the user details.
- **Response**:
  - 201 Created: The user was successfully registered.

#### `PUT /lib/api/v1/users/{id}`
- **Description**: Updates an existing user's information.
- **Parameters**:
  - `id`: The ID of the user.
- **Request Body**: JSON object with updated user details.
- **Response**:
  - 200 OK: The user was successfully updated.
  - 404 Not Found: If the user does not exist.

#### `DELETE /lib/api/v1/users/{id}`
- **Description**: Deletes a user from the system.
- **Parameters**:
  - `id`: The ID of the user.
- **Response**:
  - 200 OK: The user was successfully deleted.
  - 404 Not Found: If the user does not exist.

## Error Handling
- **404 Not Found**: Returned when a requested resource does not exist.
- **400 Bad Request**: Returned when the request body is invalid or missing required fields.
- **500 Internal Server Error**: Returned when an unexpected error occurs on the server.

## Authentication
- The API currently doesn't implement authentication . Future versions may include user authentication using JWT and authorization.

## Project Installation

### Prerequisites
- Java 17 or higher
- Maven
- Postgresql or another compatible database

### Installation Steps

1. **Clone the Repository**
   ```sh
   git clone https://github.com/ahmedrafat-SW/library-management-system.git
