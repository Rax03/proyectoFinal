package org.example.Model.DAO;

public class PokededDAO {
    private static final String INSERT ="INSERT INTO pokemon (Id ,Descripcion,Habitad, Estadisticas, Movimientos,pokemons) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE ="UPDATE Pokeded  set Descripcion=?, Habitad=?, Estadisticas=?, Movimientos=?, pokemons=? WHERE Id =?  ";
    private static final String DELETE ="DELETE FROM Pokeded where Id=?";
    private static final String FINBYNAME ="SELECT * from Pokeded where  Id=?";
    private static final String FINDALL ="SELECT * from Pokeded";
}
