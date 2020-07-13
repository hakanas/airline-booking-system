DROP TABLE IF EXISTS route;
DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS flights;
DROP TABLE IF EXISTS airport;
DROP TABLE IF EXISTS airline_company;

CREATE TABLE airline_company (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);

CREATE TABLE airport (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  city VARCHAR(50) NOT NULL,
  code VARCHAR(3) DEFAULT NULL
);

CREATE TABLE route (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  departure_id INT NOT NULL,
  destination_id INT NOT NULL,
  FOREIGN KEY (departure_id) REFERENCES airport(id),
  FOREIGN KEY (destination_id) REFERENCES airport(id)
);

CREATE TABLE flights (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  airline_company_id INT NOT NULL,
  seat_capacity INT,
  price INT,
  FOREIGN KEY (airline_company_id) REFERENCES airline_company(id)
);

CREATE TABLE ticket (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  flight_id INT NOT NULL,
  card_number VARCHAR(16) NOT NULL,
  FOREIGN KEY (flight_id) REFERENCES flights(id)
);

INSERT INTO airline_company (name) VALUES
  ('Türk Hava Yolları'),
  ('Pegasus'),
  ('Onur Air'),
  ('American Airlines'),
  ('Delta Air Lines'),
  ('JetBlue Airways');

INSERT INTO airport (name, city, code) VALUES
  ('AALBORG LUFTHAVN', 'AALBORG', 'AAL'),
  ('AEROPUERTO DE BARCELONA', 'BARCELONA', 'BCN'),
  ('ISTANBUL AIRPORT', 'ISTANBUL', 'IST'),
  ('SABIHA GÖKÇEN ULUSLARARASI HAVALIMANI', 'ISTANBUL', 'SAW'),
  ('ISTANBUL ATATÜRK HAVALIMANI', 'ISTANBUL', 'ISL'),
  ('ISTANBUL ATATÜHAVALIMANI', 'IANBUL', 'IuL'),
  ('ISTANBUL ATATÜssssLIMANI', 'IANssUL', 'Iua'),
  ('ESENBOĞA ULUSLARARASI HAVALIMANI', 'ANKARA', 'ESB');



