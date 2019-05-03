package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity 
public class Cidade {
	@Id //Define a chave primaria
	@GeneratedValue(strategy= GenerationType.AUTO) //Define que ser� auto incremento 
	private long id;
	private String nome;
	@ManyToOne //Define a cardinalidade muitos(cidade) pra um (estado) fk 
	private Estado estado;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}