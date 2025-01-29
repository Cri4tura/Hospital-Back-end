drop database if exists Hospital;

CREATE DATABASE Hospital;

USE Hospital;

CREATE TABLE Nurse (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for each nurse
    name VARCHAR(50) NOT NULL,         -- First name of the nurse
    surname VARCHAR(50) NOT NULL,      -- Last name of the nurse
    email VARCHAR(100) UNIQUE NOT NULL, -- Email of the nurse (must be unique)
    password VARCHAR(255) NOT NULL,    -- Encrypted password
    birth_date DATE NOT NULL,          -- Birthdate of the nurse
    register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Date of registration
);

INSERT INTO Nurse (name, surname, email, password, birth_date, register_date) VALUES
('Ana', 'Martínez', 'test@gmail.com', '1234', '1990-03-12', '2023-05-01'),
('Luis', 'Gómez', 'luis.gomez@example.com', 'password123', '1985-06-24', '2023-05-02'),
('Carla', 'Pérez', 'carla.perez@example.com', 'password123', '1992-09-15', '2023-05-03'),
('José', 'López', 'jose.lopez@example.com', 'password123', '1988-02-18', '2023-05-04'),
('Marta', 'Hernández', 'marta.hernandez@example.com', 'password123', '1995-11-30', '2023-05-05'),
('Pedro', 'Sánchez', 'pedro.sanchez@example.com', 'password123', '1991-07-07', '2023-05-06'),
('Lucía', 'Ramírez', 'lucia.ramirez@example.com', 'password123', '1993-01-21', '2023-05-07'),
('Sofía', 'Torres', 'sofia.torres@example.com', 'password123', '1987-04-11', '2023-05-08'),
('Carlos', 'Vega', 'carlos.vega@example.com', 'password123', '1996-12-02', '2023-05-09'),
('Elena', 'Castro', 'elena.castro@example.com', 'password123', '1990-05-19', '2023-05-10'),
('Manuel', 'Molina', 'manuel.molina@example.com', 'password123', '1989-08-25', '2023-05-11'),
('Laura', 'Morales', 'laura.morales@example.com', 'password123', '1994-10-10', '2023-05-12'),
('Diego', 'Núñez', 'diego.nunez@example.com', 'password123', '1997-03-03', '2023-05-13'),
('Raquel', 'Ortiz', 'raquel.ortiz@example.com', 'password123', '1991-09-09', '2023-05-14'),
('Isabel', 'Guerrero', 'isabel.guerrero@example.com', 'password123', '1986-07-16', '2023-05-15'),
('Fernando', 'Cruz', 'fernando.cruz@example.com', 'password123', '1983-01-01', '2023-05-16'),
('María', 'Navarro', 'maria.navarro@example.com', 'password123', '1985-10-30', '2023-05-17'),
('Rafael', 'Díaz', 'rafael.diaz@example.com', 'password123', '1988-05-20', '2023-05-18'),
('Clara', 'Fuentes', 'clara.fuentes@example.com', 'password123', '1990-12-31', '2023-05-19'),
('Álvaro', 'Silva', 'alvaro.silva@example.com', 'password123', '1992-06-06', '2023-05-20');

