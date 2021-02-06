CREATE TABLE CUSTOMER_INFO (
    CUSTOMER_ID INT PRIMARY KEY,
    CUSTOMER_NAME VARCHAR(15),
    PHONE VARCHAR(15),
    DUE DECIMAL(5,2),
    PAID DECIMAL(5,2),
    LAST_BOUGHT TIMESTAMP
);
DROP TABLE CUSTOMER_INFO;
INSERT INTO CUSTOMER_INFO VALUES(1,'JISAN','01718315457','0.00','0.00',sysdate());
INSERT INTO CUSTOMER_INFO VALUES(2,'SADMAN','01634608250','0.00','0.00',sysdate());
INSERT INTO CUSTOMER_INFO VALUES(3,'SHYKET','01634608250','0.00','0.00',sysdate());


SELECT *FROM CUSTOMER_INFO;
CREATE VIEW SHOW_INFO AS SELECT  CUSTOMER_ID,CUSTOMER_NAME,PHONE FROM  CUSTOMER_INFO;
DROP VIEW SHOW_INFO;
SELECT * FROM SHOW_INFO ;


ALTER TABLE DUES ADD COLUMN BUYING_DATE TIMESTAMP;
DELETE FROM DUES WHERE CUSTOMER_ID=1;