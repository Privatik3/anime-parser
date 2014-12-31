package anime.parser.general;


import anime.parser.dao.AnimeDao;
import anime.parser.dao.implement.AnimeDaoImpl;
import anime.parser.parser.AnimeParser;
import anime.parser.parser.WorldArtParser;

public class Factory {

    public static Factory instance = new Factory();
    private AnimeDao animeDao;
    private AnimeParser animeParser;


    private Factory() {}

    public static Factory getInstance() {
        return Factory.instance;
    }

    public AnimeDao getAnimeDao() {
        if (animeDao == null)
            return animeDao = new AnimeDaoImpl();
        return animeDao;
    }

    public AnimeParser getAnimeParser() {
        if (animeParser == null)
            return animeParser = new WorldArtParser();
        return animeParser;
    }
}
