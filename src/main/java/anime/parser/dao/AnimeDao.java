package anime.parser.dao;

import anime.parser.domain.*;

import java.sql.SQLException;

public interface AnimeDao {

    // методы для сохранения данных

    public void setAnimeInfoById(AnimesEntity animeInfoById) throws SQLException;
    public void setAnimesGanresById(AnimeGenreEntity animesGanresById) throws SQLException;
    public void setAnimeResourcesesById(AnimeResourcesEntity animeResourcesesById) throws SQLException;
    public void setDirectedByDirectedId(DirectedEntity directedByDirectedId) throws SQLException;
    public void setGenresById(GenresEntity genresById) throws SQLException;
    public void setResourcesNameById(ResourcesNameEntity resourcesNameById) throws SQLException;
    public void setSecondNameById(OtherTitleEntity secondNameById) throws SQLException;
    public void setStudioByStudioId(StudioEntity studioByStudioId)throws SQLException;
    public void setAnimeTypesByAnimeTypeId(TypesEntity animeTypesByAnimeTypeId)throws SQLException;
    public void setYearProductionByYearProductionId(YearProductionEntity yearProductionByYearProductionId)throws SQLException;
    public void setConnectionsesById(ConnectionsEntity connectionsesById)throws SQLException;
    public void setScreenshotsesById(ScreenshotsEntity screenshotsesById)throws SQLException;

    // методы для загрузки данных

    public AnimesEntity getAnimesByID(Integer getAnimesById) throws SQLException;
    public AnimeGenreEntity getAnimeGenreEntityById(Integer getAnimeGenreEntityById) throws SQLException;
    public AnimeResourcesEntity getAnimeResourcesEntityById(Integer getAnimeResourcesEntityByID) throws SQLException;
    public ConnectionsEntity getConnectionsEntityByID(Integer getConnectionsEntityById) throws SQLException;
    public DirectedEntity getDirectedEntityById(Integer getDirectedEntityById) throws SQLException;
    public GenresEntity getGenresEntityByID(Integer getGenresEntityById) throws SQLException;
    public OtherTitleEntity getOtherTitleEntityById(Integer getOtherTitleEntityById) throws SQLException;
    public ResourcesNameEntity getResourcesNameEntityById(Integer getResourcesNameById) throws SQLException;
    public ScreenshotsEntity getScreenshotsEntityById(Integer getScreenshotsEntityById) throws SQLException;
    public StudioEntity getStudioEntityById(Integer getStudioEntityById) throws SQLException;
    public TypesEntity getTypesEntityById(Integer getTypesEntityById) throws SQLException;
    public YearProductionEntity getYearProductionEntityById(Integer getYearProductionEntityById) throws SQLException;


}