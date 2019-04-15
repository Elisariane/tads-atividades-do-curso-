package com.lisa.projetoAgenda.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	// Endereço do banco
	// "protocolo:banco_usado//servidor:porta/nome_banco?useTimezone=true&serverTimezone=UTC"
	private static String url = "jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC";
	// Usuário (raiz)
	private static String user = "root";
	// Senha (não tem senha)
	private static String senha = "";

	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(url, user, senha);
				System.out.println("A conexão com o banco foi realizada!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

}
