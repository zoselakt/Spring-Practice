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