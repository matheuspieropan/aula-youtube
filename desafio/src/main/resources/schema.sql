CREATE TABLE candidatos
(
    id        SERIAL PRIMARY KEY,
    nome      VARCHAR(255) NOT NULL,
    descricao TEXT
);

CREATE TABLE votos
(
    id           SERIAL PRIMARY KEY,
    id_candidato BIGINT NOT NULL,
    data_hora    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_candidato) REFERENCES candidatos (id)
);