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
public class Patrocinador {
    private int id_patrocinador;
    private String marca;
    private String indumentaria;

    public Patrocinador(int id_patrocinador, String marca, String indumentaria) {
        this.id_patrocinador = id_patrocinador;
        this.marca = marca;
        this.indumentaria = indumentaria;
    }

    public Patrocinador(String marca, String indumentaria) {
        this.marca = marca;
        this.indumentaria = indumentaria;
    }

    public Patrocinador() {
    }

    public int getId_patrocinador() {
        return id_patrocinador;
    }

    public void setId_patrocinador(int id_patrocinador) {
        this.id_patrocinador = id_patrocinador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getIndumentaria() {
        return indumentaria;
    }

    public void setIndumentaria(String indumentaria) {
        this.indumentaria = indumentaria;
    }

    @Override
    public String toString() {
        return "Patrocinador{" + "id_patrocinador=" + id_patrocinador + ", marca=" + marca + ", indumentaria=" + indumentaria + '}';
    }
    
    
}
