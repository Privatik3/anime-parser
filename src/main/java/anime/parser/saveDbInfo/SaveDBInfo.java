package anime.parser.saveDbInfo;


import anime.parser.dao.AnimeDao;
import anime.parser.domain.*;
import anime.parser.general.Factory;
import anime.parser.parser.AnimeInfoParser;
import anime.parser.parser.DirectedParser;
import anime.parser.parser.StudioParser;
import anime.parser.parser.enums.AnimeGenres;
import anime.parser.parser.struct.AnimeConnection;
import anime.parser.parser.struct.AnimeResources;
import anime.parser.utill.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaveDBInfo {

    StudioEntity studioEntity = new StudioEntity();
    DirectedEntity directedEntity = new DirectedEntity();
    YearProductionEntity yearProductionEntity = new YearProductionEntity();
    AnimesEntity animesEntity = new AnimesEntity();
    List<OtherTitleEntity> otherTitleEntity = new ArrayList<>();
    List<AnimeGenreEntity> animeGenreEntitys = new ArrayList<>();
    List<AnimeResourcesEntity> animeResourcesEntitys = new ArrayList<>();
    List<ScreenshotsEntity> screenshotsEntitys = new ArrayList<>();
    List<ConnectionsEntity> connectionsEntities = new ArrayList<>();

    Factory factory = Factory.getInstance();

    AnimeDao animeDao = factory.getAnimeDao();

    StudioParser studioParser = factory.getStudioParser();
    DirectedParser directedParser = factory.getDirectedParser();
    AnimeInfoParser animeInfoParser = factory.getAnimeParser();




    private void saveAll() throws SQLException {

        long start = System.currentTimeMillis();
        if (studioEntity != null && animeDao.getStudioEntityById(studioEntity.getId()) == null)
            animeDao.setStudioByStudioId(studioEntity);
        long end = System.currentTimeMillis();
        System.out.println("Студию закачало за " + ((end - start) / 1000d) + " секунд");


        start = System.currentTimeMillis();
        if (animeDao.getDirectedEntityById(directedEntity.getId()) == null)
            animeDao.setDirectedByDirectedId(directedEntity);
        end = System.currentTimeMillis();
        System.out.println("Рижессёра закачало за " + ((end - start) / 1000d) + " секунд");


        start = System.currentTimeMillis();
        animeDao.setYearProductionByYearProductionId(yearProductionEntity);
        end = System.currentTimeMillis();
        System.out.println("Год производства закачало за " + ((end - start) / 1000d) + " секунд");


        start = System.currentTimeMillis();
        animeDao.setAnimeInfoById(animesEntity);
        end = System.currentTimeMillis();
        System.out.println("Аниме закачало за " + ((end - start) / 1000d) + " секунд");


        start = System.currentTimeMillis();
        for (AnimeGenreEntity animeGenreEntity : animeGenreEntitys){
            animeDao.setAnimesGanresById(animeGenreEntity);
        }
        end = System.currentTimeMillis();
        System.out.println("Жанры закачало за " + ((end - start) / 1000d) + " секунд");


        start = System.currentTimeMillis();
        for (AnimeResourcesEntity animeResourcesEntity : animeResourcesEntitys){
            animeDao.setAnimeResourcesesById(animeResourcesEntity);
        }
        end = System.currentTimeMillis();
        System.out.println("Ресурсы аниме закачало за " + ((end - start) / 1000d) + " секунд");


        start = System.currentTimeMillis();
        /*for (ScreenshotsEntity screenshotsEntity : screenshotsEntitys){
            animeDao.setScreenshotsesById(screenshotsEntity);
        }*/
        animeDao.setAllScreenshotses(screenshotsEntitys);
        end = System.currentTimeMillis();
        System.out.println("Скриншоты закачало за " + ((end - start) / 1000d) + " секунд");


        start = System.currentTimeMillis();
        for (OtherTitleEntity otherTitle : otherTitleEntity){
            animeDao.setSecondNameById(otherTitle);
        }
        end = System.currentTimeMillis();
        System.out.println("Альтернативные тайтлы закачало за " + ((end - start) / 1000d) + " секунд");


        start = System.currentTimeMillis();
        for (ConnectionsEntity connectionsEntity : connectionsEntities){
            animeDao.setConnectionsesById(connectionsEntity);
        }
        end = System.currentTimeMillis();
        System.out.println("Конекты закачало за " + ((end - start) / 1000d) + " секунд");
    }

    public boolean saveAnimeToDb(int animeId) throws Exception {

        initAll(animeId);
        long start = System.currentTimeMillis();
        saveAll();
        long end = System.currentTimeMillis();
        System.out.println("Общее время закачки " + ((end - start) / 1000d) + " секунд");


        return true;
    }

    private void initAll(int animeId) throws Exception {
        initStudio(animeInfoParser.getStudioIdById(animeId));
        initDirected(animeInfoParser.getDirectedIdById(animeId));
        initYearProduction(animeId);
        initAnimeInfo(animeId);
        initAnimeGenre(animeId);
        initAnimeResouces(animeId);
        initScreenshots(animeId);
        initOtherTitles(animeId);
        initConnections(animeId);
    }

    private void initAnimeInfo(int animesId) throws Exception {
        animesEntity.setId(animesId);
        animesEntity.setMainImg(animeInfoParser.getMainImgById(animesId));
        animesEntity.setMainTitle(animeInfoParser.getMainTitleById(animesId));
        animesEntity.setTypesByAnimeTypeId(animeDao.getTypesEntityById(animeInfoParser.getTypeById(animesId).ordinal() + 1));
        animesEntity.setReview(animeInfoParser.getReviewById(animesId));
        animesEntity.setAverage(animeInfoParser.getAverageById(animesId));
        animesEntity.setRanced(animeInfoParser.getRancedById(animesId));
        animesEntity.setVoted(animeInfoParser.getVotedById(animesId));

        if (studioEntity != null)
            animesEntity.setStudioByStudioId(studioEntity);

        animesEntity.setDirectedByDirectedId(directedEntity);
        animesEntity.setYearProductionByYearProductionId(yearProductionEntity);
        animesEntity.setTypeInfo(animeInfoParser.getTypeInfoById(animesId));

    }

    private void initDirected(int directId) throws Exception{
            directedEntity.setId(directId);
            directedEntity.setName(directedParser.getDirectedNameById(directId));
            directedEntity.setResources(directedParser.getDirectedResourcesById(directId));

    }

    private void initYearProduction(int animeId) throws Exception{
            yearProductionEntity.setId(animeId);
            yearProductionEntity.setBegin(animeInfoParser.getYearStartById(animeId));
            yearProductionEntity.setEnded(animeInfoParser.getYearEndById(animeId));
    }

    private void initAnimeGenre(int animeId) throws Exception{
            for (AnimeGenres genre : animeInfoParser.getGenresById(animeId)) {
                AnimeGenreEntity tempAnimeGenre = new AnimeGenreEntity();

                tempAnimeGenre.setAnimesByAnimesId(animesEntity);
                tempAnimeGenre.setGenresByGenresId(animeDao.getGenresEntityByID(genre.ordinal() + 1));

                animeGenreEntitys.add(tempAnimeGenre);
            }

    }

    private void initAnimeResouces(int animeId) throws Exception{
            for (AnimeResources resources : animeInfoParser.getResourcesById(animeId)){
                AnimeResourcesEntity tempAnimeResoucesName = new AnimeResourcesEntity();

                tempAnimeResoucesName.setAnimesByAnimesId(animesEntity);
                tempAnimeResoucesName.setResourcesNameByResourcesNameId(
                        animeDao.getResourcesNameEntityById(resources.getName().ordinal() + 1));
                tempAnimeResoucesName.setUrl(resources.getUrl());

                animeResourcesEntitys.add(tempAnimeResoucesName);
            }
    }

    private void initScreenshots(int animeId) throws Exception{
            for (String screenshotUrl : animeInfoParser.getScreenshotsById(animeId)){
                ScreenshotsEntity tempScreenshots = new ScreenshotsEntity();

                tempScreenshots.setUrl(screenshotUrl);
                tempScreenshots.setAnimesByAnimesId(animesEntity);

                screenshotsEntitys.add(tempScreenshots);
            }
    }

    private void initConnections(int animeId) throws Exception{
            for (AnimeConnection connections : animeInfoParser.getConnectionsById(animeId)){
                ConnectionsEntity tempConnections = new ConnectionsEntity();

                tempConnections.setIdConnection(connections.getConnectionId());
                tempConnections.setText(connections.getInfo());
                tempConnections.setAnimesByAnimesId(animesEntity);

                connectionsEntities.add(tempConnections);
            }
    }

    private void initOtherTitles(int animeId) throws Exception{
        for (String othertitles : animeInfoParser.getOtherTitleById(animeId)){
            OtherTitleEntity tempOtherTitles = new OtherTitleEntity();

            tempOtherTitles.setName(othertitles);
            tempOtherTitles.setAnimesByAnimesId(animesEntity);

            otherTitleEntity.add(tempOtherTitles);
        }
    }


    private void initStudio(int animeId) throws Exception {

        int studioId = animeInfoParser.getStudioIdById(animeId);

        if (studioId == 0) {
            studioEntity = null;
            return;
        }

        studioEntity.setId(studioId);
        studioEntity.setName(studioParser.getStudioNameById(studioId));
        studioEntity.setYear(studioParser.getStudioDateById(studioId));
        studioEntity.setLogo(studioParser.getStudioLogoById(studioId));
        studioEntity.setResources(studioParser.getStudioResourcesById(studioId));
    }
}
