package pl.oskarpolak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {


    public static void main(String[] args) {

        MysqlConnector connector = MysqlConnector.getInstance();
        try {
            Statement statement = connector.getConnection().createStatement();
            statement.execute("" +
                    "INSERT INTO book1 VALUES(0, 'KsiazkaZJavy', 'Oskar', 50, '1991-05-01')");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
