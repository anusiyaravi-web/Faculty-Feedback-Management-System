# Faculty-Feedback-Management-System
A web-based Faculty Feedback System built using HTML, CSS, JavaScript, Spring Boot, Spring Data JPA, and MySQL to collect and store student feedback about faculty teaching performance.

## About the Project
The Faculty Feedback System is a web-based application that allows students to provide feedback about faculty members and their teaching performance. Students can enter their details, select a faculty member, and rate the faculty using ten feedback questions.

## Technologies Used
- HTML
- CSS
- JavaScript
- Java
- Spring Boot
- Spring Data JPA
- MySQL

## Features
- Student details entry
- Faculty selection
- Ten faculty feedback questions
- Rating-based feedback submission
- JavaScript form validation
- Spring Boot REST API integration
- MySQL database connectivity for storing feedback

## Project Structure
```text
FacultyFeedbackSystem/
├── frontend/
│   ├── index.html
│   ├── style.css
│   └── script.js
├── backend/
│   ├── src/
│   ├── pom.xml
│   └── mvnw.cmd
├── .gitignore
└── README.md
```

## How to Run the Project

1. Install Java 17 or a compatible configured JDK.
2. Start the MySQL server.
3. Configure the database name, username, and password in `backend/src/main/resources/application.properties`.
4. Open a terminal inside the `backend` folder.
5. Run the backend:

   ```bash
   .\mvnw.cmd spring-boot:run
   ```

6. Open the `frontend` folder in VS Code.
7. Run `index.html` using the Live Server extension.
8. Enter the student details, select a faculty member, complete the feedback questions, and submit the form.

## Database
MySQL is used to store submitted feedback. Configure the application to match your existing database and table structure before running the application.

## Author
Anusiya
