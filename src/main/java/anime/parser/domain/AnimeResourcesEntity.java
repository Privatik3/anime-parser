package anime.parser.domain;

import javax.persistence.*;

@Entity
@Table(name = "anime_resources", schema = "", catalog = "my_db")
public class AnimeResourcesEntity {

    private int id;
    private int animesId;
    private int resourcesNameId;
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
    @Column(name = "animes_id", nullable = false, insertable = true, updatable = true)
    public int getAnimesId() {
        return animesId;
    }

    public void setAnimesId(int animesId) {
        this.animesId = animesId;
    }

    @Basic
    @Column(name = "resources_name_id", nullable = false, insertable = true, updatable = true)
    public int getResourcesNameId() {
        return resourcesNameId;
    }

    public void setResourcesNameId(int resourcesNameId) {
        this.resourcesNameId = resourcesNameId;
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

        if (animesId != that.animesId) return false;
        if (id != that.id) return false;
        if (resourcesNameId != that.resourcesNameId) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + animesId;
        result = 31 * result + resourcesNameId;
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
