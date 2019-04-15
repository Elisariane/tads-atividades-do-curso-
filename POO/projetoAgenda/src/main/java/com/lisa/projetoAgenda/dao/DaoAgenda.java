package com.lisa.projetoAgenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lisa.projetoAgenda.conexao.Conexao;
import com.lisa.projetoAgenda.model.Agenda;

public class DaoAgenda {
	// Criando a conexão evitando repetição de código e abertura de conexões
		private Connection conn = Conexao.getConnection();

		// Ter acesso aos atributos da entidade agenda
		Agenda agenda = new Agenda();

		private PreparedStatement ps;

		public boolean salvar(Agenda agenda) {
			try {
				String sql = "INSERT INTO agenda (nome,email,telefone) VALUES (?,?,?)";
				// Prepara a instrução SQL
				ps = conn.prepareStatement(sql);
				ps.setString(1, agenda.getNome());
				ps.setString(2, agenda.getEmail());
				ps.setString(3, agenda.getTelefone());
				// Executa a instrução SQL
				ps.execute();
				System.out.println("Contato salvo!");
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

			return true;
		}

		public boolean excluir(int id) {
			try {
				String sql = "DELETE FROM agenda WHERE id = ?";
				// Prepara a instrução SQL
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, agenda.getId());

				// Executa a instrução SQL
				ps.execute();

				System.out.println("Esse contato foi excluido!");
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

			return true;
		}

		public boolean alterar(Agenda agenda) {
			try {
				String sql = "UPDATE agenda SET email=?, telefone=? WHERE nome=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, agenda.getEmail());
				ps.setString(2, agenda.getTelefone());
				ps.setString(3, agenda.getNome());
				// Executa a instrução
				int retorno = ps.executeUpdate();
				if (retorno > 0) {
					System.out.printf("Novo registro alterado: %s: %s - %s", agenda.getNome(), agenda.getEmail(),
							agenda.getTelefone());
				} else {
					System.out.println("Não foi possível alterar os registros!");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

			return true;
		}

		public boolean consultar(Agenda agenda) {
			try {
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery("SELECT * FROM estado");
				String resultado = "";
				while (rs.next()) {
					resultado += rs.getInt("id") + "ID: ";
					resultado += rs.getString("nome") + "Nome: ";
					resultado += rs.getString("email") + "Email @: ";
					resultado += rs.getString("telefone") + "Telefone: ";
				}
				System.out.println(resultado);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
	}
}
