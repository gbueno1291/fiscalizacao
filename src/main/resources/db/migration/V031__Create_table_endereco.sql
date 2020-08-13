CREATE TABLE IF NOT EXISTS endereco (
    id INT AUTO_INCREMENT,
    pessoa_id int NOT NULL,
    logradouro_id int NOT NULL,
    numero VARCHAR(20) NOT NULL,
    complemento VARCHAR(10),    
    PRIMARY KEY(id),
    CONSTRAINT fk_pessoa_endereco FOREIGN KEY (pessoa_id) REFERENCES pessoa (id),
    CONSTRAINT fk_logradouro_endereco FOREIGN KEY (logradouro_id) REFERENCES logradouros (id)
)  ENGINE=INNODB;
