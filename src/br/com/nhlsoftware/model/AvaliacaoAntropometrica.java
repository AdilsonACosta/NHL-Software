package br.com.nhlsoftware.model;

import java.util.Date;

public class AvaliacaoAntropometrica {

	private Long id;
	private Date dataAvalicaoAntropometrica;
	private String peso;
	private String altura;
	private String imc;
	private String classificacaoImc;
	private String pesoTeoricoMinimo;
	private String pesoTeoricoMedio;
	private String pesoTeoricoMaximo;
	private String circunferenciaAbdominal;
	private String classificacaoCircAbdominal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAvalicaoAntropometrica() {
		return dataAvalicaoAntropometrica;
	}

	public void setDataAvalicaoAntropometrica(Date dataAvalicaoAntropometrica) {
		this.dataAvalicaoAntropometrica = dataAvalicaoAntropometrica;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getImc() {
		return imc;
	}

	public void setImc(String imc) {
		this.imc = imc;
	}

	public String getClassificacaoImc() {
		return classificacaoImc;
	}

	public void setClassificacaoImc(String classificacaoImc) {
		this.classificacaoImc = classificacaoImc;
	}

	public String getPesoTeoricoMinimo() {
		return pesoTeoricoMinimo;
	}

	public void setPesoTeoricoMinimo(String pesoTeoricoMinimo) {
		this.pesoTeoricoMinimo = pesoTeoricoMinimo;
	}

	public String getPesoTeoricoMedio() {
		return pesoTeoricoMedio;
	}

	public void setPesoTeoricoMedio(String pesoTeoricoMedio) {
		this.pesoTeoricoMedio = pesoTeoricoMedio;
	}

	public String getPesoTeoricoMaximo() {
		return pesoTeoricoMaximo;
	}

	public void setPesoTeoricoMaximo(String pesoTeoricoMaximo) {
		this.pesoTeoricoMaximo = pesoTeoricoMaximo;
	}

	public String getCircunferenciaAbdominal() {
		return circunferenciaAbdominal;
	}

	public void setCircunferenciaAbdominal(String circunferenciaAbdominal) {
		this.circunferenciaAbdominal = circunferenciaAbdominal;
	}

	public String getClassificacaoCircAbdominal() {
		return classificacaoCircAbdominal;
	}

	public void setClassificacaoCircAbdominal(String classificacaoCircAbdominal) {
		this.classificacaoCircAbdominal = classificacaoCircAbdominal;
	}

}
