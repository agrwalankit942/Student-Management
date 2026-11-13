# Student Management System

A web-based Student Management System developed using **Java, Spring Boot, Spring MVC, Thymeleaf, Spring Data JPA, and MySQL**.

This application allows users to manage student records through a simple and user-friendly interface.

## 🚀 Features

- Add new student records
- View all students
- Update student information
- Delete student records
- Search students by name or email
- Store student information in MySQL database
- Automatic table creation and updates using Hibernate
- Form validation
- MVC-based layered architecture

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java 11 | Programming Language |
| Spring Boot 2.7.18 | Backend Framework |
| Spring MVC | Web Application Architecture |
| Thymeleaf | Frontend Template Engine |
| Spring Data JPA | Database Operations |
| Hibernate | ORM Framework |
| MySQL | Database |
| Maven | Build and Dependency Management |
| HTML & CSS | User Interface |
| VS Code | Development Environment |

## 📁 Project Structure

```text
Student Management
│
├── pom.xml
├── README.md
│
└── src
    └── main
        ├── java
        │   └── com/example/studentmanagement
        │       ├── StudentManagementApplication.java
        │       ├── controller
        │       │   └── StudentController.java
        │       ├── model
        │       │   └── Student.java
        │       └── repository
        │           └── StudentRepository.java
        │
        └── resources
            ├── application.properties
            ├── templates
            │   ├── student.html
            │   ├── students.html
            │   └── student-form.html
            └── static
                └── css
                    └── style.css
```

## ⚙️ Requirements

Before running this project, install:

1. Java JDK 11
2. Apache Maven
3. MySQL Server
4. MySQL Workbench (optional)
5. Visual Studio Code or another Java IDE

## 🗄️ Database Configuration

First, create the database in MySQL:

```sql
CREATE DATABASE student_management_db;
```

Select the database:

```sql
USE student_management_db;
```

Configure your `application.properties` file:

```properties
spring.application.name=Student Management

spring.datasource.url=${DB_URL:jdbc:mysql://localhost:3306/student_management_db}
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

server.port=${PORT:8080}
```

Set your local MySQL password in the `DB_PASSWORD` environment variable. Do not upload database passwords to GitHub.

## ▶️ How to Run the Project

**Step 1: Clone the repository**

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

**Step 2: Navigate to the project directory**

```bash
cd Student-Management-System
```

**Step 3: Build the project**

```bash
mvn clean install
```

**Step 4: Run the application**

```bash
mvn spring-boot:run
```

**Step 5: Open in your browser**

```text
http://localhost:8080/students
```

## 🌐 Application URLs

| Feature | URL |
|---|---|
| Student Dashboard | `/students` |
| Add New Student | `/students/new` |
| Edit Student | `/students/edit/{id}` |
| Delete Student | `/students/delete/{id}` |
| Search Students | `/students?keyword=name` |

## 🏗️ Application Architecture

The project follows a layered MVC architecture:

- **Controller Layer:** Handles HTTP requests and responses.
- **Service Layer:** Responsible for business logic and transaction management (planned extension).
- **Repository Layer:** Handles database operations using Spring Data JPA.
- **Model Layer:** Defines the Student entity.
- **View Layer:** Displays the user interface using Thymeleaf.

## 🗃️ Database Table

The application uses a `student` table with the following fields:

| Field | Description
