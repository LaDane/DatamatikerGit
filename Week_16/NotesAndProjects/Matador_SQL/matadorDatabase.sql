CREATE DATABASE IF NOT EXISTS Matador DEFAULT CHARSET = utf8mb4;
use Matador;
DROP TABLE IF EXISTS Field;
DROP TABLE IF EXISTS Player;
CREATE table Field(
     id tinyint primary key auto_increment, 
	 type varchar(255),
     label varchar(255),
     cost int DEFAULT NULL,
     income int DEFAULT NULL,
     seriesID int DEFAULT NULL
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE table Player(
	id tinyint primary key auto_increment,
	name varchar(255),
	balance int DEFAULT 30000,
	positon int DEFAULT 1,
    turnsleft int DEFAULT 0,
    next boolean DEFAULT 0
)ENGINE=InnoDB AUTO_INCREMENT=1;


INSERT INTO Field (type, label, income) VALUES ("Start", "Start", 4000);
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Rødovrevej", 1200, 100, 1);
INSERT INTO Field (type, label) VALUES ("Event", "Prøv lykken");
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Hvidovrevej", 1200, 100, 1);
INSERT INTO Field (type, label, cost) VALUES ("Tax", "Skat", 4000);
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Shippingline", "Limfjorden A/S", 4000, 1000, 9);
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Roskildevej", 2000, 200, 2);
INSERT INTO Field (type, label) VALUES ("Event", "Prøv lykken");
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Valby langgade", 2000, 200, 2);
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Allergade", 2400, 250, 2);
INSERT INTO Field (type, label) VALUES ("Field", "Fængsel");
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Frederiksberg Alle", 2800, 250, 3);
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Brewery", "Coca cola", 3000, 250, 10);
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Bülowsvej", 2800, 250, 3);
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Gl.Kongevej", 3200, 250, 3);
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("ShippingLine", "dont know", 4000, 250, 9);
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Bernstorffsvej", 3600, 250, 4);
INSERT INTO Field (type, label) VALUES ("Event", "Prøv Lykke");
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Hellerupvej", 3600, 100, 4);
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Strandvej", 4000, 100, 4);
insert into Field (type,label,cost,income,seriesID) values("Parking","Parking",0,0, 0);
insert into Field (type,label,cost,income,seriesID) values("Land","Trianglen", 4400, 250, 5);
insert into Field (type,label,cost,income,seriesID) values("Event","Prøv lykken", 0, 0, 0);
insert into Field (type,label,cost,income,seriesID) values("Land","Østerbrogade", 4400, 250, 5);
insert INTO Field(type,label,cost,income,seriesID) values ("Land", "Grønningen", 4800, 250, 5);
insert INTO Field(type,label,cost,income,seriesID) values ("ShippingLine", "Mols-Linien A/S", 4000, 250, 9);
insert INTO Field(type,label,cost,income,seriesID) values ("Land", "Bredgade", 5200, 250, 6);
insert INTO Field(type,label,cost,income,seriesID) values ("Land", "Kgs. Nytorv", 4400, 250, 5);
insert INTO Field(type,label,cost,income,seriesID) values ("Brewery", "Carlsberg", 3000, 250, 10);
insert INTO Field(type,label,cost,income,seriesID) values ("Land", "Østergade", 5600, 250, 6);
INSERT INTO Field (type, label) VALUES ( "GoToJail", "Fængsel");
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Amagertorv", 6000, 250, 7);
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Vimmelskattet", 6000, 250, 7);
INSERT INTO Field (type, label) VALUES ("Event", "Prøv lykken");
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Nybrogade", 6400, 100, 7);
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("ShippingLine", "Skandinavisk Linietrafik", 4000, 100, 9);
INSERT INTO Field (type, label) VALUES ("Event", "Prøv lykken");
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Frederiksberggade", 7000, 100, 8);
INSERT INTO Field (type, label, cost) VALUES ("Tax", "Skat", 2000);
INSERT INTO Field (type, label, cost, income, seriesID) VALUES ("Land", "Råhuspladsen", 8000, 100, 8);