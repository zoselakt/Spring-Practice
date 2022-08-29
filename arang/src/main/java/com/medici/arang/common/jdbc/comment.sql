create table COMMENT(
	comment_num			BIGINT			PRIMARY KEY 	AUTO_INCREMENT,
	notice_num			BIGINT,
	comment_id			varchar(50)		NOT NULL,
	comment_content		VARCHAR(1000)	NOT NULL,
	comment_parent		INT,
	comment_level		INT,
	regDate				Timestamp		DEFAULT CURRENT_TIMESTAMP
)auto_increment = 1;

select * from COMMENT;
drop table comment;
