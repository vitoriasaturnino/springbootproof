DROP SCHEMA IF EXISTS spring;

DROP USER IF EXISTS 'user'@'localhost';

CREATE SCHEMA spring;

CREATE USER 'user'@'localhost' IDENTIFIED BY 'pass123';

GRANT SELECT, INSERT, DELETE, UPDATE ON spring.* TO 'user'@'localhost';

USE spring;

CREATE TABLE emp_empregado (
  emp_id bigint primary key auto_increment,
  emp_nome_completo varchar(100) not null,
  emp_ctps bigint not null,
  emp_data_hora_cadastro datetime not null,
  emp_email varchar(30) not null,
  emp_carga_horaria float
);

INSERT INTO emp_empregado (emp_nome_completo, emp_ctps, emp_data_hora_cadastro, emp_email) VALUES ('Taylor Swift', '12345678910', current_timestamp(), 'ts13@gmail.com'),
('Ann Doe', '23456789101', current_timestamp(), 'anndoe@gmail.com');