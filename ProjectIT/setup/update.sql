-- Add _en locale to title, content, link.
ALTER TABLE `navigation` CHANGE `title` `title_en` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'title on tab', CHANGE `link` `link_en` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'button or link name', CHANGE `content` `content_en` TEXT CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content of the page';

-- Couple words
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','sledge','der Schlitten','санки');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','sidewalk','der Bürgesteig','тротуар');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','curb','die Bordüre','бордюр');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','trimming, facing','der Besatz, die Verkleidung','обшивка, отделка');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','nightingale','die Nachtigall','соловей');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','taunt','der Spott','насмешка');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','chest','die Truhe','сундук');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','fund','der Fonds, der Bestand, der Nachlass','фонд');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','preis, award','die Belohnung','награда');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','rot, rail','die Latte','планка');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','hard','steif ','жёстко');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','shamble','die Trümmer','развалины, руины');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','rumble','schmettern','швырять, огушительно звучать');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','loading, charging','die Beschickung','загрузка, засыпка, зарядка');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','trick','der Kunstgriff','искуссный приём');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','meanwhile','derweil','между тем');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','limp','hinken','хромать');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','nitrogen','der Stickstoff','азот');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','accomodate','beherbergen','вмещать, принимать у себя');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','vein','die Ader','прожилка, кровеносный сосуд');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','fibre','die Faser','волокно, нитка');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','crack, snap','knallen','хлопать, щёлкать');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','languid','schlapp','вялый, дряблый, инертный');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','rock','der Fels','горная порода');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','penetrate','dringen','проникать');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','petty, paltry','pingelig','мелочный, щепетильный');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','adjust','nachschleifen','поправлять, волочиться');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','henceforth ','nunmehr','отныне, теперь');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','enchanted','verzaubert','заколдованный');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','braid, weave','durchwinken ','плести');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','considerably','erheblich','значительно');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','flood','fluten','заливать, хлынуть');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','pledge','die Verpflichtung','заклад, обязательство');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','slyboots ','der Pfiffikus','хитрец, пройдоха');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','allowed, permitted','vergönnt','позволенный, разрешённый');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','proclaim','verkünden ','провозглашать, обнародовать');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','giant','das Riesending','громада');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','rash','der Rash ','сыпь, аллергич. реакция');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','tile','die Flíese ','плитка');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','violet','das Veilchen ','фиалка');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','permissiveness','die Willkür','вседозволенность');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT',' deadlock, stagnation','der Stillstand','застой');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','decay, dust','die Verwesung','тлен');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','nobility','der Edelmut','благородство');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','unacceptance, disapproval, rejection','die Aberkennung','неприятие');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','defect, vice','das Laster','порок');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','devotion, dedication','die Hingabe','самоотдача');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','patch','der Flicken','заплатка');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','string','der Strang','верёвка, канат');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','bribe','bestechen','подкупать / располагать к себе');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','settle','abwickeln','улаживать');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','sort, classify','einstufen','классифицировать, сортировать');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','harm','die Beeinträchtigung','нанесение вреда [ущерба]; нарушение интересов');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','outcome','der Ausfall','результат, итог; исход');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','space radiation','die Höhenstrahlung','космическое излучение');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','feasible','etwaig','имеющийся, случившийся, возможный');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','inherent','inhärent ',' присущий, (органически) свойственный, неотъемлемый');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','maturity','die Reife ','спелость; зрелость');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','presence, availability','das Vorhandensein','наличие');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','intentional','vorsätzlich',' умышленный, преднамеренный');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','frequent','gehäuft','частый, повторяющийся');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','prioritization','die Priorisierung','определение приоритета');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','reward','verleihen','награждать, присваивать');
INSERT INTO dictionary (id,english,german,russian) VALUES('DEFAULT','flake off','sich (schichtweise) ablösen','отслаиваться');

-- Relations
INSERT INTO `dictionary`.`user_dictionary` (`user_id`, `dictionary_id`) VALUES ('1', '1'), ('1', '2'), ('1', '3'), ('1', '4'), ('1', '5'), ('1', '6'), ('1', '7'), ('1', '8'), ('1', '9'), ('1', '10'), ('1', '11'), ('1', '12'), ('1', '13'), ('1', '14'), ('1', '15'), ('1', '16'), ('1', '17'), ('1', '18'), ('1', '19'), ('1', '20'), ('1', '21'), ('1', '22'), ('1', '23'), ('1', '24'), ('1', '25'), ('1', '26'), ('1', '27'), ('1', '28'), ('1', '29'), ('1', '30'), ('1', '31'), ('1', '32'), ('1', '33'), ('1', '34'), ('1', '35'), ('1', '36'), ('1', '37'), ('1', '38'), ('1', '39'), ('1', '40');

-- Content update
UPDATE `dictionary`.`navigation` SET `content_en` = 'Here you can take a test with all the words that you have already added to your personal dictionary. You also have an option to go through words that were assigned to other users. Good luck!', `content_de` = 'Hier können Sie sich mit allen bis jetzt erfassten Wörtern testen. Optional können Sie auch die Wörter anderer Nutzer raten. Viel Erfolg!', `content_ru` = 'Здесь вы можете протестировать, насколько хорошо вы выучили свой словарь. Вы можете также включить в свой тест слова других пользователей' WHERE `navigation`.`id` = 3;

-- Add stats table
-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2015 at 03:30 PM
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
-- Table structure for table `stats`
--

CREATE TABLE IF NOT EXISTS `stats` (
`id` int(8) unsigned NOT NULL,
  `user_id` int(8) unsigned NOT NULL,
  `total_tests` int(8) unsigned NOT NULL,
  `total_guessed` int(8) unsigned NOT NULL,
  `total_answered` int(8) unsigned NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `stats`
--
ALTER TABLE `stats`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `stats`
--
ALTER TABLE `stats`
MODIFY `id` int(8) unsigned NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

UPDATE `dictionary`.`navigation` SET `title_en` = 'Personal settings', `link_en` = 'Personal settings', `title_de` = 'Persönliche Einstellungen', `link_de` = 'Persönliche Einstellungen' WHERE `navigation`.`id` = 4;

ALTER TABLE `stats` DROP `total_tests`;

ALTER TABLE `stats` ADD `question_language` ENUM('en', 'de', 'ru') NOT NULL , ADD `answer_language` ENUM('en', 'de', 'ru') NOT NULL ;