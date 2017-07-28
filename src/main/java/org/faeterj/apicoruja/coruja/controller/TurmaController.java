package org.faeterj.apicoruja.coruja.controller;

// import java.util.List;

// import org.faeterj.apicoruja.coruja.controller.requestBody.TurmaRequestBody;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.model.entity.Desempenho;
import org.faeterj.apicoruja.coruja.service.AlunoService;
import org.faeterj.apicoruja.coruja.service.ProfessorService;
import org.faeterj.apicoruja.coruja.service.DesempenhoService;
import org.faeterj.apicoruja.coruja.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TurmaController {
	
	private ProfessorService  professorService;
    private TurmaService      turmaService;
    private AlunoService      alunoService;
    private DesempenhoService desempenhoService;

    @Autowired
    public TurmaController (
        TurmaService      turmaService,
        ProfessorService  professorService,
        AlunoService      alunoService,
        DesempenhoService desempenhoService
    ) {
        this.turmaService      = turmaService;
        this.professorService  = professorService;
        this.alunoService      = alunoService;
        this.desempenhoService = desempenhoService;
    }

}
