
public class Arvore {

	private Nodo raiz;

	private int totalDePalavras = 0;
	private String nomeArvore;

	public Arvore(Nodo raiz, String nome) {
		super();
		this.raiz = raiz;
		this.nomeArvore = nome;
	}

	public boolean existePalavra(String palavra) {
		return this.existePalavra(this.raiz, palavra);
	}

	private boolean existePalavra(Nodo nodo, String palavra) {
		if (nodo == null) {
			return false;
		}
		if (nodo.getPalavra().equals(palavra)) {
			//System.out.println("Palavra: " + palavra + " Quantidade de vezes: " + nodo.getContadorPalavra());
			return true;
		}
		return existePalavra(nodo.getFilhoEsquerdo(), palavra) || existePalavra(nodo.getFilhoDireito(), palavra) || false;

	}

	public void inserirNodo(String palavra) {
		this.inserirNodo(this.raiz, palavra);
	}

	private void inserirNodo(Nodo atual, String palavra) {
		if (atual.getPalavra().compareTo(palavra) > 0) {
			if (atual.getFilhoEsquerdo() == null) {
				atual.setFilhoEsquerdo(new Nodo(palavra));
				this.totalDePalavras++;
			} else {
				inserirNodo(atual.getFilhoEsquerdo(), palavra);
			}
		} else if (atual.getPalavra().compareTo(palavra) < 0) {
			if (atual.getFilhoDireito() == null) {
				atual.setFilhoDireito(new Nodo(palavra));
				this.totalDePalavras++;
			} else {
				inserirNodo(atual.getFilhoDireito(), palavra);
			}
		} else {
			atual.incrementarContador();
			this.totalDePalavras++; /* Verificar se é o que é solicitado */
		}
	}

	public void removerPalavra(String palavra) {
		removerPalavra(this.raiz, palavra);
	}

	private void removerPalavra(Nodo nodo, String palavra) {
	 
		Nodo nodoAux = null;
		
		if(!existePalavra(palavra))
		{   /* Caso a palavra não exista na árvore */
	       System.out.println("A palavra "+palavra+" não existe na árvore!");
	       return;
	    }
	    if(palavra.compareTo(nodo.getPalavra()) < 0) /* Se for menor, recursão à esquerda */
	    {
	    	if(nodo.getFilhoEsquerdo() != null) {
	    		removerPalavra(nodo.getFilhoEsquerdo(), palavra);
	    	}
	    }
	    else if(palavra.compareTo(palavra) > 0) /* Se for maior, recursão à direita */
	    {
	    	if(nodo.getFilhoDireito() != null) {
	    		removerPalavra(nodo.getFilhoDireito(), palavra);
	    	}
	    }
	    else /* Palavra encontrada */
	    {
	    	if(nodo.getFilhoEsquerdo() == null && nodo.getFilhoDireito() == null) /* Caso o nodo não tenha filho */
	    	{
	    		nodo = null; /* Atribui null ao nodo, ou seja, deleta */
	    		System.gc();
	    		return;
	    	}
	    	else if(nodo.getFilhoEsquerdo() != null && nodo.getFilhoDireito() != null)
	    	{
	    		/* Acha o maior filho a direita do nodo que contém a palavra */
	    		nodoAux = maximoValor(nodo); 
	    		/* Atribui o valor do nodoAux para o nodo atual */
	    		nodo.setPalavra(nodoAux.getPalavra());
	    		/* Caminha a partir do filho esquerdo do nodo localizado e realiza o mesmo processo para remover o nodo duplicado */
	    		removerPalavra(nodo.getFilhoDireito(), nodoAux.getPalavra());   		
	    	}
	    	else /* Caso o nodo tenha só um filho */
	    	{
	    		/* Encontra o nodo filho */
	    		Nodo filho = (nodo.getFilhoEsquerdo() != null) ? nodo.getFilhoEsquerdo() : nodo.getFilhoDireito();
	    		nodo = filho;
	    		System.gc();
	    	}	    	
	    }
	    
	}

	/**
	 * À esquerda
	 * 
	 * @param nodo
	 */
	public void imprimirPreFixado(Nodo nodo) {
		if (nodo != null) {
			System.out.println(nodo.getPalavra());
		}
		if (nodo != null) {
			imprimirPreFixado(nodo.getFilhoEsquerdo());
		}
		if (nodo != null) {
			imprimirPreFixado(nodo.getFilhoDireito());
		}
	}

	public void imprimeTeste(Nodo nodo) {
		
		if (nodo != null) {
			imprimeTeste(nodo.getFilhoEsquerdo());
		}	
			System.out.println(nodo.getPalavra());
		
		if (nodo != null) {
			imprimeTeste(nodo.getFilhoDireito());
		}
	}

	public void imprimeEmOrdem(Nodo nodo) {
		if (nodo != null) {
			imprimeEmOrdem(nodo.getFilhoEsquerdo());
			System.out.println(nodo.getPalavra() + " Quantidade no texto: " + nodo.getContadorPalavra());
			imprimeEmOrdem(nodo.getFilhoDireito());
		}	
	}

	public int getTotalDePalavras() {
		return totalDePalavras;
	}

	/**
	 * TODO
	 */
	public void limparArvore() {
		return;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public String getNomeArvore() {
		return nomeArvore;
	}

	public void setNomeArvore(String nomeArvore) {
		this.nomeArvore = nomeArvore;
	}
	
	public Nodo maximoValor(Nodo nodo) {

		while(nodo.getFilhoDireito() != null) {
			if(nodo.getFilhoDireito() != null) {
			nodo = nodo.getFilhoDireito();	
		}
		}	
		return nodo;

	}

}
