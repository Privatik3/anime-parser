package anime.parser.general;

import anime.parser.saveDbInfo.SaveDBInfo;

import java.io.IOException;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException, IOException {

        SaveDBInfo saver = new SaveDBInfo();
        int animeId = 311;

        try {
            saver.saveAnimeToDb(animeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
