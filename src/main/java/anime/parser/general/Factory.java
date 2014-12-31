package anime.parser.general;


import anime.parser.dao.AnimeDao;
import anime.parser.dao.implement.AnimeDaoImpl;

public class Factory {

    public static Factory instance = new Factory();
    public AnimeDao animeDao;

    private Factory() {}

    public static Factory getInstance() {
        return Factory.instance;
    }

    public AnimeDao getAnimeDao() {
        if (animeDao == null)
            return animeDao = new AnimeDaoImpl();
        return animeDao;
    }
}
