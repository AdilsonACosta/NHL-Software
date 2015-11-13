package br.com.nhlsoftware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.nhlsoftware.model.Usuario;

public class LoginDao extends ConexaoBanco{
	
	public Usuario pesquisarUsuario(String login, String senha) { // IMPLEMENTAÇÃO DO SELECT DE USUÁRIO, PARA VALIDAR O LOGIN;
		String sql = "SELECT u.* FROM nhlsoftware.usuario u WHERE u.nome = '"
				+ login + "' AND u.senha = '" + senha + "'";
		try {
			Connection conexao = this.abrirConexao();

			PreparedStatement st = conexao.prepareStatement(sql);

			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String loginUsuario = rs.getString("nome");
				String senhaUsuario = rs.getString("senha");

				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setLogin(loginUsuario);
				usuario.setSenha(senhaUsuario);

				return usuario;
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
