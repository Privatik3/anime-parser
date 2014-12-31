package anime.parser.parser;

public class LogicParser {

    /*public static Anime parseAnime(String anime_id) {

        Anime anime = new Anime(Integer.parseInt(anime_id));
        Document docAnime = null, docPhoto = null;

        int countLoad = 0;
        while (countLoad < 5) {
            try {
                docAnime = Jsoup.connect("http://www.world-art.ru/animation/animation.php?id=" + anime_id).get();
                Thread.sleep(1000);
                docPhoto = Jsoup.connect("http://www.world-art.ru/animation/animation_photos.php?id=" + anime_id).get();
                Thread.sleep(1000);
                countLoad = 5;
            } catch (IOException | InterruptedException e) {
                if (countLoad == 4) {
                    System.err.println("�� ������� �������� ��������:");
                    e.printStackTrace();
                    return null;
                }
                countLoad++;
            }
        }

        try {
            anime.setMainTitle(WorldArtParser.parseTitle(docAnime));
            anime.setOtherTitles(WorldArtParser.parseOtherTitle(docAnime));
            anime.setMainImg(WorldArtParser.parseTitleImg(docAnime));

            String[] info = WorldArtParser.parseInfo(docAnime);

            anime.setProduction_text(info[0].substring(15));
            anime.setGenres(Arrays.asList(info[1].substring(6).split(",")));
            anime.setType_text(info[2].substring(5));

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String dateInString = info[3].substring(10, 20);
            Date date = dateFormat.parse(dateInString);
            anime.setYear(date);

            if (info[4] != null)
                anime.setWorldArtAverage(Double.parseDouble(info[4].substring(14, info[4].length() - 6)));
            if (info[5] != null)
                anime.setWorldArtRanced(Integer.parseInt(info[5].substring(18, info[5].indexOf("��") - 1)));
            if (info[6] != null)
                anime.setWorldArtVoted(Integer.parseInt(info[6].substring(15, info[6].length() - 17)));

            anime.setReview(WorldArtParser.parseReview(docAnime));
            anime.setScreenshots(WorldArtParser.parseScreenshots(docPhoto));
            anime.setConnections(WorldArtParser.parseConnections(docAnime));

        } catch (Exception e) {
            System.err.println("������ � ���� ��������:");
            e.printStackTrace();
            return null;
        }

        return anime;
    } */
}
