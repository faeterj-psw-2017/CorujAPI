package org.faeterj.apicoruja.coruja.controller.requestBody;

public class TrabalhoRequestBody {
    private Long id;
    private String titulo;
    private String turma; //verificar
    private String aluno; // verificar
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getAluno() {
		return aluno;
	}
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	

}
