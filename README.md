# Project
Cloth Shop Management Project
# Cloth Shop Management System

## Overview
The **Cloth Shop Management System** is a Spring Boot-based application designed to manage products, customers, and suppliers in a cloth shop. The system allows CRUD operations on all entities and includes features such as validation, exception handling, and security.

## Features
- **Product Management**: Add, update, retrieve, and delete products.
- **Supplier Management**: Manage supplier details.
- **Spring Security**: Secures the application with username and password authentication.
- **Validation Handling**: Implements global exception handling for input validation.
- **Swagger API Documentation**: Uses OpenAPI for interactive API documentation.
- **Database Support**: Works with MySQL and H2 database.

## Technologies Used
- **Spring Boot 3.4.2**
- **Spring Data JPA** (for database operations)
- **Spring Boot Security** (for authentication)
- **Spring Boot Validation** (for request validation)
- **SpringDoc OpenAPI** (for API documentation)
- **Lombok** (for reducing boilerplate code)
- **MySQL & H2 Database**
- **Maven** (for dependency management)

## Project Structure
```
clothshop-management/
│── src/main/java/com/clothshop/management/
│   ├── ProductRepository/
│   ├── Product_Entity/
│   ├── Supplier_Controller/
│   ├── Supplier_Entity/
│   ├── SupplierRepository/
│   ├── Supplier_Service/
│   ├── Exception/
│   ├── Validation/
│   ├── ManagementApplication.java
│── src/main/resources/
│   ├── application.properties
│── pom.xml
│── README.md
```

## Installation & Setup
### Prerequisites
- **Java 17**
- **Maven**
- **MySQL Database**

### Steps to Run the Project
1. **Clone the repository**:
   ```sh
   git clone https://github.com/your-repo/clothshop-management.git
   cd clothshop-management
   ```
2. **Configure Database**:
   Update `src/main/resources/application.properties` with your MySQL credentials.
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/clothshop_db
   spring.datasource.username=root
   spring.datasource.password=root
   ```
3. **Build the project**:
   ```sh
   mvn clean install
   ```
4. **Run the application**:
   ```sh
   mvn spring-boot:run
   ```
5. **Access Swagger API Documentation**:
   Open your browser and visit:
   ```
   http://localhost:1000/swagger-ui/index.html
   ```

## API Endpoints
### Supplier APIs
| HTTP Method | Endpoint              | Description                    |
|------------|----------------------|--------------------------------|
| `POST`     | `/api/suppliers`      | Create a new supplier         |
| `GET`      | `/api/suppliers/{id}` | Get supplier by ID            |
| `GET`      | `/api/suppliers`      | Get all suppliers             |
| `PUT`      | `/api/suppliers/{id}` | Update supplier details       |
| `DELETE`   | `/api/suppliers/{id}` | Delete supplier by ID         |

## Security Credentials
The application is secured with Spring Security.
- **Username**: `admin`
- **Password**: `admin123`

## License
This project is open-source and available under the MIT License.

