CREATE TABLE IF NOT EXISTS contribuinte (
    id INT AUTO_INCREMENT,
    nome VARCHAR(70) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    telefone VARCHAR(14) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    complemento VARCHAR(10),
    bairro_id INT NOT NULL,
    status TINYINT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT fk_bairro_contribuinte FOREIGN KEY(bairro_id) REFERENCES bairro(id)
)  ENGINE=INNODB;
