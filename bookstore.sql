




CREATE TABLE user (
  uid varchar(64) NOT NULL,
  username varchar(64) DEFAULT NULL,
  password varchar(64) DEFAULT NULL,
  name varchar(64) DEFAULT NULL,
  email varchar(64) DEFAULT NULL,
  telephone varchar(64) DEFAULT NULL,

  sex varchar(10) DEFAULT NULL,
  state int(11) DEFAULT NULL,
  code varchar(64) DEFAULT NULL,
  PRIMARY KEY (`uid`)
)ENGINE=InnoDB DEFAULT charset=utf8;

CREATE TABLE category (
cid  varchar(64) PRIMARY KEY  NOT NULL,
name  varchar(100) NOT NULL,
description  varchar(255),
UNIQUE (cid ASC)
) ENGINE=InnoDB DEFAULT charset=utf8;
INSERT INTO category VALUES(1,'文学',NULL);
INSERT INTO category VALUES(2,'体育',NULL);

CREATE TABLE book (
bid  varchar(64) PRIMARY KEY NOT NULL,
name  varchar(100) NOT NULL,
author  varchar(100) NOT NULL,
price  double NOT NULL,
image  varchar(100),
description  varchar(255),
category_id  varchar(64)  default null,
CONSTRAINT category_id_FK FOREIGN KEY (category_id) REFERENCES category (cid),
UNIQUE (bid ASC)
)ENGINE=InnoDB DEFAULT charset=utf8;

INSERT INTO book VALUES(1,'活着','余华',24.2,'',' 中国过去六十年所发生的一切灾难，都一一发生在福贵和他的家庭身上。接踵而至的打击或许令读者无从同情，但余华至真至诚的笔墨，已将福贵塑造成了一个存在的英雄。当这部沉重的小说结束时，活着的意志，是福贵身上不能被剥夺走的东西。',1);
INSERT INTO book VALUES(2,'浮生六记','沈复 著，张佳玮 译',22.0,'','《浮生六记》俨如一块纯美的水晶，只见明莹，不见衬露明莹的颜色；只见精微，不见制作精微的痕迹。然而我自信这种说法不至于是溢美。想读这书的，必有能辨别的罢。',1);
INSERT INTO book VALUES(3,'围城','钱锺书',24.2,'','凡是真正出色的文学作品，都具有一种抗理论分析力，任何自认为深透、精彩的理论都会在它们面前显得干瘪而又捉襟见肘。尽管钱锺书所著的《围城》本身并不朦胧，但我们读后的感觉仍是感觉大于思想，大于语言。',1);
INSERT INTO book VALUES(4,'我们仨','杨绛',12.2,'','一百零五岁的杨绛，以简洁而沉重的语言，回忆了女儿钱瑗、丈夫钱钟书，一家三口那些快乐而艰难、爱与痛的日子。故事证明：家庭是人生的庇护所。',1);
INSERT INTO book VALUES(5,'闲情偶寄','李渔 著',40.2,NULL,'《闲情偶寄》是一部讨论生活艺术的书。李渔极富创作思想，对每件东西都有新颖的议论。他所创作的器具中，有许多至今为人所用。',1);




CREATE TABLE orders (
oid  varchar(64) PRIMARY KEY ,
ordertime  datetime NOT NULL,
price  double NOT NULL,
state  boolean,
user_id  varchar(64),
CONSTRAINT user_id_FK FOREIGN KEY (user_id) REFERENCES user (uid)
)ENGINE=InnoDB DEFAULT charset=utf8;


CREATE TABLE orderitem (
otid  varchar(64) PRIMARY KEY ,
quantity  int,
price  double,
order_id  varchar(64),
book_id  varchar(64),
CONSTRAINT order_id_FK FOREIGN KEY (order_id) REFERENCES orders (oid),
CONSTRAINT book_id_FK FOREIGN KEY (book_id) REFERENCES book (bid)
)ENGINE=InnoDB DEFAULT charset=utf8;

