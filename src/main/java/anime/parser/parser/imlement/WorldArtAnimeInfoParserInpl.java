package anime.parser.parser.imlement;

import anime.parser.parser.AnimeInfoParser;
import anime.parser.parser.enums.AnimeGenres;
import anime.parser.parser.enums.AnimeTypes;
import anime.parser.parser.enums.ResoursesName;
import anime.parser.parser.struct.AnimeConnection;
import anime.parser.parser.struct.AnimeResources;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldArtAnimeInfoParserInpl implements AnimeInfoParser {

    private Document mainDoc;
    private Document screenshotsDoc;
    private Integer lastDocId = 0;
    private Integer lastScreenshotsId = 0;

    @Override
    public String getMainImgById(int animeId) throws Exception {
        String resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseMainImg(animeDoc);

        return resualt;
    }

    @Override
    public String getMainTitleById(int animeId) throws Exception {
        String resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseTitle(animeDoc);

        return resualt;
    }

    @Override
    public AnimeTypes getTypeById(int animeId) throws Exception {
        AnimeTypes resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseType(animeDoc);

        return resualt;
    }

    @Override
    public List<AnimeGenres> getGenresById(int animeId) throws Exception {
        List<AnimeGenres> resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseGenre(animeDoc);

        return resualt;
    }

    @Override
    public List<String> getOtherTitleById(int animeId) throws Exception {
        List<String> resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseOtherTitle(animeDoc);

        return resualt;
    }

    @Override
    public String getReviewById(int animeId) throws Exception {
        String resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseReview(animeDoc);

        return resualt;
    }

    @Override
    public List<String> getScreenshotsById(int animeId) throws Exception {
        List<String> resualt;
        Document screenshotDoc = getScreenshotDoc(animeId);

        resualt = parseScreenshots(screenshotDoc);

        return resualt;
    }

    @Override
    public List<AnimeResources> getResourcesById(int animeId) throws Exception {
        List<AnimeResources> resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseResources(animeDoc);

        return resualt;
    }

    @Override
    public List<AnimeConnection> getConnectionsById(int animeId) throws Exception {
        List<AnimeConnection> resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseConnections(animeDoc);

        return resualt;
    }

    @Override
    public double getAverageById(int animeId) throws Exception {
        double resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseAverage(animeDoc);

        return resualt;
    }

    @Override
    public int getVotedById(int animeId) throws Exception {
        int resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseVoted(animeDoc);

        return resualt;
    }

    @Override
    public int getRancedById(int animeId) throws Exception {
        int resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseRanced(animeDoc);

        return resualt;
    }

    @Override
    public int getStudioIdById(int animeId) throws Exception {
        int resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseStudioId(animeDoc);

        return resualt;
    }

    @Override
    public int getDirectedIdById(int animeId) throws Exception {
        int resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseDirectedId(animeDoc);

        return resualt;
    }

    @Override
    public Date getYearStartById(int animeId) throws Exception {
        Date resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseYearStart(animeDoc);

        return resualt;
    }

    @Override
    public Date getYearEndById(int animeId) throws Exception {
        Date resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseYearEnd(animeDoc);

        return resualt;
    }

    @Override
    public String getTypeInfoById(int animeId) throws Exception {
        String resualt;
        Document animeDoc = getAnimeDoc(animeId);

        resualt = parseTypeInfo(animeDoc);

        return resualt;
    }


    //Вспомагательная логика
    private Document getAnimeDoc(Integer animeId) throws Exception {

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
                    ex = e;
                }
            }
            throw ex;
        }
    }

    private Document getScreenshotDoc(Integer screenshotId) throws Exception {

        if (lastScreenshotsId.equals(screenshotId) ) {
            return screenshotsDoc;
        } else {
            IOException ex = null;
            for (int i = 0; i < 5; i++) {
                try {
                    screenshotsDoc = Jsoup.connect("http://www.world-art.ru/animation/animation_photos.php?id=" + screenshotId.toString()).get();
                    lastScreenshotsId = screenshotId;
                    return screenshotsDoc;
                } catch (IOException e) {
                    System.err.println("Не удалось закачать страницу скриншотов, id: " + screenshotId);
                    System.out.println("Повторяю попытку ...");
                    ex = e;
                }
            }
            throw ex;
        }
    }

    //Логика парсера
    private String parseTitle(Document doc) throws Exception {
        return doc.select("meta[name=description]").get(0).attr("content");
    }

    private String parseMainImg(Document doc) throws Exception {

        Element element = doc.select("img[src^=http://www.world-art.ru/animation/img]").first();

        if (element != null)
            return element.attr("src");

        return "";


    }

    private String parseTypeInfo(Document doc) throws Exception {

        String[] info = parseInfo(doc);

        return info[0].substring(5);
    }

    private AnimeTypes parseType(Document doc) throws Exception {

        String[] info = parseInfo(doc);

        String typeInfo = info[0].substring(5);

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

    private String parseReview(Document doc) throws Exception {

        Elements elements = doc.getElementsByClass("review");
        elements = elements.select("p[align=justify]");

        String resualt = "";

        if (elements.size() > 1) {
            resualt = elements.first().text();
        }

        return resualt;
    }

    private List<AnimeGenres> parseGenre(Document doc) throws Exception {

        List<AnimeGenres> resualt = new ArrayList<>();
        String[] info = parseInfo(doc);

        String genreText = info[6].substring(6);

        if (genreText.contains("боевые искусства"))
            resualt.add(AnimeGenres.Martial_Arts);
        if (genreText.contains("война"))
            resualt.add(AnimeGenres.Military);
        if (genreText.contains("детектив"))
            resualt.add(AnimeGenres.Detective);
        if (genreText.contains("драма"))
            resualt.add(AnimeGenres.Drama);
        if (genreText.contains("кодомо"))
            resualt.add(AnimeGenres.Children);
        if (genreText.contains("комедия"))
            resualt.add(AnimeGenres.Comedy);
        if (genreText.contains("махо-сёдзё"))
            resualt.add(AnimeGenres.Magical_girl);
        if (genreText.contains("меха"))
            resualt.add(AnimeGenres.Mecha);
        if (genreText.contains("мистика"))
            resualt.add(AnimeGenres.Supernatural);
        if (genreText.contains("музыкальный"))
            resualt.add(AnimeGenres.Music);
        if (genreText.contains("образовательный"))
            resualt.add(AnimeGenres.Educational);
        if (genreText.contains("пародия"))
            resualt.add(AnimeGenres.Parody);
        if (genreText.contains("повседневность"))
            resualt.add(AnimeGenres.Slice_of_Life);
        if (genreText.contains("приключения"))
            resualt.add(AnimeGenres.Adventure);
        if (genreText.contains("романтика"))
            resualt.add(AnimeGenres.Romance);
        if (genreText.contains("самурайский боевик"))
            resualt.add(AnimeGenres.Samurai);
        if (genreText.contains("сёдзё"))
            resualt.add(AnimeGenres.Shoujo);
        if (genreText.contains("сёдзё-ай"))
            resualt.add(AnimeGenres.Shoujo_Ai);
        if (genreText.contains("сёнэн"))
            resualt.add(AnimeGenres.Shounen);
        if (genreText.contains("сёнэн-ай"))
            resualt.add(AnimeGenres.Shounen_Ai);
        if (genreText.contains("сказка"))
            resualt.add(AnimeGenres.Story);
        if (genreText.contains("спорт"))
            resualt.add(AnimeGenres.Sports);
        if (genreText.contains("триллер"))
            resualt.add(AnimeGenres.Thriller);
        if (genreText.contains("школа"))
            resualt.add(AnimeGenres.School);
        if (genreText.contains("фантастика"))
            resualt.add(AnimeGenres.Fiction);
        if (genreText.contains("фэнтези"))
            resualt.add(AnimeGenres.Fantasy);
        if (genreText.contains("эротика"))
            resualt.add(AnimeGenres.Erotica);
        if (genreText.contains("этти"))
            resualt.add(AnimeGenres.Ecchi);
        if (genreText.contains("ужасы"))
            resualt.add(AnimeGenres.Horror);
        if (genreText.contains("хентай"))
            resualt.add(AnimeGenres.Hentai);
        if (genreText.contains("юри"))
            resualt.add(AnimeGenres.Yuri);
        if (genreText.contains("яой"))
            resualt.add(AnimeGenres.Yaoi);

        if (resualt.isEmpty())
            throw new IOException("Не удалось спарсить жанр");
        else
            return resualt;
    }

    private String[] parseInfo(Document doc) throws Exception {
        Elements loginform = doc.getElementsByClass("estimation");
        Element element = loginform.select("a[href=http://www.world-art.ru/country.php?id=2]").first().parent();

        String all_info = element.toString().replaceAll("<br>", "@");
        all_info = Jsoup.parse(all_info).text();

        String[] all_titles = all_info.split("@");
        String[] resualt = new String[7];

        for (String s : all_titles) {
            if (s.contains("Тип:")) {
                resualt[0] = s;
            } else if (s.contains("Режиссёр:")) {
                resualt[1] = s;
            } else if (s.contains("Выпуск:") || s.contains("Премьера:")) {
                resualt[2] = s;
            } else if (s.contains("Средний балл:")) {
                resualt[3] = s;
            } else if (s.contains("Место в рейтинге:")) {
                resualt[4] = s;
            } else if (s.contains("Проголосовало:")) {
                resualt[5] = s;
            } else if (s.contains("Жанр:")) {
                resualt[6] = s;
            }
        }

        return resualt;
    }

    private double parseAverage(Document doc) throws Exception {
        String[] info = parseInfo(doc);

        if (info[3] != null)
            return Double.parseDouble(info[3].substring(14, info[3].length() - 6));

        return 0;
    }

    private int parseRanced(Document doc) throws Exception {
        String[] info = parseInfo(doc);

        if (info[4] != null)
            return Integer.parseInt(info[4].substring(18, info[4].indexOf("из") - 1));

        return 0;
    }

    private int parseVoted(Document doc) throws Exception {
        String[] info = parseInfo(doc);

        if (info[5] != null)
            return Integer.parseInt(info[5].substring(15, info[5].length() - 17));

        return 0;
    }

    private Date parseYearStart(Document doc) throws Exception {
        java.util.Date dataText;
        String[] info = parseInfo(doc);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyyy");

        dataText = dateFormat.parse(info[2].substring(10, 20).replace("??", "01"));
        dateFormat.applyPattern("yyyy-mm-dd");
        return Date.valueOf(dateFormat.format(dataText));
    }

    private Date parseYearEnd(Document doc) throws Exception {
        java.util.Date dataText;
        String[] info = parseInfo(doc);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyyy");

        if (info[2].contains("Выпуск:") && info[2].length() > 20) {
            dataText = dateFormat.parse(info[2].substring(24).replace("??", "01"));
            dateFormat.applyPattern("yyyy-mm-dd");
            return Date.valueOf(dateFormat.format(dataText));
        } else {
            return Date.valueOf("1000-01-01");
        }
    }

    private List<String> parseScreenshots(Document doc) throws Exception {

        Element description = doc.select("tbody").get(10);
        Document doc2 = description.ownerDocument();
        Elements allImages = doc2.select("img[src~=(?i)\\.(jpe?g)]");
        List<String> screenshotsUrl = new ArrayList<>();

        for (Element image : allImages) {
            String link = image.attr("src");
            link = link.replaceAll("optimize_b", "optimize_d");
            screenshotsUrl.add("http://www.world-art.ru/animation/" + link);
        }

        return screenshotsUrl;
    }

    private List<AnimeConnection> parseConnections(Document doc) throws Exception {

        Elements elements = doc.getElementsByClass("estimation");
        elements = elements.select("a[href^=http://www.world-art.ru/animation/animation.php]");
        List<AnimeConnection> resualt = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            AnimeConnection temp_connection = new AnimeConnection();

            String id = elements.get(i).attr("href");
            id = id.substring(id.indexOf("id=") + 3);

            temp_connection.setConnectionId(Integer.parseInt(id));
            temp_connection.setInfo(elements.get(i).parent().ownText().substring(2));
            resualt.add(temp_connection);
        }

        return resualt;
    }

    public List<AnimeResources> parseResources(Document doc) {

        List<AnimeResources> resualt = new ArrayList<>();
        Elements elementsByClass = doc.select("noindex");
        elementsByClass = elementsByClass.select("a[target=_blank]");

        for (Element element : elementsByClass) {
            if ("AniDB".equals(element.text())) {
                AnimeResources aniDb = new AnimeResources();
                aniDb.setName(ResoursesName.AniDB);
                aniDb.setUrl(element.attr("href"));
                resualt.add(aniDb);
            } else if ("MyAnimeList".equals(element.text())) {
                AnimeResources myAnimeList = new AnimeResources();
                myAnimeList.setName(ResoursesName.MyAnimeList);
                myAnimeList.setUrl(element.attr("href"));
                resualt.add(myAnimeList);
            } else if ("ANN".equals(element.text())) {
                AnimeResources ann = new AnimeResources();
                ann.setName(ResoursesName.ANN);
                ann.setUrl(element.attr("href"));
                resualt.add(ann);
            } else if ("Википедия".equals(element.text())) {
                AnimeResources wikipedia = new AnimeResources();
                wikipedia.setName(ResoursesName.Wikipedia);
                wikipedia.setUrl(element.attr("href"));
                resualt.add(wikipedia);
            }
        }

        return resualt;
    }

    public List<String> parseOtherTitle(Document doc) throws UnsupportedEncodingException {
        List<String> resualt;
        Element element = doc.select("font[color=#990000]").first().parent().parent().parent();

        String other_titles = element.toString().replaceAll("<br>", "@");
        other_titles = Jsoup.parse(other_titles).text();
        String[] allTitles = other_titles.split("@");
        resualt = Arrays.asList(Arrays.copyOfRange(allTitles, 1, allTitles.length));

        for (int i = 0; i < resualt.size(); i++) {
            resualt.set(i, resualt.get(i));
        }

        return resualt;
    }

    private int parseStudioId(Document doc) {
        String studioId;
        try {
            String studioUrl = doc.select("a[href^=http://www.world-art.ru/company.php?id=]").first().attr("href");
            studioId = studioUrl.substring(studioUrl.indexOf("id=") + 3);
        } catch (NullPointerException e) {
            return 0;
        }

        return Integer.parseInt(studioId);
    }

    private int parseDirectedId(Document doc) throws Exception {
        Elements loginform = doc.getElementsByClass("estimation");
        Elements element = loginform.select("a[href=http://www.world-art.ru/country.php?id=2]").first().parent().select("a[href^=http://www.world-art.ru/people.php?id=]");

        String directionUrl = element.attr("href");
        if (!directionUrl.equals("")) {
            return Integer.parseInt(directionUrl.substring(directionUrl.indexOf("id=") + 3));
        } else {
            return 0;
        }
    }
}
