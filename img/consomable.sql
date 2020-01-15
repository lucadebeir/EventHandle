-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 14, 2020 at 05:51 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eventhandle`
--

-- --------------------------------------------------------

--
-- Table structure for table `consomable`
--

DROP TABLE IF EXISTS `consomable`;
CREATE TABLE IF NOT EXISTS `consomable` (
  `idconsomable` int(11) NOT NULL AUTO_INCREMENT,
  `nameconsomable` varchar(32) NOT NULL,
  `locationconsomable` varchar(32) NOT NULL,
  `descriptionconsomable` text NOT NULL,
  `stateconsomable` varchar(32) NOT NULL,
  `volumeconsomable` float DEFAULT NULL,
  `quantityconsomable` int(11) DEFAULT NULL,
  `priceconsomable` float DEFAULT NULL,
  `idEvent` int(11) NOT NULL,
  `limiteDate` date DEFAULT NULL,
  `idConservation` int(11) NOT NULL,
  PRIMARY KEY (`idconsomable`),
  KEY `consomableToEvent` (`idEvent`),
  KEY `consomableToConservation` (`idConservation`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `consomable`
--

INSERT INTO `consomable` (`idconsomable`, `nameconsomable`, `locationconsomable`, `descriptionconsomable`, `stateconsomable`, `volumeconsomable`, `quantityconsomable`, `priceconsomable`, `idEvent`, `limiteDate`, `idConservation`) VALUES
(8, 'testconso', 'paris', 'zeezdzerfz', 'order', 10, 10, 10, 7, '2020-01-14', 4);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `consomable`
--
ALTER TABLE `consomable`
  ADD CONSTRAINT `consomableToConservation` FOREIGN KEY (`idConservation`) REFERENCES `conservation` (`idConservation`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
