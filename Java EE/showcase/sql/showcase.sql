create table categoria (
cod_categoria int not null,
nome varchar(100) not null,
constraint pk_categoria primary key (cod_categoria)
);

create table carro (
cod_carro int not null,
cod_categoria int not null,
nome varchar(100) not null,
descricao text not null,
url_foto varchar(1000) not null,
url_info varchar(1000) not null,
url_video varchar(1000) not null,
constraint pk_carro primary key (cod_carro),
constraint fk_carro_categoria foreign key (cod_categoria) references categoria
);

create sequence seq_categoria