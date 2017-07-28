package org.faeterj.apicoruja.coruja.model.repository;

import java.util.Date;
import java.util.List;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Estagio;

@Repository
public interface EstagioRepository extends
    PagingAndSortingRepository<Estagio, Long> {

    /*
    	findBy:     - encontrar
    	IgnoreCase: - ignorar se é caixa alta ou baixa
    	Containing: - que contenha um texto, ou seja, não precisa ser exatamente o texto
    */

    List<Estagio> findByAluno                       (Aluno aluno);
    List<Estagio> findByEmpresaIgnoreCaseContaining (String empresa);
    List<Estagio> findByFuncaoIgnoreCaseContaining  (String funcao);
    List<Estagio> findByDataInicio                  (Date data);
    List<Estagio> findByDataInicioGreaterThanEqual  (Date data);
    List<Estagio> findByDataInicioLessThanEqual     (Date data);
    List<Estagio> findByDataInicioBetween           (Date dataInicial, Date dataFinal);
    List<Estagio> findByDataFim                     (Date data);
    List<Estagio> findByDataFimGreaterThanEqual     (Date data);
    List<Estagio> findByDataFimLessThanEqual        (Date data);
    List<Estagio> findByDataFimBetween              (Date dataInicial, Date dataFinal);
    List<Estagio> findByHoras                       (float horas);
    List<Estagio> findByHorasGreaterThanEqual       (float horas);
    List<Estagio> findByHorasLessThanEqual          (float horas);
    List<Estagio> findByHorasBetween                (float horasInicio, float horasFim);
    List<Estagio> findByCancelado                   (boolean cancelado);

}

// OK