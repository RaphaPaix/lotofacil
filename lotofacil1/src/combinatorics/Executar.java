package combinatorics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Executar {
	public static void main(String[] args) throws FileNotFoundException {
		
		List<Vetor>premiados=new ArrayList<Vetor>();
		FileInputStream entradaPremiados = new FileInputStream(new File("C:\\Users\\Rapha\\git\\lotofacil\\lotofacil1\\src\\combinatorics\\premiados.txt"));
		Scanner lerArquivo = new Scanner(entradaPremiados, "UTF-8");
		
		while(lerArquivo.hasNext()) {
			String linha = lerArquivo.nextLine();
			if(!linha.isEmpty()&&linha!=null) {
				String[] dados = linha.split("\\;");
				Vetor premiado = new Vetor();
				int vetor[] = premiado.getCombinacao();
				for(int i=0;i<15;i++) {
					vetor[i]=Integer.parseInt(dados[i]);
				}
				premiado.setCombinacao(vetor);
				premiados.add(premiado);
			}
		}
		
		for (Vetor vetor : premiados) {
			System.out.println(vetor);
		}
	}
}
