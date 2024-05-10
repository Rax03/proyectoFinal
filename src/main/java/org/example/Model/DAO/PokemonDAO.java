package org.example.Model.DAO;

import org.example.Model.Entidades.Pokedex;
import org.example.Model.Entidades.Pokemon;
import org.example.Model.Enums.Tipo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAO {
    private static final String INSERT = "INSERT INTO pokemon ( Id ,Nombre, Sexo, Tipo1, Tipo2, Peso, Altura, Id_pokeded) VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE pokemon  set sexo=?, Tipo1=?, Tipo2=?, Peso=?, Altura=? WHERE Id =?  ";
    private static final String DELETE = "DELETE FROM Pokemon where Id=?";
    private static final String FINBYNAME = "SELECT * from pokemon where  Id=?";
    private static final String FINDALL = "SELECT * from pokemon";


    public static boolean insertar(Pokemon p) {
        boolean resultado = false;
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pokedex_pokemon", "root", "root")) {
            PreparedStatement ps = connection.prepareStatement(INSERT);
            ps.setInt(1, p.getId());
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getSexo());
            ps.setObject(3, p.getTipo1());
            ps.setObject(4, p.getTipo2());
            ps.setFloat(5, p.getPeso());
            ps.setFloat(6, p.getAltura());
            ps.setObject(7, p.getPokeded());
            ps.executeUpdate();
            ps.close();
            resultado = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public static Pokemon select_Nombre(String nombre) {
        Pokemon resultado = new Pokemon();
        if (nombre == null) return resultado;

        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pokedex_pokemon", "root", "root")) {
            PreparedStatement ps = connection.prepareStatement(FINBYNAME);
            ps.setInt(1, Integer.parseInt(nombre));
            ResultSet res = ps.executeQuery();

            if (res.next()) {   //la fila con el pokemon de la base de datos
                resultado.setId(res.getInt("ID"));
                resultado.setNombre(res.getString("Nombre"));
                resultado.setSexo(res.getString("Sexo"));
                resultado.setTipo1((Tipo) res.getObject("Tipo1"));
                resultado.setTipo2((Tipo) res.getObject("Tipo2"));
                resultado.setPeso(res.getFloat("peso"));
                resultado.setAltura(res.getFloat("Altura"));
                resultado.setPokeded((Pokedex) res.getObject("Id Pokeded"));

            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public static List<Pokemon> select_pokemon() {
        List<Pokemon> result = new ArrayList<>();


        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pokedex_pokemon", "root", "root")) {
            PreparedStatement ps = connection.prepareStatement(FINDALL);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Pokemon a = new Pokemon();
                a.setId(res.getInt("ID"));
                a.setNombre(res.getString("Nombre"));
                a.setSexo(res.getString("Sexo"));
                a.setTipo1((Tipo) res.getObject("Tipo1"));
                a.setTipo2((Tipo) res.getObject("Tipo2"));
                a.setPeso(res.getFloat("peso"));
                a.setAltura(res.getFloat("Altura"));
                a.setPokeded((Pokedex) res.getObject("Id Pokeded"));
                result.add(a);
            }
            res.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static boolean delete_pokemon(int numero) {
        if (numero > 0) {
            try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pokedex_pokemon", "root", "root")) {
                PreparedStatement ps = connection.prepareStatement(DELETE);
                ps.setInt(1, numero);
                int removed = ps.executeUpdate();
                System.out.println(removed);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return true;
    }

    public static boolean update_pokemon(Pokemon pokemons) {
        if (pokemons.getId() <= 0) {
            return false;
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pokedex_pokemon", "root", "root")) {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setString(1, pokemons.getNombre());
            ps.setString(2, pokemons.getSexo());
            ps.setObject(3, pokemons.getTipo1());
            ps.setObject(4, pokemons.getTipo2());
            ps.setFloat(5, pokemons.getPeso());
            ps.setFloat(6, pokemons.getAltura());
            ps.setObject(7, pokemons.getPokeded());

            int removed = ps.executeUpdate();
            System.out.println("Pokemon actualizado: " + removed);
            return removed > 0;
        } catch (SQLException e) {
            System.out.println(" error actualizar : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}