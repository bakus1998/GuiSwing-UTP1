package zad1;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CountryTable {
    public ArrayList<Country> countriesArray = new ArrayList<>();
    String[] arrayToCreateMenu;
    public Object rowData[];

    JTable myJTable;


    public CountryTable(String countriesFileName) {

        InputStream fis = null;
        myJTable = new JTable();

        try {
            fis = new FileInputStream(new File(countriesFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        ArrayList<String> arraylista = new ArrayList<>();
        String s = new String();

        try {
            while ((s = reader.readLine()) != null) {
                arraylista.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        arrayToCreateMenu = arraylista.get(0).split("\\t");


        //add icon and date column
        String[] subsidiaryArray = new String[arrayToCreateMenu.length+2];
        int subCount=0;
        for(int i=0;i<subsidiaryArray.length;i++){
            if(i<arrayToCreateMenu.length){
                subsidiaryArray[i]=arrayToCreateMenu[i];
            }else{
                if(subCount==0){
                    subsidiaryArray[i]="Flag";
                    subCount++;
                }else{
                    subsidiaryArray[i]="Date";
                }
            }
        }
        arrayToCreateMenu=subsidiaryArray;


        countriesArray=new ArrayList<>();
        for(int i=1;i<arraylista.size();i++){
            String[] creating = arraylista.get(i).split("\\t");
            int nr = Integer.valueOf(creating[2]);
            Country c = new Country(creating[0],creating[1],nr);
            countriesArray.add(c);
        }

        myJTable.setModel(new DefaultTableModel(new Object[][]{},arrayToCreateMenu));
        addRow();

        //set Renderers color/image
        myJTable.getColumnModel().getColumn(2).setCellRenderer(new MyRendererColor());
        myJTable.getColumnModel().getColumn(3).setCellRenderer(new MyImageRenderer());

        myJTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        myJTable.getColumnModel().getColumn(4).setPreferredWidth(170);
        myJTable.setRowHeight(35);

    }



    public void addRow()
    {
        DefaultTableModel model = (DefaultTableModel) myJTable.getModel();
        rowData = new Object[5];
        for(int i = 0; i < countriesArray.size(); i++)
        {
            rowData[0] = countriesArray.get(i).country;
            rowData[1] = countriesArray.get(i).capital;
            rowData[2] = countriesArray.get(i).population;
            rowData[3] = countriesArray.get(i).icon;
            rowData[4] = countriesArray.get(i).date;
            model.addRow(rowData);
        }

        //blokada
        for(int i=0;i<arrayToCreateMenu.length;i++){
            if(i!=2){
                myJTable.getColumn(arrayToCreateMenu[i]).setCellEditor(new MyEditor(new JCheckBox()));
            }
        }
    }


    public JTable create() {
        return myJTable;
    }
}
