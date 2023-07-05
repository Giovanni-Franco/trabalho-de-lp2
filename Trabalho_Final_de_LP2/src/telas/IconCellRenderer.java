package telas;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class IconCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Verifica se o valor é um ImageIcon
        if (value instanceof ImageIcon) {
            // Configura o ícone na célula
            setIcon((ImageIcon) value);
            setText(null);

            // Define o tamanho da célula com base nas dimensões do ícone
            setPreferredSize(new Dimension(getIcon().getIconWidth(), getIcon().getIconHeight()));
        }

        return component;
    }
}