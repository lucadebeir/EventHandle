-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jan 10, 2020 at 11:36 AM
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
(13, 1, 7, 'lll'),
(14, 2, 7, 'a');

-- --------------------------------------------------------

--
-- Table structure for table `collaborator`
--

CREATE TABLE `collaborator` (
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  `typeCollaboraor` varchar(32) NOT NULL
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
(10, 'Soirée P3', '2020-03-27', 'Montpellier', '2020-03-28', 'dernière soirée P', 1),
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
(1, 10),
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
(2, 7);

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
(1, 2, 1, 7, 'Salut', 'Demande information');

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
  `idConservation` int(11) DEFAULT NULL
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
  `statusTask` tinyint(1) NOT NULL
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
(3, 'Debeir', 'Margaux', 'm@m.m', 'm');

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
-- Indexes for table `concern`
--
ALTER TABLE `concern`
  ADD KEY `activity` (`idActivity`),
  ADD KEY `task` (`idTask`);

--
-- Indexes for table `conservation`
--
ALTER TABLE `conservation`
  ADD PRIMARY KEY (`idConservation`);

--
-- Indexes for table `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`numContract`),
  ADD KEY `sponsor` (`idSponsor`),
  ADD KEY `eventSponsor` (`idEvent`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`idEvent`),
  ADD KEY `managerUser` (`idCreator`);

--
-- Indexes for table `isIntervener`
--
ALTER TABLE `isIntervener`
  ADD KEY `intervenerEvent` (`idEvent`),
  ADD KEY `intervenerUser` (`idUser`);

--
-- Indexes for table `isManager`
--
ALTER TABLE `isManager`
  ADD KEY `managerUser` (`idUser`),
  ADD KEY `managerEvent` (`idEvent`);

--
-- Indexes for table `isVolunteer`
--
ALTER TABLE `isVolunteer`
  ADD KEY `volunteerUser` (`idUser`),
  ADD KEY `volunteerEvent` (`idEvent`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`idMessage`),
  ADD KEY `receiverMessage` (`idUserReceiver`),
  ADD KEY `senderMessage` (`idUserSender`),
  ADD KEY `eventMessage` (`idEvent`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`idNotification`),
  ADD KEY `eventNotif` (`idEvent`);

--
-- Indexes for table `resource`
--
ALTER TABLE `resource`
  ADD PRIMARY KEY (`idResource`),
  ADD KEY `conservartion` (`idConservation`);

--
-- Indexes for table `sponsor`
--
ALTER TABLE `sponsor`
  ADD PRIMARY KEY (`idSponsor`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`idTask`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `activity`
--
ALTER TABLE `activity`
  MODIFY `idActivity` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `chat`
--
ALTER TABLE `chat`
  MODIFY `idChat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `conservation`
--
ALTER TABLE `conservation`
  MODIFY `idConservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `contract`
--
ALTER TABLE `contract`
  MODIFY `numContract` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `idEvent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `idMessage` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `idNotification` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `resource`
--
ALTER TABLE `resource`
  MODIFY `idResource` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sponsor`
--
ALTER TABLE `sponsor`
  MODIFY `idSponsor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `idTask` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chat`
--
ALTER TABLE `chat`
  ADD CONSTRAINT `chatEvent` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chatUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `collaborator`
--
ALTER TABLE `collaborator`
  ADD CONSTRAINT `event` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `concern`
--
ALTER TABLE `concern`
  ADD CONSTRAINT `activity` FOREIGN KEY (`idActivity`) REFERENCES `activity` (`idActivity`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `task` FOREIGN KEY (`idTask`) REFERENCES `task` (`idTask`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `contract`
--
ALTER TABLE `contract`
  ADD CONSTRAINT `eventSponsor` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sponsor` FOREIGN KEY (`idSponsor`) REFERENCES `sponsor` (`idSponsor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `eventCreator` FOREIGN KEY (`idCreator`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `isIntervener`
--
ALTER TABLE `isIntervener`
  ADD CONSTRAINT `intervenerEvent` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `intervenerUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `isManager`
--
ALTER TABLE `isManager`
  ADD CONSTRAINT `managerEvent` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `isVolunteer`
--
ALTER TABLE `isVolunteer`
  ADD CONSTRAINT `volunteerEvent` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `volunteerUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `eventMessage` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `receiverMessage` FOREIGN KEY (`idUserReceiver`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `senderMessage` FOREIGN KEY (`idUserSender`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `eventNotif` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `resource`
--
ALTER TABLE `resource`
  ADD CONSTRAINT `conservartion` FOREIGN KEY (`idConservation`) REFERENCES `conservation` (`idConservation`) ON DELETE CASCADE ON UPDATE CASCADE;
