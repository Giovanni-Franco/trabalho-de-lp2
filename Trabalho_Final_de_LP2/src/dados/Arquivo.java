package dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

import entities.Atracao;
import entities.AtracaoAlimentacao;
import entities.AtracaoBrinquedo;

public class Arquivo {
	
	public TreeMap<Integer, Atracao> lerAtracao(Integer tipo) {	
		String endereco = "dados/atracoes.txt"; //Coleta de Endere�o
		File arquivo = new File(endereco);
		TreeMap<Integer, Atracao> atracoes= new TreeMap<Integer, Atracao>();

		if (arquivo.canRead()) {
			try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
				// lê a primeira linha e a ignora
				br.readLine();

				String line = br.readLine();
				while (line != null) {
					String[] vect = line.split(";");
					Atracao a;
					//compara o tipo da atracao 
					if(tipo==1) {
						a = new AtracaoBrinquedo();
						a.setId(Integer.parseInt(vect[0]));//trata string para inteiro
						a.setCapacidade(Integer.parseInt(vect[1]));//trata string para inteiro
						a.setNome(vect[2]);
						a.setTipo(Integer.parseInt(vect[3]));
						String[] dep = vect[4].split(",");//
						for(int j=0;j<dep.length;j++) {
							a.getDependencias().add(Integer.parseInt(dep[j]));
						}
						//restrições de brinquedos
						((AtracaoBrinquedo) a).setAlturaMinima(Float.parseFloat(vect[5]));
						((AtracaoBrinquedo) a).setIdade(Integer.parseInt(vect[6]));
						((AtracaoBrinquedo) a).setHoraAbertura(vect[7]);
						((AtracaoBrinquedo) a).setHoraAbertura(vect[8]);
					}
					else {
						a = new AtracaoAlimentacao();
						a.setId(Integer.parseInt(vect[0]));//trata string para inteiro
						a.setCapacidade(Integer.parseInt(vect[1]));//trata string para inteiro
						a.setNome(vect[2]);
						a.setTipo(Integer.parseInt(vect[3]));
						String[] dep = vect[4].split(",");
						for(int j=0;j<dep.length;j++) {
							a.getDependencias().add(Integer.parseInt(dep[j]));
						}
					}

					atracoes.put(a.getId(), a);// adicionando a atracao ao Map
					line = br.readLine();
				}
			} catch (IOException e) { // trata as exce��es do tipo FileNotFoundException
				System.out.println(e.getMessage());
				;
			}

		}
		return atracoes;
	}
	
	public static void salvarAtracao(String linha) {
		File arquivo = new File("dados/atracoes.txt");
		try {
			if (!arquivo.exists()) {
				// cria um arquivo (vazio)
				arquivo.createNewFile();
			}
			// escreve no arquivo
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(linha);
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public int numLinhasArquivo(String endereco) {
		int numLin = 0;
		try {		
			Scanner arq = new Scanner (new File (endereco));	      
	        while (arq.hasNextLine()){
	        	arq.nextLine();
	        	numLin ++;
	        }
		}
		catch (IOException e) { // trata as exce��es do tipo FileNotFoundException   
	        System.out.println(e.getMessage());;   
	    }
		return numLin-1;
	}
}
