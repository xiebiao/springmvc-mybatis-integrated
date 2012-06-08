CREATE TABLE `user` (
  `userId` int(11) NOT NULL auto_increment,
  `userName` varchar(32) default NULL,
  `age` int(11) default 0,
  PRIMARY KEY  (`userId`),
  UNIQUE KEY `userName` (`userName`)
);