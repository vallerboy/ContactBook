package pl.oskarpolak;

import java.sql.*;

public class Main {


    public static void main(String[] args) {

        MysqlConnector connector = MysqlConnector.getInstance();
        try {
            PreparedStatement statement = connector.getConnection().prepareStatement(
                    "INSERT INTO book1 VALUES(?, ?, ?, ?, ?)"
            );
            statement.setInt(1, 0);
            statement.setString(2, "mojaKsiazka");
            statement.setString(3, "Tomek");
            statement.setInt(4, 999);
            statement.setString(5, "1950-05-05");

           statement.execute();

           Statement statement1 = connector.getConnection().createStatement();
           statement.executeQuery("INSERT INTO book1 VALUES(0, ')" + "tytul','" + "autor','" + 999 + "','" + "1999-01-01')");

           Statement statement2 = connector.getConnection().createStatement();
           ResultSet set = statement2.executeQuery("SELECT * FROM book1");

           while (set.next()){
               System.out.println("tutaj moge wyswietlac dane!");
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
