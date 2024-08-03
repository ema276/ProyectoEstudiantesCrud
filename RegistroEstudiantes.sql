Drop database if exists registro_Estudiantes;
CREATE DATABASE registro_Estudiantes;
USE registro_Estudiantes;

CREATE TABLE Usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(50) NOT NULL,
    contrasena VARCHAR(50) NOT NULL
);

-- Tabla para los datos de los estudiantes
CREATE TABLE Estudiantes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    estatus VARCHAR(25),
    municipio VARCHAR(100),
    estado VARCHAR(100),
    documentos VARCHAR(100)
    
);

Select * From Estudiantes;