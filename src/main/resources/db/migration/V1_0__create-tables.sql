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
	id INT NOT NULL auto_increment,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);
create table customer_order (
	customer_order_id INT NOT NULL auto_increment,
    customer_id INT NOT NULL,
    order_date DATETIME NOT NULL,
    total DOUBLE(7,3) NOT NULL, 
    PRIMARY KEY(customer_order_id),
    FOREIGN KEY(customer_id)
      REFERENCES customer(id)    
);
create table customer_order_item (
	customer_order_id INT NOT NULL,
    item_id INT NOT NULL,
    quantity INT NOT NULL,
    subtotal DOUBLE(7,3) NOT NULL,    
    FOREIGN KEY(customer_order_id)
      REFERENCES customer_order(customer_order_id),
    FOREIGN KEY(item_id)
      REFERENCES customer(id)    
);
