package org.faeterj.apicoruja.coruja.controller.requestBody;

/**
 * Created by William Lemos on 23/07/17.
 */
public class TurmaRequestBody {

    public String codigo;
    public String sala;
    public char turno;
    
    public TurmaRequestBody () {
    	
    }
    
    
	public TurmaRequestBody(String codigo, String sala, char turno) {
		super();
		this.codigo = codigo;
		this.sala = sala;
		this.turno = turno;
	}


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
	
	public char getTurno() {
		return turno;
	}
	
	public void setTurno(char turno) {
		this.turno = turno;
	}

    
    
}
