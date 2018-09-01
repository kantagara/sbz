-- ROLES
insert into authority (id, ime) values (1, 'ADMIN');
insert into authority (id, ime) values (2, 'DOKTOR');


-- ADMINISTRATORS
  -- account admin 1
insert into account (id, deleted, password, username, ime, prezime, version)
values (103, 0, '$2a$04$NfYZ1tb6cuAQl.DNL76FjeHVXNmiMFtXlA8YWmOpg5H4lcF8jVnlS','kantagara@gmail.com', 'Nikola', 'Garabandic', 0);
insert into account_authority(id, account_id, authority_id) values (103, 103, 1);


-- ACCOUNTS ZA DOKTORE
  -- account doktor 1
insert into account (id, deleted, password, username, ime, prezime, version)
values (101, 0, '$2a$04$Ie/vN0kYNCWIHU5dwRdRp.KraHKu18S3oXPGjuZPVOQVtIjyniBrK', 'kaca.cukurov@gmail.com', 'Katarina', 'Cukurov', 0);
insert into account_authority(id, account_id, authority_id) values (101, 101, 2);
  -- account doktor 2
insert into account (id, deleted, password, username, ime, prezime, version)
values (102, 0, '$2a$04$sjM.ElxzB5B9DveQP5wxCeTkKnJgU6ck9Lw07J9GfyWXhUOHbCmpm', 'nemanja@gmail.com', 'Nemanja', 'Brzak', 0);
insert into account_authority(id, account_id, authority_id) values (102, 102, 2);