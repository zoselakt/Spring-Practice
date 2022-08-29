!DROP TABLE Artist;
!DELETE FROM Artist WHERE aid=5;
!ALTER TABLE Artist MODIFY genre VARCHAR(100);

CREATE TABLE Artist(
  aid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
  email			VARCHAR(30)		NOT NULL,
  passwd		VARCHAR(20)		NOT NULL,
  name_kor		VARCHAR(20)		NOT NULL,
  name_eng		VARCHAR(20)		NOT NULL,
  ssn			VARCHAR(20)		NOT NULL,
  phone			VARCHAR(13)		NOT NULL,
  genre			VARCHAR(100)	NOT NULL,
  career		VARCHAR(100)	NOT NULL,
  imgPath		VARCHAR(300)	NOT NULL,
  regDate		TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1;

SELECT * FROM Artist;

UPDATE Artist SET imgPath = "/upload_img/artist/Kim Bo Hei/127d4f6c.jpg" WHERE aid = 11;

UPDATE Artwork SET name = 'BLOCK (Falling Blue Brown)' WHERE artistId = '2';

!DROP TABLE Artwork;
CREATE TABLE Artwork (
	wid 				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	artistId			BIGINT			NOT NULL,
	name				VARCHAR(60)		NOT NULL,
	genre				VARCHAR(20)		NOT NULL,
	technique			VARCHAR(60)		NOT NULL,
	size				VARCHAR(40)		NOT NULL,
	publicationDate		VARCHAR(40)		NOT NULL,
	description			VARCHAR(500)	NOT NULL,
	artworkImgPath		VARCHAR(60)		NOT NULL,
	regDate				TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Artwork_artistId_FK
		FOREIGN KEY(artistId) REFERENCES Artist(aid)
)AUTO_INCREMENT = 1001;

SELECT * FROM Artwork GROUP BY artistId;

SELECT * FROM Artwork;

!DELETE FROM Artwork WHERE wid <= 1004;

SELECT a.name, a.genre, a.technique, a.size, a.publicationDate, a.description, 
a.artworkImgPath, b.mainTitle, b.subTitle, b.workInfoImgPath 
FROM Artwork a INNER JOIN ArtworkInfo b ON a.wid = b.artworkId 
WHERE a.wid = 1001;

UPDATE Artwork SET genre = 'Paint' WHERE genre = 'paint';

SELECT DISTINCT FROM Artwork WHERE artistId = 1;

SELECT a.name_kor, a.name_eng, a.genre, a.imgPath, b.artworkImgPath, a.aid, 
b.wid, c.title FROM Artist a INNER JOIN artwork b 
ON b.artistId = a.aid JOIN ArtistInfo c ON a.aid = c.artistId
WHERE a.genre = 'DrawingArtist' GROUP BY b.artistId;

INSERT INTO Artwork (artistId, name, genre, technique, size, publicationDate, 
description, imgPath) VALUES (1001, '조조의 그림', 'painter', '심혈을 기울인 기법', 
'500cm * 500cm', '2022', '조조가 그린 그림입니다.', 'chochoArt.jpg');	

CREATE TABLE ArtistInfo (
	bid 				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	artistId			BIGINT			NOT NULL,
	title				VARCHAR(200)	NOT NULL,
	description			VARCHAR(1000)	NOT NULL,
	infoImgPath			VARCHAR(40)		NOT NULL,
	regDate				TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT ArtistInfo_artistId_FK
		FOREIGN KEY(artistId) REFERENCES Artist(aid)
)AUTO_INCREMENT = 2001;

SELECT * FROM ArtistInfo;

!DROP TABLE ArtistInfo;
!DELETE FROM ArtistInfo WHERE artistId=7;

SELECT a.name_kor, a.ssn, a.imgPath, b.title, b.description, b.infoImgPath 
FROM ArtistInfo b LEFT JOIN Artist a ON a.aid = b.artistId WHERE a.aid = 1;


CREATE TABLE ArtworkInfo (
	cid 				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	artworkId			BIGINT			NOT NULL,
	mainTitle			VARCHAR(40)		NOT NULL,
	subTitle			VARCHAR(50)		NOT NULL,
	workInfoImgPath		VARCHAR(200)	NOT NULL,
	regDate				TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT ArtworkInfo_artworkId_FK
		FOREIGN KEY(artworkId) REFERENCES Artwork(wid)
)AUTO_INCREMENT = 3001;

SELECT * FROM ArtworkInfo;

!DROP TABLE ArtworkInfo;
!DELETE FROM ArtworkInfo WHERE cid = 3002;

INSERT INTO Artist (email, passwd) VALUES ('test@naver.com', '1234');
SELECT * FROM Artist;

INSERT INTO Artwork (artistId, artworkName, artworkImg, description, artworkCategory) 
VALUES (101, '조조의 그림', 'chochoArt.jpg', '조조가 그린 그림입니다.', '전통판화');
SELECT * FROM Artwork;
DELETE FROM Artwork WHERE wid=1002;
SELECT * FROM Artwork JOIN Artist ON Artwork.artistId = Artist.aid WHERE mid = ?

UPDATE Artwork SET artistId = 101, artworkName = '조조가 훔친 유비의 그림', 
artworkImg = 'bbart.png', description = '조조가 홈친 유비의 그림이다.', 
artworkCategory = '동양화' WHERE wid = 1001;


!DROP TABLE Gallerist;

CREATE TABLE Gallerist(
	email		VARCHAR(30)		PRIMARY KEY,
	passwd		VARCHAR(20)		NOT NULL,
	name		VARCHAR(20)		NOT NULL,
	ssn			VARCHAR(20)		NOT NULL,
	phone		VARCHAR(13)		NOT NULL,
	imgPath		VARCHAR(300),
	regDate		TIMESTAMP		DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM Gallerist;

!DROP TABLE Gallery;
CREATE TABLE Gallery(
	code 					BIGINT		 	PRIMARY KEY  AUTO_INCREMENT,
	galleristEmail			VARCHAR(30)		NOT NULL,
	galleryName_kor 		VARCHAR(20)		NOT NULL,	
	galleryName_eng			VARCHAR(40)		NOT NULL,
	address					VARCHAR(40)		NOT NULL,
	galleryEmail			VARCHAR(40)		NOT NULL,
	galleryPhone			VARCHAR(15)		NOT NULL,
	since					VARCHAR(10)		NOT NULL,
	area					VARCHAR(20)		NOT NULL,
	openClose				VARCHAR(30)		NOT NULL,
	galleryImgPath			VARCHAR(50)		NOT NULL,
	representer				VARCHAR(30)		NOT NULL,
	representerNum			VARCHAR(40)		NOT NULL,
	regDate					TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Gallery_galleristEmail 
		FOREIGN KEY (galleristEmail) REFERENCES Gallerist(email)
) AUTO_INCREMENT = 1;

SELECT * FROM Gallery;


!DROP TABLE GalleryInfo;
CREATE TABLE GalleryInfo(
	galleryCode 	BIGINT			NOT NULL,
	description		VARCHAR(1000)	NOT NULL,
	infoImgPath		VARCHAR(300),
	CONSTRAINT GalleryInfo_galleryCode
		FOREIGN KEY (galleryCode) REFERENCES Gallery(code)
);

SELECT * FROM GalleryInfo;

SELECT a.galleristEmail, a.galleryName_kor, a.galleryName_eng, a.address,
a.galleryEmail, a.galleryPhone, a.since, a.area, a.openClose, a.galleryImgPath,
b.description, b.infoImgPath FROM GalleryInfo b LEFT JOIN Gallery a 
ON a.code = b.galleryCode;

!DROP TABLE Contact;
!DELETE FROM Contact WHERE contactId = 101;
CREATE TABLE Contact(
	contactId			BIGINT			PRIMARY KEY  AUTO_INCREMENT,
	galleryCode			BIGINT			NOT NULL,
	artistId			BIGINT			NOT NULL,
	comment				VARCHAR(100)	NULL,
	exhibitionTitle		VARCHAR(20)		NULL,
	startDate			VARCHAR(20)		NULL,
	endDate				VARCHAR(20)		NULL,
	accept				VARCHAR(3)		NULL DEFAULT 'U',
	sendingType			VARCHAR(3)		NOT NULL,
	regDate				TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Contact_galleryCode 
		FOREIGN KEY (galleryCode) REFERENCES Gallery(code),
	CONSTRAINT Contact_artistId 
		FOREIGN KEY (artistId) REFERENCES Artist(aid)
)AUTO_INCREMENT = 101;

SELECT * FROM Contact;


SELECT a.accept, a.regDate, d.imgPath, d.name_kor, d.name_eng, a.exhibitionTitle, 
a.startDate, a.endDate, a.sendingType, a.comment 
FROM Contact a LEFT JOIN Gallery b 
ON b.code = a.galleryCode JOIN Gallerist c 
ON b.galleristEmail = c.email JOIN Artist d 
ON d.aid = a.artistId WHERE c.email = 'test1@naver.com' AND a.sendingType = 'G';


INSERT INTO Contact (galleryCode, artistId) VALUES (3, 11);

SELECT * FROM Contact WHERE galleryCode = 1;

SELECT a.contactId, a.accept, a.regDate, FROM Contact a LEFT JOIN Gallery b 
ON b.code = a.galleryCode WHERE a.artistId = 1 GROUP BY a.contactId;


SELECT exhibitionTitle, startDate, endDate, artworkImgPath FROM Contact a 
INNER JOIN Artwork b ON a.artistId = b.artistId WHERE a.sendingType = 'G' 
AND a.accept = 'Y' GROUP BY a.contactId;



SELECT a.accept, a.regDate, d.imgPath, d.name_kor, d.name_eng, d.genre, 
b.galleryName_eng, b.galleryImgPath
FROM Contact a  
LEFT JOIN Gallery b ON b.code = a.galleryCode
JOIN Gallerist c ON b.galleristEmail = c.email
JOIN Artist d ON d.aid = a.artistId
WHERE c.email = 'test1@naver.com' AND a.sendingType = 'A';




SELECT a.contactId, a.accept, a.regDate, a.startDate, a.endDate, a.exhibitionTitle,
a.comment, b.galleryName_eng, b.galleryImgPath FROM Contact a LEFT JOIN Gallery b 
ON b.code = a.galleryCode WHERE a.artistId = 1 GROUP BY a.contactId;

SELECT a.contactId, a.accept, a.regDate, b.galleryName_eng, b.galleryImgPath, 
a.startDate, a.endDate, a.exhibitionTitle, a.comment, a.galleryCode, 
a.sendingType FROM Contact a LEFT JOIN Gallery b ON b.code = a.galleryCode 
WHERE a.artistId = 1 AND a.sendingType = 'A' GROUP BY a.contactId;

CREATE TABLE Storage (
   sid					BIGINT			PRIMARY KEY AUTO_INCREMENT,
   artistId             VARCHAR(40)     DEFAULT NULL,
   myAddress            VARCHAR(70)     DEFAULT NULL,
   storagePeriodStart  	VARCHAR(20)     DEFAULT NULL,
   storagePeriodEnd     VARCHAR(20)     DEFAULT NULL,
   artworkType          VARCHAR(20)     DEFAULT NULL,
   artworkSize          VARCHAR(30)     DEFAULT NULL,
   artworkWeight        VARCHAR(30)     DEFAULT NULL,
   locationArea         VARCHAR(70)     DEFAULT NULL,
   charge               INT             DEFAULT NULL,
   transport            BOOLEAN         DEFAULT 0,
   approvalStatus       VARCHAR(20)     DEFAULT NULL,
   regDate              TIMESTAMP       DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1;

CREATE TABLE LikeTable(
   lid         		BIGINT           PRIMARY KEY AUTO_INCREMENT,     
   userId    		VARCHAR(50)      DEFAULT NULL,
   targetValue  	VARCHAR(50)      DEFAULT NULL,
   likeNum     		INT(10)         DEFAULT 0,
   regDate      	TIMESTAMP      DEFAULT CURRENT_TIMESTAMP   
)AUTO_INCREMENT = 1;

SELECT * FROM LikeTable;
!DROP TABLE LikeTable;

SELECT exhibitionTitle, startDate, endDate, artworkImgPath FROM Contact a 
INNER JOIN Artwork b ON a.artistId = b.artistId WHERE a.sendingType = 'G' 
AND a.accept = 'Y' GROUP BY a.contactId;

SELECT a.name_kor, a.name_eng, a.genre, a.imgPath,
b.artworkImgPath, a.aid, b.wid, c.title, d.userId
 FROM Artist a INNER JOIN artwork b
 ON b.artistId = a.aid JOIN ArtistInfo c ON a.aid = c.artistId
JOIN LikeTable d ON b.wid = d.targetValue WHERE d.userId='test1@naver.com';

SELECT a.name_kor, a.name_eng, a.genre, a.imgPath,
b.artworkImgPath, a.aid, b.wid, c.title, d.userID
FROM Artist a LEFT JOIN artwork b ON b.artistId = a.aid JOIN ArtistInfo c 
ON c.artistId = b.artistId JOIN LikeTable d ON d.targetValue = c.artistId
WHERE d.userId = 'test1@naver.com'
GROUP BY a.aid;

CREATE TABLE notice(
	num				BIGINT				PRIMARY KEY  AUTO_INCREMENT,
	title			VARCHAR(100)		NOT NULL,
	writer			VARCHAR(50),
	content			VARCHAR(1000)		NOT NULL,
	readCnt			INT,
	regDate			TIMESTAMP			DEFAULT CURRENT_TIMESTAMP
)auto_increment = 1;

SELECT * FROM notice;