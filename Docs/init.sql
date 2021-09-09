--Customers
insert into customers (customer_id, name) values (1,'Customer 1');
insert into customers (customer_id, name) values (2,'Customer 2');
insert into customers (customer_id, name) values (3,'Customer 3');
insert into customers (customer_id, name) values (4,'Customer 4');
insert into customers (customer_id, name) values (5,'Customer 5');
insert into customers (customer_id, name) values (6,'Customer 6');

--Strategies
insert into strategies (strategy_id, points, lower_limit) values (1, 2, 100);
insert into strategies (strategy_id, points, lower_limit, upper_limit) values (2, 1, 50,100);

--Purchases to test
insert into purchases (purchase_id, customer_id, total, date) values (1,1,120, '2021-09-01');

insert into purchases (purchase_id, customer_id, total, date) values (2,2,102, '2021-09-01');
insert into purchases (purchase_id, customer_id, total, date) values (3,2,120, '2021-08-01');
insert into purchases (purchase_id, customer_id, total, date) values (4,2,120, '2021-07-01');
insert into purchases (purchase_id, customer_id, total, date) values (5,2,110, '2021-07-01');

insert into purchases (purchase_id, customer_id, total, date) values (6,3,100, '2021-09-01');
insert into purchases (purchase_id, customer_id, total, date) values (7,3,100, '2021-04-01');
insert into purchases (purchase_id, customer_id, total, date) values (8,3,100, '2021-03-01');

insert into purchases (purchase_id, customer_id, total, date) values (9,4,65, '2021-07-01');

insert into purchases (purchase_id, customer_id, total, date) values (10,5,20, '2021-07-01');

insert into purchases (purchase_id, customer_id, total, date) values (11,6,140, '2021-07-01');

