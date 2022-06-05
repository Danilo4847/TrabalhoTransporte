drop database if exists dbtransporte;

create database dbtransporte;

use dbtransporte;


create table motorista(
idmotorista int not null auto_increment
,nome varchar(80)
,CNH varchar(12)
,habilitacao varchar(20)
,primary key(idmotorista)
);

create table veiculo(
idveiculo int not null auto_increment
,marca varchar(80)
,modelo varchar(80)
,ano date
,placa varchar(12)
,Renavam numeric(11)
,primary key(idveiculo));

create table material(
idmaterial  int not null auto_increment
,nome varchar(80)
,tipo varchar(68)
,setor_origim varchar(70)
,primary key(idmaterial)
);

create table viagem(
idviagem int not null auto_increment
,idveiculo int not null
,idmotorista int not null
,idmaterial int not null
,regional varchar(100)
,data_entrada datetime
,data_saida datetime
,primary key(idviagem)
,foreign key(idveiculo)references veiculo(idveiculo)
,foreign key (idmotorista)references motorista(idmotorista)
,foreign key (idmaterial)references material(idmaterial)
);



insert into motorista(nome,CNH,habilitacao) values("Pelé",07083899750,"AB");
insert into motorista(nome,CNH,habilitacao) values("Raul Seixas",07083899750,"A");
insert into motorista(nome,CNH,habilitacao) values("Zidani",07083899750,"AB");
insert into motorista(nome,CNH,habilitacao) values("Ronaldinho",107083899750,"B");
insert into motorista(nome,CNH,habilitacao) values("Bruxo",07083899750,"C");
insert into motorista(nome,CNH,habilitacao) values("Mrcelo",07083899750,"D");
insert into motorista(nome,CNH,habilitacao) values("Naruto",07083899750,"E");
insert into motorista(nome,CNH,habilitacao) values("Eren",07083899750,"AC");
insert into motorista(nome,CNH,habilitacao) values("Gon",07083899750,"DE");
/*
insert into veiculo(modelo,marca,ano,placa,Renavam)values("corola","toyota","BR12F55");
insert into veiculo(modelo,marca,ano,placa,Renavam)values("ducato","FIAT","RJ23F44");
insert into veiculo(modelo,marca,ano,placa,Renavam)values("perua","FIAT","SP12D32");
insert into veiculo(modelo,marca,ano,placa,Renavam)values("duster","Renault","BR13Z55");
insert into veiculo(modelo,marca,ano,placa,Renavam)values("idea","fiat","BR12K85");
insert into veiculo(modelo,marca,ano,placa,Renavam)values("fiorino","fiat","BR53H89");
insert into veiculo(modelo,marca,ano,placa,Renavam)values("logan","renault","BR45A85");
insert into viagem(idveiculo,idmotorista,regional,data_saida)values(1,3,"Procuradoira Regional de Joinville",2021/10/02);
insert into viagem(idveiculo,idmotorista,regional,data_saida)values(3,5,"Procuradoira Regional de Blumenau",2022/05/12);
insert into viagem(idveiculo,idmotorista,regional,data_saida)values(2,4,"Procuradoira Regional de Mafra",2022/08/03);
*/


