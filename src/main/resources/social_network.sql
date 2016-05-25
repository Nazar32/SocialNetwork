DROP DATABASE IF EXISTS social_network;
 
CREATE DATABASE social_network DEFAULT CHARACTER SET 'utf8';
 
USE social_network;
 
create table cities
(
  city_id int unsigned not null auto_increment,
  name varchar(255) not null,
  primary key (city_id)
) engine=InnoDB;
 
create table messages
(
  message_id int unsigned not null auto_increment,
  header varchar(255) not null,
  content varchar(12550) not null,
  sendDate datetime not null,
  authorEmail varchar(255) not null,
  receiverEmail varchar(255) not null,
  primary key (message_id)
) engine=InnoDB;

create table news
(
  news_id int unsigned not null auto_increment,
  header varchar(255) not null,
  content varchar(12550) not null,
  authorEmail varchar(255) not null,
  creationDate datetime not null,
  primary key (news_id)
) engine=InnoDB;

create table users
(
  user_id int unsigned not null auto_increment,
  firstName varchar(255) not null,
  surname varchar(255) not null,
  patronymic varchar(255) not null,
  eMail varchar(255) not null,
  sex varchar(1),
  city_id int not null,
  password varchar(255) not null,
  age int not null,
  primary key (user_id)
) engine=InnoDB;
 
set names 'utf8';
 

insert into users (firstName, surname, patronymic, eMail, sex, password, city_id, age)
values ('Ivan', 'Ivanov', 'Ivanovich', 'ivan@mail.ru', 'M', '1111', 1, 25);
insert into users (firstName, surname, patronymic, eMail, sex, password, city_id, age)
values ('Nazar', 'Melnyk', 'Andrievich', 'nazar@mail.ru', 'M', '1111', 2, 19);
insert into users (firstName, surname, patronymic, eMail, sex, password, city_id, age)
values ('Nastia', 'Schevchyk', 'Vasylivna', 'nastia@mail.ru', 'F', '1111', 3, 19);


insert into cities (name)
 values ('Kyiv');
insert into cities (name)
 values ('Kharkiv');
insert into cities (name)
 values ('Dnipropetrovsk');
insert into cities (name)
 values ('Odesa');
insert into cities (name)
 values ('Donetsk');
insert into cities (name)
 values ('Zaporizhia');
insert into cities (name)
 values ('Lviv');
insert into cities (name)
 values ('Kryvyi Rih');
insert into cities (name)
 values ('Mykolaiv');
insert into cities (name)
 values ('Mariupol');
insert into cities (name)
 values ('Luhansk');
insert into cities (name)
 values ('Makiivka');
insert into cities (name)
 values ('Vinnytsia');
insert into cities (name)
 values ('Simferopol');
insert into cities (name)
 values ('Sevastopol');
insert into cities (name)
 values ('Kherson');
insert into cities (name)
 values ('Poltava');
insert into cities (name)
 values ('Chernihiv');
insert into cities (name)
 values ('Cherkasy');
insert into cities (name)
 values ('Sumy');
insert into cities (name)
 values ('Horlivka');
insert into cities (name)
 values ('Zhytomyr');
insert into cities (name)
 values ('Dniprodzerzhynsk');
insert into cities (name)
 values ('Kirovohrad');
insert into cities (name)
 values ('Khmelnytskyi');
insert into cities (name)
 values ('Rivne');
insert into cities (name)
 values ('Chernivtsi');
insert into cities (name)
 values ('Kremenchuk');
insert into cities (name)
 values ('Ternopil');
insert into cities (name)
 values ('Ivano-Frankivsk');
insert into cities (name)
 values ('Lutsk');
insert into cities (name)
 values ('Bila Tserkva');
insert into cities (name)
 values ('Kramatorsk');
insert into cities (name)
 values ('Melitopol');
insert into cities (name)
 values ('Kerch');
insert into cities (name)
 values ('Nikopol');
insert into cities (name)
 values ('Sloviansk');
insert into cities (name)
 values ('Berdiansk');
insert into cities (name)
 values ('Sieverodonetsk');
insert into cities (name)
 values ('Alchevsk');
insert into cities (name)
 values ('Pavlohrad');
insert into cities (name)
 values ('Uzhhorod');
insert into cities (name)
 values ('Lysychansk');
insert into cities (name)
 values ('Yevpatoria');
insert into cities (name)
 values ('Yenakiieve');
insert into cities (name)
 values ('Kamianets-Podilskyi');
insert into cities (name)
 values ('Kostiantynivka');
insert into cities (name)
 values ('Krasnyi Luch');
insert into cities (name)
 values ('Oleksandriia');
insert into cities (name)
 values ('Konotop');
insert into cities (name)
 values ('Stakhanov');
insert into cities (name)
 values ('Uman');
insert into cities (name)
 values ('Berdychiv');
insert into cities (name)
 values ('Shostka');
insert into cities (name)
 values ('Brovary');
insert into cities (name)
 values ('Izmail');
insert into cities (name)
 values ('Artemivsk');
insert into cities (name)
 values ('Mukachevo');
insert into cities (name)
 values ('Yalta');
insert into cities (name)
 values ('Drohobych');
insert into cities (name)
 values ('Nizhyn');
insert into cities (name)
 values ('Feodosiya');
insert into cities (name)
 values ('Sverdlovsk');
insert into cities (name)
 values ('Novomoskovsk');
insert into cities (name)
 values ('Torez');
insert into cities (name)
 values ('Chervonohrad');
insert into cities (name)
 values ('Pervomaisk');
insert into cities (name)
 values ('Smila');
insert into cities (name)
 values ('Krasnoarmiysk');
insert into cities (name)
 values ('Kalush');
insert into cities (name)
 values ('Korosten');
insert into cities (name)
 values ('Kovel');
insert into cities (name)
 values ('Rubizhne');
insert into cities (name)
 values ('Pryluky');
insert into cities (name)
 values ('Druzhkivka');
insert into cities (name)
 values ('Khartsyzk');
insert into cities (name)
 values ('Lozova');
insert into cities (name)
 values ('Antratsyt');
insert into cities (name)
 values ('Stryi');
insert into cities (name)
 values ('Kolomyia');
insert into cities (name)
 values ('Shakhtarsk');
insert into cities (name)
 values ('Snizhne');
insert into cities (name)
 values ('Novohrad-Volynskyi');
insert into cities (name)
 values ('Enerhodar');
insert into cities (name)
 values ('Izium');
insert into cities (name)
 values ('Dymytrov');
insert into cities (name)
 values ('Brianka');
insert into cities (name)
 values ('Illichivsk');
insert into cities (name)
 values ('Boryspil');
insert into cities (name)
 values ('Novovolynsk');
insert into cities (name)
 values ('Rovenky');
insert into cities (name)
 values ('Zhovti Vody');
insert into cities (name)
 values ('Lubny');
insert into cities (name)
 values ('Nova Kakhovka');
insert into cities (name)
 values ('Fastiv');
insert into cities (name)
 values ('Bilhorod-Dnistrovskyi');
insert into cities (name)
 values ('Komsomolsk');
insert into cities (name)
 values ('Krasnodon');
insert into cities (name)
 values ('Romny');
insert into cities (name)
 values ('Okhtyrka');
insert into cities (name)
 values ('Svitlovodsk');
insert into cities (name)
 values ('Marhanets');
insert into cities (name)
 values ('Shepetivka');
insert into cities (name)
 values ('Ordzhonikidze');
insert into cities (name)
 values ('Dzerzhynsk');
insert into cities (name)
 values ('Dzhankoy');
insert into cities (name)
 values ('Pervomaisk');
insert into cities (name)
 values ('Myrhorod');
insert into cities (name)
 values ('Voznesensk');
insert into cities (name)
 values ('Kotovsk');
insert into cities (name)
 values ('Irpin');
insert into cities (name)
 values ('Vasylkiv');
insert into cities (name)
 values ('Dubno');
insert into cities (name)
 values ('Kuznetsovsk');
insert into cities (name)
 values ('Volodymyr-Volynskyi');
insert into cities (name)
 values ('Kakhovka');
insert into cities (name)
 values ('Yuzhnoukrainsk');
insert into cities (name)
 values ('Boryslav');
insert into cities (name)
 values ('Yasynuvata');
insert into cities (name)
 values ('Zhmerynka');
insert into cities (name)
 values ('Avdiivka');
insert into cities (name)
 values ('Chuhuiv');
insert into cities (name)
 values ('Sambir');
insert into cities (name)
 values ('Tokmak');
insert into cities (name)
 values ('Boiarka');
insert into cities (name)
 values ('Hlukhiv');
insert into cities (name)
 values ('Dobropillia');
insert into cities (name)
 values ('Starokostiantyniv');
insert into cities (name)
 values ('Kirovsk');
insert into cities (name)
 values ('Vyshneve');
insert into cities (name)
 values ('Netishyn');
insert into cities (name)
 values ('Slavuta');
insert into cities (name)
 values ('Mohyliv-Podilskyi');
insert into cities (name)
 values ('Obukhiv');
insert into cities (name)
 values ('Pervomaiskyi');
insert into cities (name)
 values ('Kupiansk');
insert into cities (name)
 values ('Balakliia');
insert into cities (name)
 values ('Synelnykove');
insert into cities (name)
 values ('Pereiaslav-Khmelnytskyi');
insert into cities (name)
 values ('Alushta');
insert into cities (name)
 values ('Truskavets');
insert into cities (name)
 values ('Krasnoperekopsk');
insert into cities (name)
 values ('Kirovske');
insert into cities (name)
 values ('Kostopil');
insert into cities (name)
 values ('Debaltseve');
insert into cities (name)
 values ('Perevalsk');
insert into cities (name)
 values ('Saky');
insert into cities (name)
 values ('Znamianka');
insert into cities (name)
 values ('Ternivka');
insert into cities (name)
 values ('Pershotravensk');
insert into cities (name)
 values ('Khust');
insert into cities (name)
 values ('Chortkiv');
insert into cities (name)
 values ('Lebedyn');
insert into cities (name)
 values ('Zolotonosha');
insert into cities (name)
 values ('Bucha');
insert into cities (name)
 values ('Novyi Rozdil');
insert into cities (name)
 values ('Krasnyi Lyman');
insert into cities (name)
 values ('Sarny');
insert into cities (name)
 values ('Malyn');
insert into cities (name)
 values ('Khmilnyk');
insert into cities (name)
 values ('Bakhchisaray');
insert into cities (name)
 values ('Selydove');
insert into cities (name)
 values ('Berehove');
insert into cities (name)
 values ('Kaniv');
insert into cities (name)
 values ('Koziatyn');
insert into cities (name)
 values ('Novoiavorivske');
insert into cities (name)
 values ('Korostyshiv');
insert into cities (name)
 values ('Popasna');
insert into cities (name)
 values ('Vynohradiv');
insert into cities (name)
 values ('Haisyn');
insert into cities (name)
 values ('Molodohvardiysk');
insert into cities (name)
 values ('Krolevets');
insert into cities (name)
 values ('Merefa');
insert into cities (name)
 values ('Volnovakha');
insert into cities (name)
 values ('Zdolbuniv');
insert into cities (name)
 values ('Kreminna');
insert into cities (name)
 values ('Slavutych');
insert into cities (name)
 values ('Dokuchaievsk');
insert into cities (name)
 values ('Liubotyn');
insert into cities (name)
 values ('Tsiurupynsk');
insert into cities (name)
 values ('Yuzhne');
insert into cities (name)
 values ('Armiansk');
insert into cities (name)
 values ('Vilnohirsk');
insert into cities (name)
 values ('Yahotyn');
insert into cities (name)
 values ('Sukhodilsk');
insert into cities (name)
 values ('Zolochiv');
insert into cities (name)
 values ('Trostianets');
insert into cities (name)
 values ('Brody');
insert into cities (name)
 values ('Polonne');
insert into cities (name)
 values ('Vyshhorod');
insert into cities (name)
 values ('Hadiach');
insert into cities (name)
 values ('Krasnohrad');
insert into cities (name)
 values ('Kilia');
insert into cities (name)
 values ('Starobilsk');
insert into cities (name)
 values ('Ladyzhyn');
insert into cities (name)
 values ('Polohy');
insert into cities (name)
 values ('Amvrosiivka');
insert into cities (name)
 values ('Kremenets');
insert into cities (name)
 values ('Henichesk');
insert into cities (name)
 values ('Sokal');
insert into cities (name)
 values ('Kurakhove');
insert into cities (name)
 values ('Dniprorudne');
insert into cities (name)
 values ('Volochysk');
insert into cities (name)
 values ('Nadvirna');
insert into cities (name)
 values ('Dolyna');
insert into cities (name)
 values ('Stebnyk');
insert into cities (name)
 values ('Vovchansk');
insert into cities (name)
 values ('Krasyliv');
insert into cities (name)
 values ('Piatykhatky');
insert into cities (name)
 values ('Reni');
insert into cities (name)
 values ('Bakhmach');
insert into cities (name)
 values ('Derhachi');
insert into cities (name)
 values ('Vatutine');
insert into cities (name)
 values ('Kalynivka');
insert into cities (name)
 values ('Balta');
insert into cities (name)
 values ('Zvenyhorodka');
insert into cities (name)
 values ('Zuhres');
insert into cities (name)
 values ('Skadovsk');
insert into cities (name)
 values ('Svatove');
insert into cities (name)
 values ('Shpola');
insert into cities (name)
 values ('Novoukrainka');
insert into cities (name)
 values ('Korsun-Shevchenkivskyi');
insert into cities (name)
 values ('Lutuhyne');
insert into cities (name)
 values ('Bilohirsk');
insert into cities (name)
 values ('Dolynska');
insert into cities (name)
 values ('Iziaslav');
insert into cities (name)
 values ('Bilopillia');
insert into cities (name)
 values ('Bohodukhiv');
insert into cities (name)
 values ('Skvyra');
insert into cities (name)
 values ('Karlivka');
insert into cities (name)
 values ('Orikhiv');
insert into cities (name)
 values ('Bilozerske');
insert into cities (name)
 values ('Zolote');
insert into cities (name)
 values ('Yunokomunarivsk');
insert into cities (name)
 values ('Pidhorodne');
insert into cities (name)
 values ('Rozdilna');
insert into cities (name)
 values ('Horodok');
insert into cities (name)
 values ('Chervonopartyzansk');
insert into cities (name)
 values ('Ilovaisk');
insert into cities (name)
 values ('Berezhany');
insert into cities (name)
 values ('Novohrodivka');
insert into cities (name)
 values ('Vuhledar');
insert into cities (name)
 values ('Berezan');
insert into cities (name)
 values ('Putyvl');
insert into cities (name)
 values ('Bolhrad');
insert into cities (name)
 values ('Bar');
insert into cities (name)
 values ('Svaliava');
insert into cities (name)
 values ('Bohuslav');
insert into cities (name)
 values ('Huliaipole');
insert into cities (name)
 values ('Zmiiv');
insert into cities (name)
 values ('Ovruch');
insert into cities (name)
 values ('Verkhnodniprovsk');
insert into cities (name)
 values ('Ochakiv');
insert into cities (name)
 values ('Krasnohorivka');
insert into cities (name)
 values ('Kivertsi');
insert into cities (name)
 values ('Pyriatyn');
insert into cities (name)
 values ('Mykolaivka');
insert into cities (name)
 values ('Chasiv Yar');
insert into cities (name)
 values ('Vilniansk');
insert into cities (name)
 values ('Dunaivtsi');
insert into cities (name)
 values ('Apostolove');
insert into cities (name)
 values ('Talne');
insert into cities (name)
 values ('Artsyz');
insert into cities (name)
 values ('Novyi Buh');
insert into cities (name)
 values ('Tulchyn');
insert into cities (name)
 values ('Haivoron');
insert into cities (name)
 values ('Horodok');
insert into cities (name)
 values ('Hola Prystan');
insert into cities (name)
 values ('Nosivka');
insert into cities (name)
 values ('Zhashkiv');
insert into cities (name)
 values ('Horodysche');
insert into cities (name)
 values ('Vasylivka');
insert into cities (name)
 values ('Kamianka-Dniprovska');
insert into cities (name)
 values ('Petrovske');
insert into cities (name)
 values ('Beryslav');
insert into cities (name)
 values ('Snihurivka');
insert into cities (name)
 values ('Radomyshl');
insert into cities (name)
 values ('Burshtyn');
insert into cities (name)
 values ('Rakhiv');
insert into cities (name)
 values ('Novhorod-Siverskyi');
insert into cities (name)
 values ('Kamianka');
insert into cities (name)
 values ('Tetiiv');
insert into cities (name)
 values ('Mykolaiv');
insert into cities (name)
 values ('Ostroh');
insert into cities (name)
 values ('Zelenodolsk');
insert into cities (name)
 values ('Vakhrusheve');
insert into cities (name)
 values ('Khorol');
insert into cities (name)
 values ('Storozhynets');
insert into cities (name)
 values ('Sudak');
insert into cities (name)
 values ('Siversk');
insert into cities (name)
 values ('Koriukivka');
insert into cities (name)
 values ('Biliaivka');
insert into cities (name)
 values ('Hirnyk');
insert into cities (name)
 values ('Ukrainka');
insert into cities (name)
 values ('Nova Odesa');
insert into cities (name)
 values ('Horodnia');
insert into cities (name)
 values ('Schastia');
insert into cities (name)
 values ('Kaharlyk');
insert into cities (name)
 values ('Zhdanivka');
insert into cities (name)
 values ('Berezne');
insert into cities (name)
 values ('Terebovlia');
insert into cities (name)
 values ('Vynnyky');
insert into cities (name)
 values ('Rozhysche');
insert into cities (name)
 values ('Yavoriv');
insert into cities (name)
 values ('Zhovkva');
insert into cities (name)
 values ('Tarascha');
insert into cities (name)
 values ('Myronivka');
insert into cities (name)
 values ('Bershad');
insert into cities (name)
 values ('Ukrainsk');
insert into cities (name)
 values ('Zbarazh');
insert into cities (name)
 values ('Novomyrhorod');
insert into cities (name)
 values ('Uzyn');
insert into cities (name)
 values ('Svitlodarsk');
insert into cities (name)
 values ('Soledar');
insert into cities (name)
 values ('Bashtanka');
insert into cities (name)
 values ('Mala Vyska');
insert into cities (name)
 values ('Teplohirsk');
insert into cities (name)
 values ('Barvinkove');
insert into cities (name)
 values ('Prymorsk');
insert into cities (name)
 values ('Mena');
insert into cities (name)
 values ('Hlobyne');
insert into cities (name)
 values ('Hnivan');
insert into cities (name)
 values ('Komsomolske');
insert into cities (name)
 values ('Ichnia');
insert into cities (name)
 values ('Novoazovsk');
insert into cities (name)
 values ('Baranivka');
insert into cities (name)
 values ('Buchach');
insert into cities (name)
 values ('Lokhvytsia');
insert into cities (name)
 values ('Schors');
insert into cities (name)
 values ('Bobrynets');
insert into cities (name)
 values ('Nemyriv');
insert into cities (name)
 values ('Kobeliaky');
insert into cities (name)
 values ('Rodynske');
insert into cities (name)
 values ('Chyhyryn');
insert into cities (name)
 values ('Bobrovytsia');
insert into cities (name)
 values ('Sosnivka');
insert into cities (name)
 values ('Zhydachiv');
insert into cities (name)
 values ('Yampil');
insert into cities (name)
 values ('Mospyne');
insert into cities (name)
 values ('Borzna');
insert into cities (name)
 values ('Shcholkine');
insert into cities (name)
 values ('Buryn');
insert into cities (name)
 values ('Kamianka-Buzka');
insert into cities (name)
 values ('Hrebinka');
insert into cities (name)
 values ('Khrystynivka');
insert into cities (name)
 values ('Hirske');
insert into cities (name)
 values ('Tavriisk');
insert into cities (name)
 values ('Borschiv');
insert into cities (name)
 values ('Zymohiria');
insert into cities (name)
 values ('Khotyn');
insert into cities (name)
 values ('Illintsi');
insert into cities (name)
 values ('Pomichna');
insert into cities (name)
 values ('Olevsk');
insert into cities (name)
 values ('Kamin-Kashyrskyi');
insert into cities (name)
 values ('Tatarbunary');
insert into cities (name)
 values ('Pohrebysche');
insert into cities (name)
 values ('Marinka');
insert into cities (name)
 values ('Bolekhiv');
insert into cities (name)
 values ('Inkerman');
insert into cities (name)
 values ('Zinkiv');
insert into cities (name)
 values ('Khodoriv');
insert into cities (name)
 values ('Sniatyn');
insert into cities (name)
 values ('Derazhnia');
insert into cities (name)
 values ('Liuboml');
insert into cities (name)
 values ('Valky');
insert into cities (name)
 values ('Novodnistrovsk');
insert into cities (name)
 values ('Radyvyliv');
insert into cities (name)
 values ('Vuhlehirsk');
insert into cities (name)
 values ('Sokyriany');
insert into cities (name)
 values ('Verkhivtseve');
insert into cities (name)
 values ('Zalischyky');
insert into cities (name)
 values ('Staryi Krym');
insert into cities (name)
 values ('Bilytske');
insert into cities (name)
 values ('Pereschepyne');
insert into cities (name)
 values ('Andrushivka');
insert into cities (name)
 values ('Pustomyty');
insert into cities (name)
 values ('Horodenka');
insert into cities (name)
 values ('Tysmenytsia');
insert into cities (name)
 values ('Tiachiv');
insert into cities (name)
 values ('Semenivka');
insert into cities (name)
 values ('Dubrovytsia');
insert into cities (name)
 values ('Kodyma');
insert into cities (name)
 values ('Irshava');
insert into cities (name)
 values ('Berezivka');
insert into cities (name)
 values ('Ananyiv');
insert into cities (name)
 values ('Monastyrysche');
insert into cities (name)
 values ('Lypovets');
insert into cities (name)
 values ('Vylkove');
insert into cities (name)
 values ('Radekhiv');
insert into cities (name)
 values ('Mostyska');
insert into cities (name)
 values ('Artemivsk');
insert into cities (name)
 values ('Novodruzhesk');
insert into cities (name)
 values ('Chervonozavodske');
insert into cities (name)
 values ('Alupka');
insert into cities (name)
 values ('Horokhiv');
insert into cities (name)
 values ('Pryvillia');
insert into cities (name)
 values ('Chop');
insert into cities (name)
 values ('Zastavna');
insert into cities (name)
 values ('Zorynsk');
insert into cities (name)
 values ('Tlumach');
insert into cities (name)
 values ('Teplodar');
insert into cities (name)
 values ('Lanivtsi');
insert into cities (name)
 values ('Busk');
insert into cities (name)
 values ('Korets');
insert into cities (name)
 values ('Rohatyn');
insert into cities (name)
 values ('Pivdenne');
insert into cities (name)
 values ('Dubliany');
insert into cities (name)
 values ('Rzhyschiv');
insert into cities (name)
 values ('Novoselytsia');
insert into cities (name)
 values ('Vorozhba');
insert into cities (name)
 values ('Kosiv');
insert into cities (name)
 values ('Pochaiv');
insert into cities (name)
 values ('Rava-Ruska');
insert into cities (name)
 values ('Molochansk');
insert into cities (name)
 values ('Yaremcha');
insert into cities (name)
 values ('Turka');
insert into cities (name)
 values ('Kitsman');
insert into cities (name)
 values ('Peremyshliany');
insert into cities (name)
 values ('Ulianovka');
insert into cities (name)
 values ('Seredyna-Buda');
insert into cities (name)
 values ('Zboriv');
insert into cities (name)
 values ('Khorostkiv');
insert into cities (name)
 values ('Oster');
insert into cities (name)
 values ('Sharhorod');
insert into cities (name)
 values ('Perechyn');
insert into cities (name)
 values ('Oleksandrivsk');
insert into cities (name)
 values ('Kopychyntsi');
insert into cities (name)
 values ('Skole');
insert into cities (name)
 values ('Artemove');
insert into cities (name)
 values ('Sudova Vyshnia');
insert into cities (name)
 values ('Halych');
insert into cities (name)
 values ('Morshyn');
insert into cities (name)
 values ('Monastyryska');
insert into cities (name)
 values ('Miusynsk');
insert into cities (name)
 values ('Vashkivtsi');
insert into cities (name)
 values ('Velyki Mosty');
insert into cities (name)
 values ('Druzhba');
insert into cities (name)
 values ('Staryi Sambir');
insert into cities (name)
 values ('Shumsk');
insert into cities (name)
 values ('Sviatohirsk');
insert into cities (name)
 values ('Almazna');
insert into cities (name)
 values ('Vyzhnytsia');
insert into cities (name)
 values ('Maydanets');
insert into cities (name)
 values ('Dobromyl');
insert into cities (name)
 values ('Rudky');
insert into cities (name)
 values ('Khyriv');
insert into cities (name)
 values ('Skalat');
insert into cities (name)
 values ('Komarno');
insert into cities (name)
 values ('Bibrka');
insert into cities (name)
 values ('Novyi Kalyniv');
insert into cities (name)
 values ('Hlyniany');
insert into cities (name)
 values ('Pidhaitsi');
insert into cities (name)
 values ('Baturyn');
insert into cities (name)
 values ('Belz');
insert into cities (name)
 values ('Ustyluh');
insert into cities (name)
 values ('Hertsa');
insert into cities (name)
 values ('Berestechko');
insert into cities (name)
 values ('Uhniv');
insert into cities (name)
 values ('Chernobyl');
insert into cities (name)
 values ('Prypiat');

 
