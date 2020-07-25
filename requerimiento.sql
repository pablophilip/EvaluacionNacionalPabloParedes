-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-07-2020 a las 20:23:51
-- Versión del servidor: 10.3.16-MariaDB
-- Versión de PHP: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `requerimiento`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignar`
--

CREATE TABLE `asignar` (
  `id_asignar` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `id_departamento` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_requerimiento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `id_gerencia` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_requerimiento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encargado`
--

CREATE TABLE `encargado` (
  `id_encargado` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `id_departamento` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_requerimiento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `id_estado` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gerencia`
--

CREATE TABLE `gerencia` (
  `id_gerencia` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_requimiento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `requirimiento`
--

CREATE TABLE `requirimiento` (
  `id_requerimiento` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `id_estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_asignar`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_asignar` (
`id_asignar` int(11)
,`a_nombre` varchar(50)
,`descripcion` varchar(100)
,`id_departamento` int(11)
,`d_nombre` varchar(50)
,`id_requerimiento` int(11)
,`r_nombre` varchar(50)
,`id_usuario` int(11)
,`u_nombre` varchar(50)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_departamento`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_departamento` (
`id_departamento` int(11)
,`d_nombre` varchar(50)
,`descripcion` varchar(100)
,`id_gerencia` int(11)
,`g_nombre` varchar(50)
,`id_requerimiento` int(11)
,`r_nombre` varchar(50)
,`id_usuario` int(11)
,`nombre` varchar(50)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_encargado`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_encargado` (
`id_encargado` int(11)
,`e_nombre` varchar(50)
,`apellido` varchar(50)
,`id_departamento` int(11)
,`d_nombre` varchar(50)
,`id_requerimiento` int(11)
,`r_nombre` varchar(50)
,`id_usuario` int(11)
,`u_nombre` varchar(50)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_gerencias`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_gerencias` (
`id_gerencia` int(11)
,`g_nombre` varchar(50)
,`descripcion` varchar(100)
,`id_requerimiento` int(11)
,`r_nombre` varchar(50)
,`id_usuario` int(11)
,`u_nombre` varchar(50)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `v_asignar`
--
DROP TABLE IF EXISTS `v_asignar`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_asignar`  AS  (select `a`.`id_asignar` AS `id_asignar`,`a`.`nombre` AS `a_nombre`,`a`.`descripcion` AS `descripcion`,`d`.`id_departamento` AS `id_departamento`,`d`.`nombre` AS `d_nombre`,`r`.`id_requerimiento` AS `id_requerimiento`,`r`.`nombre` AS `r_nombre`,`u`.`id_usuario` AS `id_usuario`,`u`.`nombre` AS `u_nombre` from (((`asignar` `a` join `departamento` `d` on(`a`.`id_departamento` = `d`.`id_departamento`)) join `requirimiento` `r` on(`a`.`id_requerimiento` = `r`.`id_requerimiento`)) join `usuario` `u` on(`a`.`id_usuario` = `u`.`id_usuario`))) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_departamento`
--
DROP TABLE IF EXISTS `v_departamento`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_departamento`  AS  (select `d`.`id_departamento` AS `id_departamento`,`d`.`nombre` AS `d_nombre`,`d`.`descripcion` AS `descripcion`,`g`.`id_gerencia` AS `id_gerencia`,`g`.`nombre` AS `g_nombre`,`r`.`id_requerimiento` AS `id_requerimiento`,`r`.`nombre` AS `r_nombre`,`u`.`id_usuario` AS `id_usuario`,`u`.`nombre` AS `nombre` from (((`departamento` `d` join `gerencia` `g` on(`d`.`id_gerencia` = `g`.`id_gerencia`)) join `requirimiento` `r` on(`d`.`id_requerimiento` = `r`.`id_requerimiento`)) join `usuario` `u` on(`d`.`id_usuario` = `u`.`id_usuario`))) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_encargado`
--
DROP TABLE IF EXISTS `v_encargado`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_encargado`  AS  (select `e`.`id_encargado` AS `id_encargado`,`e`.`nombre` AS `e_nombre`,`e`.`apellido` AS `apellido`,`d`.`id_departamento` AS `id_departamento`,`d`.`nombre` AS `d_nombre`,`r`.`id_requerimiento` AS `id_requerimiento`,`r`.`nombre` AS `r_nombre`,`u`.`id_usuario` AS `id_usuario`,`u`.`nombre` AS `u_nombre` from (((`encargado` `e` join `departamento` `d` on(`e`.`id_departamento` = `d`.`id_departamento`)) join `requirimiento` `r` on(`e`.`id_requerimiento` = `r`.`id_requerimiento`)) join `usuario` `u` on(`e`.`id_usuario` = `u`.`id_usuario`))) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_gerencias`
--
DROP TABLE IF EXISTS `v_gerencias`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_gerencias`  AS  (select `g`.`id_gerencia` AS `id_gerencia`,`g`.`nombre` AS `g_nombre`,`g`.`descripcion` AS `descripcion`,`r`.`id_requerimiento` AS `id_requerimiento`,`r`.`nombre` AS `r_nombre`,`u`.`id_usuario` AS `id_usuario`,`u`.`nombre` AS `u_nombre` from ((`gerencia` `g` join `requirimiento` `r` on(`g`.`id_requimiento` = `r`.`id_requerimiento`)) join `usuario` `u` on(`g`.`id_usuario` = `u`.`id_usuario`))) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignar`
--
ALTER TABLE `asignar`
  ADD PRIMARY KEY (`id_asignar`),
  ADD KEY `id_departamento` (`id_departamento`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_requerimiento` (`id_requerimiento`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id_departamento`),
  ADD KEY `id_gerencia` (`id_gerencia`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_requerimiento` (`id_requerimiento`);

--
-- Indices de la tabla `encargado`
--
ALTER TABLE `encargado`
  ADD PRIMARY KEY (`id_encargado`),
  ADD KEY `id_departamento` (`id_departamento`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_requerimiento` (`id_requerimiento`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id_estado`);

--
-- Indices de la tabla `gerencia`
--
ALTER TABLE `gerencia`
  ADD PRIMARY KEY (`id_gerencia`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_requimiento` (`id_requimiento`);

--
-- Indices de la tabla `requirimiento`
--
ALTER TABLE `requirimiento`
  ADD PRIMARY KEY (`id_requerimiento`),
  ADD KEY `id_estado` (`id_estado`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asignar`
--
ALTER TABLE `asignar`
  MODIFY `id_asignar` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id_departamento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `encargado`
--
ALTER TABLE `encargado`
  MODIFY `id_encargado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `id_estado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `gerencia`
--
ALTER TABLE `gerencia`
  MODIFY `id_gerencia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `requirimiento`
--
ALTER TABLE `requirimiento`
  MODIFY `id_requerimiento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignar`
--
ALTER TABLE `asignar`
  ADD CONSTRAINT `asignar_ibfk_1` FOREIGN KEY (`id_requerimiento`) REFERENCES `requirimiento` (`id_requerimiento`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `asignar_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD CONSTRAINT `departamento_ibfk_1` FOREIGN KEY (`id_requerimiento`) REFERENCES `requirimiento` (`id_requerimiento`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `departamento_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `departamento_ibfk_3` FOREIGN KEY (`id_gerencia`) REFERENCES `gerencia` (`id_gerencia`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `encargado`
--
ALTER TABLE `encargado`
  ADD CONSTRAINT `encargado_ibfk_1` FOREIGN KEY (`id_requerimiento`) REFERENCES `requirimiento` (`id_requerimiento`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `encargado_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `encargado_ibfk_3` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `gerencia`
--
ALTER TABLE `gerencia`
  ADD CONSTRAINT `gerencia_ibfk_1` FOREIGN KEY (`id_requimiento`) REFERENCES `requirimiento` (`id_requerimiento`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `gerencia_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `requirimiento`
--
ALTER TABLE `requirimiento`
  ADD CONSTRAINT `requirimiento_ibfk_1` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
