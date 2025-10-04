📝 Spring Article Management App

Spring Article Management App is a full-stack Java web application that allows users to create, read, update, and delete articles efficiently.
It includes user authentication, role-based access, and advanced search functionality, providing a solid foundation for a content management system.
# 🚀 Spring Article Management App

<div align="center">

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.5-brightgreen.svg)
![Java](https://img.shields.io/badge/Java-17-orange.svg)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)
![Security](https://img.shields.io/badge/Spring%20Security-6.0-red.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)


</div>

---

## 📋 Table of Contents

- [🎯 Project Overview](#-project-overview)
- [✨ Key Features](#-key-features)
- [🏗️ Architecture & Tech Stack](#️-architecture--tech-stack)
- [🚀 Quick Start](#-quick-start)
- [📱 Screenshots](#-screenshots)
- [🔧 API Documentation](#-api-documentation)
- [📁 Project Structure](#-project-structure)
- [🛡️ Security Features](#️-security-features)
- [🧪 Testing](#-testing)
- [📈 Performance](#-performance)
- [🤝 Contributing](#-contributing)
- [📞 Contact](#-contact)

---

## 🎯 Project Overview

The **Spring Article Management App** is a comprehensive, enterprise-grade web application designed for inventory management with advanced user authentication and multi-criteria search capabilities. Built using modern Spring Boot 3.4.5 with Jakarta EE standards, this application demonstrates professional software development practices and scalable architecture patterns.

### 🎨 What Makes This Project Special

- **🏢 Enterprise-Ready**: Built with Spring Boot 3.4.5 and Jakarta EE standards
- **🔐 Security-First**: Comprehensive authentication and authorization system
- **📊 Advanced Search**: Multi-criteria filtering with dynamic query building
- **💾 Data Integrity**: Proper financial data handling with BigDecimal
- **🎨 Modern UI**: Responsive design with Bootstrap and Thymeleaf
- **📈 Scalable**: Clean architecture with separation of concerns

---

## ✨ Key Features

### 🔐 **User Management**
- **Secure Registration**: Email-based user registration with validation
- **Authentication**: Spring Security 6 integration with BCrypt password hashing
- **Session Management**: Persistent user sessions with proper logout handling
- **User Isolation**: Each user sees only their own articles

### 📦 **Article Management**
- **Full CRUD Operations**: Create, Read, Update, Delete articles
- **Smart Search**: Multi-criteria search by description and price range
- **Stock Tracking**: Real-time inventory quantity management
- **Expiration Management**: Date-based expiration tracking
- **Financial Precision**: BigDecimal for accurate price calculations

### 🎨 **User Experience**
- **Responsive Design**: Mobile-friendly Bootstrap interface
- **Real-time Feedback**: Success/error messages and validation
- **Intuitive Navigation**: Clean, professional user interface
- **Fast Performance**: Optimized queries and lazy loading

### 🛡️ **Security & Data**
- **Password Encryption**: BCrypt hashing for secure password storage
- **SQL Injection Protection**: JPA/Hibernate ORM with parameterized queries
- **XSS Protection**: Thymeleaf template escaping
- **CSRF Protection**: Spring Security CSRF tokens

---

## 🏗️ Architecture & Tech Stack

### **Backend Technologies**
```
🟢 Spring Boot 3.4.5          - Main application framework
🟢 Spring Security 6.0        - Authentication & authorization
🟢 Spring Data JPA            - Data persistence layer
🟢 Jakarta Persistence API    - Modern JPA implementation
🟢 MySQL 8.0                 - Relational database
🟢 Maven                     - Build automation
🟢 Java 17                   - Programming language
```

### **Frontend Technologies**
```
🟢 Thymeleaf                 - Server-side templating
🟢 Bootstrap 5               - CSS framework
🟢 HTML5/CSS3               - Modern web standards
🟢 JavaScript               - Client-side interactions
```

### **Development Tools**
```
🟢 Spring Boot DevTools      - Development utilities
🟢 Hibernate Validator       - Bean validation
🟢 Spring Boot Test          - Testing framework
🟢 JUnit 5                  - Unit testing
```

---

## 🚀 Quick Start

### Prerequisites
- **Java 17** or higher
- **Maven 3.6+**
- **MySQL 8.0**
- **Git**

### Installation Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/spring-article-management-app.git
   cd spring-article-management-app
   ```

2. **Database Setup**
   ```sql
   CREATE DATABASE article_db;
   CREATE USER 'root'@'localhost' IDENTIFIED BY 'root';
   GRANT ALL PRIVILEGES ON article_db.* TO 'root'@'localhost';
   FLUSH PRIVILEGES;
   ```

3. **Configure Application**
   ```bash
   # Update src/main/resources/application.properties if needed
   # Default configuration:
   # Database: localhost:3306/article_db
   # Username: root
   # Password: root
   ```

4. **Build and Run**
   ```bash
   # Build the project
   mvn clean install
   
   # Run the application
   mvn spring-boot:run
   ```

5. **Access the Application**
   ```
   🌐 Open your browser and navigate to: http://localhost:8081
   ```

### 🎯 First Steps
1. **Register** a new account at `/register`
2. **Login** with your credentials at `/login`
3. **Create** your first article at `/articles/create`
4. **Explore** the search and filtering features

---

## 📱 Screenshots

<img width="1905" height="650" alt="image" src="https://github.com/user-attachments/assets/50dc6313-d758-4543-b35d-0f51599fe516" />
<img width="1912" height="884" alt="image" src="https://github.com/user-attachments/assets/66150f8a-48d6-43cb-99c5-218096e84101" />




## 📁 Project Structure

```
📦 spring-article-management-app/
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 java/com/example/articleapp/
│   │   │   ├── 🏗️ ArticleAppApplication.java          # Main application class
│   │   │   ├── 📁 config/
│   │   │   │   ├── ⚙️ SecurityConfig.java            # Security configuration
│   │   │   │   └── ⚙️ AppConfig.java                 # General configuration
│   │   │   ├── 📁 controller/
│   │   │   │   ├── 🎮 ArticleController.java         # Article management
│   │   │   │   ├── 🎮 AuthController.java            # Authentication
│   │   │   │   └── 🎮 HomeController.java           # Dashboard
│   │   │   ├── 📁 entity/
│   │   │   │   ├── 📊 Article.java                   # Article entity
│   │   │   │   └── 👤 User.java                      # User entity
│   │   │   ├── 📁 repository/
│   │   │   │   ├── 💾 ArticleRepository.java        # Article data access
│   │   │   │   └── 💾 UserRepository.java           # User data access
│   │   │   ├── 📁 service/
│   │   │   │   ├── 🔧 ArticleService.java           # Article business logic
│   │   │   │   └── 🔧 AuthService.java              # Authentication service
│   │   │   └── 📁 specification/
│   │   │       └── 🔍 ArticleSpecification.java     # Dynamic query builder
│   │   └── 📁 resources/
│   │       ├── ⚙️ application.properties            # Application configuration
│   │       ├── 📁 static/css/
│   │       │   └── 🎨 style.css                     # Custom styles
│   │       └── 📁 templates/
│   │           ├── 🏠 home.html                     # Dashboard template
│   │           ├── 🔐 login.html                    # Login template
│   │           ├── 📝 register.html                 # Registration template
│   │           └── 📁 fragments/                    # Reusable components
│   └── 📁 test/
│       └── 📁 java/com/example/articleapp/
│           └── 🧪 ArticleAppApplicationTests.java   # Application tests
├── 📄 pom.xml                                       # Maven configuration
├── 📄 README.md                                     # Project documentation
└── 📄 mvnw                                          # Maven wrapper
```

### **Architecture Highlights**

- **🏗️ Layered Architecture**: Clear separation between Controller, Service, Repository, and Entity layers
- **🔍 Specification Pattern**: Dynamic query building for flexible search functionality
- **🛡️ Security Integration**: Spring Security 6 with custom authentication
- **📊 JPA Best Practices**: Proper entity relationships and lazy loading
- **🎨 Template Engine**: Thymeleaf for server-side rendering with fragments

---

## 🛡️ Security Features

### **Authentication & Authorization**
- ✅ **Email-based Authentication**: Secure login using email addresses
- ✅ **Password Hashing**: BCrypt encryption for password storage
- ✅ **Session Management**: Persistent user sessions with proper logout
- ✅ **Role-based Access**: User role management system
- ✅ **CSRF Protection**: Cross-site request forgery prevention

### **Data Protection**
- ✅ **SQL Injection Prevention**: JPA/Hibernate ORM with parameterized queries
- ✅ **XSS Protection**: Thymeleaf template escaping
- ✅ **Input Validation**: Server-side validation for all user inputs
- ✅ **Secure Headers**: Spring Security default security headers

### **User Data Isolation**
- ✅ **User-specific Data**: Each user sees only their own articles
- ✅ **Creator Tracking**: Articles are associated with their creators
- ✅ **Secure Updates**: Creator information is preserved during updates


## 🚀 Deployment

### **Production Deployment**

1. **Environment Configuration**
   ```bash
   # Set production database
   export SPRING_DATASOURCE_URL=jdbc:mysql://your-db-host:3306/article_db
   export SPRING_DATASOURCE_USERNAME=your-username
   export SPRING_DATASOURCE_PASSWORD=your-password
   ```

2. **Build for Production**
   ```bash
   mvn clean package -Pproduction
   ```

3. **Run Application**
   ```bash
   java -jar target/articleapp-0.0.1-SNAPSHOT.jar
   ```

### **Docker Deployment** (Optional)
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/articleapp-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

---


---

## 📞 Contact

<div align="center">

**👨‍💻 Developer: [Your Name]**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue?style=for-the-badge&logo=linkedin)](https://linkedin.com/in/yourprofile)
[![GitHub](https://img.shields.io/badge/GitHub-Follow-black?style=for-the-badge&logo=github)](https://github.com/yourusername)
[![Email](https://img.shields.io/badge/Email-Contact-red?style=for-the-badge&logo=gmail)](mailto:your.email@example.com)

**🌐 Project Links:**
- **Live Demo**: [http://localhost:8081](http://localhost:8081)
- **Repository**: [GitHub Repository](https://github.com/yourusername/spring-article-management-app)
- **Documentation**: [Full Documentation](README.md)

</div>

