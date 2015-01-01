package anime.parser.general;

import anime.parser.dao.AnimeDao;
import anime.parser.domain.AnimesEntity;
import anime.parser.parser.AnimeParser;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        Factory factory = Factory.getInstance();
        AnimeDao animeDao = factory.getAnimeDao();
        AnimeParser animeParser = factory.getAnimeParser();


        Integer animeId = 1;

        //Код получения инфы про аниме

        AnimesEntity animeInfo = animeParser.getParseAnimeInfoById(animeId);
        //....

        //Код сохранинея в базу ....

    }
}
