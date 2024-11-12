package at.hakimst;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        //INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, 'Alexander Klapeer', 'alklapeer@tsn.at'), (NULL, 'maria könne', 'maria.koenne@myimst.at');
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                Connection com = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
            }catch(SQLException e) {
                throw new RuntimeException("Die Verbindung nicht möglich");
            }
        }
        catch(ClassNotFoundException e){
            throw new RuntimeException("Treiber nicht gefunden!");
        }
    }
}