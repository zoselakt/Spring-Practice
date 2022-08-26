CREATE TABLE notice(
	num				BIGINT				PRIMARY KEY  AUTO_INCREMENT,
	title			VARCHAR(100)		NOT NULL,
	writer			VARCHAR(50),
	content			VARCHAR(1000)		NOT NULL,
/**	ImgPath			VARCHAR(50)			NOT NULL, */
	readCnt			INT,
	regDate			TIMESTAMP			DEFAULT CURRENT_TIMESTAMP
)auto_increment = 1;

select * from notice;
drop table notice;