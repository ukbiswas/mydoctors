create table doctors (
	registration VARCHAR(50) primary key,
	name TEXT,
	degree VARCHAR(100) not null,
	phone VARCHAR(13),
	email VARCHAR(100),
	city TEXT,
	specialization TEXT,
	description VARCHAR(1000)
) ENGINE = MYISAM;
ALTER TABLE doctors ADD FULLTEXT(name, city, specialization);
create table dispensaries (
	registration VARCHAR(50),
	days VARCHAR(50),
	timing VARCHAR(50),
	visit INT,
	phone VARCHAR(13),
	address VARCHAR(250),
	pin VARCHAR(7)
)