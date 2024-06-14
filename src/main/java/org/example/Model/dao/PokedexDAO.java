package org.example.Model.dao;

import org.example.Model.Conection.ConnectionMariaDB;
import org.example.Model.Entidades.Pokedex;
import org.example.Model.Entidades.Pokemon;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokedexDAO implements DAO<Pokedex,Integer>{
    private static final String INSERT = "INSERT INTO Pokedex (Numero ,Descripcion,Habitad, Estadisticas, Movimientos) VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE Pokedex  set Descripcion=?, Habitad=?, Estadisticas=?, Movimientos=? WHERE Numero =?  ";
    private static final String DELETE = "DELETE FROM Pokedex where Numero=?";
    private static final String FINBYNUMERO = "SELECT * from Pokedex where Numero=?";
    private static final String FINDALL = "SELECT * from Pokedex";

    //CRUD

    @Override
    public Pokedex save(Pokedex entity) {
        Pokedex result = entity;
        if (entity == null || entity.getNumero() <1) return result;
        Pokedex a = findById(entity.getNumero());
        if (a.getNumero() <1) {

            try (PreparedStatement ps = ConnectionMariaDB.getConnection().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, entity.getNumero());
                ps.setString(2, entity.getDescripcion());
                ps.setString(3, entity.getHabitad());
                ps.setString(4, entity.getEstadisticas());
                ps.setString(5, entity.getMovimientos());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else{

            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {

                pst.setString(1, entity.getDescripcion());
                pst.setString(2, entity.getHabitad());
                pst.setString(3, entity.getEstadisticas());
                pst.setString(4, entity.getMovimientos());
                pst.setInt(5, entity.getNumero());
                pst.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;

    }

    @Override
    public Pokedex delete(Pokedex entity) throws SQLException {
        if (entity == null || entity.getNumero() <1) return entity;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
            pst.setInt(1, entity.getNumero());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }




    @Override
    public Pokedex findById (Integer Key){
        PokedexLazy result = new PokedexLazy();
        if (Key <1) return result;


        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINBYNUMERO)) {
            pst.setInt(1, Key);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                result.setNumero(resultSet.getInt("Numero"));
                result.setDescripcion(resultSet.getString("Descripcion"));
                result.setHabitad(resultSet.getString("Habitad"));
                result.setEstadisticas(resultSet.getString("Estadisticas"));
                result.setMovimientos(resultSet.getString("Movimientos"));

            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    @Override
    public List<Pokedex> findAll() {
        List<Pokedex> result = new ArrayList<>();

        try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDALL)) {

            ResultSet res = pst.executeQuery();
            while(res.next()){
                Pokedex a = new Pokedex();
                a.setNumero(res.getInt("Numero"));
                a.setDescripcion(res.getString("Descripcion"));
                a.setHabitad(res.getString("Habitad"));
                a.setEstadisticas(res.getString("Estadisticas"));
                a.setMovimientos(res.getString("Movimientos"));

                result.add(a);
            }
            res.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void close() throws IOException {

    }

    public static PokedexDAO build(){return new PokedexDAO();
    }
}
class PokedexLazy extends Pokedex{

    public List<Pokemon> getPokemons() {
        if(super.getPokemons()==null){
            setPokemons(PokemonDAO.build().findByPokedex(this));
        }
        return super.getPokemons();
    }
}