package anime.parser.general;

import anime.parser.domain.DirectedEntity;
import anime.parser.parser.AnimeInfoParser;
import anime.parser.saveDbInfo.SaveDBInfo;

import java.io.IOException;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws Exception {

        //SaveDBInfo saver = new SaveDBInfo();

        Factory factory = Factory.getInstance();

        String name = factory.getAnimeParser().getMainTitleById(500);
        DirectedEntity directedEntity = new DirectedEntity();
        directedEntity.setName(name);

        try {
            factory.getAnimeDao().setDirectedByDirectedId(directedEntity);
        } catch (Exception e) {
            System.err.println("Не удалось сохранить name");
            e.printStackTrace();
        }

        /*try {
            saver.saveAnimeToDb(animeId);
            System.out.println("Аниме с id: " + animeId + " успешно сохранено в базу");
        } catch (Exception e) {
            System.err.println("Не удалось сохранить аниме с id:" + animeId);
            e.printStackTrace();
        }*/
    }
}
