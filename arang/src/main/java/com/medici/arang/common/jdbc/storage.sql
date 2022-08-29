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