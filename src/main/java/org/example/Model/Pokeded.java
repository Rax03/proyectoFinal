package org.example.Model;

public class Pokeded {
    private int numero;
    private String Descripcion;
    private String Habitad;
    private String Estadisticas;
    private String Movimientos;

    public Pokeded(int numero, String descripcion, String habitad, String estadisticas, String movimientos) {
        this.numero = numero;
        Descripcion = descripcion;
        Habitad = habitad;
        Estadisticas = estadisticas;
        Movimientos = movimientos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getHabitad() {
        return Habitad;
    }

    public void setHabitad(String habitad) {
        Habitad = habitad;
    }

    public String getEstadisticas() {
        return Estadisticas;
    }

    public void setEstadisticas(String estadisticas) {
        Estadisticas = estadisticas;
    }

    public String getMovimientos() {
        return Movimientos;
    }

    public void setMovimientos(String movimientos) {
        Movimientos = movimientos;
    }

    @Override
    public String toString() {
        return "Pokeded{" +
                "numero=" + numero +
                ", Descripcion='" + Descripcion + '\'' +
                ", Habitad='" + Habitad + '\'' +
                ", Estadisticas='" + Estadisticas + '\'' +
                ", Movimientos='" + Movimientos + '\'' +
                '}';
    }
}
