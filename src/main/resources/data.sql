-- Remove registros anteriores
DELETE FROM TB_USUARIO;

-- Usuário Admin
INSERT INTO tb_usuario (nome, cpf, email, sexo, telefone, perfil, senha, ativo, data_cadastro, data_atualizacao)
VALUES
('Admin do Sistema', '00000000000', 'admin@sistema.com', 'MASCULINO', '11999990000', 'ROLE_ADMIN', '$2a$10$ueVVA1jO54AXReSWW/azhO9MfctOXBQyOIwwcHoey6XxTTDt5dt.K', true, CURRENT_TIMESTAMP, NULL);

-- Usuários comuns
INSERT INTO tb_usuario (nome, cpf, email, sexo, telefone, perfil, senha, ativo, data_cadastro, data_atualizacao)
VALUES
('Ana Oliveira', '12345678901', 'ana.oliveira@email.com', 'FEMININO', '11987654321', 'ROLE_USER', '$2a$10$ueVVA1jO54AXReSWW/azhO9MfctOXBQyOIwwcHoey6XxTTDt5dt.K', true, CURRENT_TIMESTAMP, NULL),
('Bruno Costa', '23456789012', 'bruno.costa@email.com', 'MASCULINO', '11983456278', 'ROLE_USER', '$2a$10$ueVVA1jO54AXReSWW/azhO9MfctOXBQyOIwwcHoey6XxTTDt5dt.K', true, CURRENT_TIMESTAMP, NULL),
('Carla Souza', '34567890123', 'carla.souza@email.com', 'FEMININO', '11981234567', 'ROLE_USER', '$2a$10$ueVVA1jO54AXReSWW/azhO9MfctOXBQyOIwwcHoey6XxTTDt5dt.K', true, CURRENT_TIMESTAMP, NULL),
('Diego Lima', '45678901234', 'diego.lima@email.com', 'MASCULINO', '11982345678', 'ROLE_USER', '$2a$10$ueVVA1jO54AXReSWW/azhO9MfctOXBQyOIwwcHoey6XxTTDt5dt.K', true, CURRENT_TIMESTAMP, NULL),
('Eduarda Mendes', '56789012345', 'eduarda.mendes@email.com', 'FEMININO', '11984567890', 'ROLE_USER', '$2a$10$ueVVA1jO54AXReSWW/azhO9MfctOXBQyOIwwcHoey6XxTTDt5dt.K', true, CURRENT_TIMESTAMP, NULL),
('Felipe Rocha', '67890123456', 'felipe.rocha@email.com', 'MASCULINO', '11981239876', 'ROLE_USER', '$2a$10$ueVVA1jO54AXReSWW/azhO9MfctOXBQyOIwwcHoey6XxTTDt5dt.K', true, CURRENT_TIMESTAMP, NULL),
('Gabriela Martins', '78901234567', 'gabriela.martins@email.com', 'FEMININO', '11980987654', 'ROLE_USER', '$2a$10$ueVVA1jO54AXReSWW/azhO9MfctOXBQyOIwwcHoey6XxTTDt5dt.K', true, CURRENT_TIMESTAMP, NULL),
('Henrique Silva', '89012345678', 'henrique.silva@email.com', 'MASCULINO', '11988776655', 'ROLE_USER', '$2a$10$ueVVA1jO54AXReSWW/azhO9MfctOXBQyOIwwcHoey6XxTTDt5dt.K', true, CURRENT_TIMESTAMP, NULL),
('Isabela Nunes', '90123456789', 'isabela.nunes@email.com', 'FEMININO', '11986655443', 'ROLE_USER', '$2a$10$ueVVA1jO54AXReSWW/azhO9MfctOXBQyOIwwcHoey6XxTTDt5dt.K', true, CURRENT_TIMESTAMP, NULL);
