-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: recrutement
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `candidat`
--

DROP TABLE IF EXISTS `candidat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidat` (
  `id` bigint(20) NOT NULL,
  `date_ajout` datetime DEFAULT NULL,
  `date_modif` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `diplome` varchar(255) DEFAULT NULL,
  `nationalite` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `piece_jointe` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidat`
--

LOCK TABLES `candidat` WRITE;
/*!40000 ALTER TABLE `candidat` DISABLE KEYS */;
INSERT INTO `candidat` VALUES (2,'2020-01-18 16:37:13','2020-01-18 16:37:13','sssdsd@ssdsssfffddssd.com','sdssddsdsd','CANDIDAT','nbnbnb','2019-10-12 00:00:00','sdsdsd','bnnnbbnbn','sdsd',NULL,NULL,'sdsdsdsdsd','bnbnnb','bnbn'),(3,'2020-01-18 16:37:46','2020-01-18 16:37:46','bc@abc.com','sdssddsdsd','CANDIDAT','nbnbnb','2019-10-12 00:00:00','sdsdsd','bnnnbbnbn','sdsd',NULL,NULL,'sdsdsdsdsd','bnbnnb','bnbn');
/*!40000 ALTER TABLE `candidat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidat_competences`
--

DROP TABLE IF EXISTS `candidat_competences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidat_competences` (
  `candidat_id` bigint(20) NOT NULL,
  `competences_id` bigint(20) NOT NULL,
  KEY `FKelmmi6aqev86sg6mlqvps71f6` (`competences_id`),
  KEY `FKceqq7hgx9xwwfnwhy4eciuar` (`candidat_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidat_competences`
--

LOCK TABLES `candidat_competences` WRITE;
/*!40000 ALTER TABLE `candidat_competences` DISABLE KEYS */;
INSERT INTO `candidat_competences` VALUES (2,1),(3,1);
/*!40000 ALTER TABLE `candidat_competences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidat_experiences`
--

DROP TABLE IF EXISTS `candidat_experiences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidat_experiences` (
  `candidat_id` bigint(20) NOT NULL,
  `experiences_id` bigint(20) NOT NULL,
  KEY `FKb57ur90fvogikr0ocp7cqew5q` (`experiences_id`),
  KEY `FK33libmcp9yatnbpdhoufulqlb` (`candidat_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidat_experiences`
--

LOCK TABLES `candidat_experiences` WRITE;
/*!40000 ALTER TABLE `candidat_experiences` DISABLE KEYS */;
INSERT INTO `candidat_experiences` VALUES (2,1),(3,1);
/*!40000 ALTER TABLE `candidat_experiences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidat_formations`
--

DROP TABLE IF EXISTS `candidat_formations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidat_formations` (
  `candidat_id` bigint(20) NOT NULL,
  `formations_id` bigint(20) NOT NULL,
  KEY `FKff8q87x8obmp37bg6vjdawnjn` (`formations_id`),
  KEY `FK72h3wj9ifv7nq3iyp4iwe4j8y` (`candidat_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidat_formations`
--

LOCK TABLES `candidat_formations` WRITE;
/*!40000 ALTER TABLE `candidat_formations` DISABLE KEYS */;
INSERT INTO `candidat_formations` VALUES (2,1),(3,1);
/*!40000 ALTER TABLE `candidat_formations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidat_langues`
--

DROP TABLE IF EXISTS `candidat_langues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidat_langues` (
  `candidat_id` bigint(20) NOT NULL,
  `langues_id` bigint(20) NOT NULL,
  KEY `FKf8caqi2dheiggi5j8tiaq7364` (`langues_id`),
  KEY `FKcl78cjwarw8fq2i3y50rhb1kd` (`candidat_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidat_langues`
--

LOCK TABLES `candidat_langues` WRITE;
/*!40000 ALTER TABLE `candidat_langues` DISABLE KEYS */;
INSERT INTO `candidat_langues` VALUES (2,1),(3,1);
/*!40000 ALTER TABLE `candidat_langues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidature`
--

DROP TABLE IF EXISTS `candidature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidature` (
  `candidat_id` bigint(20) NOT NULL,
  `offre_id` bigint(20) NOT NULL,
  KEY `FKreoctvslgrncreex2k469kb0g` (`offre_id`),
  KEY `FKplts544b4lj10vtg3inok4c9e` (`candidat_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidature`
--

LOCK TABLES `candidature` WRITE;
/*!40000 ALTER TABLE `candidature` DISABLE KEYS */;
INSERT INTO `candidature` VALUES (2,1),(3,1);
/*!40000 ALTER TABLE `candidature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competence`
--

DROP TABLE IF EXISTS `competence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `competence` (
  `id` bigint(20) NOT NULL,
  `date_ajout` datetime DEFAULT NULL,
  `date_modif` datetime DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competence`
--

LOCK TABLES `competence` WRITE;
/*!40000 ALTER TABLE `competence` DISABLE KEYS */;
INSERT INTO `competence` VALUES (1,'2020-01-18 16:37:06','2020-01-18 16:37:06','js');
/*!40000 ALTER TABLE `competence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domaine`
--

DROP TABLE IF EXISTS `domaine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `domaine` (
  `id` bigint(20) NOT NULL,
  `date_ajout` datetime DEFAULT NULL,
  `date_modif` datetime DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domaine`
--

LOCK TABLES `domaine` WRITE;
/*!40000 ALTER TABLE `domaine` DISABLE KEYS */;
INSERT INTO `domaine` VALUES (1,'2020-01-18 16:37:06','2020-01-18 16:37:06','Informatique');
/*!40000 ALTER TABLE `domaine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeur`
--

DROP TABLE IF EXISTS `employeur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employeur` (
  `id` bigint(20) NOT NULL,
  `date_ajout` datetime DEFAULT NULL,
  `date_modif` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `fondation` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `pays` varchar(255) DEFAULT NULL,
  `photo` tinyblob,
  `presentation` varchar(255) DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  `taille` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeur`
--

LOCK TABLES `employeur` WRITE;
/*!40000 ALTER TABLE `employeur` DISABLE KEYS */;
INSERT INTO `employeur` VALUES (1,'2020-01-18 16:37:06','2020-01-18 16:37:06','test@emp.com','abc','employeur','tunis','tt','cbmo','tunisie',NULL,'dd','dd','12','SSII');
/*!40000 ALTER TABLE `employeur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeur_offres`
--

DROP TABLE IF EXISTS `employeur_offres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employeur_offres` (
  `employeur_id` bigint(20) NOT NULL,
  `offres_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_d5eisdglsw60wo970m1vfenki` (`offres_id`),
  KEY `FKkrtswnewv5rjn07fhgiw8anls` (`employeur_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeur_offres`
--

LOCK TABLES `employeur_offres` WRITE;
/*!40000 ALTER TABLE `employeur_offres` DISABLE KEYS */;
INSERT INTO `employeur_offres` VALUES (1,1);
/*!40000 ALTER TABLE `employeur_offres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experience`
--

DROP TABLE IF EXISTS `experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experience` (
  `id` bigint(20) NOT NULL,
  `date_ajout` datetime DEFAULT NULL,
  `date_modif` datetime DEFAULT NULL,
  `debut` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `employeur` varchar(255) DEFAULT NULL,
  `fin` datetime DEFAULT NULL,
  `lieu` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experience`
--

LOCK TABLES `experience` WRITE;
/*!40000 ALTER TABLE `experience` DISABLE KEYS */;
INSERT INTO `experience` VALUES (1,'2020-01-18 16:37:06','2020-01-18 16:37:06','2020-01-18 16:37:06','full stack developpeur','CBMO','2020-01-18 16:37:06','Tunis','ing');
/*!40000 ALTER TABLE `experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formation`
--

DROP TABLE IF EXISTS `formation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formation` (
  `id` bigint(20) NOT NULL,
  `date_ajout` datetime DEFAULT NULL,
  `date_modif` datetime DEFAULT NULL,
  `debut` datetime DEFAULT NULL,
  `etablissement` varchar(255) DEFAULT NULL,
  `fin` datetime DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formation`
--

LOCK TABLES `formation` WRITE;
/*!40000 ALTER TABLE `formation` DISABLE KEYS */;
INSERT INTO `formation` VALUES (1,'2020-01-18 16:37:06','2020-01-18 16:37:06','2020-01-18 16:37:06','ULT','2020-01-18 16:37:06','ing');
/*!40000 ALTER TABLE `formation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (7),(7),(7),(7),(7),(7),(7),(7);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `langue`
--

DROP TABLE IF EXISTS `langue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `langue` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date_ajout` datetime DEFAULT NULL,
  `date_modif` datetime DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `niveau` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `langue`
--

LOCK TABLES `langue` WRITE;
/*!40000 ALTER TABLE `langue` DISABLE KEYS */;
INSERT INTO `langue` VALUES (4,'FR','2020-01-18 16:39:58','2020-01-18 16:39:58','Francais','B2'),(5,'EN','2020-01-18 16:40:12','2020-01-18 16:40:12','Englais','B2');
/*!40000 ALTER TABLE `langue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offre`
--

DROP TABLE IF EXISTS `offre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offre` (
  `id` bigint(20) NOT NULL,
  `date_ajout` datetime DEFAULT NULL,
  `date_modif` datetime DEFAULT NULL,
  `fonction` varchar(255) DEFAULT NULL,
  `horaire` varchar(255) DEFAULT NULL,
  `niveau_etude` varchar(255) DEFAULT NULL,
  `niveau_experience` varchar(255) DEFAULT NULL,
  `salaire` varchar(255) DEFAULT NULL,
  `domaine_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKls8khe5k8hd1nhe56se5n641y` (`domaine_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offre`
--

LOCK TABLES `offre` WRITE;
/*!40000 ALTER TABLE `offre` DISABLE KEYS */;
INSERT INTO `offre` VALUES (1,'2020-01-18 16:37:06','2020-01-18 16:37:06','service','8','Bac + 5 ','2+','1800',1);
/*!40000 ALTER TABLE `offre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offre_langues`
--

DROP TABLE IF EXISTS `offre_langues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offre_langues` (
  `offre_id` bigint(20) NOT NULL,
  `langues_id` bigint(20) NOT NULL,
  KEY `FKd3pp0pfcsf56pj81rpgc6e1sp` (`langues_id`),
  KEY `FK7owg3l0496hrawyvxsi1g4x5y` (`offre_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offre_langues`
--

LOCK TABLES `offre_langues` WRITE;
/*!40000 ALTER TABLE `offre_langues` DISABLE KEYS */;
INSERT INTO `offre_langues` VALUES (1,4);
/*!40000 ALTER TABLE `offre_langues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poste`
--

DROP TABLE IF EXISTS `poste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poste` (
  `id` bigint(20) NOT NULL,
  `date_ajout` datetime DEFAULT NULL,
  `date_modif` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poste`
--

LOCK TABLES `poste` WRITE;
/*!40000 ALTER TABLE `poste` DISABLE KEYS */;
INSERT INTO `poste` VALUES (1,'2020-01-18 16:37:06','2020-01-18 16:37:06','Dev','dev'),(6,'2020-01-18 16:37:06','2020-01-18 16:48:29','Dev','devfdfd');
/*!40000 ALTER TABLE `poste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilisateur` (
  `id` bigint(20) NOT NULL,
  `date_ajout` datetime DEFAULT NULL,
  `date_modif` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (1,'2020-01-18 16:37:06','2020-01-18 16:37:06','test@test.Com','abc','Admin');
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-18 21:30:26
