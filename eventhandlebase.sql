-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Dec 28, 2019 at 04:42 PM
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
  `statusActivity` tinyint(1) NOT NULL,
  `descriptionActivity` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `chat`
--

CREATE TABLE `chat` (
  `idChat` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  `titleChat` varchar(32) NOT NULL,
  `contentMessage` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

-- --------------------------------------------------------

--
-- Table structure for table `isVolunteer`
--

CREATE TABLE `isVolunteer` (
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
(1, 'Debeir', 'Luca', 'l.debeir@me.com', 'luca');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activity`
--
ALTER TABLE `activity`
  ADD PRIMARY KEY (`idActivity`);

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
  ADD KEY `eventCreator` (`idCreator`);

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
  ADD KEY `managerEvent` (`idEvent`),
  ADD KEY `managerUser` (`idUser`);

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
  MODIFY `idActivity` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `chat`
--
ALTER TABLE `chat`
  MODIFY `idChat` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `conservation`
--
ALTER TABLE `conservation`
  MODIFY `idConservation` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `contract`
--
ALTER TABLE `contract`
  MODIFY `numContract` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `idEvent` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `idMessage` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `idNotification` int(11) NOT NULL AUTO_INCREMENT;

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
  MODIFY `idUser` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
  ADD CONSTRAINT `managerEvent` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `managerUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

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
