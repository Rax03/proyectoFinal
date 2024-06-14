package org.example.View;

import org.example.Model.Entidades.Pokemon;

public enum Scenes {
    ROOT("view/layout.fxml"),
    MAIN("view/main.fxml"),
    POKEDEX("view/pokedex.fxml"),
    POKEMON("view/pokemons.fxml"),
    insertar_pokemon("view/Insertar_pokemons.fxml"),
    insertar_pokedex("view/Insertar_pokedex.fxml"),
    CaPokemon("view/descripcionPokemon.fxml"),
    CaPokeded("view/descripcionPokeded.fxml");



    private String url;
    Scenes(String url){
        this.url=url;
    }
    public String getURL(){
        return url;
    }

}
