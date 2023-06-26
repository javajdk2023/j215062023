# j215062023


# DDL do projeto

```sql

--excluir
drop table usuario;

-- cometarios
create table usuario(
 nome varchar(255),
 idade int,
 email varchar(255)
);


drop table questao;

create table questao (
codigo int,
enunciado varchar(255),
valor float
);


insert into questao values (1, 'Quais classes fazem parte da API JDBC?', 1.0);
insert into questao values (2, 'Quais são as estruturas de repetição do Java?', 1.0);
insert into questao values (3, 'Um classe pode herdar de uma interface Java?', 2.0);

drop table alternativa;

create table alternativa (
codigo int,
descricao varchar(255),
isVerdadeira boolean,
codigoQuestao int
);

insert into alternativa values(1, 'Connection', true, 1);
insert into alternativa values(2, 'EntityManager', false, 1);

```
