-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: mcq_quiz_system
-- ------------------------------------------------------
-- Server version	9.3.0

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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `q_id` int NOT NULL AUTO_INCREMENT,
  `topic_id` int NOT NULL,
  `question` text NOT NULL,
  `option_a` varchar(255) NOT NULL,
  `option_b` varchar(255) NOT NULL,
  `option_c` varchar(255) NOT NULL,
  `option_d` varchar(255) NOT NULL,
  `correct_option` char(1) NOT NULL,
  PRIMARY KEY (`q_id`),
  KEY `topic_id` (`topic_id`),
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (2,1,'Which method is the entry point of Java program?','start()','main()','run()','init()','B'),(3,2,'Which command removes all records but keeps table structure?','DELETE','REMOVE','TRUNCATE','DROP','C'),(4,2,'Which key uniquely identifies a record?','Foreign Key','Primary Key','Candidate Key','Composite Key','B'),(5,3,'Which scheduling algorithm is non-preemptive?','Round Robin','FCFS','Priority','Multilevel','B'),(6,3,'Which part of OS manages memory?','Compiler','Loader','Memory Manager','Assembler','C'),(8,1,'Who is teaching JAVA?','Santo sir','Lumy Miss','Juby Miss','Binu SIr','A'),(9,1,'Which of the following is not a Java primitive type?','char','int','String','double','C'),(10,1,'Which keyword is used to prevent inheritance?','static','final','const','abstract','B'),(12,1,'Which method is used to compare two strings?','equals()','compare()','==','equalsIgnore()','A'),(13,1,'Which concept allows one interface to have multiple implementations?','Abstraction','Encapsulation','Polymorphism','Inheritance','C'),(15,1,'Which exception occurs when dividing by zero?','NullPointerException','ArithmeticException','IOException','NumberFormatException','B'),(16,3,'Which of the following is a deadlock prevention technique?','Bankers Algorithm','Resource Ordering','FCFS','Round Robin','B'),(17,3,'Which scheduling algorithm gives minimum average waiting time?','FCFS','SJF','Round Robin','Priority','B'),(18,3,'Which memory allocation is non-contiguous?','Paging','Segmentation','Contiguous','Static','A'),(19,3,'What is the main function of an operating system?','Compile programs','Manage hardware resources','Create applications','Design UI','B'),(20,3,'Which state comes after ready state?','Running','Waiting','Blocked','Terminated','A'),(21,3,'Which OS is open-source?','Windows','Linux','macOS','DOS','B'),(22,3,'Thrashing occurs due to?','High CPU usage','Excessive paging','Low disk space','Deadlock','B'),(23,3,'Which is not a type of OS?','Distributed OS','Batch OS','Compiler OS','Real-Time OS','C'),(24,2,'Which normal form removes partial dependency?','1NF','2NF','3NF','BCNF','B'),(25,2,'Which SQL clause is used to filter records?','WHERE','ORDER BY','GROUP BY','SELECT','A'),(26,2,'Which command is used to remove a table?','DELETE','DROP','REMOVE','TRUNCATE','B'),(27,2,'Which key allows NULL values?','Primary Key','Foreign Key','Unique Key','Super Key','B'),(28,2,'Which operation combines rows from two tables?','JOIN','UNION','SELECT','PROJECT','A'),(29,2,'Which level ensures no dirty reads?','Read Uncommitted','Read Committed','Serializable','Repeatable Read','C'),(30,2,'Which constraint ensures unique values?','NOT NULL','CHECK','UNIQUE','DEFAULT','C'),(32,1,'What is the output?\n\nint a = 5;\nint b = 2;\nSystem.out.println(a / b);','2.5','2','3','Error','B'),(33,1,'What is the output?\n\nSystem.out.println(\"Java\" + 10 + 20);','Java30','Java1020','30Java','Error','B'),(34,1,'What is the output?\n\nint x = 10;\nif(x = 5)\n    System.out.println(\"Hello\");','Hello','Nothing','Compilation Error','Runtime Error','C'),(35,1,'What is the output?\n\nSystem.out.println(10 + 20 + \"Java\");','30Java','1020Java','Java30','Error','A'),(36,1,'What is the output?\n\nfor(int i = 0; i < 3; i++) {\n    System.out.print(i);\n}','012','123','013','Error','A'),(37,1,'String is in which package?','lang','util','io','nio','A');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic` (
  `topic_id` int NOT NULL AUTO_INCREMENT,
  `topic_name` varchar(50) NOT NULL,
  PRIMARY KEY (`topic_id`),
  UNIQUE KEY `topic_name` (`topic_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (2,'DBMS'),(1,'Java'),(3,'OS');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-19 16:52:03
