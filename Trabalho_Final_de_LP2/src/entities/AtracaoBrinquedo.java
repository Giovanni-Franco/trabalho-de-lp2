package entities;
import java.util.List;


public class AtracaoBrinquedo extends Atracao{
//altura mínima, restrição de idade e horário do funcionamento.
	private float alturaMinima;
	private int idade;
	private String horaAbertura;
	private String horaEncerramento;
	
	public AtracaoBrinquedo() {
		
	}
	
	public AtracaoBrinquedo(Integer id, int capacidade, String nome, int tipo, List<Integer> dependencias,float alturaMinima, int idade,
			String horaAbertura, String horaEncerramento) {
		super(id, capacidade, nome, tipo, dependencias);
		this.alturaMinima = alturaMinima;
		this.idade = idade;
		this.horaAbertura = horaAbertura;
		this.horaEncerramento = horaEncerramento;
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
	
	@Override
		public String cadastrar() {
			// TODO Auto-generated method stub
			return super.cadastrar();
		}
	@Override
		public String deletar(int id) {
			// TODO Auto-generated method stub
			return super.deletar(id);
		}
	
	@Override
		public String detalhar(int id) {
			// TODO Auto-generated method stub
			return super.detalhar(id);
		}
}
