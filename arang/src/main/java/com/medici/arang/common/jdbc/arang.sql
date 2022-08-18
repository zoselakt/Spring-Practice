CREATE TABLE Artist (
	aid 			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	email			VARCHAR(20)		NOT NULL,
	passwd			VARCHAR(60)		NOT NULL,
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 101;

DROP TABLE Artist;

CREATE TABLE Artwork (
	wid 				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	artistId			BIGINT			NOT NULL,
	artworkName			VARCHAR(40)		NOT NULL,
	artworkImg			VARCHAR(20)		NOT NULL,
	description			VARCHAR(255)	NOT NULL,
	artworkCategory		VARCHAR(30)		NOT NULL,
	regDate				TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Artwork_artistId_FK
		FOREIGN KEY(artistId) REFERENCES Artist(aid)
)AUTO_INCREMENT = 1001;

DROP TABLE Artwork;

INSERT INTO Artist (email, passwd) VALUES ('test@naver.com', '1234');
SELECT * FROM Artist;

INSERT INTO Artwork (artistId, artworkName, artworkImg, description, artworkCategory) 
VALUES (101, '조조의 그림', 'chochoArt.jpg', '조조가 그린 그림입니다.', '전통판화');
SELECT * FROM Artwork;