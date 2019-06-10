package aep_Bilhetes;

import java.time.LocalDate;

public class Bilhetes {
	
	Integer voo;
	String origem;
	String destino;
	LocalDate data;
	public Bilhetes(Integer voo, String origem, String destino, LocalDate data) {
		setVoo(voo);
		setOrigem(origem);
		setDestino(destino);
		setData(data);
	}
	
	
	
	
	public Integer getVoo() {
		return voo;
	}
	public void setVoo(Integer voo) {
		this.voo = voo;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	public Integer getNumero() {
		return null;
	}

}
