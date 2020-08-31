CREATE TABLE IF NOT EXISTS imovel_dados_edificacao (
    id INT AUTO_INCREMENT,
    imovel_id int NOT NULL,
    area_edificacao DECIMAL(8,2),
    tipo_edificacao VARCHAR(70),
    data_construcao DATE,
    cod_caracteristica int,
    descricao_caracteristica VARCHAR(60),
    cod_desdobro_caracteristica int,
    descricao_desdobro_caracteristica VARCHAR(60),
    PRIMARY KEY(id),
    CONSTRAINT fk_imovel_edificacao FOREIGN KEY (imovel_id) REFERENCES imovel(id)
)  ENGINE=INNODB;
