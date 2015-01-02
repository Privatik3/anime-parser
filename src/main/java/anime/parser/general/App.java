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

        AnimesEntity anime = animeDao.getAnimesByID(310);

        /*StudioEntity studio = new StudioEntity();

        studio.setId(58);
        studio.setName("Studio Pierrot");
        studio.setYear(Date.valueOf("1979-05-07"));
        studio.setLogo("http://www.world-art.ru/img/company_new/56.jpg");*/

        /*StudioResoucesEntity studioResouces = new StudioResoucesEntity();

        studioResouces.setResourcesUrl("http://ru.wikipedia.org/wiki/Studio_Pierrot");
        studioResouces.setResourcesNameByResourcesNameId(animeDao.getResourcesNameEntityById(1));
        studioResouces.setStudioByStudioId(animeDao.getStudioEntityById(58));

        animeDao.setStudioByStudioId(studioResouces);*/

        //System.out.println("Сохранино в базу!!!");
        System.out.println(anime);
    }
}
