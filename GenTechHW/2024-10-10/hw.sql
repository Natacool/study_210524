CREATE DATABASE shop;

USE shop;

CREATE TABLE SELLERS(
       SELL_ID    INTEGER, 
       SNAME   VARCHAR(20), 
       CITY    VARCHAR(20), 
       COMM    NUMERIC(2, 2),
             BOSS_ID  INTEGER
);
                                            
CREATE TABLE CUSTOMERS(
       CUST_ID    INTEGER, 
       CNAME   VARCHAR(20), 
       CITY    VARCHAR(20), 
       RATING  INTEGER
);

CREATE TABLE ORDERS(
       ORDER_ID  INTEGER, 
       AMT     NUMERIC(7,2), 
       ODATE   DATE, 
       CUST_ID    INTEGER,
       SELL_ID    INTEGER 
);

INSERT INTO SELLERS VALUES(201,'Олег','Москва',0.12,202);
INSERT INTO SELLERS VALUES(202,'Лев','Сочи',0.13,204);
INSERT INTO SELLERS VALUES(203,'Арсений','Владимир',0.10,204);
INSERT INTO SELLERS VALUES(204,'Екатерина','Москва',0.11,205);
INSERT INTO SELLERS VALUES(205,'Леонид ','Казань',0.15,NULL);


INSERT INTO CUSTOMERS VALUES(301,'Андрей','Москва',100);
INSERT INTO CUSTOMERS VALUES(302,'Михаил','Тула',200);
INSERT INTO CUSTOMERS VALUES(303,'Иван','Сочи',200);
INSERT INTO CUSTOMERS VALUES(304,'Дмитрий','Ярославль',300);
INSERT INTO CUSTOMERS VALUES(305,'Руслан','Москва',100);
INSERT INTO CUSTOMERS VALUES(306,'Артём','Тула',100);
INSERT INTO CUSTOMERS VALUES(307,'Юлия','Сочи',300);


INSERT INTO ORDERS VALUES(101,18.69,'2022-03-10',308,207);
INSERT INTO ORDERS VALUES(102,5900.1,'2022-03-10',307,204);
INSERT INTO ORDERS VALUES(103,767.19,'2022-03-10',301,201);
INSERT INTO ORDERS VALUES(104,5160.45,'2022-03-10',303,202);
INSERT INTO ORDERS VALUES(105,1098.16,'2022-03-10',308,207);
INSERT INTO ORDERS VALUES(106,75.75,'2022-04-10',304,202); 
INSERT INTO ORDERS VALUES(107,4723,'2022-05-10',306,201);
INSERT INTO ORDERS VALUES(108,1713.23,'2022-04-10',302,203);
INSERT INTO ORDERS VALUES(109,1309.95,'2022-06-10',304,203);
INSERT INTO ORDERS VALUES(110,9891.88,'2022-06-10',306,201);


-- Вывести имя продавца и сумму его заказов.
SELECT sellers.SNAME, SUM(orders.AMT)
FROM orders
JOIN sellers 
ON sellers.SELL_ID = orders.SELL_ID GROUP BY sellers.SNAME;

-- Вывести имя клиента и сумму его заказов.
SELECT customers.CNAME, SUM(orders.AMT)
FROM orders
JOIN customers 
ON customers.CUST_ID = orders.CUST_ID GROUP BY customers.CNAME;

-- Вывести всех продавцов, включая тех, у кого нет заказов.
SELECT sellers.SNAME
FROM sellers;

-- Вывести все заказы, включая информацию о продавцах, даже если не все продавцы сделали заказы.
SELECT orders.ORDER_ID, orders.ODATE, orders.AMT, sellers.SNAME, sellers.CITY
FROM orders
LEFT JOIN sellers 
ON orders.SELL_ID = sellers.SELL_ID;

-- Вывести продавцов и их начальников.
SELECT t1.SNAME AS SELLER, t2.SNAME AS BOSS
FROM sellers t1
LEFT JOIN sellers t2
ON t1.BOSS_ID = t2.SELL_ID;

-- Найти всех клиентов из города "Москва" и суммы их заказов.
SELECT customers.CNAME, customers.CITY, SUM(orders.AMT) as ORDER_SUM
FROM customers
JOIN orders -- with left if customers are needed even they didn't make any order 
ON customers.CUST_ID = orders.CUST_ID WHERE customers.CITY = 'Москва' GROUP BY customers.CNAME;

-- Найти всех продавцов из города "Сочи" и их заказы, если таковые имеются.
SELECT sellers.SNAME, sellers.CITY, orders.ORDER_ID, orders.ODATE, orders.AMT 
FROM sellers
JOIN orders
ON sellers.SELL_ID = orders.SELL_ID and sellers.CITY = 'Сочи';

-- Найти всех клиентов с заказами выше 5000 и информацию о продавцах, которые их обслуживали.
SELECT customers.CNAME AS customer_name, orders.AMT as order_amount, sellers.SNAME AS seller_name
FROM customers
JOIN orders
ON customers.CUST_ID = orders.CUST_ID  AND orders.AMT > 5000
JOIN sellers
ON orders.SELL_ID = sellers.SELL_ID;

-- Найти всех продавцов, у которых есть начальники.
SELECT t1.SNAME AS SELLER, t2.SNAME AS BOSS
FROM sellers t1
JOIN sellers t2
ON t1.BOSS_ID = t2.SELL_ID;

-- Вывести пары покупателей и обслуживших их продавцов из одного города.
SELECT customers.CNAME as customer_name, customers.CITY as customer_city, orders.ORDER_ID, sellers.SNAME as seller_name, sellers.CITY as seller_city
FROM customers
LEFT JOIN orders
ON customers.CUST_ID = orders.CUST_ID
JOIN sellers
ON orders.SELL_ID = sellers.SELL_ID AND customers.CITY = sellers.CITY;


