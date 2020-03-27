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
movie_year varchar (50) not null,
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
seat int not null,
FOREIGN KEY (id_movie) REFERENCES movie(id_movie),
FOREIGN KEY (id_auditorium) REFERENCES auditorium(id_auditorium)
);

create table ticket (
id_ticket int primary key auto_increment not null,
id_loyal_program float not null,
id_customer int not null,
id_schedule int not null,
FOREIGN KEY (id_schedule) REFERENCES theatre_schedule(id_schedule),
FOREIGN KEY (id_customer) REFERENCES customer(id_customer)
);





























