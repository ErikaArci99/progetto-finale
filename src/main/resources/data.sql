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
('Le 5 à 7 mini in pelle verniciata', 'Elegante mini bag in vinile bordeaux dal finish lucido, perfetta per serate sofisticate.', 1500, 'Bordeaux', '20x15x8 cm', 'https://saint-laurent.dam.kering.com/m/437aae3345a4a3e7/Medium2-710318B870W6259_A.jpg?v=2', 1, NULL, 'YSL'),

('Alma BB', 'Iconica borsa marrone e beige Louis Vuitton, impreziosita da charms pendenti che ne esaltano il fascino unico.', 1600, 'Marrone e Beige', '22x17x10 cm', 'https://it.louisvuitton.com/images/is/image/lv/1/PP_VP_L/louis-vuitton-alma-bb--M46990_PM1_Worn%20view.png?wid=1090&hei=1090', 2, 1, 'Louis Vuitton'),

('Fendi Sunshine Small', 'Borsa compatta in pelle marrone con dettagli color cuoio e monogram Fendi, elegante e versatile.', 2000, 'Marrone e Color Cuoio', '23x18x11 cm', 'https://static.fendi.com/dam/is/image/fendi/8BH386ALVYF1GE3_01?wid=1224&hei=1224&bgc:253253253%20view.png?wid=1090&hei=1090', 1, 2, 'Fendi'),

('Nano Speedy', 'Piccola borsa beige e marrone Louis Vuitton con tracolla, perfetta per un look chic e minimale.', 1600,'Beige e Marrone', '18x13x9 cm', 'https://it.louisvuitton.com/images/is/image/lv/1/PP_VP_L/louis-vuitton-nano-speedy--M81085_PM2_Front%20view.png?wid=490&hei=490wid=1224&hei=1224&bgc:253253253%20view.png?wid=1090&hei=1090', 1, NULL, 'Louis Vuitton'),

('Cleo Satin Crystal', 'Borsa azzurra Prada tempestata di diamanti, raffinata e scintillante, perfetta per eventi esclusivi.', 3200, 'Azzurra', '25x18x7 cm', 'https://oneminutes.it/cdn/shop/files/8B39173C-1486-42EE-A05F-4375F638D011.jpg?v=1745969734&width=360', 2, 2, 'Prada'),

('Il grande bambino', 'Borsa nera Jaquemouse dal design originale e giocoso, ideale per outfit casual estivi.', 350, 'Nera', '28x20x10 cm', 'https://oneminutes.it/cdn/shop/files/914BC357-13A1-4E20-8365-9ED138B8CCB7.jpg?v=1747397860&width=360', 2, 3, 'Jaquemouse'),

('Borsa hobo Wander in nappa matelassé', 'Elegante borsa nera drappeggiata Miu Miu, raffinata e capiente.', 2250,'Nera', '32x25x15 cm', 'https://www.miumiu.com/content/dam/miumiubkg_products/5/5BC/5BC125/AN88F0002/5BC125_AN88_F0002_V_OOY_SLF.jpg/_jcr_content/renditions/cq5dam.web.hE7E3DA.1200.1200.jpg', 1, 4, 'Miu Miu'),

('Mini Love Bag Click full strass PINKO Galleria', 'Borsa azzurra PINKO tempestata di diamanti, chic e scintillante, perfetta per look estivi glamour.', 1250, 'Azzurra e Argento', '20x15x7 cm', 'https://res.cloudinary.com/gimg1/image/upload/w_auto:200:497,c_fill,f_auto,q_auto/v1/Pinko/Style/STILLECOM/100067A0SR-E45N', 2, 2, 'Pinko'),

('LOULOU medium in pelle di agnello trapuntata', 'Borsa nera YSL in pelle di agnello trapuntata, elegante e sofisticata.', 1250, 'Nera', '28x20x10 cm', 'https://saint-laurent.dam.kering.com/m/125af6c335c71e80/Medium2-801439AAEAX1000_A.jpg?v=2', 1, 1, 'YSL'),

('Microborsa Lady D-Joy', 'Borsa azzurra Dior con charms dorati, simbolo di lusso e femminilità.', 3000, 'Azzurra', '22x17x8 cm', 'https://assets.christiandior.com/is/image/diorprod/S0910ONGEM81B_E01-1?$default_GHC$&crop=472,851,1022,966&wid=1024&hei=1107&scale=0.4843&bfc=on&qlt=85', 2, 1, 'Dior'),

('Saddle', 'Iconica borsa Dior nera e beige con monogram e dettagli oro, simbolo di eleganza senza tempo.', 5000, 'Nera e Beige', '30x25x12 cm', 'https://assets.christiandior.com/is/image/diorprod/M0446CRIWM928_E01-2?$default_GHC$&crop=403,196,1194,1750&wid=1850&hei=2000&scale=0.875&bfc=on&qlt=85', 1, 5, 'Dior'),

('Hermès Birkin Sellier 25 Noir con finiture in oro Epsom', 'Classica Hermès Birkin 25 in pelle Epsom nera con finiture in oro, lusso senza compromessi.', 25000, 'Nera', '25x20x13 cm', 'https://a.1stdibscdn.com/hermes-birkin-sellier-25-noir-epsom-gold-hardware-for-sale/v_39262/v_263402421747998154048/v_26340242_1747998154628_bg_processed.jpg?disable=upscale&auto=webp&quality=60&width=305', 1, NULL, 'Hermès'),

('Hermes Birkin 30 Blu Celeste Borsa Hardware Oro Pelle Epsom', 'Iconica Hermès Birkin 30 in pelle azzurra con hardware in oro, esclusiva e raffinata.', 33000, 'Azzurra', '30x25x15 cm', 'https://a.1stdibscdn.com/hermes-birkin-30-blue-celeste-bag-gold-hardware-epsom-leather-for-sale/1121189/v_250155221735648471721/25015522_datamatics.jpg?disable=upscale&auto=webp&quality=60&width=305', 2, NULL, 'Hermès'),

('Borsa hobo Wander in nappa matelassé', 'Elegante borsa beige Miu Miu, versatile e raffinata.', 2250, 'Beige', '32x25x15 cm', 'https://www.miumiu.com/content/dam/miumiubkg_products/5/5BC/5BC125/AN88F0009/5BC125_AN88_F0009_V_OOY_SLF.jpg/_jcr_content/renditions/cq5dam.web.hE7E3DA.1200.1200.jpg', 2, 3, 'Miu Miu'),

('Borsa a spalla Chanel', 'Iconica borsa nera Chanel con catenina argento, simbolo di eleganza senza tempo.', 4500, 'Nera', '28x20x10 cm', 'https://cdn1.jolicloset.com/img4/detail4b/2024/12/1854282-1/borse-chanel.jpg', 1, 2, 'Chanel'),

('Borsa a spalla Tina in tela Triomphe', 'Borsa Celine marrone e nera, elegante e pratica, perfetta per l’inverno.', 1450, 'Marrone e Nera', '30x22x12 cm', 'https://image.celine.com/23ea5086b2a4ee19/original/123052DQW-38NO_1_WIN25_W_V1.jpg?im=Resize=(720);AspectCrop=(1,1),xPosition=.5,yPosition=.5', 1, NULL, 'Celine'),

('Serpenti Forever Borsa A Spalla', 'Borsa verde royal Bulgari con testa di serpente sulla chiusura, sofisticata e originale.', 3500, 'Verde Royal', '25x18x10 cm', 'https://media.bulgari.com/image/upload/c_pad,h_851,w_1090/q_auto/f_auto/1322774.png', 2, 4, 'Bvlgari'),

('Mini Love Bag Click full strass PINKO Galleria', 'Borsa fucsia PINKO tempestata di diamanti, ideale per look estivi scintillanti.', 1250, 'Fucsia', '20x15x7 cm', 'https://res.cloudinary.com/gimg1/image/upload/w_auto:200:497,c_fill,f_auto,q_auto/v1/Pinko/Style/STILLECOM/100067A0SR-N17L', 2, 2, 'Pinko');
