package org.example.Model.DAO;

public class PokemonDAO {
    private static final String INSERT ="INSERT INTO pokemon (Nombre, Sexo, Tipo1, Tipo2, Peso, Altura, Id_pokeded) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE ="UPDATE pokemon  set sexo=?, Tipo1=?, Tipo2=?, Peso=?, Altura=? WHERE Nombre =?  ";
    private static final String DELETE ="DELETE FROM Pokemon where Nombre=?";
    private static final String FINBYNAME ="SELECT * from pokemon where  Nombre=?";
    private static final String FINDALL ="SELECT * from pokemon";
}
