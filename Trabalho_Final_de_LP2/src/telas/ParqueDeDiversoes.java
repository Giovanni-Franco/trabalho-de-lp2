package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ParqueDeDiversoes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParqueDeDiversoes frame = new ParqueDeDiversoes();
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
	public ParqueDeDiversoes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  JPanel panel = new TelaPrincipal();
		  getContentPane().add(panel, BorderLayout.CENTER);
	}

}
