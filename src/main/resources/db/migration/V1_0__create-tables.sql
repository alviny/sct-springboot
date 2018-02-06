create table purchased_item (
	id INT NOT NULL auto_increment,
	description VARCHAR(255) NOT NULL,
	purchased_date TIMESTAMP NOT NULL,
	price DOUBLE(7,3) NOT NULL,
	PRIMARY KEY(id)
);

create table item (
	id INT NOT NULL auto_increment,
	description VARCHAR(255) NOT NULL,
	summary VARCHAR(255) NOT NULL,
	price DOUBLE(7,3) NOT NULL,
	PRIMARY KEY(id)
);
create table feature(
	id INT NOT NULL auto_increment,
	description VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)	
);
create table item_feature (
	item_id INT NOT NULL,
	feature_id INT NOT NULL,
	FOREIGN KEY (feature_id)
        REFERENCES feature(id)
        ON DELETE CASCADE,
	FOREIGN KEY (item_id)
        REFERENCES item(id)
        ON DELETE CASCADE,
	PRIMARY KEY ( feature_id, item_id )
);
create table customer (
	customer_id INT NOT NULL auto_increment,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    PRIMARY KEY(customer_id)
);
create table item_order (
	order_id INT NOT NULL auto_increment,
    customer_id INT NOT NULL,
    PRIMARY KEY(order_id),
    FOREIGN KEY(customer_id)
      REFERENCES customer(customer_id)
);
create table customer_order (
	customer_id INT NOT NULL,
    order_id INT NOT NULL,
    PRIMARY KEY(customer_id,order_id),
    FOREIGN KEY(customer_id)
		REFERENCES customer(customer_id),
	FOREIGN KEY(order_id)
		REFERENCES item_order(order_id)
);
