/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  rickc
 * Created: Feb 13, 2020
 */

CREATE TABLE `pp1`.`empleados`(
    `Id` INT NOT NULL AUTO_INCREMENT,
    `Nombres` VARCHAR(100) NULL,
    `Apellidos` VARCHAR(100) NULL,
    `Dui` VARCHAR(10) NOT NULL,
    `Nit` INT(17) NOT NULL,
    `SalarioBase` DECIMAL(15) NOT NULL,
    PRIMARY KEY(`Id`)
) ENGINE = MyISAM

CREATE TABLE `pp1`.`historico`(
    `Id` INT NOT NULL AUTO_INCREMENT,
    `EmpleadoId` VARCHAR(100) NULL,
    `SueldoLiquido`  DECIMAL(15,2) NOT NULL,
    `Descuentos` DECIMAL(15,2) NOT NULL,
    `Fecha` TIMESTAMP NULL,
    PRIMARY KEY(`Id`),
    FOREIGN KEY (EmpleadoId) REFERENCES empleados(Id)
) ENGINE = MyISAM

INSERT INTO `empleados` (`Id`, `Nombres`, `Apellidos`, `Dui`, `Nit`, `SalarioBase`) 
VALUES (NULL, 'Ricardo Jose', 'Castaneda Hernandez', '04610484-2', '0501-060492-101-1', '3500')

SELECT `Id`, `Nombres`, `Apellidos`, `Dui`, `Nit`, `SalarioBase`, `TipoEmpleado` 
FROM `empleados` WHERE `Dui` = '04610484-2'

SELECT * FROM `empleados` WHERE `Dui` = '04610484-2'



-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Feb 13, 2020 at 11:10 PM
-- Server version: 8.0.18
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `pp1`
--

-- --------------------------------------------------------

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE IF NOT EXISTS `empleados` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(100) DEFAULT NULL,
  `Apellidos` varchar(100) DEFAULT NULL,
  `Dui` varchar(10) NOT NULL,
  `Nit` varchar(17) NOT NULL,
  `SalarioBase` decimal(15,0) NOT NULL,
  `TipoEmpleado` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `empleados`
--

INSERT INTO `empleados` (`Id`, `Nombres`, `Apellidos`, `Dui`, `Nit`, `SalarioBase`, `TipoEmpleado`) VALUES
(1, 'Ricardo Jose', 'Castaneda Hernandez', '04610484-2', '0501-060492-101-1', '3500', 'TIPO_PROGRAMADOR'),
(2, 'Simon Alberto', 'Parras Albiol', '00172855-2', '1023-051077-101-2', '900', 'TIPO_OTROS');
COMMIT;
