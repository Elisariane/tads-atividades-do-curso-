package entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Farmacia {

	@Id //Define a chave primaria
	@GeneratedValue(strategy= GenerationType.AUTO) //Define que será auto incremento 
	private int id_farma;
	private String nome_fantasia;
	private String razao_social;
	private int cnpj;
	private String telefone;
	private String endereco;
	
@OneToMany
private List<Cidade> cidade;


	public int getId_farma() {
		return id_farma;
	}


	public void setId_farma(int id_farma) {
		this.id_farma = id_farma;
	}


	public String getNome_fantasia() {
		return nome_fantasia;
	}


	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}


	public String getRazao_social() {
		return razao_social;
	}


	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}


	public int getCnpj() {
		return cnpj;
	}


	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public List<Cidade> getCidade() {
		return cidade;
	}


	public void setCidade(List<Cidade> cidade) {
		this.cidade = cidade;
	}
	
	
	
	
}
