package org.faeterj.apicoruja.coruja.model.entity;

import java.io.File;
import javax.persistence.*;

@Table(name="atcom")
@Entity
public class ATCOM {
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name="atcom_id")
        @Id
        private long id;

        @Column(name="foto")
        private File foto;

        @Column(name="descricao_documento")
        private String descricaoDocumento;

        @Column(name="horas_atribuidas")
        private double horasAtribuidas;

        @Column(name="valido")
        private boolean valido;

        // ==================================

        protected ATCOM ( ) {
        }

        public ATCOM (
                long id,                   File foto,
                String descricaoDocumento, double horasAtribuidas,
                boolean valido
        ) {
                this.id                 = id;
                this.foto               = foto;
                this.descricaoDocumento = descricaoDocumento;
                this.horasAtribuidas    = horasAtribuidas;
                this.valido             = valido;
        }

        // ==================================================================
  
	public long getId ( ) {
		return id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	// -----------------------------------------------------------------
	
	public File getFoto ( ) {
		return foto;
	}
	
	public void setFoto (File foto) {
		this.foto = foto;
	}
	
	//------------------------------------------------------------------
	
	public String getDescricaoDocumento ( ) {
		return descricaoDocumento;
	}
	
	public void setDescricaoDocumento (String descricaoDocumento) {
		this.descricaoDocumento = descricaoDocumento;
	}
	
	//------------------------------------------------------------------
	
	public double getHorasAtribuidas ( ) {
		return horasAtribuidas;
	}
	
	public void setHorasAtribuidas (double horasAtribuidas) {
		this.horasAtribuidas = horasAtribuidas;
	}
	
	//-------------------------------------------------------------------
	
	public boolean isValido ( ) {
		return valido;
	}
	
	public void setValido (boolean valido) {
		this.valido = valido;
	}

}

// OK
