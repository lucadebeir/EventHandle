-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  Dim 12 jan. 2020 à 15:59
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `eventhandle`
--

-- --------------------------------------------------------

--
-- Structure de la table `activity`
--

DROP TABLE IF EXISTS `activity`;
CREATE TABLE IF NOT EXISTS `activity` (
  `idActivity` int(11) NOT NULL AUTO_INCREMENT,
  `nameActivity` varchar(32) NOT NULL,
  `statusActivity` tinyint(1) NOT NULL DEFAULT '0',
  `descriptionActivity` text NOT NULL,
  `idEvent` int(11) NOT NULL,
  PRIMARY KEY (`idActivity`),
  KEY `idEvent` (`idEvent`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `activity`
--

INSERT INTO `activity` (`idActivity`, `nameActivity`, `statusActivity`, `descriptionActivity`, `idEvent`) VALUES
(3, 'Cuisine', 0, 'Toutes les activités liées à la cuisine.', 3),
(4, 'Salle', 0, 'Toutes les activités liées à l\'installation de la salle.', 3);

-- --------------------------------------------------------

--
-- Structure de la table `chat`
--

DROP TABLE IF EXISTS `chat`;
CREATE TABLE IF NOT EXISTS `chat` (
  `idChat` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  `contentMessage` text NOT NULL,
  PRIMARY KEY (`idChat`),
  KEY `chatUser` (`idUser`),
  KEY `chatEvent` (`idEvent`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `chat`
--

INSERT INTO `chat` (`idChat`, `idUser`, `idEvent`, `contentMessage`) VALUES
(1, 1, 7, 'Salut !'),
(2, 2, 7, 'Yo bg'),
(3, 1, 7, 'Bien?'),
(4, 1, 7, 'Et toi?'),
(5, 1, 7, 'Tranquille'),
(6, 1, 7, 'ok'),
(7, 1, 7, 'ok'),
(8, 2, 7, 'coucou'),
(9, 1, 7, 'yo'),
(10, 2, 7, 'ça va?'),
(11, 1, 7, 'oklm'),
(12, 1, 11, 'hey !'),
(13, 1, 7, 'lll'),
(14, 2, 7, 'a');

-- --------------------------------------------------------

--
-- Structure de la table `collaborator`
--

DROP TABLE IF EXISTS `collaborator`;
CREATE TABLE IF NOT EXISTS `collaborator` (
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  `typeCollaboraor` varchar(32) NOT NULL,
  KEY `event` (`idEvent`),
  KEY `user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `concern`
--

DROP TABLE IF EXISTS `concern`;
CREATE TABLE IF NOT EXISTS `concern` (
  `idActivity` int(11) NOT NULL,
  `idTask` int(11) NOT NULL,
  KEY `activity` (`idActivity`),
  KEY `task` (`idTask`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `conservation`
--

DROP TABLE IF EXISTS `conservation`;
CREATE TABLE IF NOT EXISTS `conservation` (
  `idConservation` int(11) NOT NULL AUTO_INCREMENT,
  `nameConservation` varchar(32) NOT NULL,
  `descriptionConservation` text NOT NULL,
  `storageTemperature` int(11) NOT NULL,
  `dateConservation` date NOT NULL,
  PRIMARY KEY (`idConservation`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `conservation`
--

INSERT INTO `conservation` (`idConservation`, `nameConservation`, `descriptionConservation`, `storageTemperature`, `dateConservation`) VALUES
(3, 'Sauce tomate', 'Bolo pour pâte', 27, '2020-02-28'),
(4, 'Jus d\'orange', 'Sans pulpe', 25, '2020-01-24');
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
  PRIMARY KEY (`idconsomable`),
  KEY `consomableToEvent` (`idEvent`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `contract`
--

DROP TABLE IF EXISTS `contract`;
CREATE TABLE IF NOT EXISTS `contract` (
  `numContract` int(11) NOT NULL AUTO_INCREMENT,
  `libelleContract` text NOT NULL,
  `clauseContract` text NOT NULL,
  `idEvent` int(11) NOT NULL,
  `idSponsor` int(11) NOT NULL,
  PRIMARY KEY (`numContract`),
  KEY `sponsor` (`idSponsor`),
  KEY `eventSponsor` (`idEvent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `event`
--

DROP TABLE IF EXISTS `event`;
CREATE TABLE IF NOT EXISTS `event` (
  `idEvent` int(11) NOT NULL AUTO_INCREMENT,
  `nameEvent` varchar(32) NOT NULL,
  `dateStartEvent` date NOT NULL,
  `locationEvent` varchar(32) NOT NULL,
  `dateEndEvent` date NOT NULL,
  `descriptionEvent` text NOT NULL,
  `idCreator` int(11) NOT NULL,
  PRIMARY KEY (`idEvent`),
  KEY `managerUser` (`idCreator`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `event`
--

INSERT INTO `event` (`idEvent`, `nameEvent`, `dateStartEvent`, `locationEvent`, `dateEndEvent`, `descriptionEvent`, `idCreator`) VALUES
(3, 'Gala', '2020-03-07', 'La Grande Motte', '2019-12-08', 'Gala annuel de Polytech Montpellier', 1),
(7, 'Soirée P1', '2019-10-17', 'Marsillargues', '2019-10-18', 'Première soirée privée de Polytech', 1),
(9, 'Semaine blanche', '2020-01-25', 'Domaine Les Sybelles', '2020-02-01', 'Trop bien', 1),
(10, 'Soirée P3', '2020-03-27', 'Montpellier', '2020-03-28', 'dernière soirée P', 1),
(11, 'Soirée RDD', '2019-12-07', 'Montpellier', '2019-12-08', 'Soirée pour les diplômés', 1);

--
-- Déclencheurs `event`
--
DROP TRIGGER IF EXISTS `addManager`;
DELIMITER $$
CREATE TRIGGER `addManager` AFTER INSERT ON `event` FOR EACH ROW BEGIN
    IF NEW.idEvent IS NOT NULL THEN
        INSERT INTO isManager
        VALUES(NEW.idCreator,NEW.idEvent);
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `isintervener`
--

DROP TABLE IF EXISTS `isintervener`;
CREATE TABLE IF NOT EXISTS `isintervener` (
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  KEY `intervenerEvent` (`idEvent`),
  KEY `intervenerUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ismanager`
--

DROP TABLE IF EXISTS `ismanager`;
CREATE TABLE IF NOT EXISTS `ismanager` (
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  KEY `managerUser` (`idUser`),
  KEY `managerEvent` (`idEvent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ismanager`
--

INSERT INTO `ismanager` (`idUser`, `idEvent`) VALUES
(1, 3),
(1, 7),
(1, 9),
(1, 10),
(1, 11),
(1, 7),
(1, 3),
(1, 9),
(1, 10),
(1, 11),
(2, 7),
(4, 3);

-- --------------------------------------------------------

--
-- Structure de la table `isvolunteer`
--

DROP TABLE IF EXISTS `isvolunteer`;
CREATE TABLE IF NOT EXISTS `isvolunteer` (
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  KEY `volunteerUser` (`idUser`),
  KEY `volunteerEvent` (`idEvent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `isvolunteer`
--

INSERT INTO `isvolunteer` (`idUser`, `idEvent`) VALUES
(2, 7);

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `idMessage` int(11) NOT NULL AUTO_INCREMENT,
  `idUserSender` int(11) NOT NULL,
  `idUserReceiver` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  `contentMessage` text NOT NULL,
  `objectMessage` varchar(32) NOT NULL,
  PRIMARY KEY (`idMessage`),
  KEY `receiverMessage` (`idUserReceiver`),
  KEY `senderMessage` (`idUserSender`),
  KEY `eventMessage` (`idEvent`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `message`
--

INSERT INTO `message` (`idMessage`, `idUserSender`, `idUserReceiver`, `idEvent`, `contentMessage`, `objectMessage`) VALUES
(1, 2, 1, 7, 'Salut', 'Demande information');

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

DROP TABLE IF EXISTS `notification`;
CREATE TABLE IF NOT EXISTS `notification` (
  `idNotification` int(11) NOT NULL AUTO_INCREMENT,
  `titleNotification` varchar(32) NOT NULL,
  `contentNotification` text NOT NULL,
  `idEvent` int(11) NOT NULL,
  PRIMARY KEY (`idNotification`),
  KEY `eventNotif` (`idEvent`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `notification`
--

INSERT INTO `notification` (`idNotification`, `titleNotification`, `contentNotification`, `idEvent`) VALUES
(1, 'Fin de la soirée P1', 'La soirée s\'est bien terminée. Faire la l\'inventaire des alcools qu\'il reste.', 7),
(2, 'Commande Promocash', 'Commande promocash récupérée.', 7);

-- --------------------------------------------------------

--
-- Structure de la table `resource`
--

DROP TABLE IF EXISTS `resource`;
CREATE TABLE IF NOT EXISTS `resource` (
  `idResource` int(11) NOT NULL AUTO_INCREMENT,
  `nameResource` varchar(32) NOT NULL,
  `descriptionResource` text NOT NULL,
  `volumeResource` int(11) NOT NULL,
  `quantityResource` int(11) NOT NULL,
  `locationResource` varchar(32) NOT NULL,
  `priceResource` int(11) NOT NULL,
  `idConservation` int(11) DEFAULT NULL,
  `idActivity` int(11) NOT NULL,
  PRIMARY KEY (`idResource`),
  KEY `conservartion` (`idConservation`),
  KEY `fk_idActivity` (`idActivity`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sponsor`
--

DROP TABLE IF EXISTS `sponsor`;
CREATE TABLE IF NOT EXISTS `sponsor` (
  `idSponsor` int(11) NOT NULL AUTO_INCREMENT,
  `nameSponsor` varchar(32) NOT NULL,
  `numSiretSponsor` int(11) NOT NULL,
  `lastNameSponsor` varchar(32) NOT NULL,
  `firstNameSponsor` varchar(32) NOT NULL,
  `emailSponsor` varchar(32) NOT NULL,
  `idEvent` int(11) NOT NULL,
  PRIMARY KEY (`idSponsor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `task`
--

DROP TABLE IF EXISTS `task`;
CREATE TABLE IF NOT EXISTS `task` (
  `idTask` int(11) NOT NULL AUTO_INCREMENT,
  `nameTask` varchar(32) NOT NULL,
  `startDateTask` date NOT NULL,
  `endDateTask` date NOT NULL,
  `descriptionTask` text NOT NULL,
  `statusTask` tinyint(1) NOT NULL,
  `idActivity` int(11) NOT NULL,
  PRIMARY KEY (`idTask`),
  KEY `fk_idTaskActivity` (`idActivity`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `task`
--

INSERT INTO `task` (`idTask`, `nameTask`, `startDateTask`, `endDateTask`, `descriptionTask`, `statusTask`, `idActivity`) VALUES
(1, 'Installer Sono', '2020-01-14', '2020-01-15', 'Installer sono', 0, 4),
(2, 'Installer bar', '2020-01-14', '2020-01-15', '3 bidon de vodka\r\n3 bidon de whisky\r\n5 Bidon de biere', 0, 4);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(32) NOT NULL AUTO_INCREMENT,
  `lastNameUser` varchar(32) NOT NULL,
  `firstNameUser` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `lastNameUser`, `firstNameUser`, `email`, `password`) VALUES
(1, 'Debeir', 'Luca', 'l.debeir@me.com', 'luca'),
(2, 'Gayet', 'Simon', 's@s.s', 's'),
(3, 'Debeir', 'Margaux', 'm@m.m', 'm'),
(4, 'Michel', 'RANA', 'michel@gmail.com', 'michel');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `activity`
--
ALTER TABLE `activity`
  ADD CONSTRAINT `fk_idEvent` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `chat`
--
ALTER TABLE `chat`
  ADD CONSTRAINT `chatEvent` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chatUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `collaborator`
--
ALTER TABLE `collaborator`
  ADD CONSTRAINT `event` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `concern`
--
ALTER TABLE `concern`
  ADD CONSTRAINT `activity` FOREIGN KEY (`idActivity`) REFERENCES `activity` (`idActivity`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `task` FOREIGN KEY (`idTask`) REFERENCES `task` (`idTask`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `consomable`
--
ALTER TABLE `consomable`
  ADD CONSTRAINT `consomableToEvent` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

--
-- Contraintes pour la table `contract`
--
ALTER TABLE `contract`
  ADD CONSTRAINT `eventSponsor` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sponsor` FOREIGN KEY (`idSponsor`) REFERENCES `sponsor` (`idSponsor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `eventCreator` FOREIGN KEY (`idCreator`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `isintervener`
--
ALTER TABLE `isintervener`
  ADD CONSTRAINT `intervenerEvent` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `intervenerUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `ismanager`
--
ALTER TABLE `ismanager`
  ADD CONSTRAINT `managerEvent` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `isvolunteer`
--
ALTER TABLE `isvolunteer`
  ADD CONSTRAINT `volunteerEvent` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `volunteerUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `eventMessage` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `receiverMessage` FOREIGN KEY (`idUserReceiver`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `senderMessage` FOREIGN KEY (`idUserSender`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `eventNotif` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `resource`
--
ALTER TABLE `resource`
  ADD CONSTRAINT `conservartion` FOREIGN KEY (`idConservation`) REFERENCES `conservation` (`idConservation`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idActivity` FOREIGN KEY (`idActivity`) REFERENCES `activity` (`idActivity`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `fk_idTaskActivity` FOREIGN KEY (`idActivity`) REFERENCES `activity` (`idActivity`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
