package telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import entities.Atracao;
import entities.AtracaoBrinquedo;
import javax.swing.JButton;
import javax.swing.SpringLayout;

public class DetalheAtracao extends JFrame {
    private JLabel lblNomeAtracao;
    private JLabel lblCapacidade;
    private JLabel lblIdadeMinima;
    private JLabel lblAlturaMinima;
    private JLabel lblHorarioFuncionamento;
    private JLabel lblDependencia;

    private JLabel atracaoNomeAtracao;
    private JLabel atracaoCapacidade;
    private JLabel atracaoIdadeMinima;
    private JLabel atracaoAlturaMinima;
    private JLabel atracaoHorarioFuncionamento;
    private JLabel atracaoDependencia;
    private JButton btnCancelar;
    

    public DetalheAtracao(Atracao a) {
        setTitle("Detalhes da Atração");
        setBounds(100, 100, 800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font fonteLabels = new Font("Times New Roman", Font.BOLD, 20);

        lblNomeAtracao = new JLabel("Nome da Atração:");
        lblNomeAtracao.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCapacidade = new JLabel("Capacidade:");
        lblCapacidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblIdadeMinima = new JLabel("Idade Mínima:");
        lblIdadeMinima.setFont(fonteLabels);
        lblAlturaMinima = new JLabel("Altura Mínima:");
        lblAlturaMinima.setFont(fonteLabels);
        lblHorarioFuncionamento = new JLabel("Horário de Funcionamento:");
        lblHorarioFuncionamento.setFont(fonteLabels);
        lblDependencia = new JLabel("Dependencia:");
        
        
        atracaoNomeAtracao = new JLabel(a.getNome());
        atracaoCapacidade = new JLabel(Integer.toString(a.getCapacidade()));
         
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(lblNomeAtracao);
        panel.add(atracaoNomeAtracao);
        panel.add(lblCapacidade);
        panel.add(atracaoCapacidade);
        if(a.getTipo().equals("Brinquedo")) {
        	atracaoIdadeMinima = new JLabel(Integer.toString(((AtracaoBrinquedo) a).getIdade()));
            atracaoAlturaMinima = new JLabel(Double.toString(((AtracaoBrinquedo) a).getIdade()));
            atracaoHorarioFuncionamento = new JLabel(((AtracaoBrinquedo) a).getHoraAbertura()+" às "+ ((AtracaoBrinquedo) a).getHoraEncerramento());
            atracaoDependencia = new JLabel(((AtracaoBrinquedo) a).getDependencia());
            panel.add(lblIdadeMinima);
            panel.add(atracaoIdadeMinima);
            panel.add(lblAlturaMinima);
            panel.add(atracaoAlturaMinima);
            panel.add(lblHorarioFuncionamento);
            panel.add(atracaoHorarioFuncionamento);
            panel.add(lblDependencia);
            panel.add(atracaoDependencia);
        }
        SpringLayout springLayout = new SpringLayout();
        springLayout.putConstraint(SpringLayout.NORTH, panel, 31, SpringLayout.NORTH, getContentPane());
        getContentPane().setLayout(springLayout);
        
        getContentPane().add(panel);
        
        btnCancelar = new JButton("Voltar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
           		BuscaAtracao p = new BuscaAtracao();
           		p.setVisible(true);
           	}
        });
        springLayout.putConstraint(SpringLayout.EAST, panel, -191, SpringLayout.WEST, btnCancelar);
        
        
        springLayout.putConstraint(SpringLayout.NORTH, btnCancelar, 25, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, btnCancelar, -105, SpringLayout.EAST, getContentPane());
        getContentPane().add(btnCancelar);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DetalheAtracao(null));
    }
}
