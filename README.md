<div align="center">

# 🏨 Hotel Management System

### <i>Smart hotel operations, streamlined with Java and MySQL</i>

<br>

<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white"/>
<img src="https://img.shields.io/badge/Project-Hotel%20Management-success?style=for-the-badge"/>
<img src="https://img.shields.io/badge/Type-Database%20Driven-blueviolet?style=for-the-badge"/>
<img src="https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge"/>

</div>

---

## 🌟 Introduction

The **Hotel Management System** is a Java-based database project developed to manage hotel records in an organized and efficient way.  
It helps handle rooms, guests, bookings, payments, and other hotel operations with the support of **MySQL database integration**.

This project is designed to reduce manual work, improve record handling, and demonstrate how a real-world management system can be built using Java and database concepts.

---

## 🎯 Main Goals

- Automate hotel-related record management
- Maintain room and guest information efficiently
- Manage bookings in a structured way
- Store and retrieve hotel data using MySQL
- Build a practical academic project with real-world relevance

---

## ✨ Key Features

- 🛏 Room management
- 👤 Guest/customer record handling
- 📘 Booking management
- 💳 Payment handling
- 🔐 Admin support
- 🗄 Database integration using MySQL
- ⚡ Easy execution through scripts and Java files

---

## 🛠 Tech Stack

| Technology | Purpose |
|-----------|---------|
| Java | Core application development |
| MySQL | Database storage |
| JDBC / MySQL Connector | Database connectivity |
| Ant / Standard Java Project | Build support |
| Batch & Shell Scripts | Easy execution |

---

## 📂 Detailed Project Structure

```text
hotel/
│
├── src/
│   │
│   ├── Booking.java
│   ├── Guest.java
│   ├── Room.java
│   ├── Admin.java
│   ├── Payment.java
│   ├── HotelDatabaseManager.java
│   ├── HotelManagementApp.java
│   │
│   ├── dao/
│   │   ├── BookingDAO.java
│   │   ├── GuestDAO.java
│   │   ├── RoomDAO.java
│   │   ├── AdminDAO.java
│   │   └── PaymentDAO.java
│   │
│   ├── util/
│   │   └── DBConnection.java
│   │
│   └── service/
│       └── HotelService.java
│
├── database/
│   └── hotel_db.sql
│
├── lib/
│   └── mysql-connector-j-9.6.0.jar
│
├── screenshots/
│   ├── dashboard.png
│   ├── booking-module.png
│   ├── room-management.png
│   └── guest-management.png
│
├── build/
│   └── compiled files
│
├── dist/
│   └── executable jar files
│
├── build.xml
├── run.bat
├── run.sh
├── README.md
├── LICENSE
└── .gitignore
