package anime.parser.general;

import anime.parser.saveDbInfo.SaveDBInfo;
import anime.parser.utill.HibernateUtil;

public class App {

    public static void main(String[] args) throws Exception {


        SaveDBInfo saver;

        for (int i = 310; i < 311; i++) {
            int animeId = i;

            saver = new SaveDBInfo();

            try {
                saver.saveAnimeToDb(animeId);
                System.out.println("Аниме с id: " + animeId + " успешно сохранено в базу");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println();
            } catch (Exception e) {
                System.err.println("Не удалось сохранить аниме с id:" + animeId);
                e.printStackTrace();
                HibernateUtil.closeSession();
                return;
            }
        }
        HibernateUtil.closeSession();

    }
}
