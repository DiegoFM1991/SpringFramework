package com.entra21_Spring.entra21_Spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Modelo implements Serializable{
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long id_Fabricante;
	private String nome;
	private String cor;
	private Integer ano;
	private Integer quantPorta;
	@OneToOne(fetch = FetchType.LAZY)
	private Fabricante fabricante;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public Long getId_Fabricante() {
		return id_Fabricante;
	}
	public void setId_Fabricante(Long id_Fabricante) {
		this.id_Fabricante = id_Fabricante;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getQuantPorta() {
		return quantPorta;
	}
	public void setQuantPorta(Integer quantPorta) {
		this.quantPorta = quantPorta;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
}
