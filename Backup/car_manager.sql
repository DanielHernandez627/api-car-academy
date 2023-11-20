-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-11-2023 a las 00:32:17
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `car_manager`
--
CREATE DATABASE IF NOT EXISTS `car_manager` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `car_manager`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autenticacion_pass`
--

CREATE TABLE `autenticacion_pass` (
  `id` int(11) NOT NULL,
  `token` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `autenticacion_pass`
--

INSERT INTO `autenticacion_pass` (`id`, `token`) VALUES
(1, 'RXN0ZUVzRWxUb2tlbkluZ1NvZnR3YXJl');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE `marcas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `sigla_resumida` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `marcas`
--

INSERT INTO `marcas` (`id`, `nombre`, `sigla_resumida`) VALUES
(1, 'Mazda', 'MZD'),
(2, 'Toyota', 'TOY'),
(3, 'Ford', 'FRD'),
(4, 'Chevrolet', 'CHV'),
(5, 'Honda', 'HND'),
(6, 'Nissan', 'NSN'),
(7, 'Volkswagen', 'VW'),
(8, 'Audi', 'AUD'),
(9, 'Mercedes-Benz', 'MBZ'),
(10, 'BMW', 'BMW'),
(11, 'Hyundai', 'HYD'),
(12, 'Kia', 'KIA'),
(13, 'Subaru', 'SUB'),
(14, 'Tesla', 'TSLA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles_usuarios`
--

CREATE TABLE `roles_usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles_usuarios`
--

INSERT INTO `roles_usuarios` (`id`, `nombre`, `estado`) VALUES
(1, 'Admin', b'1'),
(3, 'Vendedor', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_documentos`
--

CREATE TABLE `tipo_documentos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `sigla` varchar(10) NOT NULL,
  `estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_documentos`
--

INSERT INTO `tipo_documentos` (`id`, `nombre`, `sigla`, `estado`) VALUES
(1, 'Cedula', 'CC', b'1'),
(2, 'NIT', 'NIT', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `Nombres` varchar(100) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  `id_rol` int(11) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `id_tipo_documento` int(11) NOT NULL,
  `contrasena` varchar(1000) NOT NULL,
  `numero_documento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `Nombres`, `Apellidos`, `Email`, `Direccion`, `id_rol`, `fecha_nacimiento`, `id_tipo_documento`, `contrasena`, `numero_documento`) VALUES
(5, 'prueba', 'prueba', 'daniel33@gmail.com', 'cr', 1, '2023-11-14', 1, '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 1231777),
(6, 'acdasd', 'acasdc', 'acds@prueba.com', 'casc', 3, '2008-06-16', 1, 'ed8c0457e9e2298a6bfe90bf2347f9d2821be2094b7387a2a84c335fdd748192', 21877321);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `id` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `numero_bastidor` varchar(100) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `precio` int(11) NOT NULL,
  `descuento` int(11) NOT NULL,
  `info_adicional` varchar(100) NOT NULL,
  `valor_adicional` int(11) NOT NULL,
  `placa` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vehiculos`
--

INSERT INTO `vehiculos` (`id`, `id_marca`, `numero_bastidor`, `modelo`, `precio`, `descuento`, `info_adicional`, `valor_adicional`, `placa`) VALUES
(1, 1, 'PRUEBA', '5', 10000000, 0, ' ', 0, 'OBZ23R');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autenticacion_pass`
--
ALTER TABLE `autenticacion_pass`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `roles_usuarios`
--
ALTER TABLE `roles_usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_documentos`
--
ALTER TABLE `tipo_documentos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tipo_documento` (`id_tipo_documento`),
  ADD KEY `fk_rol` (`id_rol`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_marca` (`id_marca`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autenticacion_pass`
--
ALTER TABLE `autenticacion_pass`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `marcas`
--
ALTER TABLE `marcas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `roles_usuarios`
--
ALTER TABLE `roles_usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_documentos`
--
ALTER TABLE `tipo_documentos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_rol` FOREIGN KEY (`id_rol`) REFERENCES `roles_usuarios` (`id`),
  ADD CONSTRAINT `fk_tipo_documento` FOREIGN KEY (`id_tipo_documento`) REFERENCES `tipo_documentos` (`id`);

--
-- Filtros para la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD CONSTRAINT `vehiculos_ibfk_1` FOREIGN KEY (`id_marca`) REFERENCES `marcas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
