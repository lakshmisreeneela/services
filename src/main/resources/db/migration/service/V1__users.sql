CREATE TABLE roles(
  roleid bigint(8) NOT NULL AUTO_INCREMENT,
  role varchar(255) NOT NULL, 
  description varchar(255) NOT NULL,
  createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (roleid),
  UNIQUE KEY name_UNIQUE (role)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO roles(role,description) VALUES('SUPER_ADMIN','can have access to all stores information'),
                                          ('STORE_KEEPER','can view only his store information'),
                                          ('CUSTOMER','');
                                         

CREATE TABLE useraddress(
  addressid bigint(8) NOT NULL AUTO_INCREMENT,
  doornumber varchar(50) NOT NULL,
  street varchar(150) NOT NULL,
  city varchar(150) NOT NULL,
  state varchar(150) NOT NULL,
  country varchar(150) NOT NULL,
  pin bigint(8) NOT NULL,
  createdOn timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  modifiedOn timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (addressid)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO useraddress(doornumber,street,city,state,country,pin) 
VALUES('2-186','SDADF','SDSFD','EDREWR','DFDG',456794);


CREATE TABLE userdetails(
  userid bigint(8) NOT NULL AUTO_INCREMENT,
  fname varchar(150) NOT NULL,
  lname varchar(150) NOT NULL,
  contactnumber bigint NOT NULL,
  emailid varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  addressid bigint(8) NOT NULL,
  roleid bigint(8) NOT NULL,
  services VARCHAR(500),
  createdOn timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  modifiedOn timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (userid),
  UNIQUE KEY email_UNIQUE (emailid),
  UNIQUE KEY contactnumber_UNIQUE (contactnumber),
  FOREIGN KEY(addressid) REFERENCES useraddress(addressid),
  FOREIGN KEY(roleid) REFERENCES roles(roleid)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO userdetails(fname,lname,contactnumber,emailid,password,addressid,roleid) VALUES
('user','user','34735454','superadmin@gmail.com','admin@123',1,1);






