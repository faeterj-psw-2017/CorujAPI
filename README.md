# CorujAPI

[![Build Status](https://travis-ci.org/faeterj-psw-2017/CorujAPI.svg?branch=master)](https://travis-ci.org/faeterj-psw-2017/CorujAPI)
[![codecov](https://codecov.io/gh/faeterj-psw-2017/CorujAPI/branch/master/graph/badge.svg)](https://codecov.io/gh/faeterj-psw-2017/CorujAPI)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/1ad00727a0ed47cd98a8bd603ff10971)](https://www.codacy.com/app/marcoonroad/CorujAPI_2?utm_source=github.com&utm_medium=referral&utm_content=faeterj-psw-2017/CorujAPI&utm_campaign=badger)

### Dependências

+ Java 8
+ Maven 3.x

---

### Contribuidores (PR e/ou commit)

+ Alexandre Fonseca - [@alexandre-layer](http://github.com/alexandre-layer)
+ Arthur Ávilla - [@arthuravilla7](http://github.com/arthuravilla7)
+ Bruno Bandeira - [@bandeirabruno](http://github.com/bandeirabruno)
+ Jefferson Luis - [@jtricolor16](http://github.com/jtricolor16)
+ Marco Aurélio - [@marcoonroad](http://github.com/marcoonroad)
+ Marcos Felipe - [@Marcos521](http://github.com/Marcos521)
+ William - [@Nibelung0](http://github.com/Nibelung0)
+ Rodrigo Sudano - [@SudaGaiden](http://github.com/SudaGaiden)

---

### Links

+ [Trello](https://trello.com/faeterjpsw2017noite)
+ [Heroku App](http://coruja-beta.herokuapp.com)

---

### Rotas

| Rota                   | Método | Corpo         | Resposta           |
| :--------------------- | -----: | :------------ | :----------------: |
| /professor             | GET    |               | [ professores... ] |
| /professor             | POST   | { professor } | boolean            |
| /professor/matricula/X | GET    |               | { professor }      |
| /professor/matricula/X | DELETE |               | boolean            |
| /professor             | PUT    | { professor } | boolean            |
| /professor/sexo/X      | GET    |               | [ professores... ] |
| /professor/endereco/X  | GET    |               | [ professores... ] |

Onde X é o valor associado a um atributo no banco.

---

| Rota                     | Método | Corpo     | Resposta      |
| :----------------------- | -----: | :-------- | :-----------: |
| /atcom                   | GET    |           | [ atcoms... ] |
| /atcom                   | POST   | { atcom } | { atcom }     |
| /atcom/PK-ID             | GET    |           | { atcom }     |
| /atcom/PK-ID             | DELETE |           | { atcom }     |
| /atcom/PK-ID             | PUT    | { atcom } | { atcom }     |
| /atcom/aluno/FK-ID       | GET    |           | [ atcoms... ] |
| /atcom/valido            | GET    |           | [ atcoms... ] |
| /atcom/invalido          | GET    |           | [ atcoms... ] |
| /atcom/validados/FK-ID   | GET    |           | [ atcoms... ] |
| /atcom/invalidados/FK-ID | GET    |           | [ atcoms... ] |

Onde PK-ID designa a chave da entidade no banco e FK-ID designa uma chave
estrangeira apontando pro aluno associado.

---

| Rota               | Método | Corpo     | Resposta      |
| :----------------- | -----: | :-------- | :-----------: |
| /aluno             | GET    |           | [ alunos... ] |
| /aluno             | POST   | { aluno } | boolean       |
| /aluno/matricula/X | DELETE |           | boolean       |
| /aluno/PK-ID       | DELETE |           | boolean       |
| /aluno             | PUT    | { aluno } | { aluno }     |
| /aluno/matricula/X | GET    |           | { aluno }     |
| /aluno/PK-ID       | GET    |           | { aluno }     |

---

| Rota      | Método | Corpo        | Resposta        |
| :-------- | -----: | :----------- | :-------------: |
| /trabalho | GET    |              | [ trabalho... ] |
| /trabalho | POST   | { trabalho } | boolean         |
| /trabalho | PUT    | { trabalho } | boolean         |
| /trabalho | DELETE |              | boolean         |

---

| Rota                   | Método | Corpo        | Resposta        |
| :--------------------- | -----: | :----------- | :-------------: |
| /turma                 | GET    |              | [ turmas... ]   |
| /turma/codigo/CODIGO   | GET    |              | { turma }       |
| /turma/turno/TURNO     | GET    |              | [ turmas... ]   |
| /turma                 | POST   | { turma }    | boolean         |
| /turma                 | DELETE | { turma }    | boolean         |
| /turma/codigo/CODIGO   | PUT    | { turma }    |                 |

---

| Rota                                  | Método | Corpo        | Resposta        |
| :------------------------------------ | -----: | :----------- | :-------------: |
| /estagio/cancelado                    | GET    |              | [ estagios... ] |
| /estagio/nao-cancelado                | GET    |              | [ estagios... ] |
| /estagio                              | GET    |              | [ estagios... ] |
| /estagio                              | POST   | { estagio }  | boolean         |
| /estagio/aluno/FK-ID                  | GET    |              | [ estagios... ] |
| /estagio/empresa/X                    | GET    |              | [ estagios... ] |
| /estagio/funcao/X                     | GET    |              | [ estagios... ] |
| /estagio/data-inicio/DATA             | GET    |              | [ estagios... ] |
| /estagio/data-inicio/antes/DATA       | GET    |              | [ estagios... ] |
| /estagio/data-inicio/depois/DATA      | GET    |              | [ estagios... ] |
| /estagio/data-inicio/entre/INICIO/FIM | GET    |              | [ estagios... ] |
| /estagio/data-fim/DATA                | GET    |              | [ estagios... ] |
| /estagio/data-fim/depois/DATA         | GET    |              | [ estagios... ] |
| /estagio/data-fim/antes/DATA          | GET    |              | [ estagios... ] |
| /estagio/data-fim/entre/INICIO/FIM    | GET    |              | [ estagios... ] |
| /estagio/horas/HORAS                  | GET    |              | [ estagios... ] |
| /estagio/horas/acima/HORAS            | GET    |              | [ estagios... ] |
| /estagio/horas/abaixo/HORAS           | GET    |              | [ estagios... ] |
| /estagio/horas/entre/MIN/MAX          | GET    |              | [ estagios... ] |
| /estagio                              | PUT    | { estagio }  | { estagio }     |
| /estagio/PK-ID                        | DELETE |              |                 |

---

| Rota                                | Método | Corpo | Resposta          |
| :---------------------------------- | -----: | :---- | :---------------: |
| /desempenho                         | GET    |       | [ desempenho... ] |
| /desempenho/ID                      | GET    |       | desempenho        |
| /desempenho/turma/FK-ID             | GET    |       | [ desempenho... ] |
| /desempenho/aluno/FK-ID             | GET    |       | [ desempenho... ] |
| /desempenho/turma/FK-ID/media       | GET    |       | double            |
| /desempenho/aluno/FK-ID/media       | GET    |       | double            |
| /desempenho/turma/FK-ID/media-final | GET    |       | double            |
| /desempenho/aluno/FK-ID/media-final | GET    |       | double            |
| /desempenho/ID                      | DELETE |       | { desempenho }    |
| /desempenho/{ID}/AV1/{NOTA}         | PUT    |       | boolean           |
| /desempenho/{ID}/AV2/{NOTA}         | PUT    |       | boolean           |
| /desempenho/{ID}/AVS/{NOTA}         | PUT    |       | boolean           |
| /desempenho/{ID}/AVF/{NOTA}         | PUT    |       | boolean           |

---

| Rota                            | Método | Corpo          | Resposta           |
| :------------------------------ | -----: | :------------- | :----------------: |
| /disciplina/sigla/SIGLA         | DELETE |                | { disciplina }     |
| /disciplina                     | GET    |                | [ disciplinas... ] |
| /disciplina                     | POST   | { disciplina } | { disciplina }     |
| /disciplina/nome/NOME           | GET    |                | [ disciplinas... ] |
| /disciplina/carga-horaria/CARGA | GET    |                | [ disciplinas... ] |
| /disciplinas/descricao/DESCR    | GET    |                | [ disciplinas... ] |
| /disciplinas/sigla/SIGLA        | GET    |                | { disciplina }     |
| /disciplina                     | PUT    | { disciplina } | { disciplina }     |
|

---

##### Endpoints dos Repositórios (com paginação)

+ /aluno-page
+ /turma-page
+ /professor-page
+ /disciplina-page
+ /desempenho-page
+ /atcom-page
+ /trabalho-page
+ /estagio-page

---

### Comandos na linha de comando

Para todos aqueles que não possuem uma IDE devidamente configurada no trabalho, por exemplo,
segue uns comandos úteis para usar na linha de comando.

##### Instalação de dependências

        $ mvn install -DskipTests=true -Dmaven.javadoc.skip=true -B -V

Ou simplesmente:

        $ mvn clean install

##### Testando a aplicação

        $ mvn test

##### Rodando no localhost

        $ mvn spring-boot:run

---

### Cobertura de códigos (Não é importante!)

O pom.xml também possui configurações pra plugins de _code coverage_. As ações de
build do Maven operam sob a pasta "target", enquanto o cache dos pacotes vai sendo
escrito em "$HOME/.m2" (assumindo o Unix aqui, mas o cache não é relevante pro
escopo dessa aplicação). É possível que uma ou outra IDE tenha suporte pra cobertura
de códigos, mas sempre dá pra usar a linha de comando como último recurso pra gerar
tais relatórios de coverage.

**IMPORTANTE**: não é necessário gerar tais relatórios, eles são opcionais para ver
o seu progresso. Eles estão configurados apenas para ferramentas de Integração Contínua
do GitHub.

##### Com "Cobertura"

        $ mvn cobertura:cobertura

Aonde o HTML resultante está localizado em:

* target/site/cobertura/index.html (pra Unix)
* target\site\cobertura\index.html (pra Windows)

##### Com "JaCoCo"

        $ mvn jacoco:report

Aonde o HTML resultante está localizado em:

* target/site/jacoco/index.html (pra Unix)
* target\site\jacoco\index.html (pra Windows)

---

### Desenvolvimento no GitHub

* 01 -- Crie um branch no projeto da turma relativo aos seus futuros trabalhos. Tal branch pode
  ter o seu nome de usuário (por exemplo, _fulano_ ou _cicrano_), ou pode também carregar o nome
  do papel que você vai desempenhar aqui, por exemplo, _turma-controller_ ou só _turma_ mesmo.
  Certifique-se antes que tal branch não existe e que ele possui o branch _master_ (ou seja, o
  principal) como base pro seu branch. Após criado o branch, fork o projeto da turma em sua
  própria conta.
* 02 -- Dê um **git clone** em seu próprio Fork/projeto (e não baixe como ZIP, já que
  esse ignora o histórico do Git). Algumas IDEs possuem um mecanismo de importar do Git/GitHub
  também.
* 03 -- Importe tal clone em sua IDE (possivelmente configurando algumas coisas). Adicione também
  uma upstream apontando pro projeto da turma (e não o seu fork). Na linha de comando do git, isso
  pode ser feito assim:

        $ git remote add upstream https://github.com/faeterj-psw-2017/CorujAPI.git

* 04 -- Rode os testes.
* 05 -- Rode a aplicação (que vai inicializar um servidor no http://localhost:8080).
* 06 -- Mande requests, por exemplo, pelo Postman do Chrome (OPCIONAL).
* 07 -- Dê um **git fetch upstream** só para verificar se alguém modificou alguma coisa e então
  estar a par dessas mudanças.
* 08 -- Aqui você já pode começar a escrever o que precisa/pode. Mas antes, certifique-se que você
  está em seu próprio branch dedicado. Na linha de comando, você pode ver em qual branch está com:
  
        $ git branch -va

  Caso você esteja em outro branch qualquer, mude para o seu branch com:
  
        $ git checkout O-NOME-QUE-VOCE-DEU-PRO-SEU-BRANCH

  Se estiver tudo OK, comece a programar sem problemas. ~~**IMPORTANTE**: Se você está designado pra
  algum controller, entre em contato com o @rt3norio ou @marcoonroad para saber se o respectivo
  repository/entity/model do seu controller foi implementado. Se não, peça pra estas pessoas implementarem
  o seu repository. Se este já foi implementado, dê um merge (em seu atual branch) passando _upstream/model_
  (a upstream frequentemente contém códigos mais atualizados do que sua _origin_, ou seja, seu fork).~~ O branch
  _model_ já foi mergeado no _master_, então um merge da _upstream/master_ é suficiente.

* 09 -- Dê um **git commit -m "QUALQUER-MENSAGEM-DESCREVENDO-O-COMMIT"** sempre que puder para não
  perder seu trabalho, _mesmo em mudanças mínimas e/ou bobas_ (antes, certifique-se que os arquivos
  modificados são "trackeados" com **git add**).
* 10 -- Faça a iteração escrever-"comitar" quantas vezes quiser.
* 11 -- Dê um **git push** (que vai pro seu fork no GitHub).
* 12 -- No seu fork, dê um Pull-Request (que vai rodar os testes de integração implicitamente). Lembre-se
  que tal Pull-Request tem que ser do seu próprio branch pro branch associado da turma. Se na turma não
  há um branch com o mesmo nome que o seu do seu clone, crie um branch com tal nome na turma também.
* 13 -- Veja se há conflitos e se os testes passam na "thread" do P(ull-)R(equest).
* 14 -- Modifique os arquivos para resolver conflitos existentes. Testes não precisam passar, mas
  passarem é o ideal.
* 15 -- Dê _merge_ do seu Pull-Request ou espere outra pessoa dar o _merge_ por você.
* 16 -- Quando for voltar a programar novamente, pule pro passo 04 ou 07 (assumindo que seu clone
  vai ser "persistido" em seu Workspace, logo não há necessidade de começar do passo 01).

---

### Configuração do Banco (Importante!)

Pra configurar o banco, você precisa criar um arquivo "src/main/resources/application.properties". Tal
arquivo vai indicar pro Spring qual driver de Banco de Dados você vai usar. Existe um template aqui
nesse projeto, onde o padrão é usando o PostgreSQL. O padrão já está definido pro usuário "postgres"
sem nenhuma senha, e pra URL também, sendo no "localhost", porta "5432", se conectando ao banco chamado
"coruja". Tal padrão é devido ao uso do PostgreSQL no serviço de testes de integração do Travis-CI.

Vale lembrar que você sempre pode configurar tal arquivo, por exemplo, pra se conectar a um outro Driver
de banco. Não esqueça de definir sua própria senha e usuário em seu _clone local_ pra se conectar se precisar.
Lembrando que, uma vez configurado este arquivo na sua máquina, você tem que guardar o backup do anterior
e desse seu application.properties modificado. Estes backups podem estar guardados em uma pasta chamada
"prop-backups", a qual o ".gitignore" não irá detectá-los devido a entrada dessa pasta em tal _black-list_.
Antes de commitar, lembre-se de manter o application.properties original em "src/main/resources/application.properties".
Não serão aceitas modificações nesse arquivo aqui do projeto, mas nada te impede de modificá-lo em seu fork
e quando for dar o Pull-Request, colocar o original no lugar. Tal regra é pra evitar colisões de configurações
com outros forks e com o serviço do Travis.

__NOTA__: Não há necessidade de criar os esquemas do banco do Postgre, o Hibernate automaticamente já popula o
banco com esses esquemas. Como esse Coruja ainda está em fase de desenvolvimento inicial e os esquemas irão mudar
frequentemente, o application.properties define uma regra de popular os esquemas quando a aplicação é inicializada
e/ou finalizada, para logo depois, "dropar" todas as tabelas por ele criadas ao término da aplicação.
