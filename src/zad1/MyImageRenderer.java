package zad1;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MyImageRenderer extends JLabel implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        ImageIcon img = (ImageIcon) value;
        this.setIcon(img);
        return this;
    }
}
