package telas;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

public class VendaIngresso extends JPanel {
	 	private JComboBox<String> cmbAtracoes;
	    private JLabel lblAtracaoSelecionada;
	    private JButton btnComprar;
	/**
	 * Create the panel.
	 */
	public VendaIngresso() {
//		setTitle("Vendas de Ingressos");
        setSize(800, 400);

        lblAtracaoSelecionada = new JLabel();

        cmbAtracoes = new JComboBox<>();
        cmbAtracoes.addItem("Atração 1");
        cmbAtracoes.addItem("Atração 2");
        cmbAtracoes.addItem("Atração 3");
        cmbAtracoes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String atracaoSelecionada = cmbAtracoes.getSelectedItem().toString();
                lblAtracaoSelecionada.setText("Atração selecionada: " + atracaoSelecionada);
            }
        });

        btnComprar = new JButton("Comprar");
        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String atracaoSelecionada = cmbAtracoes.getSelectedItem().toString();
                JOptionPane.showMessageDialog(VendaIngresso.this, "Ingresso para " + atracaoSelecionada + " comprado!");
            }
        });
        SpringLayout springLayout = new SpringLayout();
        springLayout.putConstraint(SpringLayout.NORTH, btnComprar, 173, SpringLayout.SOUTH, lblAtracaoSelecionada);
        springLayout.putConstraint(SpringLayout.WEST, btnComprar, 19, SpringLayout.WEST, cmbAtracoes);
        springLayout.putConstraint(SpringLayout.NORTH, cmbAtracoes, 68, SpringLayout.SOUTH, lblAtracaoSelecionada);
        springLayout.putConstraint(SpringLayout.WEST, cmbAtracoes, 131, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.EAST, cmbAtracoes, -158, SpringLayout.EAST, this);
        springLayout.putConstraint(SpringLayout.SOUTH, cmbAtracoes, -84, SpringLayout.NORTH, btnComprar);
        springLayout.putConstraint(SpringLayout.NORTH, lblAtracaoSelecionada, 15, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.WEST, lblAtracaoSelecionada, 178, SpringLayout.WEST, this);
        setLayout(springLayout);

        add(cmbAtracoes);
        add(lblAtracaoSelecionada);
        add(btnComprar);
        
        JButton btnVoltar = new JButton("Voltar");
        springLayout.putConstraint(SpringLayout.NORTH, btnVoltar, 84, SpringLayout.SOUTH, btnComprar);
        springLayout.putConstraint(SpringLayout.WEST, btnVoltar, 26, SpringLayout.WEST, cmbAtracoes);
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 Window window = SwingUtilities.getWindowAncestor(VendaIngresso.this);
        	        if (window != null) {
        	            window.dispose();
        	        }
        		ParqueDiversao p = new ParqueDiversao();
        		p.setVisible(true);
        	}
        });
        add(btnVoltar);

        setVisible(true);
	}


}
