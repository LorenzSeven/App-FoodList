-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: db_finale
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aggiungono`
--

DROP TABLE IF EXISTS `aggiungono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aggiungono` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantità` varchar(45) NOT NULL,
  `id_utente` int NOT NULL,
  `id_ingrediente` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_utente_ingrediente` (`id_utente`,`id_ingrediente`),
  KEY `utente_idx` (`id_utente`),
  KEY `ingrediente_idx` (`id_ingrediente`),
  CONSTRAINT `ingrediente_spesa` FOREIGN KEY (`id_ingrediente`) REFERENCES `ingredienti` (`id`),
  CONSTRAINT `utente_spesa` FOREIGN KEY (`id_utente`) REFERENCES `utenti_consumer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aggiungono`
--

LOCK TABLES `aggiungono` WRITE;
/*!40000 ALTER TABLE `aggiungono` DISABLE KEYS */;
INSERT INTO `aggiungono` VALUES (3,'1',2,3),(4,'1',4,4),(5,'1',3,5),(6,'1',5,6),(7,'1',2,7),(9,'1',4,9),(10,'1',3,10),(11,'1',3,9),(12,'1',1,9);
/*!40000 ALTER TABLE `aggiungono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contengono`
--

DROP TABLE IF EXISTS `contengono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contengono` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_ricetta` int NOT NULL,
  `id_ingrediente` int NOT NULL,
  `valore` float(6,2) NOT NULL,
  `unità_misura` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_ingrediente_idx` (`id_ingrediente`),
  KEY `ricetta_idx` (`id_ricetta`),
  CONSTRAINT `ingrediente_della_ricetta` FOREIGN KEY (`id_ingrediente`) REFERENCES `ingredienti` (`id`),
  CONSTRAINT `ricetta_di_ingrediente` FOREIGN KEY (`id_ricetta`) REFERENCES `ricette` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contengono`
--

LOCK TABLES `contengono` WRITE;
/*!40000 ALTER TABLE `contengono` DISABLE KEYS */;
INSERT INTO `contengono` VALUES (1,1,18,200.00,'g'),(2,1,19,300.00,'g'),(3,1,20,300.00,'ml'),(4,1,21,10.00,'g'),(5,1,22,4.00,'g'),(6,1,23,300.00,'g'),(7,1,24,200.00,'g'),(8,1,25,0.00,'q.b.'),(9,1,3,0.00,'q.b.'),(10,1,26,0.00,'q.b.'),(11,2,26,350.00,'g'),(12,2,19,150.00,'g'),(13,2,27,250.00,'g'),(14,2,13,5.00,' '),(15,2,28,300.00,'g'),(16,2,29,150.00,'g'),(17,2,30,50.00,'g'),(18,2,31,50.00,'g'),(19,2,32,220.00,'g'),(20,2,33,100.00,'g'),(21,2,23,300.00,'g'),(22,2,34,0.00,'q.b.'),(23,2,3,1.00,'cucchiaio'),(24,2,21,0.00,'q.b.'),(25,2,10,0.00,'q.b.'),(26,2,9,70.00,'g'),(27,2,2,1.00,'L'),(28,2,35,0.00,'q.b.'),(29,2,36,270.00,'g'),(30,3,39,1.00,'cucchiaio'),(31,3,40,320.00,'g'),(32,3,9,125.00,'g'),(33,3,32,1.00,' '),(34,3,36,80.00,'g'),(35,3,41,40.00,'g'),(36,3,20,0.00,'q.b.'),(37,3,34,1.00,'L'),(38,3,21,0.00,'q.b.'),(39,4,42,320.00,'g'),(40,4,43,150.00,'g'),(41,4,13,6.00,' '),(42,4,44,50.00,'g'),(43,4,10,0.00,'q.b.'),(44,5,12,750.00,'g'),(45,5,8,5.00,' '),(46,5,15,250.00,'g'),(47,5,14,120.00,'g'),(48,5,16,300.00,'g'),(49,5,45,0.00,'q.b.'),(50,6,46,250.00,'g'),(51,6,47,250.00,'g'),(52,6,48,150.00,'g'),(53,6,29,100.00,'g'),(54,6,31,60.00,'g'),(55,6,30,60.00,'g'),(56,6,32,60.00,'g'),(57,6,49,1.00,'spicchio'),(58,6,41,60.00,'g'),(59,6,3,50.00,'g'),(60,6,50,1.00,'rametto'),(61,6,51,3.00,'foglie'),(62,6,52,2.00,'foglie'),(63,6,10,0.00,'q.b.'),(64,6,21,0.00,'q.b.'),(65,6,20,0.00,'q.b.'),(66,7,53,1.70,'kg'),(67,7,23,1.00,'kg'),(68,7,54,500.00,'g'),(69,7,36,150.00,'g'),(70,7,32,1.00,' '),(71,7,25,0.00,'q.b.'),(72,7,3,0.00,'q.b.'),(73,7,10,0.00,'q.b.'),(74,7,21,0.00,'q.b.'),(75,7,55,0.00,'q.b.'),(76,8,56,1.00,'kg'),(77,8,20,600.00,'g'),(78,8,57,7.00,'g'),(79,8,21,20.00,'g'),(80,8,3,60.00,'g'),(81,8,23,700.00,'g'),(82,8,49,4.00,'spicchi'),(83,8,58,20.00,'g'),(84,8,10,0.00,'q.b.'),(85,9,59,1.00,'kg'),(86,9,19,300.00,'g'),(87,9,13,1.00,' '),(88,9,21,0.00,'q.b.'),(89,9,60,0.00,'q.b.'),(90,9,23,600.00,'g'),(91,9,25,6.00,'foglie'),(92,9,49,1.00,'spicchio'),(93,9,3,0.00,'q.b.'),(94,9,24,250.00,'g'),(95,9,36,70.00,'g'),(96,10,61,1.20,'kg'),(97,10,62,500.00,'g'),(98,10,32,250.00,'g'),(99,10,19,50.00,'g'),(100,10,41,50.00,'g'),(101,10,3,50.00,'g'),(102,10,9,40.00,'g'),(103,10,21,0.00,'q.b.'),(104,10,10,0.00,'q.b.'),(105,10,63,1.00,'ciuffo'),(106,10,49,2.00,'spicchi'),(107,10,64,1.00,' '),(108,11,65,260.00,'g'),(109,11,13,3.00,' '),(110,11,9,65.00,'g'),(111,11,19,65.00,'g'),(112,11,66,20.00,'g'),(113,11,14,90.00,'g'),(114,11,67,1.00,' '),(115,11,21,1.00,'pizzico'),(116,11,68,150.00,'g'),(117,11,69,125.00,'g'),(118,12,39,1.00,'bustina'),(119,12,9,55.00,'g'),(120,12,70,500.00,'g'),(121,12,21,1.00,'pizzico'),(122,12,20,1.50,'L'),(123,12,71,150.00,'g'),(124,12,10,0.00,'q.b.'),(125,12,32,0.50,' '),(126,12,72,100.00,'g'),(127,12,3,0.00,'q.b.'),(128,12,23,200.00,'ml'),(129,12,73,80.00,'g'),(130,12,33,50.00,'ml'),(131,12,74,30.00,'g'),(132,12,24,60.00,'g'),(133,12,19,200.00,'g'),(134,12,75,0.00,'q.b.'),(135,12,55,0.00,'q.b.');
/*!40000 ALTER TABLE `contengono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredienti`
--

DROP TABLE IF EXISTS `ingredienti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredienti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredienti`
--

LOCK TABLES `ingredienti` WRITE;
/*!40000 ALTER TABLE `ingredienti` DISABLE KEYS */;
INSERT INTO `ingredienti` VALUES (1,'Farina di grano','Molino Rossetto'),(2,'Latte intero','Parmalat'),(3,'Olio di oliva extravergine','Carli'),(4,'Sale marino','Cervia'),(5,'Pomodori','Mutti'),(6,'Mozzarella di bufala','La Fattoria'),(7,'Zucchero semolato','Zefiro'),(8,'Uova fresche','Agricola Pagano'),(9,'Burro','Granarolo'),(10,'Pepe nero','LaDrogheria'),(12,'Mascarpone','Galbani'),(13,'Uova','Uova Gallo'),(14,'Zucchero','Zucchero di canna'),(15,'Savoiardi','Matilde Vicenzi'),(16,'Caffè','Lavazza'),(17,'Marsala','Florio'),(18,'Farina Manitoba','Barilla'),(19,'Farina 00','Barilla'),(20,'Acqua','San Benedetto'),(21,'Sale fino','Italkali'),(22,'Lievito di birra fresco','Lievital'),(23,'Passata di pomodoro','Mutti'),(24,'Mozzarella','Santa Lucia'),(25,'Basilico','Barilla'),(26,'Semola di grano duro','DeCecco'),(27,'Spinaci','Orogel'),(28,'Carne Bovina','Razza Piemontese'),(29,'Pancetta','Negroni'),(30,'Carote','Solarelli'),(31,'Sedano','Sapori del mio Orto'),(32,'Cipolle dorate','Esselunga'),(33,'Vino rosso','Conterno Barolo'),(34,'Brodo vegetale','Star'),(35,'Noce Moscata','LaDrogheria'),(36,'Parmigiano Reggiano DOP','Trentino'),(37,'Mela Rossa','Albero Rosso'),(38,'Mela Verde','Albero Verde'),(39,'Zafferano in pistilli','Zafferano dell’Aquila'),(40,'Riso Carnaroli','Terra del Riso'),(41,'Vino bianco','Ca\' Del Bosco'),(42,'Spaghetti','DeCecco'),(43,'Guanciale','Il Guanciale Amatriciano'),(44,'Pecorino Romano DOP','Caseificio Storico Amatrice'),(45,'Cacao amaro in polvere','Perugina'),(46,'Tagliatelle all\'uovo','DeCecco'),(47,'Manzo tritato','AIA'),(48,'Salsiccia','AIA'),(49,'Aglio','Ziello Arcangelo'),(50,'Rosmarino','Le Erbe Aromatiche'),(51,'Salvia','Le Erbe Aromatiche'),(52,'Alloro','Le Aromatiche di Girafi'),(53,'Melanzane ovali nere','Ortofrutta'),(54,'Fiordilatte','Latteria Sociale'),(55,'Olio di semi di arachide','Zucchi'),(56,'Farina 0','Barilla'),(57,'Lievito di birra secco','PaneAngeli'),(58,'Origano secco','LaDrogheria'),(59,'Patate Rosse','Esselunga'),(60,'Semola','DeCecco'),(61,'Ossobuchi di vitello','Eurocash'),(62,'Brodo di carne','Star'),(63,'Prezzemolo','Terre e gusti'),(64,'Scorze di limone','BioVegan'),(65,'Cioccolato fondente al 60%','Zaini Emilia'),(66,'Zucchero a Velo','PaneAngeli'),(67,'Baccello di vaniglia','PaneAngeli'),(68,'Confettura di Albicocche','Fior di Frutta'),(69,'Panna fresca liquida','Lactis'),(70,'Riso vialone nano','Scotti'),(71,'Formaggio Caciocavallo','Ferranti'),(72,'Maiale macinato','Esselunga'),(73,'Pisellini','ValFrutta'),(74,'Prosciutto cotto','Negroni'),(75,'Pane grattuggiato','GrissinBon');
/*!40000 ALTER TABLE `ingredienti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `negozi`
--

DROP TABLE IF EXISTS `negozi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `negozi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `indirizzo` varchar(45) NOT NULL,
  `orari` varchar(200) NOT NULL,
  `latitudine` float NOT NULL,
  `longitudine` float NOT NULL,
  `immagine_negozio` varchar(100) DEFAULT NULL,
  `id_utente_azienda` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_u_azienda_idx` (`id_utente_azienda`),
  CONSTRAINT `id_utent_azienda` FOREIGN KEY (`id_utente_azienda`) REFERENCES `utenti_azienda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `negozi`
--

LOCK TABLES `negozi` WRITE;
/*!40000 ALTER TABLE `negozi` DISABLE KEYS */;
INSERT INTO `negozi` VALUES (1,'','Via Roma, 24','Lun: 10:00-14:00, Mar-Sab: 9:00-19:00, Dom: chiuso',44.5013,11.3305,'',1),(2,'','Viale delle Terme, 67','Lun-Ven: 8:30-13:00, 14:00-17:30, Sab: 8:30-12:30, Dom: chiuso',43.5411,11.3532,'',2),(3,'','Piazza del Popolo, 1','Lun-Sab: 9:00-20:00, Dom: 10:00-14:00',41.8954,12.4764,'',3),(4,'','Via XX Settembre, 3','Lun-Ven: 9:00-20:00, Sab: 9:00-13:00, Dom: chiuso',45.4642,9.19,'',4),(5,'','Piazza San Babila, 10','Lun-Sab: 10:00-19:30, Dom: chiuso',45.4665,9.1979,'',5),(6,'','Via Marconi, 32','Lun-Ven: 8:00-13:00, 14:00-19:00, Sab: 8:00-12:30, Dom: chiuso',44.5075,11.3423,'',2),(7,'','Corso Italia, 57','Lun-Sab: 9:00-20:00, Dom: chiuso',45.4754,9.1914,'',1),(8,'','Via Nazionale, 123','Lun-Ven: 9:00-13:00, 14:00-18:00, Sab: 9:00-12:30, Dom: chiuso',41.9017,12.4953,'',3),(9,'','Viale Europa, 15','Lun-Sab: 10:00-21:00, Dom: chiuso',41.7369,12.2594,'',4),(10,'','Via Roma, 189','Lun-Ven: 9:00-12:30, 15:00-19:00, Sab: 9:00-12:30, 15:00-18:00, Dom: chiuso',44.4061,8.9326,'',5);
/*!40000 ALTER TABLE `negozi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ricette`
--

DROP TABLE IF EXISTS `ricette`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ricette` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `nazionalità` varchar(45) NOT NULL,
  `tempo_preparazione` varchar(45) NOT NULL,
  `difficoltà` varchar(45) NOT NULL,
  `descrizione` varchar(5000) NOT NULL,
  `immagine` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ricette`
--

LOCK TABLES `ricette` WRITE;
/*!40000 ALTER TABLE `ricette` DISABLE KEYS */;
INSERT INTO `ricette` VALUES (1,'Pizza Margherita','Primo','Italiana','60 minuti','Media','(Preparazione)||(Step 1)|Per preparare la pasta per la pizza abbiamo scelto di impastare il tutto a mano, ma se preferite utilizzare l’impastatrice potrete seguire gli stessi procedimenti, utilizzando il gancio a velocità medio bassa. Come prima cosa versate le due farine in una ciotola, sbriciolate il lievito all\'interno e versate l\'acqua poco per volta. La temperatura ideale dell\'acqua è di 25°.||(Step 2)|Mescolate man mano con un mestolo di legno e quando avrete aggiunto quasi tutta l\'acqua aggiungete anche il sale. Continuate ad aggiungere l\'acqua iniziando ad impastare con le mani, per amalgamare gli ingredienti.||(Step 3)|Infine trasferite l’impasto sul piano da lavoro e lavoratelo con le mani fino a che non sarà liscio e omogeneo. A questo punto lasciatelo riposare sul piano di lavoro per una decina di minuti coprendolo con la ciotola. Una volta riposato dategli una piccola piega: immaginate che la sfera sia divisa in 4 parti, prendete l’estremità di ognuna, tiratela delicatamente e ripiegatela verso il centro.||(Step 4)|Una volta fatte le 4 pieghe rigirandolo su se stesso dategli la forma di una sfera. Trasferite l\'impasto così formato in una ciotola, coprite con pellicola trasparente e lasciate lievitare. Per comodità potete mettere la ciotola in forno spento ma con la luce accesa, così l’interno raggiungerà la temperatura di 26-28°, ideale per la lievitazione; in alternativa potete anche tenere la bacinella in un luogo caldo. I tempi sono approssimativi poiché ogni impasto, la temperatura e le condizioni metereologiche influenzano la lievitazione: mediamente l’impasto dovrebbe impiegare 6 ore a raddoppiare di volume.||(Step 5)|Trascorso il tempo della lievitazione, l\'impasto sarà bello gonfio, quindi trasferitelo sul piano da lavoro e dividetelo con un tarocco in 3 pezzi da 265 g. Se dovesse servirvi, potete infarinare leggermente il piano di lavoro. Ora prendete ciascuna porzione e come fatto prima sollevate un lembo di pasta e portatelo verso l\'interno. Ripetete la stessa operazione per gli altri 3 lembi di pasta.||(Step 6)|Capovolgete l\'impasto e procedete con la pirlatura: pirlare l\'impasto significa farlo girare con le mani sul ripiano di lavoro portandolo verso di voi e poi allontanandolo ripetutamente fino ad ottenere una sfera liscia e regolare. Trasferite man mano i panetti in una cassetta per pizza precedentemente unta e coprite con il suo coperchio.||(Step 7)|Lasciateli riposare per altri 30 minuti. Nel frattempo posizionate nel forno la pietra refrattaria, sistematela in alto. Accendete il forno portando la temperatura a 250° e azionando la modalità statica. Ora utilizzando un tarocco sollevate delicatamente il primo panetto. Trasferitelo su un piano con abbondante semola e aggiungete ancora un po\' di semola in superficie. Con la punta delle dita schiacciate il panetto al centro.||(Step 8)|Continuate in questo modo facendo un movimento rotatorio in modo da allargare l\'impasto. Non schiacciate mai i bordi, e proseguite sino ad ottenere un disco da 28 cm. Trasferite l’impasto sulla pala, avendo cura di non rovinarlo.||(Step 9)|Ora aiutandovi con un cucchiaio stendete la passata di pomodoro sulla pizza, lasciando un bordo libero. Infornate, facendo scivolare delicatamente la pizza sulla pietra refrattaria e lasciate cuocere per circa 6 minuti. Nel ftrattempo tagliate la mozzarella a bastoncini o sfilacciatela con le mani. Poitete strizzarla delicatamente in modo che non rilasci troppa acqua in cottura 26. Trascorsi i 6 minuti, sempre utilizzando la pala sfornate la pizza.||(Step 10)|Sistemate sopra i bastoncini di mozzarella e infornatela per altri 6 minuti circa. Quando sarà ben dorata sfornatela, aggiungete le foglie di basilico, se gradite un filo d\'olio e servite. Preparate così anche le altre due pizze e gustatele calde.||(Conservazione)|La pasta per la pizza una volta lievitata può anche essere congelata, meglio se divisa già in porzioni, e conservata in un sacchetto gelo. Successivamente sarà sufficiente lasciar scongelare la propria porzione a temperatura ambiente e proseguire come da ricetta. Se preferite potete anche congelare la pizza margherita da semi cotta: basterà effettuare metà cottura, lasciarla raffreddare e infine congelarla coperta da alluminio; successivamente basterà cuocerla, ancora congelata, ad una temperatura un po’ più bassa.||(Intolleranze)|Lattosio','https://cdn.shopify.com/s/files/1/0586/6795/8427/articles/Margherita-9920.jpg?crop=center&height=915&v=1644590028&width=1200'),(2,'Lasagne alla Bolognese','Primo','Italiana','90 minuti','Media','(Preparazione)||(Step 1)|Fate stufare il soffritto di carote, sedano e cipolla tritati finemente in una casseruola con poco olio, bagnando eventualmente con dell’acqua fino a che non diventeranno tenerissimi.||(Step 2)|Unite la carne macinata e fatela rosolare velocemente per bene a fuoco medio-alto. Salate e pepate. Quando la carne risulta asciutta, sfumatela con il vino rosso corposo e fatelo evaporare a fuoco vivo.||(Step 3)|Aggiungete la polpa di pomodoro frullata, un paio di foglie di alloro e mescolate. Proseguite la cottura a fuoco basso coprendo con il coperchio per almeno 1 ora mescolando ogni tanto. Assaggiate il ragù e regolate eventualmente di sapore con sale e pepe. Se avete più tempo a disposizione fate cuocere il ragù per più tempo, aggiungendo eventualmente dell’acqua se si dovesse seccare troppo.||(Step 4)|Nel frattempo preparare la besciamella. Fate fondere il burro in una casseruola, unite la farina e versateci dentro tutto il latte freddo, lavorando con una frusta. Lasciate cuocere sempre mescolando fino ad ottenere una besciamella liscia e abbastanza fluida. Salate e date carattere con una grattata di noce moscata.||(Step 5)|Fate cuocere i fogli di pasta all’uovo in abbondante acqua bollente salata. Sbollentateli uno alla volta per circa 30 secondi e scolateli su un panno da cucina pulito distanziati.||(Step 6)|Imburrate una pirofila da 20 x 30 centimetri e foderatela con le sfoglie di pasta all’uovo, versateci un leggero strato di ragù, uno di besciamella e una spolverata di parmigiano grattugiato.||(Step 7)|Coprite con le sfoglie di pasta e proseguite con altri strati fino ad esaurimento degli ingredienti. In base a questi quantità dovreste ottenere 5 strati.||(Step 8)|Infornate la lasagna a 180° per circa 30 minuti, finché la superficie non risulterà croccante e dorata.||(Conservazione)|Conservate il ragù in frigorifero, chiuso in un contenitore ermetico, per 2-3 giorni al massimo. E\' possibile congelare il ragù.Potete conservare le lasagne in frigorifero, coperte con pellicola trasparente o in un contenitore ermetico per 1-2 giorni. Si possono preparare il giorno prima, mantenere in frigorifero coperte con pellicola trasparente e cuocere il giorno dopo. E’ possibile congelarle, solo se si sono utilizzati tutti ingredienti freschi, meglio da crude: per cuocerle sarà sufficiente scongelarle in frigorifero circa 24 ore prima e poi cuocerle in forno.||(Intolleranze)|Uova, Latte','https://assets.epicurious.com/photos/54ad692d6529d92b2c0464f5/2:1/w_674,h_337,c_limit/51193620_lasagne-bolognese_1x1.jpg'),(3,'Risotto alla Milanese','Primo','Italiana','45 minuti','Facile','(Preparazione)||(Step 1)|Per realizzare il risotto allo zafferano o risotto alla milanese, per prima cosa mettete i pistilli in un bicchierino, versate sopra dell’acqua quanto basta a ricoprire i pistilli completamente, mescolate e lasciate in infusione per tutta la notte, in questo modo i pistilli rilasceranno tutto il loro colore. Quindi preparate il brodo vegetale, per la ricetta ne occorrerà un litro. Mondate e tritate finemente la cipolla in modo che si possa sciogliere in cottura e non essere percepita mentre si assaporerà il risotto.||(Step 2)|In un tegame ampio versate 50g di burro presi dalla dose totale necessaria, scioglietelo a fuoco dolce, quindi versate il trito di cipolla e lasciate stufare per 10-15 minuti aggiungendo del brodo per non far asciugare il soffritto: la cipolla dovrà risultare ben trasparente e morbida.||(Step 3)|Una volta stufata la cipolla, versate il riso e tostatelo per 3-4 minuti, così i chicchi si sigilleranno e terranno bene la cottura. Sfumate con il vino bianco e lasciate evaporare completamente. A questo punto procedete con la cottura per circa 18-20 minuti, aggiungendo il brodo un mestolo alla volta, al bisogno, man mano che verrà assorbito dal riso: i chicchi dovranno essere sempre coperti.||(Step 4)|Cinque minuti prima del termine di cottura, versate l’acqua con i pistilli di zafferano che avevate messo in infusione, mescolate per insaporire e tingere il risotto di un bel color oro. Terminata la cottura spegnete il fuoco, salate, mantecate con il formaggio grattugiato e i restanti 75 g di burro.||(Step 5)|Mescolate e coprite co il coperchio lasciate riposare un paio di minuti, a questo punto il risotto allo zafferano è pronto, servitelo ben caldo guarnendo il piatto ancora con qualche pistillo.||(Conservazione)|Conservate il risotto allo zafferano o risotto alla milanese, chiuso in un contenitore ermetico e posto in frigorifero, per due giorni al massimo. Si sconsiglia la congelazione.||(Intolleranze)|Lattosio','https://blog.giallozafferano.it/primipiattiricette/wp-content/uploads/2021/06/SH_risotto_alla_milanese_IMMAGINE1.jpg'),(4,'Spaghetti alla Carbonara','Primo','Italiana','30 minuti','Facile','(Preparazione)||(Step 1)|Per preparare gli spaghetti alla carbonara cominciate mettendo sul fuoco una pentola con l’acqua salata per cuocere la pasta. Nel frattempo eliminate la cotenna dal guanciale e tagliatelo prima a fette 1 e poi a striscioline spesse circa 1cm 2 3. La cotenna avanzata potrà essere riutilizzata per insaporire altre preparazioni.||(Step 2)|Versate i pezzetti di guanciale in una padella antiaderente e rosolate per circa 10 minuti a fiamma medio alta, fate attenzione a non bruciarlo altrimenti rilascerà un aroma troppo forte. Nel frattempo tuffate gli spaghetti nell’acqua bollente e cuoceteli al dente. Intanto versate i tuorli in una ciotola.||(Step 3)|Aggiungete il Pecorino e insaporite con il pepe nero. Amalgamate il tutto con una frusta a mano, sino ad ottenere una crema liscia.||(Step 4)|Intanto il guanciale sarà giunto a cottura; spegnete il fuoco e utilizzando un mestolo prelevatelo dalla padella, lasciando il fondo di cottura all\'interno della padella stessa. Trasferite il guanciale in una ciotolina e tenetelo da parte. Versate una mestolata d’acqua della pasta in padella, insieme al grasso del guanciale.||(Step 5)|Scolate la pasta al dente direttamente nel tegame con il fondo di cottura. Saltatela brevemente per insaporirla. Togliete dal fuoco e versate il composto di uova e Pecorino nel tegame. Mescolate velocemente per amalgamare.||(Step 6)|Per renderla ben cremosa, al bisogno, potete aggiungere poca acqua di cottura della pasta. Aggiungete il guanciale, mescolate un\'ultima volta e servite subito gli spaghetti alla carbonara aggiungendo ancora del pecorino in superficie e un pizzico di pepe nero.||(Conservazione)|Consigliamo di consumare al momento gli spaghetti alla carbonara.||(Intolleranze)|Lattosio','https://www.focus.it/images/2022/03/31/carbonara-orig.jpg'),(5,'Tiramisù','Dolce','Italiana','20 minuti','Facile','(Preparazione)||(Step 1)|Per preparare il tiramisù preparate il caffé con la moka per ottenerne 300 g, poi zuccherate a piacere, noi abbiamo messo un cucchiaino, e lasciatelo raffreddare in una ciotolina bassa e ampia. Separate le uova dividendo gli albumi dai tuorli, ricordando che per montare bene gli albumi non dovranno presentare alcuna traccia di tuorlo. Montate i tuorli con le fruste elettriche, versando solo metà dose di zucchero. Non appena il composto sarà diventato chiaro e spumoso, e con le fruste ancora in funzione, potrete aggiungere il mascarpone, poco alla volta.||(Step 2)|Incorporato tutto il formaggio avrete ottenuto una crema densa e compatta; tenetela da parte. Pulite molto bene le fruste e passate a montare gli albumi. Quando saranno schiumosi versate il restante zucchero un po’ alla volta.||(Step 3)|Dovrete montarli a neve ben ferma; otterrete questo risultato quando rovesciando la ciotola la massa non si muoverà. Prendete una cucchiaiata di albumi e versatela nella ciotola con la crema di mascarpone e mescolate energicamente con una spatola 8, così stempererete il composto. Dopodiché procedete ad aggiungere la restante parte di albumi, poco alla volta mescolando molto delicatamente dal basso verso l\'alto.||(Step 4)|La crema al mascarpone è ora pronta. Distribuitene una generosa cucchiaiata sul fondo di una pirofila di vetro, grande 30x19,5cm e distribuite per bene su tutta la base. Inzuppate per pochi istanti i savoiardi nel caffè freddo prima da un lato e poi dall’altro.||(Step 5)|Man mano distribuite i savoiardi imbevuti nella pirofila, cercando di sistemarli tutti in un verso, così da ottenere un primo strato di biscotti. Aggiungete altra crema al mascarpone e livellatela in modo da coprirli completamente.||(Step 6)|E continuate a distribuire i savoiardi imbevuti nel caffè, poi realizzate un altro strato di crema e livellate bene la superficie.||(Step 7)|Trasferite la crema rimasta in un sac-à-poche con beccuccio liscio di diametro 12 mm e realizzare dei ciuffetti per tutta la dimensione della teglia. Spolverizzatela con del cacao amaro in polvere e lasciate rassodare in frigorifero per un paio d’ore. Il vostro tiramisù è pronto per essere gustato!||(Conservazione)|Potete conservare il tiramisù un paio di giorni al massimo ben coperto in frigorifero. Si può congelare per circa 2 settimane in freezer.||(Intolleranze)|Lattosio','https://c4.wallpaperflare.com/wallpaper/139/930/568/food-dessert-cutlery-cake-wallpaper-preview.jpg'),(6,'Tagliatelle al Ragù','Primo','Italiana','75 minuti','Media','(Preparazione)||(Step 1)|Per preparare le tagliatelle al ragù bianco iniziate dal soffritto. In un tegame scaldate l’olio con uno spicchio d’aglio e lasciatelo imbiondire. Aggiungete il sedano e la carota tritati finemente.||(Step 2)|Unite anche la cipolla tritata e mescolate con una spatola. Lasciate cuocere qualche minuto a fuoco basso; nel frattempo sfogliate il rosmarino e tritatelo al coltello, poi aggiungetelo al soffritto. Lavate e asgiugate la salvia, sfogliatela e tritatela finemente; aggiungetela al resto del soffritto e infine insaporite con due foglie di alloro intere.||(Step 3)|Tagliate la pancetta a cubetti e rosolatela insieme alle verdure, mescolando con una spatola||(Step 4)|Occupatevi ora della salsiccia: incidete, nel senso della lunghezza, il budello esterno con un coltellino ed eliminatelo con le dita; sbriciolate la salsiccia.||(Step 5)|Unitela al sugo insieme alla carne trita e cuocete a fuoco vivace, mescolando con una spatola per spezzettarle ulteriormenete. Cuocete il tutto per qualche minuto.||(Step 6)|Rimuovete lo spicchio d’aglio e le foglie di alloro e sfumate con il vino bianco.||(Step 7)|Quando il vino sarà evaporato, proseguite la cottura unendo un mestolo di acqua calda, aggiustate di sale e pepe e cuocete a fuoco dolce per circa un’ora aggiungendo, se occorre altra acqua. Trascorso il tempo necessario, spegnete il fuoco. Quando manca una mezzoretta al termine della cottura, mettete sul fuoco un tegame con abbondante acqua da portare a bollore: quando bolle salate a piacere e lessate le tagliatelle, lasciandole al dente.||(Step 8)|Scolate la pasta al dente e trasferitela direttamente nel tegame del ragù oramai pronto. Mescolate bene la pasta e legate il condimento aggiungendo eventualmente un po\' di acqua di cottura della pasta tenuta da parte. Servite subito le vostre tagliatelle al ragù bianco ancora fumanti.||(Conservazione)|Le tagliatelle al ragù bianco si conservano ini frigorifero, chiuse in un contenitore ermetico, per massimo 1 giorno. Se sono stati utilizzati ingredienti freschi, è possibile la congelazione del ragù bianco.||(Intolleranze)|Lattosio','https://www.pastafattaincasa.com/wp-content/uploads/2020/06/tagliatelle-ragu.png'),(7,'Parmigiana di Melanzane','Contorno','Italiana','60 minuti','Media','(Preparazione)||(Step 1)|Per preparare la parmigiana di melanzane cominciate dal sugo. Pulite e tritate la cipolla, versatela in un tegame dove avrete scaldato l\'olio che copra il fondo. Lasciatela rosolare per un paio di minuti mescolando spesso per non farla bruciare, poi unite la passata di pomodoro.||(Step 2)|Regolate di sale e versate le foglie di basilico, sciacquate il recipiente con poca acqua e versatela in pentola quindi lasciate cuocere a fuoco dolce per 45-50 minuti. Nel frattempo tagliate a cubetti il fiordilatte tenendone da parte un pezzo che servirà alla fine.||(Step 3)|Mettete a scolare i cubetti in uno scolapasta messo in una ciotola, coprite con pellicola e mettete da parte: questo procedimento serve a far colare il siero in eccesso. A questo punto passate alle melanzane, pulitele e spuntatele.||(Step 4)|Affettate per il senso della lunghezza ottenendo delle fette spesse di 4-5 mm. Quando avrete finito friggete le melanzane in olio già caldo 170° immergendo pochi pezzi alla volta, non appena saranno leggermente dorate scolate su vassoio con carta assorbente.||(Step 5)|Quando sul vassoio sarà finito lo spazio mettete altra carta assorbente e mettete a scolare le altre melanzane fritte. In ultimo passate alla composizione, iniziate versando un po’ di sugo in una pirofila da 20x30 cm.||(Step 6)|Formate il primo strato disponendo le fette di melanzane, versate il sugo di pomodoro, spalmatelo e distribuite dei cubetti di fiordilatte.||(Step 7)|Spolverizzate con il Parmigiano grattugiato e delle foglie di basilico. Ricominciate aggiungendo il sugo di pomodoro e le melanzane, che andranno adagiate in senso contrario.||(Step 8)|E poi ancora i formaggi e le foglie di basilico. Andate avanti così fino ad arrivare all\'ultimo strato di melanzane e che andrete a condire, ancora una volta, con sugo e il fiordilatte che avete tenuto da parte, da spezzettare a mano.||(Step 9)|Finite con il Parmigiano grattugiato e infornate in forno statico, già caldo a 200°, per circa 30 minuti. Trascorso il tempo di cottura lasciate riposare per 15-20 minuti prima di servire la vostra parmigiana di melanzane.||(Conservazione)|Conservate la parmigiana di melanzane in frigorifero coperta con pellicola trasparente per 1-2 giorni. Si può congelare dopo la cottura, magari già divisa in porzioni, e scongelare in frigorifero all\'occorrenza prima di scaldarla.||(Intolleranze)|Lattosio','https://www.misya.info/wp-content/uploads/2017/08/parmigiana.jpg'),(8,'Pizza Marinara','Secondo','Italiana','90 minuti','Difficile','(Preparazione)||(Step 1)|Per preparare la pizza marinara iniziate versando la farina nella ciotola della planetaria. Aggiungete il lievito e 100 grammi d’acqua, quindi azionate la planetaria con il gancio montato a velocità medio bassa.||(Step 2)|Procedete aggiungendo l’acqua poco per volta, avendo cura di aspettare che la dose precedente sia stata ben assorbita dalla farina. Una volta versati circa i 3/4 dell\'acqua aggiungete il sale e continuate ad impastare. Aggiungete il resto dell’acqua sempre a filo e lasciate lavorare fino ad ottenere un composto liscio ed omogeneo.||(Step 3)|A questo punto aggiungete l’olio gradatamente (come avete fatto con l’acqua). Quando l’olio è stato completamente assorbito, estraete l’impasto dalla planetaria e modellatelo con le mani fino ad ottenere una palla. Inseritelo in una ciotola capiente leggermente unta.||(Step 4)|Coprite con pellicola o con un canovaccio pulito e mettete a lievitare nel forno con la luce accesa. Attendete che l’impasto abbia almeno raddoppiato il suo volume (1,5 h), meglio triplicato (2,5/3 h) e procedete alla stesura delle pizze. Una volta che l’impasto avrà lievitato, trasferitelo sulla spianatoia e dividetelo in 4 parti uguali.||(Step 5)|Fate con ognuno delle palline. Coprite con un canovaccio pulito e lasciate riposare per 30 minuti. Ungete leggermente con un filo d’olio 4 teglie da pizza di 30 cm di diametro. Posizionate al centro della teglia una pallina di impasto.||(Step 6)|E cominciate a schiacciare dal centro verso l’esterno, tirando i leggermente i lati se necessario. Se la pasta risulta troppo elastica e tende a tornare alla forma che aveva prima, mettete da parte la pizza che state stendendo e procedete a stenderne un’altra, facendo così riposare la precedente. Cercate di distendere la pasta su tutta la superficie della teglia. A parte, in una ciotola capiente, versate la salsa di pomodoro e conditela con sale, olio, pepe e origano..||(Step 7)|Versate un mestolo abbondante di salsa al pomodoro sulla base della pizza e spargetela con un movimento circolare, ricoprendo quasi tutta l’area, lasciando solo un bordo di circa 1,5 cm. Pelate l’aglio e tagliatelo a metà. Rimuovete l’anima e tagliate a fettine sottili.||(Step 8)|Condite ora con l’origano, un filo d’olio e l’aglio. Lasciate riposare la pizza farcita per una decina di minuti, poi infornate a 210°C per 15/20 minuti in forno statico (altrimenti a 190° in forno ventilato basteranno 15 minuti). Non appena estraete la pizza marinara dal forno, potete servirla ben calda!||(Conservazione)|La pizza marinara può essere portata a metà cottura e poi congelata. Per poterla utilizzare poi bisogna farla scongelare a temperatura ambiente e finire la cottura in forno prima di servirla!||(Intolleranze)|Lattosio','https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/Pizza_marinara.jpg/1024px-Pizza_marinara.jpg'),(9,'Gnocchi alla Sorrentina','Primo','Italiana','60 minuti','Media','(Preparazione)||(Step 1)|Per preparare gli gnocchi alla sorrentina iniziate dalle patate per realizzare gli gnocchi: lavatele sotto acqua corrente per eliminare l\'eventuale terriccio, poi versatele in un tegame capiente, unite l\'acqua e cuocete le patate per circa 30-40 minuti (in base alla grandezza il tempo può variare, fate la prova con i rebbi di una forchetta per capire il grado di cottura; se volete ridurre i tempi potete utilizzare una pentola a pressione). Dedicatevi al sugo: in un tegame versate un filo d\'olio, uno spicchio di aglio intero sbucciato e la passata di pomodoro, salate a piacere.||(Step 2)|Insaporite con le foglioline di basilico, poi coprite con il coperchio e lasciate cuocere a fiamma medio-bassa per circa 30 minuti. Quando le patate saranno pronte, scolatele bene. Quindi setacciate la farina sulla spianatoia e create la classica fontana. Schiacciate al centro della fontana di farina le patate ancora calde con l\'apposito schiacciapatate oppure pelatele e schiacciatele.||(Step 3)|Versate sulle patate l\'uovo e il sale, quindi iniziate ad impastare: questa operazione va fatta piuttosto velocemente.||(Step 4)|Basterà giusto compattare e dare una consistenza omogenea all\'impasto, che deve risultare morbido ma non appiccicoso (e nemmeno troppo tenace). Copritel\'impasto con un canovaccio asciutto e pulito. Mettete a bollire in un tegame capiente l\'acqua per cuocere gli gnocchi e salate a bollore; intanto prelevate man a mano una porzione di impasto tenendo coperta quella restante.||(Step 5)|Realizzate dei bigoli dello spessore di circa 2-3 cm. Spolverizzate con un po\' di semola e ricavate gli gnocchi da ogni filoncino aiutandovi con un tarocco. Per dare la classica rigatura trascinateli delicatamente su un rigagnocchi oppure sui rebbi di una forchetta.||(Step 6)|Man a mano che li preparerete, potrete disporre gli gnocchi su un vassoio foderato con un canovaccio pulito e leggermente cosparso di semola. Una volta pronti gli gnocchi, togliete l\'aglio dal sugo e versatelo quasi tutto in una ciotola molto capiente.||(Step 7)|Lessate gli gnocchi versandoli nel tegame almeno in 2-3 volte, dovranno cuocere per pochissimi istanti avendo cura che l\'acqua nel tegame frema e non bolla in maniera violenta per evitare di rovinarli: non appena verranno a galla scolate gli gnocchi con l\'aiuto di una schiumarola e tuffateli man a mano nella ciotola dove avete versato il sugo. Mescolate delicatamente con un cucchiaio. In una pirofila, versate il restante sugo sul fondo, quindi irrorate con un filo d\'olio.||(Step 8)|Versate un primo strato di gnocchi. Condite con uno strato di mozzarella tagliata a dadini, oppure sfilacciata, e una spolverata di Parmigiano.||(Step 9)|Proseguite poi con un altro strato di gnocchi, la mozzarella e il Parmigiano Reggiano DOP restanti. Infornate i vostri gnocchi alla sorrentina in forno statico preriscaldato a 250° in modalità grill per 5 minuti. Serviteli ben caldi e fumanti!||(Conservazione)|Potete conservare gli gnocchi alla sorrentina in frigo in un contenitore ermetico per 1 giorno al massimo coperti con pellicola trasparente. Gli gnocchi si possono congelare crudi: non occorrerà scongelarli prima di cuocerli. Si possono congelare cotti e conditi se si sono utilizzati ingredienti freschi, poi farli scongelare e riscaldarli in forno prima di servirli.||(Intolleranze)|Lattosio','https://www.ricettegourmet.com/wp-content/uploads/2016/05/Gnocchi-alla-sorrentina.jpg'),(10,'Ossobuchi alla Milanese','Secondo','Italiana','120 minuti','Difficile','(Preparazione)||(Step 1)|Per realizzare gli ossibuchi alla milanese, per prima cosa preparate il brodo di carne che vi servirà per cuocere gli ossibuchi, poi sbucciate le cipolle e tagliatele a falde. Scaldate metà dell’olio in una padella, aggiungete le cipolle e cuocete per circa 5 minuti a fuoco medio-alto, dopodiché sfumate con metà del vino bianco e cuocete per altri 10 minuti.||(Step 2)|Una volta brunite, rimuovete le cipolle dalla padella che vi servirà anche per cuocere gli ossibuchi e tenetele da parte. Ora prendete gli ossibuchi e, utilizzando un paio di forbici, praticate 3 incisioni sul tessuto connettivo di ognuno per evitare che si arriccino in cottura.||(Step 3)|Versate la farina in una pirofila e conditela con sale e pepe, poi mescolate con un cucchiaio. Infarinate gli ossibuchi da entrambi i lati e sbatteteli con delicatezza per eliminare la farina in eccesso.||(Step 4)|Versate l’olio rimanente nella padella in cui avevate cotto le cipolle, aggiungete il burro e fatelo sciogliere, poi adagiate gli ossibuchi all’interno e fateli rosolare a fiamma medio-alta senza toccarli. Dopo circa 4 minuti girateli delicatamente e noterete che all’esterno si sarà formata una deliziosa crosticina.||(Step 5)|Rosolate gli ossibuchi dall’altro lato per circa 2 minuti, dopodiché sfumate con il vino rimanente e fatelo evaporare. A questo punto aggiungete il brodo in modo che arrivi quasi a coprire la carne, poi unite le cipolle, abbassate la fiamma, coprite con un coperchio e cuocete a fuoco medio-basso per 35 minuti. Nel frattempo sbucciate gli spicchi di aglio ed eliminate l’anima, poi lessateli in acqua bollente per 2 minuti: in questo modo il sapore dell’aglio risulterà meno forte, tuttavia se preferite potete omettere questo passaggio.||(Step 6)|Trascorsi i 35 minuti di cottura, girate molto delicatamente gli ossibuchi, coprite ancora con il coperchio e continuate a cuocere per altri 25 minuti. Nel frattempo lavate il prezzemolo e tritatelo finemente insieme agli spicchi di aglio sbollentati.||(Step 7)|A cottura ultimata, spegnete il fuoco e aggiungete il trito di prezzemolo e aglio nella padella, poi aromatizzate con la scorza grattugiata di un limone non trattato: i vostri ossibuchi alla milanese sono pronti per essere serviti e gustati!||(Conservazione)|Gli ossibuchi alla milanese si possono conservare in frigorifero per un giorno, in un contenitore ermetico. Si sconsiglia la congelazione.||(Intolleranze)|Glutine','https://www.divinamilano.it/wp-content/uploads/2019/12/ossobuco-alla-milanese.jpg'),(11,'Sacher','Dolce','Austriaca','110 minuti','Difficile','(Preparazione)||(Step 1)|Per preparare la Sachertorte come prima cosa trasferite il cioccolato in piccoli pezzi in una bastardella e fondetelo a bagnomaria. Se preferite potete sciogliere il cioccolato in microonde azionandolo pochi secondi per volta e mescolando ad ogni interruzione in modo da non bruciare il cioccolato. Nel frattempo ponete nella ciotola di una planetaria il burro morbido, lo zucchero a velo e un pizzico di sale. Aggiungete anche i semi del baccello di vaniglia e iniziate a lavorare il composto con la frusta fino ad ottenere una consistenza cremosa.||(Step 2)|Versate poi i tuorli leggermente sbattuti in due volte e continuate a montare il burro; ci vorranno circa 8-10 minuti. L\'importante è che il composto di zucchero a velo, tuorli e burro sia ben montato affinchè in cottura l\'impasto si sviluppi bene. Ora, assicuratevi che il cioccolato che avete fuso abbia una temperatura compresa tra 45 e 55°; è preferibile utilizzare un termometro per misurarla: se dovesse essere troppo alta, infatti, rischierebbe di sciogliere il burro, viceversa rischierebbe di compattare troppo il composto. A questo punto aggiungete il cioccolato nel composto di burro e tuorli e continuate a mescolare fino ad ottenere un composto uniforme. Versate poi gli albumi nella ciotola di una planetaria e iniziate a montarli a velocità alta. Non appena saranno bianchi e spumosi (quando inizieranno a \"salire\") versate pian piano anche lo zucchero semolato, sempre poco alla volta; è importante aspettare che gli albumi siano leggermente montati prima di aggiungere lo zucchero, altrimenti l\'albume diventerà troppo pesante e farà molta più fatica a montare.||(Step 3)|Gli albumi non dovranno essere montati a neve fermissima, ma dovrete fermarvi qualche istante prima altrimenti quando andrete ad inserirli nell\'impasto continueranno a montarsi e la torta, una volta cotta, rischierebbe di afflosciarsi. A questo punto unite gli albumi in due volte nel composto di tuorli e cioccolato e mescolate con una spatola o con una frusta. Aggiungete poi anche la farina già setacciata emescolate dall\'alto verso il basso con una spatola, fino ad ottenere un composto liscio ed uniforme.||(Step 4)|Imburrate e infarinate uno stampo da 18 cm di diametro, poi versate il composto all\'interno, livellate la superficie e cuocete in forno statico preriscaldato a 170° per 35-40 minuti. Trascorso questo tempo verificate la cottura con uno stecchino, quindi sfornate il dolce; non preoccupatevi se la torta risulta crepata in superficie. Lasciate raffreddare la torta completamente, prima di sformarla capovolgendola su un piano. Quindi tagliate la torta in due dischi, utilizzando un coltello dalla lama lunga seghettata.||(Step 5)|Disponete circa metà dose di confettura di albicocche all\'interno e spargetela con una spatola su tutta la superficie. Ricoprite con il secondo disco. aggiungete altra confettura in superficie e utilizzando una spatola spargetela ovunque per creare un velo, anche sui bordi della torta; in questo modo l\'effetto finale risulterà più lucido. Trasferite la torta su una gratella e occupatevi di preparare la ganache.||(Step 6)|Ponete la panna in un pentolino e portatela a sfiorare il bollore; non appena inizierà a bollire spegnete il fuoco e unite il cioccolato. Mescolate con una frusta fino a che il cioccolato sarà completamente sciolto e ben amalgamato.||(Step 7)|Trasferite poi la ganache all\'interno di una ciotola e utilizzatela per glassare la torta, aiutandovi con una spatola e sbattendola delicatamente sul piano in modo da ricoprire sia la superficie che i bordi e lisciarla allo stesso tempo. Per risultare liscia e lucida la ganache deve avere una temperatura di circa 40°.||(Step 8)|A questo punto ponete a rassodare in frigorifero ( a +4°) per circa 20 minuti. Poi trasferite la torta sacher su un piatto da portata e servite ciascuna fetta in purezza o assieme a della panna semimontata senza zucchero.||(Conservazione)|La torta sacher si può conservare in frigorifero per 2-3 giorni al massimo. Se volete è possibile congere la torta farcita di confettura di albicocche, senza copertura di confettura e senza glassa.||(Intolleranze)|Glutine, Lattosio','https://www.davidezambelli.com/wp-content/uploads/2022/01/torta-sacher-2-1300x731.jpg'),(12,'Arancini di riso','Primo','Italiana','145 minuti','Media','(Preparazione)||(Step 1)|Per preparare gli arancini di riso siciliani, iniziate lessando il riso in 1,2 l di acqua bollente salata, in modo da far si che, a cottura avvenuta, l\'acqua sia stata completamente assorbita, questo permetterà all\'amido di rimanere tutto in pentola e otterrete un riso molto asciutto e compatto. Fate cuocere per circa 15 minuti, poi sciogliete lo zafferano in pochissima acqua calda e unitelo al riso ormai cotto. Unite anche il burro a pezzetti.||(Step 2)|Unite il formaggio grattugiato, mescolate bene per amalgamare il tutto, dopodiché  versate e livellate il riso su un vassoio ampio e basso e copritelo con la pellicola, per farlo rafferddare completamente, la pellicola eviterà che la superficie del riso si secchi. Lasciate riposare il riso per un paio di ore fuori dal frigorifero. Intanto dedicatevi al ripieno al ragù: mondate e affettate finemente la cipolla.||(Step 3)|Fate stufare la cipolla tritata in un tegame con 2 cucchiai d’olio e il burro, poi unite la carne macinata; fatela rosolare a fuoco vivace, quindi aggiungete il vino e lasciatelo sfumare.||(Step 4)|A questo punto aggiungete la passata di pomodoro, aggiustate di sale e di pepe a piacere e fate cuocere a fuoco lento coperto per almeno 20 minuti. A metà cottura, aggiungete i piselli, se necessario potete aggiungere pochissima acqua calda perchè il ragù dovrà risultare ben rappreso e non liquido.||(Step 5)|Mentre i piselli si cuociono tagliate a cubetti il caciocavallo, il prosciutto cotto e la mozzarella. Avrete così pronti tutti i ripieni.||(Step 6)|Una volta che il riso si sarà raffreddato completamente, ci vorranno almeno un paio di ore, potrete formare gli arancini, per aiutarvi nella formazione tenete vicino una ciotola colma di acqua così da potervi inumidirvi le mani. Prelevate un paio di cucchiai di riso per volta, circa 120 gr di riso, schiacciate il mucchietto al centro del mano formando una conca e versateci all\'interno un cucchiaino di ripieno al ragù, aggiungete qualche cubetto di caciocavallo.||(Step 7)|Quindi richiudete la base dell\'arancino con il riso e modellatelo dandogli una forma a punta: potete dare questa forma a tutti gli arancini farciti con il ragù. Mentre per il ripieno al prosciutto, farcite ciascun arancino, formato circa da 130 gr di riso con dadini di prosciutto e mozzarella. Il ripieno con questo tipo di ripieno viene tradizionalmente detto \"al burro\".||(Step 8)|Modellateli dandogli una forma rotonda. Ora che avete tutti gli arancini pronti, preparate la pastella: in una ciotola versate la farina setacciata, un pizzico di sale e l\'acqu a filo. Mescolate accuratamente con una frusta per evitare che si formino grumi.||(Step 9)|Quindi tuffate gli arancini, uno ad uno, nella pastella avendo cura di ricoprirli interamente e rotolateli nel pangrattato.||(Step 10)|In un pentolino scaldate l\'olio e portatelo alla temperatura di 170°, a quel punto friggete un arancino alla volta o massimo due per non abbassare la temperatura dell\'olio: quando saranno ben dorati potrete scolarli ponendoli su un vassoio foderato con carta assorbente. Mi raccomando: gustate gli arancini di riso siciliani ben caldi!||(Conservazione)|Potete conservare gli arancini di riso siciliani cotti in frigorifero per un paio di giorni. In alternativa potete preparare il riso il giorno prima, coprirlo con la pellicola trasparente e lasciarlo riposare per una notte in frigorifero per tutta la notte. Si possono congelare crudi se avete utilizzato tutti ingredienti freschi non decongelati e friggere all\'occorrenza direttamente da congelati. In questo caso consigliamo di farli leggermente più piccoli in modo che si cuociano in maniera maggiormente uniforme.||(Intolleranze)|Glutine, Lattosio','https://cdn.cook.stbm.it/thumbnails/ricette/144/144684/hd1600x900.jpg');
/*!40000 ALTER TABLE `ricette` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salvano`
--

DROP TABLE IF EXISTS `salvano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salvano` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_utente_consumer` int NOT NULL,
  `id_ricetta` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_utente_ricetta` (`id_utente_consumer`,`id_ricetta`),
  KEY `id_utente_consumer_idx` (`id_utente_consumer`),
  KEY `id_ricetta_idx` (`id_ricetta`),
  CONSTRAINT `ricetta` FOREIGN KEY (`id_ricetta`) REFERENCES `ricette` (`id`),
  CONSTRAINT `utente` FOREIGN KEY (`id_utente_consumer`) REFERENCES `utenti_consumer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salvano`
--

LOCK TABLES `salvano` WRITE;
/*!40000 ALTER TABLE `salvano` DISABLE KEYS */;
INSERT INTO `salvano` VALUES (6,1,2),(1,2,5),(5,3,8),(8,4,9),(18,5,2),(19,5,3),(16,5,5),(9,6,10),(2,7,3),(7,8,7),(4,9,6),(3,10,1),(20,10,2);
/*!40000 ALTER TABLE `salvano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenti_azienda`
--

DROP TABLE IF EXISTS `utenti_azienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utenti_azienda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `immagine_brand` varchar(100) DEFAULT NULL,
  `sede_legale` varchar(45) NOT NULL,
  `p_iva` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti_azienda`
--

LOCK TABLES `utenti_azienda` WRITE;
/*!40000 ALTER TABLE `utenti_azienda` DISABLE KEYS */;
INSERT INTO `utenti_azienda` VALUES (1,'azienda1@example.com','password1','','','',''),(2,'azienda2@example.com','password2','','','',''),(3,'azienda3@example.com','password3','','','',''),(4,'azienda4@example.com','password4','','','',''),(5,'azienda5@example.com','password5','','','',''),(7,'michael@example.com','password6','','','',''),(8,'sara@example.com','password7','','','',''),(9,'derek@example.com','password8','','','',''),(10,'kelly@example.com','password9','','','',''),(11,'grace@example.com','password10','','','','');
/*!40000 ALTER TABLE `utenti_azienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenti_consumer`
--

DROP TABLE IF EXISTS `utenti_consumer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utenti_consumer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `immagine_profilo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti_consumer`
--

LOCK TABLES `utenti_consumer` WRITE;
/*!40000 ALTER TABLE `utenti_consumer` DISABLE KEYS */;
INSERT INTO `utenti_consumer` VALUES (1,'mario01','mario01@email.com','password123',''),(2,'paolo92','paolo92@email.com','paolo2021',''),(3,'luca89','luca89@email.com','pizza123',''),(4,'elenab','elena.b@gmail.com','qwerty456',''),(5,'lisa_rose','lisa.rose@yahoo.com','password123',''),(6,'michele_s','michele.s@outlook.com','pencil456',''),(7,'francesco_00','francesco.00@gmail.com','worker123',''),(8,'giorgia_f','giorgia.f@hotmail.com','secret369',''),(9,'davide_b','davide.b@gmail.com','garden123',''),(10,'valeria_g','valeria.g@outlook.com','light17','');
/*!40000 ALTER TABLE `utenti_consumer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendono`
--

DROP TABLE IF EXISTS `vendono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendono` (
  `id` int NOT NULL AUTO_INCREMENT,
  `prezzo` float NOT NULL,
  `id_ingrediente` int NOT NULL,
  `id_negozio` int NOT NULL,
  `valore` float(4,2) NOT NULL,
  `unità_misura` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_ingrediente_idx` (`id_ingrediente`),
  KEY `id_punto_vendita_idx` (`id_negozio`),
  CONSTRAINT `ingrediente` FOREIGN KEY (`id_ingrediente`) REFERENCES `ingredienti` (`id`),
  CONSTRAINT `negozio` FOREIGN KEY (`id_negozio`) REFERENCES `negozi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendono`
--

LOCK TABLES `vendono` WRITE;
/*!40000 ALTER TABLE `vendono` DISABLE KEYS */;
INSERT INTO `vendono` VALUES (1,1.1,1,1,0.00,''),(2,3.8,2,2,0.00,''),(3,1.8,3,3,0.00,''),(4,4.2,2,4,0.00,''),(5,3.5,1,5,0.00,''),(6,0.8,3,6,0.00,''),(7,0.6,2,7,0.00,''),(8,9,1,8,0.00,''),(9,10.5,3,9,0.00,''),(10,2.5,1,10,0.00,''),(23,2.5,34,1,0.00,''),(24,2.5,37,2,0.00,''),(25,2.5,38,2,0.00,''),(26,2.5,39,2,0.00,'');
/*!40000 ALTER TABLE `vendono` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-17 13:53:33
