/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kabelki;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Ardian
 */
public class Ustawienia {
    public static final String nazwa_uzytkownika = System.getProperty("user.name");
    public static void Ustaw() throws IOException {
        
        //try{
        File ustawienia = new File("C:/Users/"+nazwa_uzytkownika.toString()+"/kabelki/Ustawienia.cfg");
        if(ustawienia.isFile()){
            
            System.out.println("Plik istnieje! Graj muzyko!");
            Scanner in = new Scanner(ustawienia);
            String zdanie = in.nextLine();
            System.out.println(zdanie);
            String zdanie2 = in.nextLine();
            System.out.println(zdanie2);
        }else{
            ustawienia.createNewFile();
            PrintWriter zapis = new PrintWriter(ustawienia);
            zapis.println("Language = PL");
            zapis.println("Version = 0.1");
            
            zapis.close();
        }
        //Scanner in = new Scanner(ustawienia);
 
        //String zdanie = in.nextLine();
        //System.out.println(zdanie);
        //}
        //catch(FileNotFoundException ex){
        //    System.out.println("dup");
        //}
        //System.out.println("klasa ustawienia");

    }
}
