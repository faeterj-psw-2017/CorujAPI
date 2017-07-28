package org.faeterj.apicoruja.coruja.controller.requestBody;

import javax.persistence.Column;

public class DisciplinaRequestBody {
	

	    public String nome;
	    public String sigla;
	    public Double cargaHoraria;
	    public String descricao;
		
	    public DisciplinaRequestBody () {
	    	
	    }
	    
	    public DisciplinaRequestBody(String nome, String sigla,
				Double cargaHoraria, String descricao) {
			super();
			this.nome = nome;
			this.sigla = sigla;
			this.cargaHoraria = cargaHoraria;
			this.descricao = descricao;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getSigla() {
			return sigla;
		}

		public void setSigla(String sigla) {
			this.sigla = sigla;
		}

		public Double getCargaHoraria() {
			return cargaHoraria;
		}

		public void setCargaHoraria(Double cargaHoraria) {
			this.cargaHoraria = cargaHoraria;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}


}
