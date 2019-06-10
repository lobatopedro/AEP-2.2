package aep_Bilhetes;

import java.util.List;

public interface BilhetesRepository {

void inserir(Bilhetes bilhete);
	
	List<Bilhetes> obterTodos();
	
	void alterar(Bilhetes bilhete);
	
	void excluir(Integer numero);
}
