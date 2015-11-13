package br.com.nhlsoftware.control;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.nhlsoftware.dao.LoginDao;
import br.com.nhlsoftware.model.Usuario;

@ManagedBean(name = "loginUsuario")
public class LoginControl{

	private String login;
	private String senha;
	
	private LoginDao loginDao;
	
	public LoginControl(){
		this.loginDao = new LoginDao();
	}

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
		Usuario usuario = this.loginDao.pesquisarUsuario(this.login, this.senha);
		this.login = "";
		this.senha = "";
		if (usuario != null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("crudUsuario.jsf");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Login ou Senha Inválido!"));
		}
	}
}
