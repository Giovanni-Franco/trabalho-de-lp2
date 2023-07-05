package entities;

import java.util.List;

import dados.Arquivo;

public class Atracao {
	private Integer id;
	private int capacidade;
	private String nome;
	private String tipo;
	
	
	
	public Atracao(Integer id, int capacidade, String nome, String tipo) {
		super();
		this.id = id;
		this.capacidade = capacidade;
		this.nome = nome;
		this.tipo = tipo;
		
	}

	public Atracao(){
		
	}
	
	public String cadastrar() {
		if(Arquivo.salvarAtracao(toString()))
			return "Atração: "+nome+"\n"
				+"Capacidade: "+capacidade+" lugares\n"
				+"CADASTRADO COM SUCESSO!";
		return "FALHA AO CADASTRAR";
		
	}	
	
	@Override
	public String toString() {
		return id + ";" + capacidade + ";" + nome + ";" + tipo
				+ ";";
	}

	public Atracao buscar(Atracao a) {
		List<Atracao> atracoes = Arquivo.lerAtracoes();
		for (Atracao item : atracoes) {
            if (item.getId() == a.id) {
                return item;
            }
        }
        return null; // Retorna null se o item não for encontrad
        
    }
	
	public String deletar(int index) {
		List<Atracao> atracoes = Arquivo.lerAtracoes();
		Atracao a1 = atracoes.get(index);
		if(atracoes.remove(a1)) {
			Arquivo.deletarAtracao(atracoes);
			return "Removido com sucesso";
		}
		return "Falha ao remover";
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCapacidade() {
		return capacidade;
	}
	
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	
	
	
}
