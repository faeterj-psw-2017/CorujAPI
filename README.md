# CorujAPI

[![Build Status](https://travis-ci.org/faeterj-psw-2017/CorujAPI.svg?branch=master)](https://travis-ci.org/faeterj-psw-2017/CorujAPI)


### Dependências

+ Java 8
+ Maven 3.x

---

### Comandos na linha de comando

Para todos aqueles que não possuem uma IDE devidamente configurada no trabalho, por exemplo,
segue uns comandos úteis para usar na linha de comando.

##### Instalação de dependências

        $ mvn install -DskipTests=true -Dmaven.javadoc.skip=true -B -V

##### Testando a aplicação

        $ mvn test

##### Rodando no localhost

        $ mvn spring-boot:run

---

### Cobertura de códigos

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

* 01 -- Dê um *Fork* nesse repositório da turma pra sua própria conta.
* 02 -- Dê um **git clone** em seu próprio Fork/projeto (e não baixe como ZIP, já que
  esse ignora o histórico do Git). Algumas IDEs possuem um mecanismo de importar do Git/GitHub
  também.
* 03 -- Importe tal clone em sua IDE (possivelmente configurando algumas coisas).
* 04 -- Rode os testes.
* 05 -- Rode a aplicação (que vai inicializar um servidor no http://localhost:8080).
* 06 -- Mande requests, por exemplo, pelo Postman do Chrome (OPCIONAL).
* 07 -- Dê um **git pull** pra URL do projeto da turma (e não pra URL do seu fork), só para
  verificar se alguém modificou alguma coisa.
* 08 -- Comece a escrever o que precisa/pode.
* 09 -- Dê um **git commit** sempre que puder para não perder seu trabalho,
  _mesmo em mudanças mínimas e/ou bobas_.
* 10 -- Faça a iteração escrever-"comitar" quantas vezes quiser.
* 11 -- Dê um **git push** (que vai pro seu fork no GitHub).
* 12 -- No seu fork, dê um Pull-Request (que vai rodar os testes de integração implicitamente).
* 13 -- Veja se há conflitos e se os testes passam na "thread" do P(ull-)R(equest).
* 14 -- Modifique os arquivos para resolver conflitos existentes. Testes não precisam passar, mas
  passarem é o ideal.
* 15 -- Dê _merge_ do seu Pull-Request ou espere outra pessoa dar o _merge_ por você.
* 16 -- Quando for voltar a programar novamente, pule pro passo 04 ou 07 (assumindo que seu clone
  vai ser "persistido" em seu Workspace, logo não há necessidade de começar do passo 01).
