# CorujAPI

[![Build Status](https://travis-ci.org/faeterj-psw-2017/CorujAPI.svg?branch=master)](https://travis-ci.org/faeterj-psw-2017/CorujAPI)

### Dependências

+ Java 8
+ Maven 3.x

### Comandos na linha de comando

Para todos aqueles que não possuem uma IDE devidamente configurada no trabalho, por exemplo,
segue uns comandos úteis para usar na linha de comando.

##### Instalação de dependências

        $ mvn install -DskipTests=true -Dmaven.javadoc.skip=true -B -V

##### Testando a aplicação

        $ mvn test

##### Rodando no localhost

        $ mvn spring-boot:run
