# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.19)
# Database: recoland
# Generation Time: 2015-04-26 04:29:02 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table browse_history
# ------------------------------------------------------------

DROP TABLE IF EXISTS `browse_history`;

CREATE TABLE `browse_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL DEFAULT '',
  `search_latitude` double DEFAULT NULL,
  `search_longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `search_location_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `browse_history` WRITE;
/*!40000 ALTER TABLE `browse_history` DISABLE KEYS */;

INSERT INTO `browse_history` (`id`, `username`, `search_latitude`, `search_longitude`, `latitude`, `longitude`, `search_location_name`)
VALUES
	(1,'pandian',12.924829,77.6096318,12.9239297,77.6103184,'HDFC bank'),
	(2,'pandian',12.924829,77.6096318,12.9239297,77.6103184,'Ammi\'s biriyani'),
	(3,'pandian',12.9301097,77.6089988,12.9239297,77.6103184,'Oracle'),
	(4,'pandian',12.9298588,77.6078079,12.9239297,77.6103184,'Forum mall'),
	(5,'vishnu',12.9524459,77.7032662,12.9524459,77.7032662,'Syndicate bank'),
	(6,'vishnu',12.9483263,77.6980949,12.9524459,77.7032662,'Water treatment plant'),
	(7,'vishnu',12.9424081,77.6971507,12.9524459,77.7032662,'Prestige tech park');

/*!40000 ALTER TABLE `browse_history` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table food_history
# ------------------------------------------------------------

DROP TABLE IF EXISTS `food_history`;

CREATE TABLE `food_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL DEFAULT '',
  `ordered_at` datetime DEFAULT NULL,
  `cuisine_type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `food_history` WRITE;
/*!40000 ALTER TABLE `food_history` DISABLE KEYS */;

INSERT INTO `food_history` (`id`, `username`, `ordered_at`, `cuisine_type`)
VALUES
	(1,'pandian',NULL,'south_indian'),
	(4,'pandian',NULL,'south_indian'),
	(5,'pandian',NULL,'south_indian'),
	(6,'pandian',NULL,'chinese'),
	(7,'pandian',NULL,'italian'),
	(8,'vishnu',NULL,'thai'),
	(9,'vishnu',NULL,'thai'),
	(10,'vishnu',NULL,'north_indian'),
	(11,'vishnu',NULL,'thai');

/*!40000 ALTER TABLE `food_history` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table geo_history
# ------------------------------------------------------------

DROP TABLE IF EXISTS `geo_history`;

CREATE TABLE `geo_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL DEFAULT '',
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table hotel_details
# ------------------------------------------------------------

DROP TABLE IF EXISTS `hotel_details`;

CREATE TABLE `hotel_details` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `cuisine_type` varchar(100) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `hotel_details` WRITE;
/*!40000 ALTER TABLE `hotel_details` DISABLE KEYS */;

INSERT INTO `hotel_details` (`id`, `latitude`, `longitude`, `cuisine_type`, `rating`, `name`)
VALUES
	(1,12.9259531,77.6099174,'south_indian',4.5,'Ammi\'s biriyani'),
	(2,12.9320207,77.6087359,'american',4.7,'KFC'),
	(3,12.9320207,77.6087359,'italian',3.9,'Little Italy'),
	(4,12.933882,77.6104632,'north_indian',4.8,'Truffles'),
	(5,12.9425963,77.6963997,'thai',4.9,'Absolute Barbeque'),
	(6,12.9544116,77.7034647,'north_indian',4.1,'Shankuma restaraunt');

/*!40000 ALTER TABLE `hotel_details` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table land_details
# ------------------------------------------------------------

DROP TABLE IF EXISTS `land_details`;

CREATE TABLE `land_details` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `area_name` varchar(100) DEFAULT NULL,
  `area` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `land_details` WRITE;
/*!40000 ALTER TABLE `land_details` DISABLE KEYS */;

INSERT INTO `land_details` (`id`, `latitude`, `longitude`, `area_name`, `area`)
VALUES
	(1,12.9285804,77.6094547,'Tavarakere',200),
	(2,12.9252342,77.6097444,'Madiwala',300),
	(3,12.9239166,77.6066867,'Bannerghata Main road',150),
	(4,12.953251,77.7037865,'Munnekolal',175),
	(5,12.9610196,77.7031535,'Marathalli',350),
	(6,12.9351304,77.6953537,'Outer ring road',250);

/*!40000 ALTER TABLE `land_details` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table movie_history
# ------------------------------------------------------------

DROP TABLE IF EXISTS `movie_history`;

CREATE TABLE `movie_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL DEFAULT '',
  `booked_at` datetime DEFAULT NULL,
  `movie_language` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `movie_history` WRITE;
/*!40000 ALTER TABLE `movie_history` DISABLE KEYS */;

INSERT INTO `movie_history` (`id`, `username`, `booked_at`, `movie_language`)
VALUES
	(1,'pandian',NULL,'tamil'),
	(2,'pandian',NULL,'tamil'),
	(3,'pandian',NULL,'tamil'),
	(4,'pandian',NULL,'english'),
	(5,'vishnu',NULL,'tamil'),
	(6,'vishnu',NULL,'hindi');

/*!40000 ALTER TABLE `movie_history` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table theater_details
# ------------------------------------------------------------

DROP TABLE IF EXISTS `theater_details`;

CREATE TABLE `theater_details` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `movie_language` varchar(100) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `theater_details` WRITE;
/*!40000 ALTER TABLE `theater_details` DISABLE KEYS */;

INSERT INTO `theater_details` (`id`, `latitude`, `longitude`, `movie_language`, `rating`, `name`)
VALUES
	(1,12.9239166,77.6066867,'tamil',4.5,'Lakshmi theater'),
	(2,12.9239166,77.6066867,'kannada',4.1,'Balaji theater'),
	(3,12.9326481,77.6116863,'english',4.7,'PVR'),
	(4,12.9326481,77.6116863,'tamil',4.7,'PVR'),
	(5,12.9544116,77.7034647,'tamil',4.2,'Srivinayaka theater'),
	(6,12.9533451,77.7013296,'hindi',4.6,'Innovative Multiplex');

/*!40000 ALTER TABLE `theater_details` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_aux_details
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_aux_details`;

CREATE TABLE `user_aux_details` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL DEFAULT '',
  `current_lat` double NOT NULL,
  `current_long` double NOT NULL,
  `marital_status` varchar(100) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table user_details
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_details`;

CREATE TABLE `user_details` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL DEFAULT '',
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `password` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;

INSERT INTO `user_details` (`id`, `username`, `name`, `email`, `phone`, `password`)
VALUES
	(1,'pandian','Pandian','pandian4mail@gmail.com','9486088421','alaska'),
	(2,'vishnu','Vishnu','vishnu.jay@gmail.com','9887675645','abcdef');

/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_rating
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_rating`;

CREATE TABLE `user_rating` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `rating` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `user_rating` WRITE;
/*!40000 ALTER TABLE `user_rating` DISABLE KEYS */;

INSERT INTO `user_rating` (`id`, `username`, `latitude`, `longitude`, `rating`)
VALUES
	(1,'pandian',12.9285804,77.6094547,7.5),
	(2,'vishnu',12.9285804,77.6094547,8.2),
	(3,'vishnu',12.9252342,77.6097444,8.5),
	(4,'pandian',12.953251,77.7037865,7),
	(5,'pandian',12.9351304,77.6953537,8),
	(6,'vishnu',12.9351304,77.6953537,6.5);

/*!40000 ALTER TABLE `user_rating` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
