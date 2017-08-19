CREATE TABLE `employee` (
`id`  int NOT NULL AUTO_INCREMENT ,
`name`  varchar(20) NOT NULL ,
`sex`  varchar(3) NULL DEFAULT '男' ,
`password`  varchar(20) NOT NULL ,
`leavetime`  datetime NULL ,
`jointime`  datetime NULL ,
PRIMARY KEY (`id`)
)AUTO_INCREMENT=1001;

CREATE TABLE `dvd` (
`id`  int NOT NULL AUTO_INCREMENT ,
`name`  varchar(50) NOT NULL ,
`state`  varchar(20) NOT NULL ,
`count`  int NOT NULL ,
`undertime`  datetime NULL ,
`eid`  int NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
)AUTO_INCREMENT=10001;

CREATE TABLE `custom` (
`id`  int NOT NULL AUTO_INCREMENT ,
`name`  varchar(20) NULL DEFAULT '上帝' ,
`sex`  varchar(3) NULL DEFAULT '男' ,
`lendcount`  int NULL DEFAULT 0 ,
`sumcount`  int NULL DEFAULT 0 ,
`logofftime`  datetime NULL ,
`eid`  int NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
)AUTO_INCREMENT=10000001;

CREATE TABLE `lend` (
`did`  int NOT NULL ,
`cid`  int NOT NULL ,
`lendtime`  datetime NOT NULL ,
`backtime`  datetime NULL ,
PRIMARY KEY (`did`, `cid`, `lendtime`),
FOREIGN KEY (`did`) REFERENCES `dvd` (`id`),
FOREIGN KEY (`cid`) REFERENCES `custom` (`id`)
);

 CREATE TRIGGER tri_addLend
 AFTER INSERT
 ON lend
 FOR EACH ROW
 BEGIN
 	UPDATE dvd SET count=count-1 where id=new.did;
 	UPDATE custom SET lendcount=lendcount+1,sumcount=sumcount+1 where id=new.cid;
 END;
 
 CREATE TRIGGER tri_backLend
 AFTER UPDATE
 ON lend
 FOR EACH ROW
 BEGIN
 	UPDATE dvd SET count=count+1 where id=new.did;
 	UPDATE custom SET lendcount=lendcount-1 where id=new.cid;
 END;