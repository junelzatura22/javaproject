-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.24-MariaDB


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema minienrollment
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ minienrollment;
USE minienrollment;

--
-- Table structure for table `minienrollment`.`course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `c_name` varchar(45) NOT NULL DEFAULT '',
  `c_description` text NOT NULL,
  `c_department` varchar(45) NOT NULL DEFAULT '',
  `c_addedby` int(10) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`courseid`),
  KEY `FK_course_1` (`c_addedby`),
  CONSTRAINT `FK_course_1` FOREIGN KEY (`c_addedby`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `minienrollment`.`course`
--

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`courseid`,`c_name`,`c_description`,`c_department`,`c_addedby`) VALUES 
 (3,'BSIT','BACHELOR OF SCIENCE IN INFORMATION TECHNOLOGY','ICT DEPT',1),
 (4,'BITM','BACHELOR OF INDUSTRIAL TECHNOLOGY','ENGINEERING DEPT',1),
 (5,'CE','CIVIL ENGINEERING','ENGINEERING DEPT',1),
 (6,'NURSING','NURSING TO NURSE HEHEHE','NURSING DEPT',1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


--
-- Table structure for table `minienrollment`.`enrollment`
--

DROP TABLE IF EXISTS `enrollment`;
CREATE TABLE `enrollment` (
  `e_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `e_lecture` int(10) unsigned NOT NULL DEFAULT 0,
  `e_course` int(10) unsigned NOT NULL DEFAULT 0,
  `e_student` varchar(10) NOT NULL DEFAULT '',
  `e_dateenroll` varchar(45) NOT NULL DEFAULT '',
  `e_addedby` int(10) unsigned NOT NULL DEFAULT 0,
  `e_yearLevel` varchar(45) NOT NULL DEFAULT '',
  `e_semester` varchar(45) NOT NULL DEFAULT '',
  `e_schoolyear` varchar(45) NOT NULL DEFAULT '',
  `e_room` int(10) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`e_id`),
  KEY `FK_enrollment_1` (`e_lecture`),
  KEY `FK_enrollment_2` (`e_course`),
  KEY `FK_enrollment_3` (`e_student`),
  KEY `FK_enrollment_4` (`e_addedby`),
  KEY `FK_enrollment_5` (`e_room`),
  CONSTRAINT `FK_enrollment_1` FOREIGN KEY (`e_lecture`) REFERENCES `lecture` (`lectureid`),
  CONSTRAINT `FK_enrollment_2` FOREIGN KEY (`e_course`) REFERENCES `course` (`courseid`),
  CONSTRAINT `FK_enrollment_3` FOREIGN KEY (`e_student`) REFERENCES `student` (`studentid`),
  CONSTRAINT `FK_enrollment_4` FOREIGN KEY (`e_addedby`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_enrollment_5` FOREIGN KEY (`e_room`) REFERENCES `room` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `minienrollment`.`enrollment`
--

/*!40000 ALTER TABLE `enrollment` DISABLE KEYS */;
INSERT INTO `enrollment` (`e_id`,`e_lecture`,`e_course`,`e_student`,`e_dateenroll`,`e_addedby`,`e_yearLevel`,`e_semester`,`e_schoolyear`,`e_room`) VALUES 
 (1,4,3,'2021-2','2021-07-15 13:51:01',1,'Freshmen','1st Semester','2021-2022',2),
 (2,1,4,'2021-2','2021-07-15 13:56:44',1,'Freshmen','1st Semester','2021-2022',8),
 (3,1,3,'2021-1','2021-07-15 15:31:33',1,'Freshmen','1st Semester','2021-2022',2);
/*!40000 ALTER TABLE `enrollment` ENABLE KEYS */;


--
-- Table structure for table `minienrollment`.`lecture`
--

DROP TABLE IF EXISTS `lecture`;
CREATE TABLE `lecture` (
  `lectureid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `lecturer` varchar(10) NOT NULL DEFAULT '',
  `subject` varchar(10) NOT NULL DEFAULT '',
  `time` varchar(45) NOT NULL DEFAULT '',
  `date` varchar(45) NOT NULL DEFAULT '',
  `addedby` int(10) unsigned NOT NULL DEFAULT 0,
  `dateadded` varchar(45) NOT NULL DEFAULT '',
  `timeend` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`lectureid`),
  KEY `FK_lecture_1` (`lecturer`),
  KEY `FK_lecture_2` (`subject`),
  KEY `FK_lecture_3` (`addedby`),
  CONSTRAINT `FK_lecture_1` FOREIGN KEY (`lecturer`) REFERENCES `lecturer` (`lec_id`),
  CONSTRAINT `FK_lecture_2` FOREIGN KEY (`subject`) REFERENCES `subjects` (`sub_code`),
  CONSTRAINT `FK_lecture_3` FOREIGN KEY (`addedby`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `minienrollment`.`lecture`
--

/*!40000 ALTER TABLE `lecture` DISABLE KEYS */;
INSERT INTO `lecture` (`lectureid`,`lecturer`,`subject`,`time`,`date`,`addedby`,`dateadded`,`timeend`) VALUES 
 (1,'LECT-102','MATH121','4:00 PM','MWF - MON, WED, FRI',1,'2021-06-25 08:02:07','5:00 PM'),
 (3,'LECT-103','IT102','1:00 PM','TTH - TUE, THU',1,'2021-06-25 08:05:21','3:00 PM'),
 (4,'LECT-102','MATH100','1:00 PM','MWF - MON, WED, FRI',1,'2021-06-25 08:05:55','3:00 PM');
/*!40000 ALTER TABLE `lecture` ENABLE KEYS */;


--
-- Table structure for table `minienrollment`.`lecturer`
--

DROP TABLE IF EXISTS `lecturer`;
CREATE TABLE `lecturer` (
  `lec_id` varchar(10) NOT NULL DEFAULT '',
  `lec_fname` varchar(45) NOT NULL DEFAULT '',
  `lec_mname` varchar(45) NOT NULL DEFAULT '',
  `lec_lname` varchar(45) NOT NULL DEFAULT '',
  `lec_address` varchar(45) NOT NULL DEFAULT '',
  `lec_email` varchar(45) NOT NULL DEFAULT '',
  `lec_addedby` int(10) unsigned NOT NULL DEFAULT 0,
  `lec_dateAdded` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`lec_id`),
  KEY `FK_lecturer_1` (`lec_addedby`),
  CONSTRAINT `FK_lecturer_1` FOREIGN KEY (`lec_addedby`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `minienrollment`.`lecturer`
--

/*!40000 ALTER TABLE `lecturer` DISABLE KEYS */;
INSERT INTO `lecturer` (`lec_id`,`lec_fname`,`lec_mname`,`lec_lname`,`lec_address`,`lec_email`,`lec_addedby`,`lec_dateAdded`) VALUES 
 ('LECT-101','ANDREW','ANDRESS','SAMBUWAS','CALIFORNIA','sambuwa@gmail.com',1,'2021-06-12 12:37:07'),
 ('LECT-102','MARK','ANDRESS','SAMBUWA','DAVAO CITY','sambuwa@gmail.com',1,'2021-06-12 12:31:23'),
 ('LECT-103','JUANA','SASAM','LOPEZ','DAVAO CITY','sambuwa@gmail.com',1,'2021-06-12 12:37:23'),
 ('LECT-104','JAMES','ANSA','WATSON','CALIFORNIA','sam@gmail.com',1,'2021-06-25 08:07:55'),
 ('LECT-105','SASASA','BRUAASSAS','DELA','CALIFORNIA','aa@gmail.com',1,'2021-06-25 08:11:30');
/*!40000 ALTER TABLE `lecturer` ENABLE KEYS */;


--
-- Table structure for table `minienrollment`.`room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `rid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `rname` varchar(45) NOT NULL DEFAULT '',
  `rinstalledlocation` varchar(45) NOT NULL DEFAULT '',
  `remarks` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `minienrollment`.`room`
--

/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` (`rid`,`rname`,`rinstalledlocation`,`remarks`) VALUES 
 (1,'RITB 101','IT BUILDING','AVAILABLE'),
 (2,'RITB 102','IT BUILDING','AVAILABLE'),
 (3,'RITB 103','IT BUILDING','AVAILABLE'),
 (4,'RITB 104','IT BUILDING','AVAILABLE'),
 (5,'RITB 105','IT BUILDING','AVAILABLE'),
 (6,'ENGB 101','ENGR. BUILDING','AVAILABLE'),
 (7,'ENGB 102','ENGR. BUILDING','AVAILABLE'),
 (8,'ENGB 103','ENGR. BUILDING','AVAILABLE'),
 (9,'ENGB 104','ENGR. BUILDING','AVAILABLE'),
 (10,'ENGB 105','ENGR. BUILDING','AVAILABLE');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;


--
-- Table structure for table `minienrollment`.`student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentid` varchar(10) NOT NULL DEFAULT '',
  `stud_fname` varchar(45) NOT NULL DEFAULT '',
  `stud_mname` varchar(45) DEFAULT NULL,
  `stud_lname` varchar(45) NOT NULL DEFAULT '',
  `stud_bod` varchar(45) NOT NULL DEFAULT '',
  `stud_address` text NOT NULL,
  `stud_addedby` int(10) unsigned NOT NULL DEFAULT 0,
  `stud_status` varchar(45) NOT NULL DEFAULT '',
  `stud_dateAdded` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`studentid`),
  KEY `FK_student_1` (`stud_addedby`),
  CONSTRAINT `FK_student_1` FOREIGN KEY (`stud_addedby`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `minienrollment`.`student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`studentid`,`stud_fname`,`stud_mname`,`stud_lname`,`stud_bod`,`stud_address`,`stud_addedby`,`stud_status`,`stud_dateAdded`) VALUES 
 ('2021-1','SAS','SASAS','SA','May 03, 1990','POBLACION ',1,'GRADUATED','2021-07-02 11:48:19'),
 ('2021-2','JAMANA','SDADS','SA','Jul 15, 1990','PANABO',1,'ACTIVE','2021-07-02 11:57:05'),
 ('2021-3','JUAN','DELA','CRUZ','May 05, 1993','SAMPLES',1,'ACTIVE','2021-07-05 20:23:59'),
 ('2021-4','JACK','WILE','ALDEN','Jul 19, 1990','SAMPLE',1,'ACTIVE','2021-07-05 20:24:44'),
 ('2021-5','JAMES','AMB','WATSON','Jul 12, 1990','WEWEW',1,'ACTIVE','2021-07-05 20:36:13');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


--
-- Table structure for table `minienrollment`.`subjects`
--

DROP TABLE IF EXISTS `subjects`;
CREATE TABLE `subjects` (
  `sub_code` varchar(10) NOT NULL DEFAULT '',
  `sub_description` varchar(45) NOT NULL DEFAULT '',
  `sub_unit` varchar(45) NOT NULL DEFAULT '',
  `sub_addedby` int(10) unsigned NOT NULL DEFAULT 0,
  `sub_dateAdded` varchar(45) NOT NULL DEFAULT '',
  `sub_department` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`sub_code`),
  KEY `FK_subject_1` (`sub_addedby`),
  CONSTRAINT `FK_subject_1` FOREIGN KEY (`sub_addedby`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `minienrollment`.`subjects`
--

/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` (`sub_code`,`sub_description`,`sub_unit`,`sub_addedby`,`sub_dateAdded`,`sub_department`) VALUES 
 ('ENG101','ENGINEERING 1','3',1,'2021-06-25 08:06:30','ENGINEERING DEPT'),
 ('IT101','COMPUTER AND BASIC FUNDAMENTALS','3',1,'2021-06-14 14:58:59','ICT DEPT'),
 ('IT102','PROGRAMMING 1','3',1,'2021-06-14 15:00:38','ICT DEPT'),
 ('MATH100','TRIGONOMETRY AND CALCULUS','3',1,'2021-06-14 15:00:59','MATHEMATICS DEPT'),
 ('MATH121','ADVANCED CALCULUS','3',1,'2021-07-15 15:52:10','MATHEMATICS DEPT');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;


--
-- Table structure for table `minienrollment`.`users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL DEFAULT '',
  `Position` varchar(45) NOT NULL DEFAULT '',
  `username` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(45) NOT NULL DEFAULT '',
  `image` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `minienrollment`.`users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`,`Name`,`Position`,`username`,`password`,`image`) VALUES 
 (1,'JAMES A. WATSON','Admin Staff','admin','admin','/src/Asset/ava1_120x133.png');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
