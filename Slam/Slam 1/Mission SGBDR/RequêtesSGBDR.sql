Creation table produit:

create table Produit (
NumColl int,  
DateL date,
RefProd varchar(10)  primary key,
NomProd varchar(30),
Couleur varchar(30),
NomColl varchar(30),
Dimensions varchar(30),
Harmonie varchar(30),
PrixHT float
);



Creation table Collection:

create table Collection (
NumColl int  primary key,  
DateL date,
NomColl varchar(30),
Harmonie varchar(30)
);


Insertion données table produit:

insert into Produit (NumColl, DateL, RefProd, NomProd, Couleur, NomColl, Dimensions, Harmonie, PrixHT) values 
(1,"2005-04-01","A12","chaise longue","marine","marée haute","120x60","bleu",90.00),
(2,"2005-04-15","B32","parasol","paille","soleil","diam 90","jaune",45.00),
(2,"2005-04-15","A14","drap de bain","orangé","soleil","130x80","jaune",65.00),
(1,"2005-04-01","B25","parasol","ciel","marée haute","diam 110","bleu",60.00),
(2,"2005-04-15","A15","coussin","paille","soleil","30x30","jaune",12.00);


Insertion données table collection:

insert into Collection values
(1,"2005-04-01","marée haute","bleu"),
(2,"2005-04-15","soleil","jaune");


Creation utilisateur et attribution des droits:

create user 'pdo_user' identified by 'toto';
grant all privileges on Produit to 'pdo_user';
grant all privileges on Collection to 'pdo_user';

Mise a jour prix article chaise longue: 

update Produit set PrixHT=PrixHT*0.8 where NomProd like 'chaise longue'