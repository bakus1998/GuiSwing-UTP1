# Zadanie: tabela państw

Przedstawić w tabeli JTable państwa z pliku.

Plik powinien mieć następującą postać:
nazwa_kol1<TAB>nazwa_kol2<TAB> ....
nazwa_państwa1<TAB>stolica1<TAB> ludność1 ....


Na przykład:

Name    Capital    Population
Republic of Poland    Warsaw    38500
Czech Republic    Prague    10500 
Kingdom of Spain    Madrid    46599


Proszę zwrócić uwagę, że pola są rozdzielane przez znak tabulacji,  liczba ludności podawana jest w tysiącach. Kolumny zawierające nazwy i stolice państw są nieedytowalne, natomiast dane z kolumny zawierającej ludność można edytować.

Plik powinien  znajdować się w katalogu data projektu i mieć nazwę countries.txt


Wymaganiem podstawowym jest pokazanie państw w tabeli z użyciem następującej klasy Main, która uruchamia cały program:


    import javax.swing.*;

    public class Main {

      private JTable ctab;

      public void createTable(String countriesFileName) throws Exception {
        ctab = new CountryTable(countriesFileName).create();
      }

      public void showGui() {
        SwingUtilities.invokeLater( new Runnable() {
          public void run() {
            JFrame f = new JFrame("Countries table");
            f.add( new JScrollPane(ctab) );
            f.pack();
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);
          }
        });
      }

      public static void main(String[] args)  {
        Main main = new Main();
        try {
          main.createTable("data/countries.txt");
          main.showGui();
        } catch(Exception exc) {
          JOptionPane.showMessageDialog(null, "Table creation failed, " + exc);
        }
      }
    }
    
    
Struktura projektu oraz zawartośc pliku Main.java będzie wygenerowana,
Zawartości pliku Main.java nie wolno zmieniać. Nazwa i położenie pliku państw jest obowiązakowa.
Archiuwm uploadowanego projektu winno zawierać katalog data z plikiem countries.txt (sprawdzić, czy sa zaznaczenia przy eksporcie projektu)

Za wykonanie podstawowej części zadania mozna uzyskać 3 punkty.

Dodatkowe wymagania:

a) kolumny tabeli mają mieć nazwy z  pierwszego wiersza pliku +2 p.

b) dane o ludności mają być traktowane jako liczby +1 p.

c) i pokazywane w tabeli jak liczby +1 p.

d) pokazać w tabeli flagi państw (wymaga modyfikacji pliku państw i dodanie kolumny, pokazującej flagę jako grafikę) +2 p.

e) zapewnić pokazywanie wszystkich państw świata +2 p.

f) wyróżnić  komórki z liczbą ludności dla państw z ludnością > 20 mln czerwonym kolorem pisma +2 p.

g) pokazać w tabeli dodatkową kolumnę wyświetlającą datę ostatniej modyfikacji kolumny ludności +2 p.

