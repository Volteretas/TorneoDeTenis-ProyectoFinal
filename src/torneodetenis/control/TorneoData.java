/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torneodetenis.control;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import torneodetenis.modelo.Conexion;
import torneodetenis.modelo.Torneo;

/**
 *
 * @author sant
 */
public class TorneoData {
     private Connection con;
     private Conexion conexion;
    
    public TorneoData(Conexion conexion){
        try {
            this.conexion = conexion;
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    }
    
    public void agregarTorneo(Torneo torneo){
        String sql = "INSERT INTO `torneo`(`nombre_torneo`, `fecha_inicio`, `fecha_fin`) VALUES (?,?,?);";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, torneo.getNombre_torneo());
            ps.setDate(2, Date.valueOf(torneo.getFecha_inicio()));
            ps.setDate(3, Date.valueOf(torneo.getFecha_fin()));
            ps.executeUpdate();
            ps.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
    }
    
    public void actualizarTorneo(Torneo torneo){
        String sql = "UPDATE `torneo` SET `nombre_torneo`=?,`fecha_inicio`=?,`fecha_fin`=? WHERE Id_torneo = ?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, torneo.getNombre_torneo());
            ps.setDate(2, Date.valueOf(torneo.getFecha_inicio()));
            ps.setDate(3, Date.valueOf(torneo.getFecha_fin()));
            ps.setInt(4, torneo.getId_torneo());
            ps.executeUpdate();
            ps.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
    }
    
    public void borrarTorneo(int id){
        String sql = "DELETE FROM `torneo` WHERE Id_torneo = ?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
    }
    
    
    public Torneo obtenerTorneo(int id){
        String sql = "SELECT * FROM `torneo` WHERE Id_torneo = ?;";
        Torneo torneo = null;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                torneo = new Torneo();
                torneo.setId_torneo(rs.getInt("Id_torneo"));
                torneo.setNombre_torneo(rs.getString(2));
                torneo.setFecha_inicio(rs.getDate(3).toLocalDate());
                torneo.setFecha_fin(rs.getDate(4).toLocalDate());
            }
            ps.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
        return torneo;
    }
    
    public List<Torneo> obtenerTorneos(){
        String sql = "SELECT * FROM torneo";
        List<Torneo> torneos = new ArrayList();
        Torneo torneo = null;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                torneo = this.obtenerTorneo(rs.getInt("Id_torneo"));
                torneos.add(torneo);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
        return torneos;
    }
    
}
