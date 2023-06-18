CREATE TABLE PRODUCT_KIND
(
    idx  INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE PRODUCT_MAKER
(
    idx  INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE PRODUCT
(
    idx               INT        NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name              VARCHAR(255) NULL,
    discount_yn       VARCHAR(1) NOT NULL DEFAULT 'N',
    price             INT        NOT NULL,
    discount_price    INT        NOT NULL,
    product_kind_idx  INT        NOT NULL DEFAULT 0,
    product_maker_idx INT        NOT NULL DEFAULT 0,
    stock             INT        NOT NULL DEFAULT 0,
    CONSTRAINT FK_PRODUCT_KIND FOREIGN KEY (product_kind_idx) REFERENCES PRODUCT_KIND (idx),
    CONSTRAINT FK_PRODUCT_MAKER FOREIGN KEY (product_maker_idx) REFERENCES PRODUCT_MAKER (idx)
);