package org.example;
import org.example.Model.DAO.PokedexDAO;
import org.example.Model.Entidades.Pokedex;
import org.example.Model.Entidades.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.example.Model.DAO.PokedexDAO.*;

public class Main {
    public static void main(String[] args) {

                /*Pokedex pokedex = new Pokedex(25, "Cuando se enfada, este Pokémon descarga" +
                        " la energía que almacena en el interior de las bolsas de las mejillas."
                        , "bosque", "100 Ataque", "Rayo", new ArrayList<Pokemon>());
                PokedexDAO.insertar(pokedex);*/

         /*Pokedex pokedex = new Pokedex(1, "Lleva un bulbo en el lomo desde que nace."+
         "A medida que el Pokémon crece, el bulbo también va haciéndose más grande."
                        , "Desconocida", "20 Ataque", "Hoja afilada", new ArrayList<Pokemon>());
                PokedexDAO.insertar(pokedex);
               Pokedex buscado = PokedexDAO.select_numero(25);
        System.out.println(buscado);*/

        //List<Pokedex> buscados = PokedexDAO.select_pokedex();
        //System.out.println(buscados);
                //Pokemon p = new Pokemon("Pikachu", "Masculino", Tipo.Electrico, Tipo.Electrico, 6.0f, 0.4f, pokeded);
 //PokedexDAO.delete_pokedex(1);
       /* Pokedex pokedex = new Pokedex(25 ,"Cuando se enfada, este Pokémon descarga" +
                " la energía que almacena en el interior de las bolsas de las mejillas."
                , "bosque", "100 Ataque", "Rayo", new ArrayList<Pokemon>());*/


        Pokedex pokedex = new Pokedex(25 ,"Cuando se enfada, este Pokémon descarga" +
                " la energía que almacena en el interior de las bolsas de las mejillas."
                , "bosque", "100 Ataque", "Rayo", new ArrayList<Pokemon>());
            update_pokedex (pokedex);



        //Pokemon p = new Pokemon("Pikachu", "Masculino", Tipo.Electrico, Tipo.Electrico, 6.0f, 0.4f, pokeded);

    }
}
