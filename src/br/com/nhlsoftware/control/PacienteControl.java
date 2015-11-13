package br.com.nhlsoftware.control;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.nhlsoftware.dao.PacienteDao;
import br.com.nhlsoftware.model.Paciente;

@ManagedBean(name = "pacienteBean")
public class PacienteControl {

	private String nome;
	private String cpf;
	private PacienteDao pacienteDao;

	public PacienteControl() {
		this.pacienteDao = new PacienteDao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void salvarPaciente() {

		Paciente paciente = new Paciente();

		paciente.setNome(this.nome);
		paciente.setCpf(this.cpf);

		this.pacienteDao.cirarPaciente(paciente);
		this.nome = "";
		this.cpf = "";
		
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Paciente cadastrado com sucesso!"));

	}

}
