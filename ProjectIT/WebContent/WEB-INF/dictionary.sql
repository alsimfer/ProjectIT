-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 12, 2015 at 02:42 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `dictionary`
--
CREATE DATABASE IF NOT EXISTS `dictionary` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `dictionary`;

-- --------------------------------------------------------

--
-- Table structure for table `dictionary`
--

DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE IF NOT EXISTS `dictionary` (
`id` int(10) NOT NULL,
  `english` varchar(250) COLLATE utf8_bin NOT NULL,
  `german` varchar(250) COLLATE utf8_bin NOT NULL,
  `russian` varchar(250) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `navigation`
--

DROP TABLE IF EXISTS `navigation`;
CREATE TABLE IF NOT EXISTS `navigation` (
`id` int(10) unsigned NOT NULL,
  `title` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'title on tab',
  `link` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'button or link name',
  `content` text COLLATE utf8_bin NOT NULL COMMENT 'content of the page',
  `title_de` varchar(50) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL,
  `link_de` varchar(50) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL,
  `content_de` text CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL,
  `title_ru` varchar(50) CHARACTER SET utf8 NOT NULL,
  `link_ru` varchar(50) CHARACTER SET utf8 NOT NULL,
  `content_ru` text CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=5 ;

--
-- Dumping data for table `navigation`
--

INSERT INTO `navigation` (`id`, `title`, `link`, `content`, `title_de`, `link_de`, `content_de`, `title_ru`, `link_ru`, `content_ru`) VALUES
(1, 'Home Page', 'Home', 'Here is a content for the home page. Can be said something about statistics if the user is logged in and invitation message if not ', 'Home Seite', 'Home', 'Hier wird ein Content für die Home-Seite geschrieben', 'Главная страница', 'Главная', 'Что-нить про статистику или приглашение создать учётку'),
(2, 'Dictionary', 'Dictionary', 'Here will be an interface to save new words to the personal dictionary', 'Wörterbuch', 'Wörterbuch', '', 'Словарь', 'Словарь', ''),
(3, 'Test', 'Test', '', 'Test', 'Test', '', 'Тест', 'Тест', ''),
(4, 'Login', 'Login', 'Please sign up to our server or login if you already have a profile.', 'Login', 'Login', 'Bitte melden Sie sich auf unserem Server oder erstellen Sie ein neues Profil.', 'Учётная запись', 'Учётная запись', 'Пожалуйста, зарегистрируйтесь на нашем сервере или создайте новую учётную запись.');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
`id` int(10) unsigned NOT NULL,
  `last_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `first_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `email` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  `language` enum('en','de','ru') COLLATE utf8_bin NOT NULL DEFAULT 'en',
  `status` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user_dictionary`
--

DROP TABLE IF EXISTS `user_dictionary`;
CREATE TABLE IF NOT EXISTS `user_dictionary` (
  `user_id` int(10) NOT NULL,
  `dictionary_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dictionary`
--
ALTER TABLE `dictionary`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `navigation`
--
ALTER TABLE `navigation`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dictionary`
--
ALTER TABLE `dictionary`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `navigation`
--
ALTER TABLE `navigation`
MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT;

-- Add slugs for navigation
UPDATE `navigation` SET `slug` = 'index.xhtml' WHERE `navigation`.`id` = 1; UPDATE `dictionary`.`navigation` SET `slug` = 'dictionary.xhtml' WHERE `navigation`.`id` = 2; UPDATE `dictionary`.`navigation` SET `slug` = 'test.xhtml' WHERE `navigation`.`id` = 3; UPDATE `dictionary`.`navigation` SET `slug` = 'login.xhtml' WHERE `navigation`.`id` = 4;

-- To allow integer from id make it smaller
ALTER TABLE `navigation` CHANGE `id` `id` INT(8) UNSIGNED NOT NULL AUTO_INCREMENT;
ALTER TABLE `dictionary` CHANGE `id` `id` INT(8) NOT NULL AUTO_INCREMENT;
ALTER TABLE `user` CHANGE `id` `id` INT(8) UNSIGNED NOT NULL AUTO_INCREMENT;
ALTER TABLE `user_dictionary` CHANGE `user_id` `user_id` INT(8) NOT NULL, CHANGE `dictionary_id` `dictionary_id` INT(8) NOT NULL;

UPDATE `dictionary`.`navigation` SET `slug` = 'main.xhtml' WHERE `navigation`.`id` = 1;