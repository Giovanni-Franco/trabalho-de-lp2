package entities;

import java.util.ArrayList;
import java.util.List;

import dados.Arquivo;

public class AtracaoBrinquedo extends Atracao {
//altura mínima, restrição de idade e horário do funcionamento.
	private String dependencia;
	private float alturaMinima;
	private int idade;
	private String horaAbertura;
	private String horaEncerramento;

	public AtracaoBrinquedo() {

	}

	public AtracaoBrinquedo(Integer id, int capacidade, String nome, String tipo, String dependencia,
			float alturaMinima, int idade, String horaAbertura, String horaEncerramento) {
		super(id, capacidade, nome, tipo);
		this.alturaMinima = alturaMinima;
		this.idade = idade;
		this.horaAbertura = horaAbertura;
		this.horaEncerramento = horaEncerramento;
		this.dependencia = dependencia;
	}

	public float getAlturaMinima() {
		return alturaMinima;
	}

	public void setAlturaMinima(float alturaMinima) {
		this.alturaMinima = alturaMinima;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getHoraAbertura() {
		return horaAbertura;
	}

	public void setHoraAbertura(String horaAbertura) {
		this.horaAbertura = horaAbertura;
	}

	public String getHoraEncerramento() {
		return horaEncerramento;
	}

	public void setHoraEncerramento(String horaEncerramento) {
		this.horaEncerramento = horaEncerramento;
	}

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	@Override
	public String cadastrar() {
		if(Arquivo.salvarAtracao(toString()))
			return "Atração: "+getNome()+"\n"
				+"Capacidade: "+getCapacidade()+" lugares\n"
				+ "Horário de funcionamento:" +getHoraAbertura()+" as "+getHoraEncerramento()+"\n"
				+"CADASTRADO COM SUCESSO!";
		return "FALHA AO CADASTRAR";
		
	}

	@Override
	public String toString() {
		return super.toString() + ";" + alturaMinima + ";" + idade + ";" + horaAbertura + ";" + horaEncerramento+ ";" + dependencia;
	}

	@Override
	public String deletar(int index) {
		List<Atracao> atracoes = Arquivo.lerAtracoes(); 
		Atracao a1 = atracoes.get(index); //buscando a atração no vetor
		for (Atracao atracao : atracoes) {
			AtracaoBrinquedo a = (AtracaoBrinquedo)atracao; //ele faz o cast de atração para atração brinquedo
			if (a.getDependencia()!=null && a.getDependencia().equals(a1.getNome())) { //testa dependencia e se for igual a atração a ser exluída e seta null 
				a.setDependencia(null);
			}
		}
		if(atracoes.remove(a1)) {
			Arquivo.deletarAtracao(atracoes); //remove a atração do arquivo
			return "Removido com sucesso";
		}
		return "Falha ao remover";
	}

	@Override
	public Atracao buscar(Atracao a) {
		// TODO Auto-generated method stub
		return super.buscar(a);
	}

}
