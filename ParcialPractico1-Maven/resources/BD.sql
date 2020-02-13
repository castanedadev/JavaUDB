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
