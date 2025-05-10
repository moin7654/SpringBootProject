create table if not exists book(id int AUTO_INCREMENT primary key,
title varchar(50), about text,
author varchar(100), language varchar(30),
available boolean default true
);