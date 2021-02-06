CREATE TABLE PRODUCT_TABLE(
	ID INT PRIMARY KEY,
    PRODUCT_NAME VARCHAR(30),
    ADDING_DATE DATE DEFAULT(sysdate()),
    EXPIRING_DATE DATE default (sysdate()),
    PRICE DECIMAL(8,2) default(10.22),
    PRODUCT_TYPE VARCHAR(16) default('SNACKS'),
    COMPANY_NAME VARCHAR(10) DEFAULT('PRAN'),
    CHECK ( PRODUCT_TYPE='SNACKS'OR 'SOFTDRINKS'OR'COSMETICS')
);
SELECT *FROM PRODUCT_TABLE;
DELETE FROM PRODUCT_TABLE WHERE COMPANY_NAME="PRAN";
INSERT INTO PRODUCT_TABLE(ID,PRODUCT_NAME) VALUES(1,'COCACOLA' );
DROP TABLE PRODUCT_TABLE;
SET SQL_SAFE_UPDATES = 0;
DELETE FROM PRODUCT_TABLE WHERE ID LIKE '%PP' LIMIT 1;