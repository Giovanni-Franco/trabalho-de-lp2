package telas;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TelaAdministrador extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaAdministrador() {
		setSize(800, 400);
		setLayout(null);
		
		JButton btnCadastrarAtracao = new JButton("CADASTRAR ATRAÇÃO");
		btnCadastrarAtracao.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCadastrarAtracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window window = SwingUtilities.getWindowAncestor(TelaAdministrador.this);
    	        if (window != null) {
    	            window.dispose();
    	        }
				CadastroAtracao c = new CadastroAtracao();
				c.setVisible(true);
			}
		});
		btnCadastrarAtracao.setBounds(234, 95, 328, 81);
		add(btnCadastrarAtracao);
		
		JButton btnBuscarAtracao = new JButton("BUSCAR ATRAÇÃO");
		btnBuscarAtracao.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnBuscarAtracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window window = SwingUtilities.getWindowAncestor(TelaAdministrador.this);
    	        if (window != null) {
    	            window.dispose();
    	        }
				BuscaAtracao c = new BuscaAtracao();
				c.setVisible(true);
			}
		});
		btnBuscarAtracao.setBounds(234, 212, 328, 81);
		add(btnBuscarAtracao);
		
		JInternalFrame internalFrame = new JInternalFrame("administrador");
		internalFrame.setBounds(0, 0, 800, 33);
		add(internalFrame);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(685, 44, 59, 21);
		add(btnSair);
		btnSair.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 Window window = SwingUtilities.getWindowAncestor(TelaAdministrador.this);
        	        if (window != null) {
        	            window.dispose();
        	        }
        		ParqueDiversao p = new ParqueDiversao();
        		p.setVisible(true);
        	}
        });
		internalFrame.setVisible(true);
		}		 
	}
