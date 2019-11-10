alter table restaurante add ativo tinyint(1) not null;
update restaurante set ativo = true;