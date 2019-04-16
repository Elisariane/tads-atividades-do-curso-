package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import banco.Conexao;
import entidade.Estado;

public class DAOEstado {

	// Criando a conexão evitando repetição de código e abertura de conexões
	private Connection conn = Conexao.get();

	// Ter acesso aos atributos da entidade estado
	Estado estado = new Estado();

	public boolean salvar(Estado estado) {
		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate(
					"INSERT INTO estado (nome, sigla) VALUES ('" + estado.getNome() + "','" + estado.getSigla() + "')");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean excluir(Estado estado) {

		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate("DELETE FROM estado WHERE id = '" + estado.getId() + "'");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean alterar(Estado estado) {
		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate(
					"UPDATE estado SET nome = '" + estado.getNome() + "' WHERE idest = '" + estado.getId() + "'");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ArrayList<Estado> consultar() {
		try {
			ArrayList<Estado> listaEstado = new ArrayList<Estado>();
			Estado estado;
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM estado");
			while (rs.next()) {
				estado = new Estado();
				estado.setId(rs.getInt("id"));
				estado.setNome(rs.getString("nome"));
				estado.setSigla(rs.getString("sigla"));
				listaEstado.add(estado);
			}
			return listaEstado;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
