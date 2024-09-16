create database homeworks;
use homeworks;

CREATE TABLE staff(
	id int primary key auto_increment,
    firstname varchar(64) not null,
    lastname varchar(64) not null,
    position varchar(128),
    age int check(age between 0 and 110),
    has_child char(1) default 'N',
    username varchar(32) unique
);



SELECT *
FROM staff;

INSERT INTO staff VALUES (1, 'John', 'Doe', '', 110, 'Y' , 'john.doe@example.ge'); 

SELECT *
FROM staff;

INSERT INTO staff VALUES 
	(2, 'Greg', 'Smith', 'Developer', 22, 'N', 'greg.smith@email.com'),
	(4, 'John', 'Brown', 'Manager', 44, 'Y', 'john.brown@email.com'),
	(5, 'Anna', 'Grey', 'HR', 34, 'Y', 'anna.grey@email.com')
;    

SELECT *
FROM staff;

INSERT INTO staff(firstname, lastname, age, username)
VALUES ('John', 'Smith', 25, 'john.smith@qq.qq'); 


SELECT *
FROM staff;

DROP TABLE staff;
DROP DATABASE homeworks;


create database homeworks;
use homeworks;

CREATE TABLE Staff (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(64) NOT NULL,
    lastname VARCHAR(64) NOT NULL,
    position VARCHAR(128),
    age INTEGER,
    has_child CHAR(1),
    username VARCHAR(128) unique
  );

INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Anna'
        , 'Daniels'
        , 'Senior Teacher'
        , 22
        , 'N'
        , 'annakhach5'
        );
        
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Tom'
        , 'Austin'
        , 'Junior Blogger'
        , 25
        , 'Y'
        , 'tom12345'
        );
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Bill'
        , 'Lorentz'
        , 'Junior Web Developer'
        , 40
        , 'Y'
        , 'billt1'
        );        
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Lily'
        , 'May'
        , 'Junior Backend Developer'
        , 25
        , 'Y'
        , 'lil12'
        );
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Nona'
        , 'Lucky'
        , 'Junior Teacher'
        , 20
        , 'N'
        , 'LuckyNona'
        ); 
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ( 'Nancy'
        , 'Greenberg'
        , 'Middle UI Designer'
        , 32
        , 'Y'
        , 'nancy1'
        );        
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Daniel'
        , 'Faviet'
        , 'Senior UX Designer'
        , 43
        , 'Y'
        , 'favietD'
        );        
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Ally'
        , 'Austin'
        , 'Junior UI Designer'
        , 28
        , 'N'
        , 'ally1'
        );        
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Lily'
        , 'Chen'
        , 'Senior Teacher'
        , 25
        , 'Y'
        , 'lilychen'
        );        
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Anna'
        , 'Austin'
        , 'Middle Teacher'
        , 34
        , 'Y'
        , 'anna28'
        );        
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Alexander'
        , 'Lorentz'
        , 'Junior Backend Developer'
        , 25
        , 'N'
        , 'alex12345'
        );        
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Ashley'
        , 'Lorentz'
        , 'Junior UX Designer'
        , 18
        , 'N'
        , 'lorentz99'
        );        
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Tom'
        , 'Lucky'
        , 'Middle Blogger'
        , 34
        , 'Y'
        , 'lucky78'
        );        
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Ashley'
        , 'Weiss'
        , 'Junior Blogger'
        , 18
        , 'N'
        , 'weiss11'
        );
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Tom'
        , 'Weiss'
        , 'Junior UI Designer'
        , 18
        , 'N'
        , 'tom222'
        );   
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Anna'
        , 'Bloom'
        , 'Middle UX Designer'
        , 20
        , 'N'
        , 'bloom5'
        );   
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Tom'
        , 'Berg'
        , 'Middle Teacher'
        , 34
        , 'N'
        , 'tommy1'
        );   
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Ashley'
        , 'Berg'
        , 'Senior Teacher'
        , 37
        , 'N'
        , 'ash89'
        );
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Lily'
        , 'Weiss'
        , 'Middle Blogger'
        , 45
        , 'N'
        , 'lilyW1'
        );   
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Anna'
        , 'Lorentz'
        , 'Senior UX Designer'
        , 31
        , 'N'
        , 'annlo1'
        );   
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Ashley'
        , 'Weiss'
        , 'Middle UX Designer'
        , 18
        , 'N'
        , 'weiss1'
        );       
INSERT INTO Staff(firstname, lastname, position, age, has_child, username) VALUES 
        ('Anna'
        , 'Keren'
        , 'Junior UX Designer'
        , 34
        , 'N'
        , 'annaK1'
        );          


SELECT *
FROM staff;

SELECT *
FROM staff
WHERE age > 20 AND age < 40; 

SELECT *
FROM staff
WHERE age < 30  OR age > 45;

SELECT
firstname, lastname, age
FROM staff
WHERE id = 3 OR id = 7 OR id = 10;

SELECT *
FROM staff
WHERE firstname LIKE 'A%' AND lastname like '%S';
