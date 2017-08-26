-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

INSERT INTO breweries (name, password, address, city, state, zip_code, has_food, description, img_url, website, phone_number, sunday_hours, monday_hours, tuesday_hours, wednesday_hours, thursday_hours, friday_hours, saturday_hours, lat, lng)
VALUES ('DogBerry', 'Dogberry.123', '9964 Crescent Park Dr.', 'West Chester', 'OH', '45069', false, 'Great beer is crafted from great ingredients. Staying true to our local roots, whenever possible we source the freshest ingredients from local & region producers. We feel this gives our beer a unique flavor profile found only in this area.', 'DogBerry.jpg', 'https://www.dogberrybrewing.com/', '(513)-847-8208', '12pm - 8pm', 'Closed', 'Closed', '2pm - 9pm', '2pm - 9pm', '2pm - 11pm', '12pm - 11pm', 39.9611800, -82.9987900);

INSERT INTO breweries (name, password, address, city, state, zip_code, has_food, description, img_url, website, phone_number, sunday_hours, monday_hours, tuesday_hours, wednesday_hours, thursday_hours, friday_hours, saturday_hours)
VALUES ('Jackie O''s', 'JackieOs.123', '25 Campbell St.', 'Athens', 'OH', '45701', true, 'In March 2013, after eighteen months of building and planning, Jackie O’s started a new chapter at our production facility at 25 Campbell Street when we began packaging beers into kegs. Two months later we fired up the line and canned Firefly Amber and Chomolungma, and the rest has been history in the making.', 'JackieOs.jpg', 'http://jackieos.com/', '(740) 592-9686', '12pm - 7pm', '11am - 9pm', '11am - 9pm', '11am - 9pm', '11am - 9pm', '11am - 9pm', '11am - 9pm');

INSERT INTO breweries (name, password, address, city, state, zip_code, has_food, description, img_url, website, phone_number, sunday_hours, monday_hours, tuesday_hours, wednesday_hours, thursday_hours, friday_hours, saturday_hours)
VALUES ('Columbus Brewing Company', 'ColumbusBrewingCompany.123', '2555 Harrison Road.', 'Columbus', 'OH', '43204', false, 'Columbus Brewing Company is an independent craft brewery dedicated to exploring the flavors of American hops. Best known for Columbus IPA and Bodhi, we also enjoy the subtleties of German-style lagers, the intense characteristics of barrel aged beers and everything in between. We have designed and built our new brewery to make more beer, but also to allow us to explore new frontiers.', 'Columbus.jpg', 'https://www.columbusbrewing.com/', '(614) 224-3626', 'Closed', '8am - 5pm', '8am - 5pm', '8am - 5pm', '8am - 5pm', '8am - 5pm', 'Closed');

INSERT INTO breweries (name, password, address, city, state, zip_code, has_food, description, img_url, website, phone_number, sunday_hours, monday_hours, tuesday_hours, wednesday_hours, thursday_hours, friday_hours, saturday_hours)
VALUES ('Fibonacci Brewing Company', 'FibonacciBrewingCompany.123', '1445 Compton Rd.', 'Mt. Healthy', 'OH', '45231', false, 'A nanobrewery that produces high quality craft beers in a laid back, casual environment in Mt Healthy, Ohio. Our entire craft beer lineup is available for consumption on site, while growlers to go is subject to availability. We produce a wide variety of craft beers, concentrating on non-traditional and hybrid beer styles, that appeal to all beer drinkers ranging from casual beer drinkers to the beer connoisseurs.', 'Fibonacci.jpg', 'http://fibbrew.com/', '(513) 832-1422', '12pm - 10pm', 'Closed', 'Closed', '5pm - 10pm', '5pm - 10pm', '5pm - 12am', '12pm - 10am');

INSERT INTO breweries (name, password, address, city, state, zip_code, has_food, description, img_url, website, phone_number, sunday_hours, monday_hours, tuesday_hours, wednesday_hours, thursday_hours, friday_hours, saturday_hours)
VALUES ('Catawba Island Brewing Company', 'CatawbaIslandBrewingCompany.123', '2330 E Harbor Rd.', 'Port Clinton', 'OH', '43452', true, 'Catawba Island Brewing Company is a small production brewery on the beautiful Catawba Island on the shores of Lake Erie.
Our Tasting Room boasts plenty of natural light, plenty of comfortable indoor and outdoor seating, and a laid-back Nautical-Industrial atmosphere. We offer live acoustic music, pinball league, good company, and education about different types of beer. A Hard Cider, Mead, a selection of Wine, Bourbon and Scotch round out the adult beverages available at the tasting room.', 'CatawbaIsland.jpg', 'https://www.facebook.com/CatawbaIslandBrewingCo/', '(419) 960-7764', '1pm - 8pm', '4pm - 11pm', '4pm - 11pm', '4pm - 11pm', '4pm - 11pm', '1pm - 11pm', '1pm - 11pm');

INSERT INTO breweries (name, password, address, city, state, zip_code, has_food, description, img_url, website, phone_number, sunday_hours, monday_hours, tuesday_hours, wednesday_hours, thursday_hours, friday_hours, saturday_hours)
VALUES ('Market Garden Brewery', 'MarketGardenBrewery.123', '1947 W 25TH ST', 'Cleveland', 'OH', '44113', true, 'Market Garden Brewery,  located next door to the 100 year old West Side Market, has been stocked with a lineup of tasty, session beers like our award-winning Progress Pilsner, our organically hopped Citramax IPA, as well as Prosperity, our Bavarian style Hefeweizen, since 2011. Our  35,000 square foot  Production facility is now open for our Store & Tours on weekends, happening on the hour, every hour. Just follow the BEER! sign.', 'CatawbaIsland.jpg', 'https://www.marketgardenbrewery.com', '(216) 621-4000', '1pm - 9pm', '4pm - 11pm', '4pm - 11pm', '4pm - 11pm', '4pm - 11pm', '1pm - 11pm', '1pm - 11pm');

INSERT INTO beer_types (name)
VALUES ('Stout');

INSERT INTO beer_types (name)
VALUES ('Lager');

INSERT INTO beer_types (name)
VALUES ('IPA');

INSERT INTO beer_types (name)
VALUES ('Doppelbock');

INSERT INTO beer_types (name)
VALUES ('Hefeweizen');

INSERT INTO beer_types (name)
VALUES ('Blonde');

INSERT INTO beer_types (name)
VALUES ('Pilsner');
INSERT INTO beer_types (name)
VALUES ('Pale Ale');
INSERT INTO beer_types (name)
VALUES ('Sour Ale');
INSERT INTO beers (name, alcohol_percentage, beer_img_url, description, type_id, reviews, total_rating)
VALUES ('Citra', '5.5%', 'Citra.jpg', 'Light in color, mild bitterness, bright citrus hop aroma and flavor.', 3, 3, 12);
INSERT INTO beers (name, alcohol_percentage, beer_img_url, description, type_id, reviews, total_rating)
VALUES ('Berliner Weisse', '5.5%', 'BerlinerWeisse.jpg', 'Sour wheat ale fermented with Jackie O''s house lactobacillus and brettanomyces cultures. Produced via a unique Solera method ensuring consistency and variation over time. This is not a kettle sour.', 9, 2, 6);
INSERT INTO beers (name, alcohol_percentage, beer_img_url, description, type_id, reviews, total_rating)
VALUES ('Thunderlips', '5.3%', 'Thunderlips.jpg', 'This deep golden Pale Ale is brewed with Simpsons Golden Promise malt to create a backbone for thunderous additions of Mosaic® and Equinox® hops.', 8, 1, 4);
INSERT INTO beers (name, alcohol_percentage, beer_img_url, description, type_id, reviews, total_rating)
VALUES ('The Tollhouse', '7.9%', 'TheTollhouse.jpg', 'Jet black color with moderate bitterness. Strong roasted coffee flavor and aroma with hints of chocolate.', 1, 6 , 25);


INSERT INTO breweries_beers (beer_id, brewery_id)
VALUES (1,1);

INSERT INTO breweries_beers (beer_id, brewery_id)
VALUES (2,2);

INSERT INTO breweries_beers (beer_id, brewery_id)
VALUES (3,3);

INSERT INTO breweries_beers (beer_id, brewery_id)
VALUES (4,4);

INSERT INTO users (email, username, password, isBrewer) VALUES ('test@email.com', 'test', '12345678', true);

INSERT INTO breweries_users (user_id, brewery_id)
VALUES (1, 1);
COMMIT;