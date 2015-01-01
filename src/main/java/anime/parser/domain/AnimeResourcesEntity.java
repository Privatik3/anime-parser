package anime.parser.domain;

import javax.persistence.*;

@Entity
@Table(name = "anime_resources", schema = "", catalog = "my_db")
public class AnimeResourcesEntity {

    private int id;
    private String url;
    private AnimesEntity animesByAnimesId;
    private ResourcesNameEntity resourcesNameByResourcesNameId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url", nullable = true, insertable = true, updatable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimeResourcesEntity that = (AnimeResourcesEntity) o;

        if (id != that.id) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "animes_id", referencedColumnName = "id", nullable = false)
    public AnimesEntity getAnimesByAnimesId() {
        return animesByAnimesId;
    }

    public void setAnimesByAnimesId(AnimesEntity animesByAnimesId) {
        this.animesByAnimesId = animesByAnimesId;
    }

    @ManyToOne
    @JoinColumn(name = "resources_name_id", referencedColumnName = "id", nullable = false)
    public ResourcesNameEntity getResourcesNameByResourcesNameId() {
        return resourcesNameByResourcesNameId;
    }

    public void setResourcesNameByResourcesNameId(ResourcesNameEntity resourcesNameByResourcesNameId) {
        this.resourcesNameByResourcesNameId = resourcesNameByResourcesNameId;
    }
}
