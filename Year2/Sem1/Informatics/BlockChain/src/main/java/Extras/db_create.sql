CREATE TABLE block_info(
                           id serial primary KEY ,
                           info JSON
);

CREATE TABLE block_data(
                           block_id int  REFERENCES block_info(id),
                           prev_hash varchar(2048) ,
                           public_key varchar(2048),
                           signature varchar(2048) ,
                           block_formation_date varchar
);
