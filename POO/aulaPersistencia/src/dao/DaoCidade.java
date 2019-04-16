package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import banco.Conexao;
import entidade.Cidade;
import entidade.Estado;

public class DaoCidade {

	// Criando a conexão evitando repetição de código e abertura de conexões
	private Connection conn = Conexao.get();

	// Ter acesso aos atributos da entidade estado
	Estado estado = new Estado();

	public boolean salvar(Cidade cidade) {
		try {
			String sql = "INSERT INTO cidade (nome, idest ) VALUES (?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, cidade.getNome());
			pstm.setInt(2, cidade.getEstado().getId());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean excluir(Cidade cidade) {

		try {

			String sql = "DELETE FROM cidade WHERE id = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cidade.getID());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean alterar(Cidade cidade) {
		try {
			String sql = "UPDATE cidade SET nome = ?  WHERE id = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, cidade.getNome());
			pstm.setInt(2, cidade.getID());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean consultar() {
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM cidade");
			String resultado = "";
			while (rs.next()) {
				resultado += rs.getString("nome") + " Cidade: ";
				resultado += rs.getString("estado") + " Estado: ";
			}
			System.out.println(resultado);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
