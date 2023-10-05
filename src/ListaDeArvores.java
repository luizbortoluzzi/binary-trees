
import java.util.LinkedList;
import java.util.ListIterator;

public class ListaDeArvores {

	private LinkedList<Arvore> listaDeArvores = new LinkedList<Arvore>();

	public void adicionaArvore(Arvore arvore) {
		listaDeArvores.add(arvore);
	}

	public void removeArvore(String titulo) {

		ListIterator<Arvore> iteradorListaDeArvores = listaDeArvores.listIterator(0);
		Arvore arvoreAtual;
		while (iteradorListaDeArvores.hasNext()) {
			arvoreAtual = iteradorListaDeArvores.next();
			if (titulo.equals(arvoreAtual.getNomeArvore())) {
				listaDeArvores.remove(arvoreAtual);
			}
		}
	}

	public boolean existeArvore(String titulo) {

		ListIterator<Arvore> iteradorListaDeArvores = listaDeArvores.listIterator(0);
		Arvore arvoreAtual;
		while (iteradorListaDeArvores.hasNext()) {
			arvoreAtual = iteradorListaDeArvores.next();
			if (titulo.equals(arvoreAtual.getNomeArvore())) {
				return true;
			}
		}
		return false;
	}
	
	public Arvore pegaArvore(String titulo) {

		ListIterator<Arvore> iteradorListaDeArvores = listaDeArvores.listIterator(0);
		Arvore arvoreAtual;
		while (iteradorListaDeArvores.hasNext()) {
			arvoreAtual = iteradorListaDeArvores.next();
			if (titulo.equals(arvoreAtual.getNomeArvore())) {
				return arvoreAtual;
			}
		}
		return null;
	}
	
	
	
	public int contaTotal() {
		
		ListIterator<Arvore> iteradorListaDeArvores = listaDeArvores.listIterator(0);
		Arvore arvoreAtual;
		int totalDePalavras = 0;
		while (iteradorListaDeArvores.hasNext()) {
			arvoreAtual = iteradorListaDeArvores.next();
			totalDePalavras += arvoreAtual.getTotalDePalavras();
		}
		return totalDePalavras;
	}
	
	public void preFixadoTotal() {
		
		ListIterator<Arvore> iteradorListaDeArvores = listaDeArvores.listIterator(0);
		Arvore arvoreAtual;
		while (iteradorListaDeArvores.hasNext()) {
			arvoreAtual = iteradorListaDeArvores.next();
			arvoreAtual.imprimirPreFixado(arvoreAtual.getRaiz());
		}
	}
	
	public void emOrdemTotal() {
		
		ListIterator<Arvore> iteradorListaDeArvores = listaDeArvores.listIterator(0);
		Arvore arvoreAtual;
		while (iteradorListaDeArvores.hasNext()) {
			arvoreAtual = iteradorListaDeArvores.next();
			arvoreAtual.imprimeEmOrdem(arvoreAtual.getRaiz());
		}
	}
	
	public void limpaLista() {
		listaDeArvores.clear();
		return;
	}

}
