CREATE TABLE IF NOT EXISTS restaurant (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  address_id bigint(20) NOT NULL,
  create_date datetime NOT NULL,
  name varchar(255) NOT NULL,
  update_date datetime NOT NULL,
  active tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS address (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  city varchar(255) NOT NULL,
  country varchar(255) NOT NULL,
  pin varchar(255) NOT NULL,
  state varchar(255) NOT NULL,
  PRIMARY KEY (id)
);