create table doctors (
	registration    VARCHAR(50) primary key,
	name            VARCHAR(200),
	degree          VARCHAR(100) not null,
	specialization  VARCHAR(200),
	phone           VARCHAR(13),
	email           VARCHAR(100),
	city            VARCHAR(100),
	address         VARCHAR(250),
	description     VARCHAR(2000)
) ENGINE = MYISAM;

ALTER TABLE doctors ADD FULLTEXT(name, city, address, specialization);

create table dispensaries (
	registration    VARCHAR(50),
	days            VARCHAR(50),
	timing          VARCHAR(50),
	visit           INT,
	phone           VARCHAR(13),
	address         VARCHAR(250),
	pin             INT
)