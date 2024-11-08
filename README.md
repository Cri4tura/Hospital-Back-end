# **Backend API for Nurse Management**
## **Project Overview**

This project focuses on building a backend API for managing nurse-related data using Spring Boot, MySQL, and Hibernate. It supports CRUD (Create, Read, Update, Delete) operations on a "Nurse" entity and is designed for integration with both local and remote databases. Key functionalities include user login validation, searching nurses by name, and providing a centralized database system for multi-user collaboration. This API demonstrates the fundamentals of backend development, group work management, and CI (Continuous Integration) for enhanced code quality and reliability.

## Features

- **Nurse Management:** CRUD operations on nurse data (create, read, update, delete).
- **Login Validation:** Endpoint for authenticating nurse logins.
- **Search Functionality:** Endpoint to search nurses by name.
- **Database Integration:** Utilizes MySQL with Hibernate for data persistence.
- **Continuous Integration:** Configured with GitHub Actions to automate testing upon code changes.

## **Installation**

Prerequisites
- **Java 11:** or higher.
- **MySQL:** or local or remote database hosting. 
- **Maven:**  for managing dependencies
- **Git** for version control

## **Steps**

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   cd your-repo-name
   
2. **Configure MySQL Database:**
   - **Local**: Set up a MySQL instance locally. Update the `application.properties` file with your database credentials.
   - **Remote**: Alternatively, create a MySQL database on [freemysqlhosting.net](https://www.freemysqlhosting.net/) and configure the remote connection in `application.properties`.

3. **Setup Hibernate and Spring Boot:**
   - **Open**: `src/main/resources/application.properties`.
   - **Update with your MySQL credentials**:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
     spring.datasource.username=your-username
     spring.datasource.password=your-password
     spring.jpa.hibernate.ddl-auto=update
 

## **Contributing**

If you'd like to contribute to Project Title, here are some guidelines:

1. Fork the repository.
2. Create a new branch for your changes.
3. Make your changes.
4. Write tests to cover your changes.
5. Run the tests to ensure they pass.
6. Commit your changes.
7. Push your changes to your forked repository.
8. Submit a pull request.

## **License**

Project Title is released under the MIT License. See the **[LICENSE](https://www.blackbox.ai/share/LICENSE)** file for details.

## **Authors and Acknowledgment**

Project Title was created by **[Your Name](https://github.com/username)**.

Additional contributors include:

- **[Contributor Name](https://github.com/contributor-name)**
- **[Another Contributor](https://github.com/another-contributor)**

Thank you to all the contributors for their hard work and dedication to the project.



