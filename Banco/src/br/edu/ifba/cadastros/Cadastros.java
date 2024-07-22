package br.edu.ifba.cadastros;


public class Cadastros<T> {
	
	private Object[] contas = new Object[3];
	private int tamanho = 0;
	
	
	public void adicionar(T c) {
		aumentaVetor();

		contas[tamanho] = c;
		this.tamanho++;
		
	}
	
	public void adicionarPorPosicao(T c, int posicao) {
		aumentaVetor();
		
		if(!verificaPosicaoAdicionar(posicao)) {
			throw new IllegalArgumentException("Fora de posicao!!!");
		}
		for(int cont = this.tamanho-1;cont>=posicao;cont--) {
			
			this.contas[cont+1]= this.contas[cont];
			
		}
		
		this.contas[posicao] = c;
		this.tamanho++;
		
	}
	
	public void remover(int posicao) {
		
		
		if(!verificaPosicao(posicao)) {
			throw new IllegalArgumentException("Posicao vazia!!!");
		}
		
		for(int cont=posicao;cont<this.tamanho;cont++ ) {
			
			this.contas[cont] = this.contas[cont+1];
			
		}
		
		this.contas[this.tamanho-1]=null;
		this.tamanho--;
		
	}
	
	
	public T procurarConta(int posicao) {
		
		return (T) this.contas[posicao];
		
		
	}
	
	private void aumentaVetor() {
		
		if(this.tamanho == this.contas.length-1) {
		
			Object[] newContas = new Object[this.contas.length*2];
			
			System.arraycopy(this.contas, 0, newContas, 0, this.contas.length);
			
			this.contas = newContas;
		}
		
	}
	
	private boolean verificaPosicao(int posicao) {
		

		if(this.tamanho == 0) {
			return false;
		}
		
		
		return posicao >= 0 && posicao <=this.tamanho-1;
		
	}
	
	private boolean verificaPosicaoAdicionar(int posicao) {
		
				
		return posicao >=0 && posicao <=this.tamanho;
		
	}
	
	
	public int size() {
		return this.tamanho;
	}
	
	public void listar() {
		for (Object obj : contas) {
			if (obj != null) {
				System.out.println(obj.toString());
			}
		}
	}
	

}
