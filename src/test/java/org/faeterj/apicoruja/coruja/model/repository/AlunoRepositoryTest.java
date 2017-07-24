package org.faeterj.apicoruja.coruja.model.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlunoRepositoryTest {

        private AlunoRepository repository;

        @Autowired
        public void setAlunoRepository (AlunoRepository repository) {
            this.repository = repository;
        }

        @Before
        public void setUp ( ) throws Exception {

        }

        @Test
        public void findByNome ( ) {
                assertThat (true, is (true));
        }

        @Test
        public void findOne ( ) {
                String nome     = "Marco Aurélio da Silva";
                String endereco = "Rua TB";
                String telefone = "8888-8888";

                Aluno aluno = repository.findOne (12345L);

                assertThat (aluno.getNome ( ),     is (nome));
                assertThat (aluno.getEndereco ( ), is (endereco));
                assertThat (aluno.getTelefone ( ), is (telefone));
        }

}
