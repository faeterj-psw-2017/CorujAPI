package org.faeterj.apicoruja.coruja.model.repository;

import java.util.Date;
import java.util.List;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.faeterj.apicoruja.coruja.model.entity.Estagio;

@Repository
@RepositoryRestResource(path="/estagio-page")
public interface EstagioRepository extends
    PagingAndSortingRepository<Estagio, Long> {

    /*
    	findBy:     - encontrar
    	IgnoreCase: - ignorar se é caixa alta ou baixa
    	Containing: - que contenha um texto, ou seja, não precisa ser exatamente o texto
    */

    List<Estagio> findByAluno                       (@Param("aluno")   		Aluno   aluno);
    List<Estagio> findByEmpresaIgnoreCaseContaining (@Param("empresa") 		String  empresa);
    List<Estagio> findByFuncaoIgnoreCaseContaining  (@Param("funcao")  		String  funcao);
    List<Estagio> findByDataInicio                  (@Param("data")    		Date    data);
    List<Estagio> findByDataInicioGreaterThanEqual  (@Param("data")    		Date    data);
    List<Estagio> findByDataInicioLessThanEqual     (@Param("data")    		Date    data);
    List<Estagio> findByDataInicioBetween           (@Param("data_inicial") Date    dataInicial, @Param("data_final") Date dataFinal);
    List<Estagio> findByDataFim                     (@Param("data") 		Date    data);
    List<Estagio> findByDataFimGreaterThanEqual     (@Param("data") 		Date    data);
    List<Estagio> findByDataFimLessThanEqual        (@Param("data")         Date    data);
    List<Estagio> findByDataFimBetween              (@Param("data_inicial") Date    dataInicial, @Param("data_final") Date dataFinal);
    List<Estagio> findByHoras                       (@Param("horas")        float   horas);
    List<Estagio> findByHorasGreaterThanEqual       (@Param("horas")        float   horas);
    List<Estagio> findByHorasLessThanEqual          (@Param("horas")        float   horas);
    List<Estagio> findByHorasBetween                (@Param("horas_inicio") float   horasInicio, @Param("horas_fim") float horasFim);
    List<Estagio> findByCancelado                   (@Param("cancelado")    boolean cancelado);

	// --------------------------------------------------

	@Override
	@RestResource(exported=false)
	void delete (Long id);

	@Override
	@RestResource(exported=false)
	void delete (Estagio estagio);

	@Override
	@RestResource(exported=false)
	Estagio save (Estagio estagio);
	
}

// OK