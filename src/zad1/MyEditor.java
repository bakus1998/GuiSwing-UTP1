package zad1;

import javax.swing.*;
import java.util.EventObject;

public class MyEditor extends DefaultCellEditor {
    //lock cells
    public MyEditor(JCheckBox checkBox) {
        super(checkBox);
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return false;
    }
}
