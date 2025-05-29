# Fintech Project

This repository contains the implementation of the **Fintech** system, developed as the final project for the discipline. It consolidates all the knowledge acquired throughout the year, applying the concepts of **Java Web** and **Oracle database connection** to create a functional application, covering everything from database modeling to the user interface.

---

## 🚀 Implemented Features

The Fintech system includes the following features:

* **User Management:** Registration, login, and access control.
* **Authentication:** Authentication system to protect restricted functionalities.
* **Home Page:** The application's entry page.
* **Error Page:** A dedicated page for displaying errors.

---

## 🛠️ Technologies Used

This project was developed using the following technologies:

* **Java:** Main programming language.
* **JDBC:** API for database connectivity.
* **Servlets:** Java components for processing HTTP requests.
* **JSP (JavaServer Pages):** Technology for creating dynamic web interfaces.
* **HTML/CSS:** For the structure and styling of web pages.
* **SQL:** For database manipulation.
* **Oracle Database:** FIAP's remote instance used as the database.

---

## 📁 Project Structure

The project structure follows the architecture of a traditional Java Web project:

* **`src/main/java`**: Contains the Java classes, including:
    * **Models:** Classes representing the system's entities (with getters, setters, and constructors).
    * **DAOs (Data Access Objects):** Classes responsible for interacting with the database.
    * **`ConnectionManager`:** Class to manage the connection to the FIAP Oracle database.
    * **`DAOFactory`:** Factory for obtaining DAO instances.
    * **Servlets:** Classes that control the application flow and interact with JSPs.
* **`src/main/webapp`**: Contains web resources, including:
    * **JSPs:** Dynamic web pages.
    * **Static files:** CSS, images, etc.
* **`lib`**: Contains necessary external libraries (such as the Oracle JDBC driver).

---

## 🎯 Project Objective

This project aims to demonstrate the ability to:

* Model and interact with a relational database (Oracle).
* Develop dynamic web applications using Servlets and JSPs.
* Implement design patterns like DAO and Factory.
* Manage user authentication and authorization.
* Integrate back-end and front-end components into a Java Web application.
