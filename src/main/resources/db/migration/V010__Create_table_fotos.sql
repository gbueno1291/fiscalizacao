CREATE TABLE IF NOT EXISTS fotos (
    id INT AUTO_INCREMENT,
    imovel_id INT NOT NULL,
    foto VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_imovel_foto FOREIGN KEY(imovel_id) REFERENCES imovel(id)
)  ENGINE=INNODB;
