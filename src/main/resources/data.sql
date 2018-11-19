insert into answers(id, correct, incorrect1, incorrect2, incorrect3) values
(101, 'Wisła', 'Odra', 'Dunajec', 'San'),
(102, 'Rysy', 'Giewont', 'Śnieżka', 'Tarnica'),
(103, 'Andy', 'Pireneje', 'Himalaje', 'Alpy'),
(104, 'Pakistan', 'Mongolia', 'Kazachstan', 'Rosja'),
(105, 'Mont Blanc', 'Mount Everest', 'K2', 'Rysy'),
(106, 'Rosji', 'Poski', 'Ukrainy', 'Stanów Zjednoczonych'),
(107, 'Azja', 'Ameryka Południowa', 'Europa', 'Ameryka Północna'),
(108, 'Afryki', 'Azji', 'Europy', 'Ameryki Północnej'),
(109, 'Missisipi', 'Amazonka', 'Missouri', 'Jangcy'),
(110, 'Tanzania', 'Kongo', 'Kolumbia', 'Indonezja'),
(111, 'Dunaj', 'Ren', 'Łaba', 'Odra'),
(112, 'Egipt', 'Etiopia', 'Wybrzeże Kości Słoniowej', 'Nigeria'),
(113, 'Górne', 'Michigan', 'Wielkie Niewolnicze', 'Wiktorii'),
(114, 'Kaukazu', 'Karpat', 'Gór Skandynawskich', 'Gór Smoczych'),
(115, 'Gerlach', 'Łomnica', 'Rysy', 'Korab');

insert into answers(id, correct, incorrect1, incorrect2, incorrect3) values
(201, 'Bolesław Chrobry', 'Mieszko I', 'Bolesław Śmiały', 'Władysław Jagiełło'),
(202, '966 r.', '965  r.', '996 r.', '995 r.'),
(203, 'Ulrich von Jungingen', 'Konrad von Wallenrode', 'Heinrich V von Plauen', 'Karl von Habsburg-Lothringen'),
(204, 'Kurskiem', 'Moskwą', 'Stalingradem', 'Wołgogradem'),
(205, '1919 r.', '1917 r.', '1916 r.', '1920 r.');


insert into answers(id, correct, incorrect1, incorrect2, incorrect3) values
(301, '1', '2', '3', '5'),
(302, 'mitochondrium', 'jądrze komórkowym', 'cytoplaźmie', 'lizosomie'),
(303, '0', 'B', 'A', 'AB'),
(304, 'modrzew', 'świerk', 'jodła', 'sosna'),
(305, 'szkliwo', 'kość', 'chrząstka', 'mięsień'),
(306, 'pingwin', 'wieloryb', 'kaszalot', 'hipopotam'),
(307, 'szkorbut', 'krzywica', 'marskość wątroby', 'ostre zapalenie nerek'),
(308, '3', '2', '5', '4'),
(309, 'sikorka bogatka', 'bocian', 'jaskółka', 'słowik'),
(310, 'witaminy: A, D, E, K', 'witaminy: B1, B2, A, D', 'witaminy: C, B1, B2, E, K', 'witaminy: B1, B2, C, A'),
(311, 'żubra i bydła domowego', 'żubra i konia', 'żubra i bizona', 'żubra i jelenia'),
(312, 'czarnoziemy', 'bielicowe', 'płowe', 'lessy'),
(313, 'żbik', 'niedźwiedź', 'suseł', 'borsuk'),
(314, 'woda', 'tłuszcz', 'białko', 'węglowodany'),
(315, 'niezapominajka', 'stokrotka', 'lilia wodna', 'mniszek lekarski');

insert into question(id, content, category, answers_id) values
(1, 'Jaka jest najdłuższa rzeka w Polsce?', 'geography', 101),
(2, 'Jaki jest najwyższy szczyt górski w Polsce?', 'geography', 102),
(3, 'Które z wymienionych pasm górskim leży w Ameryce Południowej?', 'geography', 103),
(4, 'Które z wymienionych państw ma w swych granicach Himalaje?', 'geography', 104),
(5, 'Jaki jest najwyższy szczyt Europy?', 'geography', 105),
(6, 'Jezioro Bajkał znajduje się na terytorium?', 'geography', 106),
(7, 'Kontynent na terytorium, którego znajduje się cieśnina Malakka to:', 'geography', 107),
(8, 'Kilimandżaro to najwyższy szczyt:', 'geography', 108),
(9, 'Najdłuższa Rzeka Ameryki Północnej to:', 'geography', 109),
(10, 'Przez, które z wymienionych państw nie przechodzi równik:', 'geography', 110),
(11, 'Najdłuższa rzeka Niemiec to:', 'geography', 111),
(12, 'Którego z wymienionych Państw nie zaliczamy do Afryki Subsaharyjskiej?', 'geography', 112),
(13, 'Jak nazywa się największe jezioro Ameryki Północnej?', 'geography', 113),
(14, 'Elbrus to najwyższy szczyt?', 'geography', 114),
(15, 'Najwyższy szczyt Karpat to:', 'geography', 115);

insert into question(id, content, category, answers_id) values
(21, 'Kto był pierwszym królem Polski?', 'history', 201),
(22, 'Datę chrztu Polski określa się na:', 'history', 202),
(23, 'Wielkim Mistrzem Zakonu Krzyżackiego, pokonanym pod Grunwaldem był:', 'history', 203),
(24, 'Największa bitwa pancera II Wojny Światowej odbyła się pod:', 'history', 204),
(25, 'Traktat Wersalski na mocy którego Polska odzyskała niepodległość podpisano w: ', 'history', 205);



insert into question(id, content, category, answers_id) values
(31, 'Ile palców (przystosowanych do dźwigania ciężaru ciała) ma koń w jednej kończynie?', 'biology', 301),
(32, 'Cykl Krebsa u organizmów eukariotycznych przebiega w:', 'biology', 302),
(33, 'Uniwesalnym dawcą jest osoba posiadająca grupę krwi:', 'biology', 303),
(34, 'Które z wymienionych drzew zrzuca igły na zimę?:', 'biology', 304),
(35, 'Najtwardsza tkanka organizmu to: ', 'biology', 305),
(36, 'Które z wymienionych zwierząt nie jest ssakiem? ', 'biology', 306),
(37, 'Chorobą wywołaną niedoborem witaminy C w organiźmie jest: ', 'biology', 307),
(38, 'Ile par odnóży posiada pszczoła?: ', 'biology', 308),
(39, 'Który z wymienionych ptaków zostaje na zimę w Polsce ?: ', 'biology', 309),
(40, 'Witaminy rozpuszczalne w tłuszczach to: ', 'biology', 310),
(41, 'Żubroń to mieszaniec: ', 'biology', 311),
(42, 'Najbardziej żyzne gleby to: ', 'biology', 312),
(43, 'Które z wymienionych zwierząt nie zapada w sen zimowy?: ', 'biology', 313),
(44, 'Głównym skladnikiem organizmu jest: ', 'biology', 314),
(45, 'Niebieski kwiat to: ', 'biology', 315);

