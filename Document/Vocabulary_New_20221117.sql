-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.22-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for vocabulary
DROP DATABASE IF EXISTS `vocabulary`;
CREATE DATABASE IF NOT EXISTS `vocabulary` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `vocabulary`;

-- Dumping structure for table vocabulary.account
DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(70) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `birthday` varchar(10) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `avatar` varchar(50) NOT NULL DEFAULT 'account.png',
  `token` varchar(100) DEFAULT NULL,
  `status_account` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table vocabulary.account: ~0 rows (approximately)

-- Dumping structure for table vocabulary.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id_category` int(11) NOT NULL AUTO_INCREMENT,
  `name_category` varchar(30) NOT NULL,
  `date_create` varchar(10) NOT NULL,
  `status_category` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table vocabulary.category: ~0 rows (approximately)

-- Dumping structure for table vocabulary.type_of_words
DROP TABLE IF EXISTS `type_of_words`;
CREATE TABLE IF NOT EXISTS `type_of_words` (
  `id_type_of_words` int(11) NOT NULL AUTO_INCREMENT,
  `type_of_words` varchar(100) NOT NULL,
  `status_type_of_words` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_type_of_words`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table vocabulary.type_of_words: ~0 rows (approximately)

-- Dumping structure for table vocabulary.vocabulary
DROP TABLE IF EXISTS `vocabulary`;
CREATE TABLE IF NOT EXISTS `vocabulary` (
  `id_vocabulary` int(11) NOT NULL AUTO_INCREMENT,
  `id_category` int(11) NOT NULL,
  `spelling` varchar(100) NOT NULL,
  `sound` varchar(100) NOT NULL,
  `status_vocabulary` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_vocabulary`),
  KEY `FK_Category` (`id_category`),
  CONSTRAINT `FK_Category` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table vocabulary.vocabulary: ~0 rows (approximately)

-- Dumping structure for table vocabulary.vocabulary_detail
DROP TABLE IF EXISTS `vocabulary_detail`;
CREATE TABLE IF NOT EXISTS `vocabulary_detail` (
  `id_vocabulary_detail` int(11) NOT NULL AUTO_INCREMENT,
  `id_vocabulary_type` int(11) NOT NULL,
  `mean` varchar(100) NOT NULL,
  `example_detail` varchar(200) DEFAULT NULL,
  `status_vocabulary_detail` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_vocabulary_detail`),
  KEY `FK_VocabularyType` (`id_vocabulary_type`),
  CONSTRAINT `FK_VocabularyType` FOREIGN KEY (`id_vocabulary_type`) REFERENCES `vocabulary_type` (`id_vocabulary_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table vocabulary.vocabulary_detail: ~0 rows (approximately)

-- Dumping structure for table vocabulary.vocabulary_type
DROP TABLE IF EXISTS `vocabulary_type`;
CREATE TABLE IF NOT EXISTS `vocabulary_type` (
  `id_vocabulary_type` int(11) NOT NULL AUTO_INCREMENT,
  `id_vocabulary` int(11) NOT NULL,
  `id_type_of_words` int(11) NOT NULL,
  `type_detail` varchar(100) NOT NULL,
  `status_vocabulary_type` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_vocabulary_type`),
  KEY `FK_Vocabulary` (`id_vocabulary`),
  KEY `FK_Type_of_words` (`id_type_of_words`),
  CONSTRAINT `FK_Type_of_words` FOREIGN KEY (`id_type_of_words`) REFERENCES `type_of_words` (`id_type_of_words`),
  CONSTRAINT `FK_Vocabulary` FOREIGN KEY (`id_vocabulary`) REFERENCES `vocabulary` (`id_vocabulary`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table vocabulary.vocabulary_type: ~0 rows (approximately)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
