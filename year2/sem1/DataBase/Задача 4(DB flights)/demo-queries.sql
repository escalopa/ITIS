--Задача 1 
--WITH dep_city AS (
--   SELECT airport_code FROM airports_data WHERE city ->> 'ru' = 'казань'
--), arr_city AS (
--	SELECT airport_code FROM airports_data WHERE city ->> 'ru' = 'Краснодар'
--)

SELECT * FROM flights f WHERE f.departure_airport = (SELECT airport_code FROM airports_data WHERE city ->> 'ru' = 'Казань') 
AND f.arrival_airport = (SELECT airport_code FROM airports_data WHERE city ->> 'ru' = 'Краснодар');

--Задача 2

select * from flights f where (SELECT city ->> 'ru' FROM airports_data where airport_code = f.departure_airport )='Москва' and actual_departure between '2017-07-30 12:30:00+03' and (	timestamp '2017-07-30 12:30:00+03' + 25 * interval '1 minutes'); 

--Задача 3

select * from airports_data a join flights f on a.airport_code  = f.departure_airport and a.timezone= 'Europe/Moscow';
