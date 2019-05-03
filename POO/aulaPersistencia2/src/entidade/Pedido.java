package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
@Id //Define a chave primaria
@GeneratedValue(strategy= GenerationType.AUTO)	
private int id_pedido;

private String data;

@ManyToOne
private Remedio remedio;

public int getId_pedido() {
	return id_pedido;
}

public void setId_pedido(int id_pedido) {
	this.id_pedido = id_pedido;
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}

public Remedio getRemedio() {
	return remedio;
}

public void setRemedio(Remedio remedio) {
	this.remedio = remedio;
}

}
