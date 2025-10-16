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
(30, '2025-11-15', '2025-12-31');

-- borse (con brand)
INSERT INTO `borsa` 
(`nome`, `descrizione`, `prezzo`, `prezzo_scontato`, `colore`, `dimensioni`, `immagine`, `collezione_id`, `sconto_id`, `brand`) 
VALUES 
('Borsa Elegance', 'Borsa in pelle nera con dettagli dorati', 149.99, NULL, 'Nero', '30x20x10 cm', 'https://picsum.photos/id/1011/400/300', 1, NULL, 'LuxBag'),
('Borsa Summer Vibes', 'Borsa in tessuto colorato, perfetta per l’estate', 79.99, 59.99, 'Azzurro', '35x25x12 cm', 'https://picsum.photos/id/1025/400/300', 2, 1, 'SunnyStyle'),
('Borsa Classic', 'Design minimal in cuoio marrone', 120.00, NULL, 'Marrone', '32x22x11 cm', 'https://picsum.photos/id/1035/400/300', 1, NULL, 'ClassicLeather'),
('Borsa Sunset', 'Borsa arancione con riflessi dorati, ideale per l’estate', 99.99, 69.99, 'Arancione', '33x21x10 cm', 'https://picsum.photos/id/1045/400/300', 2, 2, 'SunshineBag');
