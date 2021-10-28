/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneodetenis.modelo;

/**
 *
 * @author Santiago
 */
public class Estadio {
    private int id_estadio;
    private int numero_ident;
    private String ciudad;
    private String direccion;
    private String estado;
    private String categoria;
    private double largo;
    private double ancho;
    private int cantidad_espectadores;

    public Estadio(int id_estadio, int numero_ident, String ciudad, String direccion, String estado, String categoria, double largo, double ancho, int cantidad_espectadores) {
        this.id_estadio = id_estadio;
        this.numero_ident = numero_ident;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.estado = estado;
        this.categoria = categoria;
        this.largo = largo;
        this.ancho = ancho;
        this.cantidad_espectadores = cantidad_espectadores;
    }

    public Estadio(int numero_ident, String ciudad, String direccion, String estado, String categoria, double largo, double ancho, int cantidad_espectadores) {
        this.numero_ident = numero_ident;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.estado = estado;
        this.categoria = categoria;
        this.largo = largo;
        this.ancho = ancho;
        this.cantidad_espectadores = cantidad_espectadores;
    }

    public Estadio() {
    }

    public int getId_estadio() {
        return id_estadio;
    }

    public void setId_estadio(int id_estadio) {
        this.id_estadio = id_estadio;
    }

    public int getNumero_ident() {
        return numero_ident;
    }

    public void setNumero_ident(int numero_ident) {
        this.numero_ident = numero_ident;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public int getCantidad_espectadores() {
        return cantidad_espectadores;
    }

    public void setCantidad_espectadores(int cantidad_espectadores) {
        this.cantidad_espectadores = cantidad_espectadores;
    }

    @Override
    public String toString() {
        return "Estadio{" + "id_estadio=" + id_estadio + ", numero_ident=" + numero_ident + ", ciudad=" + ciudad + ", direccion=" + direccion + ", estado=" + estado + ", categoria=" + categoria + ", largo=" + largo + ", ancho=" + ancho + ", cantidad_espectadores=" + cantidad_espectadores + '}';
    }
    
    
}
