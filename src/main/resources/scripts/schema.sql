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
  codDepto varchar(4) NOT NULL, 
  localidad varchar(30) not null, 
  password varchar(64) NOT NULL
);


--ALTER TABLE departamentos ADD CONSTRAINT FK_DIR FOREIGN KEY (codDirector) REFERENCES empleados (nDIEmp) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE empleados ADD CONSTRAINT FK_DPTO FOREIGN KEY (codDepto) REFERENCES departamentos (codDepto) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE empleados ADD CONSTRAINT FK_JEFE_EMP FOREIGN KEY (jefeID) REFERENCES empleados (nDIEmp) ON DELETE NO ACTION ON UPDATE NO ACTION;


CREATE TABLE weather (
  country VARCHAR(60) NOT NULL,
  name VARCHAR(60) NOT NULL,
  localtimeC VARCHAR(20) NOT NULL,
  observation_time VARCHAR(10) NOT NULL,
  temperature INT NOT NULL, 
  wind_speed INT NOT NULL,
  wind_dir VARCHAR(10) NOT NULL, 
  precip INT NOT NULL,
  humidity INT NOT NULL  
);

CREATE TABLE weatherEmp (
  nDIEmp VARCHAR(12) NOT NULL,
  country VARCHAR(60) NOT NULL,
  name VARCHAR(60) NOT NULL,
  localtimeC VARCHAR(20) NOT NULL,
  observation_time VARCHAR(10) NOT NULL,
  temperature INT NOT NULL, 
  wind_speed INT NOT NULL,
  wind_dir VARCHAR(10) NOT NULL, 
  precip INT NOT NULL,
  humidity INT NOT NULL  
);

ALTER TABLE weatherEmp ADD CONSTRAINT FK_EMP_W FOREIGN KEY (nDIEmp) REFERENCES empleados (nDIEmp) ON DELETE NO ACTION ON UPDATE NO ACTION;