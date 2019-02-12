/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  hanzh
 * Created: 17-Apr-2018
 */

DROP DATABASE if exists MyDatabase;
CREATE DATABASE MyDatabase;
USE Mydatabase;

CREATE TABLE `myrole` (
  `RoleID` int(11) NOT NULL,
  `RoleName` varchar(25) NOT NULL,
  PRIMARY KEY (`RoleID`)
);

CREATE TABLE `mygender` (
    `GenderID`  INT(10) NOT NULL,
    `GenderName` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`GenderID`)
);

CREATE TABLE `mydepartment` (
    `DepartmentID`      INT(10) NOT NULL,
    `DepartmentName`    VARCHAR(50) NOT NULL,
    PRIMARY KEY (`DepartmentID`)
);

CREATE TABLE `myuser`( 
    Username VARCHAR(50) NOT NULL,
    Password VARCHAR(10) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Phone VARCHAR(10),
    Active BIT NOT NULL,
    Firstname VARCHAR(50) NOT NULL,
    Lastname VARCHAR(50) NOT NULL,
    ResetPasswordUUID VARCHAR(100),
    `Role` INT(11) NOT NULL,
    `Department` INT(10),
    PRIMARY KEY (Username),
    KEY `FK_User_Role` (`Role`),
    CONSTRAINT `FK_User_Role` FOREIGN KEY (`Role`) REFERENCES `myrole` (`RoleID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    KEY `FK_User_Department` (`Department`),
    CONSTRAINT `FK_User_Department` FOREIGN KEY (`Department`) REFERENCES `mydepartment` (`DepartmentID`) ON DELETE RESTRICT ON UPDATE RESTRICT
);

insert into `myrole` values (1, 'Manager');
insert into `myrole` values (2, 'Employee');

insert into `mygender` values (1, 'Male');
insert into `mygender` values (2, 'Female');
insert into `mygender` values (3, 'Other');

insert into `mydepartment`  values  (1, 'Human Resource Management');
insert into `mydepartment`  values  (2, 'Accounting and Finance');
insert into `mydepartment`  values  (3, 'Research and Development');
insert into `mydepartment`  values  (4, 'Marketing');

insert into `myuser` values ('admin', 'password', 'zhongliu.han@edu.sait.ca', '4031234567', 1, 'Henry', 'Han', null, 1, 1);
insert into `myuser` values ('anna', 'password', 'anna.galban@edu.sait.ca', '5871234567', 1, 'Anna', 'Galban', null, 2, 2);
insert into `myuser` values ('john', 'password', 'john.sanidad@edu.sait.ca', '4131234567', 1, 'John', 'Sanidad', null, 2, 3);
insert into `myuser` values ('katrina', 'password', 'katrina.pauls@edu.sait.ca', '4091234567', 0, 'Katrina', 'Pauls', null, 2, 4);