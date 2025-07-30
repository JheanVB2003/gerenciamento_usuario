-- Remove registros anteriores
DELETE FROM PESSOAS;

-- Inserção de 10 usuários
INSERT INTO PESSOAS (nome, cpf, email, telefone, sexo)
VALUES
('João da Silva','123.456.789-00', 'joao.silva@email.com','(11) 91234-5678', 'MASCULINO'),
('Maria Oliveira','987.654.321-00', 'maria.oliveira@email.com', '(21) 92345-6789', 'FEMININO'),
('Carlos Souza','456.789.123-00', 'carlos.souza@email.com', '(31) 93456-7890', 'MASCULINO'),
('Ana Paula Santos','321.654.987-00', 'ana.santos@email.com','(41) 94567-8901', 'FEMININO'),
('Pedro Henrique Lima','159.753.486-20', 'pedro.lima@email.com','(51) 95678-9012', 'MASCULINO'),
('Juliana Costa','258.369.147-80', 'juliana.costa@email.com','(61) 96789-0123', 'FEMININO'),
('Ricardo Almeida','741.852.963-10', 'ricardo.almeida@email.com','(71) 97890-1234', 'MASCULINO'),
('Fernanda Ribeiro','852.741.369-20', 'fernanda.ribeiro@email.com','(81) 98901-2345', 'FEMININO'),
('Lucas Martins','369.258.147-00', 'lucas.martins@email.com',  '(91) 99012-3456', 'MASCULINO'),
('Camila Fernandes','147.258.369-90', 'camila.fernandes@email.com','(85) 90123-4567', 'FEMININO');
