package br.com.nhlsoftware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.nhlsoftware.model.AvaliacaoLaboratorial;

public class AvaliacaoLaboratorialDao extends ConexaoBanco {

	public AvaliacaoLaboratorial preencherAvalicaoLaboratorial(
			AvaliacaoLaboratorial avaliacaoLaboratorial) {

		Connection conexao = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		String sql = "INSERT INTO avaliacao_laboratorial(dataAvaliacaoLaboratorial, hemoglobina, trigliceridios, colesterolTotal, ldl, hdl, vldl, glicemiaDeJejum, glicemiaPosPrandial, pressaoArterial) VALUES (?,?,?,?,?,?,?,?,?,?)";

		try {
			conexao = this.abrirConexao();
			st = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			st.setDate(1, new java.sql.Date(avaliacaoLaboratorial
					.getDataAvaliacaoLaboratorial().getTime()));
			st.setString(2, avaliacaoLaboratorial.getHemoglobina());
			st.setString(3, avaliacaoLaboratorial.getTrigliceridios());
			st.setString(4, avaliacaoLaboratorial.getColesterolTotal());
			st.setString(5, avaliacaoLaboratorial.getLdl());
			st.setString(6, avaliacaoLaboratorial.getHdl());
			st.setString(7, avaliacaoLaboratorial.getVldl());
			st.setString(8, avaliacaoLaboratorial.getGlicemiaDeJejum());
			st.setString(9, avaliacaoLaboratorial.getGlicemiaPosPrandial());
			st.setString(10, avaliacaoLaboratorial.getPressaoArterial());

			st.executeUpdate();
			rs = st.getGeneratedKeys();

			if (rs.next()) {
				avaliacaoLaboratorial.setId(new Long(rs.getInt(1)));
			}
			
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return avaliacaoLaboratorial;
	}
}
