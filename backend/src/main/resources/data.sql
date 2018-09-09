insert into authority (id, name) values (1, 'ADMIN');
insert into authority (id, name) values (2, 'DOKTOR');


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