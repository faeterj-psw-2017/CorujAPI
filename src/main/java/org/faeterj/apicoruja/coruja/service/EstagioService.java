package org.faeterj.apicoruja.coruja.service;

/**
 * Created with IntelliJ IDEA.
 * User: Marcos Felipe
 * Date: 21/07/17
 * Time: 10:51
 * To change this template use File | Settings | File Templates.
 */

import org.apache.commons.collections.IteratorUtils;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Estagio;
import org.faeterj.apicoruja.coruja.model.repository.EstagioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class EstagioService {

    @Autowired
    private EstagioRepository repo;

    @Autowired
    public EstagioService (EstagioRepository repo) {
        this.repo = repo;
    }

    @PostConstruct
    public void init(){
        /*
        Aluno aluno = new Aluno();
        aluno.setId(5L);
        aluno.setMatricula("13");
        aluno.setNome("Mario");

        Date data = new Date(2017, 1, 10);

        System.out.println("Criado exemplo de Estagio...");
        Estagio e = new Estagio( 1, aluno, "TI Soluções", "Suporte e Desenvolvimento", data );

        repo.save(e);
        */
    }

    public List<Estagio> obterEstagios() {
        Iterator it = repo.findAll().iterator(); // De Repository para Iterator
        return IteratorUtils.toList(it); // De Iterator para List
    }

    public Estagio adicionarEstagio(Aluno aluno, String empresa, String funcao, Date data) {
        long id = 0L;
        List<Estagio> estagios = this.obterEstagios();
        for (Estagio e : estagios) {
            if (e.getId() > id) {
                id = e.getId();
            }
        }
        id++;
        Estagio e = new Estagio(id, aluno, empresa, funcao, data );
        repo.save(e);
        return e;
    }

}
