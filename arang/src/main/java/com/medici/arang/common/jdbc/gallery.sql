CREATE TABLE gallery(
	gallery_code 		BIGINT		 	PRIMARY KEY  AUTO_INCREMENT,
	gallery_name 		VARCHAR(20)		NOT NULL,
	resist_name			VARCHAR(20)		NOT	NULL,
	gallery_address		VARCHAR(30)		NOT NULL,
	gallery_phone		VARCHAR(15)		NOT NULL,
	gallery_email		VARCHAR(20)		NOT NULL,
	gallery_area		VARCHAR(15)		NOT NULL,
	gallery_payment		INT				NOT NULL,
	gallery_floor		INT,
	gallery_etc			VARCHAR(30)
) AUTO_INCREMENT=1;
select * from gallery;