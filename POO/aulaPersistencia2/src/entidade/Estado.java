package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity //Define a entidade
public class Estado {
	@Id //Define a chave primaria
	@GeneratedValue(strategy=GenerationType.AUTO) //Define que será auto incremento 
	private long idest;
	private String nome;
	private String sigla;
	
	public long getIdest() {
		return idest;
	}
	public void setIdest(long idest) {
		this.idest = idest;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	

}
