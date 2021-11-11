/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneodetenis;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import torneodetenis.control.JugadorData;
import torneodetenis.control.PartidoData;
import torneodetenis.control.TorneoData;
import torneodetenis.modelo.Conexion;
import torneodetenis.modelo.Jugador;

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
            TorneoData td = new TorneoData(conexion);
            JugadorData jd = new JugadorData(conexion);
            PartidoData pd = new PartidoData(conexion);
            Jugador jugador = new Jugador("Pedro", "Picapiedra", 1244301, LocalDate.of(2012, 12, 12), 1, 1, "ofencivo", true);
            
            //jd.agregarJugador(jugador);
                       
            System.out.println(pd.obtenerPartidos());
            
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Hay mi madre el bicho");
        }
    }
    
}
