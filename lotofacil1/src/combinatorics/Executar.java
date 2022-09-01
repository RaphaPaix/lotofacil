package combinatorics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Executar {
    final static List<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws FileNotFoundException {
		
		//adicionando as 3268760 combinaçoes
		Thread threadTodos = new Thread(thread1);
		threadTodos.start();
		
		//adicionando os premiados
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
		
		
		JOptionPane.showMessageDialog(null, "Lista de premiados carregada");
		
		//testando pra ver se adicionou
		System.out.println(premiados.get(0));
		
	}
	
	//metodos para lista de todas as 3268760 comb
	private static void listToString(List<int[]> list) {
		// TODO Auto-generated method stub
		
	}

	static void combinations15(int[] arr, List<int[]> list){
        for(int a = 0; a<arr.length-2; a++)
            for(int b = a+1; b<arr.length-1; b++)
                for(int c = b+1; c<arr.length; c++)
                    for(int d = c+1; d<arr.length; d++)
                        for(int e = d+1; e<arr.length; e++)
                            for(int f = e+1; f<arr.length; f++)
                                for(int g = f+1; g<arr.length; g++)
                                    for(int h = g+1; h<arr.length; h++)
                                        for(int i = h+1; i<arr.length; i++)
                                            for(int j = i+1; j<arr.length; j++)
                                                for(int k = j+1; k<arr.length; k++)
                                                    for(int l = k+1; l<arr.length; l++)
                                                        for(int m = l+1; m<arr.length; m++)
                                                            for(int n = m+1; n<arr.length; n++)
                                                                for(int o = n+1; o<arr.length; o++)
     list.add(new int[]{arr[a],arr[b],arr[c],arr[d],arr[e],arr[f],arr[g],arr[h],arr[i],arr[j],arr[k],arr[l],arr[m],arr[n],arr[o]});
    }
	
	public static Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {

	        ArrayList<Vetor>todasCombinacoes=new ArrayList<>();
	        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
	        combinations15(arr,list);
	        listToString(list);
	        JOptionPane.showMessageDialog(null, (list.size()+" combinações encontradas"));
		
		}
	};

}
