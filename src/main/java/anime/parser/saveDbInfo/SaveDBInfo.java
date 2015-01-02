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

import java.util.List;

public class SaveDBInfo {

    StudioEntity studioEntity;
    DirectedEntity directedEntity;
    YearProductionEntity yearProductionEntity;
    AnimesEntity animesEntity;
    OtherTitleEntity otherTitleEntity;
    List<AnimeGenreEntity> animeGenreEntitys;
    List<AnimeResourcesEntity> animeResourcesEntitys;
    List<ScreenshotsEntity> screenshotsEntitys;
    List<ConnectionsEntity> connectionsEntities;


    Factory factory = Factory.getInstance();

    AnimeDao animeDao = factory.getAnimeDao();

    StudioParser studioParser = factory.getStudioParser();
    DirectedParser directedParser = factory.getDirectedParser();
    AnimeInfoParser animeInfoParser = factory.getAnimeParser();


    public void initAll(int animeId){
        //studioEntity
    }


    public void initAnimeInfo(int animesId){
        animesEntity.setId(animesId);
        try {
            animesEntity.setMainImg(animeInfoParser.getMainImgById(animesId));
            animesEntity.setMainTitle(animeInfoParser.getMainTitleById(animesId));
            animesEntity.setTypesByAnimeTypeId(animeDao.
                    getTypesEntityById(animeInfoParser.getTypeById(animesId).ordinal() + 1));
            animesEntity.setReview(animeInfoParser.getReviewById(animesId));
            animesEntity.setAverage(animeInfoParser.getAverageById(animesId));
            animesEntity.setRanced(animeInfoParser.getRancedById(animesId));
            animesEntity.setVoted(animeInfoParser.getVotedById(animesId));
            animesEntity.setStudioByStudioId(studioEntity);
            animesEntity.setDirectedByDirectedId(directedEntity);
            animesEntity.setYearProductionByYearProductionId(yearProductionEntity);
            animesEntity.setTypeInfo(animeInfoParser.getTypeInfoById(animesId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initDirected(int directId){
        directedEntity.setId(directId);
        try {
            directedEntity.setName(directedParser.getDirectedNameById(directId));
            directedEntity.setResources(directedParser.getDirectedResourcesById(directId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initYearProduction(int animeId){
        yearProductionEntity.setId(animeId);
        try {
            yearProductionEntity.setBegin(animeInfoParser.getYearStartById(animeId));
            yearProductionEntity.setEnded(animeInfoParser.getYearEndById(animeId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initAnimeGenre(int animeId){
        try {
            for (AnimeGenres genre : animeInfoParser.getGenresById(animeId)) {
                AnimeGenreEntity tempAnimeGenre = new AnimeGenreEntity();

                tempAnimeGenre.setId(animeId);
                tempAnimeGenre.setAnimesByAnimesId(animesEntity);
                tempAnimeGenre.setGenresByGenresId(animeDao.getGenresEntityByID(genre.ordinal() + 1));

                animeGenreEntitys.add(tempAnimeGenre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initAnimeResouces(int animeId){
        try {
            for (AnimeResources resources : animeInfoParser.getResourcesById(animeId)){
                AnimeResourcesEntity tempAnimeResoucesName = new AnimeResourcesEntity();

                tempAnimeResoucesName.setAnimesByAnimesId(animesEntity);
                tempAnimeResoucesName.setResourcesNameByResourcesNameId(
                        animeDao.getResourcesNameEntityById(resources.getName().ordinal() + 1));
                tempAnimeResoucesName.setUrl(resources.getUrl());

                animeResourcesEntitys.add(tempAnimeResoucesName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initScreenshots(int animeId){
        try {
            for (String screenshotsUrl : animeInfoParser.getScreenshotsById(animeId)){
                ScreenshotsEntity tempScreenshots = new ScreenshotsEntity();

                tempScreenshots.setUrl(screenshotsUrl);
                tempScreenshots.setAnimesByAnimesId(animesEntity);

                screenshotsEntitys.add(tempScreenshots);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initConnections(int animeId){
        try {
            for (AnimeConnection connections : animeInfoParser.getConnectionsById(animeId)){
                ConnectionsEntity tempConnections = new ConnectionsEntity();

                tempConnections.setIdConnection(animeId);
                tempConnections.setText(connections.getInfo());
                tempConnections.setAnimesByAnimesId(animesEntity);

                connectionsEntities.add(tempConnections);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void initStudio(int studioId){
        studioEntity.setId(studioId);
        try {
            studioEntity.setName(studioParser.getStudioNameById(studioId));
            studioEntity.setYear(studioParser.getStudioDateById(studioId));
            studioEntity.setLogo(studioParser.getStudioLogoById(studioId));
            studioEntity.setResources(studioParser.getStudioResourcesById(studioId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
