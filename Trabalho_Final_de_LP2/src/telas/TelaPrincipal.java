package telas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class TelaPrincipal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2875856536877113449L;

	/**
	 * Create the panel.
	 */
	public TelaPrincipal() {
		setSize(800,400);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblTitulo = new JLabel("Parque de Diversão");
		springLayout.putConstraint(SpringLayout.NORTH, lblTitulo, 37, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblTitulo, 282, SpringLayout.WEST, this);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		add(lblTitulo);
		
		JButton btnComprarIngresso = new JButton("COMPRAR INGRESSO");
		springLayout.putConstraint(SpringLayout.WEST, btnComprarIngresso, 265, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnComprarIngresso, -207, SpringLayout.SOUTH, this);
		btnComprarIngresso.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnComprarIngresso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnComprarIngresso);
		
		JLabel lblAdm = new JLabel("Entrar como Administrador");
		springLayout.putConstraint(SpringLayout.NORTH, lblAdm, 12, SpringLayout.SOUTH, btnComprarIngresso);
		springLayout.putConstraint(SpringLayout.WEST, lblAdm, 310, SpringLayout.WEST, this);
		lblAdm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblAdm);
		
		

	}

}
