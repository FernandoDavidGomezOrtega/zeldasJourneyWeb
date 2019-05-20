package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDB {
    public Connection openConnection() throws Exception {

        Connection con = null; //instancia una conexion

        try {
            Class.forName("com.mysql.jdbc.Driver"); // se carga el driver
            //String urlOdbc = "jdbc:mysql://192.168.64.2:3306/zeldasjourney";
            String urlOdbc = "jdbc:mysql://localhost:3306/zeldasjourneyweb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            con = java.sql.DriverManager.getConnection(urlOdbc, "root", ""); //crea la conexion
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No se pudo establecer la conexión" + e.getMessage());
        }
    }

    public void closeConnection(Connection con) throws Exception {
        try {
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No se pudo cerrar la conexión" + e.getMessage());
        }
    }

    /**
     * Prints the sql exception in a fancy way
     * <p>
     * Inspired from: https://docs.oracle.com/javase/tutorial/jdbc/basics/sqlexception.html
     *
     * @param sqlException
     */
    public static void printSQLException(SQLException sqlException) {
        for (Throwable e : sqlException) {
            if (e instanceof SQLException) {
                if (!ignoreSQLException(((SQLException) e).getSQLState())) {

                    e.printStackTrace(System.err);
                    System.err.println("SQLState: " +
                            ((SQLException) e).getSQLState());

                    System.err.println("Error Code: " +
                            ((SQLException) e).getErrorCode());

                    System.err.println("Message: " + e.getMessage());

                    Throwable t = e.getCause();
                    while (t != null) {
                        System.out.println("Cause: " + t);
                        t = t.getCause();
                    }
                }
            }
        }
    }

    /**
     * Indicates if certan exception codes can be ignored
     * <p>
     * Inspired from: https://docs.oracle.com/javase/tutorial/jdbc/basics/sqlexception.html
     *
     * @param sqlState state to check if ignore
     */
    public static boolean ignoreSQLException(String sqlState) {

        if (sqlState == null) {
            System.out.println("The SQL state is not defined!");
            return false;
        }

        // X0Y32: Jar file already exists in schema
        if (sqlState.equalsIgnoreCase("X0Y32"))
            return true;

        // 42Y55: Table already exists in schema
        return sqlState.equalsIgnoreCase("42Y55");

    }
}