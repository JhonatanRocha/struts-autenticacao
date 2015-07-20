package br.com.actions;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings ("serial")
public class NumeroAleatorioAction extends ActionSupport {

	private int maximo;
	private int numeroAleatorio;

	public String execute() throws Exception {
		numeroAleatorio = (int) (Math.random() * getMaximo());
		System.out.println("maximo:" + maximo + " e " + "número aleatório: " + numeroAleatorio);
		return NumeroAleatorioAction.SUCCESS;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public int getNumeroAleatorio() {
		return numeroAleatorio;
	}

	public void setNumeroAleatorio(int numeroAleatorio) {
		this.numeroAleatorio = numeroAleatorio;
	}
}
