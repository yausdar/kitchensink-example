-- You can use this file to load seed data into the database using SQL statements
insert into tb_usuario (ds_nome , ds_email , ds_senha , ds_locale) values ('Administrador' , 'admin@mail.com' , MD5('admin') , 'pt');
insert into tb_usuario_papel (cd_usuario , ds_papel) values (1 , 'ADMIN');
insert into tb_usuario (ds_nome , ds_email , ds_senha , ds_locale) values ('Fulano' , 'fulano@mail.com' , MD5('fulano') , 'en');
insert into tb_usuario_papel (cd_usuario , ds_papel) values (1 , 'USER');