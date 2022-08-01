create table cafemenu(
	mid				BIGINT			PRIMARY KEY auto_increment,
	menuItem		VARCHAR(15)		NOT NULL,
	addother		VARCHAR(20),
	menuPrice		int				NOT NULL,
	menuItemCount	int,
	isHot			BOOLEAN			NOT NULL,
	cid				BIGINT			NOT NULL,
	CONSTRAINT cafemenu_cid_FK
	FOREIGN KEY (cid) REFERENCES cafecategory(cid)
)AUTO_INCREMENT = 1;

CREATE TABLE cafecategory(
	cid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	categoryname	VARCHAR(15) 	NOT NULL
);

select * from cafecategory;