CREATE TABLE ORDINI(
id VARCHAR2(4000),
status VARCHAR2(4000),
price NUMBER
);

CREATE TABLE ORDINI_ITEM(
polizzaId VARCHAR2(4000),
price NUMBER,
ORDERID VARCHAR2(4000)
);

CREATE TABLE POLIZZE(
polizzaId VARCHAR2(4000),
name VARCHAR2(4000),
price NUMBER
);