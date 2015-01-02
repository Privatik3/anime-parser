package anime.parser.saveDbInfo;


import anime.parser.dao.AnimeDao;
import anime.parser.domain.*;
import anime.parser.general.Factory;
import anime.parser.parser.AnimeInfoParser;
import anime.parser.parser.DirectedParser;
import anime.parser.parser.StudioParser;
import anime.parser.parser.enums.AnimeGenres;

import java.util.List;

public class SaveDBInfo {

    StudioEntity studioEntity;
    DirectedEntity directedEntity;
    YearProductionEntity yearProductionEntity;
    AnimesEntity animesEntity;
    List<AnimeGenreEntity> animeGenreEntitys;
    List<AnimeResourcesEntity> animeResourcesEntitys;
    List<ScreenshotsEntity> screenshotsEntitys;

    Factory factory = Factory.getInstance();

    AnimeDao animeDao = factory.getAnimeDao();

    StudioParser studioParser = factory.getStudioParser();
    DirectedParser directedParser = factory.getDirectedParser();
    AnimeInfoParser animeInfoParser = factory.getAnimeParser();


    public void initAll(int animeId){
        studioEntity
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

    public void initYearProduction(int yearproductionId){
        yearProductionEntity.setId(yearproductionId);
        try {
            yearProductionEntity.setBegin(animeInfoParser.getYearStartById(yearproductionId));
            yearProductionEntity.setEnded(animeInfoParser.getYearEndById(yearproductionId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initAnimeGenre(int animeGenreId){

        for (AnimeGenres genre : animeInfoParser.getGenresById(animesEntity.getId()))
        animeGenreEntitys.setId(animeGenreId);
        animeGenreEntitys.setAnimesByAnimesId(animesEntity);
        animeGenreEntitys.setGenresByGenresId(animeDao.getGenresEntityByID(animeInfoParser.getGenresById()));
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
