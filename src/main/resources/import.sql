INSERT INTO
  professor (professor_id, endereco, nome, cpf, rg, sexo, telefone, matricula)
  VALUES    (98765, 'Rua XYZ', 'André Neves', '999.999.999-99', '777.777.777.7', 'M', '2525-2525', '638228832871');
INSERT INTO
  professor (professor_id, endereco, nome, cpf, rg, sexo, telefone, matricula)
  VALUES     (83333, 'Rua ABC', 'Márcio Belo', '222.222.222-22', '666.666.666.6', 'M', '4444-4444', '287367637856');
INSERT INTO
  aluno  (aluno_id, endereco, nome, cpf, rg, sexo, telefone, matricula, historico)
  VALUES (12345, 'Rua TB', 'Marco Aurélio da Silva', '111.111.111-11', '012.345.678.9', 'M', '8888-8888', '1410478300059', null);
INSERT INTO
  aluno  (aluno_id, endereco, nome, cpf, rg, sexo, telefone, matricula, historico)
  VALUES (23478, 'Rua QQ', 'Jefferson Luis', '333.333.333-33', '898.989.898.9', 'M', '2121-2121', '8234786234', null);
INSERT INTO
  aluno  (aluno_id, endereco, nome, sexo, telefone, matricula, historico, cpf, rg)
  VALUES (12346, 'Rua KLKL', 'Arthur Avilla', 'M', '9999-5588', '1310478300032', null, '555.555.555-55', '987.654.321.0');
INSERT INTO
  disciplina (nome, descricao, sigla, cargaHoraria)
  VALUES ('Algoritmo e Linguagem de Programação 1', 'Disciplina que ensina os fundamentos da programação.', 'AL1', 180.0);
INSERT INTO
  disciplina (nome, descricao, sigla, cargaHoraria)
  VALUES ('Algoritmo e Linguagem de Programação 2', 'Refinando o mindset de programador dos alunos.', 'AL2', 220.0);
INSERT INTO
  estagio (aluno, empresa, funcao, data, cancelado)
  VALUES (12346, 'TI Soluções', 'Suporte e Desenvolvimento', '2017-01-10', false);