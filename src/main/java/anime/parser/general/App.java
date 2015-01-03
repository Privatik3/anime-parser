package anime.parser.general;

import anime.parser.saveDbInfo.SaveDBInfo;
import anime.parser.utill.HibernateUtil;

public class App {

    public static void main(String[] args) throws Exception {

        SaveDBInfo saver = new SaveDBInfo();
        int animeId = 310;

        try {
            saver.saveAnimeToDb(animeId);
            System.out.println("Аниме с id: " + animeId + " успешно сохранено в базу");
        } catch (Exception e) {
            System.err.println("Не удалось сохранить аниме с id:" + animeId);
            e.printStackTrace();
        }

        HibernateUtil.closeSession();
    }
}
