package org.example.Model.DAO;

import org.example.Model.Entidades.Pokemon;
import org.example.Model.Enums.Tipo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAO {
    private static final String INSERT = "INSERT INTO pokemon ( Id ,Nombre, Sexo, Tipo1, Tipo2, Peso, Altura, Id_pokedex) VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE pokemon  set sexo=?, Tipo1=?, Tipo2=?, Peso=?, Altura=? WHERE Id =?  ";
    private static final String DELETE = "DELETE FROM Pokemon where Id=?";
    private static final String FINBYId = "SELECT * from pokemon where  Id=?";
    private static final String FINDALL = "SELECT * from pokemon";


    public static boolean insertar_pokemon(Pokemon p) {
        boolean resultado = false;
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pokedex_pokemon", "root", "root")) {
            PreparedStatement ps = connection.prepareStatement(INSERT);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getSexo());
            ps.setObject(4, p.getTipo1().toString());
            ps.setObject(5, p.getTipo2().toString());
            ps.setFloat(6, p.getPeso());
            ps.setFloat(7, p.getAltura());
            ps.setInt(8, p.getPokedex().getNumero());
            ps.executeUpdate();
            ps.close();
            resultado = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public static Pokemon select_Id(int Id) {
        Pokemon resultado = new Pokemon();
        if (Id == 0) return resultado;

        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pokedex_pokemon", "root", "root")) {
            PreparedStatement ps = connection.prepareStatement(FINBYId);
            ps.setInt(1, Integer.parseInt(String.valueOf(Id)));
            ResultSet res = ps.executeQuery();

            if (res.next()) {   //la fila con el pokemon de la base de datos
                resultado.setId(res.getInt("ID"));
                resultado.setNombre(res.getString("Nombre"));
                resultado.setSexo(res.getString("Sexo"));
                resultado.setTipo1(Tipo.valueOf(res.getObject("Tipo1").toString()));
                resultado.setTipo2(Tipo.valueOf(res.getObject("Tipo2").toString()));
                resultado.setPeso(res.getFloat("peso"));
                resultado.setAltura(res.getFloat("Altura"));
                resultado.setPokedex(PokedexDAO.select_numero(res.getInt("Id_pokedex")));

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
                a.setTipo1(Tipo.valueOf(res.getObject("Tipo1").toString()));
                a.setTipo2(Tipo.valueOf(res.getObject("Tipo2").toString()));
                a.setPeso(res.getFloat("peso"));
                a.setAltura(res.getFloat("Altura"));
                a.setPokedex(PokedexDAO.select_numero(res.getInt("Id_pokedex")));
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
            ps.setString(1, pokemons.getSexo());
            ps.setObject(2, pokemons.getTipo1().toString());
            ps.setObject(3, pokemons.getTipo2().toString());
            ps.setFloat(4, pokemons.getPeso());
            ps.setFloat(5, pokemons.getAltura());
            ps.setInt(6, pokemons.getPokedex().getNumero());

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