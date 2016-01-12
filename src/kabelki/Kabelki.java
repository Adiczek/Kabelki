package kabelki;
import javax.swing.JFrame;
public class Kabelki {   
    public static void main(String[] args) {
        JFrame okno = new OknoGlowne();        
        okno.setLocation(320, 320);
        okno.setTitle("Lista przewodów");
        okno.setVisible(true); 
    }    
}
