CREATE DATABASE if not exists vocabulary;
use vocabulary;

SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

CREATE TABLE IF NOT EXISTS account (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(70) NOT NULL,
	first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    email VARCHAR(40) NOT NULL,
	birthday date DEFAULT now(),
    phone VARCHAR(20) not null,
    avatar VARCHAR(50) DEFAULT 'account.png',
    token VARCHAR(100),
    status_account boolean default true
    
);

CREATE TABLE IF NOT EXISTS category (
    id_category INT PRIMARY KEY AUTO_INCREMENT,
    name_category VARCHAR(30),
    date_create date default now(),
    status_category BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS Vocabulary (
    id_vocabulary INT PRIMARY KEY AUTO_INCREMENT,
    id_category INT,
    spelling VARCHAR(100),
    sound VARCHAR(100),
    status_vocabulary BOOLEAN DEFAULT TRUE,
    CONSTRAINT FK_Category FOREIGN KEY (id_category)
        REFERENCES category (id_category)
);

CREATE TABLE IF NOT EXISTS vocabulary_type (
    id_vocabulary_type INT PRIMARY KEY AUTO_INCREMENT,
    id_vocabulary INT,
    type_detail VARCHAR(30) NOT NULL,
    status_vocabulary_type BOOLEAN DEFAULT TRUE,
    CONSTRAINT FK_Vocabulary FOREIGN KEY (id_vocabulary)
        REFERENCES vocabulary (id_vocabulary)
);

create table vocabulary_detail (
	id_vocabulary_detail int primary key auto_increment,
	id_vocabulary_type int,
	mean VARCHAR(100),
	example_detail VARCHAR(200),
	status_vocabulary_detail BOOLEAN DEFAULT TRUE,
	CONSTRAINT FK_VocabularyType FOREIGN KEY (id_vocabulary_type)
        REFERENCES vocabulary_type (id_vocabulary_type)
);