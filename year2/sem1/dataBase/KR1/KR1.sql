--Question 2

SELECT avg(total_amount) AS AVG,
       max(total_amount) AS MAX,
       min(total_amount) AS MIN ,
       sum(total_amount) AS SUM
FROM bookings
WHERE
	book_date between '2017-08-01' and '2017-08-31'  ;

--Question 3

SELECT passenger_name
FROM tickets ticket
WHERE (
         (SELECT total_amount
          FROM bookings
          WHERE (book_ref = ticket.book_ref)) =
         (SELECT max(total_amount)
          FROM bookings))
		  and (select book_date from bookings where bookings.book_ref = ticket.book_ref )= '2017-08-03';

--Another solution


SELECT passenger_name
FROM tickets
JOIN bookings ON tickets.book_ref = bookings.book_ref
WHERE (book_date = '2017-08-03')
  AND
    (SELECT MAX(total_amount)
     FROM bookings)= bookings.total_amount;		  

--Questino 4 
--(Грозный, Геленджик)
--select coordinates[0] from airports_data where airport_name ->> 'ru' = 'Грозный' ; l1
--select coordinates[1] from airports_data where airport_name ->> 'ru' = 'Грозный' ; f1
--select coordinates[0] from airports_data where airport_name ->> 'ru' = 'Геленджик' ; l2
--select coordinates[1] from airports_data where airport_name ->> 'ru' = 'Геленджик' ; f2
--Earth rauis = 6,371 KM
--Ответ должен умножать на радиус планета ещё ,  но при  умножения возникает ошибка (введённое значение вне диапазона)
SELECT ACOS(SIN (radians(
                           (SELECT coordinates[1]
                            FROM airports_data
                            WHERE airport_name ->> 'ru' = 'Грозный')))*SIN (radians(
                                                                                      (SELECT coordinates[1]
                                                                                       FROM airports_data
                                                                                       WHERE airport_name ->> 'ru' = 'Геленджик')))+COS (radians(
                                                                                                                                                   (SELECT coordinates[1]
                                                                                                                                                    FROM airports_data
                                                                                                                                                    WHERE airport_name ->> 'ru' = 'Грозный')))*COS (radians(
                                                                                                                                                                                                              (SELECT coordinates[1]
                                                                                                                                                                                                               FROM airports_data
                                                                                                                                                                                                               WHERE airport_name ->> 'ru' = 'Геленджик')))*ABS ((radians(
                                                                                                                                                                                                                                                                            (SELECT coordinates[0]
                                                                                                                                                                                                                                                                             FROM airports_data
                                                                                                                                                                                                                                                                             WHERE airport_name ->> 'ru' = 'Грозный')) - radians(
                                                                                                                                                                                                                                                                                                                                   (SELECT coordinates[0]
                                                                                                                                                                                                                                                                                                                                    FROM airports_data
                                                                                                                                                                                                                                                                                                                                    WHERE airport_name ->> 'ru' = 'Геленджик')))))*6371  AS Distance_Kilometer,
       'Грозный' AS departure,
       'Геленджик' AS arrival;
--Question 5 
--ветеринар       
create table Veterinarian(
  veterinarian_id serial primary key not null,
  person_name varchar,
  year_of_experience int,
  constrains check (year_of_experience>3)

);
--Конюхи
create table Owener(
  owener_id serial primary key not null,
  name varchar(70),
  age int check(age < 50 and age>20),
  veterinarian int references Veterinarian (veterinarian_id), 
  
  );  
--Конюшня
create table HourseStable (
  stable_id serial primary key not null,
  horsebox_counts int check(horsebox_counts between 10 and 50),
  owener int references Owener (owener_id),
  veterinarian int references Veterinarian (veterinarian_id)
);
--Животный
create table Animal(
  type varchar,
  breed varchar,
  gender varchar,
  age int,
  stable_id int references HourseStable(stable_id)
);

--Question 6 
SELECT passenger_id,
       passenger_name
FROM tickets tic
WHERE (
         (SELECT fare_conditions
          FROM ticket_flights
          WHERE tic.ticket_no = ticket_no) = 'Business'
       AND
         (SELECT departure_airport
          FROM flights f
          WHERE
              (SELECT flight_id
               FROM ticket_flights tif
               WHERE (tif.ticket_no = tic.ticket_no)) = f.flight_id) =
         (SELECT airport_code
          FROM airports_data
          WHERE city ->> 'ru' = 'Нижневартовск')
         --09-08-2017
       AND
       		(SELECT book_date
                             FROM bookings
                             WHERE (book_ref = tic.book_ref)) = '2017-08-09');

--Another solution
SELECT passenger_id,
       passenger_name
FROM tickets
JOIN ticket_flights ON ticket_flights.ticket_no = tickets.ticket_no
JOIN flights ON ticket_flights.flight_id = flights.flight_id
WHERE fare_conditions = 'Business'
  AND arrival_airport =
    (SELECT airport_code
     FROM airports_data
     WHERE city ->> 'ru' = 'Нижневартовск')
  AND scheduled_departure between '2017-08-09' and '2017-08-10' ;

--Question 7 
SELECT flight_no,
       scheduled_departure,
       departure_airport,
       arrival_airport
FROM flights f
JOIN tickets tic ON f.flight_id =
  (SELECT flight_id
   FROM bookings
   WHERE tic.book_ref = book_ref)
  --11-07-2017
AND
		(SELECT book_date
                      FROM bookings
                      WHERE (book_ref = tic.book_ref))= '2017-11-07' ;

--Another solution
SELECT flight_no,
       scheduled_departure,
       departure_airport,
       arrival_airport,
	   passenger_name
FROM flights
JOIN ticket_flights ON flights.flight_id =  ticket_flights.flight_id
Join tickets on tickets.ticket_no= ticket_flights.ticket_no
Join bookings on tickets.book_ref = bookings.book_ref
where book_date::date  = '2017-11-07';