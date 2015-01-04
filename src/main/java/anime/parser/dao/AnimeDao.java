package anime.parser.dao;

import anime.parser.domain.*;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface AnimeDao {

    // методы для сохранения данных

    public void setAnimeInfoById(AnimesEntity animeInfoById, Session session) throws SQLException;
    public void setDirectedByDirectedId(DirectedEntity directedByDirectedId, Session session) throws SQLException;
    public void setStudioByStudioId(StudioEntity studioByStudioId, Session session) throws SQLException;
    public void setYearProductionByYearProductionId(YearProductionEntity yearProductionByYearProductionId, Session session) throws SQLException;
    public void setAllScreenshotses(List<ScreenshotsEntity> screenshotses, Session session) throws SQLException;
    public void setAllOtherTitles(List<OtherTitleEntity> otherTitles, Session session) throws SQLException;
    public void setAllAnimeResources(List<AnimeResourcesEntity> animeResources, Session session) throws SQLException;
    public void setAllConnections(List<ConnectionsEntity> connections, Session session) throws SQLException;
    public void setAllGenres(List<AnimeGenreEntity> genres, Session session) throws SQLException;

    // методы для загрузки данных
    public DirectedEntity getDirectedEntityById(Integer getDirectedEntityById, Session session) throws SQLException;
    public GenresEntity getGenresEntityByID(Integer getGenresEntityById, Session session) throws SQLException;
    public ResourcesNameEntity getResourcesNameEntityById(Integer getResourcesNameById, Session session) throws SQLException;
    public StudioEntity getStudioEntityById(Integer getStudioEntityById, Session session) throws SQLException;
    public TypesEntity getTypesEntityById(Integer getTypesEntityById, Session session) throws SQLException;


}