package br.com.nhlsoftware.model;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Anamnese {
	
	private Long id;
	private String nome;
	private String idade;
	private String escolherGenero;
	private Date dataDeNascimento;
	private String estadoCivil;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEscolherGenero() {
		return escolherGenero;
	}

	public void setEscolherGenero(String escolherGenero) {
		this.escolherGenero = escolherGenero;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}
