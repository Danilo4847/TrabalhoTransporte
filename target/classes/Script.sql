
CREATE DATABASE DBTRANSPORTE;



USE DBTRANSPORTE;



CREATE TABLE MOTORISTA(
idmotorista int not null auto_increment
,nome varchar(50)
,matricula numeric(10)
,tipoCarteira char(2)
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



CREATE TABLE VIAGEM(
idviagem int not null auto_increment
,idveiculo int
,idmotorista int
,idmaterial int
,regional varchar(200)
,dataSaida datetime
,dataChegada datetime
,primary key(idviagem)
,foreign key (idveiculo)references veiculo(idveiculo)
,foreign key (idmotorista)references motorista(idmotorista)
,foreign key (idmaterial)references material(idmaterial)



);



CREATE TABLE MATERIAL(



idmaterial int not null auto_increment
,conteudo varchar(80)
,quantidade int
,setor varchar(80)
,primary key(idmaterial)
);



insert into motorista(nome,matricula,tipocarteira,cnh)values("Edvaldo",123654,"AB",12345678998);



insert into vaiculo(marca,modelo,ano,placa,renavam)values("chevrolet","Omega",1998,"ASD4564","00222114455");



insert into material(conteudo,quantidade,setor)values("Pedra",5,"Agnaldo");



insert into viagem(idveiculo,idmotorista,idmaterial,regional,dataSaida, datachegada)values(1,1,1,"Regional do Fundão",'2022-07-10 18:00','2022-07-25 15:00');