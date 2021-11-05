-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 07, 2020 at 03:04 AM
-- Server version: 8.0.17
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `plabp_awp`
--
CREATE DATABASE IF NOT EXISTS `plabp_awp` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `plabp_awp`;

-- --------------------------------------------------------

--
-- Table structure for table `actividad`
--

CREATE TABLE `actividad` (
  `id` int(10) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `horas_semana` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `actividad`
--

INSERT INTO `actividad` (`id`, `nombre`, `horas_semana`) VALUES
(1, 'Actividad de docencia 1', 4),
(2, 'Actividad de docencia 2', 3),
(3, 'Actividad de docencia 3', 3),
(4, 'Representante Investigaciones Facultad Ingenieria', 12),
(5, 'Directora GIDIS', 5),
(6, 'Actividad extension', 6),
(7, 'Comite curricular', 1),
(8, 'Consejo facultad', 1),
(9, 'Asistencia a reuniones programadas por la administración', 1),
(10, 'Atención a estudiantes', 2),
(20, 'Actividad independiente', 2),
(21, 'actividad administracion', 20),
(22, 'actividad administracion2', 20),
(23, 'actividad administracion3', 20),
(24, 'actividad administracion4', 20),
(25, 'actividad administracion5', 30),
(26, 'actividad administracion6', 20),
(41, 'Actividad independiente', 2),
(42, 'Actividad independiente', 2);

-- --------------------------------------------------------

--
-- Table structure for table `actividad_profesor`
--

CREATE TABLE `actividad_profesor` (
  `id_profesor` int(10) NOT NULL,
  `id_actividad` int(10) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `semestre` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `actividad_profesor`
--

INSERT INTO `actividad_profesor` (`id_profesor`, `id_actividad`, `fecha_ingreso`, `semestre`) VALUES
(1, 1, '2020-12-02', '2020-2'),
(1, 2, '2020-12-02', '2020-2'),
(1, 3, '2020-12-02', '2020-2'),
(1, 4, '2020-12-02', '2020-2'),
(1, 5, '2020-12-02', '2020-2'),
(1, 6, '2020-12-02', '2020-2'),
(1, 7, '2020-12-02', '2020-2'),
(1, 8, '2020-12-02', '2020-2'),
(1, 21, '2020-12-02', ''),
(1, 22, '2020-12-02', ''),
(1, 23, '2020-12-02', ''),
(1, 24, '2020-12-02', ''),
(1, 25, '2020-12-02', ''),
(1, 26, '2020-12-17', '2020-2'),
(1, 42, '2020-12-02', ''),
(3, 9, '2020-12-02', '2020-2'),
(3, 10, '2020-12-02', '2020-2');

-- --------------------------------------------------------

--
-- Table structure for table `administracion`
--

CREATE TABLE `administracion` (
  `id_actividad` int(10) NOT NULL,
  `cargo` varchar(100) NOT NULL,
  `horas_semestre` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `administracion`
--

INSERT INTO `administracion` (`id_actividad`, `cargo`, `horas_semestre`) VALUES
(7, 'Miembro Comité Curricular', 32),
(8, 'Miembro Consejo Facultad', 32),
(21, 'presidente', 20),
(22, 'presidente2', 20),
(23, 'presidente', 20),
(24, 'presidente', 20),
(25, 'presidente', 30),
(26, 'presidente', 20);

-- --------------------------------------------------------

--
-- Table structure for table `administrador`
--

CREATE TABLE `administrador` (
  `id` int(10) NOT NULL,
  `id_usuario` int(10) NOT NULL,
  `fecha_inicio` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `administrador`
--

INSERT INTO `administrador` (`id`, `id_usuario`, `fecha_inicio`) VALUES
(1, 1, '2020-12-02');

-- --------------------------------------------------------

--
-- Table structure for table `docencia`
--

CREATE TABLE `docencia` (
  `id_actividad` int(10) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `grupo` varchar(9) NOT NULL,
  `creditos` int(1) NOT NULL,
  `nivel` varchar(50) NOT NULL,
  `num_estudiantes` int(2) NOT NULL,
  `horas_semestre` int(3) NOT NULL,
  `h_p` int(3) NOT NULL,
  `h_t_p` int(3) NOT NULL,
  `h_t` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `docencia`
--

INSERT INTO `docencia` (`id_actividad`, `codigo`, `grupo`, `creditos`, `nivel`, `num_estudiantes`, `horas_semestre`, `h_p`, `h_t_p`, `h_t`) VALUES
(1, '1151004', 'B', 4, 'NIVEL 1', 39, 62, 10, 10, 10),
(2, '1151005', 'A', 3, 'NIVEL 1', 30, 50, 4, 5, 5),
(3, '1151007', 'C', 2, 'NIVEL 4', 25, 60, 3, 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `extension`
--

CREATE TABLE `extension` (
  `id_actividad` int(10) NOT NULL,
  `responsabilidades` varchar(100) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `unidad` varchar(50) NOT NULL,
  `horas_semestre` int(3) NOT NULL,
  `h_ejecucion` int(2) NOT NULL,
  `h_programacion` int(2) NOT NULL,
  `programa` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `extension`
--

INSERT INTO `extension` (`id_actividad`, `responsabilidades`, `codigo`, `unidad`, `horas_semestre`, `h_ejecucion`, `h_programacion`, `programa`) VALUES
(6, 'Responsabilidades ....', '12345', 'unidad extension', 5, 2, 2, 'ing de sistemas');

-- --------------------------------------------------------

--
-- Table structure for table `investigacion`
--

CREATE TABLE `investigacion` (
  `id_actividad` int(10) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `responsabilidad` varchar(100) NOT NULL,
  `unidad_inv` varchar(50) NOT NULL,
  `institucion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `investigacion`
--

INSERT INTO `investigacion` (`id_actividad`, `codigo`, `responsabilidad`, `unidad_inv`, `institucion`) VALUES
(4, '1', 'Director', 'Facultad Ingenieria', 'UFPS'),
(5, '2', 'Director de Grupo', 'Dpto Sistemas', 'UFPS');

-- --------------------------------------------------------

--
-- Table structure for table `otras`
--

CREATE TABLE `otras` (
  `id_actividad` int(10) NOT NULL,
  `horas_semestre` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `otras`
--

INSERT INTO `otras` (`id_actividad`, `horas_semestre`) VALUES
(9, 16),
(10, 32),
(42, 30);

-- --------------------------------------------------------

--
-- Table structure for table `profesor`
--

CREATE TABLE `profesor` (
  `id` int(10) NOT NULL,
  `id_usuario` int(10) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `codigo` int(7) NOT NULL,
  `horas_semana` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `profesor`
--

INSERT INTO `profesor` (`id`, `id_usuario`, `fecha_inicio`, `codigo`, `horas_semana`) VALUES
(1, 2, '2020-12-01', 1150000, 132),
(2, 3, '2020-12-01', 114000, 0),
(3, 1, '2020-12-02', 1155608, 3);

-- --------------------------------------------------------

--
-- Table structure for table `recovery`
--

CREATE TABLE `recovery` (
  `user` varchar(100) NOT NULL,
  `token` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `id_tipo_usuario` int(10) NOT NULL,
  `des_tipo_usuario` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id_tipo_usuario`, `des_tipo_usuario`) VALUES
(1, 'administrador'),
(2, 'profesor');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id` int(10) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `foto` varchar(100) NOT NULL,
  `last_access` date NOT NULL,
  `id_tipo_usuario` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `nombres`, `correo`, `contraseña`, `status`, `foto`, `last_access`, `id_tipo_usuario`) VALUES
(1, 'Director ', 'angelleonardovian@ufps.edu.co', '8cb2237d0679ca88db6464eac60da96345513964', 1, '', '2020-12-02', 1),
(2, 'Profesor 1', 'joseeduardorm@ufps.edu.co', '8cb2237d0679ca88db6464eac60da96345513964', 1, '', '2020-12-02', 2),
(3, 'Profesor 2', 'profesor2.apellido@ufps.edu.co', '8cb2237d0679ca88db6464eac60da96345513964', 1, '', '2020-12-16', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `actividad`
--
ALTER TABLE `actividad`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `actividad_profesor`
--
ALTER TABLE `actividad_profesor`
  ADD PRIMARY KEY (`id_profesor`,`id_actividad`),
  ADD KEY `fk_actividad-profesor_actividad` (`id_actividad`);

--
-- Indexes for table `administracion`
--
ALTER TABLE `administracion`
  ADD PRIMARY KEY (`id_actividad`);

--
-- Indexes for table `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_administrador_usuario` (`id_usuario`);

--
-- Indexes for table `docencia`
--
ALTER TABLE `docencia`
  ADD PRIMARY KEY (`id_actividad`);

--
-- Indexes for table `extension`
--
ALTER TABLE `extension`
  ADD PRIMARY KEY (`id_actividad`);

--
-- Indexes for table `investigacion`
--
ALTER TABLE `investigacion`
  ADD PRIMARY KEY (`id_actividad`);

--
-- Indexes for table `otras`
--
ALTER TABLE `otras`
  ADD PRIMARY KEY (`id_actividad`);

--
-- Indexes for table `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `fk_profesor_usuario` (`id_usuario`);

--
-- Indexes for table `recovery`
--
ALTER TABLE `recovery`
  ADD PRIMARY KEY (`token`);

--
-- Indexes for table `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id_tipo_usuario`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `correo` (`correo`),
  ADD KEY `fk_usuario_tipo_usuario` (`id_tipo_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `actividad`
--
ALTER TABLE `actividad`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `profesor`
--
ALTER TABLE `profesor`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id_tipo_usuario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `actividad_profesor`
--
ALTER TABLE `actividad_profesor`
  ADD CONSTRAINT `fk_actividad-profesor_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_actividad-profesor_profesor` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `administracion`
--
ALTER TABLE `administracion`
  ADD CONSTRAINT `fk_administracion_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Constraints for table `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `fk_administrador_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `docencia`
--
ALTER TABLE `docencia`
  ADD CONSTRAINT `fk_docencia_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Constraints for table `extension`
--
ALTER TABLE `extension`
  ADD CONSTRAINT `fk_extension_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Constraints for table `investigacion`
--
ALTER TABLE `investigacion`
  ADD CONSTRAINT `fk_investigacion_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Constraints for table `otras`
--
ALTER TABLE `otras`
  ADD CONSTRAINT `fk_otras_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Constraints for table `profesor`
--
ALTER TABLE `profesor`
  ADD CONSTRAINT `fk_profesor_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_tipo_usuario` FOREIGN KEY (`id_tipo_usuario`) REFERENCES `tipo_usuario` (`id_tipo_usuario`) ON DELETE RESTRICT ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
