CREATE TABLE IF NOT EXISTS contato (
    id INT AUTO_INCREMENT,
    pessoa_id int NOT NULL,
    telefone VARCHAR(15),
    email VARCHAR(70),
    site VARCHAR(100),
    responsavel VARCHAR(70),
    PRIMARY KEY(id),
    CONSTRAINT fk_pessoa_contato FOREIGN KEY (pessoa_id) REFERENCES pessoa (id)
)  ENGINE=INNODB;
