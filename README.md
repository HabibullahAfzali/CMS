# Content Management System (CMS) Project

Welcome to the Content Management System (CMS) project! This project is a web application built using Java Spring Boot for the backend and Vue.js with Composition API for the frontend. It includes features such as user management, article posting, and personal information registration. The project also utilizes Spring Security for authentication and authorization, Bootstrap for styling, Axios for making HTTP requests, and Vue Router for navigation.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Features

### User Management
- User registration with personal information, education, work history, and address details.
- Role assignment to users with different permissions.

### Article Posting
- Users can create, edit, and delete articles.
- Articles can be categorized and tagged for better organization.

### Personal Information Form
- Users can input personal information, education, work history, and address details during registration.
- Data is securely stored and can be updated by the user.

### Authentication and Authorization
- Secure user authentication using Spring Security.
- Role-based access control to restrict access to certain features.

### Frontend
- Vue.js 3 with Composition API for a dynamic and efficient user interface.
- Bootstrap for responsive and visually appealing design.
- Vue Router for smooth navigation between different sections of the application.
- Axios for making asynchronous HTTP requests to the backend.

## Getting Started

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 11 or higher installed.
- Node.js and npm (Node Package Manager) installed.
- Git for version control.
- Your favorite code editor or IDE (Integrated Development Environment).

### Installation and Database Setup (MySQL)

1. Ensure that you have MySQL installed and running.

2. Create a MySQL database for your project. You can do this using a MySQL client or command line:

   ```bash
   mysql -u yourusername -p


1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/cms-project.git
   cd cms-project
   ```

2. Set up the backend:
   
   - Navigate to the `backend` directory and configure the database settings in `application.properties` (e.g., database URL, username, and password).
   
   - Run the Spring Boot application:

     ```bash
     ./mvnw spring-boot:run
     ```
3. Application.properties
   - spring.datasource.url=jdbc:mysql://localhost:3306/yourdbname
   - spring.datasource.username=yourmysqlusername
   - spring.datasource.password=yourmysqlpassword

3. Set up the frontend:

   - Navigate to the `frontend` directory.

   - Install the required dependencies:

     ```bash
     npm install
     ```

4. Configure the frontend:

   - Create a `.env` file in the `frontend` directory and set the backend API URL:

     ```
     VUE_APP_API_URL=http://localhost:8080/api
     ```

5. Run the frontend application:

   ```bash
   npm run serve
   ```

6. Access the application in your web browser at `http://localhost:8081` (or a different port if specified).

## Usage

1. Register a new user with personal information, education, work history, and address details.

2. Log in using your registered credentials.

3. Explore the user management features, post articles, and update personal information.

4. Assign different roles to users and observe how access to certain features is restricted based on roles.

## Project Structure

The project is structured as follows:

- `backend`: Contains the Java Spring Boot backend code.
  - `src`: Source code.
  - `pom.xml`: Maven project configuration.
  - `application.properties`: Configuration for the Spring Boot application.

- `frontend`: Contains the Vue.js frontend code.
  - `src`: Source code.
  - `public`: Static assets.
  - `package.json`: Node.js package configuration.
  - `vue.config.js`: Vue.js configuration.

## Contributing

Contributions to this project are welcome! You can contribute by:

- Reporting issues or suggesting enhancements.
- Forking the repository and creating pull requests to fix bugs or add new features.
- Providing feedback and ideas to improve the project.

