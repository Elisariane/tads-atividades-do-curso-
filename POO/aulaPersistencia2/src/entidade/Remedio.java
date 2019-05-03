package entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Remedio {
	@Id //Define a chave primaria
	@GeneratedValue(strategy= GenerationType.AUTO) //Define que será auto incremento 
	private int id_med;
	
	private String nome;
	private String descricao;
	private boolean precricao;
	private int qtd_comprimidos;
	private double preco;
	
	@ManyToMany
	private List<Farmacia> farmacia;
	
	@ManyToOne
	private Categoria categoria;

	public int getId_med() {
		return id_med;
	}

	public void setId_med(int id_med) {
		this.id_med = id_med;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isPrecricao() {
		return precricao;
	}

	public void setPrecricao(boolean precricao) {
		this.precricao = precricao;
	}

	public int getQtd_comprimidos() {
		return qtd_comprimidos;
	}

	public void setQtd_comprimidos(int qtd_comprimidos) {
		this.qtd_comprimidos = qtd_comprimidos;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Farmacia> getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(List<Farmacia> farmacia) {
		this.farmacia = farmacia;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	

}
