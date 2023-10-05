
public class Nodo {

	private String palavra;
	private int contadorPalavra;
	public Nodo filhoEsquerdo;
	public Nodo filhoDireito;

	public Nodo(String palavra) {
		super();
		contadorPalavra = 1;
		this.palavra = palavra;
	}

	public Nodo getFilhoEsquerdo() {
		return filhoEsquerdo;
	}

	public void setFilhoEsquerdo(Nodo filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}

	public Nodo getFilhoDireito() {
		return filhoDireito;
	}

	public void setFilhoDireito(Nodo filhoDireito) {
		this.filhoDireito = filhoDireito;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public void incrementarContador() {
		this.contadorPalavra++;
	}

	public int getContadorPalavra() {
		return contadorPalavra;
	}

}
