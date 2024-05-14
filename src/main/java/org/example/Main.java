package org.example;
import org.example.Model.DAO.PokedexDAO;
import org.example.Model.DAO.PokemonDAO;
import org.example.Model.Entidades.Pokemon;
import org.example.Model.Enums.Tipo;

import static org.example.Model.DAO.PokemonDAO.update_pokemon;

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


       /* Pokedex pokedex = new Pokedex(25 ,"Cuando se enfada, este Pokémon descarga" +
                " la energía que almacena en el interior de las bolsas de las mejillas."
                , "bosque", "100 Ataque", "Rayo", new ArrayList<Pokemon>());
            update_pokedex (pokedex);*/



        Pokemon pokemon = new Pokemon(1,"Pikachu", "Masculino", Tipo.Electrico, Tipo.Electrico, 6.0f, 0.4f, PokedexDAO.select_numero(1));
        PokemonDAO.insertar_pokemon(pokemon);

        //List<Pokemon> buscados = PokemonDAO.select_pokemon();
        //System.out.println(buscados);

        //Pokemon buscado = PokemonDAO.select_Id(1);
        //System.out.println(buscado);

       // Pokemon pokemon = new Pokemon(1, "Pikachu", "femenino", Tipo.Electrico, Tipo.Electrico, 6.0f, 0.4f, PokedexDAO.select_numero(1));
        //update_pokemon(pokemon);

       // PokemonDAO.delete_pokemon(1);
    }
}
