package anime.parser.parser.imlement;

import anime.parser.general.Factory;
import anime.parser.parser.DirectedParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class WorldArtDirectedParserImpl implements DirectedParser {

    private Document directionDoc;
    private Integer lastDocId = 0;

    @Override
    public String getDirectedNameById(int directedId) throws Exception{
        String resualt;
        Document directedDoc = getDirectedDoc(directedId);

        resualt = parseName(directedDoc);

        return resualt;
    }

    @Override
    public String getDirectedResourcesById(int directedId) throws Exception{
        String resualt;
        Document directedDoc = getDirectedDoc(directedId);

        resualt = parseResources(directedDoc);

        return resualt;
    }


    //Логика парсера
    private String parseName(Document doc) throws Exception {
        return encodingToUtf(doc.title());
    }

    private String parseResources(Document doc) throws Exception {

        Elements elements = doc.getElementsByClass("review");

        for (Element elements1 :  elements.select("a")){

            if ("Википедия".equals(elements1.text())) return elements1.attr("href");
            if ("Wikipedia".equals(elements1.text())) return elements1.attr("href");
            if ("AniDB".equals(elements1.text())) return elements1.attr("href");
            if ("MyAnimeList".equals(elements1.text())) return elements1.attr("href");

        }
        return "";
    }

    private Document getDirectedDoc(Integer directedId) throws Exception {

        if (lastDocId.equals(directedId) ) {
            return directionDoc;
        } else {
            IOException ex = null;
            for (int i = 0; i < 5; i++) {
                try {
                    directionDoc = Jsoup.connect("http://www.world-art.ru/people.php?id=" + directedId.toString()).get();
                    lastDocId = directedId;
                    return directionDoc;
                } catch (IOException e) {
                    System.err.println("Не удалось закачать страницу рижиссёра, id: " + directedId);
                    System.out.println("Повторяю попытку ...");
                    ex = e;
                }
            }
            throw ex;
        }
    }

    private String encodingToUtf(String stringInCi1215) throws UnsupportedEncodingException {

        return new String(stringInCi1215.getBytes("windows-1251"), "UTF-8");
    }
}
