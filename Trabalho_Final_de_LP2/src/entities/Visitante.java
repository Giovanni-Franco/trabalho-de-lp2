package entities;

import java.util.List;

public class Visitante {
	String nome;
	double altura;
	int idade;
    private List<Ingresso> ingressos;

    // Construtores, getters e setters

    public void comprarIngresso(Ingresso ingresso) {
        // Implementação para comprar um ingresso
    }

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
