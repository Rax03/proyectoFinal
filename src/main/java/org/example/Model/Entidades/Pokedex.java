package org.example.Model.Entidades;

import java.util.List;
import java.util.Objects;

public class Pokedex {
    private int Id;
    private String Descripcion;
    private String Habitad;
    private String Estadisticas;
    private String Movimientos;
    private List<Pokemon> pokemons;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void agregaPokemon(Pokemon p){
        pokemons.add(p);
    }
    public void eliminaPokemon(Pokemon p){
        pokemons.remove(p);
    }
    public int buscaPokemon(Pokemon p){
       return pokemons.indexOf(p);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Pokedex pokeded = (Pokedex) object;
        return Id == pokeded.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Pokeded{" +
                "Id=" + Id +
                ", Descripcion='" + Descripcion + '\'' +
                ", Habitad='" + Habitad + '\'' +
                ", Estadisticas='" + Estadisticas + '\'' +
                ", Movimientos='" + Movimientos + '\'' +
                ", pokemons=" + pokemons +
                '}';
    }

    public Pokedex(int id, String descripcion, String habitad, String estadisticas, String movimientos, List<Pokemon> pokemons) {
        Id = id;
        Descripcion = descripcion;
        Habitad = habitad;
        Estadisticas = estadisticas;
        Movimientos = movimientos;
        this.pokemons = pokemons;


    }
}
