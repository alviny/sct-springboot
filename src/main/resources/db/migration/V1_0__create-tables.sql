create table purchased_item (
	id INT NOT NULL auto_increment,
	description VARCHAR(255) NOT NULL,
	purchased_date TIMESTAMP NOT NULL,
	price DOUBLE(7,3) NOT NULL,
	PRIMARY KEY(id)
);