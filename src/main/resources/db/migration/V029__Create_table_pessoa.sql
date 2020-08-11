CREATE TABLE IF NOT EXISTS pessoa (
    id INT AUTO_INCREMENT,
    tipo_pessoa_id int NOT NULL,
    nome_razao_social VARCHAR(100) NOT NULL,
    cpf_cnpj VARCHAR (20) NOT NULL UNIQUE,
    rg_ie VARCHAR(20) NOT NULL,
    logo_imagem VARCHAR(255),
    PRIMARY KEY(id),
    CONSTRAINT fk_tipo_pessoa_pessoa FOREIGN KEY (tipo_pessoa_id) REFERENCES tipo_pessoa (id)
)  ENGINE=INNODB;



