package br.com.ambientinformatica.onzevencedor.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IDF_USUARIO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "EMAIL")
	private String email;	
	
	@Column(name = "EMAIL_REP")
	private String email_rep;
	
	@Column(name = "SENHA")
	private String senha;
	
	@Column(name = "SENHA_REP")
	private String senha_rep;
	
	@Column(name = "IDF_CIDADE")
	@Enumerated(EnumType.ORDINAL)
	private Cidade cidade;
	
	@Column(name = "IDF_ESTADO")
	@Enumerated(EnumType.ORDINAL)
	private Estado estado;	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}