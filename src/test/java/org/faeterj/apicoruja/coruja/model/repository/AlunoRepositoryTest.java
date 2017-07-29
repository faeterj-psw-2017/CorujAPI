package org.faeterj.apicoruja.coruja.model.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

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
                String nome = "Jefferson Luis";
                
                List<Aluno> alunos = repository.findByNome (nome);
                
                assertThat (alunos.size ( ), is (1));
        }

        @Test
        public void findByMatricula ( ) {
                String nome     = "Marco Aurélio da Silva";
                String endereco = "Rua TB";
                String telefone = "8888-8888";

                Aluno aluno = repository.findByMatricula ("1410478300059");

                assertThat (aluno.getNome ( ),     is (nome));
                assertThat (aluno.getEndereco ( ), is (endereco));
                assertThat (aluno.getTelefone ( ), is (telefone));
        }

}
