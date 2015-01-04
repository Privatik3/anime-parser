package anime.parser.general;

import anime.parser.saveDbInfo.SaveDBInfo;
import anime.parser.utill.HibernateUtil;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) throws Exception {


        SaveDBInfo saver;
        Session session;

        for (int i = 202; i < 500; i++) {
            int animeId = i;

            saver = new SaveDBInfo();
            session = HibernateUtil.getSessionFactory().openSession();

            try {
                saver.saveAnimeToDb(animeId, session);
                System.out.println("Аниме с id: " + animeId + " успешно сохранено в базу");
            } catch (Exception e) {
                System.err.println("Не удалось сохранить аниме с id:" + animeId);
                e.printStackTrace();
            }

            session.close();
            //HibernateUtil.sessionFactoryClean();
        }
        HibernateUtil.closeSession();
    }
}
