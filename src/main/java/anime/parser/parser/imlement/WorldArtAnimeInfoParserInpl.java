package anime.parser.parser.imlement;

import anime.parser.parser.AnimeInfoParser;
import anime.parser.parser.enums.AnimeGenres;
import anime.parser.parser.enums.AnimeTypes;
import anime.parser.parser.struct.AnimeConnection;
import anime.parser.parser.struct.AnimeResources;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class WorldArtAnimeInfoParserInpl implements AnimeInfoParser {

    private Document mainDoc;
    private Integer lastDocId = 0;

    @Override
    public String getMainImgById(int animeId) throws IOException {
        String resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseMainImg(animeDoc);

        return resualt;
    }

    @Override
    public String getMainTitleById(int animeId) throws IOException {
        String resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseTitle(animeDoc);

        return resualt;
    }

    @Override
    public AnimeTypes getTypeById(int animeId) throws IOException {
        AnimeTypes resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseType(animeDoc);

        return resualt;
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
    public String getTypeInfoById(int animeId) throws IOException {
        String resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseTypeInfo(animeDoc);

        return resualt;
    }


    //Логика парсера
    private String parseTitle(Document doc) {
        return doc.select("meta[name=description]").get(0).attr("content");
    }

    private String parseMainImg(Document doc) {

        Element element = doc.select("img[src^=http://www.world-art.ru/animation/img]").first();

        return element.attr("src");
    }

    private String parseTypeInfo(Document doc) throws IOException {

        String[] info = parseInfo(doc);

        return info[2].substring(5);
    }

    private AnimeTypes parseType(Document doc) throws IOException {

        String[] info = parseInfo(doc);

        String typeInfo = info[2].substring(5);

        if (typeInfo.contains("ТВ")) {
            return AnimeTypes.TV;
        } else if (typeInfo.contains("ТВ-спэшл")) {
            return AnimeTypes.TV_Special;
        } else if (typeInfo.contains("OVA")) {
            return AnimeTypes.OVA;
        } else if (typeInfo.contains("ONA")) {
            return AnimeTypes.ONA;
        } else if (typeInfo.contains("полнометражный фильм") || typeInfo.contains("короткометражный фильм")) {
            return AnimeTypes.Movie;
        } else if (typeInfo.contains("музыкальное видео")) {
            return AnimeTypes.Music_Video;
        } else if (typeInfo.contains("рекламный ролик") || typeInfo.contains("короткометражный клип")) {
            return AnimeTypes.Special;
        }

        throw new IOException("Не удалось спарсить тип аниме");
    }

    private String[] parseInfo(Document doc) throws IOException {
        Elements loginform = doc.getElementsByClass("estimation");
        Element element = loginform.select("a[href=http://www.world-art.ru/country.php?id=2]").first().parent();

        String all_info = element.toString().replaceAll("<br>", "@");
        all_info = Jsoup.parse(all_info).text();

        String[] all_titles = all_info.split("@");
        String[] resualt = new String[7];

        for (String s : all_titles) {
            if (s.contains("Тип:")) {
                resualt[1] = s;
            } else if (s.contains("Режиссёр:")) {
                resualt[2] = s;
            } else if (s.contains("Выпуск:") || s.contains("Премьера:")) {
                resualt[3] = s;
            } else if (s.contains("Средний балл:")) {
                resualt[4] = s;
            } else if (s.contains("Место в рейтинге:")) {
                resualt[5] = s;
            } else if (s.contains("Проголосовало:")) {
                resualt[6] = s;
            }
        }

        return resualt;
    }

    private Document getAnimeDoc(Integer animeId) throws IOException {

        if (lastDocId.equals(animeId) ) {
            return mainDoc;
        } else {
            IOException ex = null;
            for (int i = 0; i < 5; i++) {
                try {
                    mainDoc = Jsoup.connect("http://www.world-art.ru/animation/animation.php?id=" + animeId.toString()).get();
                    lastDocId = animeId;
                    return mainDoc;
                } catch (IOException e) {
                    System.err.println("Не удалось закачать страницу id: " + animeId);
                    System.out.println("Повторяю попытку ...");
                    ex = e;
                }
            }
            throw ex;
        }
    }
}
