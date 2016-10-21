SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

CREATE TABLE IF NOT EXISTS `usuarios` (
  `cedula` int(12) NOT NULL ,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `rol` varchar(25) NOT NULL,
`direccion` varchar(50) NOT NULL,
`correo electronico` varchar(50) NOT NULL,
`foto` longblob NOT NULL,
`telefono` varchar(25) NOT NULL,
`estado` varchar(25) NOT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;

CREATE TABLE IF NOT EXISTS `dispositivo` (
  `numero_unico_serie` int(12) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  `restriccion` varchar(150) NOT NULL,
  `observaciones` varchar(150) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `foto` longblob NOT NULL,
  `disponibilidad` varchar(25) NOT NULL,
  PRIMARY KEY (`numero_unico_serie`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11;

CREATE TABLE IF NOT EXISTS `reserva` (
  `id_reserva` int (12) NOT NULL,
  `id_disp` int(12) NOT NULL,
  `id_cedula` int(12) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `tiempo_reserva` varchar(50) NOT NULL,
  PRIMARY KEY (`id_reserva`),
  FOREIGN KEY (`id_disp`) REFERENCES dispositivo(numero_unico_serie),
  FOREIGN KEY (`id_cedula`) REFERENCES usuarios(cedula)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `sancion` (
  `id_sancion` int(12) NOT NULL,
  `id_dis` int(12) NOT NULL,
  `id_ced` int(12) NOT NULL,
  `fecha_ini` date NOT NULL,
  `razon` varchar(100) NOT NULL,
  `tiempo_sancion` varchar(50) NOT NULL,
  PRIMARY KEY (`id_sancion`),
  FOREIGN KEY (`id_dis`) REFERENCES dispositivo(numero_unico_serie),
  FOREIGN KEY (`id_ced`) REFERENCES usuarios(cedula)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO dispositivo(`numero_unico_serie`,`nombre`,`modelo`,`descripcion`,
`restriccion`,`observaciones`,`estado`,`foto`,`disponibilidad`)
VALUES (123,'rayos x','RCT54','Lector de rayos x','no sacar de la instalacion',
'ninguno observacion','PRESTADO','c48b','Media');

INSERT INTO dispositivo(`numero_unico_serie`,`nombre`,`modelo`,`descripcion`,
`restriccion`,`observaciones`,`estado`,`foto`,`disponibilidad`)
VALUES (333,'espectometro','UCUQ2','Mide espectro','no sacar de la instalacion',
'Tratar con cuidado','DISPONIBLE','c48b','alta');

INSERT INTO dispositivo(`numero_unico_serie`,`nombre`,`modelo`,`descripcion`,
`restriccion`,`observaciones`,`estado`,`foto`,`disponibilidad`)
VALUES (555,'generador de ondas','OND123','genera ondaz 10-100hz','No usar cerca a otros generadores',
'utilizar protecto','AGOTADO','c48b','baja');

INSERT INTO usuarios VALUES (1039,'Federico','Ocampo Ortiz','fedo','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8',
'administrador','direccion1','federico@laboratorio.com','3ab4','4440238','activo');
INSERT INTO usuarios VALUES (1010,'Andres','Felipe','anfe','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8',
'investigador','direccion2','andres@laboratorio.com','3ab4','4440239','activo');
INSERT INTO usuarios VALUES (1020,'Daniel','Dtorre','dtorre99','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8',
'administrador','direccion3','daniel@laboratorio.com','3ab4','4440237','activo');
INSERT INTO usuarios VALUES (1012,'Anibal','pelaez','investigador3','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8',
'investigador','direccion4','anibal@laboratorio.com','3ab4','4440268','activo');

