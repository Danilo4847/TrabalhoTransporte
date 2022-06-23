
drop database if exists dbtransporte;
CREATE DATABASE DBTRANSPORTE;

USE DBTRANSPORTE;

CREATE TABLE MOTORISTA(
idmotorista int not null auto_increment
,nome varchar(50)
,matricula numeric(10)
,categoria_carteira varchar(5)
,status boolean
,CNH numeric(11)
,primary key(idmotorista)



);
CREATE TABLE VEICULO(
idveiculo int not null auto_increment
,marca varchar(80)
,modelo varchar(80)
,ano year
,placa varchar(7)
,renavam varchar(11)
,primary key(idveiculo)



);



CREATE TABLE MATERIAL(
idmaterial int not null auto_increment
,conteudo varchar(80)
,quantidade int
,setor varchar(80)
,primary key(idmaterial)
);


CREATE TABLE VIAGEM(
idviagem int not null auto_increment
,idveiculo int
,idmotorista int
,idmaterial int
,regional varchar(80)
,dataSaida datetime
,dataChegada datetime
,primary key(idviagem)
,foreign key (idveiculo)references veiculo(idveiculo)
,foreign key (idmotorista)references motorista(idmotorista)
,foreign key (idmaterial)references material(idmaterial)
);





insert into motorista(nome,matricula,categoria_carteira,cnh)values("Edvaldo",123654,"A",12345678998);
insert into motorista(nome,matricula,categoria_carteira,cnh)values("PELÉ",123654,"AB",12345678998);
insert into motorista(nome,matricula,categoria_carteira,cnh)values("AGNALDO",123654,"AC",12345678998);
insert into motorista(nome,matricula,categoria_carteira,cnh)values("TORRESMO",123654,"AD",12345678998);
insert into motorista(nome,matricula,categoria_carteira,cnh)values("ROBINHO",123654,"B",12345678998);
insert into motorista(nome,matricula,categoria_carteira,cnh)values("ENEL",123654,"C",12345678998);
insert into motorista(nome,matricula,categoria_carteira,cnh)values("PERICLES",123654,"D",12345678998);

insert into viagem (regional) values("Regional de Blumenau");
insert into viagem (regional) values("Regional de Joinville");
insert into viagem (regional) values("Regional de Criciúma");
insert into viagem (regional) values("Regional de Mafra");


insert into veiculo(marca,modelo,ano,placa,renavam)values("chevrolet","Omega",1998,"ASD4564","00222114455");

insert into veiculo(marca,modelo,ano,placa,renavam)values("camaro","Ford",1998,"ASD4564","00222114455");
insert into veiculo(marca,modelo,ano,placa,renavam)values("corola","Toyota",1998,"ASD4564","45454545454");

insert into material(conteudo,quantidade,setor)values("Pedra",5,"Agnaldo");



insert into viagem(idveiculo,idmotorista,idmaterial,regional,dataSaida, datachegada)values(1,1,1,"Regional do posso",'2022-07-10 18:00','2022-07-25 15:00');
insert into viagem(idveiculo,idmotorista,idmaterial,regional,dataSaida, datachegada)values(3,1,1,"Regional do posso",'2022-07-10 18:00','2022-07-25 15:00');

select nome from motorista ;
select * from veiculo;
select * from viagem;

select * from material;

select * from motorista;
select*from veiculo where marca like"%m%";


-- select viagem.dataChegada, viagem.dataSaida,viagem.regional,motorista.nome,veiculo.marca from viageminner join motorista on motorista.idmotorista=viagem.idmotorista inner join veiculo on veiculo.idveiculo=viagem.idveiculo v;
;

 insert into material(conteudo,quantidade,setor)values("porta",10,"gepes");
 
 insert into material(conteudo,quantidade,setor)values("porta",10,"gepes");
 select*from veiculo;
 DELETE FROM VEICULO  WHERE IDveiculo= 5;
 delete from veiculo where idveiculo=2;
 
  select categoria_carteira, cnh, nome, status, idmotorista from motorista m where  m.categoria_carteira ='a';
  SELECT * FROM VEICULO v where   v.modelo like'%ford%';
  -- SELECT ano,marca,modelo,placa,renavam,status FROM VEICULO v where  and  v.marca like'%ford%';
 
 
 SELECT VIAGEM.REGIONAL,VIAGEM.DATASAIDA,VIAGEM.DATACHEGADA, MOTORISTA.NOME,VEICULO.MODELO FROM VIAGEM INNER JOIN VEICULO ON VEICULO.IDVEICULO=VIAGEM.IDVEICULO INNER JOIN MOTORISTA ON MOTORISTA.IDMOTORISTA=VIAGEM.IDMOTORISTA where veiculo.modelo="omega'";
select viagem.dataChegada, viagem.dataSaida,viagem.regional,motorista.nome,veiculo.marca from viagem inner join motorista on motorista.idmotorista=viagem.idmotorista inner join veiculo on veiculo.idveiculo=viagem.idveiculo where motorista.nome="Edvaldo";


select * from viagem inner join motorista on motorista.idmotorista=viagem.idmotorista inner join veiculo on veiculo.idveiculo=viagem.idveiculo ;