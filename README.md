# 💰 Loan Management System

[![Java](https://img.shields.io/badge/Java-17-blue?logo=java)](https://www.oracle.com/java/)
[![JDBC](https://img.shields.io/badge/JDBC-Database%20Connectivity-green)](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/)
[![Database](https://img.shields.io/badge/Database-MySQL-lightblue?logo=mysql)](https://www.mysql.com/)

A **Loan Management System** built with **Java, JDBC, and MySQL** to automate loan operations such as loan application, approval/rejection, EMI calculation, transaction tracking, and user management.  
This project demonstrates a layered architecture with **DAO, Service, Entity, and MainApp** components.

---

## 🛠 Tech Stack
- ☕ **Java 17**
- 🔗 **JDBC** (Database connectivity)
- 🗄 **MySQL Database**

---

## 📦 Features
- 🔐 User registration & login (roles: **Admin, Agent, Customer**)
- 📋 Loan application by customers
- 🧑‍💼 Loan approval/rejection by agents
- 👨‍💻 Admin view of all loans
- 💸 EMI calculation & loan details management
- 💳 Transaction management (EMI payments)

---

## ⚙️ Prerequisites
- Java 17+  
- MySQL database running locally  

---

## 🚀 Getting Started

1️⃣ **Clone the repository**
```bash
git clone https://github.com/BhaveshPatil1808/Loan-Management-System.git
cd Loan-Management-System
---
2️⃣ Configure Database  
Update DBConnection.java with your DB credentials:
String username = "root";
String password = "yourpassword";
String url = "jdbc:mysql://localhost:3306/Bank";
---
3️⃣ Compile the project
javac -d bin src/com/Loan/**/*.java
---
4️⃣ Run the application
java -cp bin com.Loan.Main.MainApp

---
💬 Usage (CLI Menus)
👤 Customer Menu
Apply Loan

View My Loans

Logout

🧑‍💼 Agent Menu
View Applied Loans

Approve Loan

Reject Loan

Logout

👨‍💻 Admin Menu
View All Loans

Logout
---
📂 Project Structure
Loan-Management-System/
 ├── com.Loan.Main/          # MainApp with CLI menus
 ├── com.Loan.Dao/           # DAO layer (UserDao, LoanDao, LoanDetailsDao, TransactionDAO)
 ├── com.Loan.Service/       # Service layer (UserServiceImpl, LoanServiceImpl, TransactionServiceImpl, EMIService)
 ├── com.Loan.Enitity/       # Entities (User, LoanApplication, LoanDetails, Transaction)
 ├── com.Loan.DB/            # DBConnection (MySQL)
---
🗄 Database Schema (Simplified)
users (id, username, password, role)

loan_applications (id, user_id, amount, duration, status)

loan_details (id, application_id, interest_rate, emi)

transactions (id, loan_id, amount, date)
---
🚀 Future Improvements
🌐 Add web-based UI

🔐 Integrate authentication & role-based security

📊 Add reporting & analytics dashboard

🐳 Dockerize for deployment

🔄 Integrate with payment gateways
---
👨‍💻 Author
Bhavesh Patil
