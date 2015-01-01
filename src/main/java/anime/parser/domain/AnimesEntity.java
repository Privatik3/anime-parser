package anime.parser.domain;

import javax.persistence.*;

@Entity
@Table(name = "animes", schema = "", catalog = "my_db")
public class AnimesEntity {

    private int id;
    private String mainImg;
    private String mainTitle;
    private String review;
    private Double average;
    private Integer ranced;
    private Integer voted;
    private String typeInfo;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "main_img", nullable = true, insertable = true, updatable = true, length = 255)
    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    @Basic
    @Column(name = "main_title", nullable = false, insertable = true, updatable = true, length = 255)
    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    @Basic
    @Column(name = "review", nullable = true, insertable = true, updatable = true, length = 16777215)
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Basic
    @Column(name = "average", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    @Basic
    @Column(name = "ranced", nullable = true, insertable = true, updatable = true)
    public Integer getRanced() {
        return ranced;
    }

    public void setRanced(Integer ranced) {
        this.ranced = ranced;
    }

    @Basic
    @Column(name = "voted", nullable = true, insertable = true, updatable = true)
    public Integer getVoted() {
        return voted;
    }

    public void setVoted(Integer voted) {
        this.voted = voted;
    }

    @Basic
    @Column(name = "type_info", nullable = false, insertable = true, updatable = true, length = 45)
    public String getTypeInfo() {
        return typeInfo;
    }

    public void setTypeInfo(String typeInfo) {
        this.typeInfo = typeInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimesEntity that = (AnimesEntity) o;

        if (id != that.id) return false;
        if (average != null ? !average.equals(that.average) : that.average != null) return false;
        if (mainImg != null ? !mainImg.equals(that.mainImg) : that.mainImg != null) return false;
        if (mainTitle != null ? !mainTitle.equals(that.mainTitle) : that.mainTitle != null) return false;
        if (ranced != null ? !ranced.equals(that.ranced) : that.ranced != null) return false;
        if (review != null ? !review.equals(that.review) : that.review != null) return false;
        if (typeInfo != null ? !typeInfo.equals(that.typeInfo) : that.typeInfo != null) return false;
        if (voted != null ? !voted.equals(that.voted) : that.voted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mainImg != null ? mainImg.hashCode() : 0);
        result = 31 * result + (mainTitle != null ? mainTitle.hashCode() : 0);
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + (average != null ? average.hashCode() : 0);
        result = 31 * result + (ranced != null ? ranced.hashCode() : 0);
        result = 31 * result + (voted != null ? voted.hashCode() : 0);
        result = 31 * result + (typeInfo != null ? typeInfo.hashCode() : 0);
        return result;
    }
}
