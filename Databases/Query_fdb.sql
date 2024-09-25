


INSERT INTO vendono (id, prezzo, id_ingrediente, id_negozio, valore, unità_misura) 
VALUES 
    (16, 4.50, 15, 2, 250, 'g'),
    (17, 15.00, 7, 5, 0.75, 'l'),
    (18, 1.80, 8, 3, 1, 'kg'),
    (19, 1.50, 9, 3, 1, 'kg'), 
    (20, 0.60, 2, 1, 1.5, 'l'),
    (21, 0.80, 2, 1, 1, 'kg'),
    (22, 1.00, 11, 6, 25, 'g'), 
    (23, 2.00, 12, 4, 400, 'g'), 
    (24, 6.00, 14, 6, 250, 'g'),
    (25, 1.10, 5, 2, 40, 'g'), 
    (26, 1.40, 6, 5, 500, 'g'), 
    (27, 2.70, 7, 2, 500, 'g'),
    (28, 14.50, 8, 4, 1, 'kg'), 
    (29, 3.00, 9, 1, 100, 'g'), 
    (30, 0.80, 4, 2, 1, 'kg');




INSERT INTO vendono (id, prezzo, id_ingrediente, id_negozio, valore, unità_misura) 
VALUES 
    (31, 1.50, 31, 1, 500, 'g'),
    (32, 0.80, 32, 15, 1, 'kg'), 
    (33, 25.00, 33, 5, 0.75, 'l'), 
    (34, 2.50, 34, 18, 1, 'l'),
    (35, 4.00, 35, 6, 40, 'g'), 
    (36, 26.00, 36, 2, 200, 'g'), 
    (37, 1.50, 37, 10, 1, 'kg'), 
    (38, 1.80, 38, 7, 1, 'kg'),
    (39, 12.00, 39, 13, 1, 'g'), 
    (40, 2.60, 40, 4, 500, 'g'), 
    (41, 20.00, 41, 19, 0.75, 'l'), 
    (42, 1.50, 42, 6, 500, 'g'),
    (43, 4.50, 15, 1, 100, 'g');

INSERT INTO vendono (id, prezzo, id_ingrediente, id_negozio, valore, unità_misura) 
VALUES 
    (44, 20.00, 44, 17, 200, 'g'), 
    (45, 3.50, 45, 7, 100, 'g'), 
    (46, 2.00, 46, 10, 500, 'g'), 
    (47, 9.50, 47, 5, 1, 'kg'), 
    (48, 7.50, 48, 20, 500, 'g'), 
    (49, 2.00, 49, 2, 500, 'g'), 
    (50, 2.80, 50, 3, 15, 'g'), 
    (51, 2.80, 51, 12, 15, 'g'), 
    (52, 3.00, 52, 13, 10, 'g'), 
    (53, 2.00, 53, 18, 1, 'kg'), 
    (54, 3.50, 54, 4, 200, 'g'), 
    (55, 2.50, 55, 8, 1, 'l');

INSERT INTO vendono (id, prezzo, id_ingrediente, id_negozio, valore, unità_misura) 
VALUES 
    (56, 0.90, 56, 15, 1, 'kg'), 
    (57, 2.50, 57, 10, 16, 'g'),
    (58, 1.50, 58, 2, 20, 'g'), 
    (59, 1.80, 59, 16, 1, 'kg'), 
    (60, 2.20, 60, 4, 500, 'g'), 
    (61, 18.00, 61, 1, 1, 'kg'), 
    (62, 2.50, 62, 10, 1, 'l'), 
    (63, 2.50, 63, 6, 50, 'g'), 
    (64, 3.00, 64, 2, 1, 'g'), 
    (65, 3.50, 65, 5, 100, 'g'), 
    (66, 2.00, 66, 3, 250, 'g'), 
    (67, 1.50, 67, 11, 1, 'pz'), 
    (68, 2.50, 68, 5, 350, 'g'),
    (69, 1.80, 69, 7, 500, 'ml'), 
    (70, 2.50, 70, 13, 500, 'g'), 
    (71, 9.00, 71, 18, 200, 'g'),
    (72, 8.00, 72, 1, 1, 'kg'), 
    (73, 2.00, 73, 12, 400, 'g'), 
    (74, 3.50, 74, 9, 200, 'g'), 
    (75, 2.00, 75, 8, 200, 'g');






/*Negozi Mialno*/
INSERT INTO negozi (nome, indirizzo, orari, latitudine, longitudine, immagine_negozio, id_utente_azienda) VALUES
('Carrefour', 'Via Mercato 5, Milano', 'Lu-Sa 8:30-21:00; Do 9:00-20:00', 45.467413, 9.206883, 'https://www.example.com/carrefour.jpg', 4),
('Coop', 'Via Pasubio 7, Milano', 'Lu-Sa 8:00-21:00; Do 9:00-19:00', 45.484394, 9.193532, 'https://www.example.com/coop.jpg', 2),
('Pam Local', 'Viale Coni Zugna, 14, Milano', 'Lu-Sa 7:30-22:30; Do 9:00-21:00', 45.460985, 9.162139, 'https://www.example.com/pam-local.jpg', 4),
('Tuodì', 'Via Eugenio Curiel 40, Milano', 'Lu-Sa 8:00-20:00; Do 9:00-13:00', 45.453998, 9.200513, 'https://www.example.com/tuodi.jpg', 2),
('Simply', 'Via Carlo Farini 42, Milano', 'Lu-Sa 8:00-21:00; Do 9:00-14:00', 45.486388, 9.192374, 'https://www.example.com/simply.jpg', 3),
('Lidl', 'Via San Dionigi 1, Milano', 'Lu-Sa 8:00-21:00; Do 9:00-19:00', 45.469308, 9.167547, 'https://www.example.com/lidl.jpg', 4),
('Eurospin', 'Via della Chiesa Rossa 104, Milano', 'Lu-Sa 8:00-20:00; Do 9:00-13:00', 45.424629, 9.098046, 'https://www.example.com/eurospin.jpg', 8),
('Panorama', 'Viale Monza 140, Milano', 'Lu-Sa 8:00-21:00; Do 9:00-20:00', 45.493160, 9.209286, 'https://www.example.com/panorama.jpg', 2),
('LD Market', 'Via Varanese 28, Milano', 'Lu-Sa 8:00-21:00; Do 9:00-20:00', 45.487704, 9.139859, 'https://www.example.com/ld-market.jpg', 3),
('Penny Market', 'Viale Sarca 29, Milano', 'Lu-Sa 8:00-21:00; Do 9:00-16:00', 45.513154, 9.199976, 'https://www.example.com/penny-market.jpg', 11),
('Sidis', 'Via Vitruvio 11, Milano', 'Lu-Sa 8:00-21:00; Do 9:00-13:00', 45.485357, 9.204265, 'https://www.example.com/sidis.jpg', 2),
('Maxì Discount', 'Via Padova 253, Milano', 'Lu-Sa 8:00-21:00; Do 9:00-14:00', 45.497815, 9.230164, 'https://www.example.com/maxi-discount.jpg', 13),
('Sisa', 'Via Fontana 18, Milano', 'Lu-Sa 8:00-21:00; Do 9:00-14:00', 45.497813, 9.182466, 'https://www.example.com/sisa.jpg', 4),
('Basko', 'Via Falcone e Borsellino, Milano', 'Lu-Sa 8:00-20:00; Do 9:00-13:00', 45.407150, 9.119521, 'https://www.example.com/basko.jpg', 5);

/*Rho*/
INSERT INTO negozi (nome, indirizzo, orari, latitudine, longitudine, immagine_negozio, id_utente_azienda) VALUES
('Carrefour Market', 'Via Firenze, 3, Rho', 'Lu-Sa 8:00-21:00; Do 9:00-14:30', 45.529621, 9.038103, 'https://www.example.com/carrefour-rho.jpg', 2),
('Lidl', 'Strada Provinciale 34, Rho', 'Lu-Sa 8:30-20:30; Do 8:30-13:00', 45.554521, 9.058987, 'https://www.example.com/lidl-rho.jpg', 3),
('Sigma', 'Via Giusti, 7, Rho', 'Lu-Sa 8:00-20:00; Do 9:00-13:00', 45.540436, 9.036156, 'https://www.example.com/sigma-rho.jpg', 2),
('Tuodì', 'Via Franchetti, 8, Rho', 'Lu-Sa 8:00-20:00; Do 9:00-13:00', 45.544805, 9.031070, 'https://www.example.com/tuodi-rho.jpg', 4),
('Pam Local', 'Strada Provinciale 233, Rho', 'Lu-Sa 7:30-20:30; Do 9:00-13:00', 45.537687, 9.057892, 'https://www.example.com/pam-local-rho.jpg', 5);

/* Bergamo*/
INSERT INTO negozi (nome, indirizzo, orari, latitudine, longitudine, immagine_negozio, id_utente_azienda) VALUES
('Coop', 'Via Suardi, 128, Bergamo', 'Lu-Sa 8:00-21:00; Do 9:00-20:00', 45.706184, 9.650460, 'https://www.example.com/coop-bergamo.jpg', 2),
('Esselunga', 'Via San Bernardino, 114, Bergamo', 'Lu-Sa 8:00-21:00; Do 9:00-20:00', 45.687734, 9.654952, 'https://www.example.com/esselunga-bergamo.jpg', 22),
('Iperal', 'Via Autostrada, 39, Bergamo', 'Lu-Sa 8:00-21:00; Do 9:00-20:00', 45.676618, 9.690117, 'https://www.example.com/iperal-bergamo.jpg', 2),
('Pam Panorama', 'Via Papa Giovanni XXIII, 66, Bergamo', 'Lu-Sa 8:00-21:00; Do 9:00-20:00', 45.706657, 9.677194, 'https://www.example.com/pam-panorama-bergamo.jpg', 24),
('Lidl', 'Via Angelo Maj, 13, Bergamo', 'Lu-Sa 8:30-20:30; Do 9:00-13:00', 45.702122, 9.689551, 'https://www.example.com/lidl-bergamo.jpg', 2),
('Eurospin', 'Via Pollini, 8, Bergamo', 'Lu-Sa 8:00-20:00; Do 9:00-13:00', 45.702595, 9.691265, 'https://www.example.com/eurospin-bergamo.jpg', 4),
('Maxiì Supermercati', 'Via Autostrada, 7, Bergamo', 'Lu-Sa 8:00-21:00; Do 9:00-20:00', 45.672725, 9.690480, 'https://www.example.com/maxi-supermercati-bergamo.jpg', 27),
('Sigma', 'Via Falck, 16, Bergamo', 'Lu-Sa 8:00-20:00; Do 9:00-13:00', 45.719557, 9.665067, 'https://www.example.com/sigma-bergamo.jpg', 5);


INSERT INTO negozi (nome_negozio, indirizzo, orari, latitudine, longitudine, immagine_negozio, id_utente_azienda) 
VALUES 
('Esselunga Baggio', 'Via Achille Grandi 7, Milano', 'Lun-Dom: 8:00-22:00', '45.5102', '9.1046', 'https://www.example.com/image1.jpg', 1),
('Esselunga Rho', 'Via Lazio 3, Rho (MI)', 'Lun-Dom: 8:00-22:00', '45.5429', '9.0428', 'https://www.example.com/image2.jpg', 1),
('Esselunga Garibaldi', 'Via Marco Polo 13, Milano', 'Lun-Dom: 8:00-22:00', '45.4795', '9.1925', 'https://www.example.com/image3.jpg', 1),
('Esselunga Vittuone', 'Via Novara 9, Vittuone (MI)', 'Lun-Sab: 8:00-21:00; Dom: 8:00-13:00', '45.4479', '8.9361', 'https://www.example.com/image4.jpg', 1),
('Esselunga Giambellino', 'Via Fratelli Zoia, Milano', 'Lun-Dom: 8:00-22:00', '45.4419', '9.1453', 'https://www.example.com/image5.jpg', 1),
('Esselunga Solari', 'Via Washington, 70, Milano', 'Lun-Dom: 8:00-22:00', '45.4546', '9.1589', 'https://www.example.com/image6.jpg', 1),
('Esselunga Vimodrone', 'Via Milano, Vimodrone', 'Lun-Dom: 8:00-22:00', '45.5106', '9.2796', 'https://www.example.com/image7.jpg', 1),
('Esselunga Pioltello', 'Via Primo Maggio, Pioltello (MI)', 'Lun-Dom: 8:00-22:00', '45.5064', '9.3277', 'https://www.example.com/image8.jpg', 1),
('Esselunga Sesto S. Giovanni', 'Via Martiri della Libertà, Sesto San Giovanni (MI)', 'Lun-Dom: 8:00-22:00', '45.5322', '9.2312', 'https://www.example.com/image9.jpg', 9),
('Esselunga Lissone', 'Via Giovanni XXIII 110, Lissone (MI)', 'Lun-Sab: 8:00-21:00; Dom:8:00-13:00', '45.6151', '9.2383', 'https://www.example.com/image10.jpg', 10),
('Esselunga Lambrate', 'Viale Monza, Milano', 'Lun-Dom: 8:00-22:00', '45.4945', '9.2346', 'https://www.example.com/image11.jpg', 1),
('Esselunga Pioltello 2', 'Via Conciliazione, Pioltello (MI)', 'Lun-Dom: 8:00-22:00', '45.5061', '9.2903', 'https://www.example.com/image12.jpg', 1),
('Esselunga Corso Lodi', 'Corso Lodi, 70, Milano', 'Lun-Dom: 8:00-22:00', '45.4526', '9.1995', 'https://www.example.com/image13.jpg', 1),
('Esselunga Cesano Boscone', 'Viale Italia 28, Cesano Boscone (MI)', 'Lun-Dom: 8:00-22:00', '45.4496', '9.0514', 'https://www.example.com/image14.jpg', 1),
('Esselunga Cinisello', 'Via XXV Aprile, Cinisello Balsamo (MI)', 'Lun-Dom: 8:00-22:00', '45.5418', '9.2082', 'https://www.example.com/image15.jpg', 1);