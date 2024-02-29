CREATE TABLE IF NOT EXISTS empresa (
                                       id INT PRIMARY KEY,
                                       razao_social VARCHAR(255),
    cnpj VARCHAR(14)
    );

CREATE TABLE IF NOT EXISTS funcionario (
                                           id INT PRIMARY KEY,
                                           nome VARCHAR(255),
    cpf VARCHAR(11)
    );

CREATE TABLE IF NOT EXISTS empresa_funcionario (
                                                   empresa_id INT,
                                                   funcionario_id INT,
                                                   FOREIGN KEY (empresa_id) REFERENCES empresa(id),
    FOREIGN KEY (funcionario_id) REFERENCES funcionario(id),
    PRIMARY KEY (empresa_id, funcionario_id)
    );

INSERT INTO empresa (id, razao_social, cnpj)
SELECT 1,
       'empresa A',
       '12345678901234' WHERE NOT EXISTS (SELECT 1 FROM empresa WHERE id = 1);

INSERT INTO empresa (id, razao_social, cnpj)
SELECT 2,
       'empresa B',
       '56789012345678' WHERE NOT EXISTS (SELECT 1 FROM empresa WHERE id = 2);

INSERT INTO funcionario (id, nome, cpf)
SELECT 1,
       'funcionario 1',
       '12345678901' WHERE NOT EXISTS (SELECT 1 FROM funcionario WHERE id = 1);

INSERT INTO funcionario (id, nome, cpf)
SELECT 2,
       'funcionario 2',
       '45678901234' WHERE NOT EXISTS (SELECT 1 FROM funcionario WHERE id = 2);

INSERT INTO funcionario (id, nome, cpf)
SELECT 3,
       'funcionario 3',
       '78901234567' WHERE NOT EXISTS (SELECT 1 FROM funcionario WHERE id = 3);

-- Inserir relação entre empresa e funcionário apenas se ela não existir
INSERT INTO empresa_funcionario (empresa_id, funcionario_id)
SELECT 1,
       1 WHERE NOT EXISTS (SELECT 1 FROM empresa_funcionario WHERE empresa_id = 1 AND funcionario_id = 1);

INSERT INTO empresa_funcionario (empresa_id, funcionario_id)
SELECT 1,
       2 WHERE NOT EXISTS (SELECT 1 FROM empresa_funcionario WHERE empresa_id = 1 AND funcionario_id = 2);

INSERT INTO empresa_funcionario (empresa_id, funcionario_id)
SELECT 2,
       2 WHERE NOT EXISTS (SELECT 1 FROM empresa_funcionario WHERE empresa_id = 2 AND funcionario_id = 2);

INSERT INTO empresa_funcionario (empresa_id, funcionario_id)
SELECT 2,
       3 WHERE NOT EXISTS (SELECT 1 FROM empresa_funcionario WHERE empresa_id = 2 AND funcionario_id = 3);