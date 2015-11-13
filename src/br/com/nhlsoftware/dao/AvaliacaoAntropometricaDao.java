package br.com.nhlsoftware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.nhlsoftware.model.AvaliacaoAntropometrica;

public class AvaliacaoAntropometricaDao extends ConexaoBanco {

	public AvaliacaoAntropometrica preencherAvalicaoAntropometrica(
			AvaliacaoAntropometrica avaliacaoAntropometrica) {

		Connection conexao = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		String sql = "INSERT INTO avalicao_antropometrica (dataAvalicaoAntropometrica, peso, altura, imc, classificacaoImc, pesoTeoricoMinimo, pesoTeoricoMedio, pesoTeoricoMaximo, circAbdominal, classificacaoCircAbdominal) VALUES (?,?,?,?,?,?,?,?,?,?)";

		try {
			conexao = this.abrirConexao();
			st = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			st.setDate(1, new java.sql.Date(avaliacaoAntropometrica
					.getDataAvalicaoAntropometrica().getTime()));
			st.setString(2, avaliacaoAntropometrica.getPeso());
			st.setString(3, avaliacaoAntropometrica.getAltura());
			st.setString(4, avaliacaoAntropometrica.getImc());
			st.setString(5, avaliacaoAntropometrica.getClassificacaoImc());
			st.setString(6, avaliacaoAntropometrica.getPesoTeoricoMinimo());
			st.setString(7, avaliacaoAntropometrica.getPesoTeoricoMedio());
			st.setString(8, avaliacaoAntropometrica.getPesoTeoricoMaximo());
			st.setString(9,
					avaliacaoAntropometrica.getCircunferenciaAbdominal());
			st.setString(10,
					avaliacaoAntropometrica.getClassificacaoCircAbdominal());

			st.executeUpdate();

			rs = st.getGeneratedKeys();

			if (rs.next()) {
				avaliacaoAntropometrica.setId(new Long(rs.getInt(1)));
			}
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avaliacaoAntropometrica;
	}
}
