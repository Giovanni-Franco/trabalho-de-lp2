
package telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

import dados.Arquivo;
import entities.Atracao;
import entities.AtracaoAlimentacao;
import entities.AtracaoBrinquedo;

public class CadastroAtracao extends JFrame {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new CadastroAtracao());
	}
	
	private JLabel lblNomeAtracao;
	private JLabel lblCapacidade;
	private JLabel lblIdadeMinima;
	private JLabel lblAlturaMinima;
	private JLabel lblHorarioAbertura;
	private JLabel lblHorarioEncerramento;

	private JTextField txtNomeAtracao;
	private JTextField txtCapacidade;
	private JTextField txtIdadeMinima;
	private JTextField txtAlturaMinima;
	private JTextField txtHorarioAbertura;
	private JTextField txtHorarioEncerramento;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JComboBox<String> cmbTipoAtracao;

	private String tipoAtracao;
	private JComboBox<String> cmbDependencia;
	private JButton btnAddDependencia;
	private JButton btnRemoverDependencia;

	public CadastroAtracao() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		setTitle("Cadastro de Atração");
		setBounds(100, 100, 800, 554);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font fonteLabels = new Font("Times New Roman", Font.BOLD, 20);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		lblNomeAtracao = new JLabel("Nome da Atração:");
		lblNomeAtracao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNomeAtracao.setVisible(false);
		lblCapacidade = new JLabel("Capacidade:");
		lblCapacidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCapacidade.setVisible(false);
		lblIdadeMinima = new JLabel("Idade Mínima:");
		lblIdadeMinima.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdadeMinima.setVisible(false);
		lblAlturaMinima = new JLabel("Altura Mínima:");
		lblAlturaMinima.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAlturaMinima.setVisible(false);
		lblHorarioAbertura = new JLabel("Horário de Abertura:");
		lblHorarioAbertura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHorarioAbertura.setVisible(false);
		lblHorarioEncerramento = new JLabel("Horário de Encerramento:");
		lblHorarioEncerramento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHorarioEncerramento.setVisible(false);

		txtNomeAtracao = new JTextField(20);
		txtNomeAtracao.setVisible(false);
		txtCapacidade = new JTextField(10);
		txtCapacidade.setVisible(false);
		txtIdadeMinima = new JTextField(10);
		txtIdadeMinima.setVisible(false);
		txtAlturaMinima = new JTextField(10);
		txtAlturaMinima.setVisible(false);
		txtHorarioAbertura = new JTextField(10);
		txtHorarioAbertura.setVisible(false);
		txtHorarioEncerramento = new JTextField(10);
		txtHorarioEncerramento.setVisible(false);
		
		cmbTipoAtracao = new JComboBox<>();
		
		List<Atracao> atracoes = Arquivo.lerAtracoes();
		cmbDependencia = new JComboBox<String>();
		for (Atracao a : atracoes) {
			if(a.getTipo().equals("Brinquedo"))
				cmbDependencia.addItem(a.getNome());
		}
		cmbDependencia.setVisible(false);
		
		btnRemoverDependencia = new JButton("Remover");
		btnRemoverDependencia.setVisible(false);
		btnRemoverDependencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbDependencia.setVisible(false);
				btnRemoverDependencia.setVisible(false);
				btnAddDependencia.setVisible(true);
			}
		});
		btnAddDependencia = new JButton("Adicionar");
		btnAddDependencia.setVisible(false);
		btnAddDependencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbDependencia.setVisible(true);
				btnRemoverDependencia.setVisible(true);
				btnAddDependencia.setVisible(false);
			}
		});
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setVisible(false);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 46, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 227, SpringLayout.WEST, getContentPane());
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(lblNomeAtracao);
		panel.add(txtNomeAtracao);
		panel.add(lblCapacidade);
		panel.add(txtCapacidade);
		panel.add(lblIdadeMinima);
		panel.add(txtIdadeMinima);
		panel.add(lblAlturaMinima);
		panel.add(txtAlturaMinima);
		panel.add(lblHorarioAbertura);
		panel.add(txtHorarioAbertura);
		panel.add(lblHorarioEncerramento);
		panel.add(txtHorarioEncerramento);
		
		
		panel.add(btnAddDependencia);
		panel.add(btnRemoverDependencia);
		panel.add(cmbDependencia);
		panel.add(btnCadastrar);


		springLayout.putConstraint(SpringLayout.NORTH, btnCadastrar, 26, SpringLayout.SOUTH, panel);
		
		springLayout.putConstraint(SpringLayout.SOUTH, cmbTipoAtracao, -6, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, cmbTipoAtracao, -379, SpringLayout.EAST, getContentPane());
		
		cmbTipoAtracao.addItem("Selecione o tipo da atração");
		cmbTipoAtracao.addItem("Brinquedo");
		cmbTipoAtracao.addItem("Alimentação");
		cmbTipoAtracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoAtracao = cmbTipoAtracao.getSelectedItem().toString();
				if (!tipoAtracao.equals("Selecione o tipo da atração")) {
					lblNomeAtracao.setVisible(true);
					txtNomeAtracao.setVisible(true);
					lblCapacidade.setVisible(true);
					txtCapacidade.setVisible(true);
					btnCadastrar.setVisible(true);
					if (tipoAtracao.equals("Brinquedo")) {
						lblIdadeMinima.setVisible(true);
						txtIdadeMinima.setVisible(true);
						lblAlturaMinima.setVisible(true);
						txtAlturaMinima.setVisible(true);
						lblHorarioAbertura.setVisible(true);
						txtHorarioAbertura.setVisible(true);
						lblHorarioEncerramento.setVisible(true);
						txtHorarioEncerramento.setVisible(true);
						btnAddDependencia.setVisible(true);
					} else {
						lblIdadeMinima.setVisible(false);
						txtIdadeMinima.setVisible(false);
						lblAlturaMinima.setVisible(false);
						txtAlturaMinima.setVisible(false);
						lblHorarioAbertura.setVisible(false);
						txtHorarioAbertura.setVisible(false);
						lblHorarioEncerramento.setVisible(false);
						txtHorarioEncerramento.setVisible(false);
						cmbDependencia.setVisible(false);
						btnRemoverDependencia.setVisible(false);
						btnAddDependencia.setVisible(false);
					}
					btnCadastrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cadastrarAtracao();
						}
					});
					panel.repaint();
				} else {
					lblNomeAtracao.setVisible(false);
					txtNomeAtracao.setVisible(false);
					lblCapacidade.setVisible(false);
					txtCapacidade.setVisible(false);
					lblHorarioAbertura.setVisible(false);
					txtHorarioAbertura.setVisible(false);
					lblHorarioEncerramento.setVisible(false);
					txtHorarioEncerramento.setVisible(false);
					btnCadastrar.setVisible(false);
					lblIdadeMinima.setVisible(false);
					txtIdadeMinima.setVisible(false);
					lblAlturaMinima.setVisible(false);
					txtAlturaMinima.setVisible(false);
					cmbDependencia.setVisible(false);
					btnRemoverDependencia.setVisible(false);
					btnAddDependencia.setVisible(false);
				}
			}
		});
		
		
		getContentPane().add(panel);

		btnCancelar = new JButton("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, btnCancelar, 0, SpringLayout.NORTH, cmbTipoAtracao);
		springLayout.putConstraint(SpringLayout.EAST, btnCancelar, -164, SpringLayout.EAST, getContentPane());
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				TelaAdministrador p = new TelaAdministrador();
				setContentPane(p);
			}
		});
		getContentPane().add(btnCancelar);
		getContentPane().add(cmbTipoAtracao);

		

		setVisible(true);
	}

	private void cadastrarAtracao() {
		Atracao a;

		String nomeAtracao = txtNomeAtracao.getText();
		String capacidade = txtCapacidade.getText();
		String idadeMinima = txtIdadeMinima.getText();
		String alturaMinima = txtAlturaMinima.getText();
		String horarioAbertura = txtHorarioAbertura.getText();
		String horarioEncerramento = txtHorarioEncerramento.getText();
		String dependencia = null;
		if(cmbDependencia.getSelectedItem()!=null)
			dependencia = cmbDependencia.getSelectedItem().toString();

		// Aqui você pode fazer o processamento dos dados inseridos, como salvar no
		// banco de dados, exibir em console, etc.

		if (tipoAtracao.equals("Brinquedo")) {
			if (nomeAtracao.isEmpty() || capacidade.isEmpty() || idadeMinima.isEmpty() || alturaMinima.isEmpty()
					|| horarioAbertura.isEmpty() || horarioEncerramento.isEmpty()) {
				JOptionPane.showMessageDialog(CadastroAtracao.this, "Não foi possível cadastrar atração");
			} else {
				a = new AtracaoBrinquedo();
				a.setId(hashCode());
				a.setCapacidade(Integer.parseInt(capacidade));// trata string para inteiro
				a.setNome(nomeAtracao);
				a.setTipo(tipoAtracao);
				((AtracaoBrinquedo) a).setAlturaMinima(Float.parseFloat(alturaMinima));
				((AtracaoBrinquedo) a).setIdade(Integer.parseInt(idadeMinima));
				((AtracaoBrinquedo) a).setHoraAbertura(horarioAbertura);
				((AtracaoBrinquedo) a).setHoraEncerramento(horarioEncerramento);
				((AtracaoBrinquedo) a).setDependencia(dependencia);
				JOptionPane.showMessageDialog(CadastroAtracao.this, a.cadastrar());
				cmbTipoAtracao.setSelectedItem("Selecione o tipo da atração");
			}
		} else if (tipoAtracao.equals("Alimentação")){
			if (nomeAtracao.isEmpty() || capacidade.isEmpty()) {
				JOptionPane.showMessageDialog(CadastroAtracao.this, "Não foi possível cadastrar atração");
			} else {
				a = new AtracaoAlimentacao();
				a.setId(hashCode());// trata string para inteiro
				a.setCapacidade(Integer.parseInt(capacidade));// trata string para inteiro
				a.setNome(nomeAtracao);
				a.setTipo(tipoAtracao);
				JOptionPane.showMessageDialog(CadastroAtracao.this, a.cadastrar());
				cmbTipoAtracao.setSelectedItem("Selecione o tipo da atração");
			}
		}
	}
}
