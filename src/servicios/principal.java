package servicios;

import gui.log;
import java.sql.SQLException;

public class principal {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        log log = new log();
        log.setVisible(true);
        log.setLocationRelativeTo(null);
    }
}
