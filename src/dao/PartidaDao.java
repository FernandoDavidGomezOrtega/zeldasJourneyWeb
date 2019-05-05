package dao;

import dao.ConnectionDB;
import entidades.ObjetoArma;
import entidades.ObjetoArtefacto;
import entidades.ObjetoEscudo;
import entidades.Partida;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PartidaDao {

    private static final String SELECT_ONE_QUERY = "SELECT Id_partida, nombre, Descripcion " +
            "FROM Partida where Id_partida = ?";
    private static final String SELECT_ALL_QUERY = "SELECT Id_partida, nombre, Descripcion " +
            "FROM Partida";
    private static final String INSERT_QUERY = "INSERT INTO Partida(nombre, Descripcion) " +
            "VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE Partida " +
            "SET nombre = ?, Descripcion = ? " +
            "WHERE Id_partida = ?";
    private static final String DELETE_QUERY = "DELETE FROM Partida WHERE Id_partida = ?";
    private static final String INSERT_ARMA_QUERY = "INSERT IGNORE INTO Arma_Partida(fk_id_partida, fk_id_arma) VALUES (?, ?)";
    private static final String DELETE_ARMA_QUERY = "DELETE FROM Arma_Partida WHERE fk_id_partida = ? AND fk_id_arma = ?";
    private static final String INSERT_ARTEFACTO_QUERY = "INSERT IGNORE INTO Artefacto_Partida(fk_id_partida, fk_id_artefacto) VALUES (?, ?)";
    private static final String DELETE_ARTEFACTO_QUERY = "DELETE FROM Artefacto_Partida WHERE fk_id_partida = ? AND fk_id_artefacto = ?";
    private static final String INSERT_ESCUDO_QUERY = "INSERT IGNORE INTO Escudo_Partida (fk_id_partida, fk_id_escudo) VALUES (?, ?)";
    private static final String DELETE_ESCUDO_QUERY = "DELETE FROM Escudo_Partida WHERE fk_id_partida = ? AND fk_id_escudo = ?";

    private final Connection connection;
    private final ArmasDao armasDao;
    private final ArtefactoDao artefactoDao;
    private final EscudoDao escudoDao;

    public PartidaDao(Connection connection) {
        this.connection = connection;
        this.armasDao = new ArmasDao(connection);
        this.artefactoDao = new ArtefactoDao(connection);
        this.escudoDao = new EscudoDao(connection);
    }

    public Optional<Partida> get(Integer id) {
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

    public List<Partida> getAll() {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {

            List<Partida> results = new ArrayList<>();

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

    public void save(Partida partida) {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection
                .prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            //nombre, Descripcion
            statement.setString(1, partida.getNombre());
            statement.setString(2, partida.getDescripcion());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating partida failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    partida.setIdPropia(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating partida failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void update(Partida partida) {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, partida.getNombre());
                   statement.setString(2, partida.getDescripcion());
                   statement.setDouble(3, partida.getIdPropia());
            statement.executeUpdate();
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void delete(Partida partida) {
        Connection connection = getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, partida.getIdPropia());
            statement.executeUpdate();
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void addArma(Partida partida, ObjetoArma arma) {

        if (partida.getIdPropia() == null) {
            throw new IllegalArgumentException("Es obligatorio que la partida tenga un id");
        }

        if (arma.getIdPropia() <= 0) {
            throw new IllegalArgumentException("Es obligatorio que la arma tenga un id");
        }


        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(INSERT_ARMA_QUERY)) {

            statement.setInt(1, partida.getIdPropia());
            statement.setInt(2, arma.getIdPropia());

            int affectedRows = statement.executeUpdate();

            if (affectedRows != 0) {
                partida.addArma(arma);
            }


        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void deleteArma(Partida partida, ObjetoArma arma) {

        if (partida.getIdPropia() == null) {
            throw new IllegalArgumentException("Es obligatorio que la partida tenga un id");
        }

        if (arma.getIdPropia() <= 0) {
            throw new IllegalArgumentException("Es obligatorio que la arma tenga un id");
        }


        if (!partida.getArmas().contains(arma)) {
            throw new IllegalArgumentException("Laa partida no contiene el arma.");
        }


        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(DELETE_ARMA_QUERY)) {

            statement.setInt(1, partida.getIdPropia());
            statement.setInt(2, arma.getIdPropia());

            statement.executeUpdate();

            partida.deleteArma(arma);

        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void addArtefacto(Partida partida, ObjetoArtefacto artefacto) {

        if (partida.getIdPropia() == null) {
            throw new IllegalArgumentException("Es obligatorio que la partida tenga un id");
        }

        if (artefacto.getIdPropia() <= 0) {
            throw new IllegalArgumentException("Es obligatorio que el artefacto tenga un id");
        }

        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(INSERT_ARTEFACTO_QUERY)) {

            statement.setInt(1, partida.getIdPropia());
            statement.setInt(2, artefacto.getIdPropia());

            int affectedRows = statement.executeUpdate();

            if (affectedRows != 0) {
                partida.addArtefacto(artefacto);
            }

        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void deleteArtefacto(Partida partida, ObjetoArtefacto artefacto) {

        if (partida.getIdPropia() == null) {
            throw new IllegalArgumentException("Es obligatorio que la partida tenga un id");
        }

        if (artefacto.getIdPropia() <= 0) {
            throw new IllegalArgumentException("Es obligatorio que el artefacto tenga un id");
        }


        if (!partida.getArtefactos().contains(artefacto)) {
            throw new IllegalArgumentException("La partida no contiene el artefacto.");
        }

        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(DELETE_ARTEFACTO_QUERY)) {

            statement.setInt(1, partida.getIdPropia());
            statement.setInt(2, artefacto.getIdPropia());

            statement.executeUpdate();

            partida.deleteArtefacto(artefacto);

        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void addEscudo(Partida partida, ObjetoEscudo escudo) {

        if (partida.getIdPropia() == null) {
            throw new IllegalArgumentException("Es obligatorio que la partida tenga un id");
        }

        if (escudo.getIdPropia() <= 0) {
            throw new IllegalArgumentException("Es obligatorio que el escudo tenga un id");
        }

        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(INSERT_ESCUDO_QUERY)) {

            statement.setInt(1, partida.getIdPropia());
            statement.setInt(2, escudo.getIdPropia());

            int affectedRows = statement.executeUpdate();

            if (affectedRows != 0) {
                partida.addEscudo(escudo);
            }


        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void deleteEscudo(Partida partida, ObjetoEscudo escudo) {

        if (partida.getIdPropia() == null) {
            throw new IllegalArgumentException("Es obligatorio que la partida tenga un id");
        }

        if (escudo.getIdPropia() <= 0) {
            throw new IllegalArgumentException("Es obligatorio que el escudo tenga un id");
        }


        if (!partida.getEscudos().contains(escudo)) {
            throw new IllegalArgumentException("La partida no contiene el escudo.");
        }

        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(DELETE_ESCUDO_QUERY)) {

            statement.setInt(1, partida.getIdPropia());
            statement.setInt(2, escudo.getIdPropia());

            statement.executeUpdate();

            partida.deleteEscudo(escudo);

        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    Connection getConnection() {
        return connection;
    }


    private Partida buildFromResultSet(ResultSet resultSet) {

        // Id_partida, nombre, Descripcion
        try {
            String nombre = resultSet.getString("nombre");
            String descripcion = resultSet.getString("descripcion");
            Partida partida = new Partida();
            partida.setDescripcion(descripcion);
            partida.setNombre(nombre);
            partida.setIdPropia(resultSet.getInt("Id_partida"));

            List<ObjetoArma> armas = armasDao.getAllByPartida(partida.getIdPropia());
            partida.setArmas(armas);

            List<ObjetoArtefacto> artefactos = artefactoDao.getAllByPartida(partida.getIdPropia());
            partida.setArtefactos(artefactos);

            List<ObjetoEscudo> escudos = escudoDao.getAllByPartida(partida.getIdPropia());
            partida.setEscudos(escudos);

            return partida;
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }
}
