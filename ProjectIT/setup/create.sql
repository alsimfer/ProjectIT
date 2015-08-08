-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 08. Aug 2015 um 19:34
-- Server-Version: 5.6.24
-- PHP-Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `dictionary`
--
CREATE DATABASE IF NOT EXISTS `dictionary` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `dictionary`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `dictionary`
--

DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE IF NOT EXISTS `dictionary` (
  `id` int(8) NOT NULL,
  `english` varchar(250) COLLATE utf8_bin NOT NULL,
  `german` varchar(250) COLLATE utf8_bin NOT NULL,
  `russian` varchar(250) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Daten für Tabelle `dictionary`
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
(64, 'flake off', 'sich (schichtweise) ablösen', 'отслаиваться');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `navigation`
--

DROP TABLE IF EXISTS `navigation`;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Daten für Tabelle `navigation`
--

INSERT INTO `navigation` (`id`, `slug`, `title_en`, `link_en`, `content_en`, `title_de`, `link_de`, `content_de`, `title_ru`, `link_ru`, `content_ru`) VALUES
(1, 'main.xhtml', 'Home Page', 'Home', 'This site was developed for those people, who would like to learn new words in English, German or Russian languages. Using it you will be able to create a personal profile and manage your own dictionary. Just add those words you would like to learn and control your progress with the regular testing. \r\n<br/>\r\nThe statistics of all your tests will be shown here, on the main page so that you can check how are your skills improving over the time! :)', 'Home Seite', 'Home', 'Diese Website wurde für die Menschen entwickelt, die gerne neue Wörter in Englisch, Deutsch oder Russisch lernen möchten. Hier sind Sie in der Lage, ein persönliches Profil zu erstellen um ein eigenes Wörterbuch zu führen. Fügen Sie einfach alle neue Worte die Sie lernen wollen, wiederholen sie regelmäßig und testen Sie sich um Ihren Fortschritt zu kontrollieren.\r\n<br/>\r\nDie Ergebnisse aller Ihren Tests werden hier, auf der Haupt-Seite, angezeigt. Damit können Sie sich freuen über die immer steigenden Leistungen! :)', 'Главная страница', 'Главная', 'Этот сайт был создан для тех людей, которые хотели бы выучить новые слова на английском, немецком или русском языках. С его помощью вы сможете создать личный профиль и управлять своим собственным словарем. Просто добавляйте те новые слова, которые вы хотели бы выучить и контролируйте свой прогресс с помощью регулярного тестирования.\r\n<br/>\r\nСтатистика всех ваших тестов будет показано здесь, на главной странице, так что вы видите, как ваши полиглотские навыки улучшаются со временем! :)'),
(2, 'dictionary.xhtml', 'Dictionary', 'Dictionary', 'If you are not logged in, you are seeing all the words from other users below. You are not able to manage it. If you want to get your own dictionary and save only those words which you are interested in, you need to sign up / log in.\r\n<br/>\r\nFor the logged in users it is possible to add new words using the form below. If the word should be changed or deleted, just select it in the table and it will be loaded to the form.', 'Wörterbuch', 'Wörterbuch', 'Wenn Sie nicht eingeloggt sind, können Sie alle Worte von anderen Usern unten sehen. Sie sind nicht in der Lage die Tabelle zu verwalten. Wenn Sie Ihr eigenes Wörterbuch haben wollen und nur die für Sie interessanten Worte speichern möchten, müssen Sie sich anmelden / registrieren.\r\n<br/>\r\nFür das angemeldete Benutzer ist es möglich, neue Wörter mit der untenstehenden Form hinzuzufügen. Wenn das Wort geändert oder gelöscht werden sollte, wählen Sie es einfach in der Tabelle, und es wird auf die Form eingelegt.', 'Словарь', 'Словарь', 'Если вы не зарегистрированы, вы видите все слова от других пользователей. Вы не можете управлять этим словарем. Если вы хотите, чтобы вести свой собственный словарь и сохранять только те слова, которые вас интересуют, вы должны зарегистрироваться / войти в систему.\r\n<br/>\r\nДля зарегистрированных пользователей есть возможность добавлять новые слова, используя форму ниже. Слова также можно изменять или удалять, кликая по ним в таблице и редактируя значения, загруженные в форму.'),
(3, 'test.xhtml', 'Test', 'Test', 'Here you can take a test and check how well did you learn new words lately. Also if you are not logged in, you can go through the words of other users. \r\n<br/>\r\nTo set up the test use the form below. If you are logged in, you can check your result on the main page in the statistic table.\r\n<br/>\r\nGood luck!', 'Test', 'Test', 'Hier können Sie sich testen und prüfen, wie gut haben Sie neue Wörter in letzter Zeit gelernt. Selbst wenn Sie nicht eingeloggt sind, gibt es die Möglichkeit durch die Worte von anderen Benutzern zu gehen.\r\n<br/>\r\nUm den Test einzustellen, benutzen Sie das folgende Form. Wenn Sie angemeldet sind, können Sie Ihr Ergebnis auf der Hauptseite in der Statistik-Tabelle sehen.\r\n<br/>\r\nViel Glück!', 'Тест', 'Тест', 'Здесь вы можете пройти тест и проверить, насколько хорошо вы учили новые слова в последнее время. Даже если вы не зарегистрированы, вы можете протестировать свои знания, используя словари других пользователей.\r\n<br/>\r\nЧтобы настроить тест используйте форму ниже. Если вы зарегистрированы, вы можете проверить свой результат на главной странице в таблице со статистикой.\r\n<br/>\r\nУдачи!'),
(4, 'login.xhtml', 'Personal settings', 'Personal settings', 'Please sign up to our server or login if you already have a profile. \r\n<br />\r\nIf you are logged in, you can change your personal user data on this page.', 'Persönliche Einstellungen', 'Persönliche Einstellungen', 'Bitte melden Sie sich auf unserem Server oder erstellen Sie ein neues Profil.\r\n<br />\r\nWenn Sie eingeloggt sind, können Sie Ihre persönlichen Daten an dieser Seite ändern.', 'Учётная запись', 'Учётная запись', 'Пожалуйста, зарегистрируйтесь на нашем сервере или создайте новую учётную запись.\r\n<br />\r\nЕсли вы зарегистрированы, вы можете также изменить свои персональные данные на этой странице.');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `stats`
--

DROP TABLE IF EXISTS `stats`;
CREATE TABLE IF NOT EXISTS `stats` (
  `id` int(8) unsigned NOT NULL,
  `user_id` int(8) unsigned NOT NULL,
  `date` date NOT NULL,
  `total_guessed` int(8) unsigned NOT NULL,
  `total_answered` int(8) unsigned NOT NULL,
  `question_language` enum('en','de','ru') COLLATE utf8_bin NOT NULL,
  `answer_language` enum('en','de','ru') COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Daten für Tabelle `stats`
--

INSERT INTO `stats` (`id`, `user_id`, `date`, `total_guessed`, `total_answered`, `question_language`, `answer_language`) VALUES
(4, 13, '2015-06-26', 0, 15, 'en', 'ru'),
(5, 1, '2015-06-26', 10, 15, 'en', 'ru'),
(6, 1, '2015-06-27', 4, 25, 'de', 'ru'),
(7, 0, '2015-08-02', 1, 5, 'en', 'ru'),
(8, 0, '2015-08-02', 1, 5, 'en', 'ru'),
(9, 0, '2015-08-02', 0, 5, 'en', 'ru'),
(10, 0, '2015-08-02', 5, 15, 'en', 'ru'),
(11, 0, '2015-08-05', 1, 5, 'en', 'de'),
(12, 0, '2015-08-05', 2, 5, 'en', 'de'),
(13, 0, '2015-08-05', 1, 5, 'en', 'de'),
(14, 0, '2015-08-05', 2, 5, 'en', 'de'),
(15, 0, '2015-08-05', 2, 5, 'en', 'de'),
(16, 0, '2015-08-05', 1, 5, 'en', 'de'),
(17, 0, '2015-08-05', 8, 15, 'en', 'de'),
(18, 0, '2015-08-05', 3, 15, 'en', 'de'),
(19, 0, '2015-08-05', 5, 15, 'en', 'de'),
(20, 0, '2015-08-05', 1, 6, 'en', 'de'),
(21, 1, '2015-08-05', 1, 6, 'en', 'de'),
(22, 0, '2015-08-06', 2, 5, 'en', 'de'),
(23, 1, '2015-08-06', 1, 5, 'en', 'de'),
(24, 1, '2015-08-06', 0, 5, 'en', 'de'),
(25, 1, '2015-08-06', 2, 5, 'en', 'de'),
(26, 0, '2015-08-07', 5, 15, 'en', 'de'),
(27, 0, '2015-08-07', 4, 15, 'en', 'de'),
(28, 0, '2015-08-07', 2, 15, 'en', 'de'),
(29, 0, '2015-08-07', 9, 15, 'en', 'de'),
(30, 0, '2015-08-08', 9, 15, 'en', 'de'),
(31, 0, '2015-08-08', 15, 15, 'en', 'de'),
(32, 0, '2015-08-08', 2, 15, 'en', 'de'),
(33, 0, '2015-08-08', 2, 15, 'en', 'de'),
(34, 0, '2015-08-08', 4, 15, 'en', 'de'),
(35, 16, '2015-08-08', 1, 5, 'de', 'en');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user_dictionary`
--

DROP TABLE IF EXISTS `user_dictionary`;
CREATE TABLE IF NOT EXISTS `user_dictionary` (
  `user_id` int(8) NOT NULL,
  `dictionary_id` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Daten für Tabelle `user_dictionary`
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
-- Tabellenstruktur für Tabelle `user_table`
--

DROP TABLE IF EXISTS `user_table`;
CREATE TABLE IF NOT EXISTS `user_table` (
  `id` int(8) unsigned NOT NULL,
  `last_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `first_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `email` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  `language` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT 'english',
  `status` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Daten für Tabelle `user_table`
--

INSERT INTO `user_table` (`id`, `last_name`, `first_name`, `email`, `password`, `language`, `status`) VALUES
(1, 'Smith', 'Alex', 'qwerty@asd.com', '123456', 'russian', 1),
(16, 'Schmalex', 'Alex', 'qwe@asd.com', '123456', 'english', 1);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `dictionary`
--
ALTER TABLE `dictionary`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `english` (`english`),
  ADD UNIQUE KEY `german` (`german`),
  ADD UNIQUE KEY `russian` (`russian`);

--
-- Indizes für die Tabelle `navigation`
--
ALTER TABLE `navigation`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `stats`
--
ALTER TABLE `stats`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `navigation`
--
ALTER TABLE `navigation`
  MODIFY `id` int(8) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT für Tabelle `stats`
--
ALTER TABLE `stats`
  MODIFY `id` int(8) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT für Tabelle `user_table`
--
ALTER TABLE `user_table`
  MODIFY `id` int(8) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
