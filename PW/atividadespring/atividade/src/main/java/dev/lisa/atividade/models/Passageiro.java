package dev.lisa.atividade.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Passageiro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	private String cpf;
	private int numVoo;
	private double malaPeso;
	private double valorTaxa;
	private double pesoMala;
	private double altura;
	private double largura;
	private double comprimento;
    private char tipoVoo;
    
    
	public char getTipoVoo() {
		return tipoVoo;
	}
	public void setTipoVoo(char tipoVoo) {
		this.tipoVoo = tipoVoo;
	}
	public Long getId() {
		return id;
	}
	public double getPesoMala() {
		return pesoMala;
	}
	public void setPesoMala(double pesoMala) {
		this.pesoMala = pesoMala;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getLargura() {
		return largura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
	public double getComprimento() {
		return comprimento;
	}
	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getNumVoo() {
		return numVoo;
	}
	public void setNumVoo(int numVoo) {
		this.numVoo = numVoo;
	}
	public double getMalaPeso() {
		return malaPeso;
	}
	public void setMalaPeso(double malaPeso) {
		this.malaPeso = malaPeso;
	}
	public double getValorTaxa() {
		return valorTaxa;
	}
	public void setValorTaxa(double valorTaxa) {
		this.valorTaxa = valorTaxa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public boolean validarBagagem() {
		if(this.pesoMala > 10)
			return false;
		if(this.altura > 55)
			return false;
		if(this.largura > 35)
			return false;
		if(this.comprimento > 25)
			return false;
		return true;
	}
	
}
