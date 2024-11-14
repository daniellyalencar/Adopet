create table pet(
    id bigint not null auto_increment,
    tipo varchar(100) not null,
    nome varchar(100) not null,
    raca varchar(100) not null,
    idade int not null,
    cor varchar(100) not null,
    peso decimal(4,2) not null,
    abrigo_id bigint not null,
    adotado boolean not null,
    primary key(id),
    constraint fk_pet_abrigo_id foreign key(abrigo_id) references abrigo(id)
);