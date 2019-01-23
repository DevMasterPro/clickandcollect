
CREATE TABLE customer (
    ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Firstname varchar(255),
    Lastname varchar(255),
    Email varchar(255),
    AddressLine1 Varchar(200),
    AddressLine2 Varchar(200),
    City Varchar(200),
    Postcode Varchar(200),
    Telephone Varchar(200),
    disable Varchar(200)
);

CREATE TABLE Seller (
    ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Firstname varchar(255),
    Lastname varchar(255),
    Email varchar(255),
    AddressLine1 Varchar(200),
    AddressLine2 Varchar(200),
    City Varchar(200),
    Postcode Varchar(200),
    Telephone Varchar(200),
    disable Varchar(200)
);

CREATE TABLE Admin (
    ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Firstname varchar(255),
    Lastname varchar(255),
    Email varchar(255),
    AddressLine1 Varchar(200),
    AddressLine2 Varchar(200),
    City Varchar(200),
    Postcode Varchar(200),
    Telephone Varchar(200),
    disable Varchar(200)
);

Insert into Admin (Firstname,Lastname,Email,AddressLine1,AddressLine2,City,Postcode,Telephone,disable)
values('Admin','Miah','admin@hotmail.com','test1','test2','London','e1 5dj','07961108414','No');

Insert into login(password,userid,type) values('1234','1','admin');

CREATE TABLE login (
    ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    password varchar(255),
    userid varchar(20),
    type varchar(200)
);

CREATE TABLE contact (
    ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    email varchar(200),
    description varchar(2000),
    status varchar(5),
    adminid varchar(10)
);



CREATE TABLE Store (
    ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Storename varchar(255),
    Email varchar(255),
    AddressLine1 Varchar(200),
    AddressLine2 Varchar(200),
    City Varchar(200),
    Postcode Varchar(200),
    Telephone Varchar(200),
    sellerid Varchar(200)
);

CREATE TABLE Product (
    ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Productname varchar(255),
    Productinfo varchar(2555),
    Productdesc varchar(4000),
    Image varchar(200),
    Price varchar(200),
    Stroreid varchar(20)
);

CREATE TABLE Orders (
    ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    total varchar(255),
    customerid varchar(255),
    orderdate date
);


CREATE TABLE Ordersline (
    ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Productid varchar(200),
    orderid varchar (200),
    price varchar(255),
    storeid varchar(255),
    quantity varchar(255),
    orderdate date,
    status varchar(20),
    customerid varchar(20)
);

Created a view 
-----------------------------------------------------------------------------------------------------------------
create view sellerorder as 
select p.Productname,c.Firstname,c.Lastname,s.Storename,sel.ID as sellerid, o.ID as orderlineid, o.status
from Ordersline as o 
inner join customer as c  on  c.ID = o.customerid
inner join Product as p on p.ID = o.Productid
inner join Store as s on s.ID =  o.storeid
inner join Seller as sel on sel.ID = s.sellerid;