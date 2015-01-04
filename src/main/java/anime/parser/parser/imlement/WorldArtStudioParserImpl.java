package anime.parser.parser.imlement;

import anime.parser.parser.StudioParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class WorldArtStudioParserImpl implements StudioParser {

    private Document studioDoc;
    private Integer lastDocId = 0;

    private Document getStudioDoc(Integer studioId) throws Exception {

        if (lastDocId.equals(studioId) ) {
            return studioDoc;
        } else {
            IOException ex = null;
            for (int i = 0; i < 5; i++) {
                try {
                    studioDoc = Jsoup.connect("http://www.world-art.ru/company.php?id=" + studioId.toString()).get();
                    lastDocId = studioId;
                    return studioDoc;
                } catch (IOException e) {
                    System.err.println("Не удалось закачать страницу студии, id: " + studioId);
                    ex = e;
                }
            }
            throw ex;
        }
    }

    @Override
    public String getStudioNameById(int studioId) throws Exception {
        String resualt;
        Document studioDoc = getStudioDoc(studioId);

        resualt = parseName(studioDoc);

        return resualt;
    }

    @Override
    public Date getStudioDateById(int studioId) throws Exception {
        Date resualt;
        Document studioDoc = getStudioDoc(studioId);

        resualt = parseDate(studioDoc);

        return resualt;
    }

    @Override
    public String getStudioLogoById(int studioId) throws Exception {
        String resualt;
        Document studioDoc = getStudioDoc(studioId);

        resualt = parseLogo(studioDoc);

        return resualt;
    }

    @Override
    public String getStudioResourcesById(int studioId) throws Exception {
        String resualt;
        Document studioDoc = getStudioDoc(studioId);

        resualt = parseResuorces(studioDoc);

        return resualt;
    }


    //Логика парсера
    private String parseResuorces(Document doc) {
        Elements elements = doc.select("a");

        for (Element element :  elements.select("a")){

            if ("Википедия".equals(element.text())) return element.attr("href");
            if ("Wikipedia".equals(element.text())) return element.attr("href");
            if ("AniDB".equals(element.text())) return element.attr("href");
            if ("MyAnimeList".equals(element.text())) return element.attr("href");

        }

        return "";
    }

    private String parseLogo(Document doc) {
        Element description = doc.select("img").get(0);
        Document doc2 = description.ownerDocument();
        Elements allImages = doc2.select("img[src~=(?i)\\.(jpe?g)]");

        String link = allImages.attr("src");

        return link;
    }

    private Date parseDate(Document doc) throws Exception {

        Elements elements = doc.select("tbody");

        try {
            for (Element element : elements) {
                if (element.text().contains("Дата основания:")) {
                    String dataText = element.text();
                    String data = dataText.substring(dataText.indexOf("Дата основания:") + 16, dataText.indexOf(" г.")).replace("??", "01");

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyyy");

                    if (data.length() == 7) {
                        data = "01." + data;
                    } else if (data.length() == 4)
                        data = "01.01." + data;

                    java.util.Date date = dateFormat.parse(data);
                    dateFormat.applyPattern("yyyy-mm-dd");
                    String resualt = dateFormat.format(date);

                    return Date.valueOf(resualt);
                }
            }
            return Date.valueOf("1000-01-01");
        } catch (Exception e) {
            throw new Exception("Не удалось спарсить дату");
        }


    }

    private String parseName(Document doc) throws UnsupportedEncodingException {
        return doc.title();
    }
}
