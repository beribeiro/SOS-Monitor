package br.com.listavip.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class Analysts {
	
	@Column
	private long Id;
	
	@Column
	private String nome;
	
	@Column
	private boolean ativo;
	
	public Analysts(String nome, boolean ativo) {
		this.nome = nome;
		this.ativo = ativo;
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Analysts() {
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
