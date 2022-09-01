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
    final static List<Vetor>premiados=new ArrayList<Vetor>();
	public static void main(String[] args) throws FileNotFoundException {
		
		//senha para autorizar a operação
		String senha = JOptionPane.showInputDialog("DIGITE A SENHA PARA INICIAR A OPERAÇÃO");
		if(senha.equalsIgnoreCase("kiara")) {
			//adicionando as 3268760 combinaçoes
			Thread threadTodos = new Thread(thread1);
			threadTodos.start();
			
			//adicionando os premiados
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
			
			//somando total de cada linha
			for(int i=0;i<premiados.size();i++) {
				Vetor premiado = new Vetor();
				premiado=premiados.get(i);
				float total=premiado.calcularTotalVetor();
			}
			
			//calculando a média
			float mediaTotalPremiados=0;
			float totalPremiados=0;
			for(int i=0;i<premiados.size();i++) {
				totalPremiados=totalPremiados+premiados.get(i).getTotal();
			}
			mediaTotalPremiados=(totalPremiados/premiados.size());
			System.out.println("Media dos totais de cada linha = "+mediaTotalPremiados);
			
			//frequencia da media (intervalo +-)
			int mediaTotalPremiadosInteiro = (int)mediaTotalPremiados;
			int frequencia=0;
			for(int i=0;i<premiados.size();i++) {
				if(premiados.get(i).getTotal()>=(mediaTotalPremiadosInteiro-3)
						&&premiados.get(i).getTotal()<=(mediaTotalPremiadosInteiro+3)) {
					frequencia++;
				}
			}
			System.out.println("Em um intervalo de -3 a 3, a média tem a frequencia de "+frequencia);
			int porcentagemFrequencia = (frequencia*100)/premiados.size();
			System.out.println("Em porcentagem, a frequência tem o valor de: "+porcentagemFrequencia+"%");
			
			//calculo desvio padrao da media
			//primeiro obter a variaçao de x (xi - xmedia) e a soma dos quadrados
			for(int i=0;i<premiados.size();i++) {
				float variacao = (premiados.get(i).getTotal()-mediaTotalPremiados);
				premiados.get(i).setVariacao(variacao);
				float quadradoVariacao = variacao*variacao;
				premiados.get(i).setQuadradoVariacao(quadradoVariacao);
			}
			//soma dos quadrados da variacao:
			float somaQuadradosVariacao=0;
			for(int i=0;i<premiados.size();i++) {
				somaQuadradosVariacao=somaQuadradosVariacao+premiados.get(i).getQuadradoVariacao();
			}
			//calculos para obter o desvio padrao
			float desvioPadraoMediaSemRaiz=(somaQuadradosVariacao/(premiados.size()*(premiados.size()-1)));
			
			
			float desvioPadraoMedia=(float) Math.sqrt(desvioPadraoMediaSemRaiz);
			//testando:
			//System.out.println("Variacao da linha 1 = "+premiados.get(0).getVariacao());
			//System.out.println("Quadrado da variacao da linha 1 = "+premiados.get(0).getQuadradoVariacao());
			//System.out.println("Soma dos quadrados das variaçoes = "+somaQuadradosVariacao);
			System.out.println("Desvio padrão da média = "+desvioPadraoMedia);
			
			
			
			
			
			
		}else {
			JOptionPane.showMessageDialog(null, "SENHA INCORRETA");
		}
		
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
