create database movietheatre;
use movietheatre;

create table category (
	id_category int primary key auto_increment not null,
	category_name varchar (50) not null
);


create table movie (
	id_movie int primary key auto_increment not null,
	movie_name varchar(50) not null,
	id_category int not null,
	director varchar (50) not null,
	actor varchar (50) not null,
	movie_year int not null,
	runtime_minutes int not null,
	rate varchar (50) not null,
	FOREIGN KEY (id_category) REFERENCES category(id_category)
);


create table location(
	id_location int primary key auto_increment not null,
	location varchar (50),
	address varchar (50)
);


CREATE table auditorium(
	id_auditorium int PRIMARY KEY AUTO_INCREMENT not null,
	seat_total VARCHAR(50) NOT NULL,
	vip boolean NOT NULL,
	id_location int NOT NULL,
	FOREIGN KEY (id_location) REFERENCES location(id_location)
);


create table loyal_program (
	id_loyal_program int primary key auto_increment not null,
	discount float not null,
	minimum_points int not null
);


create table customer (
	id_customer int primary key auto_increment not null,
	first_name varchar (50) not null,
	last_name varchar (50) not null,
	gender varchar (1) null,
	email varchar (50) null,
	points int not null default 0
);

create table theatre_schedule (
	id_schedule int primary key auto_increment not null,
	showtime datetime not null,
	id_auditorium int not null,
	id_movie int not null,
	price float not null,
	FOREIGN KEY (id_movie) REFERENCES movie(id_movie),
	FOREIGN KEY (id_auditorium) REFERENCES auditorium(id_auditorium)
);

create table ticket (
	id_ticket int primary key auto_increment not null,
	id_loyal_program float not null default 0,
	id_customer int,
	id_schedule int not null,
	seat int not null,
	FOREIGN KEY (id_schedule) REFERENCES theatre_schedule(id_schedule)
);


create table user (
	id_user int primary key auto_increment not null,
	name varchar (50),
	pwd varchar (50),
	role varchar (50) 
);









select * from auditorium;


insert into location(id_location, location, address) values (1, "Scotiabank Theatre Vancouver", "900 Burrard Street Vancouver");
insert into location(id_location, location, address) values (2, "Cineplex Cinemas Metropolis", "4700 Kingsway Burnaby");
insert into location(id_location, location, address) values (3, "Cineplex Cambie St", "3440 Cambie St Vancouver");
insert into location(id_location, location, address) values (4, "Cineplex Cinemas Chinatown", "88 W Pender St, 3rd Floor Vancouver");
insert into location(id_location, location, address) values (5, "Vancity Theatre", "1181 SeymournSt Vancouver");


select * from location;

insert into auditorium(id_auditorium, seat_total, vip, id_location) values(1, 50, true, 1);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(2, 50, true, 1);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(3, 50, false, 1);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(4, 50, false, 1);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(5, 50, false, 1);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(6, 50, false, 2);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(7, 50, true, 2);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(8, 50, false, 2);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(9, 50, false, 2);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(10, 50, false, 2);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(11, 50, false, 3);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(12, 50, true, 3);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(13, 50, false, 3);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(14, 50, false, 3);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(15, 50, false, 3);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(16, 50, false, 4);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(17, 50, true, 4);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(18, 50, false, 4);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(19, 50, false, 4);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(20, 50, false, 4);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(21, 50, false, 5);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(22, 50, true, 5);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(23, 50, false, 5);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(24, 50, false, 5);
insert into auditorium(id_auditorium, seat_total, vip, id_location) values(25, 50, false, 5);












