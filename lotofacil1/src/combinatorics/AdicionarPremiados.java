package combinatorics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AdicionarPremiados {
	public static void main(String[] args) throws IOException {
		
		List<Vetor>premiados=new ArrayList<Vetor>();
		Scanner scanner = new Scanner(System.in);
		int totalPremiados;
		totalPremiados=Integer.parseInt(JOptionPane.showInputDialog("Quantos premiados quer adicionar no arquivo texto?"));
		JOptionPane.showMessageDialog(null, "Copie e cole os premiados no console");
		System.out.println("Copie e cole os premiados abaixo: ");
		//esse processo ta demorando, consertar
		for(int i=0;i<totalPremiados;i++) {
			Vetor premiado = new Vetor();
			int[] combinacao = new int[15];
			for(int j=0;j<15;j++) {
				combinacao[j]=scanner.nextInt();
			}
			premiado.setCombinacao(combinacao);
			premiados.add(premiado);
		}
		System.out.println("Premiados adicionados, agora passando para o arquivo TXT");
		File arquivo = new File("C:\\Users\\Rapha\\git\\lotofacil\\lotofacil1\\src\\combinatorics\\premiados.txt");
		if(!arquivo.exists()) { 
			arquivo.createNewFile();
		}
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		for (Vetor vetor : premiados) {
			escrever_no_arquivo.write(vetor.getCombinacao()[0]+";"+
					vetor.getCombinacao()[1]+";"+
					vetor.getCombinacao()[2]+";"+
					vetor.getCombinacao()[3]+";"+
					vetor.getCombinacao()[4]+";"+
					vetor.getCombinacao()[5]+";"+
					vetor.getCombinacao()[6]+";"+
					vetor.getCombinacao()[7]+";"+
					vetor.getCombinacao()[8]+";"+
					vetor.getCombinacao()[9]+";"+
					vetor.getCombinacao()[10]+";"+
					vetor.getCombinacao()[11]+";"+
					vetor.getCombinacao()[12]+";"+
					vetor.getCombinacao()[13]+";"+
					vetor.getCombinacao()[14]+";"+"\n");
		}
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	
	}
}
