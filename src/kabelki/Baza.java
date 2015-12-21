/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kabelki;
 
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
/**
 *
 * @author Ardian
 */
public class Baza {
    public static final String nazwa_uzytkownika = System.getProperty("user.name");
    
     
    
    public static final String DRIVER = "org.sqlite.JDBC";
    
    public static final String DB_URL = "jdbc:sqlite:C:/Users/"+nazwa_uzytkownika.toString()+"/kabelki/kabelki.db";
    
    
    private Connection conn;
    private Statement stat;
    
    public Baza() {
        try {
            Class.forName(Baza.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
 
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
 
        createTables();
    }
    
     public boolean createTables()  {
        String createPrzewody = "CREATE TABLE IF NOT EXISTS przewody (id_przew INTEGER PRIMARY KEY AUTOINCREMENT, marka varchar(255), zdjecie varchar(255), ilosc varchar(255), cena varchar(255))";
        try {   //id_przew,marka, zdjecie, ilosc, cena
            stat.execute(createPrzewody);
            
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }
      
     public boolean insertPrzewod(String marka, String zdjecie, String ilosc,  String cena) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into przewody values (NULL, ?, ?, ?, ?);");
            prepStmt.setString(1, marka);
            prepStmt.setString(2, zdjecie);
            prepStmt.setString(3, ilosc);
            prepStmt.setString(4, cena);

            prepStmt.execute();
            
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu przewodu");
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
      //id_przew,marka, zdjecie, ilosc, cena
     public boolean updatePrzewod(int id, String marka, String zdjecie, String ilosc,  String cena){
         try {
            String asd = "UPDATE przewody SET marka='"+marka+"',zdjecie='"+zdjecie+"',ilosc='"+ilosc+"', cena='"+cena+"' WHERE id_przew='"+id+"';";
            PreparedStatement prepStmt = conn.prepareStatement(asd);  
            prepStmt.execute();
         } catch (SQLException e) {
            System.err.println("Blad przy aktualizowaniu klientaa");
            e.printStackTrace();
            return false;
         }
            return true;
     }
     
     public boolean wywalPrzewod(int id){
         try {
            String asd = "DELETE FROM przewody WHERE id_przew='"+id+"';";
            PreparedStatement prepStmt = conn.prepareStatement(asd);  
            prepStmt.execute();
         } catch (SQLException e) {
            System.err.println("Blad przy wywalaniu klientaa");
            e.printStackTrace();
            return false;
         }
            return true;
     }
     //id_przew,marka, zdjecie, ilosc, cena
     public List<Przewod> selectPrzewod() {
        List<Przewod> przewody = new LinkedList<Przewod>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM przewody");
            int id;
            String marka, zdjecie, ilosc, cena;
            while(result.next()) {
                id = result.getInt("id_przew");
                marka = result.getString("marka");
                zdjecie = result.getString("zdjecie");
                ImageIcon toZdjecie = new ImageIcon(zdjecie);
                ilosc = result.getString("ilosc");
                cena = result.getString("cena");
                przewody.add(new Przewod(id, marka, toZdjecie, ilosc, cena));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return przewody;
    }
     
     public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}
