/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneodetenis.modelo;

import java.time.LocalDate;

/**
 *
 * @author Santiago
 */
public class Jugador {
    private int id_jugador;
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fecha_nac;
    private double altura;
    private double peso;
    private String estilo;
    private boolean diestro;

    public Jugador(int id_jugador, String nombre, String apellido, int dni, LocalDate fecha_nac, double altura, double peso, String estilo, boolean diestro) {
        this.id_jugador = id_jugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nac = fecha_nac;
        this.altura = altura;
        this.peso = peso;
        this.estilo = estilo;
        this.diestro = diestro;
    }

    public Jugador(String nombre, String apellido, int dni, LocalDate fecha_nac, double altura, double peso, String estilo, boolean diestro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nac = fecha_nac;
        this.altura = altura;
        this.peso = peso;
        this.estilo = estilo;
        this.diestro = diestro;
    }

    public Jugador() {
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public boolean isDiestro() {
        return diestro;
    }

    public void setDiestro(boolean diestro) {
        this.diestro = diestro;
    }

    @Override
    public String toString() {
        return "Jugador{" + "id_jugador=" + id_jugador + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fecha_nac=" + fecha_nac + ", altura=" + altura + ", peso=" + peso + ", estilo=" + estilo + ", diestro=" + diestro + '}';
    }
    
}
