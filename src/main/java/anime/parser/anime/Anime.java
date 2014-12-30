package anime.parser.anime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Anime {

    private final int ID;
    private String mainImg;
    private String mainTitle;
    private List<String> otherTitles;
    private String production_text;
    private AnimeProduction production;
    private List<AnimeGenres> genres;
    private String type_text;
    private AnimeType type;
    private Date year;
    private double worldArtAverage;
    private int worldArtVoted;
    private int worldArtRanced;
    private String review;
    private List<String> screenshots;
    private List<AnimeConnection> connections;

    public String getMainImg() {
        return mainImg;
    }

    public int getID() {
        return ID;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public List<String> getOtherTitles() {
        return otherTitles;
    }

    public AnimeProduction getProduction() {
        return production;
    }

    public List<AnimeGenres> getGenres() {
        return genres;
    }

    public String getType_text() {
        return type_text;
    }

    public AnimeType getType() {
        return type;
    }

    public Date getYear() {
        return year;
    }

    public double getWorldArtAverage() {
        return worldArtAverage;
    }

    public int getWorldArtVoted() {
        return worldArtVoted;
    }

    public int getWorldArtRanced() {
        return worldArtRanced;
    }

    public String getReview() {
        return review;
    }

    public List<String> getScreenshots() {
        return screenshots;
    }

    public List<AnimeConnection> getConnections() {
        return connections;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public void setConnections(List<AnimeConnection> connections) {
        this.connections = connections;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public void setOtherTitles(List<String> otherTitles) {
        this.otherTitles = otherTitles;
    }

    public void setProduction_text(String production_text) {
        this.production_text = production_text;
        this.production = getProductions(production_text);
    }

    public void setGenres(List<String> genres) {
        for (String genre : genres) {
            if (genre.contains("������ ���������")) {
                this.genres.add(AnimeGenres.Martial_Arts);
            } else if (genre.contains("�����")) {
                this.genres.add(AnimeGenres.Military);
            } else if (genre.contains("��������")) {
                this.genres.add(AnimeGenres.Detective);
            } else if (genre.contains("�����")) {
                this.genres.add(AnimeGenres.Drama);
            } else if (genre.contains("������")) {
                this.genres.add(AnimeGenres.Children);
            } else if (genre.contains("�������")) {
                this.genres.add(AnimeGenres.Comedy);
            } else if (genre.contains("����-���")) {
                this.genres.add(AnimeGenres.Magical_girl);
            } else if (genre.contains("����")) {
                this.genres.add(AnimeGenres.Mecha);
            } else if (genre.contains("�������")) {
                this.genres.add(AnimeGenres.Supernatural);
            } else if (genre.contains("�����������")) {
                this.genres.add(AnimeGenres.Music);
            } else if (genre.contains("���������������")) {
                this.genres.add(AnimeGenres.Educational);
            } else if (genre.contains("�������")) {
                this.genres.add(AnimeGenres.Parody);
            } else if (genre.contains("��������������")) {
                this.genres.add(AnimeGenres.Slice_of_Life);
            } else if (genre.contains("�����������")) {
                this.genres.add(AnimeGenres.Adventure);
            } else if (genre.contains("���������")) {
                this.genres.add(AnimeGenres.Romance);
            } else if (genre.contains("����������� ������")) {
                this.genres.add(AnimeGenres.Samurai);
            } else if (genre.contains("���")) {
                this.genres.add(AnimeGenres.Shoujo);
            } else if (genre.contains("���-��")) {
                this.genres.add(AnimeGenres.Shoujo_Ai);
            } else if (genre.contains("����")) {
                this.genres.add(AnimeGenres.Shounen);
            } else if (genre.contains("����-��")) {
                this.genres.add(AnimeGenres.Shounen_Ai);
            } else if (genre.contains("������")) {
                this.genres.add(AnimeGenres.Story);
            } else if (genre.contains("�����")) {
                this.genres.add(AnimeGenres.Sports);
            } else if (genre.contains("�������")) {
                this.genres.add(AnimeGenres.Thriller);
            } else if (genre.contains("�����")) {
                this.genres.add(AnimeGenres.School);
            } else if (genre.contains("����������")) {
                this.genres.add(AnimeGenres.Fiction);
            } else if (genre.contains("�������")) {
                this.genres.add(AnimeGenres.Fantasy);
            } else if (genre.contains("�������")) {
                this.genres.add(AnimeGenres.Erotica);
            } else if (genre.contains("����")) {
                this.genres.add(AnimeGenres.Ecchi);
            } else if (genre.contains("�����")) {
                this.genres.add(AnimeGenres.Horror);
            } else if (genre.contains("������")) {
                this.genres.add(AnimeGenres.Hentai);
            } else if (genre.contains("���")) {
                this.genres.add(AnimeGenres.Yuri);
            } else if (genre.contains("���")) {
                this.genres.add(AnimeGenres.Yaoi);
            }
        }
    }

    public void setType_text(String type_text) {
        this.type_text = type_text;
        type = getTypes(type_text);
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public void setWorldArtAverage(double worldArtAverage) {
        this.worldArtAverage = worldArtAverage;
    }

    public void setWorldArtVoted(int worldArtVoted) {
        this.worldArtVoted = worldArtVoted;
    }

    public void setWorldArtRanced(int worldArtRanced) {
        this.worldArtRanced = worldArtRanced;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setScreenshots(List<String> screenshots) {
        this.screenshots = screenshots;
    }

    public Anime(int id) {
        ID = id;
        genres = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ID: ").append(ID).append("\n");
        sb.append("Main title:\n");
        sb.append("     ").append(mainTitle).append("\n");
        sb.append("Other titles:\n");

        for (String title : otherTitles) {
            sb.append("     ").append(title).append("\n");
        }

        sb.append("Info:\n");
        sb.append("     ").append("������������: ").append(production_text).append("\n");

        sb.append("     ").append("����: ");
        for (AnimeGenres genre: genres) {
            sb.append(genre).append(" ");
        }
        sb.append("\n");
        sb.append("     ").append("���: ").append(type_text).append("\n");
        sb.append("     ").append("��������: ").append(new SimpleDateFormat("dd/M/yyyy").format(year)).append("\n");
        sb.append("     ").append("������� ���: ").append(worldArtAverage).append("\n");
        sb.append("     ").append("����� � ��������: ").append(worldArtRanced).append("\n");
        sb.append("     ").append("�������������: ").append(worldArtVoted).append("\n");

        sb.append("Review:\n");
        sb.append("     ").append(review).append("\n");
        sb.append("Screenshots:\n");
        sb.append("     Screenshot size: ").append(screenshots.size()).append("\n");
        sb.append("Connections:\n");
        for (AnimeConnection connection : connections) {
            sb.append("     ID:").append(connection.getId()).append(" ").append(connection.getText());
            sb.append("\n");
        }
        sb.append("-----------------------------------------------------------------------------------");

        return sb.toString();
    }

    private AnimeType getTypes(String type_text) {
        if (type_text.contains("��")) {
            return AnimeType.TV;
        } else if (type_text.contains("��-�����")) {
            return AnimeType.TV_Special;
        } else if (type_text.contains("OVA")) {
            return AnimeType.OVA;
        } else if (type_text.contains("ONA")) {
            return AnimeType.ONA;
        } else if (type_text.contains("�������������� �����")) {
            return AnimeType.Movie;
        } else if (type_text.contains("���������������� �����")) {
            return AnimeType.Movie;
        } else if (type_text.contains("����������� �����")) {
            return AnimeType.Music_Video;
        } else if (type_text.contains("��������� �����") || type_text.contains("���������������� ����")) {
            return AnimeType.Special;
        }
        return null;
    }

    private AnimeProduction getProductions(String Production_text) {
        if (Production_text.contains("������")) {
            return AnimeProduction.Japan;
        }
        return null;
    }
}
