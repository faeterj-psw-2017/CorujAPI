INSERT INTO
  professor (professor_id, endereco, nome, cpf, rg, sexo, telefone, matricula)
  VALUES    (001, 'Rua XYZ', 'André Neves', '999.999.999-99', '777.777.777.7', 'M', '2525-2525', '638228832871');
INSERT INTO
  professor (professor_id, endereco, nome, cpf, rg, sexo, telefone, matricula)
  VALUES    (002, 'Rua ABC', 'Márcio Belo', '222.222.222-22', '666.666.666.6', 'M', '4444-4444', '287367637856');
INSERT INTO
  professor (professor_id, endereco, nome, cpf, rg, sexo, telefone, matricula)
  VALUES    (003, 'Rua Qual mesma', 'Rosângela', '237652323221', '948796', 'F', '1212-2121', '937983786738');
INSERT INTO
  professor (professor_id, endereco, nome, cpf, rg, sexo, telefone, matricula)
  VALUES    (004, 'Rua do Matemático', 'Cláudio Bispo', '267726', '385891', 'M', '9393-3939', '12249849138');
INSERT INTO
  professor (professor_id, endereco, nome, cpf, rg, sexo, telefone, matricula)
  VALUES    (005, 'Rua do Zoeiro', 'José Wilson', '5989238', '0532319', 'M', '9128-7984', '0302353835');
INSERT INTO
  professor (professor_id, endereco, nome, cpf, rg, sexo, telefone, matricula)
  VALUES    (006, 'Rua do Zoado', 'Miguel', '2389487', '987314', 'M', '3443-4334', '29872871');
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
  aluno  (aluno_id, endereco, nome, sexo, telefone, matricula, historico, cpf, rg)
  VALUES (004, 'Rua Desconhecida', 'Alexandre Fonseca', 'M', '8585-5858', '82347261876', null, 'ABC', 'CDF');
INSERT INTO
  aluno  (aluno_id, endereco, nome, sexo, telefone, matricula, historico, cpf, rg)
  VALUES (005, 'Rua FBI', 'Rodrigo Sudano', 'M', '3232-3232', '2387486', null, 'QQCOISA', 'AJEITAR-DPS');
INSERT INTO
  aluno  (aluno_id, endereco, nome, sexo, telefone, matricula, historico, cpf, rg)
  VALUES (006, 'Rua CSI', 'William', 'M', '7979-7979', '887236', null, 'ISSO-NAO-VAI-EM-PROD', 'TODO-FIXME');
INSERT INTO
  aluno  (aluno_id, endereco, nome, sexo, telefone, matricula, historico, cpf, rg)
  VALUES (007, 'Rua WXYZ', 'Marcos Felipe', 'M', '9595-5959', '04282971991', null, 'XXXXXXX', 'YYYYYYYY');
INSERT INTO
  aluno  (aluno_id, endereco, nome, sexo, telefone, matricula, historico, cpf, rg)
  VALUES (008, 'Rua N', 'Bruno Bandeira', 'M', '4141-1414', '275891074334874', null, '2039059191', '07278932187');
INSERT INTO
  disciplina (disciplina_id, nome, descricao, sigla, carga_horaria)
  VALUES     (001, 'Algoritmo e Linguagem de Programação 1', 'Disciplina que ensina os fundamentos da programação.', 'AL1', 180.0);
INSERT INTO
  disciplina (disciplina_id, nome, descricao, sigla, carga_horaria)
  VALUES     (002, 'Algoritmo e Linguagem de Programação 2', 'Refinando o mindset de programador dos alunos.', 'AL2', 220.0);
INSERT INTO
  disciplina (disciplina_id, nome, descricao, sigla, carga_horaria)
  VALUES     (003, 'Técnicas de Relacionamento Interpessoal', 'Matéria pra fechar o curriculo escolar.', 'TRI', 500.20);
INSERT INTO
  disciplina (disciplina_id, nome, descricao, sigla, carga_horaria)
  VALUES     (004, 'Produção de Software', 'Alunos se tornam aptos a trabalhar em equipe no mercado de TI.', 'PSW', 300.0);
INSERT INTO
  estagio (estagio_id, aluno, empresa, funcao, data_inicio, cancelado)
  VALUES  (001, 003, 'TI Soluções', 'Suporte e Desenvolvimento', '2017-01-10', false);
INSERT INTO
  estagio (estagio_id, aluno, empresa, funcao, data_inicio, cancelado)
  VALUES  (002, 002, 'Empresa na Barra', 'Java Backend', '2017-03-05', false);
INSERT INTO
  turma  (turma_id, codigo, sala, turno, disciplina, professor, ano, semestre)
  VALUES (100, 'PSW', '4', 'N', 004, 001, 2017, 'A');
INSERT INTO
  turma  (turma_id, codigo, sala, turno, disciplina, professor, ano, semestre)
  VALUES (101, 'ALG', '2', 'M', 001, 002, 2016, 'B');
INSERT INTO
  desempenho (desempenho_id, turma, aluno, nota_av1, nota_av2, nota_avs, nota_avf, segunda_chamada, recuperacao)
  VALUES     (001, 100, 001, 6.7, 10.0, null, null, false, false);
INSERT INTO
  desempenho (desempenho_id, turma, aluno, nota_av1, nota_av2, nota_avs, nota_avf, segunda_chamada, recuperacao)
  VALUES     (002, 100, 002, 7.8, 10.0, null, null, false, false);
INSERT INTO
  desempenho (desempenho_id, turma, aluno, nota_av1, nota_av2, nota_avs, nota_avf, segunda_chamada, recuperacao)
  VALUES     (003, 100, 003, 7.5, 10.0, null, null, false, false);
INSERT INTO
  desempenho (desempenho_id, turma, aluno, nota_av1, nota_av2, nota_avs, nota_avf, segunda_chamada, recuperacao)
  VALUES     (004, 100, 004, 8.1, 10.0, null, null, false, false);
INSERT INTO
  desempenho (desempenho_id, turma, aluno, nota_av1, nota_av2, nota_avs, nota_avf, segunda_chamada, recuperacao)
  VALUES     (005, 100, 005, 7.9, 10.0, null, null, false, false);
INSERT INTO
  desempenho (desempenho_id, turma, aluno, nota_av1, nota_av2, nota_avs, nota_avf, segunda_chamada, recuperacao)
  VALUES     (006, 100, 006, 9.1, 10.0, null, null, false, false);
INSERT INTO
  trabalho (trabalho_id, turma, aluno, titulo)
  VALUES   (001, 100, 001, 'Corujão 2.0');
INSERT INTO
  trabalho (trabalho_id, turma, aluno, titulo)
  VALUES   (002, 100, 002, 'Corujão 2.0');
INSERT INTO
  atcom  (atcom_id, foto, descricao, horas_atribuidas, valido, aluno)
  VALUES (001, null, 'Fui a uma convenção de TI.', 3.50, true, 001);
INSERT INTO
  atcom  (atcom_id, foto, descricao, horas_atribuidas, valido, aluno)
  VALUES (002, null, 'Assisti palestras na semana tecnológica do IST.', 15.0, true, 002);
INSERT INTO
  atcom  (atcom_id, foto, descricao, horas_atribuidas, valido, aluno)
  VALUES (003, null, 'Pfvr aceita esse documento nunca te pedi nada.', 30, false, 001);
INSERT INTO
  atcom  (atcom_id, foto, descricao, horas_atribuidas, valido, aluno)
  VALUES (004, null, 'Fiz uma oficina de Arduino no IST.', 12.0, true, 003);
INSERT INTO
  atcom  (atcom_id, foto, descricao, horas_atribuidas, valido, aluno)
  VALUES (005, null, 'Fui pra baladinha top.', 6.0, false, 004);