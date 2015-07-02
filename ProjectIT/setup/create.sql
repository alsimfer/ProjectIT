DROP TABLE IF EXISTS dictionary;
DROP TABLE IF EXISTS navigation;
DROP TABLE IF EXISTS stats;
DROP TABLE IF EXISTS user_table;
DROP TABLE IF EXISTS user_dictionary;

-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2015 at 10:10 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dictionary`
--

-- --------------------------------------------------------

--
-- Table structure for table `dictionary`
--

CREATE TABLE IF NOT EXISTS `dictionary` (
`id` int(8) NOT NULL,
  `english` varchar(250) COLLATE utf8_bin NOT NULL,
  `german` varchar(250) COLLATE utf8_bin NOT NULL,
  `russian` varchar(250) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=68 ;

--
-- Dumping data for table `dictionary`
--

INSERT INTO `dictionary` (`id`, `english`, `german`, `russian`) VALUES
(1, 'sledge', 'der Schlitten', 'санки'),
(2, 'sidewalk', 'der Bürgesteig', 'тротуар'),
(3, 'curb', 'die Bordüre', 'бордюр'),
(4, 'trimming, facing', 'der Besatz, die Verkleidung', 'обшивка, отделка'),
(5, 'nightingale', 'die Nachtigall', 'соловей'),
(6, 'taunt', 'der Spott', 'насмешка'),
(7, 'chest', 'die Truhe', 'сундук'),
(8, 'fund', 'der Fonds, der Bestand, der Nachlass', 'фонд'),
(9, 'preis, award', 'die Belohnung', 'награда'),
(10, 'rot, rail', 'die Latte', 'планка'),
(11, 'hard', 'steif ', 'жёстко'),
(12, 'shamble', 'die Trümmer', 'развалины, руины'),
(13, 'rumble', 'schmettern', 'швырять, огушительно звучать'),
(14, 'loading, charging', 'die Beschickung', 'загрузка, засыпка, зарядка'),
(15, 'trick', 'der Kunstgriff', 'искуссный приём'),
(16, 'meanwhile', 'derweil', 'между тем'),
(17, 'limp', 'hinken', 'хромать'),
(18, 'nitrogen', 'der Stickstoff', 'азот'),
(19, 'accomodate', 'beherbergen', 'вмещать, принимать у себя'),
(20, 'vein', 'die Ader', 'прожилка, кровеносный сосуд'),
(21, 'fibre', 'die Faser', 'волокно, нитка'),
(22, 'crack, snap', 'knallen', 'хлопать, щёлкать'),
(23, 'languid', 'schlapp', 'вялый, дряблый, инертный'),
(24, 'rock', 'der Fels', 'горная порода'),
(25, 'penetrate', 'dringen', 'проникать'),
(26, 'petty, paltry', 'pingelig', 'мелочный, щепетильный'),
(27, 'adjust', 'nachschleifen', 'поправлять, волочиться'),
(28, 'henceforth ', 'nunmehr', 'отныне, теперь'),
(29, 'enchanted', 'verzaubert', 'заколдованный'),
(30, 'braid, weave', 'durchwinken ', 'плести'),
(31, 'considerably', 'erheblich', 'значительно'),
(32, 'flood', 'fluten', 'заливать, хлынуть'),
(33, 'pledge', 'die Verpflichtung', 'заклад, обязательство'),
(34, 'slyboots ', 'der Pfiffikus', 'хитрец, пройдоха'),
(35, 'allowed, permitted', 'vergönnt', 'позволенный, разрешённый'),
(36, 'proclaim', 'verkünden ', 'провозглашать, обнародовать'),
(37, 'giant', 'das Riesending', 'громада'),
(38, 'rash', 'der Rash ', 'сыпь, аллергич. реакция'),
(39, 'tile', 'die Flíese ', 'плитка'),
(40, 'violet', 'das Veilchen ', 'фиалка'),
(41, 'permissiveness', 'die Willkür', 'вседозволенность'),
(42, ' deadlock, stagnation', 'der Stillstand', 'застой'),
(43, 'decay, dust', 'die Verwesung', 'тлен'),
(44, 'nobility', 'der Edelmut', 'благородство'),
(45, 'unacceptance, disapproval, rejection', 'die Aberkennung', 'неприятие'),
(46, 'defect, vice', 'das Laster', 'порок'),
(47, 'devotion, dedication', 'die Hingabe', 'самоотдача'),
(48, 'patch', 'der Flicken', 'заплатка'),
(49, 'string', 'der Strang', 'верёвка, канат'),
(50, 'bribe', 'bestechen', 'подкупать / располагать к себе'),
(51, 'settle', 'abwickeln', 'улаживать'),
(52, 'sort, classify', 'einstufen', 'классифицировать, сортировать'),
(53, 'harm', 'die Beeinträchtigung', 'нанесение вреда [ущерба]; нарушение интересов'),
(54, 'outcome', 'der Ausfall', 'результат, итог; исход'),
(55, 'space radiation', 'die Höhenstrahlung', 'космическое излучение'),
(56, 'feasible', 'etwaig', 'имеющийся, случившийся, возможный'),
(57, 'inherent', 'inhärent ', ' присущий, (органически) свойственный, неотъемлемый'),
(58, 'maturity', 'die Reife ', 'спелость; зрелость'),
(59, 'presence, availability', 'das Vorhandensein', 'наличие'),
(60, 'intentional', 'vorsätzlich', ' умышленный, преднамеренный'),
(61, 'frequent', 'gehäuft', 'частый, повторяющийся'),
(62, 'prioritization', 'die Priorisierung', 'определение приоритета'),
(63, 'reward', 'verleihen', 'награждать, присваивать'),
(64, 'flake off', 'sich (schichtweise) ablösen', 'отслаиваться'),
(67, 'asd', 'hallo', '123');

-- --------------------------------------------------------

--
-- Table structure for table `navigation`
--

CREATE TABLE IF NOT EXISTS `navigation` (
`id` int(8) unsigned NOT NULL,
  `slug` varchar(50) COLLATE utf8_bin NOT NULL,
  `title_en` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'title on tab',
  `link_en` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'button or link name',
  `content_en` text COLLATE utf8_bin NOT NULL COMMENT 'content of the page',
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

INSERT INTO `navigation` (`id`, `slug`, `title_en`, `link_en`, `content_en`, `title_de`, `link_de`, `content_de`, `title_ru`, `link_ru`, `content_ru`) VALUES
(1, 'main.xhtml', 'Home Page', 'Home', 'Here is a content for the home page. Can be said something about statistics if the user is logged in and invitation message if not ', 'Home Seite', 'Home', 'Hier wird ein Content für die Home-Seite geschrieben', 'Главная страница', 'Главная', 'Что-нить про статистику или приглашение создать учётку'),
(2, 'dictionary.xhtml', 'Dictionary', 'Dictionary', 'Here will be an interface to save new words to the personal dictionary', 'Wörterbuch', 'Wörterbuch', '', 'Словарь', 'Словарь', ''),
(3, 'test.xhtml', 'Test', 'Test', 'Here you can take a test with all the words that you have already added to your personal dictionary. You also have an option to go through words that were assigned to other users. Good luck!', 'Test', 'Test', 'Hier können Sie sich mit allen bis jetzt erfassten Wörtern testen. Optional können Sie auch die Wörter anderer Nutzer raten. Viel Erfolg!', 'Тест', 'Тест', 'Здесь вы можете протестировать, насколько хорошо вы выучили свой словарь. Вы можете также включить в свой тест слова других пользователей'),
(4, 'login.xhtml', 'Personal settings', 'Personal settings', 'Please sign up to our server or login if you already have a profile.', 'Persönliche Einstellungen', 'Persönliche Einstellungen', 'Bitte melden Sie sich auf unserem Server oder erstellen Sie ein neues Profil.', 'Учётная запись', 'Учётная запись', 'Пожалуйста, зарегистрируйтесь на нашем сервере или создайте новую учётную запись.');

-- --------------------------------------------------------

--
-- Table structure for table `stats`
--

CREATE TABLE IF NOT EXISTS `stats` (
`id` int(8) unsigned NOT NULL,
  `user_id` int(8) unsigned NOT NULL,
  `date` date NOT NULL,
  `total_guessed` int(8) unsigned NOT NULL,
  `total_answered` int(8) unsigned NOT NULL,
  `question_language` enum('en','de','ru') COLLATE utf8_bin NOT NULL,
  `answer_language` enum('en','de','ru') COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=7 ;

--
-- Dumping data for table `stats`
--

INSERT INTO `stats` (`id`, `user_id`, `date`, `total_guessed`, `total_answered`, `question_language`, `answer_language`) VALUES
(4, 13, '2015-06-26', 0, 15, 'en', 'ru'),
(5, 1, '2015-06-26', 10, 15, 'en', 'ru'),
(6, 1, '2015-06-27', 4, 25, 'de', 'ru');

-- --------------------------------------------------------

--
-- Table structure for table `user_dictionary`
--

CREATE TABLE IF NOT EXISTS `user_dictionary` (
  `user_id` int(8) NOT NULL,
  `dictionary_id` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user_dictionary`
--

INSERT INTO `user_dictionary` (`user_id`, `dictionary_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(1, 18),
(1, 19),
(1, 20),
(1, 21),
(1, 22),
(1, 23),
(1, 24),
(1, 25),
(1, 26),
(1, 27),
(1, 28),
(1, 29),
(1, 30),
(1, 31),
(1, 32),
(1, 33),
(1, 34),
(1, 35),
(1, 36),
(1, 37),
(1, 38),
(1, 39),
(1, 40),
(0, 67);

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE IF NOT EXISTS `user_table` (
`id` int(8) unsigned NOT NULL,
  `last_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `first_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `email` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  `language` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT 'english',
  `status` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=16 ;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`id`, `last_name`, `first_name`, `email`, `password`, `language`, `status`) VALUES
(1, 'Smith', 'Alex', 'qwerty', '123456', 'english', 1),
(12, 'Pupkin', 'Vasya', 'vasy', '1', 'english', 1),
(13, 'Smith', 'Alex', '3', '4', 'english', 1),
(14, 'qwe', 'rty', '6', '5', 'english', 1),
(15, '1', '1', '4', '5', 'russian', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dictionary`
--
ALTER TABLE `dictionary`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `english` (`english`), ADD UNIQUE KEY `german` (`german`), ADD UNIQUE KEY `russian` (`russian`);

--
-- Indexes for table `navigation`
--
ALTER TABLE `navigation`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stats`
--
ALTER TABLE `stats`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dictionary`
--
ALTER TABLE `dictionary`
MODIFY `id` int(8) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=68;
--
-- AUTO_INCREMENT for table `navigation`
--
ALTER TABLE `navigation`
MODIFY `id` int(8) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `stats`
--
ALTER TABLE `stats`
MODIFY `id` int(8) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `user_table`
--
ALTER TABLE `user_table`
MODIFY `id` int(8) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
