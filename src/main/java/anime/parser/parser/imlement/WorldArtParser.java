package anime.parser.parser.imlement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldArtParser  {

    private Document mainDoc;
    private Integer lastDocId = 0;

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


    public static String parseTitle(Document doc) {
        return doc.select("meta[name=description]").get(0).attr("content");
    }

    public static List<String> parseScreenshots(Document doc) throws IOException {

        Element description = doc.select("tbody").get(10);
        Document doc2 = description.ownerDocument();
        Elements allImages = doc2.select("img[src~=(?i)\\.(jpe?g)]");
        List<String> animeLinks = new ArrayList<>();

        for (Element image : allImages) {
            String link = image.attr("src");
            link = link.replaceAll("optimize_b", "optimize_d");
            animeLinks.add("http://www.world-art.ru/animation/" + link);
        }

        return animeLinks;
    }

    public static List<String> parseOtherTitle(Document doc) {

        Element element = doc.select("font[color=#990000]").first().parent().parent().parent();

        String other_titles = element.toString().replaceAll("<br>", "�");
        other_titles = Jsoup.parse(other_titles).text();
        String[] allTitles = other_titles.split("�");

        return Arrays.asList(Arrays.copyOfRange(allTitles, 1, allTitles.length));
    }

    public static String parseReview(Document doc) throws IOException {

        Elements elements = doc.getElementsByClass("review");
        elements = elements.select("p[align=justify]");

        String resualt = "";

        if (elements.size() > 1) {
            resualt = elements.first().text();
        }

        return resualt;
    }

    public static String[] parseInfo(Document doc) throws IOException {
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

   /* public static List<AnimeConnection> parseConnections(Document doc) {

        Elements elements = doc.getElementsByClass("estimation");
        elements = elements.select("a[href^=http://www.world-art.ru/animation/animation.php]");
        List<AnimeConnection> resualt = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            AnimeConnection temp_connection = new AnimeConnection();

            String id = elements.get(i).attr("href");
            id = id.substring(id.indexOf("id=") + 3);

            temp_connection.setId(Integer.parseInt(id));
            temp_connection.setText(elements.get(i).parent().ownText().substring(2));
            resualt.add(temp_connection);
        }

        return resualt;
    }*/

    public static void parseLinks(Document doc) {
        Elements elementsByClass = doc.select("noindex");
        elementsByClass = elementsByClass.select("a[target=_blank]");

        for (Element element : elementsByClass) {
            if ("AniDB".equals(element.text()))
                System.out.println("AniDB: " + element.attr("href"));
            else if ("MyAnimeList".equals(element.text()))
                System.out.println("MyAnimeList: " + element.attr("href"));
        }
    }

    public static String parseTitleImg(Document doc) {

        Element element = doc.select("img[src^=http://www.world-art.ru/animation/img]").first();

        if (element != null) {
            return element.attr("src");
        }

        return "";
    }
}
