-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: localhost    Database: empresadb
-- ------------------------------------------------------
-- Server version	5.7.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table 'departamentos
--

DROP TABLE departamentos;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE departamentos (
  codDepto VARCHAR(4) NOT NULL PRIMARY KEY,
  nombreDpto VARCHAR(20) NOT NULL,
  ciudad VARCHAR(15),
  codDirector VARCHAR(12),
  KEY FK_DIR_idx (codDirector),
  CONSTRAINT FK_DIR FOREIGN KEY (codDirector) REFERENCES empleados (nDIEmp) ON DELETE NO ACTION ON UPDATE NO ACTION
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table utf8departamentos'
--

LOCK TABLES 'departamentos' WRITE;
/*!40000 ALTER TABLE 'departamentos' DISABLE KEYS */;
/*!40000 ALTER TABLE 'departamentos' ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table 'empleados'
--

/*DROP TABLE 'empleados';*/
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE empleados (
  nDIEmp VARCHAR(12) NOT NULL PRIMARY KEY,
  nomEmp VARCHAR(30) NOT NULL,
  sexEmp CHAR(1) NOT NULL,
  fecNac DATE NOT NULL,
  fecIncorporacion DATE NOT NULL,
  salEmp FLOAT NOT NULL,
  comisionE FLOAT NOT NULL,
  cargoE VARCHAR(15) NOT NULL,
  jefeID VARCHAR(12),
  codDepto varchar(4) NOT NULL,
  KEY FK_JEFE_idx (jefeID),
  KEY FK_DPTO (codDepto),
  CONSTRAINT FK_DPTO FOREIGN KEY (codDepto) REFERENCES departamentos (codDepto) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_JEFE_EMP FOREIGN KEY (jefeID) REFERENCES empleados (nDIEmp) ON DELETE NO ACTION ON UPDATE NO ACTION
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table 'empleados'
--

LOCK TABLES 'empleados' WRITE;
/*!40000 ALTER TABLE 'empleados' DISABLE KEYS */;
/*!40000 ALTER TABLE 'empleados' ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-08 10:08:07
