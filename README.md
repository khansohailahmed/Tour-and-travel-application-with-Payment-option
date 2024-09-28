# Travel and Booking Management System

## Project Overview

The **Travel and Booking Management System** is a comprehensive desktop application developed using **Java Swing** for the frontend and **MySQL** for database management. This application allows users to manage their travel and accommodation needs, including package and hotel bookings, personal information, payment processing, and travel notes. It is designed to provide a seamless, user-friendly interface for users to handle all aspects of their travel planning in one place.

## Key Features

### 1. **User Authentication**
   - **User Registration**: New users can sign up by providing their personal details.
   - **Login**: Registered users can securely log in to their accounts to manage their travel plans.

### 2. **Personal Details Management**
   - **Add Personal Details**: Users can enter and save their personal details in the system.
   - **View Personal Details**: Users can view the personal information saved in the system.
   - **Update Personal Details**: Users can modify their personal details as needed.
   - **Delete Personal Details**: Users have the option to delete their personal details from the system.

### 3. **Package Management**
   - **View Packages**: Users can browse the available travel packages.
   - **Book Packages**: Users can book their desired travel packages.
   - **View Booked Packages**: Users can view the details of their booked travel packages.

### 4. **Hotel Management**
   - **View Hotels**: Users can explore the available hotels for their destination.
   - **Book Hotels**: Users can book hotels based on their preferences.
   - **View Booked Hotels**: Users can view the details of their booked hotels.

### 5. **Destination Management**
   - **View Destinations**: Users can explore and view various travel destinations.

### 6. **Payment Management**
   - **Make Payments**: Users can pay for booked packages and hotels using Card or UPI.
   - **View Payment Details**: Users can view their payment history and transaction details.

### 7. **Notepad**
   - **User Notes**: Users can maintain a personal notepad for recording any travel-related notes or reminders.

## Technologies Used

- **Java Swing**: Used for building the graphical user interface (GUI).
- **MySQL**: Used for database management and storing user data.
- **JDBC**: Java Database Connectivity to interact with the MySQL database.

## Installation and Setup Instructions

### Prerequisites

1. **Java Development Kit (JDK)**: Ensure JDK 8 or later is installed on your machine.
2. **MySQL Database**: Install MySQL on your system and set up the database.
3. **MySQL JDBC Driver**: Add the MySQL JDBC connector in your Java project to connect the application with the MySQL database.

### Steps to Set Up

1. **Clone the Repository**  
   Clone the GitHub repository to your local machine:
   ```bash
   git clone https://github.com/khansohailahmed/Travel-and-Booking-Management-System.git
   ```

2. **Database Setup**
   - Create a MySQL database for the project.
   - Import the `travel_management.sql` file into your MySQL database. This file contains the required tables and data structure.
   ```bash
   mysql -u username -p database_name < travel_management.sql
   ```

3. **Configure Database Connection**
   - In the project, update the database connection details in the Java files where the database is accessed (such as `DBConnection.java`). Set your database credentials like `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD`.

4. **Run the Application**
   - Compile and run the Java project using your preferred IDE (Eclipse, IntelliJ IDEA, or NetBeans) or from the command line:
   ```bash
   javac Main.java
   java Main
   ```

## Project Structure

```
├── src
│   ├── main
│   ├── auth
│   ├── booking
│   ├── hotel
│   ├── payment
│   ├── destination
│   ├── notepad
│   └── utils
├── lib
│   └── mysql-connector-java.jar
├── resources
│   ├── images
│   └── css
├── travel_management.sql
└── README.md
```

### Modules

- **auth**: Handles user registration and login functionality.
- **booking**: Manages the package booking process.
- **hotel**: Manages hotel viewing and booking.
- **payment**: Handles payment processing for bookings.
- **destination**: Manages travel destination exploration.
- **notepad**: Manages user notes and reminders.
- **utils**: Contains utility classes for database connectivity and general helpers.

## How to Contribute

1. Fork the repository.
2. Create a new branch for your feature/bug fix.
3. Make your changes and commit them.
4. Push the changes to your forked repository.
5. Create a pull request describing your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any queries or issues, feel free to reach out via khansohailtufailahmed@gmail.com.
