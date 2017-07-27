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

    @PostConstruct
    public void init(){
        Aluno aluno = new Aluno();
        aluno.setId(1);

        Date data = new Date(2017, 1, 10);

        System.out.println("Criado exemplo de Estagio...");
        Estagio e = new Estagio( 1, aluno, "TI Soluções", "Suporte e Desenvolvimento", data );

        repo.save(e);
    }

    public List<Estagio> obterEstagios() {
        Iterator it = repo.findAll().iterator(); // De Repository para Iterator
        return IteratorUtils.toList(it); // De Iterator para List
    }

    public Estagio adicionarEstagio(Aluno aluno, String empresa, String funcao, Date dataInicio) {
        long id = 0L;
        List<Estagio> estagios = this.obterEstagios();
        for (Estagio e : estagios) {
            if (e.getId() > id) {
                id = e.getId();
            }
        }
        id++;
        Estagio e = new Estagio(id, aluno, empresa, funcao, dataInicio );
        repo.save(e);
        return e;
    }

    public Estagio adicionarEstagio(Aluno aluno, String empresa, String funcao, Date dataInicio, Date dataFim) {
        Estagio e = this.adicionarEstagio(aluno, empresa, funcao, dataInicio);
        e.setDataFim(dataFim);
        repo.save(e);
        return e;
    }

    public Estagio adicionarEstagio(Aluno aluno, String empresa, String funcao, Date dataInicio, Date dataFim, float horas) {
        Estagio e = this.adicionarEstagio(aluno, empresa, funcao, dataInicio, dataFim);
        e.setHoras(horas);
        repo.save(e);
        return e;
    }

    public Estagio obterEstagioPorID(Long id) {
        return repo.findOne(id);
    }

    public List<Estagio> obterEstagioPorAluno(Aluno aluno) {
        return repo.findByAluno(aluno);
    }

    public List<Estagio> obterEstagioPorEmpresa(String empresa) {
        return repo.findByEmpresaIgnoreCaseContaining(empresa);
    }

    public List<Estagio> obterEstagioPorFuncao(String funcao) {
        return repo.findByFuncaoIgnoreCaseContaining(funcao);
    }

    public List<Estagio> obterEstagioPorDataInicio(Date data) {
        return repo.findByDataInicio(data);
    }

    public List<Estagio> obterEstagioIniciadoAPartirDe(Date data) {
        return repo.findByDataInicioGreaterThanEqual(data);
    }

    public List<Estagio> obterEstagioIniciadoAte(Date data) {
        return repo.findByDataInicioLessThanEqual(data);
    }

    public List<Estagio> obterEstagioIniciadoEntre(Date dataInicial, Date dataFinal) {
        return repo.findByDataInicioBetween(dataInicial, dataFinal);
    }

    public List<Estagio> obterEstagioPorDataFim(Date data) {
        return repo.findByDataFim(data);
    }

    public List<Estagio> obterEstagioTerminadoAPartirDe(Date data) {
        return repo.findByDataFimGreaterThanEqual(data);
    }

    public List<Estagio> obterEstagioTerminadoAte(Date data) {
        return repo.findByDataFimLessThanEqual(data);
    }

    public List<Estagio> obterEstagioTerminadoEntre(Date dataInicial, Date dataFinal) {
        return repo.findByDataFimBetween(dataInicial, dataFinal);
    }

    public List<Estagio> obterEstagioPorHoras(float horas) {
        return repo.findByHoras(horas);
    }

    public List<Estagio> obterEstagioPorHorasAcimaDe(float horas) {
        return repo.findByHorasGreaterThanEqual(horas);
    }

    public List<Estagio> obterEstagioPorHorasAbaixoDe(float horas) {
        return repo.findByHorasLessThanEqual(horas);
    }

    public List<Estagio> obterEstagioPorHorasEntre(float horasMinimo, float horasMaximo) {
        return repo.findByHorasBetween(horasMinimo, horasMaximo);
    }

    public void alterarEstagio(Estagio e) {
        repo.save(e);
    }

    public void removerEstagio(Estagio e) {
        repo.delete(e.getId());
    }
}
