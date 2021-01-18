insert into tenant1.warehouse(id, amount) values(1, 1);
insert into tenant1.warehouse(id, amount) values(2, 3);
insert into tenant1.warehouse(id, amount) values(3, 5);
insert into tenant1.warehouse(id, amount) values(4, 7);

insert into tenant1.product (id, name, description, price, warehouse_id) values (1, 'Chleb', 'Chleb pszenny', 5.45, 1);
insert into tenant1.product (id, name, description, price, warehouse_id) values (2, 'Maslo', 'Maslo prawdziwe', 4.99, 2);
insert into tenant1.product (id, name, description, price, warehouse_id) values (3, 'Pomidor', 'Pomidor pochodzenia lokalnego', 1.24, 3);
insert into tenant1.product (id, name, description, price, warehouse_id) values (4, 'Marchew', 'Marchew pochodzenia lokalnego', 2.89, 4);

insert into tenant2.warehouse(id, amount) values(1, 11);
insert into tenant2.warehouse(id, amount) values(2, 14);
insert into tenant2.warehouse(id, amount) values(3, 21);
insert into tenant2.warehouse(id, amount) values(4, 23);

insert into tenant2.product (id, name, description, price, warehouse_id) values (1, 'Koszulka', 'Koszulka z nadrukiem', 19.99, 1);
insert into tenant2.product (id, name, description, price, warehouse_id) values (2, 'Sweter', 'Damski stylowy sweterek', 49.09, 2);
insert into tenant2.product (id, name, description, price, warehouse_id) values (3, 'T-Shirt', 'T-shirt ze śmiesznym nadrukiem', 15.22, 3);
insert into tenant2.product (id, name, description, price, warehouse_id) values (4, 'Jeans', 'Spodnie niebieskie', 69.51, 4);
