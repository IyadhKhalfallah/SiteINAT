-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Ven 03 Mai 2019 à 23:05
-- Version du serveur :  5.7.26-0ubuntu0.18.04.1
-- Version de PHP :  7.2.17-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `SiteINAT`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `articleid` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `longdescription` text,
  `name` varchar(255) DEFAULT NULL,
  `shortdescription` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `article`
--

INSERT INTO `article` (`articleid`, `date`, `longdescription`, `name`, `shortdescription`) VALUES
(4, '2019-04-10 00:00:00', 'Les additifs alimentaires sont des substances ajoutées en petite quantité aux denrées alimentaires dans le but d\'en préserver ou améliorer leur innocuité, leur fraîcheur, leur goût, leur texture ou leur aspect. Ils jouent plusieurs rôles capitaux dans la branche agroalimentaire, ils peuvent être des : * conservateurs qui empêchent la présence et le développement de micro-organismes indésirables *anti-oxygène qui évitent ou réduisent les phénomènes d\'oxydation provoquant entre autres le rancissement (altération des graisses exposées à l\'air, à la lumière et à la chaleur) des matières grasses ou le brunissement des fruits et légumes coupés * agents de texture qui améliorent la présentation ou la tenue(émulsifiants, stabilisants, épaississants, gélifiants) *colorants qui renforcent ou confèrent une coloration *exausteurs de goût qui renforcent leur goût Ainsi, le Décret du 18 septembre 1989, suite à la directive CEE du 21 décembre 1988, définit le terme additif alimentaire en disposant que « On entend par additif alimentaire, toute substance habituellement non consommée comme aliment en soi et habituellement non utilisée comme ingrédient caractéristique dans l’alimentation, possédant ou non une valeur nutritive et dont l’adjonction intentionnelle aux denrées alimentaires dans un but technologique au stade de leur fabrication, transformation, préparation, traitement, conditionnement, transport, entreposage, a pour effet, ou peut raisonnablement être estimée avoir pour effet, qu’elle devient elle-même, ou que ses dérivés deviennent directement ou indirectement, un composant de ces denrées alimentaires »  Les effets positifs : \r\n1/ Ils permettent de lutter contre l’obésité. En effet, les édulcorants permettent de donner un goût sucré aux aliments, sans pour autant ajouter des calories \r\n2/ Ils préviennent les maladies cardio-vasculaires; la lécithine de soja est un émulsifiant qui est un anti-cholestérol naturel qui solubilise les graisses dans le sang, Les effets négatifs : \r\n1/ Un régime qui contient des colorants peut engendrer l’hyperactivité chez les enfants \r\n2/ Les additifs engendrent une baisse au niveau de l’absorption intestinale ainsi qu’un bouleversement de la flore intestinale \r\n3/ Allergies: en ce qui concerne les personnes sensibles \r\n4/ Accoutumance: les exhausteurs de goût stimulent l’appétit, ce qui insinue que plus on en mange plus on a faim', 'Les additifs alimentaires', 'Les additifs alimentaires sont des substances ajoutées en petite quantité aux denrées alimentaires dans le but d\'en préserver ou améliorer leur innocuité, leur fraîcheur, leur goût, leur texture ou leur aspect ');

-- --------------------------------------------------------

--
-- Structure de la table `article_photo`
--

CREATE TABLE `article_photo` (
  `photoid` bigint(20) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `article_articleid` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `article_photo`
--

INSERT INTO `article_photo` (`photoid`, `path`, `article_articleid`) VALUES
(1, 'Les additifis Alimentaires .jpg', 4);

-- --------------------------------------------------------

--
-- Structure de la table `enterprise`
--

CREATE TABLE `enterprise` (
  `enterpriseid` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `description` text,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `partner` bit(1) NOT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `sponsor` bit(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `enterprise`
--

INSERT INTO `enterprise` (`enterpriseid`, `address`, `description`, `email`, `name`, `partner`, `phone`, `sponsor`) VALUES
(1, '1, Rue Salah Ben Mahmoud Menzah 1 Tunis', NULL, NULL, 'Restaurant Zink', b'0', 22420010, b'0'),
(2, '43 Avenue Charles Nicolle, Tunis 1082', 'Enseignant – chercheur', 'warnermail', 'Ali Sahli', b'0', 53934331, b'0'),
(3, 'INAT', NULL, NULL, 'Département protection des plantes', b'0', NULL, b'0');

-- --------------------------------------------------------

--
-- Structure de la table `enterprise_photo`
--

CREATE TABLE `enterprise_photo` (
  `photoid` bigint(20) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `enterprise_enterpriseid` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `event`
--

CREATE TABLE `event` (
  `dtype` varchar(31) NOT NULL,
  `eventid` bigint(20) NOT NULL,
  `closing` datetime DEFAULT NULL,
  `description` text,
  `name` varchar(255) DEFAULT NULL,
  `opening` datetime DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `program` text,
  `equipment` text,
  `goals` text,
  `prerequisites` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `event`
--

INSERT INTO `event` (`dtype`, `eventid`, `closing`, `description`, `name`, `opening`, `place`, `program`, `equipment`, `goals`, `prerequisites`) VALUES
('Training', 3, NULL, 'Courte, dynamique et  opérationnelle, cette formation s\'adresse à ceux qui souhaitent acquérir les fondamentaux de la gestion de projet.  La formation est conçue autour d’un cas fil rouge qui permet de mettre en œuvre les bonnes pratiques de la gestion de projet pour maîtriser la performance, les coûts et les délais d’un projet. Charte projet, organigramme des tâches, planning, analyse de risques… les membres repartent avec des outils à déployer pour leurs propres projets.', 'Agri-Business', NULL, NULL, NULL, NULL, NULL, 'Cette formation ne nécessite pas de prérequis.'),
('Training', 4, NULL, 'Dans un contexte concurrentiel où l’attraction et la fidélisation des talents sont de plus en plus stratégiques. Cette formation fournit une démarche et des outils permettant de mettre le processus recrutement en cohérence avec la stratégie de l\'entreprise et de maîtriser toutes les techniques d\'entretien pour accroître la qualité et l\'objectivité de ses recrutements.', 'Comment réussir son recrutement', NULL, NULL, NULL, NULL, NULL, 'Cette formation ne nécessite pas de prérequis.'),
('Training', 5, NULL, 'Comment choisir votre stratégie sur les médias sociaux ? Comment choisir les médias prioritaires ? Quels facteurs clés de succès pour animer vos espaces et engager vos communautés ? Comment piloter vos résultats ? Quels outils pour surveiller votre réputation ?… Cette formation vous permettra de mieux cerner le rôle de community manager et de mettre en place vos premières actions avec efficacité.', 'Community Management', NULL, NULL, NULL, NULL, NULL, 'Être inscrit et actif sur au moins un réseau social (Facebook, Linkedin, Twitter, Instagram).'),
('Training', 6, NULL, 'Le Marketing digital est au cœur de la communication. Ce cycle de formation vous apporte la dimension à la fois stratégique et opérationnelle d\'un métier en pleine mutation : • la stratégie marketing digital avec la démarche globale, le e-mix marketing, les techniques de référencement, la génération de trafic et de conversion ; • optimiser ses campagnes de communication digitale (display, e-mailing, …) et déployer sa stratégie sur le mobile ;• le marketing digital sur les médias et réseaux sociaux.', 'Digital Marketing', NULL, NULL, NULL, NULL, NULL, 'Des connaissances marketing et commerciales sont requises pour tirer tout le     bénéfice de ce cycle.'),
('Training', 7, NULL, 'La communication événementielle est un des outils à enjeux pour l\'entreprise. Aujourd\'hui elle intègre le digital dans ses actions. Durant cette formation, vous allez maîtriser les étapes-clés, de l\'organisation amont à l\'évaluation des retombées, d\'une manifestation. ', 'Event Management', NULL, NULL, NULL, NULL, NULL, 'Organiser des manifestations événementielles.'),
('Training', 8, NULL, 'Cette formation Photoshop permet de se familiariser avec le logiciel de retouche d\'image et d\'apprendre les fonctions de base pour améliorer, modifier et enrichir des images numériques. Évaluez votre niveau de connaissance sur Photoshop.', 'Initiation Photoshop', NULL, NULL, NULL, NULL, NULL, 'Être à l\'aise avec l\'ordinateur et la bureautique.'),
('Training', 9, NULL, 'Détourer un personnage en respectant la finesse de ses cheveux, l\'incruster dans un nouveau décor sans raccords visibles, changer la couleur de ses vêtements, créer une ombre portée… un travail d\'artiste avec Photoshop désormais possible grâce à cette formation !', 'Photoshop', NULL, NULL, NULL, NULL, NULL, 'Avoir suivi  ou avoir une très bonne pratique du logiciel.'),
('Training', 10, NULL, 'Moment privilégié pour les collaborateurs et l\'entreprise, l\'entretien annuel d\'appréciation doit, pour jouer pleinement son rôle, être conduit de manière objective et concertée. Mené avec les bonnes techniques et postures, cet entretien d\'évaluation est un véritable outil de management pour renforcer la performance individuelle et collective. En plus des techniques pour conduire l\'entretien annuel en toute objectivité, cette formation vous fournit également des clés pour identifier et prévenir les situations à risques qui peuvent découler de l\'appréciation (stress, harcèlement, discrimination…).', 'Reussir son entretien', NULL, NULL, NULL, NULL, NULL, 'Cette formation ne nécessite pas de prérequis.'),
('Training', 11, NULL, 'Exister sur le web, c’est aujourd’hui se retrouver bien placé dans les pages de résultats des moteurs de recherche. Le référencement naturel, SEO peut à lui seul propulser un site sur les premières pages de Google. Pour qui veut comprendre les rouages et techniques avancées du référencement naturel.', 'S.E.O', NULL, NULL, NULL, NULL, NULL, 'Être à l\'aise avec l\'ordinateur, maîtriser Internet et les fonctionnalités des sites Web.'),
('Training', 12, NULL, 'Se positionner sur un marché consiste à déterminer la place visée pour son offre, à destination de clients actuels et futurs (produit / prestations et services associés), en tenant compte de ses concurrents. Elle va permettre : • De se différencier de la concurrence de l\'entreprise. • D\'être identifié par la clientèle de l\'entreprise ancienne et nouvelle et par les prescripteurs', 'Savoir se positionner sur le marché', NULL, NULL, NULL, NULL, NULL, 'Cette formation ne nécessite pas de prérequis.'),
('Training', 13, NULL, 'Monter des partenariats ne s\'improvise pas. Cette formation vous permet d\'identifier le dispositif de partenariat le plus adapté à votre stratégie, vos objectifs de communication et à vos contraintes de budgets.  Vous découvrirez les différentes méthodes de collecte de fonds, de stratégie de mécénat et la manière de les promouvoir. ', 'Sponsoring', NULL, NULL, NULL, NULL, NULL, 'Participer ou organiser des événements impliquant des acteurs externes à sa    structure.'),
('Training', 14, NULL, 'Appliquer sa stratégie de gestion du stress dans la durée. Mieux gérer ses émotions en situations de stress. Faire appel à ses ressources individuelles. Récupérer rapidement. ', 'Stress Management', NULL, NULL, 'En amont, un autodiagnostic pour se situer et définir ses priorités 1 - Évaluer ses modes de fonctionnement face au stress 2 - Apprendre à se détendre intellectuellement, physiquement et émotionnellement 3 - Sortir de la passivité et agir positivement 4 - Renforcer la confiance en soi 5 - Définir et mettre en œuvre sa stratégie de réussite', NULL, NULL, 'Forte volonté de s’impliquer personnellement et émotionnellement dans cette formation pour en tirer les meilleurs bénéfices.'),
('Training', 15, NULL, '? Permettre aux participants de comprendre leur propre préférence dans le travail et de développer leurs forces dans le domaine du leadership et du travail en équipe. ? Acquérir des outils de diagnostic et de développement de ses capacités de coordinateur d’équipe. ? Maîtriser un modèle qui permet à chaque responsable de tirer le meilleur parti des aptitudes de ses collaborateurs et de maîtriser les principes de fonctionnement et de motivation de l’équipe. ', 'Team Management', NULL, NULL, NULL, NULL, NULL, 'Cette formation ne nécessite pas de prérequis.'),
('Training', 16, NULL, 'La gestion des priorités et la maîtrise des échéances sont des compétences indispensables à l’efficacité et la réussite. Les méthodes et outils de la gestion du temps nécessaires pour permettre à l’individu d\'anticiper et d’organiser au quotidien. Cependant, notre succès à appliquer les méthodes et outils de la gestion du temps dépend fortement de notre fonctionnement intime et de notre façon de percevoir le temps. La formation \"Time Management\" accorde une large place aux dimensions personnelles et relationnelles du temps. Elle permet d’approprier les méthodes et outils éprouvés en tenant compte du contexte et du propre fonctionnement. Elle aide à trouver un équilibre personnel entre la vie professionnelle et la vie privée, et à tenir compte de la gestion de l’énergie dans la gestion du temps.', 'Time Management', NULL, NULL, NULL, NULL, NULL, 'Cette formation ne nécessite pas de prérequis.');

-- --------------------------------------------------------

--
-- Structure de la table `event_photo`
--

CREATE TABLE `event_photo` (
  `photoid` bigint(20) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `event_eventid` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `event_photo`
--

INSERT INTO `event_photo` (`photoid`, `path`, `event_eventid`) VALUES
(1, '/Agri-Business.jpg', 3),
(3, '/Agro-Business0.png', 3),
(4, '/Agro-Business1.png', 3),
(5, '/Agro-Business2.jpg', 3),
(6, '/Agro-Business3.jpg', 3),
(7, '/Agro-Business4.jpg', 3),
(8, '/Agro-Business5.jpg', 3),
(9, '/Agro-Business6.jpg', 3),
(10, '/Comment réussir son recrutement.jpg', 4),
(11, '/CommentRéussirSonRecrutementBEx0.jpg', 4),
(12, '/CommentRéussirSonRecrutementBEx1.jpg', 4),
(13, '/CommentRéussirSonRecrutementBEx2.jpg', 4),
(14, '/CommentRéussirSonRecrutementBEx3.jpg', 4),
(15, '/Community Management.jpeg', 5),
(16, '/CommunityManagement.jpg', 5),
(17, '/Digital Marketing.jpeg', 6),
(18, '/DigitalMarketing.jpg', 6),
(19, '/Event Management.jpg', 7),
(20, '/EventManagement0.jpg', 7),
(21, '/EventManagement1.jpg', 7),
(22, '/EventManagement2.jpg', 7),
(23, '/EventManagement3.jpg', 7),
(24, '/EventManagement4.jpg', 7),
(25, '/EventManagement5.jpg', 7),
(26, '/Initiation Photoshop.jpeg', 8),
(27, '/InitiationPhotoshop0.jpg', 8),
(28, '/InitiationPhotoshop1.jpg', 8),
(29, '/InitiationPhotoshop2.jpg', 8),
(30, '/InitiationPhotoshop3.jpg', 8),
(31, '/Photoshop.jpg', 9),
(32, '/Reussir son entretien.jpg', 10),
(33, '/S.E.O.png', 11),
(34, '/Savoir se positionner sur le marché.jpeg', 12),
(35, '/SePositionnerSurLeMarché0.jpg', 12),
(36, '/SePositionnerSurLeMarché1.jpg', 12),
(37, '/Sponsoring.png', 13),
(38, '/stressManagement1.jpg', 14),
(39, '/stressManagement2.jpg', 14),
(40, '/Team Management.jpg', 15),
(41, '/TeamManagement0.jpg', 15),
(42, '/Time management.jpg', 16),
(43, '/TimeManagement0.jpg', 16),
(44, '/Stress Management.jpg', 14);

-- --------------------------------------------------------

--
-- Structure de la table `member`
--

CREATE TABLE `member` (
  `memberid` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `family` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `office` bit(1) NOT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `quote` varchar(255) DEFAULT NULL,
  `dtype` varchar(31) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `member_photo`
--

CREATE TABLE `member_photo` (
  `photoid` bigint(20) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `member_memberid` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `messageid` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `messagetext` text,
  `subject` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `organizer`
--

CREATE TABLE `organizer` (
  `eventid` bigint(20) NOT NULL,
  `memberid` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `project`
--

CREATE TABLE `project` (
  `projectid` bigint(20) NOT NULL,
  `closing` datetime DEFAULT NULL,
  `description` text,
  `name` varchar(255) DEFAULT NULL,
  `opening` datetime DEFAULT NULL,
  `client_enterpriseid` bigint(20) DEFAULT NULL,
  `academic` bit(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `project`
--

INSERT INTO `project` (`projectid`, `closing`, `description`, `name`, `opening`, `client_enterpriseid`, `academic`) VALUES
(12, '2018-05-09 09:28:56', 'Ce projet consiste à mettre en place un appareil qui aide l’agriculteur à suivre le cumul du besoin en froid des différentes cultures afin de pouvoir s’assurer sur le bon développement de la plante, de suivre les phases de croissance et intervenir dans le moment où il remarque des anomalies dans leur gérmination.', 'Station bioclimatologique', '2017-11-09 09:28:56', 2, b'1'),
(11, NULL, 'Ce projet consiste à cultiver un genre de champignon « pleurote » en utilisant le mycélium et en valorisant le marc de café et les débris de bois qui sont dégradables et bénéfiques pour le bon développement du champignon. Ceci nous permet d’obtenir une culture ayant un goût qui apprécié par les consommateurs. ', 'Culture de champignon ', '2018-04-02 09:28:56', 1, b'1'),
(10, '2018-10-15 09:28:56', 'Afin de remplacer un mur blanc sans spécificités particulières, on peut construire un mur végétal qui soit à la fois esthétique (décorer l’entrée du département) et utilisé pour profiter des apports bénéfiques du mur végétal (amélioration thermique, rafraichissement de l’air…).Un mur végétal est un système de culture qui permet la végétalisation verticale des façades verticales. Les plantes croissent dans un contenant en situation hors sol. ', 'Mur végétal', '2018-10-10 09:28:56', 3, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `project_photo`
--

CREATE TABLE `project_photo` (
  `photoid` bigint(20) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `project_projectid` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `project_photo`
--

INSERT INTO `project_photo` (`photoid`, `path`, `project_projectid`) VALUES
(6, '/Champignon0.jpg', 11),
(5, '/Champignon.jpg', 11),
(4, '/mur vegetal.jpg', 10),
(7, '/Champignon1.jpg', 11),
(8, '/StationBioclimatologique .jpg', 12),
(19, '/StationBioclimatologique .jpg', 12);

-- --------------------------------------------------------

--
-- Structure de la table `trainer`
--

CREATE TABLE `trainer` (
  `eventid` bigint(20) NOT NULL,
  `memberid` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`articleid`);

--
-- Index pour la table `article_photo`
--
ALTER TABLE `article_photo`
  ADD PRIMARY KEY (`photoid`),
  ADD KEY `FKjrs0gxvwmxt0ox23sd49004fc` (`article_articleid`);

--
-- Index pour la table `enterprise`
--
ALTER TABLE `enterprise`
  ADD PRIMARY KEY (`enterpriseid`);

--
-- Index pour la table `enterprise_photo`
--
ALTER TABLE `enterprise_photo`
  ADD PRIMARY KEY (`photoid`),
  ADD KEY `FK5vnv6e0qvtoybpo239qud21pl` (`enterprise_enterpriseid`);

--
-- Index pour la table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`eventid`);

--
-- Index pour la table `event_photo`
--
ALTER TABLE `event_photo`
  ADD PRIMARY KEY (`photoid`),
  ADD KEY `FK12ukllpdd1llin4tdpej206ae` (`event_eventid`);

--
-- Index pour la table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`memberid`);

--
-- Index pour la table `member_photo`
--
ALTER TABLE `member_photo`
  ADD PRIMARY KEY (`photoid`),
  ADD KEY `FKenhvv15mymrlc34o60be2erjp` (`member_memberid`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`messageid`);

--
-- Index pour la table `organizer`
--
ALTER TABLE `organizer`
  ADD PRIMARY KEY (`eventid`,`memberid`),
  ADD KEY `FK72nw12k6m386hprff2ycheyrb` (`memberid`);

--
-- Index pour la table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`projectid`),
  ADD KEY `FKomxbnbxk91ikc5b1w2gcntnvb` (`client_enterpriseid`);

--
-- Index pour la table `project_photo`
--
ALTER TABLE `project_photo`
  ADD PRIMARY KEY (`photoid`),
  ADD KEY `FK7pybnrp0h1yxklxowtynw7gk4` (`project_projectid`);

--
-- Index pour la table `trainer`
--
ALTER TABLE `trainer`
  ADD PRIMARY KEY (`eventid`,`memberid`),
  ADD KEY `FKg3s7qmeiofy5bx5gvuxxwisj0` (`memberid`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `articleid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `article_photo`
--
ALTER TABLE `article_photo`
  MODIFY `photoid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `enterprise`
--
ALTER TABLE `enterprise`
  MODIFY `enterpriseid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `enterprise_photo`
--
ALTER TABLE `enterprise_photo`
  MODIFY `photoid` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `event`
--
ALTER TABLE `event`
  MODIFY `eventid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT pour la table `event_photo`
--
ALTER TABLE `event_photo`
  MODIFY `photoid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT pour la table `member`
--
ALTER TABLE `member`
  MODIFY `memberid` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `member_photo`
--
ALTER TABLE `member_photo`
  MODIFY `photoid` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `messageid` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `project`
--
ALTER TABLE `project`
  MODIFY `projectid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `project_photo`
--
ALTER TABLE `project_photo`
  MODIFY `photoid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
