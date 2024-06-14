package org.example.Model.dao;

import org.example.Model.Conection.ConnectionMariaDB;
import org.example.Model.Entidades.Pokedex;
import org.example.Model.Entidades.Pokemon;
import org.example.Model.Enums.Tipo;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAO implements DAO<Pokemon, Integer> {
    private static final String INSERT = "INSERT INTO pokemon ( Id ,Nombre, Sexo, Tipo1, Tipo2, Peso, Altura, Id_pokedex) VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE pokemon  set sexo=?, Tipo1=?, Tipo2=?, Peso=?, Altura=? WHERE Id =?  ";
    private static final String DELETE = "DELETE FROM Pokemon where Id=?";
    private static final String FINDBYID = "SELECT Id ,Nombre, Sexo, Tipo1, Tipo2, Peso, Altura, Id_pokedex from pokemon where  Id=?";
    private static final String FINDALL = "SELECT Id ,Nombre, Sexo, Tipo1, Tipo2, Peso, Altura, Id_pokedex from pokemon";
    private static final String FINDBYPOKEDEX ="SELECT Id,nombre,sexo,Tipo1,Tipo2,Peso,Altura,Id_pokedex FROM pokemon AS i WHERE i.Id_pokedex=?";

    private Connection conn;
    public PokemonDAO(){
        conn = ConnectionMariaDB.getConnection();
    }

    @Override
    public Pokemon save(Pokemon entity) {
        Pokemon result=entity;
        if(entity!=null){
            int id = entity.getId();
            if(id!=0){
                Pokemon isInDataBase = findById(id);
                if(isInDataBase==null){
                    //INSERT
                    try(PreparedStatement pst = conn.prepareStatement(INSERT)) {
                        pst.setInt(1,entity.getId());
                        pst.setString(2,entity.getNombre());
                        pst.setString(3,entity.getSexo());
                        pst.setObject(4,entity.getTipo1());
                        pst.setObject(5,entity.getTipo2());
                        pst.setFloat(6,entity.getPeso());
                        pst.setFloat(7,entity.getAltura());
                        pst.setObject(8,entity.getPokedex());
                        pst.executeUpdate();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }else{
                    //UPDATE
                    try(PreparedStatement pst = conn.prepareStatement(UPDATE)) {
                        pst.setString(1,entity.getSexo());
                        pst.setString(2,entity.getTipo1().toString() );
                        pst.setString(3,entity.getTipo2().toString());
                        pst.setFloat(4,entity.getPeso());
                        pst.setFloat(5,entity.getAltura());
                        pst.setInt(6,entity.getId());
                        pst.executeUpdate();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }

    @Override
    public Pokemon delete(Pokemon entity) {
        if(entity!=null) {
            try (PreparedStatement pst = conn.prepareStatement(DELETE)) {
                pst.setInt(1, entity.getId());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                entity = null;
            }
        }
        return entity;
    }

    @Override
    public Pokemon findById(Integer key) {
        Pokemon result = null;
        try(PreparedStatement pst = conn.prepareStatement(FINDBYID)){
            pst.setInt(1,key);
            try(ResultSet res = pst.executeQuery()){
                if(res.next()){
                    Pokemon pokemon = new Pokemon();
                    pokemon.setId(res.getInt("Id"));
                    pokemon.setNombre(res.getString("Nombre"));
                    pokemon.setSexo(res.getString("Sexo"));
                    pokemon.setTipo1(Tipo.valueOf(res.getString("Tipo1")));
                    pokemon.setTipo2(Tipo.valueOf(res.getString("Tipo2")));
                    pokemon.setPeso(res.getFloat("Peso"));
                    pokemon.setAltura(res.getFloat("Altura"));
                    //Eager
                    pokemon.setPokedex(PokedexDAO.build().findById(res.getInt("id_pokedex")));
                    result=pokemon;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Pokemon> findAll() {
        List<Pokemon> result = new ArrayList<>();
        try(PreparedStatement pst = conn.prepareStatement(FINDALL)){
            try(ResultSet res = pst.executeQuery()){
                while(res.next()){
                    Pokemon pokemon = new Pokemon();
                    pokemon.setId(res.getInt("Id"));
                    pokemon.setNombre(res.getString("Nombre"));
                    pokemon.setSexo(res.getString("Sexo"));
                    pokemon.setTipo1(Tipo.valueOf(res.getString("Tipo1")));
                    pokemon.setTipo2(Tipo.valueOf(res.getString("Tipo2")));
                    pokemon.setPeso(res.getFloat("Peso"));
                    pokemon.setAltura(res.getFloat("Altura"));
                    pokemon.setPokedex(PokedexDAO.build().findById(res.getInt("id_pokedex")));

                    result.add(pokemon);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }

    public List<Pokemon> findByPokedex(Pokedex pokedex) {
        List<Pokemon> result = new ArrayList<>();
        if(pokedex==null) return result;
        try(PreparedStatement pst = conn.prepareStatement(FINDBYPOKEDEX)){
            pst.setInt(1,pokedex.getNumero());
            try(ResultSet res = pst.executeQuery()){
                while(res.next()){
                    Pokemon b = new Pokemon();


                    pokedex.setNumero(res.getInt("NUMERO"));

                    result.add(b);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }

    @Override
    public void close() throws IOException {

    }

    public static PokemonDAO build(){
        return new PokemonDAO();
    }


}