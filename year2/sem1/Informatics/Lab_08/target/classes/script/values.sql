INSERT Into client (client_id, first_name, last_name, birth_date, hire_date)
VALUES
    (1, 'client1', 'Family1', '2000-8-1', '2020-9-1'),
    (2, 'client2', 'Family2', '2000-8-2', '2020-9-2'),
    (3, 'client3', 'Family3', '2000-8-3', '2020-9-3'),
    (4, 'client4', 'Family4', '2000-8-4', '2020-9-4'),
    (5, 'client5', 'Family5', '2000-8-5', '2020-9-5'),
    (6, 'client6', 'Family6', '2000-8-6', '2020-9-6'),
    (7, 'client7', 'Family7', '2000-8-7', '2020-9-7'),
    (8, 'client8', 'Family8', '2000-8-8', '2020-9-8'),
    (9, 'client9', 'Family9', '2000-8-9', '2020-9-9'),
    (10, 'client10', 'Family10', '2000-8-10', '2020-10-10');

INSERT Into place (place_id, place_name)
VALUES
    (1, 'street 1'),
    (2, 'street 2'),
    (3, 'street 3'),
    (4, 'street 4'),
    (5, 'street 5'),
    (6, 'street 6'),
    (7, 'street 7'),
    (8, 'street 8'),
    (9, 'street 9'),
    (10, 'street 10');

INSERT Into car(car_id, model_name)
VALUES
    (1, 'model1'),
    (2, 'model2'),
    (3, 'model3'),
    (4, 'model4'),
    (5, 'model5'),
    (6, 'model6'),
    (7, 'model7'),
    (8, 'model8'),
    (9, 'model9'),
    (10, 'model10');

INSERT Into driver (driver_id, first_name, last_name, phone_number, current_car)
VALUES (1, 'driver1', 'driver21', '794452', 1),
       (2, 'driver2', 'driver22', '794452', 2),
       (3, 'driver3', 'driver23', '794452', 3),
       (4, 'driver4', 'driver24', '794452', 4),
       (5, 'driver5', 'driver25', '794452', 5),
       (6, 'driver6', 'driver26', '794452', 6),
       (7, 'driver7', 'driver27', '794452', 7),
       (8, 'driver8', 'driver28', '794452', 8),
       (9, 'driver8', 'driver29', '794452', 9),
       (10, 'driver10', 'driver30', '794452', 10);

INSERT Into trip (trip_id, departure_place, arrival_place, departure_time, arrival_time)
VALUES (1, 1, 2, '2016-06-22 19:10:25-01', '2016-06-22 19:10:25-01'),
       (2, 7, 3, '2016-06-22 19:10:25-01', '2016-06-22 19:10:25-01'),
       (3, 2, 5, '2016-06-22 19:10:25-01', '2016-06-22 19:10:25-01'),
       (4, 1, 2, '2016-06-22 19:10:25-01', '2016-06-22 19:10:25-01'),
       (5, 8, 7, '2016-06-22 19:10:25-01', '2016-06-22 19:10:25-01'),
       (6, 8, 4, '2016-06-22 19:10:25-01', '2016-06-22 19:10:25-01'),
       (7, 10, 9, '2016-06-22 19:10:25-01', '2016-06-22 19:10:25-01'),
       (8, 6, 1, '2016-06-22 19:10:25-01', '2016-06-22 19:10:25-01'),
       (9, 2, 5, '2016-06-22 19:10:25-01', '2016-06-22 19:10:25-01'),
       (10, 8, 2, '2016-06-22 19:10:25-01', '2016-06-22 19:10:25-01');

INSERT Into ride (the_client, the_driver, the_trip, price)
VALUES (1, 2, 1, 1234),
       (4, 5, 2, 876),
       (9, 7, 3, 34),
       (4, 3, 4, 993),
       (5, 2, 5, 235),
       (2, 5, 6, 285),
       (8, 5, 7, 200),
       (1, 8, 8, 205),
       (2, 4, 9, 201),
       (6, 1, 10, 10);