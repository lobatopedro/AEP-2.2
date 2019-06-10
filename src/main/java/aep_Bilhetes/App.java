package aep_Bilhetes;

import java.sql.Connection;
import java.util.List;

public class App {

	public static void main(String[] args) {
		Bilhetes bilheteAereo = new Bilhetes(2999, "São Jose do Rio Preto", "Andromeda", toDate(9-06-2019));
		Bilhetes bilheteAereo1 = new Bilhetes(3433, "Mykonos", "Bratislava", toDate(10-06-2019));
		
		Connection conn = null;

		BilhetesRepository repo = null;
		
		repo.inserir(bilheteAereo);
		repo.inserir(bilheteAereo1);
		
		List<Bilhetes> bilhetes = repo.obterTodos();
		System.out.println("Listar bilhetes");

		for (Bilhetes bilhete : bilhetes) {
			System.out.println("  " + bilhete);
		}
		System.out.println("Fim!");

		repo.excluir(bilheteAereo.getNumero());
		
	}
}
