package dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Atracao;
import entities.AtracaoAlimentacao;
import entities.AtracaoBrinquedo;

public class Arquivo {

	public static List<Atracao> lerAtracoes() {
		String endereco = "../atracoes.txt"; // Coleta de Endere�o
		File arquivo = new File(endereco);
		List<Atracao> atracoes = new ArrayList<>();

		if (arquivo.canRead()) {
			try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
				String line = br.readLine();
				while (line != null) {
					String[] vect = line.split(";");
					Atracao a;
					// compara o tipo da atracao
					if (vect[3].equals("Brinquedo")) {
						a = new AtracaoBrinquedo();
						a.setId(Integer.parseInt(vect[0]));// trata string para inteiro
						a.setCapacidade(Integer.parseInt(vect[1]));// trata string para inteiro
						a.setNome(vect[2]);
						a.setTipo(vect[3]);
						// restrições de brinquedos
						//Transforma para acessar atributos private
						((AtracaoBrinquedo) a).setDependencia(vect[4]);
						((AtracaoBrinquedo) a).setAlturaMinima(Float.parseFloat(vect[5]));
						((AtracaoBrinquedo) a).setIdade(Integer.parseInt(vect[6]));
						((AtracaoBrinquedo) a).setHoraAbertura(vect[7]);
						((AtracaoBrinquedo) a).setHoraEncerramento(vect[8]);
						((AtracaoBrinquedo) a).setDependencia(vect[9]);
					} else {
						a = new AtracaoAlimentacao();
						a.setId(Integer.parseInt(vect[0]));// trata string para inteiro
						a.setCapacidade(Integer.parseInt(vect[1]));// trata string para inteiro
						a.setNome(vect[2]);
						a.setTipo(vect[3]);
					}

					atracoes.add(a);// adicionando a atracao ao Map
					line = br.readLine();
				}
			} catch (IOException e) { // trata as exce��es do tipo FileNotFoundException
				System.out.println(e.getMessage());
				;
			}

		}
		return atracoes;//retorna a lista de atraçoes
	}

	public static boolean salvarAtracao(String linha) {
		String endereco = "../atracoes.txt";
		File arquivo = new File(endereco);
		try {
			if (!arquivo.exists()) {
				// cria um arquivo (vazio)
				arquivo.createNewFile();
			}
			// escreve no arquivo
			FileWriter fw = new FileWriter(arquivo, true); //abre o arquivo para escrita
			BufferedWriter bw = new BufferedWriter(fw); // permissão de escrever
			bw.write(linha);
			bw.newLine();
			bw.close(); //fecha a permissão
			fw.close(); //fecha o arquivo
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();//tratamento de erro
		}
		return false;
	}

	public static void deletarAtracao(List<Atracao> atracoes) {
		String endereco = "../atracoes.txt";
        String newContent = "";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(endereco))) {
            writer.write(newContent); //esvazia o arquivo
            for (Atracao a : atracoes) {
				salvarAtracao(a.toString()); // pra cada registro no list ele chama o "salvar a atração"
			}
          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
