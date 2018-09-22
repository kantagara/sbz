insert into authority (id, name) values (1, 'ADMIN');
insert into authority (id, name) values (2, 'DOCTOR');


insert into account (id, deleted, password, username, name, surname, version)
values (101, 0, '$2a$04$x//BMp4r.LBP7DgETzBpQ.4rwEc2hC6nxwoxAzcIF5MWQDk.urNSu', 'kaca', 'Katarina', 'Cukurov', 0);
insert into account_authority(id, account_id, authority_id) values (101, 101, 2);
  -- account doktor 2
insert into account (id, deleted, password, username, name, surname, version)
values (102, 0, '$2a$04$EFWq.vkZxKM2xEffM9wu7u/ErbTzAl6KD23gT0.DxGqQrX.ECVw26', 'nemanja', 'Nemanja', 'Brzak', 0);
insert into account_authority(id, account_id, authority_id) values (102, 102, 2);

insert into account (id, deleted, password, username, name, surname, version)
values (103, 0, '$2a$04$2IwsW4cy24II65pgR8jdN.eqAFZ36W70EAHiO8ZguOfZekqcq1eM2','kantagara', 'Nikola', 'Garabandic', 0);
insert into account_authority(id, account_id, authority_id) values (103, 103, 1);



insert into symptom (id, name, value) values (101, 'curenje iz nosa', null);
insert into symptom (id, name, value) values (102, 'bol u grlu', null);
insert into symptom (id, name, value) values (103, 'glavobolja', null);
insert into symptom (id, name, value) values (104, 'kijanje', null);
insert into symptom (id, name, value) values (105, 'kasalj', null);
insert into symptom (id, name, value) values (106, 'temperatura', 38);
insert into symptom (id, name, value) values (107, 'drhtavica', null);
insert into symptom (id, name, value) values (108, 'bol koji se siri do usiju', null);
insert into symptom (id, name, value) values (109, 'temperatura', 40);
insert into symptom (id, name, value) values (110, 'gubitak apetita', null);
insert into symptom (id, name, value) values (111, 'umor', null);
insert into symptom (id, name, value) values (112, 'zuti sekret iz nosa', null);
insert into symptom (id, name, value) values (113, 'oticanje oko ociju', null);
insert into symptom (id, name, value) values (114, 'cesto uriniranje', null);
insert into symptom (id, name, value) values (115, 'gubitak telesne tezine', null);
insert into symptom (id, name, value) values (116, 'zamor', null);
insert into symptom (id, name, value) values (117, 'mucnina i povracanje', null);
insert into symptom (id, name, value) values (118, 'nocturia', null);
insert into symptom (id, name, value) values (119, 'otoci nogu i zglobova', null);
insert into symptom (id, name, value) values (120, 'gusenje', null);
insert into symptom (id, name, value) values (121, 'bol u grudima', null);
insert into symptom (id, name, value) values (122, 'dijareja', null);
insert into symptom (id, name, value) values (123, 'p/g u 60', null);
insert into symptom (id, name, value) values (124, 'visok pritisak 10x', null);
insert into symptom (id, name, value) values (125, 'boluje od dijabetesa', null);
insert into symptom (id, name, value) values (126, 'boluje od hipertenzije', null);
insert into symptom (id, name, value) values (127, 'operacija', null);
insert into symptom (id, name, value) values (128, 'bolest sa temperaturom', null);
insert into symptom (id, name, value) values (129, 'bolest sa antibioticima', null);

insert into disease(id, name) values (101, 'prehlada');
insert into disease(id, name) values (102, 'groznica');
insert into disease(id, name) values (103, 'upala krajnika');
insert into disease(id, name) values (104, 'sinusna infekcija');
insert into disease(id, name) values (105, 'hipertenzija');
insert into disease(id, name) values (106, 'dijabetes');
insert into disease(id, name) values (107, 'hronicna bubrezna bolest');
insert into disease(id, name) values (108, 'akutna bubrezna povreda');



insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (101, 101);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (101, 102);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (101, 103);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (101, 104);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (101, 105);
-- groznica
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (102, 104);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (102, 102);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (102, 105);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (102, 106);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (102, 101);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (102, 103);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (102, 107);
-- upala krajnika
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (103, 102);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (103, 103);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (103, 108);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (103, 107);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (103, 109);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (103, 110);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (103, 111);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (103, 112);
-- sinusna infekcija
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (104, 113);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (104, 112);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (104, 103);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (104, 105);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (104, 106);
insert into disease_general_symptoms(disease_id,  general_symptoms_id) values (104, 102);


INSERT INTO PATIENT(ID, JMBG, NAME, SURNAME) VALUES(102, '2702995800039', 'MILOS', 'GARABANDIC');
INSERT INTO PATIENT(ID, JMBG, NAME, SURNAME) VALUES(101, '2303995800039', 'MILOS', 'GARABANDIC');