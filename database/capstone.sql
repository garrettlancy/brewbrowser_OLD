CREATE TABLE breweries (
      brew_id serial NOT NULL PRIMARY KEY,
      name varchar(255) NOT NULL,
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
      saturday_hours varchar(255)
);

CREATE TABLE beers (
        beer_id serial NOT NULL PRIMARY KEY,
        name varchar(255) NOT NULL,
        alcohol_percentage int,
        beer_img_url varchar(255),
        description text,
        type_id int
);

CREATE TABLE breweries_beers (
        beer_id int NOT NULL,
        brew_id int NOT NULL,
        FOREIGN KEY (beer_id) REFERENCES beers(beer_id),
        FOREIGN KEY (brew_id) REFERENCES breweries(brew_id)

);

INSERT INTO breweries (name, address, city, state, zip_code, has_food, description, website, phone_number, sunday_hours, monday_hours, tuesday_hours, wednesday_hours, thursday_hours, friday_hours, saturday_hours)
VALUES ('DogBerry', '9964 Crescent Park Dr.', 'West Chester', 'OH', '45069', false, 'Great beer is crafted from great ingredients. Staying true to our local roots, whenever possible we source the freshest ingredients from local & region producers. We feel this gives our beer a unique flavor profile found only in this area.', 'https://www.dogberrybrewing.com/', '(513)-847-8208', '12pm - 8pm', 'Closed', 'Closed', '2pm - 9pm', '2pm - 9pm', '2pm - 11pm', '12pm - 11pm');

INSERT INTO breweries (name, address, city, state, zip_code, has_food, description, website, phone_number, sunday_hours, monday_hours, tuesday_hours, wednesday_hours, thursday_hours, friday_hours, saturday_hours)
VALUES ('Jackie O''s', '25 Campbell St.', 'Athens', 'OH', '45701', true, 'In March 2013, after eighteen months of building and planning, Jackie O’s started a new chapter at our production facility at 25 Campbell Street when we began packaging beers into kegs. Two months later we fired up the line and canned Firefly Amber and Chomolungma, and the rest has been history in the making.', 'http://jackieos.com/', '(740) 592-9686', '12pm - 7pm', '11am - 9pm', '11am - 9pm', '11am - 9pm', '11am - 9pm', '11am - 9pm', '11am - 9pm');

INSERT INTO breweries (name, address, city, state, zip_code, has_food, description, website, phone_number, sunday_hours, monday_hours, tuesday_hours, wednesday_hours, thursday_hours, friday_hours, saturday_hours)
VALUES ('Columbus Brewing Company', '2555 Harrison Road.', 'Columbus', 'OH', '43204', false, 'Columbus Brewing Company is an independent craft brewery dedicated to exploring the flavors of American hops. Best known for Columbus IPA and Bodhi, we also enjoy the subtleties of German-style lagers, the intense characteristics of barrel aged beers and everything in between. We have designed and built our new brewery to make more beer, but also to allow us to explore new frontiers.', 'https://www.columbusbrewing.com/', '(614) 224-3626', 'Closed', '8am - 5pm', '8am - 5pm', '8am - 5pm', '8am - 5pm', '8am - 5pm', 'Closed');

INSERT INTO breweries (name, address, city, state, zip_code, has_food, description, website, phone_number, sunday_hours, monday_hours, tuesday_hours, wednesday_hours, thursday_hours, friday_hours, saturday_hours)
VALUES ('Fibonacci Brewing Co', '1445 Compton Rd.', 'Mt. Healthy', 'OH', '45231', false, 'A nanobrewery that produces high quality craft beers in a laid back, casual environment in Mt Healthy, Ohio. Our entire craft beer lineup is available for consumption on site, while growlers to go is subject to availability. We produce a wide variety of craft beers, concentrating on non-traditional and hybrid beer styles, that appeal to all beer drinkers ranging from casual beer drinkers to the beer connoisseurs.', 'http://fibbrew.com/', '(513) 832-1422', '12pm - 10pm', 'Closed', 'Closed', '5pm - 10pm', '5pm - 10pm', '5pm - 12am', '12pm - 10am');

INSERT INTO breweries (name, address, city, state, zip_code, has_food, description, website, phone_number, sunday_hours, monday_hours, tuesday_hours, wednesday_hours, thursday_hours, friday_hours, saturday_hours)
VALUES ('Catawba Island Brewing Company', '2330 E Harbor Rd.', 'Port Clinton', 'OH', '43452', true, 'Catawba Island Brewing Company is a small production brewery on the beautiful Catawba Island on the shores of Lake Erie.
Our Tasting Room boasts plenty of natural light, plenty of comfortable indoor and outdoor seating, and a laid-back Nautical-Industrial atmosphere. We offer live acoustic music, pinball league, good company, and education about different types of beer. A Hard Cider, Mead, a selection of Wine, Bourbon and Scotch round out the adult beverages available at the tasting room.', 'https://www.facebook.com/CatawbaIslandBrewingCo/', '(419) 960-7764', '1pm - 8pm', '4pm - 11pm', '4pm - 11pm', '4pm - 11pm', '4pm - 11pm', '1pm - 11pm', '1pm - 11pm');

