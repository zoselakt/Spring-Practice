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

SELECT a.contactId, a.accept, a.regDate FROM Contact a LEFT JOIN Gallery b 
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
