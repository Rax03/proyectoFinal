package org.example.Model;


public class Pokemon{
    private String nombre;
    private String sexo;
    private Enums.Tipo1 tipo1;
    private Enums.Tipo2 tipo2;
    private String Peso;
    private String Altura;
    private  int numero;

    public Pokemon(String nombre, String sexo,Enums.Tipo1 tipo1,Enums.Tipo2 tipo2,
                   String peso, String altura, int numero) {
        this.nombre = nombre;
        this.sexo = sexo;
        Peso = peso;
        Altura = altura;
        this.numero = numero;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
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

    public Enums.Tipo1 getTipo1() {
        return tipo1;
    }

    public void setTipo1(Enums.Tipo1 tipo1) {
        this.tipo1 = tipo1;
    }

    public Enums.Tipo2 getTipo2() {
        return tipo2;
    }

    public void setTipo2(Enums.Tipo2 tipo2) {
        this.tipo2 = tipo2;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String peso) {
        Peso = peso;
    }

    public String getAltura() {
        return Altura;
    }

    public void setAltura(String altura) {
        Altura = altura;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                ", tipo1=" + tipo1 +
                ", tipo2=" + tipo2 +
                ", Peso='" + Peso + '\'' +
                ", Altura='" + Altura + '\'' +
                ", numero=" + numero +
                '}';
    }
}
