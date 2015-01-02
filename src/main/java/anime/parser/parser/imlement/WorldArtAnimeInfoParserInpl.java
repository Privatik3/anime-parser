package anime.parser.parser.imlement;

import anime.parser.parser.AnimeInfoParser;
import anime.parser.parser.enums.AnimeGenres;
import anime.parser.parser.enums.AnimeTypes;
import anime.parser.parser.struct.AnimeConnection;
import anime.parser.parser.struct.AnimeResources;

import java.sql.Date;
import java.util.List;

public class WorldArtAnimeInfoParserInpl implements AnimeInfoParser {

    @Override
    public String getMainImgById(int animeId) {
        return null;
    }

    @Override
    public String getMainTitleById(int animeId) {
        return null;
    }

    @Override
    public AnimeTypes getTypeById(int animeId) {
        return null;
    }

    @Override
    public List<AnimeGenres> getGenresById(int animeId) {
        return null;
    }

    @Override
    public String getReviewById(int animeId) {
        return null;
    }

    @Override
    public List<String> getScreenshotsById(int animeId) {
        return null;
    }

    @Override
    public List<AnimeResources> getResourcesById(int animeId) {
        return null;
    }

    @Override
    public List<AnimeConnection> getConnectionsById(int animeId) {
        return null;
    }

    @Override
    public double getAverageById(int animeId) {
        return 0;
    }

    @Override
    public int getVotedById(int animeId) {
        return 0;
    }

    @Override
    public int getRancedById(int animeId) {
        return 0;
    }

    @Override
    public int getStudioIdById(int animeId) {
        return 0;
    }

    @Override
    public int getDirectedIdById(int animeId) {
        return 0;
    }

    @Override
    public Date getYearStartById(int animeId) {
        return null;
    }

    @Override
    public Date getYearEndById(int animeId) {
        return null;
    }

    @Override
    public String getTypeInfoById(int animeId) {
        return null;
    }
}
