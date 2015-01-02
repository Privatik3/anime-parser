package anime.parser.general;

import anime.parser.dao.AnimeDao;
import anime.parser.domain.*;
import anime.parser.parser.StudioParser;

import java.sql.Date;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        Factory factory = Factory.getInstance();
        AnimeDao animeDao = factory.getAnimeDao();
        StudioParser studioParser = factory.getStudioParser();

        StudioEntity studio = new StudioEntity();
        int studioId = 58;

        studio.setId(studioId);
        studio.setName(studioParser.getStudioNameById(studioId));
        studio.setYear(studioParser.getStudioDateById(studioId));
        studio.setLogo(studioParser.getStudioLogoById(studioId));
        studio.setResources(studioParser.getStudioResourcesById(studioId));

        animeDao.setStudioByStudioId(studio);

        /*StudioResoucesEntity studioResouces = new StudioResoucesEntity();

        studioResouces.setResourcesUrl("http://ru.wikipedia.org/wiki/Studio_Pierrot");
        studioResouces.setResourcesNameByResourcesNameId(animeDao.getResourcesNameEntityById(1));
        studioResouces.setStudioByStudioId(animeDao.getStudioEntityById(58));*/

        System.out.println("Сохранино в базу!!!");
    }
}
