package zad1;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyRendererColor extends DefaultTableCellRenderer
{
    JTable table;
    int row;
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        this.table=table;
        this.row=row;
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        int val = Integer.parseInt(table.getModel().getValueAt(row,column).toString());

        if(val>20000){
            cellComponent.setForeground(Color.RED);
        }else{
            cellComponent.setForeground(Color.BLACK);
        }

        if(hasFocus){
            setCell(row);
        }
        return cellComponent;
    }

    @Override
    public void firePropertyChange(String propertyName, int oldValue, int newValue) {
        super.firePropertyChange(propertyName, oldValue, newValue);
    }

    public void setCell(int row){
        //setDateEdit
        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String data = formatter.format(date);
        table.getModel().setValueAt(data,row,4);
    }
}
