package br.com.nhlsoftware.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

	private final String driverName = "com.mysql.jdbc.Driver";
	private final String serverName = "localhost";
	private final String mydatabase = "nhlsoftware";
	private final String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
	private final String usuarioBD = "root";
	private final String senha = "root";

	private Connection conexao;

	public Connection abrirConexao() {
		try {
			Class.forName(driverName);
			return conexao = DriverManager.getConnection(url, usuarioBD, senha);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Connection getConexaoBanco() {
		return conexao;
	}

	public String statusConexao() {
		try {
			if (conexao != null && !conexao.isClosed()) {
				return "Conexão aberta";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Conexão fechada";
	}

	public boolean FecharConexao() {
		try {
			conexao.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public java.sql.Connection ReiniciarConexao() {
		FecharConexao();
		return abrirConexao();
	}
}