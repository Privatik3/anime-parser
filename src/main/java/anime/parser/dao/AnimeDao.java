package anime.parser.dao;

import anime.parser.domain.*;

import java.sql.SQLException;

public interface AnimeDao {

    public void setAnimeInfoById(AnimesEntity animeInfoById) throws SQLException;
    public void setAnimesGanresById(AnimeGenreEntity animesGanresById) throws SQLException;
    public void setAnimeResourcesesById(AnimeResourcesEntity animeResourcesesById) throws SQLException;
    public void setDirectedByDirectedId(DirectedEntity directedByDirectedId) throws SQLException;
    public void setSecondNameByOtherTitleId(ScreenshotsEntity secondNameByOtherTitleId) throws SQLException;
    public void setStudioByStudioId(StudioEntity studioByStudioId)throws SQLException;
    public void setAnimeTypesByAnimeTypeId(TypesEntity animeTypesByAnimeTypeId)throws SQLException;
    public void setYearProductionByYearProductionId(YearProductionEntity yearProductionByYearProductionId)throws SQLException;
    public void setConnectionsesById(ConnectionsEntity connectionsesById)throws SQLException;
    public void setScreenshotsesById(ScreenshotsEntity screenshotsesById)throws SQLException;

    public AnimesEntity getAnimesByID(Long getAnimesById) throws SQLException;


}