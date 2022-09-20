SELECT client.first_name                       AS Client,
       driver.first_name                       AS Driver,
       car.model_name                          AS car_Model,

       (SELECT place_name
        FROM place
        WHERE place_id = trip.departure_place) AS departure,
       (SELECT place_name
        FROM place
        WHERE place_id = trip.arrival_place)   AS arrival

FROM ride
         JOIN client ON ride.the_client = client.client_id
         JOIN driver ON ride.the_driver = driver.driver_id
         JOIN car ON driver.current_car = car.car_id
         JOIN trip ON ride.the_trip = trip.trip_id
         JOIN place ON trip.arrival_place = place.place_id;