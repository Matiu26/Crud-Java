create database if not exists prog;
use prog;
CREATE TABLE IF NOT EXISTS personas(
    Cedula INT NOT NULL PRIMARY KEY,
    Nombre VARCHAR(20) NOT NULL,
    Contrasenia VARCHAR(12),
    Tipo_Funcionario CHAR(1) NOT NULL,
     Estado CHAR(1) NOT NULL
);
CREATE TABLE IF NOT EXISTS registro (
    Cedula INT NOT NULL PRIMARY KEY,
      fecha DATE NOT NULL ,
      entrada TIME NOT NULL ,
      salida TIME NOT NULL 
);

CREATE TABLE IF NOT EXISTS usuarios(
    Id_Usuario INT NOT NULL PRIMARY KEY,
    Rol VARCHAR(2) NOT NULL,
    Usuario VARCHAR(45)  NOT NULL,
   Password VARCHAR(45) NOT NULL
);