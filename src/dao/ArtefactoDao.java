package zeldasjourney.dao;

import zeldasjourney.jdbc.ConnectionDB;
import zeldasjourney.objetos.objetoHijo.ObjetoArma;
import zeldasjourney.objetos.objetoHijo.ObjetoArtefacto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArtefactoDao {

    private static final String SELECT_ONE_QUERY = "SELECT Id_artefacto, nombre, Descripcion, tipo, ataque, fuerza, movimiento, movimiento_turno, nivel, resistencia, Super_ataque, vida, vida_Gastar " +
            "FROM Artefacto where Id_artefacto = ?";
    private static final String SELECT_ALL_QUERY = "SELECT Id_artefacto, nombre, Descripcion, tipo, ataque, fuerza, movimiento, movimiento_turno, nivel, resistencia, Super_ataque, vida, vida_Gastar " +
            "FROM Artefacto";
    private static final String SELECT_BY_PARTIDA_QUERY = "SELECT id_artefacto, nombre, Descripcion, tipo, ataque, fuerza, movimiento, movimiento_turno, nivel, resistencia, Super_ataque, vida, vida_Gastar " +
            "FROM Artefacto a JOIN Artefacto_Partida p ON a.id_artefacto = p.fk_id_artefacto WHERE p.fk_id_partida = ?";
    private static final String INSERT_QUERY = "INSERT INTO Artefacto(nombre, Descripcion, tipo, ataque, fuerza, movimiento, movimiento_turno, nivel, resistencia, Super_ataque, vida, vida_Gastar) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE Artefacto " +
            "SET nombre = ?, Descripcion = ?, tipo = ?, ataque = ?, fuerza = ?, movimiento = ?, movimiento_turno = ?, nivel = ?, resistencia = ?, Super_ataque = ?, vida = ?, vida_Gastar = ? " +
            "WHERE Id_artefacto = ?";
    private static final String DELETE_QUERY = "DELETE FROM Artefacto WHERE Id_artefacto = ?";

    private final Connection connection;

    public ArtefactoDao(Connection connection) {
        this.connection = connection;
    }


    public Optional<ObjetoArtefacto> get(Integer id) {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ONE_QUERY)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(buildFromResultSet(resultSet));
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public List<ObjetoArtefacto> getAll() {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {

            List<ObjetoArtefacto> results = new ArrayList<>();

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    results.add(buildFromResultSet(resultSet));
                }
            }

            return results;
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public List<ObjetoArtefacto> getAllByPartida(int idPartida) {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_PARTIDA_QUERY)) {
            statement.setInt(1, idPartida);

            List<ObjetoArtefacto> results = new ArrayList<>();

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    results.add(buildFromResultSet(resultSet));
                }
            }

            return results;
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void save(ObjetoArtefacto artefacto) {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection
                .prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            //nombre, Descripcion, tipo, ataque, fuerza, movimiento, movimiento_turno, nivel, resistencia, Super_ataque, vida, vida_Gastar
            statement.setString(1, artefacto.getNombre());
            statement.setString(2, artefacto.getDescripcion());
            statement.setString(3, artefacto.getTipo());
            statement.setDouble(4, artefacto.getAtaque());
            statement.setInt(5, artefacto.getFuerza());
            statement.setInt(6, artefacto.getMovimiento());
            statement.setInt(7, artefacto.getMovimientoTurno());
            statement.setInt(8, artefacto.getNivel());
            statement.setDouble(9, artefacto.getResistencia());
            statement.setInt(10, artefacto.getSuperAtaque());
            statement.setInt(11, artefacto.getVida());
            statement.setInt(12, artefacto.getVidaGastar());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating artefacto failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    artefacto.setIdPropia(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating artefacto failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void update(ObjetoArtefacto artefacto) {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, artefacto.getNombre());
            statement.setString(2, artefacto.getDescripcion());
            statement.setString(3, artefacto.getTipo());
            statement.setDouble(4, artefacto.getAtaque());
            statement.setInt(5, artefacto.getFuerza());
            statement.setInt(6, artefacto.getMovimiento());
            statement.setInt(7, artefacto.getMovimientoTurno());
            statement.setInt(8, artefacto.getNivel());
            statement.setDouble(9, artefacto.getResistencia());
            statement.setInt(10, artefacto.getSuperAtaque());
            statement.setInt(11, artefacto.getVida());
            statement.setInt(12, artefacto.getVidaGastar());
            statement.setInt(13, artefacto.getIdPropia());
            statement.executeUpdate();
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void delete(ObjetoArtefacto artefacto) {
        Connection connection = getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, artefacto.getIdPropia());
            statement.executeUpdate();
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    Connection getConnection() {
        return connection;
    }


    private ObjetoArtefacto buildFromResultSet(ResultSet resultSet) {

        try {
            String nombre = resultSet.getString("nombre");
            String descripcion = resultSet.getString("descripcion");
            // String tipo = resultSet.getString("tipo");
            double ataque = resultSet.getDouble("Ataque");
            int fuerza = resultSet.getInt("Fuerza");
            int movimiento = resultSet.getInt("Movimiento");
            int movimientoTurno = resultSet.getInt("Movimiento_turno");
            int nivel = resultSet.getInt("Nivel");
            double resistencia = resultSet.getDouble("Resistencia");
            int superAtaque = resultSet.getInt("Super_ataque");
            int vida = resultSet.getInt("Vida");
            int vidaGastar = resultSet.getInt("Vida_gastar");

            ObjetoArtefacto artefacto = new ObjetoArtefacto(nombre, descripcion, vida, resistencia, movimiento, ataque, fuerza, vidaGastar, movimientoTurno, superAtaque, nivel);
            artefacto.setIdPropia(resultSet.getInt("Id_artefacto"));
            return artefacto;
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }
}
