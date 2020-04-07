-- Users
insert into user (name,pwd,role) values ("hector","123","admin");
insert into user (name,pwd,role) values ("aki","123","admin");
insert into user (name,pwd,role) values ("sachiko","123","admin");
insert into user (name,pwd,role) values ("jc","123","admin");

-- Categories
insert into category (category_name) 
values ("Action"),("Drama"),("Romance"),("Car Racing"),("Thriller"),("Adult")
,("Family"),("Sci-Fi"),("War"),("Adventure"),("Fantasy"),("Horror"),("Comedy")	
,("Martial Arts"),("Sports"),("Crime"),("Musical"),("Documentary"),("Mystery")
,("Religious");

-- Location

insert into location(location, address) values ("Scotiabank Theatre Vancouver", "900 Burrard Street Vancouver");
insert into location(location, address) values ("Cineplex Cinemas Metropolis", "4700 Kingsway Burnaby");
insert into location(location, address) values ("Cineplex Cambie St", "3440 Cambie St Vancouver");
insert into location(location, address) values ("Cineplex Cinemas Chinatown", "88 W Pender St, 3rd Floor Vancouver");
insert into location(location, address) values ("Vancity Theatre", "1181 SeymournSt Vancouver");

-- Auditorium

insert into auditorium(seat_total, vip, id_location) values(50, true, 1);
insert into auditorium(seat_total, vip, id_location) values(50, true, 1);
insert into auditorium(seat_total, vip, id_location) values(40, false, 1);
insert into auditorium(seat_total, vip, id_location) values(50, false, 1);
insert into auditorium(seat_total, vip, id_location) values(30, false, 1);
insert into auditorium(seat_total, vip, id_location) values(50, false, 2);
insert into auditorium(seat_total, vip, id_location) values(15, true, 2);
insert into auditorium(seat_total, vip, id_location) values(20, false, 2);
insert into auditorium(seat_total, vip, id_location) values(50, false, 2);
insert into auditorium(seat_total, vip, id_location) values(50, false, 2);
insert into auditorium(seat_total, vip, id_location) values(50, false, 3);
insert into auditorium(seat_total, vip, id_location) values(30, true, 3);
insert into auditorium(seat_total, vip, id_location) values(50, false, 3);
insert into auditorium(seat_total, vip, id_location) values(50, false, 3);
insert into auditorium(seat_total, vip, id_location) values(50, false, 3);
insert into auditorium(seat_total, vip, id_location) values(50, false, 4);
insert into auditorium(seat_total, vip, id_location) values(20, true, 4);
insert into auditorium(seat_total, vip, id_location) values(50, false, 4);
insert into auditorium(seat_total, vip, id_location) values(50, false, 4);
insert into auditorium(seat_total, vip, id_location) values(50, false, 4);
insert into auditorium(seat_total, vip, id_location) values(30, false, 5);
insert into auditorium(seat_total, vip, id_location) values(50, true, 5);
insert into auditorium(seat_total, vip, id_location) values(50, false, 5);
insert into auditorium(seat_total, vip, id_location) values(30, false, 5);
insert into auditorium(seat_total, vip, id_location) values(50, false, 5);


-- Custommer
insert into customer(first_name,last_name,gender,email,points)value("Ryan","Gosling","M","Ryan@gmail.com",0);
insert into customer(first_name,last_name,gender,email,points)value("Leonardo","Dicaprio","M","L.D@gmail.com",0);
insert into customer(first_name,last_name,gender,email,points)value("Johnny","Depp","M","J.D@gmail.com",0);
insert into customer(first_name,last_name,gender,email,points)value("Emma","Watson","F","E.W@gmail.com",0);
insert into customer(first_name,last_name,gender,email,points)value("Harrison","Ford","M","H.F@gmail.com",0);


-- Loyalty program
insert into loyal_program(discount,minimum_points)value(10,0);
insert into loyal_program(discount,minimum_points)value(20,0);
insert into loyal_program(discount,minimum_points)value(30,0);
insert into loyal_program(discount,minimum_points)value(40,0);
insert into loyal_program(discount,minimum_points)value(50,0);
insert into loyal_program(discount,minimum_points)value(60,0);
insert into loyal_program(discount,minimum_points)value(70,0);
insert into loyal_program(discount,minimum_points)value(80,0);
insert into loyal_program(discount,minimum_points)value(90,0);
insert into loyal_program(discount,minimum_points)value(100,0);

-- Movies

Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Avengers: Endgame",1,"Anthony Ruso","Chris Evans"
,2019,182,"PG13");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("The Irishman",2,"Martin Scorsese","Robert de Niro"
,2019,210,"R");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Jocker",3," Todd Phillips","Joaquin Phoenix"
,2019,122,"R");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Star Wars: EpisodeVIII",4," Rian Johnson","Daisy Ridley"
,2017,152,"PG13");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Avatar",1,"James Cameron","Zoe Saldana"
,2009,162,"PG13");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Good Fellas",5," Martin Scorsese","Ray Liotta"
,1990,148,"R");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("A Beautiful Mind",6,"Ron Howard","Russell Crow"
,2001,140,"PG13");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("The Shawshank Redemption",1," Frank Darabont","Tim Robbinss"
,1994,142,"R");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Forrest Gump",1,"Robert Zemeckis","Tom Hanks"
,1994,142,"PG13");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Taxi Driver",4,"Martin Scorsese","Robert de Niro"
,1976,114,"R");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Schindler's List",3,"Steven Spielberg","Liam Neeson"
,1993,197,"R");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Pianist",1,"Roman Polanski","Adrien Brodyo"
,2002,150,"R");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Apollo 11",2,"Todd Douglas Miller","Neil Armstrong"
,2019,93,"G");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Catch Me If You Can",3,"Steven Spielberg","Leonardo Di Caprio"
,2002,141,"PG13");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Interestellar",1,"Christopher Nolan","Matthew McConaughey"
,2014,169,"PG13");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("2001: A Space Odyssey",9,"Stanley Kubrick","Keir Dullea"
,1968,164,"G");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("COCO",10,"Adrián Molina","Ernesto de la Cruz"
,2017,109,"PG");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Monsters, Inc.",1," Pete Docter","Boo"
,2001,96,"G");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Samsara",1,"Ron Fricke","Hiroshi Ishiguro"
,2011,102,"G");
Insert into movie (movie_name,Id_category,director,actor,movie_year,runtime_minutes,rate) values ("Pi",1,"Darren Aronofsky","Sean Gullette"
,1998,85,"R");

-- Schedule

Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-09T13:00:00",1,1,"10.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-09T15:30:00",2,2,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-09T19:00:00",3,3,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-09T23:00:00",4,4,"16.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-10T13:00:00",5,1,"10.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-10T15:00:00",6,2,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-10T19:00:00",7,3,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-10T23:00:00",8,4,"16.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-11T13:00:00",9,5,"10.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-11T15:30:00",10,6,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-11T19:00:00",11,8,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-11T23:00:00",12,9,"16.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-12T13:00:00",1,7,"10.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-12T16:00:00",2,7,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-12T13:00:00",3,10,"10.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-12T16:00:00",4,10,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-12T13:00:00",5,11,"10.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-12T16:00:00",6,11,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-13T13:00:00",5,12,"10.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-13T23:59:00",6,12,"16.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-13T15:00:00",7,13,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-13T23:59:00",8,13,"16.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-13T16:00:00",9,14,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-13T23:59:00",10,14,"16.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-14T17:00:00",11,15,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-14T23:59:00",12,15,"16.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-14T13:00:00",1,16,"10.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-14T23:59:00",1,16,"16.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-14T13:00:00",2,17,"10.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-14T21:00:00",3,17,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-15T13:00:00",4,18,"10.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-15T21:00:00",5,18,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-15T15:00:00",6,19,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-15T23:59:00",7,19,"16.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-15T15:00:00",8,20,"15.50");
Insert into theatre_schedule (showtime,id_auditorium,id_movie,price) values ("2020-04-15T23:59:00",9,20,"16.50");




