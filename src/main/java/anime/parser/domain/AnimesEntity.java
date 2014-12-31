package anime.parser.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "animes", schema = "", catalog = "mydb")
public class AnimesEntity {

    private int id;
    private String mainImg;
    private String mainTitle;
    private int animeTypeId;
    private String review;
    private Double average;
    private Integer ranced;
    private Integer voted;
    private int studioId;
    private int directedId;
    private int yearProductionId;
    private int otherTitleId;
    private String typeInfo;
    private Collection<AnimeGenreEntity> animeGenresById;
    private Collection<AnimeResourcesEntity> animeResourcesesById;
    private DirectedEntity directedByDirectedId;
    private SecondNameEntity secondNameByOtherTitleId;
    private StudioEntity studioByStudioId;
    private AnimeTypesEntity animeTypesByAnimeTypeId;
    private YearProductionEntity yearProductionByYearProductionId;
    private Collection<ConnectionsEntity> connectionsesById;
    private Collection<ScreenshotsEntity> screenshotsesById;

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
    @Column(name = "anime_type_id", nullable = false, insertable = true, updatable = true)
    public int getAnimeTypeId() {
        return animeTypeId;
    }

    public void setAnimeTypeId(int animeTypeId) {
        this.animeTypeId = animeTypeId;
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
    @Column(name = "studio_id", nullable = false, insertable = true, updatable = true)
    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    @Basic
    @Column(name = "directed_id", nullable = false, insertable = true, updatable = true)
    public int getDirectedId() {
        return directedId;
    }

    public void setDirectedId(int directedId) {
        this.directedId = directedId;
    }

    @Basic
    @Column(name = "year_production_id", nullable = false, insertable = true, updatable = true)
    public int getYearProductionId() {
        return yearProductionId;
    }

    public void setYearProductionId(int yearProductionId) {
        this.yearProductionId = yearProductionId;
    }

    @Basic
    @Column(name = "other_title_id", nullable = false, insertable = true, updatable = true)
    public int getOtherTitleId() {
        return otherTitleId;
    }

    public void setOtherTitleId(int otherTitleId) {
        this.otherTitleId = otherTitleId;
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

        if (animeTypeId != that.animeTypeId) return false;
        if (directedId != that.directedId) return false;
        if (id != that.id) return false;
        if (otherTitleId != that.otherTitleId) return false;
        if (studioId != that.studioId) return false;
        if (yearProductionId != that.yearProductionId) return false;
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
        result = 31 * result + animeTypeId;
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + (average != null ? average.hashCode() : 0);
        result = 31 * result + (ranced != null ? ranced.hashCode() : 0);
        result = 31 * result + (voted != null ? voted.hashCode() : 0);
        result = 31 * result + studioId;
        result = 31 * result + directedId;
        result = 31 * result + yearProductionId;
        result = 31 * result + otherTitleId;
        result = 31 * result + (typeInfo != null ? typeInfo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "animesByAnimesId")
    public Collection<AnimeGenreEntity> getAnimeGenresById() {
        return animeGenresById;
    }

    public void setAnimeGenresById(Collection<AnimeGenreEntity> animeGenresById) {
        this.animeGenresById = animeGenresById;
    }

    @OneToMany(mappedBy = "animesByAnimesId")
    public Collection<AnimeResourcesEntity> getAnimeResourcesesById() {
        return animeResourcesesById;
    }

    public void setAnimeResourcesesById(Collection<AnimeResourcesEntity> animeResourcesesById) {
        this.animeResourcesesById = animeResourcesesById;
    }

    @ManyToOne
    @JoinColumn(name = "directed_id", referencedColumnName = "id", nullable = false)
    public DirectedEntity getDirectedByDirectedId() {
        return directedByDirectedId;
    }

    public void setDirectedByDirectedId(DirectedEntity directedByDirectedId) {
        this.directedByDirectedId = directedByDirectedId;
    }

    @ManyToOne
    @JoinColumn(name = "other_title_id", referencedColumnName = "id", nullable = false)
    public SecondNameEntity getSecondNameByOtherTitleId() {
        return secondNameByOtherTitleId;
    }

    public void setSecondNameByOtherTitleId(SecondNameEntity secondNameByOtherTitleId) {
        this.secondNameByOtherTitleId = secondNameByOtherTitleId;
    }

    @ManyToOne
    @JoinColumn(name = "studio_id", referencedColumnName = "id", nullable = false)
    public StudioEntity getStudioByStudioId() {
        return studioByStudioId;
    }

    public void setStudioByStudioId(StudioEntity studioByStudioId) {
        this.studioByStudioId = studioByStudioId;
    }

    @ManyToOne
    @JoinColumn(name = "anime_type_id", referencedColumnName = "id", nullable = false)
    public AnimeTypesEntity getAnimeTypesByAnimeTypeId() {
        return animeTypesByAnimeTypeId;
    }

    public void setAnimeTypesByAnimeTypeId(AnimeTypesEntity animeTypesByAnimeTypeId) {
        this.animeTypesByAnimeTypeId = animeTypesByAnimeTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "year_production_id", referencedColumnName = "id", nullable = false)
    public YearProductionEntity getYearProductionByYearProductionId() {
        return yearProductionByYearProductionId;
    }

    public void setYearProductionByYearProductionId(YearProductionEntity yearProductionByYearProductionId) {
        this.yearProductionByYearProductionId = yearProductionByYearProductionId;
    }

    @OneToMany(mappedBy = "animesByAnimesId")
    public Collection<ConnectionsEntity> getConnectionsesById() {
        return connectionsesById;
    }

    public void setConnectionsesById(Collection<ConnectionsEntity> connectionsesById) {
        this.connectionsesById = connectionsesById;
    }

    @OneToMany(mappedBy = "animesByAnimesId")
    public Collection<ScreenshotsEntity> getScreenshotsesById() {
        return screenshotsesById;
    }

    public void setScreenshotsesById(Collection<ScreenshotsEntity> screenshotsesById) {
        this.screenshotsesById = screenshotsesById;
    }
}
