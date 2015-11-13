package br.com.nhlsoftware.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.ApplicationContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.util.AjaxRequestBuilder;
import org.primefaces.util.CSVBuilder;
import org.primefaces.util.StringEncrypter;
import org.primefaces.util.WidgetBuilder;

import br.com.nhlsoftware.dao.AnamneseDao;
import br.com.nhlsoftware.model.Anamnese;

@ManagedBean(name = "anamneseBean")
public class AnamneseControl {

	private String nome;
	private String idade;
	private String escolherGenero;
	private Date dataDeNascimento;
	private String estadoCivil;
	private AnamneseDao anamneseDao;

	public AnamneseControl() {
		this.anamneseDao = new AnamneseDao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEscolherGenero() {
		return escolherGenero;
	}

	public void setEscolherGenero(String escolherGenero) {
		this.escolherGenero = escolherGenero;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	// public void dataDeNascimento(SelectEvent event) {
	// FacesContext facesContext = FacesContext.getCurrentInstance();
	// SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
	// facesContext.addMessage(
	// null,
	// new FacesMessage(FacesMessage.SEVERITY_INFO,
	// "Data de Nascimento", formatoData.format(event
	// .getObject())));
	// }

	public void salvarAnamnese() {

		Anamnese anamnese = new Anamnese();
		anamnese.setNome(this.getNome());
		anamnese.setIdade(this.getIdade());
		anamnese.setEscolherGenero(this.getEscolherGenero());
		anamnese.setDataDeNascimento(this.getDataDeNascimento());
		anamnese.setEstadoCivil(this.getEstadoCivil());

		this.anamneseDao.preencherAnamnese(anamnese);
		this.nome = "";
		this.idade = "";
		this.escolherGenero = "";
		this.dataDeNascimento = null;
		this.estadoCivil = "";

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Cadastro realizado com sucesso!"));
	}

}
