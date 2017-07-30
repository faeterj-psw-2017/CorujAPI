package org.faeterj.apicoruja.coruja.controller.requestBody;

// foto não aparece pois o upload do arquivo será
// feito em uma outro request, sendo provavelmente
// em uma conexão aberta/persistida...
public final class ATCOMRequestBody {
	
	public Long             id;
	public String           descricao;
	public double           horasAtribuidas;
	public boolean          valido;
	public AlunoRequestBody aluno;
}

// OK