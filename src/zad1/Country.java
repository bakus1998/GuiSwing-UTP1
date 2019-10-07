package zad1;

import javax.swing.*;

public class Country {
    String country;
    String capital;
    int population;
    String date=null;
    Icon icon;

    public Country(String country,String capital,int population){
        this.capital=capital;
        this.country=country;
        this.population=population;
        String myFlag = "data/flags/" + country+ ".png";
        icon= new ImageIcon(myFlag);
    }
}
