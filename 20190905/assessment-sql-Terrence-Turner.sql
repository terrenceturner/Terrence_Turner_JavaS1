-- assessment-sql-Terrence-Turner
/*
What are the categories of products in the database?
customers
employees
order_details
orders
products
*/

-- What products are made by Dell?
select * from northwind.products where product_name like 'Dell%';

-- List all the orders shipped to Pennsylvania.
select * from northwind.orders where ship_state = 'Pennsylvania';

-- List the first name and last name of all employees with last names that start with w
select * from northwind.employees where last_name like 'W%';

-- List all customers from zipcodes that start with 55
select * from northwind.customers where postal_code like '55%';

-- List all customers from zipcodes that end with 0
select * from northwind.customers where postal_code like '%0';

-- List the first name, last name, and email for all customers with a .org email address
select first_name, last_name, email from northwind.customers where email like '%.org';

-- List the first name, last name, and phone number for all customers from the 202 area code
select first_name, last_name, phone from northwind.customers where phone like '%202%';

-- List the order id for each order placed by George Wilson
select orders.id from orders 
inner join customers on customers.id = orders.customer_id
where first_name = 'George' and last_name = 'Wilson';

-- List all the products and quantities associated with order 4003
select products.product_name, order_details.quantity from products
inner join order_details on order_details.product_id = product_id
inner join orders on orders.id = order_details.order_id
where orders.id = 4003;

-- car_lot schema
-- Create this schema and table
create schema car_lot;
-- make car_lot the default schema
use car_lot;

create table car(
	id int not null,
    make varchar(50),
    model varchar(50),
    model_year varchar(4),
    color varchar(50),
    primary key (id)
);

select * from car;

SET SQL_SAFE_UPDATES = 0;

-- Add the following cars to inventory:
-- 2012 Red Honda Accord
INSERT INTO car_lot.car (id, make, model, model_year, color) 
VALUES (3, 'Honda', 'Accord', '2012', 'Red');
-- 2017 Black Chevy Impala
INSERT INTO car_lot.car (id, make, model, model_year, color) 
VALUES (4, 'Chevy', 'Impala', '2017', 'Black');
-- 2019 Siver Ford F-150
INSERT INTO car_lot.car (id, make, model, model_year, color) 
VALUES (5, 'Ford', 'F-150', '2019', 'Silver');
-- 2020 White Subaru Outback
INSERT INTO car_lot.car (id, make, model, model_year, color) 
VALUES (6, 'Subaru', 'Outback', '2020', 'White');
-- 2015 Silver Ford Mustang
INSERT INTO car_lot.car (id, make, model, model_year, color) 
VALUES (7, 'Ford', 'Mustang', '2015', 'Silver');
-- 2018 Blue Honda Ridgeline
INSERT INTO car_lot.car (id, make, model, model_year, color) 
VALUES (8, 'Honda', 'Ridgeline', '2018', 'Blue');
-- 2017 Gray Chevy Silverado
INSERT INTO car_lot.car (id, make, model, model_year, color) 
VALUES (9, 'Chevy', 'Silverado', '2017', 'Gray');


-- Make the following updates to the database:
-- Change all Hondas to Black
update car set color = 'Black'
where make = 'Honda';
-- Change 'Chevy' to 'Chevrolet'
update car set make = 'Chevrolet'
where make = 'Chevy';
-- Change all 2020 model years to 2019
update car set model_year = '2019'
where model_year = '2020';


-- Delete the following:
-- Delete all blue inventory
delete from car
where color = 'Blue';
-- Delete all Fords
delete from car
where make = 'Ford';
-- Delete all cars from 2012 and 2017
delete from car
where model_year between 2012 and 2017;

