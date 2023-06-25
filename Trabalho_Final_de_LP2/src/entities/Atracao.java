package entities;

import java.util.ArrayList;
import java.util.List;

public class Atracao {
	private Integer id;
	private int capacidade;
	private String nome;
	private int tipo;
	private List <Integer> dependencias = new ArrayList<>();
	
	
	public Atracao(Integer id, int capacidade, String nome, int tipo, List<Integer> dependencias) {
		super();
		this.id = id;
		this.capacidade = capacidade;
		this.nome = nome;
		this.tipo = tipo;
		this.dependencias = dependencias;
	}

	public Atracao(){
		
	}
	
	public String cadastrar() {
		return"";
	}	
	
	public String detalhar(int id) {
		return"";
	}
	
	public String deletar(int id) {
		return"";
	}
	
	public void adicionarDependencia(Integer id) {
		getDependencias().add(id);
	}
	public void removerDependencia(Integer id) {
		getDependencias().remove(id);
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
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public List <Integer> getDependencias() {
		return dependencias;
	}
	
	public void setDependencias(List<Integer> dependencias) {
		this.dependencias = dependencias;
	}

	
	
	
}
