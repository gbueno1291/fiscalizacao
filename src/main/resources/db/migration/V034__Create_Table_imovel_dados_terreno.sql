CREATE TABLE IF NOT EXISTS imovel_dados_terreno (
    id INT AUTO_INCREMENT,
    imovel_id int NOT NULL,
    cod_caracteristica int,
    descricao_caracteristica VARCHAR(60),
    cod_desdobro_caracteristica int,
    descricao_desdobro_caracteristica VARCHAR(60),
    PRIMARY KEY(id),
    CONSTRAINT fk_imovel_terreno FOREIGN KEY (imovel_id) REFERENCES imovel(id)
)  ENGINE=INNODB;
