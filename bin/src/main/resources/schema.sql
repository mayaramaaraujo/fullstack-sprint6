CREATE TABLE IF NOT EXISTS payment (
   id bigint(20) NOT NULL AUTO_INCREMENT,
   amount decimal(19,2) NOT NULL,
   card_holder_name varchar(100) NOT NULL,
   card_number varchar(50) NOT NULL,
   card_expiration varchar(10) NOT NULL,
   card_verification_code varchar(3) NOT NULL,
   status enum('CREATED', 'CONFIRMED', 'CANCELED') NOT NULL,
   PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
