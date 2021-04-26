CREATE DATABASE IF NOT EXISTS Tournament DEFAULT CHARSET = utf8mb4;
use Tournament;
DROP TABLE IF EXISTS matches;
DROP TABLE IF EXISTS tournament_data;
DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS team;
DROP TABLE IF EXISTS team_matches;

CREATE TABLE tournament_data(
	id int primary key auto_increment,
	name varchar(255),
    founder_name varchar(255),
	start_date date,
    start_time time,
    due_date date,
    amount_of_teams int
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE team(
	id int primary key auto_increment,
	name varchar(255),
    points int DEFAULT 0,
    point_score int DEFAULT 0,
    games_won int DEFAULT 0,
    games_played int DEFAULT 0,
    knocked_out boolean DEFAULT 0
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE player(
	id int primary key auto_increment,
	name varchar(255),
    team_id int,
    FOREIGN KEY (team_id) REFERENCES team(id)
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE matches(
	id int primary key auto_increment,
    match_start_date date,
    match_start_time time
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE team_matches(
	id int primary key auto_increment,
	match_id int,
    team_id int,
    score int,
	FOREIGN KEY (match_id) REFERENCES matches(id),
    FOREIGN KEY (team_id) REFERENCES team(id)
)ENGINE=InnoDB AUTO_INCREMENT=1;


