package aep_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import AEP.Bilhete;
import AEP.BilheteRepository;

public class ConexaoBanco {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/aep2019",
					"postgres",
					"unicesumar");
			
			criarTabelaBilhetes(conn);
			
			excluirTodos(conn);
			
			gerarBilhete(conn, 2999, "São Jose do Rio Preto", "Andromeda",  toDate(9-06-2019));
			
			Calendar calendar = Calendar.getInstance();
			calendar.set(calendar.DAY_OF_MONTH, 9);
			calendar.set(calendar.MONTH, 6);
			calendar.set(calendar.YEAR, 2019);
								
			gerarBilhete(conn, 3433, "Destino", "Origem", calendar.getTime());
		
			
			System.out.println("OK");
			conn.close();
			System.out.println("Closed");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fim!");
	}

	private static Date toDate(int i) {
		return null;
	}

	private static void excluirTodos(Connection conn) {
		
	}


	
	public static void gerarBilhete(Connection conexao, Integer numero, String origem, String destino, Date date) throws Exception {
		String sql = "insert into bilhetes (numero, origem, destino, data) values (?, ?, ?, ?)";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, numero);
		statement.setString(2, "Verkoyansky");
		statement.setString(3, "Wellington");
		statement.setDate(4, new java.sql.Date(date.getTime()));
		
		statement.execute();
		statement.close();
	}
	
	public static void excluirBilhete(Connection conexao, Integer numero) throws Exception {
		String sql = "delete from bilhetes where numero = ?";
		Statement statement = conexao.createStatement();
		((PreparedStatement) statement).setInt(1, numero);
		statement.execute(sql);
		statement.close();		
	}
	
	public static void criarTabelaBilhetes(Connection conexao) throws Exception {
		String sql = "create table if not exists bilhetes ("
				+ "numero integer not null primary key,"
				+ "origem varchar(255) not null unique,"
				+ "destino varchar(255) not null unique,"
				+ "data date not null"
				+ ")";
		
		Statement statement = conexao.createStatement();
		statement.execute(sql);
		statement.close();		
	}
}
