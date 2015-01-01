package anime.parser.parser;

import anime.parser.domain.*;

import java.util.List;

public interface AnimeParser {

    public AnimeInfo getParseAnimeInfoById(Integer animeId);
    public DirectedEntity getDirectedByDirectedId(Integer animeId);
    public StudioEntity getStudioByStudioId(Integer animeId);
    public YearProductionEntity getYearProductionByYearProductionId(Integer animeId);


}
