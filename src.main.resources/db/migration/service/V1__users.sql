CREATE TABLE roles(
  id bigint(8) NOT NULL AUTO_INCREMENT,
  role varchar(255) NOT NULL, 
  description varchar(255) NOT NULL,
  createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (id),
  UNIQUE KEY name_UNIQUE (role)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO roles(role,description) VALUES('SUPER_ADMIN','can have all access rights'),
                                          ('STORE_KEEPER','can view only his store information'),
                                          ('CUSTOMER','');
                                         

CREATE TABLE useraddress(
  id bigint(8) NOT NULL AUTO_INCREMENT,
  doornumber varchar(50) NOT NULL,
  street varchar(150) NOT NULL,
  city varchar(150) NOT NULL,
  state varchar(150) NOT NULL,
  country varchar(150) NOT NULL,
  pin bigint(8) NOT NULL,
  createdOn timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  modifiedOn timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO useraddress(doornumber,street,city,state,country,pin) VALUES('2-186','SDADF','SDSFD','EDREWR','DFDG',45679);


CREATE TABLE usersdetails(
  id bigint(8) NOT NULL AUTO_INCREMENT,
  fname varchar(150) NOT NULL,
  lname varchar(150) NOT NULL,
  contactnumber bigint,
  emailid varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  addressid bigint(8) NOT NULL,
  roleid bigint(8) NOT NULL,
  createdOn timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  modifiedOn timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (id),
  UNIQUE KEY name_UNIQUE (emailid),
 FOREIGN KEY(addressid) REFERENCES useraddress(id),
 FOREIGN KEY(roleid) REFERENCES roles(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO usersdetails(fname,lname,contactnumber,emailid,password,addressid,roleid) VALUES
('user','user','34735454','user@gmail.com','user',1,1);




