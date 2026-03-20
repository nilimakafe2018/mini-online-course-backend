# Mini Online Course

## 📖 Project Overview: 

My project is a full-stack web application that simulates a mini online learning experience for process Feedback users. The application allows users to enter their name, email and institution, watch an instructional video, complete a quiz, and receive a custom certificate after passing the course.

One of the key features of this project is enforcing a one-to-one relationship between users and certificates, making sure that each user can create one certificate while still being able to download it anytime they return. 

Additionally, returning users are recognized and can skip the course and directly access their certificate.

## 📌 Technologies used:

### Frontend
- React with functional components and hooks
- JavaScript
- HTML
- CSS
- React Router
- html2canvas library for downloading certificate as image

### Backend
- Java
- Spring Boot
- REST ful APIs
- Hibernate and JPA

### Database
- MySQL

### Tools and Platforms
- Visual Studio Code
- GitHub
- IntelliJ IDEA
- Postman for API testing
- MYSQL Workbench

## How to run this project locally:

### 1. Clone the Repository
```bash
https://github.com/nilimakafe2018/mini-online-course-backend.git
````

### 2. Frontend Setup step by step:
After cloning the repo, navigate to the frontend folder:
```bash
cd your folder name
```

Install dependencies:
```bash
npm install
```
Start the development server:
```bash
npm rundev
```
After completing all these steps, frontend will run at http://localhost:5175

### 3. Backend Setup step by step:

- Open the backend project in IntelliJ IDEA
- Make sure that MYSQL is installed and running
- Update the application.properties file:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
```
- Run the Spring Boot application, backend will run at:
```bash
http://localhost:8080
```
🎨 View the Wireframe here:

https://www.canva.com/design/DAHBPE4rEY0/1yU2vUvkmnaTCmVVv1qYxg/edit










