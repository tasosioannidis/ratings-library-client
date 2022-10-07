INSERT INTO Reviewable_Entity(id, reviewable_type) VALUES (default, 'com.baeldung.evaluation.ratings.restaurant.domain.MenuItem');
INSERT INTO Reviewable_Entity(id, reviewable_type) VALUES (default, 'com.baeldung.evaluation.ratings.restaurant.domain.MenuItem');
INSERT INTO Reviewable_Entity(id, reviewable_type) VALUES (default, 'com.baeldung.evaluation.ratings.restaurant.domain.MenuItem');

INSERT INTO Menu_Item(id, code, name, price) VALUES (1, 'CLUB-SANDWICH', 'Club Sandwich', 3.0);
INSERT INTO Menu_Item(id, code, name, price) VALUES (2, 'VEGGIE-BOWL', 'Veggie Bowl', 2.5);
INSERT INTO Menu_Item(id, code, name, price) VALUES (3, 'PIZZA-SLICE', 'Pizza Slice', 1.5);

INSERT INTO Reviewable_Entity(id, reviewable_type) VALUES (default, 'com.baeldung.evaluation.ratings.restaurant.domain.Server');
INSERT INTO Reviewable_Entity(id, reviewable_type) VALUES (default, 'com.baeldung.evaluation.ratings.restaurant.domain.Server');

INSERT INTO Server(id, uuid, first_name, last_name) VALUES (4, uuid(), 'John', 'Doe');
INSERT INTO Server(id, uuid, first_name, last_name) VALUES (5, uuid(), 'Lara', 'Jane');

INSERT INTO Restaurant_Order(id, server_id) VALUES (default, 4);
INSERT INTO Restaurant_Order_Menu_Items(restaurant_order_id, menu_items_id) VALUES(1,1);
INSERT INTO Restaurant_Order_Menu_Items(restaurant_order_id, menu_items_id) VALUES(1,2);