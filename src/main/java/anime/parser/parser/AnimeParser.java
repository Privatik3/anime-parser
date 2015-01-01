package anime.parser.parser;

import anime.parser.domain.*;

import java.io.IOException;
import java.util.List;

public interface AnimeParser {

    public AnimesEntity getParseAnimeInfoById(Integer animeId) throws IOException;
    public DirectedEntity getDirectedByDirectedId(Integer animeId);
    public StudioEntity getStudioByStudioId(Integer animeId);
    public YearProductionEntity getYearProductionByYearProductionId(Integer animeId);


}
