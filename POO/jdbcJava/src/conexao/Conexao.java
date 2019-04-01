package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	;

	// Endereço do banco
	// "protocolo:banco_usado//servidor:porta/nome_banco?useTimezone=true&serverTimezone=UTC"
	private static String url = "jdbc:mysql://localhost:3306/banco?useTimezone=true&serverTimezone=UTC";
	// Usuário (raiz)
	private static String user = " root";
	// Senha (não tem senha)
	private static String password = " ";

	// Criar a variavel conn do tipo Connection e inicializar como nula
	private static Connection conn = null;

	public static Connection get() {

		try {
			//Se a conn estiver vazia, ou seja , sem conexão estabelecida então...
			if (conn == null) {
				//Conectar o banco 
				conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão estabecida!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

}
