-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 07-Jun-2018 às 07:36
-- Versão do servidor: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `event_manager`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `campus`
--

CREATE TABLE `campus` (
  `idCampus` int(11) NOT NULL,
  `CampusName` varchar(100) NOT NULL,
  `CampusCity` varchar(100) NOT NULL,
  `CampusFantasyName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `campus`
--

INSERT INTO `campus` (`idCampus`, `CampusName`, `CampusCity`, `CampusFantasyName`) VALUES
(2, 'dfadf', 'dfadfsaddsfa', 'fsd'),
(3, 'dfadfsdfa', 'dfadfsaddsfa', 'fsdsdaf'),
(8, '1sdafsfsa', '444', '2222'),
(9, '555552222', '444', '333');

-- --------------------------------------------------------

--
-- Estrutura da tabela `equipaments`
--

CREATE TABLE `equipaments` (
  `idEquipaments` int(11) NOT NULL,
  `EquipamentsName` varchar(200) NOT NULL,
  `EquipamentsType` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `event`
--

CREATE TABLE `event` (
  `idEvent` int(11) NOT NULL,
  `EventName` varchar(100) NOT NULL,
  `EventDate` date NOT NULL,
  `EventClass` varchar(100) NOT NULL,
  `EventCampus` varchar(100) NOT NULL,
  `EventResponsible` varchar(100) NOT NULL,
  `EventTrainee` varchar(100) DEFAULT NULL,
  `EventHour` varchar(100) NOT NULL,
  `Class_idClass` int(11) NOT NULL,
  `Person_idPerson` int(11) NOT NULL,
  `Campus_idCampus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `eventequipament`
--

CREATE TABLE `eventequipament` (
  `idEventEquipament` int(11) NOT NULL,
  `idEvent` int(11) DEFAULT NULL,
  `idEquipament` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `person`
--

CREATE TABLE `person` (
  `idPerson` int(11) NOT NULL,
  `PersonName` varchar(100) DEFAULT NULL,
  `PersonRG` varchar(20) DEFAULT NULL,
  `PersonCPF` varchar(20) DEFAULT NULL,
  `PersonDateBorn` date DEFAULT NULL,
  `PersonPrivileges` tinyint(4) DEFAULT NULL,
  `PersonHourWork` varchar(100) DEFAULT NULL,
  `PersonEmail` varchar(45) NOT NULL,
  `PersonPassword` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `place`
--

CREATE TABLE `place` (
  `idPlace` int(11) NOT NULL,
  `PlaceName` varchar(100) NOT NULL,
  `PlaceCampus` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `type`
--

CREATE TABLE `type` (
  `idType` int(11) NOT NULL,
  `TypeName` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `campus`
--
ALTER TABLE `campus`
  ADD PRIMARY KEY (`idCampus`);

--
-- Indexes for table `equipaments`
--
ALTER TABLE `equipaments`
  ADD PRIMARY KEY (`idEquipaments`),
  ADD KEY `typefk_idx` (`EquipamentsType`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`idEvent`),
  ADD KEY `fk_Event_Class1_idx` (`Class_idClass`),
  ADD KEY `fk_Event_Person1_idx` (`Person_idPerson`),
  ADD KEY `fk_Event_Campus1_idx` (`Campus_idCampus`);

--
-- Indexes for table `eventequipament`
--
ALTER TABLE `eventequipament`
  ADD PRIMARY KEY (`idEventEquipament`),
  ADD KEY `index2` (`idEvent`,`idEquipament`),
  ADD KEY `equipFk_idx` (`idEquipament`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`idPerson`),
  ADD UNIQUE KEY `PersonName_UNIQUE` (`PersonName`),
  ADD UNIQUE KEY `PersonRG_UNIQUE` (`PersonRG`),
  ADD UNIQUE KEY `PersonCPF_UNIQUE` (`PersonCPF`),
  ADD UNIQUE KEY `PersonDateBorn_UNIQUE` (`PersonDateBorn`),
  ADD UNIQUE KEY `PersonPrivileges_UNIQUE` (`PersonPrivileges`),
  ADD UNIQUE KEY `PersonHourWork_UNIQUE` (`PersonHourWork`);

--
-- Indexes for table `place`
--
ALTER TABLE `place`
  ADD PRIMARY KEY (`idPlace`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`idType`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `campus`
--
ALTER TABLE `campus`
  MODIFY `idCampus` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `equipaments`
--
ALTER TABLE `equipaments`
  MODIFY `idEquipaments` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `idEvent` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `idPerson` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `place`
--
ALTER TABLE `place`
  MODIFY `idPlace` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `equipaments`
--
ALTER TABLE `equipaments`
  ADD CONSTRAINT `typefk` FOREIGN KEY (`EquipamentsType`) REFERENCES `type` (`idType`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `fk_Event_Campus1` FOREIGN KEY (`Campus_idCampus`) REFERENCES `campus` (`idCampus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Event_Class1` FOREIGN KEY (`Class_idClass`) REFERENCES `place` (`idPlace`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Event_Person1` FOREIGN KEY (`Person_idPerson`) REFERENCES `person` (`idPerson`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `eventequipament`
--
ALTER TABLE `eventequipament`
  ADD CONSTRAINT `equipFk` FOREIGN KEY (`idEquipament`) REFERENCES `equipaments` (`idEquipaments`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `eventoFk` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
