package org.faeterj.apicoruja.coruja.controller.requestBody;


/**
 * Created by Gabriel Capanema on 23/06/17.
 */
public class TurmaRequestBody {

	private String codigo;

	private String sala;

	private String turno;
	
	private String matricula;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	

}
