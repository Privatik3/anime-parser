package anime.parser.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("Неудалось загрузить драйвер!");
        }

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement()) {

            statement.execute("insert into users (name, age, email) values('alex', 23, 'yandex@yandex.ru')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
