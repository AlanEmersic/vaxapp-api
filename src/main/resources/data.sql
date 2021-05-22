delete
from vaccine;
delete
from side_effect;

insert into vaccine (id, manufacturer_name, research_name, number_of_shots, available_doses, type)
values (1, 'Pfizer', 'BNT162B2', 2, 100, 'VIRAL_VECTOR');

insert into vaccine (id, manufacturer_name, research_name, number_of_shots, available_doses, type)
values (2, 'AstraZeneca', 'AZD1222', 1, 200, 'VIRAL_VECTOR');

insert into vaccine (id, manufacturer_name, research_name, number_of_shots, available_doses, type)
values (3, 'Moderna', 'MRNA-1273', 2, 5000, 'MRNA');

insert into vaccine (id, manufacturer_name, research_name, number_of_shots, available_doses, type)
values (4, 'Johnson & Johnson', 'JNJ-78436735', 1, 2000, 'MRNA');


insert into side_effect (id, short_description, description, frequency, vaccine)
values (1, 'Crvenilo', 'U području oko mjesta uboda moguća je pojava crvenila', 5, 1);

insert into side_effect (id, short_description, description, frequency, vaccine)
values (2, 'Alergija', 'Moguća je pojava alergijske reakcije', 3, 2);

insert into side_effect (id, short_description, description, frequency, vaccine)
values (3, 'Temperatura', 'Moguća je pojava povišene temperature', 1, 3);

insert into side_effect (id, short_description, description, frequency, vaccine)
values (4, 'Kašalj', 'Moguća je pojava kašlja', 2, 4);


insert into user (id, username, password, first_name, last_name)
values (1, 'admin', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'admin', 'admin'); --password=test
insert into user (id, username, password, first_name, last_name)
values (2, 'user', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'user', 'user'); --password=test

insert into user (id, username, password, first_name, last_name)
values (3, 'creator', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'creator', 'creator'); --password=test

insert into authority (id, name)
values (1, 'ROLE_ADMIN');
insert into authority (id, name)
values (2, 'ROLE_USER');
insert into user_authority (user_id, authority_id)
values (1, 1);
insert into user_authority (user_id, authority_id)
values (2, 2);

insert into authority (id, name)
values (3, 'ROLE_CREATOR');
insert into user_authority (user_id, authority_id)
values (3, 3);