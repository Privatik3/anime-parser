package anime.parser.parser;

public class AnimeInfo {

    private String mainImg;
    private String mainTitle;
    private String review;
    private Double average;
    private Integer ranced;
    private Integer voted;
    private String typeInfo;

    public String getMainImg() {
        return mainImg;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public String getReview() {
        return review;
    }

    public Double getAverage() {
        return average;
    }

    public Integer getRanced() {
        return ranced;
    }

    public Integer getVoted() {
        return voted;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public void setRanced(Integer ranced) {
        this.ranced = ranced;
    }

    public void setVoted(Integer voted) {
        this.voted = voted;
    }

    public void setTypeInfo(String typeInfo) {
        this.typeInfo = typeInfo;
    }
}
