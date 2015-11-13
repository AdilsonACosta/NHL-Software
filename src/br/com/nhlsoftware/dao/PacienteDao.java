package br.com.nhlsoftware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.nhlsoftware.model.Paciente;

public class PacienteDao extends ConexaoBanco {

	public Paciente cirarPaciente(Paciente paciente) {

		Connection conexao = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		String sql = "INSERT INTO pacientes (nome,cpf) VALUES (?,?)";

		try {
			conexao = this.abrirConexao();
			st = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			st.setString(1, paciente.getNome());
			st.setString(2, paciente.getCpf());

			st.executeUpdate();

			rs = st.getGeneratedKeys();

			if (rs.next()) {
				paciente.setId(new Long(rs.getInt(1)));
			}

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return paciente;
	}

	public List<Paciente> ListarPacientes() {

		String sql = "SELECT * FROM pacientes";

		Connection conexao = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conexao = this.abrirConexao();
			st = conexao.prepareStatement(sql);
			rs = st.executeQuery(sql);

			ArrayList<Paciente> listaDePacientes = new ArrayList<Paciente>();

			while (rs.next()) {

				Long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");

				Paciente paciente = new Paciente();
				paciente.setId(id);
				paciente.setNome(nome);
				paciente.setCpf(cpf);
				listaDePacientes.add(paciente);
			}
			conexao.close();
			return listaDePacientes;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Paciente atualizarPaciente(Paciente paciente) {

		String sql = "UPDATE pacientes SET nome = ?, cpf = ? WHERE id = ?";

		Connection conexao = null;
		PreparedStatement st = null;

		try {
			conexao = this.abrirConexao();
			st = conexao.prepareStatement(sql);

			st.setString(1, paciente.getNome());
			st.setString(2, paciente.getCpf());
			st.setLong(3, paciente.getId());
			st.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return paciente;
	}

	public Paciente deletarPaciente(Paciente paciente) {

		String sql = "DELETE FROM pacientes WHERE id = ?";

		Connection conexao = null;
		PreparedStatement st = null;

		try {
			conexao = this.abrirConexao();
			st = conexao.prepareStatement(sql);

			st.setLong(1, paciente.getId());
			st.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return paciente;
	}
}
