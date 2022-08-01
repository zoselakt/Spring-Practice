CREATE TABLE addcustomer(
	cid 		BIGINT			PRIMARY KEY AUTO_INCREMENT,
	customerid  varchar(20)		NOT NULL,
	password	varchar(14)		NOT NULL,
	name		varchar(14)		NOT NULL,
	ssn			varchar(14)		NOT NULL,
	phone		varchar(14)
)AUTO_INCREMENT = 1;

SELECT * FROM ADDCUSTOMER;
delete from addcustomer where customerid = 'jojo';

CREATE TABLE addaccount(
	aid				BIGINT		PRIMARY KEY AUTO_INCREMENT,
	customerId		BIGINT		NOT NULL,
	accountNum		CHAR(11)	NOT NULL,
	accType			CHAR(1)		NOT NULL DEFAULT 'S',
	balance			DOUBLE		NOT NULL DEFAULT 0,
	interestRate	DOUBLE		NOT NULL DEFAULT 0.0,
	overAmount		DOUBLE		NOT NULL DEFAULT 0.0,
	regDate			TIMESTAMP	NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT addaccount_customerId_FK
	FOREIGN KEY (customerId) REFERENCES addcustomer(cid) 
)AUTO_INCREMENT = 1001;

SELECT * FROM addaccount;
drop table addaccount;
