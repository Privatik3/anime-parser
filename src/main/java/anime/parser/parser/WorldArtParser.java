package anime.parser.parser;

import anime.parser.domain.*;

import java.util.ArrayList;
import java.util.List;

public class WorldArtParser implements AnimeParser {



    @Override
    public AnimesEntity getParseAnimeInfoById(Integer animeId) {
        return null;
    }

    @Override
    public DirectedEntity getDirectedByDirectedId(Integer animeId) {
        return null;
    }

    @Override
    public StudioEntity getStudioByStudioId(Integer animeId) {
        return null;
    }

    @Override
    public YearProductionEntity getYearProductionByYearProductionId(Integer animeId) {
        return null;
    }




    /*public static String parseTitle(Document doc) {
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

        String all_info = element.toString().replaceAll("<br>", "�");
        all_info = Jsoup.parse(all_info).text();

        String[] all_titles = all_info.split("�");
        String[] resualt = new String[7];

        for (String s : all_titles) {
            if (s.contains("������������:")) {
                resualt[0] = s;
            } else if (s.contains("����:")) {
                resualt[1] = s;
            } else if (s.contains("���:")) {
                resualt[2] = s;
            } else if (s.contains("������:") || s.contains("��������:")) {
                resualt[3] = s;
            } else if (s.contains("������� ����:")) {
                resualt[4] = s;
            } else if (s.contains("����� � ��������:")) {
                resualt[5] = s;
            } else if (s.contains("�������������:")) {
                resualt[6] = s;
            }
        }

        return resualt;
    }

    public static List<AnimeConnection> parseConnections(Document doc) {

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
    }

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
    }*/
}
