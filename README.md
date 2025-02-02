# Simple Spring Boot Project: Content Calendar API

This is a simple REST API project built with Spring Boot to learn the fundamentals of Java backend development. The project uses the Model-View-Controller (MVC) pattern and JDBC for data manipulation, interacting with a simple H2 database. The application is also Dockerized for easy deployment.

## Features
- **Spring Boot**: Provides the framework for building and running the application.
- **MVC Pattern**: Organizes the application into three main components:
  - **Controller**: Handles HTTP requests and delegates tasks to the service layer.
  - **Repository**: Manages data access logic and provides an object-oriented view of the persistence layer.
- **JDBC**: Used for data manipulation and access to the H2 database.
- **Docker**: The application is containerized for easy deployment and scaling.

## API Endpoints

The `ContentController` provides a RESTful interface to manage content in the application. Below is a guide to the available endpoints:

1. **Get All Content**
   - **Endpoint**: `GET /content`
   - **Description**: Retrieves a list of all content in the system.
   - **Response**: A list of `Content` objects.

2. **Get Content by ID**
   - **Endpoint**: `GET /content/{id}`
   - **Description**: Retrieves a specific piece of content by its ID.
   - **Response**: A `Content` object.
   - **Error Response**: Returns a 404 status code if the content is not found.

3. **Create Content**
   - **Endpoint**: `POST /content`
   - **Description**: Creates a new piece of content.
   - **Request Body**: A `Content` object.
   - **Response**: HTTP 201 status code on success.

4. **Update Content**
   - **Endpoint**: `PUT /content/{id}`
   - **Description**: Updates an existing piece of content by its ID.
   - **Request Body**: A `Content` object.
   - **Response**: HTTP 204 status code on success.
   - **Error Response**: Returns a 404 status code if the content is not found.

5. **Delete Content**
   - **Endpoint**: `DELETE /content/{id}`
   - **Description**: Deletes a specific piece of content by its ID.
   - **Response**: HTTP 204 status code on success.
   - **Error Response**: Returns a 404 status code if the content is not found.

6. **Search Content by Title**
   - **Endpoint**: `GET /content/filter/{keyword}`
   - **Description**: Searches for content containing the specified keyword in the title.
   - **Response**: A list of `Content` objects matching the search criteria.

7. **Filter Content by Status**
   - **Endpoint**: `GET /content/filter/status/{status}`
   - **Description**: Filters content by its status.
   - **Response**: A list of `Content` objects with the specified status.
