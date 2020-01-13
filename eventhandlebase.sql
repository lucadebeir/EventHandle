-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jan 13, 2020 at 02:40 PM
-- Server version: 5.7.26
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `eventhandle`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity`
--

CREATE TABLE `activity` (
  `idActivity` int(11) NOT NULL,
  `nameActivity` varchar(32) NOT NULL,
  `statusActivity` tinyint(1) NOT NULL DEFAULT '0',
  `descriptionActivity` text NOT NULL,
  `idEvent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `activity`
--

INSERT INTO `activity` (`idActivity`, `nameActivity`, `statusActivity`, `descriptionActivity`, `idEvent`) VALUES
(1, 'Cuisine', 0, 'Toutes les activités liées à la cuisine.', 0),
(2, 'Salle', 0, 'Toutes les activités liées à l\'installation de la salle.', 0);

-- --------------------------------------------------------

--
-- Table structure for table `chat`
--

CREATE TABLE `chat` (
  `idChat` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  `contentMessage` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chat`
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
(13, 1, 7, 'hey');

-- --------------------------------------------------------

--
-- Table structure for table `collaborator`
--

CREATE TABLE `collaborator` (
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  `typeCollaborator` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `concern`
--

CREATE TABLE `concern` (
  `idActivity` int(11) NOT NULL,
  `idTask` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `conservation`
--

CREATE TABLE `conservation` (
  `idConservation` int(11) NOT NULL,
  `nameConservation` varchar(32) NOT NULL,
  `descriptionConservation` text NOT NULL,
  `storageTemperature` int(11) NOT NULL,
  `dateConservation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `conservation`
--

INSERT INTO `conservation` (`idConservation`, `nameConservation`, `descriptionConservation`, `storageTemperature`, `dateConservation`) VALUES
(3, 'Sauce tomate', 'Bolo pour pâte', 27, '2020-02-28'),
(4, 'Jus d\'orange', 'Sans pulpe', 25, '2020-01-24');

-- --------------------------------------------------------

--
-- Table structure for table `contract`
--

CREATE TABLE `contract` (
  `numContract` int(11) NOT NULL,
  `libelleContract` text NOT NULL,
  `clauseContract` text NOT NULL,
  `idEvent` int(11) NOT NULL,
  `idSponsor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `idEvent` int(11) NOT NULL,
  `nameEvent` varchar(32) NOT NULL,
  `dateStartEvent` date NOT NULL,
  `locationEvent` varchar(32) NOT NULL,
  `dateEndEvent` date NOT NULL,
  `descriptionEvent` text NOT NULL,
  `idCreator` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`idEvent`, `nameEvent`, `dateStartEvent`, `locationEvent`, `dateEndEvent`, `descriptionEvent`, `idCreator`) VALUES
(3, 'Gala', '2020-03-07', 'La Grande Motte', '2019-12-08', 'Gala annuel de Polytech Montpellier', 1),
(7, 'Soirée P1', '2019-10-17', 'Marsillargues', '2019-10-18', 'Première soirée privée de Polytech', 1),
(9, 'Semaine blanche', '2020-01-25', 'Domaine Les Sybelles', '2020-02-01', 'Trop bien', 1),
(11, 'Soirée RDD', '2019-12-07', 'Montpellier', '2019-12-08', 'Soirée pour les diplômés', 1);

--
-- Triggers `event`
--
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
-- Table structure for table `isIntervener`
--

CREATE TABLE `isIntervener` (
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `isIntervener`
--

INSERT INTO `isIntervener` (`idUser`, `idEvent`) VALUES
(2, 7),
(3, 11);

-- --------------------------------------------------------

--
-- Table structure for table `isManager`
--

CREATE TABLE `isManager` (
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `isManager`
--

INSERT INTO `isManager` (`idUser`, `idEvent`) VALUES
(1, 7),
(1, 3),
(1, 9),
(1, 11),
(2, 7);

-- --------------------------------------------------------

--
-- Table structure for table `isVolunteer`
--

CREATE TABLE `isVolunteer` (
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `isVolunteer`
--

INSERT INTO `isVolunteer` (`idUser`, `idEvent`) VALUES
(3, 7),
(2, 11);

-- --------------------------------------------------------

--
-- Table structure for table `material`
--

CREATE TABLE `material` (
  `idMaterial` int(11) NOT NULL,
  `nameMaterial` varchar(32) NOT NULL,
  `locationMaterial` varchar(32) NOT NULL,
  `descriptionMaterial` text NOT NULL,
  `stateMaterial` varchar(32) NOT NULL,
  `volumeMaterial` float DEFAULT NULL,
  `quantityMaterial` int(11) DEFAULT NULL,
  `priceMaterial` float DEFAULT NULL,
  `idEvent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `material`
--

INSERT INTO `material` (`idMaterial`, `nameMaterial`, `locationMaterial`, `descriptionMaterial`, `stateMaterial`, `volumeMaterial`, `quantityMaterial`, `priceMaterial`, `idEvent`) VALUES
(3, 'ed', 'de', 'dede', 'Stock', 14, 41, 14, 7),
(7, 'try', 'lol', 'rzdnzidnece', 'Order', 98, 60, 42, 7);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `idMessage` int(11) NOT NULL,
  `idUserSender` int(11) NOT NULL,
  `idUserReceiver` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  `contentMessage` text NOT NULL,
  `objectMessage` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`idMessage`, `idUserSender`, `idUserReceiver`, `idEvent`, `contentMessage`, `objectMessage`) VALUES
(1, 2, 1, 7, 'Salut', 'Demande information'),
(4, 1, 3, 7, ' lol ', ' lol '),
(6, 1, 2, 7, 'aaaaaaaaaa', 'aaaa'),
(7, 1, 2, 7, 'C\'est bien ça !', 'Re [Demande information]');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `idNotification` int(11) NOT NULL,
  `titleNotification` varchar(32) NOT NULL,
  `contentNotification` text NOT NULL,
  `idEvent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`idNotification`, `titleNotification`, `contentNotification`, `idEvent`) VALUES
(1, 'Fin de la soirée P1', 'La soirée s\'est bien terminée. Faire la l\'inventaire des alcools qu\'il reste.', 7),
(2, 'Commande Promocash', 'Commande promocash récupérée.', 7);

-- --------------------------------------------------------

--
-- Table structure for table `resource`
--

CREATE TABLE `resource` (
  `idResource` int(11) NOT NULL,
  `nameResource` varchar(32) NOT NULL,
  `descriptionResource` text NOT NULL,
  `volumeResource` int(11) NOT NULL,
  `quantityResource` int(11) NOT NULL,
  `locationResource` varchar(32) NOT NULL,
  `priceResource` int(11) NOT NULL,
  `idConservation` int(11) DEFAULT NULL,
  `idActivity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `sponsor`
--

CREATE TABLE `sponsor` (
  `idSponsor` int(11) NOT NULL,
  `nameSponsor` varchar(32) NOT NULL,
  `numSiretSponsor` int(11) NOT NULL,
  `lastNameSponsor` varchar(32) NOT NULL,
  `firstNameSponsor` varchar(32) NOT NULL,
  `emailSponsor` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `idTask` int(11) NOT NULL,
  `nameTask` varchar(32) NOT NULL,
  `startDateTask` date NOT NULL,
  `endDateTask` date NOT NULL,
  `descriptionTask` text NOT NULL,
  `statusTask` tinyint(1) NOT NULL,
  `idActivity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `idUser` int(32) NOT NULL,
  `lastNameUser` varchar(32) NOT NULL,
  `firstNameUser` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`idUser`, `lastNameUser`, `firstNameUser`, `email`, `password`) VALUES
(1, 'Debeir', 'Luca', 'l.debeir@me.com', 'luca'),
(2, 'Gayet', 'Simon', 's@s.s', 's'),
(3, 'Debeir', 'Margaux', 'm@m.m', 'm'),
(4, 'm', 'm', 'm@m.m', 'm'),
(5, 'p', 'p', 'p', 'p');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activity`
--
ALTER TABLE `activity`
  ADD PRIMARY KEY (`idActivity`),
  ADD KEY `idEvent` (`idEvent`);

--
-- Indexes for table `chat`
--
ALTER TABLE `chat`
  ADD PRIMARY KEY (`idChat`),
  ADD KEY `chatUser` (`idUser`),
  ADD KEY `chatEvent` (`idEvent`);

--
-- Indexes for table `collaborator`
--
ALTER TABLE `collaborator`
  ADD KEY `event` (`idEvent`),
  ADD KEY `user` (`idUser`);

--
-- Indexes for table `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`idMaterial`),
  ADD KEY `materialToEvent` (`idEvent`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `activity`
--
ALTER TABLE `activity`
  MODIFY `idActivity` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `chat`
--
ALTER TABLE `chat`
  MODIFY `idChat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `material`
--
ALTER TABLE `material`
  MODIFY `idMaterial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
