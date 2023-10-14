/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.22 : Database - bank-mgt-spb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bank-mgt-spb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `bank-mgt-spb`;

/*Table structure for table `b_account_balance` */

DROP TABLE IF EXISTS `b_account_balance`;

CREATE TABLE `b_account_balance` (
  `id` bigint NOT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `created_date_time` datetime(6) DEFAULT NULL,
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date_time` datetime(6) DEFAULT NULL,
  `account_no` bigint DEFAULT NULL,
  `amount` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `b_account_balance` */

insert  into `b_account_balance`(`id`,`created_by`,`created_date_time`,`modified_by`,`modified_date_time`,`account_no`,`amount`) values 
(1,NULL,NULL,NULL,NULL,1000100102,18000),
(2,NULL,NULL,NULL,NULL,1000100103,2000);

/*Table structure for table `b_bank` */

DROP TABLE IF EXISTS `b_bank`;

CREATE TABLE `b_bank` (
  `id` bigint NOT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `created_date_time` datetime(6) DEFAULT NULL,
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date_time` datetime(6) DEFAULT NULL,
  `ifse_code` varchar(225) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  `short_code` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `b_bank` */

insert  into `b_bank`(`id`,`created_by`,`created_date_time`,`modified_by`,`modified_date_time`,`ifse_code`,`description`,`name`,`short_code`) values 
(1,NULL,NULL,NULL,NULL,'BKID0010','Bank Of india','Bank of India','BOI');

/*Table structure for table `b_fund_transfer` */

DROP TABLE IF EXISTS `b_fund_transfer`;

CREATE TABLE `b_fund_transfer` (
  `id` bigint NOT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `created_date_time` datetime(6) DEFAULT NULL,
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date_time` datetime(6) DEFAULT NULL,
  `bank_name` varchar(225) DEFAULT NULL,
  `ben_acc_holder_name` varchar(225) DEFAULT NULL,
  `ben_account_no` bigint DEFAULT NULL,
  `by_acc_holder_name` varchar(225) DEFAULT NULL,
  `by_account_no` bigint DEFAULT NULL,
  `routing` varchar(225) DEFAULT NULL,
  `status` varchar(225) DEFAULT NULL,
  `tra_amount` bigint DEFAULT NULL,
  `transfer_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `b_fund_transfer` */

insert  into `b_fund_transfer`(`id`,`created_by`,`created_date_time`,`modified_by`,`modified_date_time`,`bank_name`,`ben_acc_holder_name`,`ben_account_no`,`by_acc_holder_name`,`by_account_no`,`routing`,`status`,`tra_amount`,`transfer_date`) values 
(1,NULL,NULL,NULL,NULL,'Bank of India','User User',1000100103,'Hariom Mukati',1000100102,'2','Completed',2000,'2021-09-07 11:53:23.183000');

/*Table structure for table `b_role` */

DROP TABLE IF EXISTS `b_role`;

CREATE TABLE `b_role` (
  `id` bigint NOT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `created_date_time` datetime(6) DEFAULT NULL,
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date_time` datetime(6) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `b_role` */

insert  into `b_role`(`id`,`created_by`,`created_date_time`,`modified_by`,`modified_date_time`,`description`,`name`) values 
(1,'root','2021-09-07 10:33:04.000000','root','2021-09-07 10:33:10.000000','Admin','Admin'),
(2,'root','2021-09-07 10:39:47.000000','root','2021-09-07 10:39:52.000000','User','User');

/*Table structure for table `b_user` */

DROP TABLE IF EXISTS `b_user`;

CREATE TABLE `b_user` (
  `id` bigint NOT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `created_date_time` datetime(6) DEFAULT NULL,
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date_time` datetime(6) DEFAULT NULL,
  `account_name` varchar(225) DEFAULT NULL,
  `account_no` bigint DEFAULT NULL,
  `bank_id` bigint DEFAULT NULL,
  `bank_name` varchar(225) DEFAULT NULL,
  `confirm_password` varchar(255) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `email_id` varchar(225) DEFAULT NULL,
  `fax` varchar(225) DEFAULT NULL,
  `first_name` varchar(225) DEFAULT NULL,
  `gender` varchar(225) DEFAULT NULL,
  `last_name` varchar(225) DEFAULT NULL,
  `login` varchar(225) DEFAULT NULL,
  `mobile_no` varchar(225) DEFAULT NULL,
  `nationality` varchar(225) DEFAULT NULL,
  `password` varchar(225) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  `title` varchar(225) DEFAULT NULL,
  `type_of_account` varchar(255) DEFAULT NULL,
  `user_image` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `b_user` */

insert  into `b_user`(`id`,`created_by`,`created_date_time`,`modified_by`,`modified_date_time`,`account_name`,`account_no`,`bank_id`,`bank_name`,`confirm_password`,`dob`,`email_id`,`fax`,`first_name`,`gender`,`last_name`,`login`,`mobile_no`,`nationality`,`password`,`role_id`,`title`,`type_of_account`,`user_image`) values 
(1,'root','2021-09-07 10:28:37.000000','root','2021-09-07 10:28:44.000000','(N',1000100101,1,'BOI',NULL,'2021-09-07 10:29:12.000000','Admin@gmail.com',NULL,'Admin','Male','Admin','Admin123','9685456585','Indian','Admin@123',1,NULL,NULL,NULL),
(2,NULL,NULL,NULL,NULL,'Account Name',1000100102,1,'Bank of India',NULL,'1997-10-10 00:00:00.000000','Hari@gmail.com','10000','Hariom','Male','Mukati','Hari123','9685456586','Indian','Hari@321',2,'My Account','Saving',NULL),
(3,NULL,NULL,NULL,NULL,'My New Ac',1000100103,1,'Bank of India',NULL,'1993-01-06 00:00:00.000000','User@gmail.com','9666','User','Female','User','User123','9685456585','Indian','User@123',2,'New Ac','Saving',NULL);

/*Table structure for table `book_transaction` */

DROP TABLE IF EXISTS `book_transaction`;

CREATE TABLE `book_transaction` (
  `id` bigint NOT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `created_date_time` datetime(6) DEFAULT NULL,
  `modified_by` varchar(50) DEFAULT NULL,
  `modified_date_time` datetime(6) DEFAULT NULL,
  `acc_holder_name` varchar(225) DEFAULT NULL,
  `account_no` bigint DEFAULT NULL,
  `bank_id` bigint DEFAULT NULL,
  `bank_name` varchar(225) DEFAULT NULL,
  `rounting_no` varchar(225) DEFAULT NULL,
  `transaction_amount` bigint DEFAULT NULL,
  `transaction_date` datetime(6) DEFAULT NULL,
  `transaction_description` varchar(225) DEFAULT NULL,
  `transaction_type` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `book_transaction` */

insert  into `book_transaction`(`id`,`created_by`,`created_date_time`,`modified_by`,`modified_date_time`,`acc_holder_name`,`account_no`,`bank_id`,`bank_name`,`rounting_no`,`transaction_amount`,`transaction_date`,`transaction_description`,`transaction_type`) values 
(1,NULL,NULL,NULL,NULL,'Hariom Mukati',1000100102,1,'Bank of India','1',5000,'2021-09-07 00:00:00.000000','cncfgnbfdgn','Credit'),
(2,NULL,NULL,NULL,NULL,'Hariom Mukati',1000100102,1,'Bank of India','2',2000,'2021-09-07 11:57:10.290000','Fund Transfer','Debit'),
(3,NULL,NULL,NULL,NULL,'User User',1000100103,1,'Bank of India','2',2000,'2021-09-07 11:57:10.319000','Fund Transfer','Credit');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
