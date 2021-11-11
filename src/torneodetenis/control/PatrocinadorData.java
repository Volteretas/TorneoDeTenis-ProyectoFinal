/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torneodetenis.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import torneodetenis.modelo.Conexion;
import torneodetenis.modelo.Patrocinador;

/**
 *
 * @author sant
 */
public class PatrocinadorData {
    private Connection con;
    
    public PatrocinadorData(Conexion conexion){
        try {
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    }
    
    public void agregarPatrocinador(Patrocinador patrocinador){
        String sql = "INSERT INTO `patrocinador`(`marca`, `indumentaria`) VALUES (?,?);";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, patrocinador.getMarca());
            ps.setString(2, patrocinador.getIndumentaria());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
    }
    
    public void actualizarPatrocinador(Patrocinador patrocinador){
        String sql = "UPDATE `patrocinador` SET `marca`= ? ,`indumentaria`= ? WHERE Id_patrocinador = ?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, patrocinador.getMarca());
            ps.setString(2, patrocinador.getIndumentaria());
            ps.setInt(3, patrocinador.getId_patrocinador());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
    }
    
    public void borrarPatrocinador(int id){
        String sql = "DELETE FROM `patrocinador` WHERE Id_patrocinador = ?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
    }
    
    public Patrocinador obtenerPatrocinador(int id){
        String sql = "SELECT * FROM `patrocinador` WHERE Id_patrocinador = ?;";
        Patrocinador patrocinador = null;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                patrocinador = new Patrocinador();
                patrocinador.setId_patrocinador(rs.getInt("Id_patrocinador"));
                patrocinador.setMarca(rs.getString(2));
                patrocinador.setIndumentaria(rs.getString(3));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
        return patrocinador;
    }
    
    public List<Patrocinador> obtenerPatrocinadores(){
        List<Patrocinador> patrocinadores = new ArrayList();
        Patrocinador patrocinador = null;
        String sql="SELECT * FROM patrocinador";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                patrocinador = this.obtenerPatrocinador(rs.getInt("Id_patrocinador"));
                patrocinadores.add(patrocinador);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
        return patrocinadores;
    }
    
}
