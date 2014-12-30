package anime.parser;

import com.privatik.anime.Anime;
import com.privatik.database.SaverAnimes;
import com.privatik.parser.LogicParser;

import java.util.Random;

public class App {

    public static void main(String[] args) throws InterruptedException {

        SaverAnimes saver = new SaverAnimes();
        Random rad = new Random();
        for (int i = 1; i < 123; i++) {
            int id = 3077;//rad.nextInt(8100)
            Anime anime = LogicParser.parseAnime(Integer.toString(i));


            if (anime != null) {
                if (saver.saveAnime(anime)) {
                    System.out.println("����� id:" + i + " ��������� � ����");
                } else {
                    System.err.println("�� �������� ��������� ����� id: " + i);
                    return;
                }
            }
            Thread.sleep(3000);
        }
    }
}
