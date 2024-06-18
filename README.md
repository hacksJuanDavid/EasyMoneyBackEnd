## Easy Money API


## Description
This is a simple API in Spring Boot that provides a way to manage data information easy bank and their information,credits,credit line. It allows to create, update, delete and get users and data.

## Technologies
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman
- Lombok
- Spring web

## How to use
1. Clone the repository
2. Open the project in your IDE
3. Run the project
4. Use Postman to test the API

## Route API
```
http://localhost:5000/api/v1
```
## Endpoints
```
1. Endpoints Personal Information
- GET /api/v1/personalInformation
- GET /api/v1/personalInformation/{id}
- POST /api/v1/personalInformation
- PUT /api/v1/personalInformation/{id}
- DELETE /api/v1/personalInformation/{id}

2. Endpoints Working Information
- GET /api/v1/workingInformation
- GET /api/v1/workingInformation/{id}
- POST /api/v1/workingInformation
- PUT /api/v1/workingInformation/{id}
- DELETE /api/v1/workingInformation/{id}

3. Endpoints Reference
- GET /api/v1/reference
- GET /api/v1/reference/{id}
- POST /api/v1/reference
- PUT /api/v1/reference/{id}
- DELETE /api/v1/reference/{id}

4. Endpoints Credit
- GET /api/v1/credit
- GET /api/v1/credit/{id}
- POST /api/v1/credit
- PUT /api/v1/credit/{id}
- DELETE /api/v1/credit/{id}

5. Endpoints Credit Line
- GET /api/v1/creditLine
- GET /api/v1/creditLine/{id}
- POST /api/v1/creditLine
- PUT /api/v1/creditLine/{id}
- DELETE /api/v1/creditLine/{id}
```

