package anime.parser.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import anime.parser.anime.Anime;
import anime.parser.anime.AnimeConnection;
import anime.parser.anime.AnimeGenres;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class SaverAnimes {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";



    Driver driver;

    public SaverAnimes() {

        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("Неудалось загрузить драйвер!");
        }
    }

    public boolean saveAnime(Anime anime) {

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement()) {

            saveAnimeInfo(anime, statement);
            //saveAnimeScreenshots(anime, statement);
            //saveAnimeGenres(anime, statement);
            //saveAnimeConnections(anime, statement);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void saveAnimeInfo(Anime anime, Statement statement) throws SQLException {

        String other_title = "";
        if (anime.getOtherTitles().size() > 0) {
            for (String title : anime.getOtherTitles()) {
                other_title += title + ";";
            }
            other_title = other_title.replace("'", "");
        }

        /*String request = "INSERT INTO animes(id, main_img, main_title, other_title, anime_type_id, production_id, year_production, review, average, ranced, voted)";
        request += String.format("VALUES ('%d', '%s', '%s', '%s', '%d', '%d', '%s', '%s', '%s', '%d', '%d')",
                anime.getID(), anime.getMainImg(), anime.getMainTitle().replace("'", ""),
                other_title, anime.getType().ordinal() + 1,anime.getProduction().ordinal() + 1,
                new SimpleDateFormat("yyyy.MM.dd").format(anime.getYear()), anime.getReview().replace("'", ""),
                anime.getWorldArtAverage(), anime.getWorldArtRanced(), anime.getWorldArtVoted());*/

        String request = "UPDATE animes ";
        request += String.format("SET other_title='%s' WHERE id=%d;",
                other_title, anime.getID());

        statement.execute(request);
        //System.out.println(request);
    }

    public void saveAnimeConnections(Anime anime, Statement statement) throws SQLException {

        if (anime.getConnections().size() > 0) {
            String request = "INSERT INTO connections (id_connection, text, animes_id)";

            for (AnimeConnection connection : anime.getConnections()) {

                String values = String.format("VALUES ('%d', '%s', '%d');",
                        connection.getId(), connection.getText(), anime.getID());

                statement.execute(request + values);
            }
        }
    }

    public void saveAnimeScreenshots(Anime anime, Statement statement) throws SQLException {

        if (anime.getScreenshots().size() > 0) {
            String request = "INSERT INTO screenshots (url, animes_id)";

            for (String url : anime.getScreenshots()) {

                String values = String.format("VALUES ('%s', '%d');",
                        url, anime.getID());

                statement.execute(request + values);
            }
        }
    }

    public void saveAnimeGenres(Anime anime, Statement statement) throws SQLException {

        String request = "INSERT INTO anime_genre (animes_id, genres_id) ";

        for (AnimeGenres genre : anime.getGenres()) {

            String values = String.format("VALUES ('%d', '%d');",
                    anime.getID(), genre.ordinal() + 1);

            statement.execute(request + values);
        }
    }
}
