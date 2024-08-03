package servicios;

import java.sql.*;

public class conexion {
    
    private static Connection cx = null;
    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cx == null) {
            try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/registro_estudiantes", "root", "12345678");
            } catch (SQLException ex) {
                System.out.println("Se conecto");
            } catch (ClassNotFoundException ex) {
               throw new ClassCastException(ex.getMessage());
            }
        }
        return cx;
    }
    public static void cerrar() throws SQLException {
        if (cx != null) {
            cx.close();
            System.out.println("Se desconecto");
        }
    }
}


