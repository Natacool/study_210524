-- task 1 Создать БД Shop, используя следующие данные: https://github.com/NelliEfr/MySQL_databases/blob/main/shop.txt

CREATE DATABASE shop2;

USE shop2;

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


SELECT *
FROM customers;

SELECT *
FROM orders;

SELECT *
FROM sellers;


-- Определить какие из покупок были совершены в июне
select *
from orders
where month(odate) = 6;


-- Определить какие из покупок были совершены в интервале от 10 апреля 2022 до 10 мая 2022 года
select *
from orders
where date(odate) >= '2022-04-10' and date(odate) <= '2022-05-10';


-- Определить сколько покупок было совершено в марте
select count(ORDER_ID) as "Amount of order in March"
from orders
where monthname(odate) = 'March';


-- Определить среднюю стоимость покупок в марте
select avg(AMT) as "Average of orders in March"
from orders
where month(odate) = 3;


-- Выведите минимальный рейтинг(rating) покупателя среди сделавших заказ в апреле 2022 года.
-- select *
select RATING
from orders
join customers
on customers.CUST_ID = orders.CUST_ID
where month(odate) = 4 and year(odate) = 2022
order by RATING ASC limit 1;


-- Выведите продавцов, которые оформили заказ на наибольшую сумму в период с 1 марта по 1 май 2022 года.
-- Вывести : sell_id, amt
-- select *
select sellers.SELL_ID, AMT
from sellers
join orders
on sellers.SELL_ID = orders.SELL_ID
where date(odate) >= '2022-03-01' and date(odate) <= '2022-05-01'
order by AMT DESC limit 1;


-- Определить какие покупки были совершены во вторник
select *
from orders
where dayname(odate) = 'Tuesday';
