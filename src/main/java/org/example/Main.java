package org.example;
import org.example.Model.Entidades.Pokedex;
import org.example.Model.Entidades.Pokemon;
import org.example.Model.Enums.Tipo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

    Connection connection;
    {
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pokedex_pokemon", "root", "root");
            Pokedex pokeded = new Pokedex(25,"Cuando se enfada, este Pokémon descarga" +
                    " la energía que almacena en el interior de las bolsas de las mejillas."
                    ,"bosque","100 Ataque","Rayo", new ArrayList<Pokemon>());

            Pokemon p = new Pokemon("Pikachu", "Masculino", Tipo.Electrico, Tipo.Electrico, 6.0f, 0.4f, pokeded);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
