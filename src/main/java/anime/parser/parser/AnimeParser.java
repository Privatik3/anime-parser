package anime.parser.parser;

import anime.parser.domain.*;

import java.util.List;

public interface AnimeParser {

    public AnimeInfo getParseAnimeInfoById(Integer animeId);
    public List<AnimeGenreEntity> getParseAnimeGenresById(Integer animeId);
    public List<AnimeResourcesEntity> getAnimeResourcesesById(Integer animeId);
    public DirectedEntity getDirectedByDirectedId(Integer animeId);
    public SecondNameEntity getSecondNameByOtherTitleId(Integer animeId);
    public StudioEntity getStudioByStudioId(Integer animeId);
    public AnimeTypesEntity getAnimeTypesByAnimeTypeId(Integer animeId);
    public YearProductionEntity getYearProductionByYearProductionId(Integer animeId);
    public List<ConnectionsEntity> getConnectionsesById(Integer animeId);
    public List<ScreenshotsEntity> getScreenshotsesById(Integer animeId);

}
