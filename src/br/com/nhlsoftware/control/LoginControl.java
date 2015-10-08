package br.com.nhlsoftware.control;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.nhlsoftware.dao.ConexaoBanco;

@ManagedBean(name = "loginUsuario")
public class LoginControl {

	private String login;
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void logar() {
		testarConexao();

		if (login.equals("Adilson") && senha.equals("12345")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Bem Vindo " + login + " "));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Login ou Senha Inválido!"));
			;
		}
	}

	private void testarConexao() {
		// TOSystem.out.println(ConexaoBanco.satatusConexao());
		
		
		System.out.println(ConexaoBanco.statusConexao());
		
		ConexaoBanco.getConexaoBanco();
		System.out.println(ConexaoBanco.statusConexao());
		
		ConexaoBanco.FecharConexao();
		System.out.println(ConexaoBanco.statusConexao());
	}

}
