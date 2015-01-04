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
import com.sun.deploy.security.SecureStaticVersioning;
import org.hibernate.Session;

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




    private void saveAll(Session session) throws SQLException {

        if (studioEntity != null && animeDao.getStudioEntityById(studioEntity.getId(), session) == null)
            animeDao.setStudioByStudioId(studioEntity, session);

        if (directedEntity != null && animeDao.getDirectedEntityById(directedEntity.getId(), session) == null)
            animeDao.setDirectedByDirectedId(directedEntity, session);

        animeDao.setYearProductionByYearProductionId(yearProductionEntity, session);
        animeDao.setAnimeInfoById(animesEntity, session);
        animeDao.setAllGenres(animeGenreEntitys, session);
        animeDao.setAllAnimeResources(animeResourcesEntitys, session);
        animeDao.setAllScreenshotses(screenshotsEntitys, session);
        animeDao.setAllOtherTitles(otherTitleEntity, session);
        animeDao.setAllConnections(connectionsEntities, session);
    }

    public boolean saveAnimeToDb(int animeId, Session session) throws Exception {

        initAll(animeId, session);
        saveAll(session);

        return true;
    }

    private void initAll(int animeId, Session session) throws Exception {
        initStudio(animeId);
        Thread.sleep(500);
        initDirected(animeId);
        Thread.sleep(500);
        initYearProduction(animeId);
        Thread.sleep(500);
        initAnimeInfo(animeId, session);
        Thread.sleep(500);
        initAnimeGenre(animeId, session);
        Thread.sleep(500);
        initAnimeResouces(animeId, session);
        Thread.sleep(500);
        initScreenshots(animeId);
        Thread.sleep(500);
        initOtherTitles(animeId);
        Thread.sleep(500);
        initConnections(animeId);
        Thread.sleep(500);
    }

    private void initAnimeInfo(int animesId, Session session) throws Exception {
        animesEntity.setId(animesId);
        animesEntity.setMainImg(animeInfoParser.getMainImgById(animesId));
        animesEntity.setMainTitle(animeInfoParser.getMainTitleById(animesId));
        animesEntity.setTypesByAnimeTypeId(animeDao.getTypesEntityById(animeInfoParser.getTypeById(animesId).ordinal() + 1, session));
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

    private void initDirected(int animeId) throws Exception {
        int directId = animeInfoParser.getDirectedIdById(animeId);

        if (directId == 0) {
            directedEntity = null;
            return;
        }

        directedEntity.setId(directId);
        directedEntity.setName(directedParser.getDirectedNameById(directId));
        directedEntity.setResources(directedParser.getDirectedResourcesById(directId));
    }

    private void initYearProduction(int animeId) throws Exception{
            yearProductionEntity.setId(animeId);
            yearProductionEntity.setBegin(animeInfoParser.getYearStartById(animeId));
            yearProductionEntity.setEnded(animeInfoParser.getYearEndById(animeId));
    }

    private void initAnimeGenre(int animeId, Session session) throws Exception {

            for (AnimeGenres genre : animeInfoParser.getGenresById(animeId)) {
                AnimeGenreEntity tempAnimeGenre = new AnimeGenreEntity();

                tempAnimeGenre.setAnimesByAnimesId(animesEntity);
                tempAnimeGenre.setGenresByGenresId(animeDao.getGenresEntityByID(genre.ordinal() + 1, session));

                animeGenreEntitys.add(tempAnimeGenre);
            }

    }

    private void initAnimeResouces(int animeId, Session session) throws Exception {
            for (AnimeResources resources : animeInfoParser.getResourcesById(animeId)){
                AnimeResourcesEntity tempAnimeResoucesName = new AnimeResourcesEntity();

                tempAnimeResoucesName.setAnimesByAnimesId(animesEntity);
                tempAnimeResoucesName.setResourcesNameByResourcesNameId(
                        animeDao.getResourcesNameEntityById(resources.getName().ordinal() + 1, session));
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
