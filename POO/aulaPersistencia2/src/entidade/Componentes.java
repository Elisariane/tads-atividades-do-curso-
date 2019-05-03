package entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Componentes {

	@Id //Define a chave primaria
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id_componentes;
	
	private String nome;
	
	@ManyToMany
	private List<Remedio> remedio;

	public int getId_componentes() {
		return id_componentes;
	}

	public void setId_componentes(int id_componentes) {
		this.id_componentes = id_componentes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Remedio> getRemedio() {
		return remedio;
	}

	public void setRemedio(List<Remedio> remedio) {
		this.remedio = remedio;
	}

	
	
	
}
