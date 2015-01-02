package anime.parser.parser;

import anime.parser.parser.enums.AnimeGenres;
import anime.parser.parser.enums.AnimeTypes;
import anime.parser.parser.struct.AnimeConnection;
import anime.parser.parser.struct.AnimeResources;

import java.util.List;

import java.sql.Date;

public interface AnimeInfoParser {

    public String getMainImgById(int animeId);
    public String getMainTitleById(int animeId);
    public AnimeTypes getTypeById(int animeId);
    public List<AnimeGenres> getGenresById(int animeId);
    public String getReviewById(int animeId);
    public List<String> getScreenshotsById(int animeId);
    public List<AnimeResources> getResourcesById(int animeId);
    public List<AnimeConnection> getConnectionsById(int animeId);
    public double getAverageById(int animeId);
    public int getVotedById(int animeId);
    public int getRancedById(int animeId);
    public int getStudioIdById(int animeId);
    public int getDirectedIdById(int animeId);
    public Date getYearStartById(int animeId);
    public Date getYearEndById(int animeId);
    public String getTypeInfoById(int animeId);

}
