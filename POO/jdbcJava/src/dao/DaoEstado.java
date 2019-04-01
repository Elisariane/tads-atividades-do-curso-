package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import conexao.Conexao;
import entidade.Estado;

public class DaoEstado {

	// Criando a conexão evitando repetição de código e abertura de conexões
	private Connection conn = Conexao.get();

	// Ter acesso aos atributos da entidade estado
	Estado estado = new Estado();

	public boolean salvar(Estado estado) {
		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate("INSERT INTO estado (nome, sigla) VALUES ('"
					+ estado.getNome() + "','" + estado.getSigla() + "')");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean excluir(Estado estado) {

		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate("DELETE FROM estado WHERE idest = '"
					+ estado.getIdest() + "'");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean alterar(Estado estado) {
		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate("UPDATE estado SET nome = '" + estado.getNome()
					+ "' WHERE idest = '" + estado.getIdest() + "'");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean consultar(Estado estado) {
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM estado");
			String resultado = "";
			while (rs.next()) {
				resultado += rs.getString("nome") + " Estado: ";
				resultado += rs.getString("sigla") + " Sigla: ";
			}
			System.out.println(resultado);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
