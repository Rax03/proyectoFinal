package org.example.Model.dao;

import org.example.Model.Entidades.Pokedex;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokedexDAOTest {

    @Test
    void save() {
        PokedexDAO.build().save(new Pokedex(369,"Las gentes de antaño creían que la superficie terrestre se encontraba sobre un gran Torterra.","Montañas","300","Terremoto",null));
    }

    @Test
    void delete() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void findAll() {
    }

}