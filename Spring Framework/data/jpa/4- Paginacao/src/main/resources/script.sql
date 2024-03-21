CREATE TABLE IF NOT EXISTS pessoa
(
    id
    SERIAL
    PRIMARY
    KEY,
    nome
    VARCHAR
(
    100
),
    idade INTEGER
    );


INSERT INTO pessoa (nome, idade)
SELECT nome, idade
FROM (VALUES ('João', 25),
             ('Maria', 30),
             ('Pedro', 22),
             ('Ana', 28),
             ('Carlos', 35),
             ('Juliana', 40),
             ('Rafael', 27),
             ('Camila', 33),
             ('Lucas', 29),
             ('Fernanda', 26),
             ('Gustavo', 31),
             ('Mariana', 37),
             ('Paulo', 24),
             ('Carolina', 32),
             ('Daniel', 29),
             ('Natália', 35),
             ('Rodrigo', 28),
             ('Amanda', 27),
             ('André', 34),
             ('Bianca', 30)) AS dados(nome, idade)
WHERE NOT EXISTS (SELECT 1
                  FROM pessoa
                  WHERE pessoa.nome = dados.nome
                    AND pessoa.idade = dados.idade);