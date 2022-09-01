package combinatorics;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Vetor {
	
	Scanner scanner = new Scanner(System.in);
	
	int[] combinacao = new int[15];
	float total;
	float variacao;
	float quadradoVariacao;
	
	
	

	public float getQuadradoVariacao() {
		return quadradoVariacao;
	}

	public void setQuadradoVariacao(float quadradoVariacao) {
		this.quadradoVariacao = quadradoVariacao;
	}

	public float getVariacao() {
		return variacao;
	}

	public void setVariacao(float variacao) {
		this.variacao = variacao;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int[] getCombinacao() {
		return combinacao;
	}

	public void setCombinacao(int[] combinacao) {
		this.combinacao = combinacao;
	}
	
	public float calcularTotalVetor() {
		for(int i=0;i<15;i++) {
			this.total=this.total+this.combinacao[i];
		}
		return this.total;
	}
	
	public boolean compararVetor(int[] vetor) {
		int t=0;
		boolean tem9iguais = false;
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(this.combinacao[i]==vetor[j]){
					t++;
				}
			}
		}
		if(t==9) {
			tem9iguais = true;
		}
		return tem9iguais;
	}

	@Override
	public String toString() {
		return "Vetor [combinacao=" + Arrays.toString(combinacao) + "]";
	}
	
	public void imprimirVetor() {
		for(int i=0;i<15;i++) {
			System.out.printf(" %d",this.combinacao[i]);
		}
		System.out.println("");
	}
	
	
	
	
}
