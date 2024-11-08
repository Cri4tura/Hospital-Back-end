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
4. **Install dependencies:**
    ```bash
   mvn install
5. **Run the application:**
    ```bash
   mvn spring-boot:run
    
## **Usage**
**Endpoints Overview**

The following endpoints are available for the Nurse entity:

1. **Get All Nurses**
   - **Endpoint:** `GET /nurse/all`
   - **Description:** Retrieves a list of all registered nurses.

2. **Login Validation**
   - **Endpoint:** `POST /nurse/login`
   - **Description:** Authenticates a nurse’s login credentials.

3. **Search Nurse by Name**
   - **Endpoint:** `GET /nurse/name/{name}`
   - **Description:** Returns nurse(s) with the specified name.

4. **CRUD Operations for Nurse**
   - **Create Nurse:** `POST /nurse/create`
   - **Read Nurse by ID:** `GET /nurse/{id}`
   - **Update Nurse by ID:** `PUT /nurse/{id}`
   - **Delete Nurse by ID:** `DELETE /nurse/{id}`

**Testing**
 - **Postman:** Use Postman to test each endpoint and validate response data.
 - **CI Pipeline:** The CI pipeline will automatically run unit tests upon code push to ensure quality.

## **Continuous Integration (CI)**

- **GitHub Actions** is configured to automate the testing process.
  - On every push and pull request, unit tests are triggered to check the code.
  - Failed tests will notify contributors, ensuring prompt fixes.
  - The CI pipeline will detect syntax errors and logic errors during testing.

## **Contributing**

This project follows a group collaboration model. Each contributor should work on a designated branch and submit changes via pull requests. All changes are reviewed for integration into the main branch.




