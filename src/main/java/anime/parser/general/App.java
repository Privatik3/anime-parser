package anime.parser.general;

import anime.parser.dao.AnimeDao;
import anime.parser.domain.*;
import anime.parser.parser.AnimeParser;

import java.sql.Date;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        Factory factory = Factory.getInstance();
        AnimeDao animeDao = factory.getAnimeDao();
        //AnimeParser animeParser = factory.getAnimeParser();

        //AnimesEntity anime = animeDao.getAnimesByID(310);

        AnimeResourcesEntity resources = new AnimeResourcesEntity();

        ConnectionsEntity connections = new ConnectionsEntity();

        connections.setIdConnection(5548);
        connections.setText("sfsdfsdfdfdf");

        connections.setAnimesByAnimesId(animeDao.getAnimesByID(310));


        animeDao.setConnectionsesById(connections);

        System.out.println("Сохранино в базу!!!");
        //System.out.println(anime);
    }
}
