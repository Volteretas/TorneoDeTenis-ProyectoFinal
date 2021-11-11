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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import torneodetenis.modelo.Conexion;
import torneodetenis.modelo.Jugador;
import torneodetenis.modelo.Partido;

/**
 *
 * @author Santiago
 */
public class PartidoData {
    //Esta clase todavia no esta completa
    private Connection con;
    private Conexion conexion;
    
    public PartidoData(Conexion conexion){
        try {
            this.conexion = conexion;
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    }
    
    public void agregarPartido(Partido partido){
        String sql = "INSERT INTO `partido`(`Id_partido`, `Id_torneo`, `Id_estadio`, `id_jugador1`, `id_jugador2`, `id_ganador`, `fechayhora`, `estado`, `resultado`) VALUES (?,?,?,?,?,?,?,?,?);";
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, partido.getTorneo().getId_torneo());
            ps.setInt(2, partido.getEstadio().getId_estadio());
            ps.setInt(3, partido.getJugador1().getId_jugador());
            ps.setInt(4, partido.getJugador2().getId_jugador());
            ps.setTimestamp(5,Timestamp.valueOf(partido.getFechayhora()));
            ps.setString(6,partido.getEstado());  
            ps.setString(7,partido.getResultado());
            
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
        String sql= "UPDATE `partido` SET `Id_torneo`='[value-2]',`Id_estadio`=?,`id_jugador1`=?,`id_jugador2`=?,`fechayhora`=?,`estado`=?,`resultado`=? WHERE id_partido;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, partido.getTorneo().getId_torneo());
            ps.setInt(2, partido.getEstadio().getId_estadio());
            ps.setInt(3, partido.getJugador1().getId_jugador());
            ps.setInt(4, partido.getJugador2().getId_jugador());
            ps.setTimestamp(5,Timestamp.valueOf(partido.getFechayhora()));
            ps.setString(6,partido.getEstado());  
            ps.setString(7,partido.getResultado());          
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al conectar " + ex);
        }
    }
    
    public void borrarPartido(int id){
        String sql="DELETE FROM `partido` WHERE Id_partido = ?;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar "+ex);
        }
    }
    
    public void comenzarPartido(Partido partido){
        String sql="UPDATE partido SET estado = ? WHERE Id_partido = ?;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(2, partido.getId_partido());
            ps.setString(1, "Jugando");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar "+ex);
        }
    }
    
    public void terminarPartido(Partido partido){
        String sql="UPDATE partido SET estado = ? WHERE Id_partido = ?;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(2, partido.getId_partido());
            ps.setString(1, "Terminado");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar "+ex);
        }
    }
    
    public void agregarResultado(Partido partido, String resultado, Jugador ganador){
        String sql="UPDATE partido SET resultado=?, id_ganador=? WHERE Id_partido=? ;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(3, partido.getId_partido());
            ps.setString(1, resultado);
            ps.setInt(2, ganador.getId_jugador());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar "+ex);
        }
    }
    
    public Partido buscarPartido(int id_partido){
        String sql="SELECT * FROM `partido` WHERE Id_partido = ?;";
        
        Partido partido = null;
        
        try{
            JugadorData jd = new JugadorData(conexion);
            TorneoData td = new TorneoData(conexion);
            EstadioData ed = new EstadioData(conexion);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_partido);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                partido = new Partido();
                partido.setId_partido(rs.getInt("Id_partido"));
                partido.setTorneo(td.obtenerTorneo(rs.getInt(2)));
                partido.setEstadio(ed.obtenerEstadio(rs.getInt(3)));
                partido.setJugador1(jd.obtenerJugador(rs.getInt(4)));
                partido.setJugador2(jd.obtenerJugador(rs.getInt(5)));
                partido.setGanador(jd.obtenerJugador(rs.getInt(6)));
                partido.setFechayhora(rs.getTimestamp(7).toLocalDateTime());
                partido.setEstado(rs.getString(8));
                partido.setResultado(rs.getString(9));   
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar "+ex);
        }
        return partido;
    }
    
    public List<Partido> obtenerPartidos(){
        List<Partido> partidos = new ArrayList();
        Partido partido = null;
        String sql="SELECT * FROM partido";
        
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    partido = this.buscarPartido(rs.getInt("Id_partido"));
                    partidos.add(partido);                   
                }
                ps.close();
            }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar "+ex);
            }
        return partidos;
    }
    
}
