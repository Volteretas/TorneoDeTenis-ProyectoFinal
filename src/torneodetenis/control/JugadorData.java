/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torneodetenis.control;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import torneodetenis.modelo.Conexion;
import torneodetenis.modelo.Jugador;

/**
 *
 * @author sant
 */
public class JugadorData {
       private Connection con;
    
    public JugadorData(Conexion conexion){
        try {
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    }
    
    public void agregarJugador(Jugador jugador){
        String sql = "INSERT INTO `jugadores`(`nombre`, `apellido`, `dni`, `fecha_nac`, `altura`, `peso`, `estilo`, `diestro`) VALUES (?,?,?,?,?,?,?,?);";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, jugador.getNombre());
            ps.setString(2, jugador.getApellido());
            ps.setInt(3, jugador.getDni());
            ps.setDate(4, Date.valueOf(jugador.getFecha_nac()));
            ps.setDouble(5, jugador.getAltura());
            ps.setDouble(6, jugador.getPeso());
            ps.setString(7, jugador.getEstilo());
            ps.setBoolean(8, jugador.getDiestro());
            ps.executeUpdate();
            ps.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
    }
    
    public void actualizarJugador(Jugador jugador){
        String sql = "UPDATE `jugadores` SET `nombre`=?,`apellido`=?,`dni`=?,`fecha_nac`=?,`altura`=?,`peso`=?,`estilo`=?,`diestro`=? WHERE Id_jugador = ?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, jugador.getNombre());
            ps.setString(2, jugador.getApellido());
            ps.setInt(3, jugador.getDni());
            ps.setDate(4, Date.valueOf(jugador.getFecha_nac()));
            ps.setDouble(5, jugador.getAltura());
            ps.setDouble(6, jugador.getPeso());
            ps.setString(7, jugador.getEstilo());
            ps.setBoolean(8, jugador.getDiestro());
            ps.setInt(9, jugador.getId_jugador());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
    }
    
    public void borrarJugador(int id){
        String sql = "DELETE FROM `jugadores` WHERE Id_jugador = ?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
    }
    
    public Jugador obtenerJugador(int id){
        String sql = "SELECT * FROM `jugadores` WHERE Id_jugador = ?;";
        Jugador jugador = null;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                jugador = new Jugador();
                jugador.setId_jugador(rs.getInt("Id_jugador"));
                jugador.setNombre(rs.getString(2));
                jugador.setApellido(rs.getString(3));
                jugador.setDni(rs.getInt(4));
                jugador.setFecha_nac(rs.getDate(5).toLocalDate());
                jugador.setAltura(rs.getDouble(6));
                jugador.setPeso(rs.getDouble(7));
                jugador.setEstilo(rs.getString(8));
                jugador.setDiestro(rs.getBoolean(9));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
        return jugador;
    }
    
    public List<Jugador> obtenerJugadores(){
        List<Jugador> jugadores = new ArrayList();
        Jugador jugador = null;
        String sql="SELECT * FROM jugadores";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                jugador = this.obtenerJugador(rs.getInt("Id_jugador"));
                jugadores.add(jugador);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al agregar partido " + ex);
        }
        return jugadores;
    }
    
}
