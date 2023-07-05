package telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dados.Arquivo;
import entities.Atracao;
import entities.AtracaoBrinquedo;

public class BuscaAtracao extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnCancelar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaAtracao frame = new BuscaAtracao();
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
	public BuscaAtracao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		List<Atracao> atracoes = Arquivo.lerAtracoes();
        
        // Criação do modelo da tabela com base no array de dados
        String[] columnNames = {"Nome", "Capacidade", "Tipo","",""};
        DefaultTableModel tableModel = new DefaultTableModel(null, columnNames);
        for (Atracao a : atracoes) {
        	tableModel.addRow(new Object[]{a.getNome(), a.getCapacidade(),a.getTipo(),new ImageIcon("icons/lupa.png"),new ImageIcon("icons/lixeira.png")});
		}

        // Criação da tabela
        table = new JTable(tableModel);
     // Configuração do renderizador de células para exibir os ícones
        table.getColumnModel().getColumn(3).setCellRenderer(new IconCellRenderer());
        table.getColumnModel().getColumn(3).setPreferredWidth(0);
        table.getColumnModel().getColumn(4).setCellRenderer(new IconCellRenderer());
        table.getColumnModel().getColumn(4).setPreferredWidth(0);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = table.columnAtPoint(e.getPoint());
                int row = table.rowAtPoint(e.getPoint());
                // Verifica se o clique ocorreu na coluna dos ícones
                if (column == 3) {
                	int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        int selectedRowIndex = table.convertRowIndexToModel(selectedRow);
                        Atracao selectedItem = atracoes.get(selectedRowIndex);
                        dispose();
                        DetalheAtracao detalhe = new DetalheAtracao(selectedItem);
                        detalhe.setVisible(true);
                    }
                }
                if (column == 4) {
                	int selectedRow = table.getSelectedRow(); 
                    if (selectedRow != -1) {
                        int selectedRowIndex = table.convertRowIndexToModel(selectedRow);//identifica qual foi a linha selecionada
                        Atracao selectedItem = atracoes.get(selectedRowIndex); //busca no vetor de atrações
                        deletarAtracao(selectedItem, selectedRowIndex);//aciona o metodo atrações
                        dispose();
                        BuscaAtracao b = new BuscaAtracao();
                        b.setVisible(true);
                        
                    }
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
        
        btnCancelar = new JButton("Voltar");
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -85, SpringLayout.WEST, btnCancelar);
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
           		ParqueDiversao p = new ParqueDiversao();
           		p.setVisible(true);
           	}
        });
        sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancelar, 10, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, btnCancelar, -58, SpringLayout.EAST, contentPane);
        contentPane.add(btnCancelar);
	}
	private void deletarAtracao(Atracao a, int index) { 
		if(a.getTipo().equals("Brinquedo")) {//identifica o tipo de atração
			AtracaoBrinquedo a1 = (AtracaoBrinquedo)a; //se o tipo for brinquedo é instaciado nova atração do tipo brinquedo e faz o cast
			a1.deletar(index); //chama o metodo deletar da classe briqnuedo
		}
		else
			a.deletar(index); // deleta a atração alimentação
	}
}
