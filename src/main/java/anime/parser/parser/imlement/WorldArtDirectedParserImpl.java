package anime.parser.parser.imlement;

import anime.parser.general.Factory;
import anime.parser.parser.DirectedParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WorldArtDirectedParserImpl implements DirectedParser {

    private Document directionDoc;
    private Integer lastDocId = 0;

    public static void main(String[] args) throws Exception {
        int directedId = 1549;
        DirectedParser parser = Factory.getInstance().getDirectedParser();

        System.out.println("Name: " + parser.getDirectedNameById(directedId));
        System.out.println("Resources: " + parser.getDirectedResourcesById(directedId));
    }

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
        String resualt;



        return resualt;
    }

    private String parseResources(Document doc) throws Exception {
        String resualt;




        return resualt;
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
                    System.err.println("Не удалось закачать страницу id: " + directedId);
                    System.out.println("Повторяю попытку ...");
                    ex = e;
                }
            }
            throw ex;
        }
    }
}
