package org.example.Model.Entidades;


import org.example.Model.Enums.Tipo;

import java.util.Objects;

public class Pokemon{
    private String nombre;
    private String sexo;
    private Tipo tipo1;
    private Tipo tipo2;
    private Float Peso;
    private Float Altura;
    private Pokedex pokeded;

    public Pokemon(String nombre, String sexo, Tipo tipo1, Tipo tipo2, Float peso, Float altura, Pokedex pokeded) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        Peso = peso;
        Altura = altura;
        this.pokeded = pokeded;
    }

    public Pokemon() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Tipo getTipo1() {
        return tipo1;
    }

    public void setTipo1(Tipo tipo1) {
        this.tipo1 = tipo1;
    }

    public Tipo getTipo2() {
        return tipo2;
    }

    public void setTipo2(Tipo tipo2) {
        this.tipo2 = tipo2;
    }

    public Float getPeso() {
        return Peso;
    }

    public void setPeso(Float peso) {
        Peso = peso;
    }

    public Float getAltura() {
        return Altura;
    }

    public void setAltura(Float altura) {
        Altura = altura;
    }

    public Pokedex getPokeded() {
        return pokeded;
    }

    public void setPokeded(Pokedex pokeded) {
        this.pokeded = pokeded;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Pokemon pokemon = (Pokemon) object;
        return Objects.equals(nombre, pokemon.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                ", tipo1=" + tipo1 +
                ", tipo2=" + tipo2 +
                ", Peso=" + Peso +
                ", Altura=" + Altura +
                ", pokeded=" + pokeded.getId() +
                '}';
    }
}
