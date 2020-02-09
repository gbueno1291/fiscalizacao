CREATE TABLE IF NOT EXISTS notificacao (
    id INT AUTO_INCREMENT,
    fiscal_id INT NOT NULL,
    tipoNotificacao INT NOT NULL,
    numero INT NOT NULL,
    contribuinte_id INT NOT NULL,
    imovel_id INT NOT NULL,
    data_emissao DATE NOT NULL,
    prazo INT NOT NULL,
    vencimento DATE NOT NULL,
    status TINYINT NOT NULL,
    atendida CHAR(1),
    dataAtendimento DATE,
    cancelada CHAR(1),
    dataCancelamento DATE,
    canceladoPor INT,
    prorrogada CHAR(1),
    dataProrrogacao date,
    protocolorequerimento INT,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
    