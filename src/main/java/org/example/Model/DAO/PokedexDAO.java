package org.example.Model.DAO;

import org.example.Model.Entidades.Pokedex;
import org.example.Model.Entidades.Pokemon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokedexDAO {
    private static final String INSERT = "INSERT INTO Pokedex (Numero ,Descripcion,Habitad, Estadisticas, Movimientos) VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE Pokedex  set Descripcion=?, Habitad=?, Estadisticas=?, Movimientos=? WHERE Numero =?  ";
    private static final String DELETE = "DELETE FROM Pokedex where Numero=?";
    private static final String FINBYNUMERO = "SELECT * from Pokedex where Numero=?";
    private static final String FINDALL = "SELECT * from Pokedex";

    //CRUD

    public static boolean insertar_Pokedex(Pokedex p) {
        boolean resultado = false;
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pokedex_pokemon", "root", "root")) {
            PreparedStatement ps = connection.prepareStatement(INSERT);
            ps.setInt(1, p.getNumero());
            ps.setString(2, p.getDescripcion());
            ps.setString(3, p.getHabitad());
            ps.setString(4, p.getEstadisticas());
            ps.setString(5, p.getMovimientos());
            ps.executeUpdate();
            ps.close();
            resultado = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public static Pokedex select_numero(int numero) {
        Pokedex resultado = new Pokedex();
        if (numero == -1) return resultado;

        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pokedex_pokemon", "root", "root")) {
            PreparedStatement ps = connection.prepareStatement(FINBYNUMERO);
            ps.setInt(1, numero);
            ResultSet res = ps.executeQuery();

            if (res.next()) {   //la fila con el pokedex de la base de datos
                resultado.setNumero(res.getInt("Numero"));
                resultado.setDescripcion(res.getString("Descripcion"));
                resultado.setHabitad(res.getString("Habitad"));
                resultado.setEstadisticas(res.getString("Estadisticas"));
                resultado.setMovimientos(res.getString("Movimientos"));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public static List<Pokedex> select_pokedex() {
        List<Pokedex> result = new ArrayList<>();


        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pokedex_pokemon", "root", "root")) {
            PreparedStatement ps = connection.prepareStatement(FINDALL);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
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

    public static boolean delete_pokedex(int numero) {
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


    public static boolean update_pokedex(Pokedex pokedex) {
        if (pokedex.getNumero() <= 0) {
            return false;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pokedex_pokemon", "root", "root")) {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setString(1, pokedex.getDescripcion());
            ps.setString(2, pokedex.getHabitad());
            ps.setString(3, pokedex.getEstadisticas());
            ps.setString(4, pokedex.getMovimientos());
            ps.setInt(5, pokedex.getNumero());

            int removed = ps.executeUpdate();
            System.out.println("Pokeded actualizada: " + removed);
            return removed > 0;
        } catch (SQLException e) {
            System.out.println(" error actualizar : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}