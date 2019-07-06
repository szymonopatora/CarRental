insert into branch (id,city,country,street,zip_code) values
(1,'Lubin','Poland','Wierzbowa','59-300'),
(2,'Gdynia','Poland','Kwiatowa','65-832'),
(3,'Wrocław','Poland','Fabryczna','78-217'),
(4,'Poznań','Poland','Maszynowa','61-623'),
(5,'Torzym','Poland','Kolorowa','66-600'),
(6,'Kraków','Poland','Smocza','50-831');

insert into car (id, year_of_production, body, brand, color, model, rental_fee, status, branch_id) values
(1,2018,1,'Toyota','white','Corolla',100,2,2),
(2,2018,4,'Dacia','brown','Duster',110,2,5),
(3,2014,5,'Volswagen','navy blue','Passat',50,2,3),
(4,2019,2,'Mercedes','silver','C',120,2,1),
(5,2017,1,'Citroen','grey','C4',100,2,4),
(6,2019,4,'Toyota','white','RAV4',130,2,6);

insert into role (id, role_name) values
(1, 'Admin'),
(2, 'Customer'),
(3, 'Manager'),
(4, 'Employee');