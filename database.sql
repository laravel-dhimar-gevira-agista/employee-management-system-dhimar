CREATE DATABASE IF NOT EXISTS employee_management;
USE employee_management;

-- =========================
-- Tabel Users
-- =========================
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- =========================
-- Tabel Divisions
-- =========================
CREATE TABLE divisions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    division_name VARCHAR(100) NOT NULL
);

-- =========================
-- Tabel Positions
-- =========================
CREATE TABLE positions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    position_name VARCHAR(100) NOT NULL,
    level INT NOT NULL
);

-- =========================
-- Tabel Employees
-- =========================
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(100) NOT NULL,
    address TEXT,
    phone VARCHAR(20),
    division_id INT,
    position_id INT,

    CONSTRAINT fk_division
        FOREIGN KEY (division_id)
        REFERENCES divisions(id),

    CONSTRAINT fk_position
        FOREIGN KEY (position_id)
        REFERENCES positions(id)
);
INSERT INTO users(username, password)
VALUES
('admin','admin123');

INSERT INTO divisions(division_name)
VALUES
('IT'),
('HRD'),
('Finance');

INSERT INTO positions(position_name, level)
VALUES
('Staff',1),
('Supervisor',2),
('Manager',3);