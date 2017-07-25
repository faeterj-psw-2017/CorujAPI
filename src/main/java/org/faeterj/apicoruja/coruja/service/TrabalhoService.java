package org.faeterj.apicoruja.coruja.service;
import org.faeterj.apicoruja.coruja.model.entity.Trabalho;

import java.util.List;

import org.faeterj.apicoruja.coruja.model.entity.Aluno;
import org.faeterj.apicoruja.coruja.model.entity.Turma;
import org.faeterj.apicoruja.coruja.model.repository.TrabalhoRepository;

public class TrabalhoService {
	private final TrabalhoRepository TrabalhoRepositorio;

	public TrabalhoService(TrabalhoRepository trabalhoRepositorio) {
		TrabalhoRepositorio = trabalhoRepositorio;
	}
	void init()
	{
	}
	void salvarTrabalho(Trabalho trabalho)
	{
		TrabalhoRepositorio.save(trabalho);
	}
	List<Trabalho>  encontrarTrabalhoPeloTitulo(String titulo)
	{
		return TrabalhoRepositorio.findByTitulo (titulo);
	}
	List<Trabalho>  encontrarTrabalhoPeloAluno(Aluno aluno)
	{
		return TrabalhoRepositorio.findByAluno (aluno);
	}
	List<Trabalho> encontrarTrabalhoPelaTurma(Turma turma)
	{
		return TrabalhoRepositorio.findByTurma (turma);
	}
}
