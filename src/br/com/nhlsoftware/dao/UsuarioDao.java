package br.com.nhlsoftware.dao;

import java.util.*;
import java.awt.image.ConvolveOp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.nhlsoftware.model.Usuario;

public class UsuarioDao extends ConexaoBanco {

	public Usuario criarUsuario(Usuario usuario) {

		Connection conexao = null;
		PreparedStatement st = null;

		String sql = "INSERT INTO usuario (nome,senha) VALUES (?,?)";

		try {
			conexao = this.abrirConexao();
			st = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, usuario.getLogin());
			st.setString(2, usuario.getSenha());

			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();

			if (rs.next()) {
				usuario.setId(new Long(rs.getInt(1)));

			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		// return pesquisarUsuarioComMaiorID();
		return usuario;
	}

	// private Usuario pesquisarUsuarioComMaiorID() {
	// String sql =
	// "SELECT * FROM nhlsoftware.usuario u WHERE u.id = (SELECT MAX(us.id) FROM nhlsoftware.usuario us)";
	// try {
	// Connection conexao = this.abrirConexao();
	//
	// PreparedStatement st = conexao.prepareStatement(sql);
	// ResultSet rs = st.executeQuery(sql);
	//
	// if (rs.next()) {
	// Usuario usuario = new Usuario();
	//
	// usuario.setId(new Long(rs.getInt("id")));
	// usuario.setLogin(rs.getString("nome"));
	// usuario.setSenha(rs.getString("senha"));
	//
	// return usuario;
	// }
	// conexao.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }

	public Usuario pesquisarUsuario(String login, String senha) {
		String sql = "SELECT u.* FROM nhlsoftware.usuario u WHERE u.nome = '"
				+ login + "' AND u.senha = '" + senha + "'";
		try {
			Connection conexao = this.abrirConexao();

			PreparedStatement st = conexao.prepareStatement(sql);
			// st.setString(1, login);
			// st.setString(2, senha);

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

	public List<Usuario> listarUsuario() throws SQLException {

		String sql = "SELECT * FROM usuario";

		Connection conexao = null;
		PreparedStatement st = null;

		try {

			conexao = this.abrirConexao();

			st = conexao.prepareStatement(sql);

			ResultSet rs = st.executeQuery(sql);
			
			ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

			while (rs.next()) {
				Long id = (long) rs.getInt("id");
				String login = rs.getString("nome");
				String senha = rs.getString("senha");

				Usuario usuario = new Usuario();
				usuario.setId(id);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				listaUsuarios.add(usuario);
			}
			conexao.close();
			
			return listaUsuarios;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	public Usuario atualizar(Usuario usuario) throws SQLException{
		String sql = "UPDATE usuario SET nome = ?, senha = ? WHERE id = ?";
		
		Connection conexao = null;
		
		PreparedStatement st = null;
		
		try {
			conexao = this.abrirConexao();
			st = conexao.prepareStatement(sql);
			
			st.setString(1, "adilsonCosta");
			st.setString(2,"54321");
			st.setLong(3, 1);
			st.executeUpdate();
			
			conexao.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return usuario;
		
	}
	
	public Usuario deletar(Usuario usuario) throws SQLException{
		
		String sql = "DELETE FROM usuario WHERE id = ?";
		
		Connection conexao = null;
		
		PreparedStatement st = null;
		
		try {
			conexao = this.abrirConexao();
			st = conexao.prepareStatement(sql);
			
			st.setLong(1,27);
			st.executeUpdate();
			
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	
}
