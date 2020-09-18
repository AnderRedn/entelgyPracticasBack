


INSERT INTO departamentos VALUES ('1000', 'DPTO_1', 'ZAMPELANA', '');
INSERT INTO departamentos VALUES ('2000', 'DPTO_2', 'LEZABETZU', '');
INSERT INTO departamentos VALUES ('3000', 'DPTO_3', 'SONDERIO', '');

INSERT INTO empleados VALUES ('000000001111', 'Joan Pele', 'M', '10/02/1960', '06/02/1985', 2000.00, 0.0, 'Director', '000000001111', '1000', 'Galdacano', '1234');
INSERT INTO empleados VALUES ('000000002222', 'Karen Pele', 'F', '11/11/1965', '04/02/1985', 2100.00, 0.0, 'Director', '000000001111', '2000', 'Bedia', 'abcd');

UPDATE departamentos SET codDirector ='000000001111' WHERE codDepto ='1000';
UPDATE departamentos SET codDirector ='000000002222' WHERE codDepto ='1000';
UPDATE departamentos SET codDirector ='000000002222' WHERE codDepto ='3000';

INSERT INTO empleados VALUES ('000000003333', 'Anton Zamarripa', 'M', '07/01/1972', '12/02/1986', 1500.00, 0.0, 'Secretari@', '000000001111', '1000', 'Larrabezua', '1234');
INSERT INTO empleados VALUES ('000000006666', 'Beatriz Esteban', 'F', '07/01/1985', '11/02/2000', 1450.00, 0.0, 'Secretari@', '000000002222', '2000', 'Zamudio', 'abcd');
INSERT INTO empleados VALUES ('000000007777', 'Carlos Eldel', 'M', '07/01/1985', '10/02/1995', 1400.00, 0.0, 'Secretari@', '000000002222', '2000', 'Derio', '1234');
INSERT INTO empleados VALUES ('000000004444', 'Maria Perez', 'F', '12/11/1965', '10/02/1985', 1500.00, 100.0, 'Vendedor', '000000002222', '2000', 'Sopelana', 'abcd');
INSERT INTO empleados VALUES ('000000005555', 'Andy Aurre', 'M', '02/03/1990', '11/02/2010', 1400.00, 120.0, 'Vendedor', '000000002222', '2000', 'Bilbao', '1234');
INSERT INTO empleados VALUES ('000011110000', 'Katalin Legen', 'F', '02/03/1990', '04/02/2010', 1400.00, 110.0, 'Vendedor', '000000002222', '2000', 'Larrabezua', '1234');


INSERT INTO empleados VALUES ('000000009999', 'Cece Can', 'M', '02/03/1990', '08/02/2010', 1050.00, 15.0, 'Operario', '000000001111', '3000', 'Galdacano', '1234');
INSERT INTO empleados VALUES ('000022220000', 'Eheh Ean', 'F', '02/03/1990', '02/02/2010', 1110.00, 2.0, 'Operario', '000000001111', '3000', 'Derio', 'abcd');
INSERT INTO empleados VALUES ('000000008888', 'Dede Dan', 'F', '02/03/1990', '07/02/2010', 1100.00, 10.0, 'Operario', '000000001111', '3000', 'Bedia', '1234');
INSERT INTO empleados VALUES ('000033330000', 'Fefe Fan', 'M', '02/03/1990', '03/02/2010', 1150.00, 5.0, 'Operario', '000000001111', '3000', 'Baracaldo', 'abcd');
INSERT INTO empleados VALUES ('000044440000', 'Gege Gan', 'F', '02/03/1990', '10/02/2010', 1000.00, 7.0, 'Operario', '000000001111', '3000', 'Gorliz', '1234');

