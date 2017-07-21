package org.faeterj.apicoruja.coruja.model.entity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.faeterj.apicoruja.coruja.model.repository.AlunoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlunoTest {

        @Before
        public void setUp ( ) throws Exception {

        }

        @Test
        public void aluno ( ) {
                String nome     = "Fulano da Silva";
                String telefone = "0000-0000";
                String endereco = "Avenida dos Pokémons";

                Aluno aluno = new Aluno (nome, telefone, endereco);

                assertThat (aluno.getNome ( ),     is (nome));
                assertThat (aluno.getTelefone ( ), is (telefone));
                assertThat (aluno.getEndereco ( ), is (endereco));
        }

}
