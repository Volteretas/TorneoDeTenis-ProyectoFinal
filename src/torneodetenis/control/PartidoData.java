/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneodetenis.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import torneodetenis.modelo.Conexion;
import torneodetenis.modelo.Partido;

/**
 *
 * @author Santiago
 */
public class PartidoData {
    //Esta clase todavia no esta completa
    private Connection con;
    
    public PartidoData(Conexion conexion){
        try {
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    }
    
    public void agregarPartido(Partido partido){
        String sql = "INSERT INTO `partido`(`Id_torneo`, `Id_estadio`, `fechayhora`, `estado`, `resultado`) VALUES (?,?,?,?,?);";
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, partido.getTorneo().getId_torneo());
            ps.setInt(2, partido.getEstadio().getId_estadio());
            ps.setTimestamp(3, Timestamp.valueOf(partido.getFechayhora()));
            ps.setString(4, partido.getEstado());
            ps.setString(5, partido.getResultado());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                partido.setId_partido(1);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
    }
    
    public void actualizarPartido(Partido partido){
        String sql= "UPDATE `partido` SET `Id_torneo`=? ,`Id_estadio`=? ,`fechayhora`=?,`estado`=?,`resultado`=? WHERE Id_partido = ?;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, partido.getTorneo().getId_torneo());
            ps.setInt(2, partido.getEstadio().getId_estadio());
            ps.setTimestamp(3, Timestamp.valueOf(partido.getFechayhora()));
            ps.setString(4, partido.getEstado());
            ps.setString(5, partido.getResultado());
            ps.setInt(6, partido.getId_partido());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al conectar " + ex);
        }
    }
    
    public void borrarPartido(Partido partido){
        String sql="DELETE FROM `partido` WHERE Id_partido = ?;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, partido.getId_partido());
            ps.executeUpdate();
            
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar "+ex);
        }
    }
    
    
}
