DROP TABLE IF EXISTS `todo`;
CREATE TABLE todo (
    idx INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(255) NULL,
    done_yn VARCHAR(1) NOT NULL DEFAULT 'N',
    create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
    delete_date TIMESTAMP NULL
);