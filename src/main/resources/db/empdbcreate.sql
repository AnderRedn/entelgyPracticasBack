--DROP TABLE departamentos;
CREATE TABLE departamentos (codDepto VARCHAR(4) NOT NULL PRIMARY KEY,
	nombreDpto VARCHAR(20) NOT NULL,
	ciudad VARCHAR(15),
	codDirector VARCHAR(12)
);
	
--DROP TABLE empleados;
CREATE TABLE empleados (
  nDIEmp VARCHAR(12) NOT NULL PRIMARY KEY,
  nomEmp VARCHAR(30) NOT NULL,
  sexEmp CHAR(1) NOT NULL,
  fecNac DATE NOT NULL,
  fecIncorporacion DATE NOT NULL,
  salEmp FLOAT NOT NULL,
  comisionE FLOAT NOT NULL,
  cargoE VARCHAR(15) NOT NULL,
  jefeID VARCHAR(12),
  codDepto varchar(4) NOT NULL
);






INSERT INTO empleados VALUES ('000000001111', 'Joan Pele', 'M', '10/02/1960', '06/02/1985', 2000.00, 0.0, 'Director', '000000001111', '');
INSERT INTO empleados VALUES ('000000002222', 'Karen Pele', 'F', '11/11/1965', '04/02/1985', 2100.00, 0.0, 'Director', '000000001111', '');

INSERT INTO departamentos VALUES ('1000', 'DPTO_1', 'ZAMPELANA', '000000001111');
INSERT INTO departamentos VALUES ('2000', 'DPTO_2', 'LEZABETZU', '000000002222');
INSERT INTO departamentos VALUES ('3000', 'DPTO_3', 'SONDERIO', '000000002222');

UPDATE empleados SET codDepto ='1000' WHERE nDIEmp ='000000001111';
UPDATE empleados SET codDepto ='2000' WHERE nDIEmp ='000000002222';

INSERT INTO empleados VALUES ('000000003333', 'Anton Zamarripa', 'M', '07/01/1972', '12/02/1986', 1500.00, 0.0, 'Secretari@', '000000001111', '1000');
INSERT INTO empleados VALUES ('000000006666', 'Beatriz Esteban', 'F', '07/01/1985', '11/02/2000', 1450.00, 0.0, 'Secretari@', '000000002222', '2000');
INSERT INTO empleados VALUES ('000000007777', 'Carlos Eldel', 'M', '07/01/1985', '10/02/1995', 1400.00, 0.0, 'Secretari@', '000000002222', '2000');
INSERT INTO empleados VALUES ('000000004444', 'Maria Perez', 'F', '12/11/1965', '10/02/1985', 1500.00, 100.0, 'Vendedor', '000000002222', '2000');
INSERT INTO empleados VALUES ('000000005555', 'Andy Aurre', 'M', '02/03/1990', '11/02/2010', 1400.00, 120.0, 'Vendedor', '000000002222', '2000');
INSERT INTO empleados VALUES ('000011110000', 'Katalin Legen', 'F', '02/03/1990', '04/02/2010', 1400.00, 110.0, 'Vendedor', '000000002222', '2000');

INSERT INTO empleados VALUES ('000000008888', 'Dede Dan', 'F', '02/03/1990', '07/02/2010', 1100.00, 10.0, 'Operario', '000000001111', '3000');
INSERT INTO empleados VALUES ('000000009999', 'Cece Can', 'M', '02/03/1990', '08/02/2010', 1050.00, 15.0, 'Operario', '000000001111', '3000');
INSERT INTO empleados VALUES ('000022220000', 'Eheh Ean', 'F', '02/03/1990', '02/02/2010', 1110.00, 2.0, 'Operario', '000000001111', '3000');
INSERT INTO empleados VALUES ('000033330000', 'Fefe Fan', 'M', '02/03/1990', '03/02/2010', 1150.00, 5.0, 'Operario', '000000001111', '3000');
INSERT INTO empleados VALUES ('000044440000', 'Gege Gan', 'F', '02/03/1990', '10/02/2010', 1000.00, 7.0, 'Operario', '000000001111', '3000');


--ALTER TABLE departamentos ADD CONSTRAINT FK_DIR FOREIGN KEY (codDirector) REFERENCES empleados (nDIEmp) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE empleados ADD CONSTRAINT FK_DPTO FOREIGN KEY (codDepto) REFERENCES departamentos (codDepto) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE empleados ADD CONSTRAINT FK_JEFE_EMP FOREIGN KEY (jefeID) REFERENCES empleados (nDIEmp) ON DELETE NO ACTION ON UPDATE NO ACTION;
