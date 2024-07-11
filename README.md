# Pharmacy Management System

A Java-based console application to manage the inventory of a pharmacy. The system allows users to insert, update, delete, and display medicines using a MySQL database.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
  - [Prerequisites](#prerequisites)
  - [Database Setup](#database-setup)
  - [Project Setup](#project-setup)
- [Usage](#usage)
- [License](#license)
- [Contact](#contact)

## Features

- **Login System:** Simple authentication to access the system.
- **CRUD Operations:**
  - Insert a new medicine.
  - Update existing medicine details.
  - Delete a medicine from the inventory.
  - Display all medicines.
  - Find a medicine by ID.
- **Stored Procedure:** Find medicine name by ID using a stored procedure.

## Technologies Used

- Java
- JDBC
- MySQL

## Setup and Installation

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- MySQL Connector/J (JDBC Driver)
- An IDE such as IntelliJ IDEA, Eclipse, or NetBeans

### Database Setup

1. Create a MySQL database named `PharmacyDB`.
2. Create a table named `Medicines` with columns for `id`, `name`, `price`, and `quantity`.
3. Create a stored procedure named `findMedicineNameByIdUsingProc` to find medicine names by ID.

### Project Setup

1. Clone the repository from GitHub.
2. Import the project into your IDE as a Maven or Gradle project.
3. Add the MySQL Connector/J JAR file to your project's classpath.
4. Update the database URL, username, and password in `MedicineDAOImpl.java` with your MySQL server details.

## Usage

1. Run the `PharmacyService.java` file.
2. Log in using the default credentials.
3. Use the menu to perform various operations such as inserting, updating, deleting, and displaying medicines.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

- **Author:** Mayuresh Kalal
- **Email:** mayureshkalal28@gmail.com

