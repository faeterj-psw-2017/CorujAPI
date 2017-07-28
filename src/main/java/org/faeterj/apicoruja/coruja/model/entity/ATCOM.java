package org.faeterj.apicoruja.coruja.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.File;
import javax.persistence.*;

@Table(name="atcom")
@Entity
public class ATCOM {

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="atcom_id")
    @Id
    private Long id;

    @Column(name="foto")
    private File foto;

    @Column(name="descricao_documento")
    private String descricaoDocumento;

    @Column(name="horas_atribuidas")
    private double horasAtribuidas;

    @Column(name="valido")
    private boolean valido;

    @ManyToOne(optional=false)
    @JoinColumn(name                 = "aluno",
                referencedColumnName = "aluno_id",
                nullable             = true)
    private Aluno aluno;

    // =============================================

    public ATCOM ( ) {

    }

    public ATCOM (
        File foto,
        String descricaoDocumento, double horasAtribuidas,
        boolean valido
    ) {
        this.foto               = foto;
        this.descricaoDocumento = descricaoDocumento;
        this.horasAtribuidas    = horasAtribuidas;
        this.valido             = valido;
    }

    // ==================================================================
  
    @JsonIgnore
	public Long getId ( ) {
	    return id;
	}
	
	public void setId (Long id) {
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

    // ----------------------------------------------------

    public Aluno getAluno ( ) {
        return aluno;
    }

    public void setAluno (Aluno aluno) {
        this.aluno = aluno;
    }

}

// OK
