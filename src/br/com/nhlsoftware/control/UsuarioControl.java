package br.com.nhlsoftware.control;

import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nhlsoftware.dao.UsuarioDao;
import br.com.nhlsoftware.model.Usuario;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioControl {

	private String login;
	private String senha;
	private List<Usuario> usuarios;

	private UsuarioDao usuarioDao;

	public UsuarioControl() {
		this.usuarioDao = new UsuarioDao();
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

	public void salvar() {

		Usuario usuario = new Usuario();
		usuario.setLogin(this.login);
		usuario.setSenha(this.senha);

		this.usuarioDao.criarUsuario(usuario);
		this.login = "";
		this.senha = "";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Usuario " + login
						+ " cadastrado com sucesso!"));

		try {
			usuarios = this.usuarioDao.listarUsuario();
			
			for(Usuario usr : this.usuarios){
				System.out.println(usr.getId() + " " + usr.getLogin()+ " " + usr.getSenha());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			usuario = this.usuarioDao.atualizar(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			usuario = this.usuarioDao.deletar(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	
}