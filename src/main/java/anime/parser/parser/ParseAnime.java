package anime.parser.parser;

import anime.parser.domain.*;

import java.util.List;

public interface ParseAnime {

    public List<AnimeGenreEntity> getParseAnimeInfoById(Integer animeId);
    public List<AnimeGenreEntity> getParseAnimeGenresById(Integer animeId);
    public List<AnimeResourcesEntity> animeResourcesesById(Integer animeId);
    public DirectedEntity directedByDirectedId(Integer animeId);
    public SecondNameEntity secondNameByOtherTitleId(Integer animeId);
    public StudioEntity studioByStudioId(Integer animeId);
    public AnimeTypesEntity animeTypesByAnimeTypeId(Integer animeId);
    public YearProductionEntity yearProductionByYearProductionId(Integer animeId);
    public List<ConnectionsEntity> connectionsesById(Integer animeId);
    public List<ScreenshotsEntity> screenshotsesById(Integer animeId);

}
