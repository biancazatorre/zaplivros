CREATE TABLE IF NOT EXISTS funcionario (
     id serial PRIMARY KEY,
     nome  varchar(50),
     cpf   varchar(11),
     email   varchar(50),
     telefone   varchar(11),
     senha varchar(50),
     cargo boolean
);