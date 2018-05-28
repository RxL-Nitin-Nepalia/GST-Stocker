/*
SQLyog Ultimate v11.5 (64 bit)
MySQL - 10.1.24-MariaDB : Database - gst
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gst` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `gst`;

/*Table structure for table `inventory` */

DROP TABLE IF EXISTS `inventory`;

CREATE TABLE `inventory` (
  `STOCK` varchar(45) NOT NULL,
  `UNITS` varchar(45) NOT NULL,
  `HSN` int(11) NOT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  `RATE` int(11) DEFAULT NULL,
  `IGST` int(11) DEFAULT '0',
  `CESS` int(11) DEFAULT '0',
  PRIMARY KEY (`STOCK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `inventory` */

insert  into `inventory`(`STOCK`,`UNITS`,`HSN`,`QUANTITY`,`RATE`,`IGST`,`CESS`) values ('Bindi','dz',3304,11007,22,0,0),('BOPP','kg',3506,1977,123,18,0),('Compac Powder','Nos',7809,0,120,28,0),('Fevicol','kg',3920,195,123,18,0),('GlassBeads','gross',7018,125,12,5,0),('HairColour','nos',3305,128,28,28,0),('Lip Balm','Nos',7809,190,123,28,0),('Packaging','kg',3923,4089,321,18,0),('Sindur','nos',3304,0,0,0,0);

/*Table structure for table `ledger` */

DROP TABLE IF EXISTS `ledger`;

CREATE TABLE `ledger` (
  `NAME` varchar(45) NOT NULL,
  `ADDRESS` varchar(200) DEFAULT NULL,
  `STATE` varchar(45) DEFAULT NULL,
  `AC` double DEFAULT NULL,
  `IFSC` varchar(45) DEFAULT NULL,
  `BRANCH` varchar(45) DEFAULT NULL,
  `PAN` varchar(45) DEFAULT NULL,
  `GSTIN` varchar(45) DEFAULT NULL,
  `AMOUNT` int(11) DEFAULT '0',
  `GROUPS` varchar(45) NOT NULL,
  PRIMARY KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ledger` */

insert  into `ledger`(`NAME`,`ADDRESS`,`STATE`,`AC`,`IFSC`,`BRANCH`,`PAN`,`GSTIN`,`AMOUNT`,`GROUPS`) values ('Aditya Polymers Pvt Ltd','B2/117 Block A West Shastri Nagar','Delhi',0,'','','ALXPJ1850M','07ALXPJ1840M1ZJ',443010,'Supplier'),('Aero Tex Pvt Ltd','T-123 Ramasec Quarters Trivenderum','Kerela',0,'','','BTQPD7456P','32BTQPD7456P1ZO',6000,'Buyer'),('Alishan Creation Corporate','2901/12 Hanuman Market Sadar Bazaar','Delhi',0,'','','AGKPA5920B','07AGKPA5920B1ZY',115206,'Buyer'),('Allied Hosiery','N-78 Radha Enclave','Assam',0,'','','ASDRF8976T','20ASDRF8976T1XC',0,'Buyer'),('Balaji Traders','122-123 Part A Palwal','Haryana',0,'','','AAEPC0742M','06AAEPC0742M1ZZ',143195,'Buyer'),('bank','',NULL,0,'','','','',12334,'Cash-in-hand'),('Bank Charges','','',0,'','','','',235,'Indirect Expenses'),('Bank Interest','','',0,'','','','',10056,'Incomes'),('Business Promotion','','',0,'','','','',1686,'Indirect Expenses'),('Cartage Outwards','','',0,'','','','',2655,'Indirect Expenses'),('Cash','','',0,'','','','',124860,'Cash-in-hand'),('Conveyance','','',0,'','','','',3443,'Indirect Expenses'),('Diamond Impex','B-90 Rana Nagar','Maharashtra',0,'','','ASDTG7896A','23ASDTG7896A1AA',65000,'Buyer'),('Duties and Taxes','','',0,'','','','',100234,'Current Liability'),('Electricity Exp','','',0,'','','','',62000,'Indirect Expenses'),('Fixed Deposit','','',0,'','','','',42510,'Incomes'),('G L Marketing Ltd','178/122 Block A Rohini West','Delhi',0,'','','AACCG4080F','07aaccg4080f1zq',168598,'Supplier'),('Guddu Products','12/123 Block B Sadar Bazaar','Delhi',0,'','','AAJPF0750B','07AAJPF0750B1ZC',91255,'Buyer'),('Harsh Industries','C-122 First Floor Mahavir Nagar','Maharashtra',0,'','','AAJPM7382A','27AAJPM7382A1ZN',107805,'Supplier'),('Indian Cottage Industries','43-C Ashok Nagar','Delhi',0,'','','AAFPT3461R','07AAFPT3461R1ZZ',8285,'Buyer'),('kotak Mahindra Bank','','',3165314,'KKBK0000204','SadarBazaar','','',2208951,'Bank Account'),('Lady Archana Bindi Ltd','897/11 Ground Floor Sadar Bazaar','Delhi',0,'','','AZJPT0580K','07AZJPT0580K1ZZ',32624,'Buyer'),('Loan Balbir','','',0,'','','','',472940,'Current Liability'),('Loan Bimlesh','','',0,'','','','',225262,'Current Liability'),('Loan Krishna','','',0,'','','','',250000,'Current Liability'),('Loan Kusum','','',0,'','','','',118371,'Current Liability'),('Loan Meena','','',0,'','','','',14196,'Current Liability'),('Loan Naveen','','',0,'','','','',139036,'Current Liability'),('Loan Puraan','','',0,'','','','',425000,'Current Liability'),('Loan Sonu','','',0,'','','','',200000,'Current Liability'),('Loan Vijay','','',0,'','','','',215000,'Current Liability'),('Maa Paarvati Traders','26/4 Armenian Street','West Bengal',0,'','','AGBPA6796Q','19AGBPA6796Q1ZN',25750,'Buyer'),('Machines','','',0,'','','','',64629,'Current Assets'),('Madaan Knitting','H-12 Raghu Nagar','Bihar',0,'','','AYRTU9658J','25AYRTU9658J1PL',0,'Buyer'),('Mahavir Sales Co','34-A Geeta Colony','Delhi',0,'','','ASDCG6789J','07ASDCG6789J1AA',19964,'Buyer'),('Malka Enterprises','b-23 jagat puri','Delhi',0,'','','ARDFG7890I','07ARDFG7890I1AA',57358,'Buyer'),('Motor Cycle','','',0,'','','','',2307,'Current Assets'),('Motor Cycle Running and Maintainence','','',0,'','','','',2089,'Indirect Expenses'),('Mutual Funds','','',0,'','','','',0,'Incomes'),('Nancy Fashion Traders','J-122 Block A Jagatpura Jaipur','Rajashtan',0,'','','AFBPA4762M','08AFBPA4762M1ZE',12038,'Buyer'),('New Dastana Hosiery','A-13 shahdara','Delhi',0,'','','HNJML8970I','00HNJML8970I1AA',8500,'Buyer'),('Nikhat Traders Pvt Ltda','1297/12 First Floor Teliwara Sadar Bazaar','Delhi',0,'','','ALGPA2939P','07ALGPA2939P1ZT',67000,'Buyer'),('Office Equipment','','',0,'','','','',5761,'Current Assets'),('Paras Trading Coporation','A-12 Azadpur Khari Baoli ','Delhi',0,'','','AXBPG8460A','07AXBPG8460A1ZV',116813,'Supplier'),('Postage and Courrier','','',0,'','','','',612,'Indirect Expenses'),('Praveen','','',0,'','','','',269088,'Capital'),('Preet Hosiery Pvt Ltd','P-122 Dilbagh Nagar Jalandhar','Punjab',0,'','','CKEPK0714M','03CKEPK0714M1ZE',2000,'Buyer'),('Premises ','','',0,'','','','',275000,'Current Assets'),('Printing and Stationary','','',0,'','','','',100000,'Indirect Expenses'),('Radhika Products','128 B JAGAT PURI ','Delhi',0,'','','ANIPM1652M','07ANIPM1652M1ZP',80500,'Buyer'),('Rajeev','','',0,'','','','',107819,'Capital'),('Returns From Investment','','',0,'','','','',120676,'Incomes'),('RK Industries Ltd','A-122 Anant Road Mahipur','Andhra Pradesh',0,'','','ACYPG0042N','37ACYPG0042N1ZB',90097,'Buyer'),('Sajani Plastic','Naminath Industrial Estate \nBuilding no 1,gali101','Maharashtra',0,'','','ADCGB7890C','26ADCGB7890C1AA',100000,'Supplier'),('Sajjan Singh and Brothers','S-24 Vikas Nagar ','Chattisgarh',0,'','','AAGHD7895F','03AAGHD7895F1ZP',11650,'Buyer'),('Salary','','',0,'','','','',85194,'Indirect Expenses'),('Sales Tax','','',0,'','','','',402,'Indirect Expenses'),('Sarvottam Industries Ltd','D-122 First Floor Akbar Road Udaipur','Rajashtan',0,'','','AAPFS5539A','08AAPFS5539A1ZC',98097,'Buyer'),('Shagun Traders','N-98 Janakpuri','Delhi',0,'','','HYUJN8976T','07HYUJN8976T1AA',17322,'Buyer'),('SHIV','Q-123 Surya Nagar','Telangana',0,'','','FDGTE7896U','14FDGTE7896U7ZX',0,'Buyer'),('Short and Excess Recovery','','',0,'','','','',194,'Indirect Expenses'),('Shree Adinaath Traders','S-122 Sita Vihar Jaipur','Rajashtan',0,'','','BIAPJ2153G','08BIAPJ2153G1ZM',83331,'Buyer'),('Shri Hinglaj Properties','S-34 Ghaziabad ','Uttar Pradesh',0,'','','HGHGH1245F','08HGHGH1245F1AA',0,'Buyer'),('Shyam Housy Corporation','122-123 Block B Station Road','Maharashtra',0,'','','ADOPK0188N','27ADOPK0188N1ZX',98097,'Buyer'),('Sindhu Hosiery Pvt Ltd','A24 Block C Arun Nagar','West Bengal',0,'','','AARPH4696N','19AARPH4696N2ZM',98097,'Buyer'),('SK Enterprises','105 2nd Floor Dariba Kalan','Delhi',0,'','','AMDPB1123C','07AMDPB1123C1ZZ',300000,'Supplier'),('SP Trading Company','123/122 Arjun Vihar ','Delhi',0,'','','AAFPJ6543G','07AAFPJ6543G1ZR',401940,'Supplier'),('Staff Welfare','','',0,'','','','',9046,'Indirect Expenses'),('Suri Rajendra Plastic','B-308 Padmavati Nagar Bhayandar West','Maharashtra',0,'','','ACTPJ3891M','27ACTPJ3891M1ZP',90624,'Supplier'),('Telephone Exp','','',0,'','','','',10824,'Indirect Expenses'),('Vikas Crystal Pvt Ltd','S-23 Mayur Nagar Malad West','Maharashtra',0,'','','AAEPP6230B','27AAEPP6230B1ZZ',122153,'Supplier'),('Vishnu Store','C-4 E Sadar Bazaar','Delhi',0,'','','ASRDF4567T','07ASRDF4567T1AA',0,'Buyer'),('Zeenaat Traders Pvt Ltd','122/123 Ghaziabad ','Delhi',0,'','','BBXPS1143K','07BBXPS1143K1ZZ',98097,'Buyer');

/*Table structure for table `payment` */

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `DATE_` date NOT NULL,
  `BY_` varchar(45) NOT NULL,
  `TO_` varchar(45) NOT NULL,
  `AMOUNT` float NOT NULL,
  `NARRATION` varchar(4000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `payment` */

insert  into `payment`(`DATE_`,`BY_`,`TO_`,`AMOUNT`,`NARRATION`) values ('2017-07-01','Cash','Praveen',30000,'Narration ::'),('2017-07-01','Cash','Rajeev',15000,'Narration ::'),('2017-07-06','Cash','Staff Welfare',1094,'Narration ::'),('2017-07-07','Cash','Salary',15000,'Narration ::'),('2017-07-07','Cash','Salary',10000,'Narration ::'),('2017-07-11','Cash','kotak Mahindra Bank',25000,'Narration ::'),('2017-08-01','Cash','Praveen',15000,'Narration ::'),('2017-08-01','Cash','Rajeev',15000,'Narration ::'),('2017-08-07','Cash','Salary',15000,'Narration ::'),('2017-08-07','Cash','Salary',10000,'Narration ::'),('2017-08-07','Cash','Staff Welfare',1122,'Narration ::'),('2017-08-10','Cash','kotak Mahindra Bank',20000,'Narration ::'),('2017-08-19','Cash','kotak Mahindra Bank',100000,'Narration ::'),('2017-07-14','kotak Mahindra Bank','G L Marketing Ltd',200000,'Narration ::'),('2017-07-19','kotak Mahindra Bank','Vikas Crystal Pvt Ltd',26250,'Narration ::'),('2017-07-19','kotak Mahindra Bank','Electricity Exp',8220,'Narration ::'),('2017-07-24','kotak Mahindra Bank','Shagun Traders',24882,'Narration ::'),('2017-07-28','kotak Mahindra Bank','Vikas Crystal Pvt Ltd',13801,'Narration ::'),('2017-07-29','kotak Mahindra Bank','Aditya Polymers Pvt Ltd',144400,'Narration ::'),('2017-07-29','kotak Mahindra Bank','SP Trading Company',31380,'Narration ::'),('2017-07-30','kotak Mahindra Bank','Telephone Exp',731,'Narration ::'),('2017-07-31','kotak Mahindra Bank','Telephone Exp',1000,'Narration ::'),('2017-07-31','kotak Mahindra Bank','Bank Charges',30,'Narration ::'),('2017-08-02','kotak Mahindra Bank','G L Marketing Ltd',150000,'Narration ::'),('2017-08-04','kotak Mahindra Bank','SK Enterprises',150000,'Narration ::'),('2017-08-08','kotak Mahindra Bank','G L Marketing Ltd',75672,'Narration ::'),('2017-08-09','kotak Mahindra Bank','SK Enterprises',150000,'Narration ::'),('2017-08-11','kotak Mahindra Bank','Paras Trading Coporation',39187,'Narration ::'),('2017-08-20','kotak Mahindra Bank','Bank Charges',17,'Narration ::'),('2017-08-23','kotak Mahindra Bank','Electricity Exp',9361,'Narration ::'),('2017-07-14','kotak Mahindra Bank','G L Marketing Ltd',200000,'Narration ::'),('2017-07-19','kotak Mahindra Bank','Vikas Crystal Pvt Ltd',26250,'Narration ::'),('2017-07-19','kotak Mahindra Bank','Electricity Exp',8220,'Narration ::'),('2017-07-21','kotak Mahindra Bank','Paras Trading Coporation',24882,'Narration ::'),('2017-07-28','kotak Mahindra Bank','Vikas Crystal Pvt Ltd',13801,'Narration ::'),('2017-07-29','kotak Mahindra Bank','Aditya Polymers Pvt Ltd',144400,'Narration ::'),('2017-07-29','kotak Mahindra Bank','SP Trading Company',31380,'Narration ::'),('2017-07-30','kotak Mahindra Bank','Telephone Exp',1731,'Narration ::'),('2017-07-31','kotak Mahindra Bank','Bank Charges',29,'Narration ::'),('2017-09-01','Cash','Cartage Outwards',208,'Narration ::'),('2017-09-01','Cash','Praveen',10000,'Narration ::'),('2017-09-01','Cash','Rajeev',10000,'Narration ::'),('2017-09-05','Cash','Duties and Taxes',5000,'Narration ::'),('2017-09-06','Cash','Motor Cycle Running and Maintainence',1974,'Narration ::'),('2017-09-06','Cash','Salary',25000,'Narration ::'),('2017-09-06','Cash','Business Promotion',973,'Narration ::'),('2017-09-09','Cash','Staff Welfare',1284,'Narration ::'),('2017-09-09','Cash','Conveyance',1893,'Narration ::'),('2017-09-04','kotak Mahindra Bank','G L Marketing Ltd',118526,'Narration ::'),('2017-09-06','kotak Mahindra Bank','Suri Rajendra Plastic',50000,'Narration ::'),('2017-09-12','kotak Mahindra Bank','G L Marketing Ltd',123902,'Narration ::'),('2017-09-11','kotak Mahindra Bank','Bank Charges',18,'Narration ::'),('2017-09-13','kotak Mahindra Bank','Harsh Industries',100000,'Narration ::'),('2017-09-14','kotak Mahindra Bank','Duties and Taxes',25000,'Narration ::'),('2017-09-20','kotak Mahindra Bank','Electricity Exp',8780,'Narration ::'),('2017-09-20','kotak Mahindra Bank','Telephone Exp',2200,'Narration ::'),('2017-09-21','kotak Mahindra Bank','Suri Rajendra Plastic',40624,'Narration ::'),('2017-09-21','kotak Mahindra Bank','G L Marketing Ltd',134408,'Narration ::'),('2017-09-22','kotak Mahindra Bank','Sajani Plastic',100000,'Narration ::');

/*Table structure for table `profit` */

DROP TABLE IF EXISTS `profit`;

CREATE TABLE `profit` (
  `DATE_OF_SALE` date DEFAULT NULL,
  `ITEM` varchar(20) DEFAULT NULL,
  `SALE_PRICE` float DEFAULT NULL,
  `PURCHASE_PRICE` float DEFAULT NULL,
  `PROFIT` float DEFAULT NULL,
  `PROFIT%` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `profit` */

insert  into `profit`(`DATE_OF_SALE`,`ITEM`,`SALE_PRICE`,`PURCHASE_PRICE`,`PROFIT`,`PROFIT%`) values ('2017-07-04','BOPP',4602,2975,1627,54.6891),('2017-07-08','BOPP',10738,6941.67,3796.33,54.6891),('2017-07-11','Fevicol',29205,23237.5,5967.5,25.6805),('2017-07-12','BOPP',10556,7040.83,3515.17,49.9254),('2017-07-12','Fevicol',5525,5492.5,32.5,0.591716),('2017-07-12','BOPP',11000,9916.67,1083.33,10.9244),('2017-07-14','BOPP',7965,4462.5,3502.5,78.4874),('2017-07-14','BOPP',11139,7933.33,3205.67,40.4076),('2017-07-18','BOPP',18101,12891.7,5209.33,40.4085),('2017-07-18','BOPP',40797,29055.8,11741.2,40.409),('2017-07-20','BOPP',8354,5950,2404,40.4034),('2017-07-20','BOPP',7936,5652.5,2283.5,40.3981),('2017-07-20','GlassBeads',23356,163492,-140136,-85.7143),('2017-07-20','GlassBeads',2334,16338,-14004,-85.7143),('2017-07-21','BOPP',38940,29750,9190,30.8908),('2017-07-21','GlassBeads',4000,28000,-24000,-85.7143),('2017-07-24','BOPP',16987,12098.3,4888.67,40.4078),('2017-07-25','Sindur',40110,34380,5730,16.6667),('2017-07-25','BOPP',21000,19833.3,1166.67,5.88236),('2017-07-26','BOPP',29205,22312.5,6892.5,30.8908),('2017-07-28','BOPP',10999,7834.17,3164.83,40.3978),('2017-07-28','BOPP',16987,12098.3,4888.67,40.4078),('2017-07-28','BOPP',25960,19833.3,6126.67,30.8908),('2017-07-30','GlassBeads',20000,700,19300,2757.14),('2017-07-30','GlassBeads',25000,700,24300,3471.43),('2017-07-30','BOPP',8910,8032.5,877.5,10.9244),('2017-07-30','GlassBeads',37800,1260,36540,2900),('2017-07-30','BOPP',11880,10710,1170,10.9244),('2017-08-02','BOPP',11139,7933.33,3205.67,40.4076),('2017-08-02','BOPP',38940,29750,9190,30.8908),('2017-08-09','BOPP',48675,37187.5,11487.5,30.8908),('2017-08-09','Packaging',22000,22300,-300,-1.34529),('2017-08-10','GlassBeads',3000,21000,-18000,-85.7143),('2017-08-12','Fevicol',8500,8450,50,0.591716),('2017-08-14','BOPP',6944,6148.33,795.667,12.9412),('2017-08-14','BOPP',25960,19833.3,6126.67,30.8908),('2017-08-14','BOPP',16830,15172.5,1657.5,10.9244),('2017-08-18','BOPP',22844,17453.3,5390.67,30.8862),('2017-08-18','GlassBeads',50400,39200,11200,28.5714),('2017-08-19','BOPP',32400,19833.3,12566.7,63.3614),('2017-08-21','BOPP',17405,12395.8,5009.17,40.4101),('2017-08-22','BOPP',10721,7635.83,3085.17,40.4038),('2017-08-22','BOPP',30015,25882.5,4132.5,15.9664),('2017-08-22','BOPP',16200,9916.67,6283.33,63.3614),('2017-08-23','BOPP',32450,24791.7,7658.33,30.8908),('2017-08-24','BOPP',38940,29750,9190,30.8908),('2017-08-25','Bindi',25500,5033.33,20466.7,406.622),('2017-08-26','Packaging',12980,11150,1830,16.4126),('2017-08-26','Packaging',21185,2118.5,19066.5,900),('2017-08-28','GlassBeads',4777,31850,-27073,-85.0016),('2017-08-29','GlassBeads',714,4760,-4046,-85),('2017-08-30','BOPP',8549,6247.5,2301.5,36.8387),('2017-08-31','BOPP',10720,7834.17,2885.83,36.8365),('2017-09-01','Packaging',8956,7359,1597,21.7013),('2017-09-04','BOPP',7870,5751.67,2118.33,36.8299),('2017-09-04','Bindi',8000,8388.89,-388.89,-4.63577),('2017-09-05','GlassBeads',1182,7882,-6700,-85.0038),('2017-09-05','BOPP',9886,7040.83,2845.17,40.4095),('2017-09-08','Bindi',9000,8388.89,611.11,7.28476),('2017-09-28','BOPP',10999,7834.17,3164.83,40.3978),('2017-10-03','BOPP',18101,12891.7,5209.33,40.4085),('2017-10-04','BOPP',10582,7536.67,3045.33,40.4069),('2017-10-10','BOPP',27275,19932.5,7342.5,36.8368),('2017-10-12','BOPP',1357,991.667,365.333,36.8403),('2017-10-24','BOPP',6962,4958.33,2003.67,40.4101),('2017-11-08','Packaging',364,2564.5,-2200.5,-85.8062),('2017-07-26','Fevicol',295000,84500,210500,249.112),('2017-07-19','BOPP',278480,198333,80146.7,40.4101),('2017-08-15','Fevicol',295000,84500,210500,249.112),('2017-08-11','BOPP',280840,198333,82506.7,41.6),('2017-11-17','BOPP',364,2280.83,-1916.83,-84.0409);

/*Table structure for table `purchase` */

DROP TABLE IF EXISTS `purchase`;

CREATE TABLE `purchase` (
  `DATE_` date NOT NULL,
  `INVOICE` varchar(10) NOT NULL,
  `SELLER` varchar(45) NOT NULL,
  `CESS` float DEFAULT NULL,
  `CGST` float DEFAULT NULL,
  `SGST` float DEFAULT NULL,
  `IGST` float DEFAULT NULL,
  `NARRATION` varchar(4000) DEFAULT NULL,
  `ROUNDOFF` float DEFAULT NULL,
  `QUANTITY` float NOT NULL,
  `RATE` float NOT NULL,
  `DISCOUNT` float DEFAULT NULL,
  `TOTAL` float NOT NULL,
  `ITEM` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`INVOICE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `purchase` */

insert  into `purchase`(`DATE_`,`INVOICE`,`SELLER`,`CESS`,`CGST`,`SGST`,`IGST`,`NARRATION`,`ROUNDOFF`,`QUANTITY`,`RATE`,`DISCOUNT`,`TOTAL`,`ITEM`) values ('2017-07-07','001','Harsh Industries',0,0,0,0,'Narration ::',0,2540,17,0,43180,'Bindi'),('2017-07-06','003','Vikas Crystal Pvt Ltd',0,0,0,1300,'Narration ::',0,2000,13,0,29380,'GlassBeads'),('2017-07-26','008','Aditya Polymers Pvt Ltd',0,10975.7,10975.7,0,'Narration ::',0,1184,103,0,121952,'Packaging'),('2017-07-24','025','Harsh Industries',0,0,0,0,'Narration ::',0,2455,17,0,41735,'Bindi'),('2017-07-28','031','Harsh Industries',0,0,0,0,'Narration ::',0,480,17,0,8160,'Bindi'),('2017-07-28','035','Harsh Industries',0,0,0,0,'Narration ::',0,1281,17,0,21777,'Bindi'),('2017-07-31','042','Harsh Industries',0,0,0,0,'Narration ::',0,400,15,0,6000,'Bindi'),('2017-07-07','078','Paras Trading Coporation',0,1905.75,1905.75,0,'Narration ::',0,275,77,0,21175,'Fevicol'),('2017-08-17','101','Suri Rajendra Plastic',0,0,0,13824,'Narration ::',0,640,120,0,90624,'Packaging'),('2017-07-13','15','Harsh Industries',0,0,0,0,'Narration ::',0,420,17,0,7140,'Bindi'),('2017-07-11','161','G L Marketing Ltd',0,11187.8,11187.8,0,'Narration ::',0,1166,101,0,117766,'BOPP'),('2017-07-18','17','Vikas Crystal Pvt Ltd',0,0,0,682.8,'Narration ::',0.279297,1138,12,0,15431,'GlassBeads'),('2017-07-20','18','SP Trading Company',0,0,0,0,'Narration ::',0,192,102,0,19584,'Sindur'),('2017-07-21','20','SP Trading Company',0,0,0,0,'Narration ::',0,190,78,0,14820,'Sindur'),('2017-07-24','272','G L Marketing Ltd',0,9975,9975,0,'Narration ::',0,1050,100,0,105000,'BOPP'),('2017-08-05','3','Paras Trading Coporation',0,2980.8,2980.8,0,'Narration ::',0,360,92,0,33120,'Fevicol'),('2017-08-02','403','G L Marketing Ltd',0,10256.3,10256.3,0,'Narration ::',0,1113,97,0,107961,'BOPP'),('2017-08-02','45','Harsh Industries',0,0,0,0,'Narration ::',0,2199,17,0,37383,'Bindi'),('2017-08-09','484','G L Marketing Ltd',0,10101,10101,0,'Narration ::',0,1074,99,0,106326,'BOPP'),('2017-08-09','488','G L Marketing Ltd',0,9491.45,9491.45,0,'Narration ::',0,1030,97,0,99910,'BOPP'),('2017-08-05','49','Harsh Industries',0,0,0,0,'Narration ::',0,450,17,0,7650,'Bindi'),('2017-08-12','56','Harsh Industries',0,0,0,0,'Narration ::',0,2069,17,0,35173,'Bindi'),('2017-08-31','751','G L Marketing Ltd',0,2745.18,2745.18,0,'Narration ::',0,302,101,0,30502,'BOPP'),('2017-08-10','99','SK Enterprises',0,7437.5,7437.5,0,'Narration ::',0,17500,17,0,321300,'GlassBeads');

/*Table structure for table `receipt` */

DROP TABLE IF EXISTS `receipt`;

CREATE TABLE `receipt` (
  `DATE_` date NOT NULL,
  `BY_` varchar(45) NOT NULL,
  `TO_` varchar(45) NOT NULL,
  `AMOUNT` int(11) NOT NULL,
  `NARRATION` varchar(4000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `receipt` */

insert  into `receipt`(`DATE_`,`BY_`,`TO_`,`AMOUNT`,`NARRATION`) values ('2017-07-21','Cash','Guddu Products',1000,'Narration ::'),('2017-08-19','Cash','Malka Enterprises',38242,'Narration ::'),('2017-08-22','Cash','Malka Enterprises',19116,'Narration ::'),('2017-07-13','kotak Mahindra Bank','Balaji Traders',150000,'Narration ::'),('2017-07-20','kotak Mahindra Bank','Maa Paarvati Traders',17100,'Narration ::'),('2017-07-20','kotak Mahindra Bank','RK Industries Ltd',8000,'Narration ::'),('2017-07-20','kotak Mahindra Bank','Sarvottam Industries Ltd',8461,'Narration ::'),('2017-07-21','kotak Mahindra Bank','Guddu Products',20000,'Narration ::'),('2017-07-24','kotak Mahindra Bank','Shagun Traders',6743,'Narration ::'),('2017-07-25','kotak Mahindra Bank','Nikhat Traders Pvt Ltda',54025,'Narration ::'),('2017-07-27','kotak Mahindra Bank','Balaji Traders',300000,'Narration ::'),('2017-07-27','kotak Mahindra Bank','Aero Tex Pvt Ltd',11000,'Narration ::'),('2017-07-27','kotak Mahindra Bank','Preet Hosiery Pvt Ltd',17000,'Narration ::'),('2017-07-31','kotak Mahindra Bank','Lady Archana Bindi Ltd',36870,'Narration ::'),('2017-08-02','kotak Mahindra Bank','Alishan Creation Corporate',22071,'Narration ::'),('2017-08-02','kotak Mahindra Bank','Vikas Crystal Pvt Ltd',32716,'Narration ::'),('2017-08-04','kotak Mahindra Bank','Radhika Products',40000,'Narration ::'),('2017-08-05','kotak Mahindra Bank','Balaji Traders',200000,'Narration ::'),('2017-08-05','kotak Mahindra Bank','Shyam Housy Corporation',40852,'Narration ::'),('2017-08-10','kotak Mahindra Bank','Sindhu Hosiery Pvt Ltd',18125,'Narration ::'),('2017-08-11','kotak Mahindra Bank','Paras Trading Coporation',19125,'Narration ::'),('2017-08-11','kotak Mahindra Bank','Nancy Fashion Traders',22359,'Narration ::'),('2017-08-23','kotak Mahindra Bank','New Dastana Hosiery',2600,'Narration ::'),('2017-08-24','kotak Mahindra Bank','Indian Cottage Industries',8285,'Narration ::'),('2017-08-24','kotak Mahindra Bank','Shagun Traders',35461,'Narration ::'),('2017-08-25','kotak Mahindra Bank','Cash',100000,'Narration ::'),('2017-08-25','kotak Mahindra Bank','Balaji Traders',200000,'Narration ::'),('2017-09-01','kotak Mahindra Bank','Maa Paarvati Traders',8650,'Narration ::'),('2017-09-01','kotak Mahindra Bank','RK Industries Ltd',8000,'Narration ::'),('2017-09-04','kotak Mahindra Bank','Lady Archana Bindi Ltd',34448,'Narration ::'),('2017-09-09','kotak Mahindra Bank','Nikhat Traders Pvt Ltda',75000,'Narration ::'),('2017-09-14','kotak Mahindra Bank','Balaji Traders',150000,'Narration ::'),('2017-09-16','kotak Mahindra Bank','Shree Adinaath Traders',13500,'Narration ::'),('2017-09-16','kotak Mahindra Bank','Mahavir Sales Co',19964,'Narration ::'),('2017-09-19','kotak Mahindra Bank','Nancy Fashion Traders',21848,'Narration ::'),('2017-09-20','kotak Mahindra Bank','Diamond Impex',65000,'Narration ::'),('2017-09-21','kotak Mahindra Bank','New Dastana Hosiery',5900,'Narration ::'),('2017-09-28','kotak Mahindra Bank','Sajjan Singh and Brothers',11650,'Narration ::'),('2017-09-28','kotak Mahindra Bank','Radhika Products',40500,'Narration ::'),('2017-07-02','kotak Mahindra Bank','Bank Interest',3542,'Narration ::'),('2017-08-02','kotak Mahindra Bank','Bank Interest',4410,'Narration ::'),('2017-09-04','kotak Mahindra Bank','Bank Interest',2104,'Narration ::'),('2017-07-02','kotak Mahindra Bank','Returns From Investment',48012,'Narration ::'),('2017-08-02','kotak Mahindra Bank','Returns From Investment',51234,'Narration ::'),('2017-09-02','kotak Mahindra Bank','Returns From Investment',21430,'Narration ::'),('2017-09-13','kotak Mahindra Bank','Fixed Deposit',42510,'Narration ::');

/*Table structure for table `sale` */

DROP TABLE IF EXISTS `sale`;

CREATE TABLE `sale` (
  `DATE_` date NOT NULL,
  `INVOICE` int(11) NOT NULL,
  `BUYER` varchar(45) NOT NULL,
  `CESS` float DEFAULT NULL,
  `CGST` float DEFAULT NULL,
  `SGST` float DEFAULT NULL,
  `IGST` float DEFAULT NULL,
  `NARRATION` varchar(4000) DEFAULT NULL,
  `ROUNDOFF` float DEFAULT NULL,
  `QUANTITY` float DEFAULT NULL,
  `RATE` float DEFAULT NULL,
  `DISCOUNT` float DEFAULT NULL,
  `TOTAL` float DEFAULT NULL,
  `ITEM` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`INVOICE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sale` */

insert  into `sale`(`DATE_`,`INVOICE`,`BUYER`,`CESS`,`CGST`,`SGST`,`IGST`,`NARRATION`,`ROUNDOFF`,`QUANTITY`,`RATE`,`DISCOUNT`,`TOTAL`,`ITEM`) values ('2017-07-04',1,'Balaji Traders',0,0,0,702,'Narration ::',0,30,130,0,4602,'BOPP'),('2017-07-08',2,'Balaji Traders',0,0,0,1638,'Narration ::',0,70,130,0,10738,'BOPP'),('2017-07-11',3,'Balaji Traders',0,0,0,4455,'Narration ::',0,275,90,0,29205,'Fevicol'),('2017-07-12',4,'Balaji Traders',0,0,0,38880,'Narration ::',0.280273,1800,120,0,254880,'BOPP'),('2017-07-12',5,'Zeenaat Traders Pvt Ltd',0,497.25,497.25,0,'Narration ::',0,65,85,0,5525,'Fevicol'),('2017-07-12',6,'Zeenaat Traders Pvt Ltd',0,990,990,0,'Narration ::',0,100,110,0,11000,'BOPP'),('2017-07-14',7,'RK Industries Ltd',0,0,0,1215,'Narration ::',0,45,150,0,7965,'BOPP'),('2017-07-14',8,'Nancy Fashion Traders',0,0,0,1699.2,'Narration ::',0.200195,80,118,0,11139,'BOPP'),('2017-07-18',9,'Sindhu Hosiery Pvt Ltd',0,0,0,2761.2,'Narration ::',0.199219,130,118,0,18101,'BOPP'),('2017-07-18',10,'Shyam Housy Corporation',0,0,0,6223.32,'Narration ::',0.320312,293,118,0,40797,'BOPP'),('2017-07-20',11,'Sarvottam Industries Ltd',0,0,0,1274.4,'Narration ::',0.400391,60,118,0,8354,'BOPP'),('2017-07-20',12,'Shree Adinaath Traders',0,0,0,1210.68,'Narration ::',0.680176,57,118,0,7936,'BOPP'),('2017-07-20',13,'Alishan Creation Corporate',0,583.9,583.9,0,'Narration ::',0,11678,2,0,23356,'GlassBeads'),('2017-07-20',14,'Alishan Creation Corporate',0,58.35,58.35,0,'Narration ::',0,1167,2,0,2334,'GlassBeads'),('2017-07-21',15,'Balaji Traders',0,0,0,5940,'Narration ::',0,300,110,0,38940,'BOPP'),('2017-07-21',16,'Zeenaat Traders Pvt Ltd',0,100,100,0,'Narration ::',0,2000,2,0,4000,'GlassBeads'),('2017-07-24',17,'Maa Paarvati Traders',0,0,0,2591.28,'Narration ::',0.279297,122,118,0,16987,'BOPP'),('2017-07-25',18,'Vikas Crystal Pvt Ltd',0,0,0,0,'Narration ::',0,3820,105,0,401100,'Sindur'),('2017-07-25',19,'Zeenaat Traders Pvt Ltd',0,1890,1890,0,'Narration ::',0,200,105,0,21000,'BOPP'),('2017-07-26',20,'Balaji Traders',0,0,0,4455,'Narration ::',0,225,110,0,29205,'BOPP'),('2017-07-28',21,'Aero Tex Pvt Ltd',0,0,0,1677.96,'Narration ::',0.959961,79,118,0,10999,'BOPP'),('2017-07-28',22,'Preet Hosiery Pvt Ltd',0,0,0,2591.28,'Narration ::',0.279297,122,118,0,16987,'BOPP'),('2017-07-28',23,'Balaji Traders',0,0,0,3960,'Narration ::',0,200,110,0,25960,'BOPP'),('2017-07-30',24,'Guddu Products',0,500,500,0,'Narration ::',0,50,400,0,20000,'GlassBeads'),('2017-07-30',25,'Lady Archana Bindi Ltd',0,625,625,0,'Narration ::',0,50,500,0,25000,'GlassBeads'),('2017-07-30',26,'Lady Archana Bindi Ltd',0,801.9,801.9,0,'Narration ::',0,81,110,0,8910,'BOPP'),('2017-07-30',27,'Nikhat Traders Pvt Ltda',0,945,945,0,'Narration ::',0,90,420,0,37800,'GlassBeads'),('2017-07-30',28,'Nikhat Traders Pvt Ltda',0,1069.2,1069.2,0,'Narration ::',0,108,110,0,11880,'BOPP'),('2017-08-02',29,'Nancy Fashion Traders',0,0,0,1699.2,'Narration ::',0.200195,80,118,0,11139,'BOPP'),('2017-08-02',30,'Balaji Traders',0,0,0,5940,'Narration ::',0,300,110,0,38940,'BOPP'),('2017-08-09',31,'Balaji Traders',0,0,0,7425,'Narration ::',0,375,110,0,48675,'BOPP'),('2017-08-09',32,'Radhika Products',0,1980,1980,0,'Narration ::',0,200,110,0,22000,'Packaging'),('2017-08-10',33,'Radhika Products',0,75,75,0,'Narration ::',0,1500,2,0,3000,'GlassBeads'),('2017-08-12',34,'Radhika Products',0,765,765,0,'Narration ::',0,100,85,0,8500,'Fevicol'),('2017-08-14',35,'Indian Cottage Industries',0,624.96,624.96,0,'Narration ::',0,62,112,0,6944,'BOPP'),('2017-08-14',36,'Balaji Traders',0,0,0,3960,'Narration ::',0,200,110,0,25960,'BOPP'),('2017-08-14',37,'Mahavir Sales Co',0,1514.7,1514.7,0,'Narration ::',0,153,110,0,16830,'BOPP'),('2017-08-18',38,'Balaji Traders',0,0,0,3484.8,'Narration ::',0.800781,176,110,0,22844,'BOPP'),('2017-08-18',39,'Paras Trading Coporation',0,1260,1260,0,'Narration ::',0,2800,18,0,50400,'GlassBeads'),('2017-08-19',40,'Malka Enterprises',0,2916,2916,0,'Narration ::',0,200,162,0,32400,'BOPP'),('2017-08-21',41,'Sindhu Hosiery Pvt Ltd',0,0,0,2655,'Narration ::',0,125,118,0,17405,'BOPP'),('2017-08-22',42,'Nancy Fashion Traders',0,0,0,1635.48,'Narration ::',0.480469,77,118,0,10721,'BOPP'),('2017-08-22',43,'Shagun Traders',0,2701.35,2701.35,0,'Narration ::',0,261,115,0,30015,'BOPP'),('2017-08-22',44,'Malka Enterprises',0,1458,1458,0,'Narration ::',0,100,162,0,16200,'BOPP'),('2017-08-23',45,'Balaji Traders',0,0,0,4950,'Narration ::',0,250,110,0,32450,'BOPP'),('2017-08-24',46,'Balaji Traders',0,0,0,5940,'Narration ::',0,300,110,0,38940,'BOPP'),('2017-08-25',47,'Vishnu Store',0,0,0,0,'Narration ::',0,300,85,0,25500,'Bindi'),('2017-08-26',48,'Balaji Traders',0,0,0,1980,'Narration ::',0,100,110,0,12980,'Packaging'),('2017-08-26',49,'New Dastana Hosiery',0,1906.65,1906.65,0,'Narration ::',0,19,1115,0,21185,'Packaging'),('2017-08-28',50,'Diamond Impex',0,0,0,227.5,'Narration ::',0.5,2275,2,0,4777,'GlassBeads'),('2017-08-29',51,'Balaji Traders',0,0,0,34,'Narration ::',0,340,2,0,714,'GlassBeads'),('2017-08-30',52,'Maa Paarvati Traders',0,0,0,1304.1,'Narration ::',0.0996094,63,115,0,8549,'BOPP'),('2017-08-31',53,'Allied Hosiery',0,0,0,1635.3,'Narration ::',0.299805,79,115,0,10720,'BOPP'),('2017-09-01',54,'Shri Hinglaj Properties',0,0,0,1366.2,'Narration ::',0.200195,66,115,0,8956,'Packaging'),('2017-09-04',55,'RK Industries Ltd',0,0,0,1200.6,'Narration ::',0.600098,58,115,0,7870,'BOPP'),('2017-09-04',56,'Sindhu Hosiery Pvt Ltd',0,0,0,0,'Narration ::',0,500,16,0,8000,'Bindi'),('2017-09-05',57,'Balaji Traders',0,0,0,56.3,'Narration ::',0.300049,563,2,0,1182,'GlassBeads'),('2017-09-05',58,'Sindhu Hosiery Pvt Ltd',0,0,0,1508.04,'Narration ::',0.0400391,71,118,0,9886,'BOPP'),('2017-09-08',59,'SHIV',0,0,0,1092,'Narration ::',0,60,65,0,4992,'Lip Balm'),('2017-09-08',60,'SHIV',0,0,0,2419.2,'Narration ::',0.200195,72,120,0,11059,'HairColour'),('2017-09-08',61,'SHIV',0,0,0,784,'Narration ::',0,25,112,0,3584,'Compac Powder'),('2017-09-08',62,'SHIV',0,0,0,0,'Narration ::',0,500,18,0,9000,'Bindi'),('2017-09-28',63,'Sajjan Singh and Brothers',0,0,0,1677.96,'Narration ::',0.959961,79,118,0,10999,'BOPP'),('2017-10-03',64,'Madaan Knitting',0,0,0,2761.2,'Narration ::',0.199219,130,118,0,18101,'BOPP'),('2017-10-04',65,'Nancy Fashion Traders',0,0,0,1614.24,'Narration ::',0.240234,76,118,0,10582,'BOPP'),('2017-10-10',66,'Balaji Traders',0,0,0,4160.7,'Narration ::',0.699219,201,115,0,27275,'BOPP'),('2017-10-12',67,'Balaji Traders',0,0,0,207,'Narration ::',0,10,115,0,1357,'BOPP'),('2017-10-24',68,'Nancy Fashion Traders',0,0,0,1062,'Narration ::',0,50,118,0,6962,'BOPP'),('2017-11-17',69,'Diamond Impex',0,0,0,55.6416,'Narration ::',0.761597,23,14,4,364,'BOPP');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
