CREATE TABLE IF NOT EXISTS imovel (
    id INT AUTO_INCREMENT,
    cadastro VARCHAR(12) NOT NULL,
    contribuinte_id INT NOT NULL,
    bairro_id INT NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    complemento VARCHAR(100), 
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=INNODB;
