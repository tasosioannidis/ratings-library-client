INSERT INTO Menu_Item(id, code, name, price) VALUES (default, 'CLUB-SANDWICH', 'Club Sandwich', 3.0);
INSERT INTO Menu_Item(id, code, name, price) VALUES (default, 'VEGGIE-BOWL', 'Veggie Bowl', 2.5);
INSERT INTO Menu_Item(id, code, name, price) VALUES (default, 'PIZZA-SLICE', 'Pizza Slice', 1.5);

INSERT INTO Server(id, uuid, first_name, last_name) VALUES (default, uuid(), 'John', 'Doe');
INSERT INTO Server(id, uuid, first_name, last_name) VALUES (default, uuid(), 'Lara', 'Jane');

INSERT INTO Restaurant_Order(id, server_id) VALUES (default, 1);
INSERT INTO Restaurant_Order_Menu_Items(restaurant_order_id, menu_items_id) VALUES(1,1);
INSERT INTO Restaurant_Order_Menu_Items(restaurant_order_id, menu_items_id) VALUES(1,2);