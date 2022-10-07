INSERT INTO Menu_Item(id, code, name, price, reviewable_type) VALUES (default, 'CLUB-SANDWICH', 'Club Sandwich', 3.0, 'com.baeldung.evaluation.ratings.restaurant.domain.MenuItem');
INSERT INTO Menu_Item(id, code, name, price, reviewable_type) VALUES (default, 'VEGGIE-BOWL', 'Veggie Bowl', 2.5, 'com.baeldung.evaluation.ratings.restaurant.domain.MenuItem');
INSERT INTO Menu_Item(id, code, name, price, reviewable_type) VALUES (default, 'PIZZA-SLICE', 'Pizza Slice', 1.5, 'com.baeldung.evaluation.ratings.restaurant.domain.MenuItem');

INSERT INTO Server(id, uuid, first_name, last_name, reviewable_type) VALUES (default, uuid(), 'John', 'Doe', 'com.baeldung.evaluation.ratings.restaurant.domain.Server');
INSERT INTO Server(id, uuid, first_name, last_name, reviewable_type) VALUES (default, uuid(), 'Lara', 'Jane', 'com.baeldung.evaluation.ratings.restaurant.domain.Server');

INSERT INTO Restaurant_Order(id, server_id) VALUES (default, 1);
INSERT INTO Restaurant_Order_Menu_Items(restaurant_order_id, menu_items_id) VALUES(1,1);
INSERT INTO Restaurant_Order_Menu_Items(restaurant_order_id, menu_items_id) VALUES(1,2);