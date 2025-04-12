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

Create table POS.Bills(
	BillID INT NOT NULL Auto_Increment,
    Date_Time datetime Not null,
    GTotal Int Not Null,
    AdminEmail Varchar(100) Not Null,
    PhoneNo Varchar(15) Not Null,
    Payment_Type Varchar(50) Not Null,
    Primary Key(BillID)
);

Create table POS.BillDetails(
	BillDetailsID INT NOT NULL Auto_Increment,
    BillID INT NOT NULL,
    PName Varchar(50) Not Null,
    PricePerUnit Int Not Null,
    Quantity Int Not Null,
    Primary Key(BillDetailsID),
    FOREIGN KEY (BillID) REFERENCES POS.Bills(BillID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
```
# 2. Update Credentials

Edit src/newproject/DBLoader.java:

```
Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/POS", "username", "Password");
```

# 3. Add Jar Files

Add all the libraries/jar files in src/LIBS folder


#

# Run the Application

Go to src/newproject/AdminLogin.java and run the file. It will also start server automatically.
If you want to open any other file, then you have to run MyServer.java manually.


