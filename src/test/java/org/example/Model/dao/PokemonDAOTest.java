package org.example.Model.dao;

import org.example.Model.Entidades.Pokemon;
import org.example.Model.Enums.Tipo;

import static org.junit.jupiter.api.Assertions.*;

class PokemonDAOTest {

    @org.junit.jupiter.api.Test
    void save() {
        Pokemon pokemon = new Pokemon(389,"Torterra","Masculino", Tipo.Planta,Tipo.Tierra,310f,2.2f,null);

    }

    @org.junit.jupiter.api.Test
    void delete() {
    }

    @org.junit.jupiter.api.Test
    void findById() {
    }

    @org.junit.jupiter.api.Test
    void findAll() {
    }

    @org.junit.jupiter.api.Test
    void findByPokedex() {
    }
}