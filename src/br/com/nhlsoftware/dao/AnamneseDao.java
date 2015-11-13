package br.com.nhlsoftware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.EscapeTokenizer;

import br.com.nhlsoftware.model.Anamnese;

public class AnamneseDao extends ConexaoBanco {

	public Anamnese preencherAnamnese(Anamnese anamnese) {

		Connection conexao = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		String sql = "INSERT INTO anamnese (nome, idade, genero, dataNascimento, estadoCivil) VALUES (?,?,?,?,?)";

		try {
			conexao = this.abrirConexao();
		
			st = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			st.setString(1, anamnese.getNome());
			st.setString(2, anamnese.getIdade());
			st.setString(3, anamnese.getEscolherGenero());
			st.setDate(4, new java.sql.Date (anamnese.getDataDeNascimento().getTime()));
			st.setString(5, anamnese.getEstadoCivil());
			st.executeUpdate();

			rs = st.getGeneratedKeys();

			if (rs.next()) {
				anamnese.setId(new Long(rs.getInt(1)));
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return anamnese;
	}

}
