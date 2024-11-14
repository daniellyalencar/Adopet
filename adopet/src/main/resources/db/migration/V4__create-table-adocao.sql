create table adocao(
    id bigint not null auto_increment,
    data datetime not null,
    tutor_id bigint not null,
    pet_id bigint not null,
    motivo varchar(255) not null,
    status varchar(100) not null,
    justificativa_status varchar(255),
    primary key(id),
    constraint fk_adocao_tutor_id foreign key(tutor_id) references tutor(id),
    constraint fk_adocaopet_id foreign key(pet_id) references pet(id)
);