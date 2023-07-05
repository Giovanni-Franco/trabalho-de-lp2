package telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class ParqueDiversao extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParqueDiversao frame = new ParqueDiversao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ParqueDiversao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		
		JLabel lblAdm = new JLabel("Entrar como Administrador");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAdm, 298, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, lblAdm, 310, SpringLayout.WEST, this);
		lblAdm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdm.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TelaAdministrador frame = new TelaAdministrador();
                setContentPane(frame);
            }
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			});
		contentPane.add(lblAdm);
		
		
		JLabel lblTitulo = new JLabel("Parque de Diversão");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTitulo, 66, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTitulo, 270, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.NORTH, lblTitulo, 37, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblTitulo, 282, SpringLayout.WEST, this);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblTitulo);
		
		JButton btnComprarIngresso = new JButton("COMPRAR INGRESSO");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAdm, 70, SpringLayout.SOUTH, btnComprarIngresso);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnComprarIngresso, 161, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnComprarIngresso, 253, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, btnComprarIngresso, 265, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnComprarIngresso, -207, SpringLayout.SOUTH, this);
		btnComprarIngresso.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnComprarIngresso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendaIngresso frame = new VendaIngresso();
				setContentPane(frame);
			}
		});
		contentPane.add(btnComprarIngresso);
		setContentPane(contentPane);
		springLayout.putConstraint(SpringLayout.NORTH, lblAdm, 12, SpringLayout.SOUTH, btnComprarIngresso);
	}

}
