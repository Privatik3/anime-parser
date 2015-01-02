package anime.parser.parser;

import anime.parser.parser.enums.AnimeGenres;
import anime.parser.parser.enums.AnimeTypes;
import anime.parser.parser.struct.AnimeConnection;
import anime.parser.parser.struct.AnimeResources;

import java.io.IOException;
import java.util.List;

import java.sql.Date;

public interface AnimeInfoParser {

    public String getMainImgById(int animeId) throws Exception;
    public String getMainTitleById(int animeId) throws Exception;
    public AnimeTypes getTypeById(int animeId) throws Exception;
    public List<AnimeGenres> getGenresById(int animeId) throws Exception;
    public List<String> getOtherTitleById(int animeId) throws Exception;
    public String getReviewById(int animeId) throws Exception;
    public List<String> getScreenshotsById(int animeId) throws Exception;
    public List<AnimeResources> getResourcesById(int animeId) throws Exception;
    public List<AnimeConnection> getConnectionsById(int animeId) throws Exception;
    public double getAverageById(int animeId) throws Exception;
    public int getVotedById(int animeId) throws Exception;
    public int getRancedById(int animeId) throws Exception;
    public int getStudioIdById(int animeId) throws Exception;
    public int getDirectedIdById(int animeId) throws Exception;
    public Date getYearStartById(int animeId) throws Exception;
    public Date getYearEndById(int animeId) throws Exception;
    public String getTypeInfoById(int animeId) throws Exception;

}
