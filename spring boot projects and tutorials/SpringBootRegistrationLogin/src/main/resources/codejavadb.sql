-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: codejavadb
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 
-- create database schema
-- 
CREATE SCHEMA `codejavadb` ;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `password` varchar(64) NOT NULL,
  `verification_code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-17 15:24:12

-- Use the codejavadb database
USE `codejavadb`;

--
-- Insert additional sample data into 'users' table
-- 
INSERT INTO `users` (`email`, `enabled`, `first_name`, `last_name`, `password`, `verification_code`)
VALUES
  ('user1@example.com', 1, 'John', 'Doe', 'hashed_password_1', 'verification_code_1'),
  ('user2@example.com', 1, 'Jane', 'Smith', 'hashed_password_2', 'verification_code_2'),
  ('user3@example.com', 0, 'Alice', 'Johnson', 'hashed_password_3', 'verification_code_3'),
  ('user4@example.com', 1, 'David', 'Brown', 'hashed_password_4', 'verification_code_4'),
  ('user5@example.com', 1, 'Emily', 'White', 'hashed_password_5', 'verification_code_5'),
  ('user6@example.com', 0, 'Michael', 'Miller', 'hashed_password_6', 'verification_code_6'),
  ('user7@example.com', 1, 'Olivia', 'Wilson', 'hashed_password_7', 'verification_code_7'),
  ('user8@example.com', 1, 'Daniel', 'Davis', 'hashed_password_8', 'verification_code_8'),
  ('user9@example.com', 0, 'Sophia', 'Moore', 'hashed_password_9', 'verification_code_9'),
  ('user10@example.com', 1, 'Ethan', 'Johnson', 'hashed_password_10', 'verification_code_10'),
  ('user11@example.com', 1, 'Emma', 'Anderson', 'hashed_password_11', 'verification_code_11'),
  ('user12@example.com', 0, 'Matthew', 'Thomas', 'hashed_password_12', 'verification_code_12'),
  ('user13@example.com', 1, 'Ava', 'Martinez', 'hashed_password_13', 'verification_code_13'),
  ('user14@example.com', 1, 'Noah', 'Taylor', 'hashed_password_14', 'verification_code_14'),
  ('user15@example.com', 0, 'Isabella', 'Clark', 'hashed_password_15', 'verification_code_15'),
  ('user16@example.com', 1, 'Liam', 'Lewis', 'hashed_password_16', 'verification_code_16'),
  ('user17@example.com', 1, 'Sophie', 'Lee', 'hashed_password_17', 'verification_code_17'),
  ('user18@example.com', 0, 'Jackson', 'Brown', 'hashed_password_18', 'verification_code_18'),
  ('user19@example.com', 1, 'Aria', 'Harris', 'hashed_password_19', 'verification_code_19'),
  ('user20@example.com', 1, 'Logan', 'King', 'hashed_password_20', 'verification_code_20'),
  ('user21@example.com', 0, 'Amelia', 'Wright', 'hashed_password_21', 'verification_code_21'),
  ('user22@example.com', 1, 'Mason', 'Evans', 'hashed_password_22', 'verification_code_22'),
  ('user23@example.com', 1, 'Evelyn', 'Brown', 'hashed_password_23', 'verification_code_23'),
  ('user24@example.com', 0, 'Caden', 'Moore', 'hashed_password_24', 'verification_code_24'),
  ('user25@example.com', 1, 'Harper', 'Davis', 'hashed_password_25', 'verification_code_25'),
  ('user26@example.com', 1, 'Hudson', 'Miller', 'hashed_password_26', 'verification_code_26'),
  ('user27@example.com', 0, 'Grace', 'Wilson', 'hashed_password_27', 'verification_code_27'),
  ('user28@example.com', 1, 'Lucas', 'Smith', 'hashed_password_28', 'verification_code_28'),
  ('user29@example.com', 1, 'Lily', 'Brown', 'hashed_password_29', 'verification_code_29'),
  ('user30@example.com', 0, 'Liam', 'Martinez', 'hashed_password_30', 'verification_code_30'),
  ('user31@example.com', 1, 'Chloe', 'White', 'hashed_password_31', 'verification_code_31'),
  ('user32@example.com', 1, 'Aiden', 'Johnson', 'hashed_password_32', 'verification_code_32'),
  ('user33@example.com', 0, 'Avery', 'Moore', 'hashed_password_33', 'verification_code_33'),
  ('user34@example.com', 1, 'Ella', 'Davis', 'hashed_password_34', 'verification_code_34'),
  ('user35@example.com', 1, 'Jackson', 'Taylor', 'hashed_password_35', 'verification_code_35'),
  ('user36@example.com', 0, 'Scarlett', 'Anderson', 'hashed_password_36', 'verification_code_36'),
  ('user37@example.com', 1, 'Carter', 'Lewis', 'hashed_password_37', 'verification_code_37'),
  ('user38@example.com', 1, 'Aria', 'Clark', 'hashed_password_38', 'verification_code_38'),
  ('user39@example.com', 0, 'Grayson', 'Wright', 'hashed_password_39', 'verification_code_39'),
  ('user40@example.com', 1, 'Aurora', 'Evans', 'hashed_password_40', 'verification_code_40'),
  ('user41@example.com', 1, 'Landon', 'Brown', 'hashed_password_41', 'verification_code_41'),
  ('user42@example.com', 0, 'Mila', 'Moore', 'hashed_password_42', 'verification_code_42'),
  ('user43@example.com', 1, 'Elijah', 'Davis', 'hashed_password_43', 'verification_code_43'),
  ('user44@example.com', 1, 'Nova', 'Miller', 'hashed_password_44', 'verification_code_44'),
  ('user45@example.com', 0, 'Lincoln', 'Wilson', 'hashed_password_45', 'verification_code_45'),
  ('user46@example.com', 1, 'Aria', 'Smith', 'hashed_password_46', 'verification_code_46'),
  ('user47@example.com', 1, 'Ezra', 'Brown', 'hashed_password_47', 'verification_code_47'),
  ('user48@example.com', 0, 'Layla', 'Harris', 'hashed_password_48', 'verification_code_48'),
  ('user49@example.com', 1, 'Wyatt', 'King', 'hashed_password_49', 'verification_code_49'),
  ('user50@example.com', 1, 'Piper', 'Wright', 'hashed_password_50', 'verification_code_50');

-- Display the inserted data
SELECT * FROM `users`;
