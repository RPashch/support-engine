-- create database and delete if ixists

use test;
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists customs;
drop table if exists accounts;
drop table if exists transactions;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `customs` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`first_name` varchar(100) NOT NULL,
	`second_name` varchar(100) NOT NULL,
	`date_of_bitrh` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `accounts` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`custom_id` INT NOT NULL,
	`amount_money` DECIMAL(20) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `transactions` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`account_from_id` INT NOT NULL,
	`account_to_id` INT NOT NULL,
	`amount` DECIMAL(20) NOT NULL,
	`date` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `accounts` ADD CONSTRAINT `accounts_fk0` FOREIGN KEY (`custom_id`) REFERENCES `customs`(`id`);

ALTER TABLE `transactions` ADD CONSTRAINT `transactions_fk0` FOREIGN KEY (`account_from_id`) REFERENCES `accounts`(`id`);

ALTER TABLE `transactions` ADD CONSTRAINT `transactions_fk1` FOREIGN KEY (`account_to_id`) REFERENCES `accounts`(`id`);
