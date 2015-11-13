package br.com.nhlsoftware.control;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.nhlsoftware.dao.AvaliacaoAntropometricaDao;
import br.com.nhlsoftware.model.Anamnese;
import br.com.nhlsoftware.model.AvaliacaoAntropometrica;

@ManagedBean(name = "antropometriaBean")
public class AvaliacaoAntropometricaControl {

	private Long id;
	private Date dataAvalicaoAntropometrica;
	private String peso;
	private String altura;
	private String imc;
	private String classificacaoImc;
	private String pesoTeoricoMinimo;
	private String pesoTeoricoMedio;
	private String pesoTeoricoMaximo;
	private String circunfericiaAbdominal;
	private String classificacaoCircAbdominal;
	private AvaliacaoAntropometricaDao avaliacaoAntropometricaDao;

	public AvaliacaoAntropometricaControl() {
		this.avaliacaoAntropometricaDao = new AvaliacaoAntropometricaDao();
	}

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

	public String getCircunfericiaAbdominal() {
		return circunfericiaAbdominal;
	}

	public void setCircunfericiaAbdominal(String circunfericiaAbdominal) {
		this.circunfericiaAbdominal = circunfericiaAbdominal;
	}

	public AvaliacaoAntropometricaDao getAvaliacaoAntropometricaDao() {
		return avaliacaoAntropometricaDao;
	}

	public void setAvaliacaoAntropometricaDao(
			AvaliacaoAntropometricaDao avaliacaoAntropometricaDao) {
		this.avaliacaoAntropometricaDao = avaliacaoAntropometricaDao;
	}

	public String getClassificacaoCircAbdominal() {
		return classificacaoCircAbdominal;
	}

	public void setClassificacaoCircAbdominal(String classificacaoCircAbdominal) {
		this.classificacaoCircAbdominal = classificacaoCircAbdominal;
	}

	public void salvarAvaliacaoAntropometrica() {

		AvaliacaoAntropometrica avaliacaoAntropometrica = new AvaliacaoAntropometrica();
		avaliacaoAntropometrica.setDataAvalicaoAntropometrica(this
				.getDataAvalicaoAntropometrica());
		avaliacaoAntropometrica.setPeso(this.getPeso());
		avaliacaoAntropometrica.setAltura(this.getAltura());
		avaliacaoAntropometrica.setImc(this.getImc());
		avaliacaoAntropometrica.setClassificacaoImc(this.getClassificacaoImc());
		avaliacaoAntropometrica.setPesoTeoricoMinimo(this
				.getPesoTeoricoMinimo());
		avaliacaoAntropometrica.setPesoTeoricoMedio(this.getPesoTeoricoMedio());
		avaliacaoAntropometrica.setPesoTeoricoMaximo(this
				.getPesoTeoricoMaximo());
		avaliacaoAntropometrica.setCircunferenciaAbdominal(this
				.getCircunfericiaAbdominal());
		avaliacaoAntropometrica.setClassificacaoCircAbdominal(this
				.getClassificacaoCircAbdominal());
		
		this.avaliacaoAntropometricaDao.preencherAvalicaoAntropometrica(avaliacaoAntropometrica);
		
		this.dataAvalicaoAntropometrica = null;
		this.peso = "";
		this.altura = "";
		this.imc = "";
		this.classificacaoImc = "";
		this.pesoTeoricoMinimo = "";
		this.pesoTeoricoMedio = "";
		this.pesoTeoricoMaximo = "";
		this.circunfericiaAbdominal = "";
		this.classificacaoCircAbdominal = "";

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Cadastro realizado com sucesso!"));
	}

}
