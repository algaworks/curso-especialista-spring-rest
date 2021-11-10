create table restaurante_usuario_responsavel (
  restaurante_id bigint not null,
  usuario_id bigint not null,
  
  primary key (restaurante_id, usuario_id)
) engine=InnoDB default charset=utf8;

alter table restaurante_usuario_responsavel add constraint fk_restaurante_usuario_restaurante
foreign key (restaurante_id) references restaurante (id);

alter table restaurante_usuario_responsavel add constraint fk_restaurante_usuario_usuario
foreign key (usuario_id) references usuario (id);
