insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thuk Tuk Comida Indiana', 15, 2);

insert into forma_pagamento (descricao) values ('Vista');
insert into forma_pagamento (descricao) values ('Prazo');

insert into estado (id, nome) values (1, 'Mato Grosso');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Rio de Janeiro');
insert into estado (id, nome) values (4, 'Bahia');
insert into estado (id, nome) values (5, 'Maranhão');

insert into cidade (id, nome, estado_id) values (1, 'Cuiabá', 1);
insert into cidade (id, nome, estado_id) values (2, 'Várzea Grande', 1);
insert into cidade (id, nome, estado_id) values (3, 'Rondonópolis', 1);
insert into cidade (id, nome, estado_id) values (4, 'Mogi das Cruzes', 2);
insert into cidade (id, nome, estado_id) values (5, 'São Paulo', 2);
insert into cidade (id, nome, estado_id) values (6, 'Rio de Janeiro', 3);
insert into cidade (id, nome, estado_id) values (7, 'Savador', 4);
insert into cidade (id, nome, estado_id) values (8, 'São Luis', 5);


insert into permissao (id, nome, descricao) values (1, 'Consulta', 'Consulta Geral');
insert into permissao (id, nome, descricao) values (2, 'Gestor', 'Gerencia todas as conta');
insert into permissao (id, nome, descricao) values (3, 'Administrador', 'Administra todas as contas');
