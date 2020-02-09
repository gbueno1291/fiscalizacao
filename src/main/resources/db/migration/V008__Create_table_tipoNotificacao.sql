CREATE TABLE IF NOT EXISTS tipo_notificacao (
    id INT AUTO_INCREMENT,
    fiscal_id INT NOT NULL,
    descricao VARCHAR(30) NOT NULL,
    textoPadrao TEXT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_fiscal_tpnotificacao FOREIGN KEY(fiscal_id) REFERENCES fiscal (id)
)  ENGINE=INNODB;