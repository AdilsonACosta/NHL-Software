package br.com.nhlsoftware.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	
	private static String status = "Não aconteceu...";
	
	public ConexaoBanco(){ 
	
	}
	
	public static java.sql.Connection getConexaoBanco(){
		
		Connection conexao = null;
		
		try{
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			
			String serverName = "localhost";
			String mydatabase = "nhlsoftware";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "root";
			String senha = "root";
			
			conexao = DriverManager.getConnection(url, username, senha);
			
			if(conexao != null){
				status = ("STATUS ---> CONECTADO COM SUCESSO!");
			}
			else{
				status = ("STATUS ---> Não foi possível realizar sua conexão");
			}
			
			return conexao;
			
		}catch(ClassNotFoundException e){
			
			System.out.println("Driver não encontrado");
			return null;
		
		}catch (SQLException e) {
			
			System.out.println("Não foi possível se conectar ao B.D");
			
			return null;
		}
	}
	
	public static String statusConexao(){
		
		return status;
	}
	
	public static boolean FecharConexao(){
		
		try {
			ConexaoBanco.getConexaoBanco().close();
			return true;
		
		}catch (SQLException e) {
			return false;
		}
		
	}
	
	public static java.sql.Connection ReiniciarConexao(){
		
		FecharConexao();
		
		return ConexaoBanco.getConexaoBanco();
	}
}
