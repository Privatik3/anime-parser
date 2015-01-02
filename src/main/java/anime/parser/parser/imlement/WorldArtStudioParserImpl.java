package anime.parser.parser.imlement;

import anime.parser.general.Factory;
import anime.parser.parser.DirectedParser;
import anime.parser.parser.StudioParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.sql.Date;

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
                    System.err.println("Не удалось закачать страницу id: " + studioId);
                    System.out.println("Повторяю попытку ...");
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
        return null;
    }

    private String parseLogo(Document doc) {
        return null;
    }

    private Date parseDate(Document doc) {



        return null;
    }

    private String parseName(Document doc) {
        return doc.title();
    }
}
