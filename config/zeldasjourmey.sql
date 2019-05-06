-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Temps de generació: 16-04-2019 a les 11:46:30
-- Versió del servidor: 10.3.14-MariaDB
-- Versió de PHP: 7.3.2

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

CREATE TABLE `Armas` (
  `Id_Arma` int(2) PRIMARY KEY AUTO_INCREMENT ,
  `nombre` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `tipo` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ataque` decimal(2,2) NOT NULL,
  `fuerza` int(2) NOT NULL,
  `movimiento` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Arma_partida`
--

CREATE TABLE `Arma_partida` (
  `Fk_id_arma` int(2) NOT NULL,
  `Fk_id_Partida` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Artefacto`
--

CREATE TABLE `Artefacto` (
  `Id_artefacto` int(2) PRIMARY KEY AUTO_INCREMENT ,
  `nombre` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Descripcion` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `tipo` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ataque` decimal(2,0) NOT NULL,
  `fuerza` int(2) NOT NULL,
  `movimiento` int(2) NOT NULL,
  `movimiento_turno` int(2) NOT NULL,
  `nivel` int(2) NOT NULL,
  `resistencia` decimal(2,2) NOT NULL,
  `Super_ataque` int(2) NOT NULL,
  `vida` int(2) NOT NULL,
  `vida_Gastar` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Artefacto_Enemigo`
--

CREATE TABLE `Artefacto_Enemigo` (
  `Id_Artefacto_Enemigo` int(2) PRIMARY KEY  AUTO_INCREMENT ,
  `vida` int(11) NOT NULL,
  `resistencia` decimal(3,0) NOT NULL,
  `movimiento` int(11) NOT NULL,
  `ataque` decimal(3,0) NOT NULL,
  `fuerza` int(11) NOT NULL,
  `vida_gastar` int(11) NOT NULL,
  `movimiento_turno` int(11) NOT NULL,
  `super_ataque` int(11) NOT NULL,
  `experiencia` int(11) NOT NULL,
  `nombre` varchar(15) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Artefacto_Enemigo_partida`
--

CREATE TABLE `Artefacto_Enemigo_partida` (
  `fk_id_artefacto_enemigo` int(2) NOT NULL,
  `Fk_id_partida` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Artefacto_Partida`
--

CREATE TABLE `Artefacto_Partida` (
  `Fk_id_partida` int(7) NOT NULL,
  `fk_id_artefacto` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Enemigo_comun`
--

CREATE TABLE `Enemigo_comun` (
  `id_enemigo_comun` int(2) PRIMARY KEY  AUTO_INCREMENT ,
  `ataque` int(11) NOT NULL,
  `experiencia` int(20) NOT NULL,
  `movimiento` int(3) NOT NULL,
  `movimientoTurno` int(3) NOT NULL,
  `muerto` tinyint(1) NOT NULL,
  `n_ataques` int(2) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `resistencia` decimal(10,0) NOT NULL,
  `turno` tinyint(1) NOT NULL,
  `vida` int(4) NOT NULL,
  `vida_gastar` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Estructura de la taula `Enemigo_Comun_partida`
--

CREATE TABLE `Enemigo_Comun_partida` (
  `Fk_id_enemigo_comun` int(2) NOT NULL,
  `Fk_id_partida` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Estructura de la taula `Enemigo_Jefe`
--

CREATE TABLE `Enemigo_Jefe` (
  `id_Enemigo_Jefe` int(10) PRIMARY KEY  AUTO_INCREMENT,
  `ataque` int(11) NOT NULL,
  `experiencia` int(20) NOT NULL,
  `movimiento` int(3) NOT NULL,
  `movimientoTurno` int(3) NOT NULL,
  `muerto` tinyint(1) NOT NULL,
  `n_ataques` int(2) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `resistencia` decimal(10,0) NOT NULL,
  `turno` tinyint(1) NOT NULL,
  `vida` int(4) NOT NULL,
  `vida_gastar` int(4) NOT NULL,
  `Super_ataque` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Estructura de la taula `Enemigo_Jefe_partida`
--

CREATE TABLE `Enemigo_Jefe_partida` (
  `fk_id_enemigo_jefe` int(2) NOT NULL,
  `fk_id_partida` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Escudo`
--

CREATE TABLE `Escudo` (
  `Id_escudo` int(2) PRIMARY KEY  AUTO_INCREMENT ,
  `nombre` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `tipo` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Descripcion` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `Ataque` decimal(2,2) NOT NULL,
  `Movimiento` int(2) NOT NULL,
  `Resistencia` decimal(2,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Escudo_partida`
--

CREATE TABLE `Escudo_partida` (
  `Fk_id_escudo` int(2) NOT NULL,
  `Fk_id_partida` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Heroe`
--

CREATE TABLE `Heroe` (
  `id_Heroe` int(10) PRIMARY KEY  AUTO_INCREMENT ,
  `FK_ID_Usuario` int(6) NOT NULL,
  `ataque` decimal(10,0) NOT NULL,
  `experiencia` int(20) NOT NULL,
  `movimiento` int(3) NOT NULL,
  `movimientoTurno` int(3) NOT NULL,
  `muerto` tinyint(1) NOT NULL,
  `n_ataques` int(2) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `resistencia` decimal(10,0) NOT NULL,
  `turno` tinyint(1) NOT NULL,
  `vida` int(4) NOT NULL,
  `vida_gastar` int(4) NOT NULL,
  `Super_ataque` int(1) NOT NULL,
  `Fk_id_arma` int(2) DEFAULT NULL,
  `Fk_id_escudo` int(2) DEFAULT NULL,
  `FK_id_artefacto` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Heroe_Partida`
--

CREATE TABLE `Heroe_Partida` (
  `Fk_id_Heroe` int(10) NOT NULL,
  `Fk_id_Partida` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Partida`
--

CREATE TABLE `Partida` (
  `Id_partida` int(7) PRIMARY KEY  AUTO_INCREMENT ,
  `nombre` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Descripcion` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de la taula `Usuario`
--

CREATE TABLE `Usuario` (
  `Id_Usuario` int(6) PRIMARY KEY  AUTO_INCREMENT ,
  `Fecha_Ingreso` date NOT NULL,
  `Nick` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Nombre` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Apellido` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Índexs per a les taules bolcades
--



--
-- Índexs per a la taula `Arma_partida`
--
ALTER TABLE `Arma_partida`
  ADD KEY `Fk_id_arma` (`Fk_id_arma`);




--
-- Índexs per a la taula `Artefacto_Enemigo_partida`
--
ALTER TABLE `Artefacto_Enemigo_partida`
  ADD KEY `fk_id_artefacto_enemigo` (`fk_id_artefacto_enemigo`),
  ADD KEY `Fk_id_partida` (`Fk_id_partida`);

--
-- Índexs per a la taula `Artefacto_Partida`
--
ALTER TABLE `Artefacto_Partida`
  ADD KEY `fk_id_artefacto` (`fk_id_artefacto`),
  ADD KEY `Fk_id_partida` (`Fk_id_partida`);


--
-- Índexs per a la taula `Enemigo_Comun_partida`
--
ALTER TABLE `Enemigo_Comun_partida`
  ADD KEY `Fk_id_enemigo_comun` (`Fk_id_enemigo_comun`),
  ADD KEY `Fk_id_partida` (`Fk_id_partida`);



--
-- Índexs per a la taula `Enemigo_Jefe_partida`
--
ALTER TABLE `Enemigo_Jefe_partida`
  ADD KEY `fk_id_enemigo_jefe` (`fk_id_enemigo_jefe`),
  ADD KEY `fk_id_partida` (`fk_id_partida`);



--
-- Índexs per a la taula `Escudo_partida`
--
ALTER TABLE `Escudo_partida`
  ADD KEY `Fk_id_escudo` (`Fk_id_escudo`),
  ADD KEY `Fk_id_partida` (`Fk_id_partida`);

--
-- Índexs per a la taula `Heroe`
--
ALTER TABLE `Heroe`
  
  ADD KEY `FK_ID_Usuario` (`FK_ID_Usuario`),
  ADD KEY `Fk_id_arma` (`Fk_id_arma`),
  ADD KEY `FK_id_artefacto` (`FK_id_artefacto`),
  ADD KEY `Fk_id_escudo` (`Fk_id_escudo`),
  ADD CONSTRAINT uk_heroe_id_usuario_nombre UNIQUE(fk_id_usuario, nombre);

--
-- Índexs per a la taula `Heroe_Partida`
--
ALTER TABLE `Heroe_Partida`
  ADD KEY `Fk_id_Heroe` (`Fk_id_Heroe`),
  ADD KEY `Fk_id_Partida` (`Fk_id_Partida`);



--
-- Índexs per a la taula `Usuario`
--
ALTER TABLE `Usuario`
  
  ADD CONSTRAINT uk_usuario_nick UNIQUE(nick);

--
-- Restriccions per a les taules bolcades
--

--
-- Restriccions per a la taula `Arma_partida`
--
ALTER TABLE `Arma_partida`
  ADD CONSTRAINT `Arma_partida_ibfk_1` FOREIGN KEY (`Fk_id_arma`) REFERENCES `Armas` (`Id_Arma`);

--
-- Restriccions per a la taula `Artefacto_Enemigo_partida`
--
ALTER TABLE `Artefacto_Enemigo_partida`
  ADD CONSTRAINT `Artefacto_Enemigo_partida_ibfk_1` FOREIGN KEY (`fk_id_artefacto_enemigo`) REFERENCES `Artefacto_Enemigo` (`Id_Artefacto_Enemigo`),
  ADD CONSTRAINT `Artefacto_Enemigo_partida_ibfk_2` FOREIGN KEY (`Fk_id_partida`) REFERENCES `Partida` (`Id_partida`);

--
-- Restriccions per a la taula `Artefacto_Partida`
--
ALTER TABLE `Artefacto_Partida`
  ADD CONSTRAINT `Artefacto_Partida_ibfk_1` FOREIGN KEY (`fk_id_artefacto`) REFERENCES `Artefacto` (`Id_artefacto`),
  ADD CONSTRAINT `Artefacto_Partida_ibfk_2` FOREIGN KEY (`Fk_id_partida`) REFERENCES `Partida` (`Id_partida`),
  ADD CONSTRAINT `Artefacto_Partida_ibfk_3` FOREIGN KEY (`Fk_id_partida`) REFERENCES `Partida` (`Id_partida`);

--
-- Restriccions per a la taula `Enemigo_Comun_partida`
--
ALTER TABLE `Enemigo_Comun_partida`
  ADD CONSTRAINT `Enemigo_Comun_partida_ibfk_1` FOREIGN KEY (`Fk_id_enemigo_comun`) REFERENCES `Enemigo_comun` (`id_enemigo_comun`),
  ADD CONSTRAINT `Enemigo_Comun_partida_ibfk_2` FOREIGN KEY (`Fk_id_partida`) REFERENCES `Partida` (`Id_partida`);

--
-- Restriccions per a la taula `Enemigo_Jefe_partida`
--
ALTER TABLE `Enemigo_Jefe_partida`
  ADD CONSTRAINT `Enemigo_Jefe_partida_ibfk_1` FOREIGN KEY (`fk_id_enemigo_jefe`) REFERENCES `Enemigo_Jefe` (`id_Enemigo_Jefe`),
  ADD CONSTRAINT `Enemigo_Jefe_partida_ibfk_2` FOREIGN KEY (`fk_id_partida`) REFERENCES `Partida` (`Id_partida`);

--
-- Restriccions per a la taula `Escudo_partida`
--
ALTER TABLE `Escudo_partida`
  ADD CONSTRAINT `Escudo_partida_ibfk_1` FOREIGN KEY (`Fk_id_escudo`) REFERENCES `Escudo` (`Id_escudo`),
  ADD CONSTRAINT `Escudo_partida_ibfk_2` FOREIGN KEY (`Fk_id_partida`) REFERENCES `Partida` (`Id_partida`);

--
-- Restriccions per a la taula `Heroe`
--
ALTER TABLE `Heroe`
  ADD CONSTRAINT `Heroe_ibfk_1` FOREIGN KEY (`FK_ID_Usuario`) REFERENCES `Usuario` (`Id_Usuario`),
  ADD CONSTRAINT `Heroe_ibfk_2` FOREIGN KEY (`Fk_id_arma`) REFERENCES `Armas` (`Id_Arma`),
  ADD CONSTRAINT `Heroe_ibfk_3` FOREIGN KEY (`FK_id_artefacto`) REFERENCES `Artefacto` (`Id_artefacto`),
  ADD CONSTRAINT `Heroe_ibfk_4` FOREIGN KEY (`Fk_id_escudo`) REFERENCES `Escudo` (`Id_escudo`);

--
-- Restriccions per a la taula `Heroe_Partida`
--
ALTER TABLE `Heroe_Partida`
  ADD CONSTRAINT `Heroe_Partida_ibfk_1` FOREIGN KEY (`Fk_id_Heroe`) REFERENCES `Heroe` (`id_Heroe`),
  ADD CONSTRAINT `Heroe_Partida_ibfk_2` FOREIGN KEY (`Fk_id_Partida`) REFERENCES `Partida` (`Id_partida`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
