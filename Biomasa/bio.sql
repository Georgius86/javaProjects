drop database if exists ams;
create database ams character set utf8;
use ams;

create table prijevoznici(
sifra int not null primary key auto_increment,
naziv varchar(50) not null,
mjesto varchar(50),
oib char(11) not null
)engine=innodb;

create table vozaci(
sifra int not null primary key auto_increment,
ime varchar(50) not null,
prezime varchar(50) not null,
oib char (11) not null,
prijevoznik int not null
)engine=innodb;

create table kamioni(
sifra int not null primary key auto_increment,
registracija varchar(50) not null,
prijevoznik int not null,
vozac int not null,
nosivost int
)engine=innodb;

create table stovarista(
sifra int not null primary key auto_increment,
naziv varchar (50) not null,
adresa varchar(50) not null,
mjesto varchar(50)not null,
povrsina decimal(18,2)
)engine=innodb;

create table dobavljaci(
sifra int not null primary key auto_increment,
naziv varchar(50) not null,
mjesto varchar(50),
oib char (11) not null
)engine=innodb;

create table dovozi(
sifra int not null primary key auto_increment,
kamion int not null,
vrijemeistovara datetime not null,
dobavljac int,
stovariste int,
sirovina varchar(50) not null,
kolicinat double
)engine=innodb;

create table operateri(
sifra int not null primary key auto_increment,
korisnik varchar(50) not null,
lozinka char(32) not null,
ime varchar(50) not null,
prezime varchar(50) not null,
uloga varchar (20) not null
)engine=innodb;


create unique index i1 on operateri(korisnik);

alter table kamioni add foreign key (prijevoznik) references prijevoznici(sifra);
alter table kamioni add foreign key (vozac) references vozaci(sifra);

alter table vozaci add foreign key (prijevoznik) references prijevoznici(sifra);

alter table dovozi add foreign key (kamion) references kamioni(sifra);
alter table dovozi add foreign key (stovariste) references stovarista(sifra);
alter table dovozi add foreign key (dobavljac) references dobavljaci(sifra); 

#operateri
insert into operateri (korisnik,lozinka,ime,prezime,uloga) 
values ('ddordevic',md5('ddd'),'Đorđe','Đorđević','administrator');

insert into operateri (korisnik,lozinka,ime,prezime,uloga) 
values ('mdoric',md5('mdd'),'Milan','Dorić','korisnik');

insert into operateri (korisnik,lozinka,ime,prezime,uloga) 
values ('amaric',md5('amm'),'Ana','Marić','korisnik');

#stovarista
insert into stovarista (naziv,adresa,mjesto,povrsina) 
values ('Skladište_ogrjevno_drvo','Kralja Zvonimira 25','Darda',450.85);

insert into stovarista (naziv,adresa,mjesto,povrsina) 
values ('Skladište_sijeno','Filipinska 15','Čepin',320.22);

insert into stovarista (naziv,adresa,mjesto,povrsina) 
values ('Skladište_daske','Kralja Tomislava 25','Vinkovci',688.35);

insert into stovarista (naziv,adresa,mjesto,povrsina) 
values ('Skladište_trupci','Maksimirska 13','Čepin',844.71);

#prijevoznici
insert into prijevoznici (naziv,mjesto,oib)
values ('Brkić prijevoz','Županja',44412338894);

insert into prijevoznici (naziv,mjesto,oib)
values ('Marijan prijevoz','Sisak',42422338294);

insert into prijevoznici (naziv,mjesto,oib)
values ('Felini prijevoz','Batina',54412138814);

insert into prijevoznici (naziv,mjesto,oib)
values ('Veriana prijevoz','Čepin',74412338774);

#vozaci
insert into vozaci (ime,prezime,oib,prijevoznik) 
values ('Duško','Lokin',42456667899,1);

insert into vozaci (ime,prezime,oib,prijevoznik) 
values ('Mirko','Miočić',33422467899,1);

insert into vozaci (ime,prezime,oib,prijevoznik) 
values ('Suzana','Mančić',55456667899,2);

insert into vozaci (ime,prezime,oib,prijevoznik) 
values ('Mate','Bulić',15156667899,3);

insert into vozaci (ime,prezime,oib,prijevoznik) 
values ('Ljubo','Ćesić',25456667811,3);

insert into vozaci (ime,prezime,oib,prijevoznik) 
values ('Vilibor','Sinčić',55456667899,3);

insert into vozaci (ime,prezime,oib,prijevoznik) 
values ('Siniša','Cmrk',22456667899,4);

insert into vozaci (ime,prezime,oib,prijevoznik) 
values ('Aleksandar','Grginov',75451117899,1);



#kamioni
insert into kamioni (registracija,prijevoznik,vozac,nosivost)
values ('ŽU-2788-KK',1,1,40);
insert into kamioni (registracija,prijevoznik,vozac,nosivost)
values ('ŽU-5758-KN',1,2,40);
insert into kamioni (registracija,prijevoznik,vozac,nosivost)
values ('SK-6758-KL',2,3,40);
insert into kamioni (registracija,prijevoznik,vozac,nosivost)
values ('SK-1458-MU',3,4,35);
insert into kamioni (registracija,prijevoznik,vozac,nosivost)
values ('SK-4758-KI',3,5,40);
insert into kamioni (registracija,prijevoznik,vozac,nosivost)
values ('SK-3758-CL',3,6,35);
insert into kamioni (registracija,prijevoznik,vozac,nosivost)
values ('BM-1118-NL',4,7,40);
insert into kamioni (registracija,prijevoznik,vozac,nosivost)
values ('OS-3998-IL',1,8,30);

#dobavljači

insert into dobavljaci (naziv,mjesto,oib)
values ('Hrvatske šume','Šumarija Našice',47811118894);
insert into dobavljaci (naziv,mjesto,oib)
values ('Hrvatske šume','Šumarija Zagreb',27821118894);
insert into dobavljaci (naziv,mjesto,oib)
values ('Hrvatske šume','Šumarija Karlovac',67811668894);
insert into dobavljaci (naziv,mjesto,oib)
values ('Šumarstva Federacije BIH','Šumarstvo Tuzlanskog Kantona',37899118114);
insert into dobavljaci (naziv,mjesto,oib)
values ('Šumarstva Federacije BIH','Unsko-Sanske šume',55819118894);

#dovoz

insert into dovozi (kamion,vrijemeistovara,dobavljac,stovariste,sirovina,kolicinat)
values (1,'2014-10-28 09:45:15',4,1,'sijeno',2);
insert into dovozi (kamion,vrijemeistovara,dobavljac,stovariste,sirovina,kolicinat)
values (2,'2014-10-28 10:15:12',3,2,'bukva_cjepanice',15);
insert into dovozi (kamion,vrijemeistovara,dobavljac,stovariste,sirovina,kolicinat)
values (3,'2014-10-29 08:15:12',1,2,'hrast_daske',12.5);
insert into dovozi (kamion,vrijemeistovara,dobavljac,stovariste,sirovina,kolicinat)
values (4,'2014-10-28 10:49:12',3,2,'cer_cjepanice',18);
insert into dovozi (kamion,vrijemeistovara,dobavljac,stovariste,sirovina,kolicinat)
values (4,'2014-10-28 10:15:12',3,3,'uljana_repica',15);