CREATE DATABASE dpbd;
USE dpdb;

CREATE TABLE Departamento(
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NomeDepto VARCHAR(60) NOT NULL,
    IdFuncGerente INT
);

CREATE TABLE Cargo(
    Id INT NO NULL AUTO_INCREMENT PRIMARY KEY,
    Descricao VARCHAR(60) NOT NULL,
    IdDepto INT NOT NULL,
    FOREIGN KEY(IdDepto) REFERENCES Departamento(Id)
);

CREATE TABLE Funcionario(
    Id INT Not AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(80) NOT NULL,
    Sexo CHAR(1) NOT NULL,
    Salario DECIMAL(7, 2) NOT NULL,
    Planosaude BOOL default true,
    IdCargo INT NOT NULL,
    FOREIGN KEY(IdCargo) REFERENCES Cargo(Id)
);

ALTER TABLE Departamento ADD CONSTRAINT FOREIGN KEY REFERENCES Funcionario(Id);
ALTER TABLE Departamento ADD CONSTRAINT UNIQUE(IdFuncGerente);