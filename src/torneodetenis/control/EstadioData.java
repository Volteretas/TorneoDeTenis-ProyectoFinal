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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import torneodetenis.modelo.Conexion;
import torneodetenis.modelo.Estadio;
/**
 *
 * @author Santiago
 */
public class EstadioData {
    private Connection con;

    public EstadioData(Conexion conexion) {
        try{
            con = conexion.getConexion();
        }catch (SQLException ex){
            System.out.println("Error en la conexion " + ex);
        }
    }
    
    public void agregarEstadio(Estadio estadio){
        String sql = "INSERT INTO `estadio`(`numero_ident`, `ciudad`, `direccion`, `estado`, `largo`, `ancho`, `cantidad_espectadores`, `categoria`) VALUES (?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, estadio.getNumero_ident());
            ps.setString(2, estadio.getCiudad());
            ps.setString(3, estadio.getDireccion());
            ps.setString(4, estadio.getEstado());
            ps.setDouble(5, estadio.getLargo());
            ps.setDouble(6, estadio.getAncho());
            ps.setInt(7, estadio.getCantidad_espectadores());
            ps.setString(8,estadio.getCategoria());
            
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                estadio.setId_estadio(1);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al insertar Estadio "+ex);
        }
    }
    
    public void actualizarEstadio(Estadio estadio){
        String sql ="UPDATE `estadio` SET `numero_ident`=?,`ciudad`=?,`direccion`=?,`estado`=?,`largo`=?,`ancho`=?,`cantidad_espectadores`=?,`categoria`=? WHERE Id_estadio = ?;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, estadio.getNumero_ident());
            ps.setString(2, estadio.getCiudad());
            ps.setString(3, estadio.getDireccion());
            ps.setString(4, estadio.getEstado());
            ps.setDouble(5, estadio.getLargo());
            ps.setDouble(6, estadio.getAncho());
            ps.setInt(7, estadio.getCantidad_espectadores());
            ps.setString(8, estadio.getCategoria());
            ps.setInt(9, estadio.getId_estadio());
            ps.executeUpdate();
            ps.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar " + ex);
        }
    }
    
    public void borrarEstadio(int id_estadio){
        String sql = "DELETE FROM `estadio` WHERE Id_estadio = ?;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_estadio);
            ps.executeUpdate();
            ps.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar "+ex);
        }
        
    }
    
    public Estadio obtenerEstadio(int id_estadio){
        Estadio estadio= null;
        String sql = "SELECT * FROM estadio WHERE Id_estadio = ?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_estadio);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                estadio = new Estadio();
                estadio.setId_estadio(rs.getInt("Id_estadio"));
                estadio.setNumero_ident(rs.getInt(2));
                estadio.setCiudad(rs.getString(3));
                estadio.setDireccion(rs.getString(4));
                estadio.setEstado(rs.getString(5));
                estadio.setLargo(rs.getDouble(6));
                estadio.setAncho(rs.getDouble(7));
                estadio.setCantidad_espectadores(rs.getInt(8));
                estadio.setCategoria(rs.getString(9));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar " + ex);
        }
        return estadio;
    }
    
    public List<Estadio> obtenerEstadios(){
        List<Estadio> estadios = new ArrayList<>();
        Estadio estadio = null;
        String sql ="SELECT * FROM estadio";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                estadio = new Estadio();
                estadio.setId_estadio(rs.getInt("Id_estadio"));
                estadio.setNumero_ident(rs.getInt(2));
                estadio.setCiudad(rs.getString(3));
                estadio.setDireccion(rs.getString(4));
                estadio.setEstado(rs.getString(5));
                estadio.setLargo(rs.getDouble(6));
                estadio.setAncho(rs.getDouble(7));
                estadio.setCantidad_espectadores(rs.getInt(8));
                estadio.setCategoria(rs.getString(9));
                estadios.add(estadio);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar "+ ex);
        }
        return estadios;
    }
    
}
