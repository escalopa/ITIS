DROP TABLE if exists client cascade;
CREATE TABLE client
(

    client_id  int PRIMARY KEY NOT NULL,
    first_name VARCHAR(255)    NOT NULL,
    last_name  VARCHAR(255)    NOT NULL,
    birth_date DATE            NOT NULL,
    hire_date  DATE            NOT NULL
);

DROP TABLE if exists place cascade;
CREATE TABLE place
(
    place_id   int PRIMARY KEY NOT NULL,
    place_name VARCHAR(255)    NOT NULL
);

DROP TABLE if exists car cascade;
CREATE TABLE car
(
    car_id     int PRIMARY KEY NOT NULL,
    model_name VARCHAR(255)    NOT NULL
);

DROP TABLE if exists driver cascade;
CREATE TABLE driver
(
    driver_id    int PRIMARY KEY NOT NULL,
    first_name   VARCHAR(255)    NOT NULL,
    last_name    VARCHAR(255)    NOT NULL,
    phone_number VARCHAR(20),
    current_car  int references car (car_id)
);

DROP TABLE if exists trip cascade;
CREATE TABLE trip
(
    trip_id         int PRIMARY KEY                 NOT NULL,
    departure_place int references place (place_id),
    arrival_place   int references place (place_id) NOT NULL,
    departure_time  TimeStamp,
    arrival_time    TimeStamp
);

DROP TABLE if exists ride cascade;
CREATE TABLE ride
(
    the_client int references client (client_id),
    the_driver int references driver (driver_id),
    the_trip   int references trip (trip_id),
    price      int NOT NULL
);


