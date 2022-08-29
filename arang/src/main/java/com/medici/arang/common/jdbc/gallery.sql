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

DROP TABLE Gallery;
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


DROP TABLE GalleryInfo;
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