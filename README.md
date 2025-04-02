# PointOfSales
 A Java Desktop Application with JDBC, Networking and Multithreading for Inventory Management and Bills Generation of any Business Store.

# Database Configuration

# 1. MySQL Setup
Start MySQL Server
Run these commands:

```
CREATE DATABASE POS;

CREATE TABLE Category (
    Name VARCHAR(255) NOT NULL,
    Description VARCHAR(255) NOT NULL,
    Photo VARCHAR(255) NOT NULL,
    PRIMARY KEY (Name)
);


CREATE TABLE Products (
    PID INT NOT NULL AUTO_INCREMENT,
    PName VARCHAR(255) NOT NULL,
    PDesc VARCHAR(255) NOT NULL,
    Category VARCHAR(255) NOT NULL,
    Quantity VARCHAR(255) NOT NULL,
    Price Int NOT NULL,
    Photo VARCHAR(255) NOT NULL,
    PRIMARY KEY (PID)
);

CREATE TABLE users (
    Username VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Gmail VARCHAR(255) NOT NULL,
    PRIMARY KEY (Username)
);
```
# 2. Update Credentials

Edit src/newproject/DBLoader.java:

```
Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/POS", "username", "Password");
```

# 3. Add Jar Files

Add all the libraries/jar files in src/LIBS folder



