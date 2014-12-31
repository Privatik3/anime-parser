package anime.parser.general;

import anime.parser.dao.AnimeDao;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        Factory factory = Factory.getInstance();
        AnimeDao animeDao = factory.getAnimeDao();


    }
}
