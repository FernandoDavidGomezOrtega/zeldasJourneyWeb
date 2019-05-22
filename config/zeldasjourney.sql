
-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Temps de generaciï¿½: 16-04-2019 a les 11:46:30
-- Versiï¿½ del servidor: 10.3.14-MariaDB
-- Versiï¿½ de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `id5411527_zaldasjourney`
--

-- --------------------------------------------------------



--
-- Estructura de la taula `Armas`
--

CREATE TABLE `ARMAS` (
  `Id_Arma` int(2) PRIMARY KEY AUTO_INCREMENT ,
  `nombre` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `tipo` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ATAQUE` decimal(2,2) NOT NULL,
  `fuerza` int(2) NOT NULL,
  `movimiento` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Arma_partida`
--

CREATE TABLE `ARMA_PARTIDA` (
  `Fk_id_arma` int(2) NOT NULL,
  `Fk_id_Partida` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Artefacto`
--

CREATE TABLE `ARTEFACTO` (
  `Id_artefacto` int(2) PRIMARY KEY AUTO_INCREMENT ,
  `nombre` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Descripcion` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `tipo` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ATAQUE` decimal(4,2) NOT NULL,
  `fuerza` int(2) NOT NULL,
  `movimiento` int(2) NOT NULL,
  `movimiento_turno` int(2) NOT NULL,
  `nivel` int(2) NOT NULL,
  `resistencia` decimal(4,2) NOT NULL,
  `Super_ataque` int(2) NOT NULL,
  `vida` int(2) NOT NULL,
  `vida_Gastar` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Artefacto_Enemigo`
--

CREATE TABLE `ARTEFACTO_ENEMIGO` (
  `Id_Artefacto_Enemigo` int(2) PRIMARY KEY  AUTO_INCREMENT ,
  `vida` int(11) NOT NULL,
  `resistencia` decimal(4,2) NOT NULL,
  `movimiento` int(11) NOT NULL,
  `ATAQUE` decimal(4,2) NOT NULL,
  `fuerza` int(11) NOT NULL,
  `vida_gastar` int(11) NOT NULL,
  `movimiento_turno` int(11) NOT NULL,
  `super_ataque` int(11) NOT NULL,
  `EXPERIENCIA` int(11) NOT NULL,
  `nombre` varchar(15) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Artefacto_Enemigo_partida`
--

CREATE TABLE `ARTEFACTO_ENEMIGO_PARTIDA` (
  `fk_id_artefacto_enemigo` int(2) NOT NULL,
  `Fk_id_partida` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Artefacto_Partida`
--

CREATE TABLE `ARTEFACTO_PARTIDA` (
  `Fk_id_partida` int(7) NOT NULL,
  `fk_id_artefacto` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Enemigo_comun`
--

CREATE TABLE `ENEMIGO_COMUN` (
  `ENEMIGO_COMUN_ID` int(2) PRIMARY KEY  AUTO_INCREMENT ,
  `ENEMIGO_COMUN_ATAQUE` decimal(4,2) NOT NULL,
  `experiencia` int(20) NOT NULL,
  `movimiento` int(3) NOT NULL,
  `movimientoTurno` int(3) NOT NULL,
  `muerto` tinyint(1) NOT NULL,
  `n_ataques` int(2) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `resistencia` decimal(4,2) NOT NULL,
  `turno` tinyint(1) NOT NULL,
  `vida` int(4) NOT NULL,
  `vida_gastar` int(4) NOT NULL, 
  `avatar_enemigo_comun` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Estructura de la taula `Enemigo_Comun_partida`
--

CREATE TABLE `ENEMIGO_COMUN_PARTIDA` (
  `Fk_id_enemigo_comun` int(2) NOT NULL,
  `Fk_id_partida` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Estructura de la taula `Enemigo_Jefe`
--

CREATE TABLE `ENEMIGO_JEFE` (
  `id_Enemigo_Jefe` int(10) PRIMARY KEY  AUTO_INCREMENT,
  `ATAQUE` decimal(4,2) NOT NULL,
  `experiencia` int(20) NOT NULL,
  `movimiento` int(3) NOT NULL,
  `movimientoTurno` int(3) NOT NULL,
  `muerto` tinyint(1) NOT NULL,
  `n_ataques` int(2) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `resistencia` decimal(4,2) NOT NULL,
  `turno` tinyint(1) NOT NULL,
  `vida` int(4) NOT NULL,
  `vida_gastar` int(4) NOT NULL,
  `Super_ataque` int(1) NOT NULL,
  `avatar_enemigo_jefe` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Estructura de la taula `Enemigo_Jefe_partida`
--

CREATE TABLE `ENEMIGO_JEFE_PARTIDA` (
  `fk_id_enemigo_jefe` int(2) NOT NULL,
  `fk_id_partida` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Escudo`
--

CREATE TABLE `ESCUDO` (
  `Id_escudo` int(2) PRIMARY KEY  AUTO_INCREMENT ,
  `nombre` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `tipo` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Descripcion` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `ATAQUE` decimal(2,2) NOT NULL,
  `Movimiento` int(2) NOT NULL,
  `Resistencia` decimal(2,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Escudo_partida`
--

CREATE TABLE `ESCUDO_PARTIDA` (
  `Fk_id_escudo` int(2) NOT NULL,
  `Fk_id_partida` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `HEROE`
--

CREATE TABLE `HEROE` (
  `HEROE_ID` int(10) PRIMARY KEY  AUTO_INCREMENT ,
  `HEROE_USUARIO_ID` int(6) NOT NULL,
  `HEROE_ATAQUE` decimal(4,2) NOT NULL,
  `HEROE_EXPERIENCIA` int(20) NOT NULL,
  `HEROE_MOVIMIENTO` int(3) NOT NULL,
  `HEROE_MOVIMIENTO_TURNO` int(3) NOT NULL,
  `HEROE_MUERTO` tinyint(1) NOT NULL,
  `HEROE_N_ATAQUES` int(2) NOT NULL,
  `HEROE_NOMBRE` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `HEROE_DESCRPCION` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HEROE_SUPER_PODER_1` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HEROE_SUPER_PODER_2` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HEROE_RESISTENCIA` decimal(4,2) NOT NULL,
  `HEROE_TURNO` tinyint(1) NOT NULL,
  `HEROE_VIDA` int(4) NOT NULL,
  `HEROE_VIDA_GASTAR` int(4) NOT NULL,
  `HEROE_SUPER_ATAQUE` int(1) NOT NULL,
  `HEROE_FUERZA` int(4) NOT NULL,
  `HEROE_AVATAR` varchar(100) DEFAULT NULL,
  `HEROE_ARMA_ID` int(2) DEFAULT NULL,
  `HEROE_ESCUDO_ID` int(2) DEFAULT NULL,
  `HEROE_ARTEFACTO_ID` int(2) DEFAULT NULL,
  HEROE_PLANTILLA_HEROE_ID int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- -----------------------------------------------------------
--
-- Estructura de la taula `PLANTILLA_HEROE`
--

CREATE TABLE `PLANTILLA_HEROE` (
  `PLANTILLA_HEROE_ID` int(10) PRIMARY KEY  AUTO_INCREMENT ,
  `PLANTILLA_HEROE_ATAQUE` decimal(4,2) NOT NULL,
  `PLANTILLA_HEROE_MOVIMIENTO` int(3) NOT NULL,
  `PLANTILLA_HEROE_MOVIMIENTO_TURNO` int(3) NOT NULL,
  `PLANTILLA_HEROE_N_ATAQUES` int(2) NOT NULL,
  `PLANTILLA_HEROE_NOMBRE` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `PLANTILLA_HEROE_DESCRIPCION` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PLANTILLA_HEROE_SUPER_PODER_1` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PLANTILLA_HEROE_SUPER_PODER_2` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PLANTILLA_HEROE_RESISTENCIA` decimal(4,2) NOT NULL,
  `PLANTILLA_HEROE_VIDA` int(4) NOT NULL,
  `PLANTILLA_HEROE_VIDA_GASTAR` int(4) NOT NULL,
  `PLANTILLA_HEROE_SUPER_ATAQUE` int(1) NOT NULL,
  `PLANTILLA_HEROE_FUERZA` int(4) NOT NULL,
  `PLANTILLA_HEROE_AVATAR` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Heroe_Partida`
--

CREATE TABLE `HEROE_PARTIDA` (
  `Fk_id_Heroe` int(10) NOT NULL,
  `Fk_id_Partida` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Partida`
--

CREATE TABLE `PARTIDA` (
  `Id_partida` int(7) PRIMARY KEY  AUTO_INCREMENT ,
  `nombre` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Descripcion` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Usuario`
--

CREATE TABLE `USUARIO` (
  `USUARIO_ID` int(6) PRIMARY KEY  AUTO_INCREMENT ,
  `USUARIO_FECHA_INGRESO` date NOT NULL,
  `USUARIO_NICK` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `USUARIO_PASSWORD` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `USUARIO_NOMBRE` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `USUARIO_APELLIDO` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- ï¿½ndexs per a les taules bolcades
--



--
-- ï¿½ndexs per a la taula `Arma_partida`
--
ALTER TABLE `ARMA_PARTIDA`
  ADD KEY `Fk_id_arma` (`Fk_id_arma`);




--
-- ï¿½ndexs per a la taula `Artefacto_Enemigo_partida`
--
ALTER TABLE `ARTEFACTO_ENEMIGO_PARTIDA`
  ADD KEY `fk_id_artefacto_enemigo` (`fk_id_artefacto_enemigo`),
  ADD KEY `Fk_id_partida` (`Fk_id_partida`);

--
-- ï¿½ndexs per a la taula `Artefacto_Partida`
--
ALTER TABLE `ARTEFACTO_PARTIDA`
  ADD KEY `fk_id_artefacto` (`fk_id_artefacto`),
  ADD KEY `Fk_id_partida` (`Fk_id_partida`);


--
-- ï¿½ndexs per a la taula `Enemigo_Comun_partida`
--
ALTER TABLE `ENEMIGO_COMUN_PARTIDA`
  ADD KEY `Fk_id_enemigo_comun` (`Fk_id_enemigo_comun`),
  ADD KEY `Fk_id_partida` (`Fk_id_partida`);



--
-- ï¿½ndexs per a la taula `Enemigo_Jefe_partida`
--
ALTER TABLE `ENEMIGO_JEFE_PARTIDA`
  ADD KEY `fk_id_enemigo_jefe` (`fk_id_enemigo_jefe`),
  ADD KEY `fk_id_partida` (`fk_id_partida`);



--
-- ï¿½ndexs per a la taula `Escudo_partida`
--
ALTER TABLE `ESCUDO_PARTIDA`
  ADD KEY `Fk_id_escudo` (`Fk_id_escudo`),
  ADD KEY `Fk_id_partida` (`Fk_id_partida`);

--
-- ï¿½ndexs per a la taula `HEROE`
--
ALTER TABLE `HEROE`
  
  ADD KEY `fk_heroe_usuario_id` (`HEROE_USUARIO_ID`),
  ADD KEY `Fk_id_arma` (`HEROE_ARMA_ID`),
  ADD KEY `FK_id_artefacto` (`HEROE_ARTEFACTO_ID`),
  ADD KEY `Fk_id_escudo` (`HEROE_ESCUDO_ID`),
  ADD CONSTRAINT `fk_heroe_plantilla` foreign key(HEROE_PLANTILLA_HEROE_ID) references PLANTILLA_HEROE(PLANTILLA_HEROE_ID),
  ADD CONSTRAINT uk_heroe_id_usuario_nombre UNIQUE(HEROE_USUARIO_ID, HEROE_NOMBRE);

--
-- ï¿½ndexs per a la taula `Heroe_Partida`
--
ALTER TABLE `HEROE_PARTIDA`
  ADD KEY `Fk_id_Heroe` (`Fk_id_Heroe`),
  ADD KEY `Fk_id_Partida` (`Fk_id_Partida`);



--
-- ï¿½ndexs per a la taula `Usuario`
--
ALTER TABLE `USUARIO`
  
  ADD CONSTRAINT uk_usuario_nick UNIQUE(USUARIO_NICK);

--
-- Restriccions per a les taules bolcades
--

--
-- Restriccions per a la taula `Arma_partida`
--
ALTER TABLE `ARMA_PARTIDA`
  ADD CONSTRAINT `Arma_partida_ibfk_1` FOREIGN KEY (`Fk_id_arma`) REFERENCES `Armas` (`Id_Arma`);

--
-- Restriccions per a la taula `Artefacto_Enemigo_partida`
--
ALTER TABLE `ARTEFACTO_ENEMIGO_PARTIDA`
  ADD CONSTRAINT `Artefacto_Enemigo_partida_ibfk_1` FOREIGN KEY (`fk_id_artefacto_enemigo`) REFERENCES `Artefacto_Enemigo` (`Id_Artefacto_Enemigo`),
  ADD CONSTRAINT `Artefacto_Enemigo_partida_ibfk_2` FOREIGN KEY (`Fk_id_partida`) REFERENCES `Partida` (`Id_partida`);

--
-- Restriccions per a la taula `Artefacto_Partida`
--
ALTER TABLE `ARTEFACTO_PARTIDA`
  ADD CONSTRAINT `Artefacto_Partida_ibfk_1` FOREIGN KEY (`fk_id_artefacto`) REFERENCES `Artefacto` (`Id_artefacto`),
  ADD CONSTRAINT `Artefacto_Partida_ibfk_2` FOREIGN KEY (`Fk_id_partida`) REFERENCES `Partida` (`Id_partida`),
  ADD CONSTRAINT `Artefacto_Partida_ibfk_3` FOREIGN KEY (`Fk_id_partida`) REFERENCES `Partida` (`Id_partida`);

--
-- Restriccions per a la taula `Enemigo_Comun_partida`
--
ALTER TABLE `ENEMIGO_COMUN_PARTIDA`
  ADD CONSTRAINT `Enemigo_Comun_partida_ibfk_1` FOREIGN KEY (`Fk_id_enemigo_comun`) REFERENCES `ENEMIGO_COMUN` (`ENEMIGO_COMUN_ID`),
  ADD CONSTRAINT `Enemigo_Comun_partida_ibfk_2` FOREIGN KEY (`Fk_id_partida`) REFERENCES `Partida` (`Id_partida`);

--
-- Restriccions per a la taula `Enemigo_Jefe_partida`
--
ALTER TABLE `ENEMIGO_JEFE_PARTIDA`
  ADD CONSTRAINT `Enemigo_Jefe_partida_ibfk_1` FOREIGN KEY (`fk_id_enemigo_jefe`) REFERENCES `Enemigo_Jefe` (`id_Enemigo_Jefe`),
  ADD CONSTRAINT `Enemigo_Jefe_partida_ibfk_2` FOREIGN KEY (`fk_id_partida`) REFERENCES `Partida` (`Id_partida`);

--
-- Restriccions per a la taula `Escudo_partida`
--
ALTER TABLE `ESCUDO_PARTIDA`
  ADD CONSTRAINT `Escudo_partida_ibfk_1` FOREIGN KEY (`Fk_id_escudo`) REFERENCES `Escudo` (`Id_escudo`),
  ADD CONSTRAINT `Escudo_partida_ibfk_2` FOREIGN KEY (`Fk_id_partida`) REFERENCES `Partida` (`Id_partida`);

--
-- Restriccions per a la taula `HEROE`
--
ALTER TABLE `HEROE`
  ADD CONSTRAINT `Heroe_ibfk_1` FOREIGN KEY (`HEROE_USUARIO_ID`) REFERENCES `USUARIO` (`USUARIO_ID`),
  ADD CONSTRAINT `Heroe_ibfk_2` FOREIGN KEY (`HEROE_ARMA_ID`) REFERENCES `Armas` (`Id_Arma`),
  ADD CONSTRAINT `Heroe_ibfk_3` FOREIGN KEY (`HEROE_ARTEFACTO_ID`) REFERENCES `Artefacto` (`Id_artefacto`),
  ADD CONSTRAINT `Heroe_ibfk_4` FOREIGN KEY (`HEROE_ESCUDO_ID`) REFERENCES `Escudo` (`Id_escudo`);

--
-- Restriccions per a la taula `Heroe_Partida`
--
ALTER TABLE `HEROE_PARTIDA`
  ADD CONSTRAINT `Heroe_Partida_ibfk_1` FOREIGN KEY (`Fk_id_Heroe`) REFERENCES `HEROE` (`HEROE_ID`),
  ADD CONSTRAINT `Heroe_Partida_ibfk_2` FOREIGN KEY (`Fk_id_Partida`) REFERENCES `Partida` (`Id_partida`);

--
-- Inserts in tabla PLANTILLA_HEROE
--

insert INTO PLANTILLA_HEROE(PLANTILLA_HEROE_ATAQUE, PLANTILLA_HEROE_MOVIMIENTO, PLANTILLA_HEROE_MOVIMIENTO_TURNO, PLANTILLA_HEROE_N_ATAQUES, PLANTILLA_HEROE_NOMBRE, PLANTILLA_HEROE_DESCRIPCION, PLANTILLA_HEROE_SUPER_PODER_1, PLANTILLA_HEROE_SUPER_PODER_2, PLANTILLA_HEROE_RESISTENCIA, PLANTILLA_HEROE_VIDA, PLANTILLA_HEROE_VIDA_GASTAR, PLANTILLA_HEROE_SUPER_ATAQUE, PLANTILLA_HEROE_FUERZA, PLANTILLA_HEROE_AVATAR) 
    values(2.2, 2, 3, 3, "Capitán América", "Luchando por la justicia después de haber estado congelado durante muchos años. En un mundo en guerra siempre es fiel a sus ideales.", "Super resistencia", "Escudo proyectil", 2.2, 3, 2, 2, 2, "images/capitan_america.jpg");

insert INTO PLANTILLA_HEROE(PLANTILLA_HEROE_ATAQUE, PLANTILLA_HEROE_MOVIMIENTO, PLANTILLA_HEROE_MOVIMIENTO_TURNO, PLANTILLA_HEROE_N_ATAQUES, PLANTILLA_HEROE_NOMBRE, PLANTILLA_HEROE_DESCRIPCION, PLANTILLA_HEROE_SUPER_PODER_1, PLANTILLA_HEROE_SUPER_PODER_2, PLANTILLA_HEROE_RESISTENCIA, PLANTILLA_HEROE_VIDA, PLANTILLA_HEROE_VIDA_GASTAR, PLANTILLA_HEROE_SUPER_ATAQUE, PLANTILLA_HEROE_FUERZA, PLANTILLA_HEROE_AVATAR) 
    values(1.9, 3, 4, 2, "Astro Boy", "Viene del futuro y está dispuesto a ayudar a la humanidad. Controla todas les tecnologías cibernéticas y de fusión nuclear.", "Super velocidad", "Viajes interplanetarios", 1.8, 1, 3, 4, 3, "images/astro-boy.png");

insert INTO PLANTILLA_HEROE(PLANTILLA_HEROE_ATAQUE, PLANTILLA_HEROE_MOVIMIENTO, PLANTILLA_HEROE_MOVIMIENTO_TURNO, PLANTILLA_HEROE_N_ATAQUES, PLANTILLA_HEROE_NOMBRE, PLANTILLA_HEROE_DESCRIPCION, PLANTILLA_HEROE_SUPER_PODER_1, PLANTILLA_HEROE_SUPER_PODER_2, PLANTILLA_HEROE_RESISTENCIA, PLANTILLA_HEROE_VIDA, PLANTILLA_HEROE_VIDA_GASTAR, PLANTILLA_HEROE_SUPER_ATAQUE, PLANTILLA_HEROE_FUERZA, PLANTILLA_HEROE_AVATAR) 
    values(2.1, 4, 5, 1, "Gladiator", "Viene del antiguo imperio romano. Su fuerza descomunal lo convierte en un enemigo temible. No tiene miedo a nada.", "Super fuerza", "Resistencia máxima", 2.8, 4, 1, 3, 2, "images/gladiator.jpg");

insert INTO PLANTILLA_HEROE(PLANTILLA_HEROE_ATAQUE, PLANTILLA_HEROE_MOVIMIENTO, PLANTILLA_HEROE_MOVIMIENTO_TURNO, PLANTILLA_HEROE_N_ATAQUES, PLANTILLA_HEROE_NOMBRE, PLANTILLA_HEROE_DESCRIPCION, PLANTILLA_HEROE_SUPER_PODER_1, PLANTILLA_HEROE_SUPER_PODER_2, PLANTILLA_HEROE_RESISTENCIA, PLANTILLA_HEROE_VIDA, PLANTILLA_HEROE_VIDA_GASTAR, PLANTILLA_HEROE_SUPER_ATAQUE, PLANTILLA_HEROE_FUERZA, PLANTILLA_HEROE_AVATAR) 
    values(1.5, 1, 4, 5, "Super Woman", "Viene de otra dimensión donde el planeta Kripton pudo ser salvado de su destrucción. Atrapada en éste universo decide unirse a los superhéroes para cuidar la galaxia.", "Viajes multiverso", "Telepatía", 2.5, 1, 5, 6, 4, "images/super_woman.jpg");

insert INTO PLANTILLA_HEROE(PLANTILLA_HEROE_ATAQUE, PLANTILLA_HEROE_MOVIMIENTO, PLANTILLA_HEROE_MOVIMIENTO_TURNO, PLANTILLA_HEROE_N_ATAQUES, PLANTILLA_HEROE_NOMBRE, PLANTILLA_HEROE_DESCRIPCION, PLANTILLA_HEROE_SUPER_PODER_1, PLANTILLA_HEROE_SUPER_PODER_2, PLANTILLA_HEROE_RESISTENCIA, PLANTILLA_HEROE_VIDA, PLANTILLA_HEROE_VIDA_GASTAR, PLANTILLA_HEROE_SUPER_ATAQUE, PLANTILLA_HEROE_FUERZA, PLANTILLA_HEROE_AVATAR) 
    values(2.9, 4, 4, 4, "Link", "Es un gran espadachín, arquero, jinete, ejecutante musical, y tiene una gran habilidad para el combate en modo duelo. El más hábil de todos.", "Super astucia", "Diseño de trampas", 1.3, 4, 6, 4, 2, "images/link2.jpg");

insert INTO PLANTILLA_HEROE(PLANTILLA_HEROE_ATAQUE, PLANTILLA_HEROE_MOVIMIENTO, PLANTILLA_HEROE_MOVIMIENTO_TURNO, PLANTILLA_HEROE_N_ATAQUES, PLANTILLA_HEROE_NOMBRE, PLANTILLA_HEROE_DESCRIPCION, PLANTILLA_HEROE_SUPER_PODER_1, PLANTILLA_HEROE_SUPER_PODER_2, PLANTILLA_HEROE_RESISTENCIA, PLANTILLA_HEROE_VIDA, PLANTILLA_HEROE_VIDA_GASTAR, PLANTILLA_HEROE_SUPER_ATAQUE, PLANTILLA_HEROE_FUERZA, PLANTILLA_HEROE_AVATAR) 
    values(3.2, 6, 6, 2, "Robot Z-Storm", "Construído como un proyecto secreto del Pentágono, Z-Storm utiliza su inteligencia artificial para empatizar con los seres humanos y socorrer en catástrofes naturales. Esta vez está dispuesto a todo en The Challenge.", "Casi indestructible", "Rayo aniquilador", 3.2, 1, 3, 3, 4, "images/robot_heroe.png");

--
-- inserts en tabla Enemigo_comun
--
insert INTO Enemigo_comun (ENEMIGO_COMUN_ATAQUE, experiencia, movimiento, movimientoTurno, muerto, n_ataques, nombre, resistencia, turno, vida, vida_gastar)
  values(1.2, 0, 2, 2, 0, 3, "Zombie", 1.2, 1, 3, 3);

insert INTO Enemigo_comun (ENEMIGO_COMUN_ATAQUE, experiencia, movimiento, movimientoTurno, muerto, n_ataques, nombre, resistencia, turno, vida, vida_gastar)
  values(1.2, 0, 2, 2, 0, 3, "Frankenstein", 1.2, 1, 3, 3);

insert INTO Enemigo_comun (ENEMIGO_COMUN_ATAQUE, experiencia, movimiento, movimientoTurno, muerto, n_ataques, nombre, resistencia, turno, vida, vida_gastar)
  values(1.2, 0, 2, 2, 0, 3, "Muerte", 1.2, 1, 3, 3);

insert INTO Enemigo_comun (ENEMIGO_COMUN_ATAQUE, experiencia, movimiento, movimientoTurno, muerto, n_ataques, nombre, resistencia, turno, vida, vida_gastar)
  values(1.2, 0, 2, 2, 0, 3, "Nï¿½mesis", 1.2, 1, 3, 3);

COMMIT;
    

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
