package anime.parser.parser;

import anime.parser.parser.enums.AnimeGenres;
import anime.parser.parser.enums.AnimeTypes;
import anime.parser.parser.struct.AnimeConnection;
import anime.parser.parser.struct.AnimeResources;

import java.io.IOException;
import java.util.List;

import java.sql.Date;

public interface AnimeInfoParser {

    public String getMainImgById(int animeId) throws IOException;
    public String getMainTitleById(int animeId) throws IOException;
    public AnimeTypes getTypeById(int animeId) throws IOException;
    public List<AnimeGenres> getGenresById(int animeId) throws IOException;
    public String getReviewById(int animeId) throws IOException;
    public List<String> getScreenshotsById(int animeId) throws IOException;
    public List<AnimeResources> getResourcesById(int animeId) throws IOException;
    public List<AnimeConnection> getConnectionsById(int animeId) throws IOException;
    public double getAverageById(int animeId) throws IOException;
    public int getVotedById(int animeId) throws IOException;
    public int getRancedById(int animeId) throws IOException;
    public int getStudioIdById(int animeId) throws IOException;
    public int getDirectedIdById(int animeId) throws IOException;
    public Date getYearStartById(int animeId) throws IOException;
    public Date getYearEndById(int animeId) throws IOException;
    public String getTypeInfoById(int animeId) throws IOException;

}
