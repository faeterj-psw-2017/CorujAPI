package org.faeterj.apicoruja.coruja.service;
import org.faeterj.apicoruja.coruja.model.entity.Trabalho;

import java.util.List;
import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Professor;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.model.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;


public class TrabalhoService {
	private final TrabalhoRepository TrabalhoRepositorio;

	public TrabalhoService(TrabalhoRepository trabalhoRepositorio) {
		TrabalhoRepositorio = trabalhoRepositorio;
	}
	void init()
	{
	}
	public void salvarTrabalho(Trabalho trabalho)
	{
		TrabalhoRepositorio.save(trabalho);
	}
	public List<Trabalho> listarTrabalhos ( ) {
        return (List<Trabalho>) TrabalhoRepositorio.findAll();
	}
	public List<Trabalho>  encontrarTrabalhoPeloTitulo(String titulo)
	{
		return TrabalhoRepositorio.findByTitulo (titulo);
	}
	public List<Trabalho>  encontrarTrabalhoPeloAluno(Aluno aluno)
	{
		return TrabalhoRepositorio.findByAluno (aluno);
	}
	public List<Trabalho> encontrarTrabalhoPelaTurma(Turma turma)
	{
		return TrabalhoRepositorio.findByTurma (turma);
	}
	public Trabalho encontrarTrabalhoPeloId(long id)
	{
		return TrabalhoRepositorio.findById(id);
	}
}
