CREATE TABLE `employee` (
`id`  int NOT NULL AUTO_INCREMENT ,
`name`  varchar(20) NOT NULL ,
`sex`  varchar(3) NULL DEFAULT '��' ,
`password`  varchar(32) NOT NULL ,
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
`name`  varchar(20) NULL DEFAULT '�ϵ�' ,
`sex`  varchar(3) NULL DEFAULT '��' ,
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

INSERT INTO `employee` VALUES ('1001', '���ĺ�', '��', 'b8c37e33defde51cf91e1e03e51657da', null, '2017-08-19 21:13:36');
INSERT INTO `employee` VALUES ('1002', '����', '��', '96e79218965eb72c92a549dd5a330112', '2017-08-20 00:15:55', '2017-08-19 21:14:30');
INSERT INTO `employee` VALUES ('1003', '����', 'Ů', 'aa68c75c4a77c87f97fb686b2f068676', null, '2017-08-19 21:14:34');
INSERT INTO `employee` VALUES ('1004', '���»�', '��', '96e79218965eb72c92a549dd5a330112', '2017-08-20 17:44:53', '2017-08-20 15:59:19');
INSERT INTO `employee` VALUES ('1005', '�����', 'Ů', '2387337ba1e0b0249ba90f55b2ba2521', null, '2017-08-20 17:13:44');
INSERT INTO `employee` VALUES ('1006', '����', '��', '9246444d94f081e3549803b928260f56', null, '2017-08-20 17:16:15');

INSERT INTO `custom` VALUES ('10000001', '����', '��', '0', '4', null, '1001');
INSERT INTO `custom` VALUES ('10000002', '�ϵ�', '��', '0', '1', null, '1001');
INSERT INTO `custom` VALUES ('10000003', '����', 'Ů', '0', '0', null, '1002');
INSERT INTO `custom` VALUES ('10000004', '�ϵ�', 'Ů', '1', '1', null, '1003');
INSERT INTO `custom` VALUES ('10000005', '�ϵ�', '��', '0', '0', '2017-08-20 17:45:23', '1002');
INSERT INTO `custom` VALUES ('10000006', '��ʫʫ', 'Ů', '0', '0', null, '1001');
INSERT INTO `custom` VALUES ('10000007', '123213', '��', '0', '0', null, '1001');

INSERT INTO `dvd` VALUES ('10001', '������', '����', '10', null, '1001');
INSERT INTO `dvd` VALUES ('10002', '��Ӱ����', '������', '0', null, '1002');
INSERT INTO `dvd` VALUES ('10003', '�ɿ�����', '���¼�', '0', '2017-08-19 21:23:46', '1003');
INSERT INTO `dvd` VALUES ('10004', '�ٶ��뼤��8', '����', '15', null, '1001');
INSERT INTO `dvd` VALUES ('10005', '�ٶ��뼤��7', '����', '20', null, '1001');
INSERT INTO `dvd` VALUES ('10006', '�ٶ��뼤��6', '����', '12', null, '1001');
INSERT INTO `dvd` VALUES ('10007', '�ٶ��뼤��5', '���¼�', '25', '2017-08-20 23:25:38', '1001');
INSERT INTO `dvd` VALUES ('10008', '�ٶ��뼤��4', '���¼�', '6', '2017-08-20 17:44:20', '1001');
INSERT INTO `dvd` VALUES ('10009', 'ս��2', '����', '20', null, '1003');
INSERT INTO `dvd` VALUES ('10010', 'ս��', '����', '10', null, '1001');
INSERT INTO `dvd` VALUES ('10011', '����С��', '����', '1', null, '1001');

INSERT INTO `lend` VALUES ('10001', '10000001', '2017-08-19 21:55:25', '2017-08-19 21:59:14');
INSERT INTO `lend` VALUES ('10001', '10000002', '2017-08-19 21:56:07', '2017-08-19 21:59:36');
INSERT INTO `lend` VALUES ('10002', '10000001', '2017-08-19 21:55:44', '2017-08-19 21:59:32');
INSERT INTO `lend` VALUES ('10004', '10000001', '2017-08-20 23:13:56', '2017-08-20 23:20:31');
INSERT INTO `lend` VALUES ('10006', '10000004', '2017-08-20 14:03:58', null);
INSERT INTO `lend` VALUES ('10011', '10000001', '2017-08-20 23:24:54', '2017-08-20 23:25:16');

  CREATE TRIGGER tri_addLend
  AFTER INSERT
  ON lend
  FOR EACH ROW
  BEGIN
  	UPDATE dvd SET count=count-1 where id=new.did;
  	UPDATE dvd SET state='������' where count=0 and id=new.did;
  	UPDATE custom SET lendcount=lendcount+1,sumcount=sumcount+1 where id=new.cid;
  END;
 
  CREATE TRIGGER tri_backLend
  AFTER UPDATE
  ON lend
  FOR EACH ROW
  BEGIN
  	UPDATE dvd SET count=count+1,state='����' where id=new.did;
  	UPDATE custom SET lendcount=lendcount-1 where id=new.cid;
  END;