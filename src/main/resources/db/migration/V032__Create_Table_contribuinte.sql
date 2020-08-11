CREATE TABLE IF NOT EXISTS contribuinte (
    id INT AUTO_INCREMENT,
    pessoa_id INT  NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_pessoa_contribuinte FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
)  ENGINE=INNODB;
