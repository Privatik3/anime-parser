package anime.parser.general;


import anime.parser.dao.AnimeDao;
import anime.parser.dao.implement.AnimeDaoImpl;
import anime.parser.parser.AnimeInfoParser;
import anime.parser.parser.DirectedParser;
import anime.parser.parser.StudioParser;
import anime.parser.parser.imlement.WorldArtAnimeInfoParserInpl;
import anime.parser.parser.imlement.WorldArtDirectedParserImpl;
import anime.parser.parser.imlement.WorldArtParser;
import anime.parser.parser.imlement.WorldArtStudioParserImpl;

public class Factory {

    public static Factory instance = new Factory();
    private AnimeDao animeDao;
    private AnimeInfoParser animeInfoParser;
    private DirectedParser directedParser;
    private StudioParser studioParser;

    private Factory() {}

    public static Factory getInstance() {
        return Factory.instance;
    }

    public AnimeDao getAnimeDao() {
        if (animeDao == null)
            return animeDao = new AnimeDaoImpl();
        return animeDao;
    }

    public AnimeInfoParser getAnimeParser() {
        if (animeInfoParser == null)
            return animeInfoParser = new WorldArtAnimeInfoParserInpl();
        return animeInfoParser;
    }

    public DirectedParser getDirectedParser() {
        if (directedParser == null)
            return directedParser = new WorldArtDirectedParserImpl();
        return directedParser;
    }

    public StudioParser getStudioParser() {
        if (studioParser == null)
            return studioParser = new WorldArtStudioParserImpl();
        return studioParser;
    }
}
