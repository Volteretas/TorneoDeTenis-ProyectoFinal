/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneodetenis;

import javax.swing.JOptionPane;
import torneodetenis.control.EstadioData;
import torneodetenis.modelo.Conexion;
import torneodetenis.modelo.Estadio;

/**
 *
 * @author Santiago
 */
public class TorneoDeTenis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try{
            Conexion conexion = new Conexion();
            EstadioData ed = new EstadioData(conexion);
            
       
            
            System.out.println(ed.obtenerEstadios());
            
            
            
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Hay mi madre el bicho");
        }
    }
    
}
