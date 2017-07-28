INSERT INTO
  professor (professor_id, endereco, nome, cpf, rg, sexo, telefone, matricula)
  VALUES    (001, 'Rua XYZ', 'André Neves', '999.999.999-99', '777.777.777.7', 'M', '2525-2525', '638228832871');
INSERT INTO
  professor (professor_id, endereco, nome, cpf, rg, sexo, telefone, matricula)
  VALUES     (002, 'Rua ABC', 'Márcio Belo', '222.222.222-22', '666.666.666.6', 'M', '4444-4444', '287367637856');
INSERT INTO
  professor (professor_id, endereco, nome, cpf, rg, sexo, telefone, matricula)
  VALUES (003, 'Rua Qual mesma', 'Rosângela', '237652323221', '948796', 'F', '1212-2121', '937983786738');
INSERT INTO
  professor (professor_id, endereco, nome, cpf, rg, sexo, telefone, matricula)
  VALUES (004, 'Rua do Matemático', 'Cláudio Bispo', '267726', '385891', 'M', '9393-3939', '12249849138');
INSERT INTO
  aluno  (aluno_id, endereco, nome, cpf, rg, sexo, telefone, matricula, historico)
  VALUES (001, 'Rua TB', 'Marco Aurélio da Silva', '111.111.111-11', '012.345.678.9', 'M', '8888-8888', '1410478300059', null);
INSERT INTO
  aluno  (aluno_id, endereco, nome, cpf, rg, sexo, telefone, matricula, historico)
  VALUES (002, 'Rua QQ', 'Jefferson Luis', '333.333.333-33', '898.989.898.9', 'M', '2121-2121', '8234786234', null);
INSERT INTO
  aluno  (aluno_id, endereco, nome, sexo, telefone, matricula, historico, cpf, rg)
  VALUES (003, 'Rua KLKL', 'Arthur Avilla', 'M', '9999-5588', '1310478300032', null, '555.555.555-55', '987.654.321.0');
INSERT INTO
  aluno (aluno_id, endereco, nome, sexo, telefone, matricula, historico, cpf, rg)
  VALUES (004, 'Rua Desconhecida', 'Alexandre Fonseca', 'M', '8585-5858', '82347261876', null, 'ABC', 'CDF');
INSERT INTO
  aluno (aluno_id, endereco, nome, sexo, telefone, matricula, historico, cpf, rg)
  VALUES (005, 'Rua FBI', 'Rodrigo Sudano', 'M', '3232-3232', '2387486', null, 'QQCOISA', 'AJEITAR-DPS');
INSERT INTO
  aluno (aluno_id, endereco, nome, sexo, telefone, matricula, historico, cpf, rg)
  VALUES (006, 'Rua CSI', 'William', 'M', '7979-7979', '887236', null, 'ISSO-NAO-VAI-EM-PROD', 'TODO-FIXME');
INSERT INTO
  disciplina (disciplina_id, nome, descricao, sigla, carga_horaria)
  VALUES (001, 'Algoritmo e Linguagem de Programação 1', 'Disciplina que ensina os fundamentos da programação.', 'AL1', 180.0);
INSERT INTO
  disciplina (disciplina_id, nome, descricao, sigla, carga_horaria)
  VALUES (002, 'Algoritmo e Linguagem de Programação 2', 'Refinando o mindset de programador dos alunos.', 'AL2', 220.0);
INSERT INTO
  estagio (estagio_id, aluno, empresa, funcao, data_inicio, cancelado)
  VALUES (001, 003, 'TI Soluções', 'Suporte e Desenvolvimento', '2017-01-10', false);
INSERT INTO
  estagio (estagio_id, aluno, empresa, funcao, data_inicio, cancelado)
  VALUES (002, 002, 'Empresa na Barra', 'Java Backend', '2017-03-05', false);