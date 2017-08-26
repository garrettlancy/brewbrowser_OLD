-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

CREATE TABLE breweries (
      brewery_id serial NOT NULL PRIMARY KEY,
      name varchar(255) NOT NULL UNIQUE,
      password varchar(255),
      address varchar(255) NOT NULL,
      address2 varchar(255),
      city varchar(255) NOT NULL,
      state varchar(255) NOT NULL,
      zip_code varchar(255) NOT NULL,
      has_food boolean,
      description text,
      img_url varchar(255),
      website varchar(255) NOT NULL,
      phone_number varchar(255) NOT NULL,
      sunday_hours varchar(255),
      monday_hours varchar(255),
      tuesday_hours varchar(255),
      wednesday_hours varchar(255),
      thursday_hours varchar(255),
      friday_hours varchar(255),
      saturday_hours varchar(255),
      lat decimal(9,6), 
      lng decimal(9,6)
);

CREATE TABLE beer_types (
		type_id serial NOT NULL PRIMARY KEY,
		name varchar(255) NOT NULL UNIQUE
);

CREATE TABLE beers (
        beer_id serial NOT NULL PRIMARY KEY,
        name varchar(255) NOT NULL UNIQUE,
        alcohol_percentage varchar(255),
        beer_img_url varchar(255),
        description text,
        type_id int,
        reviews int,
        total_rating int,
        FOREIGN KEY (type_id) REFERENCES beer_types(type_id)
);

CREATE TABLE breweries_beers (
        beer_id int NOT NULL,
        brewery_id int NOT NULL,
        FOREIGN KEY (beer_id) REFERENCES beers(beer_id),
        FOREIGN KEY (brewery_id) REFERENCES breweries(brewery_id)
);

CREATE TABLE users (
	id serial PRIMARY KEY,
	email VARCHAR(256) NOT NULL UNIQUE,
	username VARCHAR(256) NOT NULL UNIQUE,
	password VARCHAR(256) NOT NULL,
	isBrewer BOOLEAN
);

CREATE TABLE favorite_beers (
		beer_id int NOT NULL,
        user_id int NOT NULL,
        FOREIGN KEY (beer_id) REFERENCES beers(beer_id),
        FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE breweries_users (
		user_id int NOT NULL,
        brewery_id int NOT NULL,
       
        FOREIGN KEY (user_id) REFERENCES users(id),
        FOREIGN KEY (brewery_id) REFERENCES breweries(brewery_id)
        
);
CREATE TABLE reviews (
	id serial PRIMARY KEY,
	rating int NOT NULL,
	review_text VARCHAR(500) NOT NULL,
	user_id int NOT NULL,
	beer_id int NOT NULL,
	username VARCHAR(256) NOT NULL,
	
	FOREIGN KEY (username) REFERENCES users(username),
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (beer_id) REFERENCES beers(beer_id)
);

COMMIT;