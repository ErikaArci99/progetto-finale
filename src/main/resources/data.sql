-- utenti
INSERT INTO `users` (`username`, `password`) VALUES ('admin', '{noop}12345678');
INSERT INTO `users` (`username`, `password`) VALUES ('user', '{noop}12345678');

-- ruoli
INSERT INTO `roles` (`name`) VALUES ('ADMIN');
INSERT INTO `roles` (`name`) VALUES ('USER');

-- associazione utenti-ruoli
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2, 2);

-- collezioni
INSERT INTO `collezione` 
(`nome`, `stagione`, `descrizione`)
VALUES 
('Autunno 2025', 'Autunno/Inverno', 'Collezione di borse dai toni caldi e materiali pregiati'),
('Estate 2025', 'Primavera/Estate', 'Collezione vivace con colori accesi e materiali leggeri');

-- sconti
INSERT INTO `sconto` 
(`percentuale`, `data_inizio`, `data_fine`)
VALUES 
(20, '2025-10-01', '2025-10-31'),
(30, '2025-11-15', '2025-12-31'),
(10, '2025-09-01', '2025-09-30'),
(40, '2025-08-01', '2025-08-31'),
(50, '2025-12-01', '2025-12-31');

-- borse (con brand)
INSERT INTO `borsa` 
(`nome`, `descrizione`, `prezzo`, `colore`, `dimensioni`, `immagine`, `collezione_id`, `sconto_id`, `brand`) 
VALUES 
('Le 5 à 7 mini in pelle verniciata', 'Elegante mini bag in vinile nero dal finish lucido, perfetta per serate sofisticate.', 1500, 'Nero', '20x15x8 cm', 'https://owp.klarna.com/product/232x232/3111080029/Saint-Laurent-Le-5-A-7-Mini-Bag-Noir.jpg?ph=true', 1, NULL, 'YSL'),

('Alma BB', 'Iconica borsa marrone e beige Louis Vuitton, impreziosita da charms pendenti che ne esaltano il fascino unico.', 1600, 'Marrone e Beige', '22x17x10 cm', 'https://it.louisvuitton.com/images/is/image/lv/1/PP_VP_L/louis-vuitton-alma-bb--M46990_PM2_Front%20view.jpg', 2, 1, 'Louis Vuitton'),

('Fendi Sunshine Small', 'Borsa compatta in pelle marrone con dettagli color cuoio e monogram Fendi, elegante e versatile.', 2000, 'Marrone e Color Cuoio', '23x18x11 cm', 'https://data.pozzilei.it/images/galleries/26524/16022024_056.png', 1, 2, 'Fendi'),

('Nano Speedy', 'Piccola borsa beige e marrone Louis Vuitton con tracolla, perfetta per un look chic e minimale.', 1600,'Beige e Marrone', '18x13x9 cm', 'https://it.louisvuitton.com/images/is/image/lv/1/PP_VP_L/louis-vuitton-nano-speedy--M81085_PM2_Front%20view.jpg', 1, NULL, 'Louis Vuitton'),

('Cleo Satin Crystal', 'Borsa azzurra Prada tempestata di diamanti, raffinata e scintillante, perfetta per eventi esclusivi.', 3200, 'Azzurra', '25x18x7 cm', 'https://uk.static.designerexchange.com/product_images/uk/Handbags/HB%20-%20Prada/SHANPRA244051_1_XL.PNG', 2, 2, 'Prada'),

('Il grande bambino', 'Borsa nera Jaquemouse dal design originale e giocoso, ideale per outfit casual estivi.', 350, 'Nera', '28x20x10 cm', 'https://www.theatticstreetwear.com/cdn/shop/files/jacquemus-le-grand-bambino-black-silver-the-attic.png?v=1754382907', 2, 3, 'Jaquemouse'),

('Borsa hobo Wander in nappa matelassé', 'Elegante borsa nera drappeggiata Miu Miu, raffinata e capiente.', 2250,'Nera', '32x25x15 cm', 'https://compass-media.vogue.it/photos/658bf33f82932469770a3d8c/3:4/w_748%2Cc_limit/Senza%2520titolo%2520(12).png', 1, 4, 'Miu Miu'),

('Mini Love Bag Click PINKO Galleria', 'Borsa nera PINKO, chic e eleante, perfetta per look estivi glamour.', 1250, 'Nero e Dorato', '20x15x7 cm', 'https://owp.klarna.com/product/640x640/3015764628/Pinko-Love-Click-Mini-Crossbody-Bag-Black.jpg?ph=true', 2, 2, 'Pinko'),

('LOULOU medium in pelle di agnello trapuntata', 'Borsa nera YSL in pelle di agnello trapuntata, elegante e sofisticata.', 1250, 'Nera', '28x20x10 cm', 'https://data.pozzilei.it/images/galleries/34502/30062025_009.png', 1, 1, 'YSL'),

('Microborsa Lady Dior', 'Borsa rosa Dior con charms dorati, simbolo di lusso e femminilità.', 3000, 'Rosa', '22x17x8 cm', 'https://api.platforme.com/api/compose?brand=dior&model=my_lady_dior_cuir&version=879&p=base:cuir:50p_fard&initials=&format=webp', 2, 1, 'Dior'),

('Saddle', 'Iconica borsa Dior nera e beige con monogram e dettagli oro, simbolo di eleganza senza tempo.', 5000, 'Nera e Beige', '30x25x12 cm', 'https://api.platforme.com/api/compose?brand=dior&model=saddle&version=879&p=base:embroidery:m0446criwm928&initials=&format=webp&size=718&logic=1&initials_profile=style::m0446criwm928', 1, 5, 'Dior'),

('Hermès Birkin Sellier 25 Noir con finiture in oro Epsom', 'Classica Hermès Birkin 25 in pelle Epsom nera con finiture in oro, lusso senza compromessi.', 25000, 'Nera', '25x20x13 cm', 'https://alistcolleczioni.com/cdn/shop/files/file_f62ecf55-eb77-417c-8f7f-5186190c9dea.png?v=1713113451&width=2048', 1, NULL, 'Hermès'),

('Hermes Birkin 30 Blu Celeste Borsa Hardware Oro Pelle Epsom', 'Iconica Hermès Birkin 30 in pelle verde con hardware in oro, esclusiva e raffinata.', 33000, 'Verde', '30x25x15 cm', 'https://timepiecetradingllc.com/cdn/shop/files/Untitleddesign_48_3d808c7a-29d3-414a-8762-f08238a8e8eb.png?v=1738771835&width=1946', 2, NULL, 'Hermès'),

('Borsa hobo Wander in nappa matelassé', 'Elegante borsa beige Miu Miu, versatile e raffinata.', 2250, 'Beige', '32x25x15 cm', 'https://d2j6dbq0eux0bg.cloudfront.net/images/42910207/4888688736.webp', 2, 3, 'Miu Miu'),

('Borsa a spalla Chanel', 'Iconica borsa nera Chanel con catenina oro, simbolo di eleganza senza tempo.', 4500, 'Nera', '28x20x10 cm', 'https://www.belloepossibile.com/wp-content/uploads/2023/02/1-600x658.png', 1, 2, 'Chanel'),

('Borsa a spalla Celine', 'Borsa Celine nera, elegante e pratica, perfetta per l’inverno.', 1450, 'Nera', '30x22x12 cm', 'https://www.belloepossibile.com/wp-content/uploads/2025/03/Celine-Luggage-1-500x667.png', 1, NULL, 'Celine'),

('Serpenti Forever Borsa A Spalla', 'Borsa verde royal Bulgari con testa di serpente sulla chiusura, sofisticata e originale.', 3500, 'Verde Royal', '25x18x10 cm', 'https://media.bulgari.com/image/upload/c_pad,h_851,w_1090/q_auto/f_auto/1322774.png', 2, 4, 'Bvlgari'),

('Gucci Jackie', 'Borsa elegante e tipica dello stile Gucci. Pratica ma allo stesso tempo iconica.', 1250, 'Marrone', '20x15x7 cm', 'https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1746025269-636706-huhhg-8565-001-080-0000-light-borsa-gucci-jackie-1961-misura-media-senza-sfondo-68123b2677318.png?crop=1xw:1xh;center,top&resize=980:*', 2, 2, 'Gucci');
